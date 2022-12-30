package com.steamif.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.steamif.conexao.Conexao;
import com.steamif.models.Jogo;


public class JogoDAO{
            
    public void cadastrar(Jogo jogo){

        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO jogos (nome, preco, desconto, desenvolvedora, distribuidora, classificacao) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, jogo.getNome());
            pstm.setDouble(3, jogo.getPreco());
            pstm.setDouble(4, jogo.getDesconto());
            pstm.setString(5, jogo.getDesenvolvedora());
            pstm.setString(6, jogo.getDistribuidora());
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

    public ArrayList<Jogo> listarJogos(){
            
            Connection con = null;
            PreparedStatement pstm = null;
            ResultSet rs = null;
            ArrayList<Jogo> jogos = new ArrayList<Jogo>();
    
            String sql = "SELECT * FROM jogos";
    
            try {
                con = Conexao.getConnection();
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
    
                while (rs.next()) {
                    
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
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

            return jogos;
    }

    public void atualizarJogo(Jogo jogo){
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "UPDATE jogos SET nome = ?, nome = ?, preco = ?, desconto = ?, desenvolvedora = ?, distribuidora = ?, classificacao = ? WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, jogo.getNome());
            pstm.setString(2, jogo.getNome());
            pstm.setDouble(3, jogo.getPreco());
            pstm.setDouble(4, jogo.getDesconto());
            pstm.setString(5, jogo.getDesenvolvedora());
            pstm.setString(6, jogo.getDistribuidora());
            pstm.setInt(7, jogo.getClassificacao());
            pstm.setInt(8, jogo.getId());
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

    public void excluirJogo(int id){
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "DELETE FROM jogos WHERE id = ?";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
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

    public void comprar(int idUsuario, int idJogo){

        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "INSERT INTO jogos_usuarios (id_usuario, id_jogo) VALUES (?, ?)";

        try {
            con = Conexao.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, idUsuario);
            pstm.setInt(2, idJogo);
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