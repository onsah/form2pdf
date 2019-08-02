package com.fnss.form2pdf;

import java.sql.SQLException;
import java.util.List;
import com.fnss.form2pdf.database.*;
import com.fnss.form2pdf.data.*;

/**
 * Hello world!
 */
public final class App {
    private static final String DB_NAME = "fnss";
    private static final String DB_USER = "root";
    private static final String DB_PW = ""; // Don't use this in production!!!

    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        
        if (args.length < 2) {
            System.out.println("Usage: form <name>");   
        }

        try {
            db.connect(DB_NAME, DB_USER, DB_PW);
            List<PersonelForm> forms = db.getPersonels();
            System.out.println(forms);
        } finally {
            db.disconnect();
        }
    }
}