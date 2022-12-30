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

    // Atributo para armazenar o id do usuário logado
    private int id;
    
    public boolean login(String email, String senha) {

        /* Método de Login - São passados o email e a senha como parametros para verificar se há
         * um usuário com esses dados no banco de dados. Caso haja, o método retorna true e
         * o usuário é logado. Caso contrário, retorna false e o usuário não é logado.
         */

        boolean logado = false;
        Usuario usuario = null;

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        // String com o comando SQL buscar um usuário por email e senha
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // Setar os valores do comando SQL
            pstm.setString(1, email);
            pstm.setString(2, senha);
            // Executar o comando SQL e pegar os resultados da consulta
            rs = pstm.executeQuery();
            // Como é esperado apenas um resultado, o cursor é movido para o primeiro registro
            rs.first();
            // Pegar os dados do usuário
            int id = rs.getInt("id");
            this.id = id;
            String nome = rs.getString("nome");
            String email2 = rs.getString("email");
            String senha2 = rs.getString("senha");
            boolean administrador = rs.getBoolean("administrador");
            // Criar um objeto do tipo Usuario com os dados pegos do banco de dados
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

        // Se o usuário não for nulo, significa que ele foi encontrado no banco de dados
        if (usuario != null) {
            logado = true;
        }

        // Retornar o valor da variável logado
        return logado;
    }

    public Usuario consultarPorId(int id){

        Usuario usuario = null;

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        // String com o comando SQL buscar um usuário por id
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // Setar os valores do comando SQL
            pstm.setInt(1, id);
            // Executar o comando SQL e pegar os resultados da consulta
            rs = pstm.executeQuery();
            // Como é esperado apenas um resultado, o cursor é movido para o primeiro registro
            rs.first();
            // Pegar os dados do usuário
            int id2 = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            boolean administrador = rs.getBoolean("administrador");
            // Criar um objeto do tipo Usuario com os dados pegos do banco de dados
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
        // Retornar o usuário
        return usuario;
    }

    public void cadastrarUsuario(Usuario usuario) {

        Connection con = null;
        PreparedStatement pstm = null;
        // String com o comando SQL para cadastrar um usuário
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Setar os valores do comando SQL
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            // Executar o comando SQL
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

        /*Só brinque. Agora brinque. Esse método ficou muito bom */

        /*Esse meétodo tem dois comandos sql, o primeiro retorna o id dos  
         * jogos de um usuario e o segundo retorna os dados do jogo com base no id
         */

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        /*1 - Comando que SQL que retorna os ids dos jogos de um usuario */
        String sql = "SELECT id_jogo FROM jogos_usuarios WHERE id_usuario = ?";
        /*2 - Comando que o resultado do camando anterior */
        String sql2 = "SELECT * FROM jogos WHERE id = ?";
        ArrayList<Jogo> jogos = new ArrayList<Jogo>();

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Setar os valores do primerio comando SQL
            pstm.setInt(1, idUsuario);
            //Executar o comando SQL e pegar os resultados da consulta
            rs = pstm.executeQuery();

            // Enquanto houver jogos para o usuário no resultado da consulta
            while (rs.next()) {

                int idJogo = rs.getInt("id_jogo");
                pstm = con.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                // Setar os valores do segundo comando SQL
                pstm.setInt(1, idJogo);
                // Executar o primeiro comando SQL e pegar os resultados da consulta
                ResultSet rs2 = pstm.executeQuery();

                // Como é esperado apenas um resultado, o cursor é movido para o primeiro registro
                rs2.first();
                // Pegar os dados do jogo
                int id = rs2.getInt("id");
                String nome = rs2.getString("nome");
                String genero = rs2.getString("genero");
                String desenvolvedora = rs2.getString("desenvolvedora");
                String distribuidora = rs2.getString("distribuidora");
                double preco = rs2.getDouble("preco");
                double desconto = rs2.getDouble("desconto");
                int classificacao = rs2.getInt("classificacao");
                // Criar um objeto do tipo Jogo com os dados pegos do banco de dados
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
        // Retornar jogos do usuário
        return jogos;
    }

    public ArrayList<Usuario> listarUsuarios() {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        // String com o comando SQL para listar todos os usuários
        String sql = "SELECT * FROM usuarios";
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Executar o comando SQL e pegar os resultados da consulta
            rs = pstm.executeQuery();

            // Enquanto houver usuários no banco de dados
            while (rs.next()) {
                // Pegar os dados do usuário
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                boolean adm = rs.getBoolean("administrador");
                ArrayList<Jogo> biblioteca = listarJogosDoUsuario(id);
                // Criar um objeto usuário
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
        /// String com o comando SQL para atualizar um usuário
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Passar os parâmetros para o comando SQL
            pstm.setString(1, nome);
            pstm.setString(2, email);
            pstm.setInt(3, id);
            // Executar o comando SQL
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
        // String com o comando SQL para os jogos de um usuario, assim não vai dar erro de chave estrangeira
        String sql = "DELETE FROM jogos_usuarios WHERE id_usuario = ?";

        PreparedStatement pstm2 = null;
        /*String com o comando SQL para excluir um usuário
        */
        String sql2 = "DELETE FROM usuarios WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Setar os valores para o comando SQL
            pstm.setInt(1, id);
            // Executar o primeiro comando SQL
            pstm.execute();

            pstm2 = con.prepareStatement(sql2);
            // Setar os valores para o segundo comando SQL
            pstm2.setInt(1, id);
            // Executar o segundo comando SQL
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

    // Métodos para o id do usuário
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
