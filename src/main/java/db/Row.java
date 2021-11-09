package db;

import java.util.Map;

public class Row {
    Map<String, Value> colValues;

    public Row(Map<String, Value> colValues){
        this.colValues = colValues;
    }

    public Map<String, Value> getColValues() {
        return colValues;
    }

    @Override
    public String toString() {
        return "Row{" +
                "colValues=" + colValues +
                '}';
    }
}
