package db;

public class IntegerVal implements Value<Integer> {
    Integer val;

    public IntegerVal(Object o){
        this.val = Integer.valueOf(o.toString());
    }
    public Integer getValue() {
        return val;
    }

    public void setValue(Integer val) {
        this.val = val;

    }

    @Override
    public String toString() {
        return "StringVal{" +
                "val='" + val + '\'' +
                '}';
    }
}
