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
public class DCTemaDiplomskogRada implements GeneralDObject, Serializable {

    private Long temaID;
    private String nazivTeme;
    private String opisTeme;
    private DCPredmet predmet;

    public DCTemaDiplomskogRada() {
    }

    public DCTemaDiplomskogRada(Long temaID, String nazivTeme, String opisTeme, DCPredmet predmet) {
        this.temaID = temaID;
        this.nazivTeme = nazivTeme;
        this.opisTeme = opisTeme;
        this.predmet = predmet;
    }

    public DCTemaDiplomskogRada(Long temaID) {
        this.temaID = temaID;
    }

    public Long getTemaID() {
        return temaID;
    }

    public void setTemaID(Long temaID) {
        this.temaID = temaID;
    }

    public String getNazivTeme() {
        return nazivTeme;
    }

    public void setNazivTeme(String nazivTeme) {
        this.nazivTeme = nazivTeme;
    }

    public String getOpisTeme() {
        return opisTeme;
    }

    public void setOpisTeme(String opisTeme) {
        this.opisTeme = opisTeme;
    }

    public DCPredmet getPredmet() {
        return predmet;
    }

    public void setPredmet(DCPredmet predmet) {
        this.predmet = predmet;
    }

    @Override
    public String getAtrValue() {
        return "'" + nazivTeme + "', '" + opisTeme + "', " + predmet.getPredmetID();
    }

    @Override
    public String setAtrValue() {
        return Constants.TemaDiplomskogRada.NAZIV_TEME + "='" + nazivTeme + "'," + Constants.TemaDiplomskogRada.OPIS_TEME + "='" + opisTeme + "'," + Constants.TemaDiplomskogRada.PREDMET_ID_FK + "=" + predmet.getPredmetID();
    }

    @Override
    public String getClassName() {
        return Constants.TemaDiplomskogRada.CLASS_NAME;
    }

    @Override
    public String getWhereCondition() {
        return Constants.TemaDiplomskogRada.TEMA_ID + "=" + temaID;
    }

    @Override
    public String getNameByColumn(int column) {
        String[] names = new String[]{Constants.TemaDiplomskogRada.TEMA_ID, Constants.TemaDiplomskogRada.NAZIV_TEME, Constants.TemaDiplomskogRada.OPIS_TEME, Constants.TemaDiplomskogRada.PREDMET_ID_FK};
        return names[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        if (nazivTeme.length() < 10) {
            throw new Exception("naziv teme previse kratak");
        }
        if (opisTeme.length() < 10) {
            throw new Exception("Opis teme previse kratak");
        }
        if (predmet == null) {
            throw new Exception("Predmet null");//elavborate
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.temaID);
        hash = 37 * hash + Objects.hashCode(this.nazivTeme);
        hash = 37 * hash + Objects.hashCode(this.opisTeme);
        hash = 37 * hash + Objects.hashCode(this.predmet);
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
        final DCTemaDiplomskogRada other = (DCTemaDiplomskogRada) obj;
        if (!Objects.equals(this.temaID, other.temaID)) {
            return false;
        }
        return true;
    }

    @Override
    public String getColumnNames() {
        return Constants.TemaDiplomskogRada.NAZIV_TEME + "," + Constants.TemaDiplomskogRada.OPIS_TEME + "," + Constants.TemaDiplomskogRada.PREDMET_ID_FK;
    }

    @Override
    public void setKey(ResultSet rs) {
        try {
            if (rs.next()) {
                temaID = rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DCTemaDiplomskogRada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return nazivTeme;
    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{Constants.TemaDiplomskogRada.NAZIV_TEME};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.TemaDiplomskogRada.TEMA_ID:
                return temaID;
            case Constants.TemaDiplomskogRada.NAZIV_TEME:
                return nazivTeme;
            case Constants.TemaDiplomskogRada.OPIS_TEME:
                return opisTeme;
            case Constants.TemaDiplomskogRada.PREDMET_ID_FK:
                return predmet;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.TemaDiplomskogRada.TEMA_ID};
    }
    
    

}
