package org.acme;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:transacoes?groupId=kafkaReader")
        .log("MSG ${body}")
        ;

    }
    
}
