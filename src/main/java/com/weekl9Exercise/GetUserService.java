package com.weekl9Exercise;

import com.week9Exercise.entity.User;
import com.week9Exercise.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/getUserById")
public class GetUserService {
    // The Java method will process HTTP GET requests
    @GET
    @Path("{id}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/html")
    public Response getUser(@PathParam("id") int id) {
        // Return a simple message
        GenericDao genericDao = new GenericDao(User.class);

        User user = (User) genericDao.getById(id);

        String results = "<H3>" + user.getId() + ":" + user.getEmailAddress() +
                      "... " + user.getFirstName() + " " + user.getLastName() + "</h3>";

        return Response.status(200).entity(results).build();
    }

}


