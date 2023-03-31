package org.acme;

import java.util.Random;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;


@Path("/boletos")
public class GreetingResource {

    Random random = new Random();

    @Inject
    Logger log;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer hello(Conteudo conteudo) {
        return Math.abs(random.nextInt());
    }
}