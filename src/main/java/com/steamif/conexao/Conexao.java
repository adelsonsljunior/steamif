package com.steamif.conexao;

/* Criando Conexão com banco de dados Postgres */

import java.sql.*;

public class Conexao {

    public static Connection getConnection() {

        String driver = "org.postgresql.Driver";

        Env env = new Env();

        String url = "jdbc:postgresql://" + env.getHost() + ":" + env.getPorta() + "/" + env.getNomeBanco();

        Connection con = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, env.getUsuario(), env.getSenha());
            return con;

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }

        throw new IllegalArgumentException("Erro ao conectar com banco de dados!");
    }

}
