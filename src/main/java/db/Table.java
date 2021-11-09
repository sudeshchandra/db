package db;

import java.util.*;
import java.util.stream.Collectors;

public class Table {
    String name;
    List<Row> rows;
    Column[] cols;

    public Table(String name, Column[] cols){
        this.name = name;
        this.rows = new ArrayList<Row>();
        this.cols = cols;
    }

    public boolean insert(Object... values){
        //Todo : add optional checks
        if(values.length != cols.length){
            System.out.println("required cols are not present");
            return false;
        }
        Map<String, Value> colValMap = new HashMap<String, Value>();

        if(!validateSchema(values)){
            System.out.println("Schema Validation failed");
            return false;
        }

        for(int i= 0; i<values.length; i++){
            //TODO : validate schema
            Value val = null;

            if(cols[i].type == Type.STRING){
                val = new StringVal(values[i]);
            }

            if(cols[i].type == Type.INTEGER){
                val = new IntegerVal(values[i]);
            }

            colValMap.put(cols[i].name, val);
        }

        Row row = new Row(colValMap);

        this.rows.add(row);

        return true;

    }

    public Table filter(String op, final String columnName, final Object value){

        List<Row> filteredRows =  rows.stream().filter(r -> r.getColValues().get(columnName).getValue().equals(value)).collect(Collectors.toList());

        Table t = new Table(this.name, this.cols);
        t.rows = filteredRows;

        return t;

    }

    private boolean validateSchema(Object[] values){
        for(int i= 0; i<values.length; i++){
            if(cols[i].required == true){
                if(values[i] == null){
                    System.out.println(String.format("column {%s} is required", cols[i].name));
                    return false;
                }
            }
            if(cols[i].type == Type.INTEGER){
                Integer val = 0;
                try{
                    val = Integer.valueOf(values[i].toString());
                    if(val > 1024 || val < -1024){
                        System.out.println(String.format("column {%s} is not in the range", cols[i].name));
                        return false;
                    }
                }
                catch (Exception ex){
                    System.out.println(String.format("column {%s} can't be parsed to Integer", cols[i].name));
                    return false;
                }
            }

            if(cols[i].type == Type.STRING){
                if(values[i] != null && !(values[i] instanceof  String)){
                    System.out.println(String.format("column {%s} requires string value", cols[i].name));
                    return false;
                }

            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", rows=" + rows +
                '}';
    }
}
