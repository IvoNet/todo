package nl.ordina.io;

import nl.ordina.domain.Todo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivo Woltring
 */
public class TodoIO {

    private static final String TODO_FILE = "/Users/ivonet/dev/junk/todo/src/main/resources/todos.txt";

    public List<Todo> read() {
        try (final InputStreamReader in = new InputStreamReader(new FileInputStream(TODO_FILE));
             final BufferedReader br = new BufferedReader(in)) {
            return br.lines()
                     .filter(p -> !p.isEmpty())
                     .map(s -> {
                         final Todo todo = new Todo();
                         todo.setDone(s.startsWith("* "));
                         todo.setTodo(s.replaceAll("^[*-] ", ""));
                         return todo;
                     })
                     .collect(Collectors.toList());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(final List<Todo> todos) {
        if (todos == null) {
            return;
        }

        final String result = todos.stream()
                                   .map(todo -> (todo.isDone() ? "* " : "- ") + todo.getTodo() + "\n")
                                   .reduce((s, s2) -> s + s2)
                                   .orElse("");


        try {
            Files.write(Paths.get(TODO_FILE), result.getBytes());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

    }
}
