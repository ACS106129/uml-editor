package uml.listener.type;

public enum ListenerType {

    Exit("exit"), Group("group"), Ungroup("ungroup"), Rename("rename"), Delete("delete"), Tool("tool");

    private final String name;

    private ListenerType(final String n) {
        name = n;
    }

    @Override
    public String toString() {
        return name;
    }
}
