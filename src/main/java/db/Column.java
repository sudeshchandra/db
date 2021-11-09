package db;


public class Column {
    String name;
    Type type;
    boolean required;

    public Column(String name, Type type, boolean required) {
        this.name = name;
        this.type = type;
        this.required = required;
    }
}
