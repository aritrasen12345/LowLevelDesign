package SOLID.DIP.Followed;


class Application {
    private final Persistence persistence;

    Application(Persistence persistence) {
        this.persistence = persistence;
    }

    void save() {
        persistence.save();
    }
}

interface Persistence  {
    void save();
}


class SQLDBPersistence  implements Persistence  {
    SQLDBPersistence () {}

    @Override
    public void save() {
        System.out.println("Saved data to SQL DB");
    }
}

class MongoDBPersistence  implements Persistence  {
    MongoDBPersistence () {}

    @Override
    public void save() {
        System.out.println("Saved data to MongoDB");
    }
}


public class DIPFollowed {
    public static void main(String[] args) {
        SQLDBPersistence  sqldb = new SQLDBPersistence ();
        MongoDBPersistence  mgdb = new MongoDBPersistence ();
        
        Application appSql = new Application(sqldb);
        Application appMongo = new Application(mgdb);

        appMongo.save();
        appSql.save();
    }
}
