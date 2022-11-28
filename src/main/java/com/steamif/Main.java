package com.steamif;

import java.sql.Connection;

import com.steamif.conexao.Conexao;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Connection con = Conexao.getConnection();

        if (con != null) {
            System.out.println("Conexao realizada com sucesso");
        } else {
            System.out.println("Problema na conexao");
        }
    }
}
