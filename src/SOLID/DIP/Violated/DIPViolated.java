package SOLID.DIP.Violated;


class Application {
    MongoDB mgdb;
    SQLDB sqldb;

    Application(MongoDB mgdb, SQLDB sqldb) {
        this.mgdb = mgdb;
        this.sqldb = sqldb;
    }

    void saveToMongoDB() {
        this.mgdb.save();
    }

    void saveToSQLDB() {
        this.sqldb.save();
    }
}


class MongoDB {
    MongoDB() {}

    void save() {
        System.out.println("Saving data to MongoDB");
    }
}


class SQLDB {
    SQLDB() {}

    void save() {
        System.out.println("Saving data to SQLDB");
    }
}


public class DIPViolated {
    public static void main(String[] args) {
        MongoDB mgdb = new MongoDB();
        SQLDB sqldb = new SQLDB();
        Application app = new Application(mgdb, sqldb);

        app.saveToSQLDB();
        app.saveToMongoDB();
    }
    
}