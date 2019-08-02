package com.fnss.form2pdf.data;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.fnss.form2pdf.MdGen;

public class SaglikForm {
    private static final SimpleDateFormat FMT = new SimpleDateFormat("dd/MM/yyyy");

    private String ad;
    private String soyad;
    private long tcNo;
    private GregorianCalendar dtarihi;
    private long telno;
    private String hastalik;
    private String ilac;
    private String ameliyat;
    private String alerji;
    private double boy;
    private boolean sigara;

    public SaglikForm(String ad, String soyad, long tcNo, GregorianCalendar dtarihi, long telno, String hastalik, String ilac,
            String ameliyat, String alerji, double boy, boolean sigara) {
        setAd(ad);
        setSoyad(soyad);
        setTcNo(tcNo);
        setDtarihi(dtarihi);
        setTelno(telno);
        setHastalik(hastalik);
        setIlac(ilac);
        setAmeliyat(ameliyat);
        setAlerji(alerji);
        setBoy(boy);
        setSigara(sigara);
    }

    public String getIlac() {
        return ilac;
    }

    public void setIlac(String ilac) {
        this.ilac = ilac;
    }

    public String getAd() {
        return ad;
    }

    public boolean isSigara() {
        return sigara;
    }

    public void setSigara(boolean sigara) {
        this.sigara = sigara;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }

    public String getAlerji() {
        return alerji;
    }

    public void setAlerji(String alerji) {
        this.alerji = alerji;
    }

    public String getAmeliyat() {
        return ameliyat;
    }

    public void setAmeliyat(String ameliyat) {
        this.ameliyat = ameliyat;
    }

    public String getHastalik() {
        return hastalik;
    }

    public void setHastalik(String hastalik) {
        this.hastalik = hastalik;
    }

    public long getTelno() {
        return telno;
    }

    public void setTelno(long telno) {
        this.telno = telno;
    }

    public GregorianCalendar getDtarihi() {
        return dtarihi;
    }

    public void setDtarihi(GregorianCalendar dtarihi) {
        this.dtarihi = dtarihi;
    }

    public long getTcNo() {
        return tcNo;
    }

    public void setTcNo(long tcNo) {
        this.tcNo = tcNo;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        MdGen gen = new MdGen();

        gen.addHeader(2, "Ad: " + getAd());
        gen.addHeader(2, "Soyad: " + getSoyad());
        gen.addHeader(2, "Tc: " + getTcNo());
        gen.addHeader(2, "Doğum tarihi: " + FMT.format(getDtarihi().getTime()));
        gen.addHeader(2, "Telefon: " + getTelno());
        gen.addHeader(2, "Hastalık: " + getHastalik());
        gen.addHeader(2, "İlaç: " + getIlac());
        gen.addHeader(2, "Ameliyat: " + getAmeliyat());
        gen.addHeader(2, "Alerji: " + getAlerji());
        gen.addHeader(2, "Boy: " + getBoy());
        gen.addHeader(2, "Sigara: " + isSigara());

        return gen.toString();
    }    
}