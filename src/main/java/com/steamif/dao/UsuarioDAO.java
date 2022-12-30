package com.steamif.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.steamif.conexao.Conexao;
import com.steamif.models.Usuario;
import com.steamif.models.Jogo;

public class UsuarioDAO {

    private int id;
    
    public boolean login(String email, String senha) {

        boolean logado = false;
        Usuario usuario = null;

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstm.setString(1, email);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();

            rs.first();
            int id = rs.getInt("id");
            this.id = id;
            String nome = rs.getString("nome");
            String email2 = rs.getString("email");
            String senha2 = rs.getString("senha");
            boolean administrador = rs.getBoolean("administrador");
            usuario = new Usuario(id, nome, email2, senha2, administrador, new ArrayList<>());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Fechar as conexões
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (usuario != null) {
            logado = true;
        }

        return logado;
    }

    public Usuario consultarPorId(int id){

        Usuario usuario = null;

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            rs.first();
            int id2 = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            boolean administrador = rs.getBoolean("administrador");
            usuario = new Usuario(id2, nome, email, senha, administrador, new ArrayList<>());

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            // Fechar as conexões
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }

    public void cadastrarUsuario(Usuario usuario) {

        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.execute();

            System.out.println("Usuário cadastrado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Fechar as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Jogo> listarJogosDoUsuario(int idUsuario) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT id_jogo FROM jogos_usuarios WHERE id_usuario = ?";
        String sql2 = "SELECT * FROM jogos WHERE id = ?";
        ArrayList<Jogo> jogos = new ArrayList<Jogo>();

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idUsuario);
            rs = pstm.executeQuery();

            while (rs.next()) {

                int idJogo = rs.getInt("id_jogo");
                pstm = con.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pstm.setInt(1, idJogo);
                ResultSet rs2 = pstm.executeQuery();
                rs2.first();
                int id = rs2.getInt("id");
                String nome = rs2.getString("nome");
                String genero = rs2.getString("genero");
                String desenvolvedora = rs2.getString("desenvolvedora");
                String distribuidora = rs2.getString("distribuidora");
                double preco = rs2.getDouble("preco");
                double desconto = rs2.getDouble("desconto");
                int classificacao = rs2.getInt("classificacao");

                Jogo jogo = new Jogo(id, preco, desconto, nome, desenvolvedora, distribuidora, genero, classificacao);
                jogos.add(jogo);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Fechar as conexões
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return jogos;
    }

    public ArrayList<Usuario> listarUsuarios() {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usuarios";
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                boolean adm = rs.getBoolean("administrador");
                ArrayList<Jogo> biblioteca = listarJogosDoUsuario(id);
                Usuario usuario = new Usuario(id, nome, email, senha, adm, biblioteca);
                usuarios.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Fechar as conexões
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usuarios;
    }

    public void atualizarUsuario(String nome, String email, int id) {

        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setString(2, email);
            pstm.setInt(3, id);
            pstm.execute();

            System.out.println("Usuário alterado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Fechar as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirUsuario(int id) {

        Connection con = null;
        
        PreparedStatement pstm = null;
        String sql = "DELETE FROM jogos_usuarios WHERE id_usuario = ?";

        PreparedStatement pstm2 = null;
        String sql2 = "DELETE FROM usuarios WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

            pstm2 = con.prepareStatement(sql2);
            pstm2.setInt(1, id);
            pstm2.execute();

            System.out.println("Usuário excluído com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // Fechar as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
