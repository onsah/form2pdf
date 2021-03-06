package com.fnss.form2pdf.database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import com.fnss.form2pdf.data.PersonelForm;
import com.fnss.form2pdf.data.SaglikForm;
import com.mysql.cj.jdbc.Driver;

public class Database {
    private static final String PERSONEL_TABLE = "personel";
    private static final String SAGLIK_TABLE = "saglik";

    private static final GregorianCalendar dummy = new GregorianCalendar();
    
    private static final int AD_INDEX           = 1;
    private static final int SOYAD_INDEX        = 2;
    private static final int DTARIHI_INDEX      = 3;
    private static final int EMAIL_INDEX        = 4;
    private static final int DYERI_INDEX        = 5;
    private static final int IKAMETGAH_INDEX    = 6;
    private static final int IL_INDEX           = 7;
    private static final int ILCE_INDEX         = 8;
    private static final int SGK_INDEX          = 9;
    private static final int ILETISIM_INDEX     = 10;
    private static final int UNIVERSITE_INDEX   = 11;
    private static final int BOLUM_INDEX        = 12;
    private static final int SINIF_INDEX        = 13;
    private static final int DEPARTMAN_INDEX    = 14;
    private static final int ANNE_INDEX         = 15;
    private static final int BABA_INDEX         = 16;
    private static final int TC_INDEX           = 17;


    
    private final String SERVER_IP;
    private final String MYSQL_URI;

    private Connection mConnection = null;

    public Database() {
        SERVER_IP = "127.0.0.1";
        MYSQL_URI = "jdbc:mysql://" + SERVER_IP + ":3306/";
    }

    public Database(String serverIp) {
        SERVER_IP = serverIp;
        MYSQL_URI = "jdbc:mysql://" + SERVER_IP + ":3306/";
    }

    public void connect(String name, String user, String password) throws SQLException, ClassNotFoundException {
        new Driver();
        mConnection = DriverManager.getConnection(MYSQL_URI + name, user, password);
    }

    public void disconnect() throws SQLException {
        if (mConnection != null) {
            mConnection.close();
            mConnection = null;
        }
    }

    public List<PersonelForm> getPersonels() throws SQLException {
        Statement stmt = null;
        ArrayList<PersonelForm> forms = new ArrayList<>();
        try {
            stmt = mConnection.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from " + PERSONEL_TABLE);
            while (rs.next()) {
                String ad = rs.getString(AD_INDEX);
                String soyad = rs.getString(SOYAD_INDEX);
                // String dtarihi = rs.getString(DTARIHI_INDEX);
                String email = rs.getString(EMAIL_INDEX);
                String dyeri = rs.getString(DYERI_INDEX);
                String ikametgah = rs.getString(IKAMETGAH_INDEX);
                String il = rs.getString(IL_INDEX);
                String ilce = rs.getString(ILCE_INDEX);
                BigDecimal sgkNo = rs.getBigDecimal(SGK_INDEX);
                BigDecimal iletisimNo = rs.getBigDecimal(ILETISIM_INDEX);
                String uniAdi = rs.getString(UNIVERSITE_INDEX);
                String bolumAdi = rs.getString(BOLUM_INDEX);
                int sinif = rs.getInt(SINIF_INDEX);
                String departman = rs.getString(DEPARTMAN_INDEX);
                String anneAdi = rs.getString(ANNE_INDEX);
                String babaAdi = rs.getString(BABA_INDEX);
                BigDecimal tcNo = rs.getBigDecimal(TC_INDEX);
                forms.add(new PersonelForm(
                    ad, soyad, dummy, email, 
                    dyeri, ikametgah, il, ilce, 
                    sgkNo.toBigInteger().longValue(), 
                    iletisimNo.toBigInteger().longValue(),
                    uniAdi, bolumAdi, sinif, departman,
                    anneAdi, babaAdi, tcNo.toBigInteger().longValue()
                ));
            }
        } finally {
            stmt.close();
        }
        return forms;
    }

    public List<SaglikForm> getSaglikForms() throws SQLException {
        Statement stmt = null;
        ArrayList<SaglikForm> forms = new ArrayList<>();
        
        try {
            stmt = mConnection.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from " + SAGLIK_TABLE);
            while (rs.next()) {
                String ad = rs.getString(1);
                String soyad = rs.getString(2);
                long tcNo = rs.getLong(11);
                // GregorianCalendar dtarihi = (3);
                long telno = rs.getLong(4);
                String hastalik = rs.getString(5);
                String ilac = rs.getString(6);
                String ameliyat = rs.getString(7);
                String alerji = rs.getString(10);
                double boy =  rs.getDouble(8);
                boolean sigara = rs.getBoolean(9);  
                forms.add(new SaglikForm(
                    ad, soyad, tcNo, dummy,
                    telno, hastalik, ilac, ameliyat,
                    alerji, boy, sigara
                ));       
            }
        } finally {
            stmt.close();
        }
        return forms;
    }

    public boolean isConnected() {
        return mConnection != null;
    }
}