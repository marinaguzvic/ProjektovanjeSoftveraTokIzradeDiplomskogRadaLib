/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.jpa.example1.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Objects;
import rs.ac.bg.fon.silab.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCStudent implements GeneralDObject, Serializable {

    private String brojIndeksa;
    private String jmbg;
    private String ime;
    private String prezime;
    private boolean budzet;
    private int godinaStudija;
    private LocalDate datumRodjenja;
    private boolean prviPutUpisao;

    public DCStudent(String brojIndeksa, String jmbg, String ime, String prezime, boolean budzet, int godinaStudija, LocalDate datumRodjenja, boolean prviPutUpisao) {
        this.brojIndeksa = brojIndeksa;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.budzet = budzet;
        this.godinaStudija = godinaStudija;
        this.datumRodjenja = datumRodjenja;
        this.prviPutUpisao = prviPutUpisao;

    }

    public DCStudent() {
        this.brojIndeksa = "00000000";
        this.jmbg = "0000000000000";
        this.ime = "";
        this.prezime = "";
        this.budzet = false;
        this.godinaStudija = 1;
        this.datumRodjenja = LocalDate.now();
        this.datumRodjenja = this.datumRodjenja.minusYears(19);
        this.prviPutUpisao = true;

    }

    public DCStudent(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean isBudzet() {
        return budzet;
    }

    public void setBudzet(boolean budzet) {
        this.budzet = budzet;
    }

    public int getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(int godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public boolean isPrviPutUpisao() {
        return prviPutUpisao;
    }

    public void setPrviPutUpisao(boolean prviPutUpisao) {
        this.prviPutUpisao = prviPutUpisao;
    }

    @Override
    public String getAtrValue() {
        return "'" + brojIndeksa + "', '" + jmbg + "', '" + ime + "', '" + prezime + "', " + (budzet ? 1 : 0) + ", " + godinaStudija + ", '" + datumRodjenja + "', " + (prviPutUpisao ? 1 : 0);
    }

    @Override
    public String setAtrValue() {
        return Constants.Student.BROJ_INDEKSA + "='" + brojIndeksa + "'," + Constants.Student.JMBG + "='" + jmbg + "'," + Constants.Student.IME + "='" + ime + "'," + Constants.Student.PREZIME + "='" + prezime + "'," + Constants.Student.BUDZET + "=" + budzet + "," + Constants.Student.GODINA_STUDIJA + "=" + godinaStudija + "," + Constants.Student.DATUM_RODJENJA + "='" + datumRodjenja + "'," + Constants.Student.PRVI_PUT_UPISAO + "=" + prviPutUpisao;
    }

    @Override
    public String getClassName() {
        return Constants.Student.CLASS_NAME;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Student.BROJ_INDEKSA + "='" + brojIndeksa + "'";
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = new String[]{Constants.Student.BROJ_INDEKSA, Constants.Student.JMBG, Constants.Student.IME, Constants.Student.PREZIME, Constants.Student.BUDZET, Constants.Student.GODINA_STUDIJA, Constants.Student.DATUM_RODJENJA, Constants.Student.PRVI_PUT_UPISAO};
        return names[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        try {
            Long.parseLong(jmbg);
        } catch (NumberFormatException pe) {
            throw new Exception("JMBG is not consisted of all integers");
        }
        if (jmbg.length() < 13 || jmbg.length() > 13) {
            throw new Exception("JMBG is supposed to be 13 digits long, yours is: " + jmbg.length());
        }
        if (ime.length() <= 2) {
            throw new Exception("Name length less than 3");
        }
        for (char c : ime.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new Exception("Character " + c + " in Name is not a letter");
            }
        }
        if (jmbg.length() != 13) {
            throw new Exception("JMBG is supposed to be 13 digits long, yours is: " + jmbg.length());
        }
        if (prezime.length() <= 2) {
            throw new Exception("Surname length less than 3");
        }
        for (char c : prezime.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new Exception("Character " + c + " in Surname is not a letter");
            }
        }
    }

    @Override
    public String getColumnNames() {
        return Constants.Student.BROJ_INDEKSA + "," + Constants.Student.JMBG + "," + Constants.Student.IME + "," + Constants.Student.PREZIME + "," + Constants.Student.BUDZET + "," + Constants.Student.GODINA_STUDIJA + "," + Constants.Student.DATUM_RODJENJA + "," + Constants.Student.PRVI_PUT_UPISAO;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.brojIndeksa);
        hash = 79 * hash + Objects.hashCode(this.jmbg);
        hash = 79 * hash + Objects.hashCode(this.ime);
        hash = 79 * hash + Objects.hashCode(this.prezime);
        hash = 79 * hash + (this.budzet ? 1 : 0);
        hash = 79 * hash + this.godinaStudija;
        hash = 79 * hash + Objects.hashCode(this.datumRodjenja);
        hash = 79 * hash + (this.prviPutUpisao ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DCStudent other = (DCStudent) obj;
        if (!Objects.equals(this.brojIndeksa, other.brojIndeksa)) {
            return false;
        }
        return true;
    }

    @Override
    public void setKey(ResultSet rs) {
    }

    @Override
    public String toString() {
        return brojIndeksa + "\t" + ime + "\t" + prezime;
    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{Constants.Student.BROJ_INDEKSA,Constants.Student.JMBG};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Student.BROJ_INDEKSA:
                return brojIndeksa;
            case Constants.Student.JMBG:
                return jmbg;
            case Constants.Student.IME:
                return ime;
            case Constants.Student.PREZIME:
                return prezime;
            case Constants.Student.BUDZET:
                return budzet;
            case Constants.Student.GODINA_STUDIJA:
                return godinaStudija;
            case Constants.Student.DATUM_RODJENJA:
                return datumRodjenja;
            case Constants.Student.PRVI_PUT_UPISAO:
                return prviPutUpisao;
                default:
                    return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Student.BROJ_INDEKSA};
    }

    
}
