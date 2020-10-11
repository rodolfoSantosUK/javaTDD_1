package br.com.github.java.teste;

import br.com.github.java.dominio.Lance;
import br.com.github.java.dominio.Leilao;
import br.com.github.java.dominio.Usuario;
import br.com.github.java.servico.Avaliador;
import br.com.github.java.servico.CriadorDeLeilao;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TesteDoAvaliador {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario maria;

    @Before
    private void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        this.joao     =  new Usuario("Joao");
        this.maria    =  new Usuario("Maria");
    }

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {

        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario jose = new Usuario("Jose");

        Leilao leilao = new Leilao("Play Station 3 novo");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

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

        leiloeiro.avalia(leilao);

        double maiorEsperado = 250;
        double menorEsperado = 250;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }


    @Test
    public void deveEncontrarOsTresMaioresLances() {

        Leilao  leilao = new CriadorDeLeilao().para("Playstation 3 novo")
                .lance(joao,  100.0)
                .lance(maria, 200.0)
                .lance(joao,  300.0)
                .lance(maria, 400.0)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();
        assertEquals(3, tresMaiores.size());
    }


}
