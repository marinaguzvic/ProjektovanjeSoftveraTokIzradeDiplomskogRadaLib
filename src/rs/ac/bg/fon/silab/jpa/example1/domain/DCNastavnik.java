/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.jpa.example1.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCNastavnik implements GeneralDObject, Serializable {

    private Long nastavnikID;
    private String imeNastavnika;
    private String prezimeNastavnika;
    private String brojRadneKnjizice; //proveriti koliko znakova ima
    private String jmbg;
    private EZvanje zvanje;
    private ETitula titula; //da li da zvanje i titula budu enumerated?

    public DCNastavnik() {
    }

    public DCNastavnik(Long nastavnik_id, String imeNastavnika, String prezimeNastavnika, String brojRadneKnjizice, String jmbg, EZvanje zvanje, ETitula titula) {
        this.nastavnikID = nastavnik_id;
        this.imeNastavnika = imeNastavnika;
        this.prezimeNastavnika = prezimeNastavnika;
        this.brojRadneKnjizice = brojRadneKnjizice;
        this.jmbg = jmbg;
        this.zvanje = zvanje;
        this.titula = titula;
    }

    public DCNastavnik(Long nastavnik_id) {
        this.nastavnikID = nastavnik_id;
    }

    public Long getNastavnikID() {
        return nastavnikID;
    }

    public void setNastavnikID(Long nastavnikID) {
        this.nastavnikID = nastavnikID;
    }

    public String getImeNastavnika() {
        return imeNastavnika;
    }

    public void setImeNastavnika(String imeNastavnika) {
        this.imeNastavnika = imeNastavnika;
    }

    public String getPrezimeNastavnika() {
        return prezimeNastavnika;
    }

    public void setPrezimeNastavnika(String prezimeNastavnika) {
        this.prezimeNastavnika = prezimeNastavnika;
    }

    public String getBrojRadneKnjizice() {
        return brojRadneKnjizice;
    }

    public void setBrojRadneKnjizice(String brojRadneKnjizice) {
        this.brojRadneKnjizice = brojRadneKnjizice;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public EZvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(EZvanje zvanje) {
        this.zvanje = zvanje;
    }

    public ETitula getTitula() {
        return titula;
    }

    public void setTitula(ETitula titula) {
        this.titula = titula;
    }

    @Override
    public String getAtrValue() {
        return "'" + imeNastavnika + "', '" + prezimeNastavnika + "', '" + brojRadneKnjizice + "', '" + jmbg + "', '" + zvanje + "', '" + titula + "'";
    }

    @Override
    public String setAtrValue() {
        return Constants.Nastavnik.IME_NASTAVNIKA + "='" + imeNastavnika + "'," + Constants.Nastavnik.PREZIME_NASTAVNIK + "='" + prezimeNastavnika + "'," + Constants.Nastavnik.BROJ_RADNE_KNJIZICE + "='" + brojRadneKnjizice + "'," + Constants.Nastavnik.JMBG + "='" + jmbg + "'," + Constants.Nastavnik.ZVANJE + "='" + zvanje.name() + "'," + Constants.Nastavnik.TITULA + "='" + titula.name() + "'";
    }

    @Override
    public String getClassName() {
        return Constants.Nastavnik.CLASS_NAME;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Nastavnik.NASTAVNIK_ID + "=" + nastavnikID;
    }

    @Override
    public String getNameByColumn(int column) {
        String[] names = new String[]{Constants.Nastavnik.NASTAVNIK_ID, Constants.Nastavnik.IME_NASTAVNIKA, Constants.Nastavnik.PREZIME_NASTAVNIK, Constants.Nastavnik.BROJ_RADNE_KNJIZICE, Constants.Nastavnik.JMBG, Constants.Nastavnik.ZVANJE, Constants.Nastavnik.TITULA};
        return names[column];
    }

    @Override
    public void checkConstraints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnNames() {
        return Constants.Nastavnik.IME_NASTAVNIKA + "," + Constants.Nastavnik.PREZIME_NASTAVNIK + "," + Constants.Nastavnik.BROJ_RADNE_KNJIZICE + "," + Constants.Nastavnik.JMBG + "," + Constants.Nastavnik.ZVANJE + "," + Constants.Nastavnik.TITULA;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nastavnikID);
        hash = 31 * hash + Objects.hashCode(this.imeNastavnika);
        hash = 31 * hash + Objects.hashCode(this.prezimeNastavnika);
        hash = 31 * hash + Objects.hashCode(this.brojRadneKnjizice);
        hash = 31 * hash + Objects.hashCode(this.jmbg);
        hash = 31 * hash + Objects.hashCode(this.zvanje);
        hash = 31 * hash + Objects.hashCode(this.titula);
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
        final DCNastavnik other = (DCNastavnik) obj;
        if (!Objects.equals(this.nastavnikID, other.nastavnikID)) {
            return false;
        }
        return true;
    }

    @Override
    public void setKey(ResultSet rs) {
        try {
            if (rs.next()) {
                nastavnikID = rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DCNastavnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return imeNastavnika + " " + prezimeNastavnika;
    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Nastavnik.NASTAVNIK_ID:
                return nastavnikID;
            case Constants.Nastavnik.IME_NASTAVNIKA:
                return imeNastavnika;
            case Constants.Nastavnik.PREZIME_NASTAVNIK:
                return prezimeNastavnika;
            case Constants.Nastavnik.BROJ_RADNE_KNJIZICE:
                return brojRadneKnjizice;
            case Constants.Nastavnik.JMBG:
                return jmbg;
            case Constants.Nastavnik.ZVANJE:
                return zvanje;
            case Constants.Nastavnik.TITULA:
                return titula;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Nastavnik.NASTAVNIK_ID};
    }
    
    

}
