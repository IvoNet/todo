package nl.ordina.rest;

import nl.ordina.domain.Todo;
import nl.ordina.io.TodoIO;

import javax.inject.Inject;
import java.util.List;

public class TodoService {

    @Inject private TodoIO todoIO;

    public List<Todo> read() {
        return todoIO.read();
    }

    public void save(List<Todo> todos) {
        todoIO.write(todos);
    }

}
