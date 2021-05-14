package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.EnumSet;


// VALIDACE + CEHO
// sport a pohlavi je v ENUMU
// vytvoreni GETTERU a SETTERU
// DATE a TIME FORMAT (u data narozeni)

public class RegistraceForm {
    @NotBlank
    private String jmeno;
    @NotBlank
    private String prijmeni;
    @NotNull
    private EnumSet<Pohlavi> pohlavi;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate datumNarozeni;
    @NotNull
    private String turnus;
    @NotNull
    private EnumSet<Sport> sport;
    @NotNull
    private String telefon;
    @Email
    private String email;
    @NotNull
    private int vekDitete;


    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public EnumSet<Pohlavi> getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(EnumSet<Pohlavi> pohlavi) {
        this.pohlavi = pohlavi;
    }


    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getTurnus() {
        return turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public EnumSet<Sport> getSport() {
        return sport;
    }

    public void setSport(EnumSet<Sport> sport) {
        this.sport = sport;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVekDitete() {
        return vekDitete;
    }

    public void setVekDitete(int vekDitete) {
        this.vekDitete = vekDitete;
    }

}