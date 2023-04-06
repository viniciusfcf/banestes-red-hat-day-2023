package org.acme;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration().bindingMode(RestBindingMode.json);

        rest("/").post().produces("text/plain").to("direct:post");

        from("direct:post")
            .removeHeaders("*")
            .marshal().json(JsonLibrary.Jackson)
            
            .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
            .setHeader("accept", constant("text/plain"))
            .log("MSG ${body}")
            .to("http://{{plataforma-externa.url}}/boletos?httpMethod=post")
            .log("Retorno ${body}")
        ;

    }
    
}
