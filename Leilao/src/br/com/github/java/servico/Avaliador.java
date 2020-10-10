package br.com.github.java.servico;

import br.com.github.java.dominio.Lance;
import br.com.github.java.dominio.Leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

    private double maiorDetodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;

    public void avalia(Leilao leilao) {
        leilao.getLances().forEach(lance -> {
            if (lance.getValor() > maiorDetodos) {
                maiorDetodos = lance.getValor();
            }
            if ( lance.getValor() < menorDeTodos )   {
                menorDeTodos = lance.getValor();
            }
        });

        maiores = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>() {
            @Override
            public int compare(Lance lance1, Lance lance2) {
                if(lance1.getValor() < lance2.getValor()  ) return 1;
                if(lance1.getValor() > lance2.getValor()  ) return -1;
                return 0;
            }
        } );

        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());

    }

    public List<Lance> getTresMaiores() {
        return maiores;
    }

    public double getMaiorLance() {
        return maiorDetodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }
}
