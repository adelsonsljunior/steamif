package com.steamif.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.steamif.conexao.Conexao;
import com.steamif.models.Jogo;

public class JogoDAO {

    public void cadastrar(Jogo jogo) {

        // Conexão com o banco de dados
        Connection con = null;
        PreparedStatement pstm = null;
        // String com o comando SQL para inserir os dados de jogos
        String sql = "INSERT INTO jogos (nome, preco, desconto, desenvolvedora, distribuidora, classificacao) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Setar os valores do comando SQL
            pstm.setString(1, jogo.getNome());
            pstm.setDouble(3, jogo.getPreco());
            pstm.setDouble(4, jogo.getDesconto());
            pstm.setString(5, jogo.getDesenvolvedora());
            pstm.setString(6, jogo.getDistribuidora());
            // Executar o comando SQL
            pstm.execute();

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

    public ArrayList<Jogo> listarJogos() {

        // Conexão com o banco de dados

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Jogo> jogos = new ArrayList<Jogo>();

        // String com o comando SQL para consultar todos os jogos

        String sql = "SELECT * FROM jogos";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Executar o comando SQL
            rs = pstm.executeQuery();

            // Enquanto houver registros, adicionar na lista
            while (rs.next()) {

                // Criar um objeto do tipo Jogo

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                double desconto = rs.getDouble("desconto");
                String desenvolvedora = rs.getString("desenvolvedora");
                String distribuidora = rs.getString("distribuidora");
                String genero = rs.getString("genero");
                int classificacao = rs.getInt("classificacao");

                Jogo jogo = new Jogo(id, desconto, preco, nome, desenvolvedora, distribuidora, genero, classificacao);
                jogos.add(jogo);
            }

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

        // Retornar a lista de jogos

        return jogos;
    }

    public void atualizarJogo(Jogo jogo) {

        Connection con = null;
        PreparedStatement pstm = null;
        // String com o comando SQL para atualizar os dados de jogos
        String sql = "UPDATE jogos SET nome = ?, nome = ?, preco = ?, desconto = ?, desenvolvedora = ?, distribuidora = ?, classificacao = ? WHERE id = ?";

        try {

            // Conexão com o banco de dados
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);

            // Setar os valores do comando SQL
            pstm.setString(1, jogo.getNome());
            pstm.setString(2, jogo.getNome());
            pstm.setDouble(3, jogo.getPreco());
            pstm.setDouble(4, jogo.getDesconto());
            pstm.setString(5, jogo.getDesenvolvedora());
            pstm.setString(6, jogo.getDistribuidora());
            pstm.setInt(7, jogo.getClassificacao());
            pstm.setInt(8, jogo.getId());
            // Executar o comando SQL
            pstm.execute();

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

    public void excluirJogo(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        // String com o comando SQL para excluir os dados de jogos por id
        String sql = "DELETE FROM jogos WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Setar os valores do comando SQL
            pstm.setInt(1, id);
            // Executar o comando SQL
            pstm.execute();

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

    public void comprar(int idUsuario, int idJogo) {

        Connection con = null;
        PreparedStatement pstm = null;
        // String com o comando SQL para conexao de jogos e usuarios
        String sql = "INSERT INTO jogos_usuarios (id_usuario, id_jogo) VALUES (?, ?)";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            // Setar os valores do comando SQL
            pstm.setInt(1, idUsuario);
            pstm.setInt(2, idJogo);
            // Executar o comando SQL
            pstm.execute();

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

}