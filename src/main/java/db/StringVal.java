package db;

public class StringVal implements Value<String> {
    String val;

    public StringVal(Object o){
        this.val = String.valueOf(o);
    }

    public String getValue() {
        return val;
    }

    public void setValue(String val) {
        this.val = val;

    }

    @Override
    public String toString() {
        return "StringVal{" +
                "val='" + val + '\'' +
                '}';
    }
}
