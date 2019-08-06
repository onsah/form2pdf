package com.fnss.form2pdf;

import org.junit.Test;
import com.fnss.form2pdf.MdGen;
import com.fnss.form2pdf.data.PersonelForm;
import com.fnss.form2pdf.data.SaglikForm;
import com.fnss.form2pdf.database.*;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test
    public void testMdGen() {
        MdGen gen = new MdGen();
        String header1 = "Ad: Onur";
        String header2 = "Soyad: Sahin";

        gen.addHeader(1, header1);
        gen.addHeader(2, header2);

        assertEquals(gen.toString(), "# Ad: Onur\n## Soyad: Sahin\n");
    }

    @Test
    public void testDatabase() throws SQLException, ClassNotFoundException {
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
