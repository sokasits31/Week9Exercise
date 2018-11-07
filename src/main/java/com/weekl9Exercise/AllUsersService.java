package com.weekl9Exercise;

import com.week9Exercise.entity.User;
import com.week9Exercise.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/allUsers")
public class AllUsersService {
    // The Java method will process HTTP GET requests
    @GET ()
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getAllUsers() {
        // Return a simple message
        GenericDao genericDao = new GenericDao(User.class);

        String allUsers = null;
        List<User> users = genericDao.getAll();

        for(User user:users) {
            allUsers = allUsers + user.toString();
        }

        return Response.status(200).entity(allUsers).build();
    }

}


