package org.acme;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
        log.infof("MSG %s", conteudo);

        try {
            int minSleep = 200;
            int maxSleep = 500;
            int sleepTime = ThreadLocalRandom.current().nextInt(minSleep, maxSleep + 1);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Math.abs(random.nextInt());
    }
}