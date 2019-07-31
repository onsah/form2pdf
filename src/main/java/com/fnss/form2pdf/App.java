package com.fnss.form2pdf;

import java.sql.SQLException;
import java.util.List;
import com.fnss.form2pdf.database.*;
import com.fnss.form2pdf.data.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        String name = "fnss";
        String userName = "root";
        String password = "";
        try {
            db.connect(name, userName, password);
            List<PersonelForm> forms = db.getPersonels();
            System.out.println(forms);
        } finally {
            db.disconnect();
        }
    }
}