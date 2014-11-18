package nl.ordina.rest;

import nl.ordina.domain.Todo;
import nl.ordina.io.TodoIO;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

/**
 * @author Ivo Woltring
 */
@Path("/todos")
public class TodoService {

    @Inject TodoIO readerWriter;

    @GET
    @Produces({APPLICATION_JSON, APPLICATION_XML})
    public List<Todo> getTodos() {
        return this.readerWriter.read();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public List<Todo> writeTodos(final List<Todo> todos) {
        this.readerWriter.write(todos);
        return todos;
    }
}
