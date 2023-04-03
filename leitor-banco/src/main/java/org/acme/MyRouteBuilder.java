package org.acme;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("sql:select * from public.transacao where processado is false?outputType=StreamList")
        .split(body()).streaming()
            .setHeader("id", simple("${body[id]}"))
            .marshal().json(JsonLibrary.Jackson)
            .log("Transacao ${body}")
            .to("kafka:transacoes")
            .to("sql: update public.transacao t set processado = true where t.id = :#id")
        ;

    }
    
}
