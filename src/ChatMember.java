import java.io.Serializable;

public class ChatMember implements Serializable {

    private static final Long serialVersionUID = 123L;

    private String name;

    public ChatMember(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Chat{name='%s'}", name);
    }
}
