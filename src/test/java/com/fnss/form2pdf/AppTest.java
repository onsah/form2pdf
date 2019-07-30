package com.fnss.form2pdf;

import org.junit.Test;
import com.fnss.form2pdf.MdGen;
import static org.junit.Assert.*;

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
}
