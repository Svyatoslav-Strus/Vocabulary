package com.vocabulary.DB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Strus Sviatoslav on 06.02.2017.
 */
public class FromTXTtoSQL {

    public static void fromTXTtoSQL() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("words2.txt"));
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/Vocabulary",
                            "user", "b33e5460");
            c.setAutoCommit(false);

            while (reader.ready()){
                String line = reader.readLine();
                stmt = c.createStatement();
                String sql = "INSERT INTO vocabulary (word, frequency) "
                           + "VALUES ('" + line + "', 0);";
                stmt.executeUpdate(sql);
                System.out.println(sql);
            }
            c.commit();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
