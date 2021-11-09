package db;

import java.util.HashMap;
import java.util.Map;

public class Db {

    String name;
    Map<String, Table> tables;

    public Db(String name){
        this.name = name;
        this.tables = new HashMap<String, Table>();
    }

    public boolean createTable(String name, Column[] cols){
        if(tables.containsKey(name)){
            System.out.println("Table already exists");
            //throw new RuntimeException("Table already exists");
            return false;
        }

        this.tables.put(name, new Table(name, cols));
        return true;
    }

    public Table getTable(String name){
        return tables.get(name);
    }
}
