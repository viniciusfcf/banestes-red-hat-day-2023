package org.acme;

import java.util.Random;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Random random = new Random();
        // for (int i = 0; i < 10000; i++) {
            
        //     System.out.println(random.nextInt());
        // }
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
