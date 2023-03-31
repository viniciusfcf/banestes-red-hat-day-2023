package org.acme;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //baixa a cada 5s
        from("sftp://{{username}}@{{host}}:{{port}}/{{directoryName}}?password={{password}}&moveFailed=/foo/error&move=/foo/done&preMove=/foo/in-progress&readLock=changed&streamDownload=true&useUserKnownHostsFile=false")
        
        .log("Arquivo: ${body}")
        .to("file:{{localDirectoryName}}")
        ;

    }
    
}
