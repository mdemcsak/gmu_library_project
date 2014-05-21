package edu.gmu.authorservice;

import edu.gmu.authorservice.dao.AuthorDao;
import edu.gmu.authorservice.dao.InMemoryAuthorDao;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class that runs the server.
 *
 * Once you have started the server, it runs until you shut it down.
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/gmulibrary/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // Create a resource config that scans for JAX-RS resources and providers
        final ResourceConfig rc = new ResourceConfig().packages("edu.gmu.authorservice.web");

        // Create application properties map
        Map<String, Object> props = new HashMap<>();

        // Setup AuthorDao. in this sample we're using an in-memory implementation; for extra
        // credit you can create a JDBC-based implementation. Note also that the in-memory class
        // is not actually implemented; we have defined the outline of it but not the details)
        AuthorDao authorDao = new InMemoryAuthorDao();

        // Set property for authorDao (the resource can then access its configuration properties)
        props.put("authorDao", authorDao);

        // Add the properties to the Jersey ResourceConfig
        rc.addProperties(props);

        // Create and start a new instance of grizzly HTTP server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     *
     * @param args arguments (not used)
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.printf("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...\n", BASE_URI);
        System.in.read();
        server.shutdownNow();
    }
}
