package common;

import java.io.Serializable;

public class ChatMember implements Serializable {

    private static final Long serialVersionUID = 123L;

    private String name;
    private String message;

    public ChatMember(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Chat{name='%s', message='%s'}", name, message);
    }
}
