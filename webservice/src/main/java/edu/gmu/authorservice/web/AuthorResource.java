package edu.gmu.authorservice.web;

import edu.gmu.authorservice.dao.AuthorDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/")
public class AuthorResource {

    private static final Logger logger = Logger.getLogger(AuthorResource.class.getName());

    private AuthorDao _authorDao;

    public AuthorResource(@Context Application app) throws Exception {
        _authorDao = (AuthorDao) app.getProperties().get("authorDao");
        logger.info("Using AuthorDao implementation " + _authorDao.getClass().getSimpleName());
    }

    // This is a sample method. You can verify your server is working by
    // opening a browser and navigating to http://localhost:8080/gmulibrary/test
    // You should see the text "This is the result. Success!" in your browser.
    @Path("/test")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        logger.info("Handling test request");
        return "This is the result. Success!";
    }

    // TODO Implement two methods here: one to obtain all authors
    // and a second to obtain an author by id

}
