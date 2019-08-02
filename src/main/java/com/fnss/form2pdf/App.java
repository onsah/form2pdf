package com.fnss.form2pdf;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.fnss.form2pdf.database.*;
import com.google.protobuf.Field;
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

    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, FileNotFoundException {
        Database db = new Database();
        
        if (args.length < 2) {
            System.out.println("Usage: form <name>");   
        }
        String name = args[1];
        PrintWriter pwPersonel = null, pwSaglik = null;
        try {
            db.connect(DB_NAME, DB_USER, DB_PW);
            List<PersonelForm> personelForms = db.getPersonels();
            List<SaglikForm> saglikForms = db.getSaglikForms();
            System.out.println(personelForms);
            System.out.println(saglikForms);
            Optional<PersonelForm> pForm = personelForms.stream()
                .filter(p -> p.getAd().equals(name))
                .findFirst();
            Optional<SaglikForm> sForm = saglikForms.stream()
                .filter(p -> p.getAd().equals(name))
                .findFirst();
            if (pForm.isPresent()) {
                PersonelForm form = pForm.get();
                pwPersonel = new PrintWriter(PERSONEL_FILE, "UTF-8");
                pwPersonel.println(form.toString());
            }
            if (sForm.isPresent()) {
                SaglikForm form = sForm.get();
                pwSaglik = new PrintWriter(SAGLIK_FILE, "UTF-8");
                pwSaglik.println(form.toString());
            }
        } finally {
            db.disconnect();
            if (pwPersonel != null)
                pwPersonel.close();
            if (pwSaglik != null)
                pwSaglik.close();
        }
    }
}