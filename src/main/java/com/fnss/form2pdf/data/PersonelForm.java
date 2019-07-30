package com.fnss.form2pdf.data;

import java.util.Date;

public class PersonelForm {
    private String ad;
    private String soyad;
    private long tcNo;
    private Date dogumTarihi;
    private String email;
    private String dogumYeri;
    private String il;
    private long sgkNo;
    private long iletisimNo;
    private String universiteAdi;
    private String bolumAdi;
    private int sinif;
    private String departman;
    private String anneAdi;
    private String babaAdi;

    public PersonelForm(
        String ad,
        String soyad,
        long tcNo,
        Date dogumTarihi,
        String email,
        String dogumYeri,
        String il,
        long sgkNo,
        long iletisimNo,
        String universiteAdi,
        String bolumAdi,
        int sinif,
        String departman,
        String anneAdi,
        String babaAdi
    ) {
        setAd(ad);
        setSoyad(soyad);
        setTcNo(tcNo);
        setDogumTarihi(dogumTarihi);
        setEmail(email);
        setDogumTarihi(dogumTarihi);
        setEmail(email);
        setDogumYeri(dogumYeri);
        setIl(il);
        setSgkNo(sgkNo);
        setIletisimNo(iletisimNo);
        setUniversiteAdi(universiteAdi);
        setBolumAdi(bolumAdi);
        setSinif(sinif);
        setDepartman(departman);
        setAnneAdi(anneAdi);
        setBabaAdi(babaAdi);
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

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
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
}