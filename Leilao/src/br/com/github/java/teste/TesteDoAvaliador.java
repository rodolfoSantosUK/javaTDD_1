package br.com.github.java.teste;

import br.com.github.java.dominio.Lance;
import br.com.github.java.dominio.Leilao;
import br.com.github.java.dominio.Usuario;
import br.com.github.java.servico.Avaliador;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TesteDoAvaliador {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {

        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario jose = new Usuario("Jose");


        Leilao leilao = new Leilao("Play Station 3 novo");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);

    }


    @Test
    public void deveEntenderLancesComApenasUmValor() {

        Usuario joao = new Usuario("Joao");

        Leilao leilao = new Leilao("Play Station 3 novo");

        leilao.propoe(new Lance(joao, 250.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 250;
        double menorEsperado = 250;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);

    }


    @Test
    public void deveEncontrarOsTresMaioresLances() {

        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Play Station 3 novo");

        leilao.propoe(new Lance(joao,  100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao,  300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();
        assertEquals(3, tresMaiores.size());


    }


}
