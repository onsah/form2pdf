package com.fnss.form2pdf.data;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.fnss.form2pdf.MdGen;

public class PersonelForm {
    private static final SimpleDateFormat FMT = new SimpleDateFormat("dd/MM/yyyy");

    private String ad;
    private String soyad;
    private GregorianCalendar dogumTarihi;
    private String email;
    private String dogumYeri;
    private String ikametgah;
    private String il;
    private String ilce;
    private long sgkNo;
    private long iletisimNo;
    private String universiteAdi;
    private String bolumAdi;
    private int sinif;
    private String departman;
    private String anneAdi;
    private String babaAdi;
    private long tcNo;

    public PersonelForm(
        String ad, 
        String soyad, 
        GregorianCalendar dogumTarihi, 
        String email,
        String dogumYeri, 
        String ikametgah, 
        String il, 
        String ilce,
        long sgkNo, 
        long iletisimNo, 
        String universiteAdi,
        String bolumAdi, 
        int sinif, 
        String departman, 
        String anneAdi, 
        String babaAdi,
        long tcNo
    ) {
        setAd(ad);
        setSoyad(soyad);
        setDogumTarihi(dogumTarihi);
        setEmail(email);
        setDogumYeri(dogumYeri);
        setIkametgah(ikametgah);
        setIl(il);
        setIlce(ilce);
        setSgkNo(sgkNo);
        setIletisimNo(iletisimNo);
        setUniversiteAdi(universiteAdi);
        setBolumAdi(bolumAdi);
        setSinif(sinif);
        setDepartman(departman);
        setAnneAdi(anneAdi);
        setBabaAdi(babaAdi);
        setTcNo(tcNo);
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getIkametgah() {
        return ikametgah;
    }

    public void setIkametgah(String ikametgah) {
        this.ikametgah = ikametgah;
    }

    public String getAd() {
        return ad;
    }

    public String getBabaAdi() {
        return babaAdi;
    }

    public void setBabaAdi(String babaAdi) {
        this.babaAdi = babaAdi;
    }

    public String getAnneAdi() {
        return anneAdi;
    }

    public void setAnneAdi(String anneAdi) {
        this.anneAdi = anneAdi;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public int getSinif() {
        return sinif;
    }

    public void setSinif(int sinif) {
        this.sinif = sinif;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public String getUniversiteAdi() {
        return universiteAdi;
    }

    public void setUniversiteAdi(String universiteAdi) {
        this.universiteAdi = universiteAdi;
    }

    public long getIletisimNo() {
        return iletisimNo;
    }

    public void setIletisimNo(long iletisimNo) {
        this.iletisimNo = iletisimNo;
    }

    public long getSgkNo() {
        return sgkNo;
    }

    public void setSgkNo(long sgkNo) {
        this.sgkNo = sgkNo;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GregorianCalendar getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(GregorianCalendar dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
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
        gen.addHeader(2, "Doğum tarihi: " + FMT.format(getDogumTarihi().getTime()));
        gen.addHeader(2, "İl: " + getIl());
        gen.addHeader(2, "İlce: " + getIlce());
        gen.addHeader(2, "Sgk no: " + String.valueOf(getSgkNo()));
        gen.addHeader(2, "İletişim numarası: " + String.valueOf(getIletisimNo()));
        gen.addHeader(2, "Üniversite adı: " + getUniversiteAdi());
        gen.addHeader(2, "Üniversite Bölümü: " + getBolumAdi());
        gen.addHeader(2, "Sınıf: " + String.valueOf(getSinif()));
        gen.addHeader(2, "Departman: " + getDepartman());
        gen.addHeader(2, "Anne adı: " + getAnneAdi());
        gen.addHeader(2, "Baba adı: " + getBabaAdi());
        gen.addHeader(2, "TC no: " + String.valueOf(getTcNo()));
        
        return gen.toString();
    }
}