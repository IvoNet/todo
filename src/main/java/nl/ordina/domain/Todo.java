package nl.ordina.domain;

public class Todo {
    private boolean done;
    private String todo;

    public boolean isDone() {
        return this.done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    public String getTodo() {
        return this.todo;
    }

    public void setTodo(final String todo) {
        this.todo = todo;
    }
}
