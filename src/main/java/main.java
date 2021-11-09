import db.Column;
import db.Db;
import db.Type;

public class main {
    public static void main(String[] args) {
        Db db = new Db("shopping");

        db.createTable("cart",
                new Column[]{new Column("name", Type.STRING, true),
                new Column("quantity", Type.INTEGER, true),
                        new Column("favourite", Type.STRING, false)});

        db.getTable("cart").insert("Orange", 1, null);
        db.getTable("cart").insert("Apple", 20, null);
        db.getTable("cart").insert("Apple", 25, "Y");
        db.getTable("cart").insert("Grapes", 15, null);

        System.out.println(db.getTable("cart").toString());

        System.out.println(db.getTable("cart").filter("", "name", "Apple").toString());

    }
}
