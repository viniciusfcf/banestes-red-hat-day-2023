package org.acme;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LineProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String entrada = (String) exchange.getIn().getBody();
        // nome tem 20 posicoes
        // valor tem 9 posicoes
        String nome = entrada.substring(0, 20);
        String valor = entrada.substring(20);
        Map<String, String> mapa = Map.of("nome", nome, "valor", valor);

        exchange.getIn().setBody(mapa);
    }

}
