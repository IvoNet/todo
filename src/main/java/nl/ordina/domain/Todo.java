package nl.ordina.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ivo Woltring
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
