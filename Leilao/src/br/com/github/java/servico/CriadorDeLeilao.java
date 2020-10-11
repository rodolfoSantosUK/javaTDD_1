package br.com.github.java.servico;

import br.com.github.java.dominio.Lance;
import br.com.github.java.dominio.Leilao;
import br.com.github.java.dominio.Usuario;

public class CriadorDeLeilao {

    private Leilao leilao;

    public CriadorDeLeilao para(String descricao) {
        this.leilao = new Leilao(descricao);
        return this;
    }

    public CriadorDeLeilao lance(Usuario usuario, double valor) {
        leilao.propoe(new Lance(usuario, valor));
        return this;
    }

     public Leilao constroi() {
        return leilao;
     }
}
