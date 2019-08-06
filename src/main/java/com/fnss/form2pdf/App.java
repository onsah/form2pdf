package com.fnss.form2pdf;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.fnss.form2pdf.database.*;
import com.fnss.form2pdf.data.*;

/**
 * Hello world!
 */
public final class App {
    private static final String DB_NAME = "fnss";
    private static final String DB_USER = "root";
    private static final String DB_PW = ""; // Don't use this in production!!!
    private static final String PERSONEL_FILE = "personel.md";
    private static final String SAGLIK_FILE = "saglik.md";

    private static boolean gotError = false;

    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, FileNotFoundException {
        Database db = new Database();
        
        if (args.length < 1) {
            System.out.println("Usage: form2text <tc-no>");  
            return; 
        }
        long tcNo = Long.parseLong(args[0]);
        PrintWriter pwPersonel = null, pwSaglik = null;
        try {
            db.connect(DB_NAME, DB_USER, DB_PW);
            List<PersonelForm> personelForms = db.getPersonels();
            List<SaglikForm> saglikForms = db.getSaglikForms();
            Optional<PersonelForm> pForm = personelForms.stream()
                .filter(p -> p.getTcNo() == tcNo)
                .findFirst();
            Optional<SaglikForm> sForm = saglikForms.stream()
                .filter(p -> p.getTcNo() == tcNo)
                .findFirst();
            if (pForm.isPresent()) {
                PersonelForm form = pForm.get();
                pwPersonel = new PrintWriter(PERSONEL_FILE, "UTF-8");
                pwPersonel.println(form.toString());
            } else {
                gotError = true;
                System.out.println("Error: Couldn't find personel entry for tc id: " + String.valueOf(tcNo));
            }
            if (sForm.isPresent()) {
                SaglikForm form = sForm.get();
                pwSaglik = new PrintWriter(SAGLIK_FILE, "UTF-8");
                pwSaglik.println(form.toString());
            } else {
                gotError = true;
                System.out.println("Error: Couldn't find saglik entry for tc id: " + String.valueOf(tcNo));
            }
        } finally {
            db.disconnect();
            if (pwPersonel != null)
                pwPersonel.close();
            if (pwSaglik != null)
                pwSaglik.close();
        }
        if (!gotError) {
            System.out.println("Files generated successfully");
        } else {
            System.exit(1);
        }
    }
}