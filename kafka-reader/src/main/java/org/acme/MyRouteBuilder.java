package org.acme;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:transacoes?groupId=geradorBoletos")
        .log("MSG ${body}")
        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
        .setHeader("accept", constant("text/plain"))
        .log("MSG ${body}")
        .to("http://localhost:8083/boletos?httpMethod=post")
        .log("MSG ${body}")
        ;

    }
    
}
