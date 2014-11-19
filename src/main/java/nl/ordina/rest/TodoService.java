package nl.ordina.rest;

import nl.ordina.domain.Todo;
import nl.ordina.io.TodoIO;

import javax.inject.Inject;
import java.util.List;

/**
 * This demos the basics of how little code you need to get up and running.
 */

public class TodoService {

    @Inject private TodoIO todoIO;

    public List<Todo> read() {
        return todoIO.read();
    }

    public void save(List<Todo> todos) {
        todoIO.write(todos);
    }

}
