package org.acme;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:transacoes?groupId={{consumer-group}}")
            .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
            .setHeader("accept", constant("text/plain"))
            // .log("MSG ${body}")
            .to("http://{{plataforma-externa.url}}/boletos?httpMethod=post")
            // .log("Retorno ${body}")
        ;

    }
    
}
