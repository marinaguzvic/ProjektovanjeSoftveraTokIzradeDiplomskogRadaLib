/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.jpa.example1.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Objects;
import rs.ac.bg.fon.silab.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCKorisnik implements GeneralDObject, Serializable {

    private String username;
    private char[] password;
    private String ime;
    private String prezime;

    public DCKorisnik() {
        password = new char[0];

    }

    public DCKorisnik(String username, char[] password, String ime, String prezime) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    @Override
    public String getAtrValue() {
        return "'" + username + "', '" + new String(password) + "', '" + ime + "', '" + prezime + "'";
    }

    @Override
    public String setAtrValue() {
        return Constants.Korisnik.USERNAME + "='" + username + "', " + Constants.Korisnik.PASSWORD + "='" + new String(password) + "', " + Constants.Korisnik.IME + "='" + ime + "', " + Constants.Korisnik.PREZIME + "='" + prezime + "'";
    }

    @Override
    public String getClassName() {
        return Constants.Korisnik.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.Korisnik.USERNAME + "," + Constants.Korisnik.PASSWORD + "," + Constants.Korisnik.IME + "," + Constants.Korisnik.PREZIME;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Korisnik.USERNAME + "='" + username + "'";
    }

    @Override
    public String getNameByColumn(int column) {
        return new String[]{Constants.Korisnik.USERNAME, Constants.Korisnik.PASSWORD, Constants.Korisnik.IME, Constants.Korisnik.PREZIME}[column];
    }

    @Override
    public void checkConstraints() throws Exception {

        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        if (!new String(password).matches(pattern)) {
            throw new Exception("Password must have: 1 upper, one lower letter, one number and one special character at least and has to be at least 8 characters long");
        }
        if (username.length() < 3) {
            throw new Exception("Username is too short! Must be at least 3 characters long!");
        }
        if (ime.length() < 3) {
            throw new Exception("Ime has less than 3 characters");
        }
        if (prezime.length() < 3) {
            throw new Exception("Prezime has less than 3 characters");
        }
    }

    @Override
    public void setKey(ResultSet rs) throws Exception {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
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

    @Override
    public String toString() {
        return username;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.username);
        hash = 41 * hash + Objects.hashCode(this.password);
        hash = 41 * hash + Objects.hashCode(this.ime);
        hash = 41 * hash + Objects.hashCode(this.prezime);
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
        final DCKorisnik other = (DCKorisnik) obj;
        if (!this.username.equals(other.username)) {
            return false;
        }

        if (this.password.length != other.password.length) {
            return false;
        }
        for (int i = 0; i < this.password.length; i++) {
            if (this.password[i] != other.password[i]) {
                return false;
            }
        }
        return true;

    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{Constants.Korisnik.USERNAME};
    }

    @Override
    public Object getValue(String column) {
        switch(column){
            case Constants.Korisnik.USERNAME:
                return username;
            case Constants.Korisnik.PASSWORD:
                return password;
            case Constants.Korisnik.IME:
                return ime;
            case Constants.Korisnik.PREZIME:
                return prezime;
            default:
                return null;
              
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Korisnik.USERNAME};
    }
    
    

}
