package org.acme;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://{{input-dir}}?delete=true")
        .log("File ${header.CamelFileName} at ${header.CamelFileLastModified}")
        // .setBody(simple("insert into transacao values('${body[ID]}','${body[NAME]}')"))
        .setBody(simple("insert into public.transacao(nome, valor, processado)  values('nome', 1, false);"))
        .to("jdbc:default?resetAutoCommit=false")
        .log("AE")
        ;

    }
    
}
