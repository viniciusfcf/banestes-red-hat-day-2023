package org.acme;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://{{input-dir}}?delete=true")
        .log("File ${header.CamelFileName} at ${header.CamelFileLastModified}")
        .split(body().tokenize("\n")).streaming()
        // .log("${body}")
        .process(new LineProcessor())
        // .log("${body}")
        // .setBody(simple("insert into transacao values('${body[ID]}','${body[NAME]}')"))
        .setBody(simple("insert into public.transacao(nome, valor, processado)  values('${body[nome]}', '${body[valor]}', false);"))
        .to("jdbc:default?resetAutoCommit=false")
        ;

    }
    
}
