package com.steamif.conexao;

/* Obtendo variáveis de ambiente */

import io.github.cdimascio.dotenv.Dotenv;

public final class Env {

    private String porta, host, nomeBanco, usuario, senha;

    public Env() {
        Dotenv dotenv = Dotenv.configure().load();
        this.porta = dotenv.get("PG_PORT");
        this.host = dotenv.get("PG_HOST");
        this.nomeBanco = dotenv.get("PG_DB_NAME");
        this.usuario = dotenv.get("PG_USER");
        this.senha = dotenv.get("PG_PASSWORD");
    }

    public String getPorta() {
        return porta;
    }

    public String getHost() {
        return host;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

}
