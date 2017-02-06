package com.vocabulary.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeMap;

/**
 * Created by Strus Sviatoslav on 06.02.2017.
 */
public class FromSQLtoMap {

    public TreeMap<String,Integer> getMap (){
        TreeMap<String,Integer> map = new TreeMap<>();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/Vocabulary",
                            "user", "b33e5460");
            c.setAutoCommit(false);

            ResultSet rs = stmt.executeQuery( "SELECT * FROM vocabulary;" );
            while ( rs.next() ) {
                map.put(rs.getString("word"), rs.getInt("frequency"));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return map;
    }
}
