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
public class DCPredmet implements GeneralDObject, Serializable {

    private Long predmetID;
    private String nazivPredmeta;

    public DCPredmet(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public DCPredmet() {
    }

    public DCPredmet(Long predmetID, String nazivPredmeta) {
        this.predmetID = predmetID;
        this.nazivPredmeta = nazivPredmeta;

    }

    public DCPredmet(Long predmetID) {
        this.predmetID = predmetID;
    }

    public Long getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(Long predmetID) {
        this.predmetID = predmetID;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    @Override
    public String getAtrValue() {
        return "'" + nazivPredmeta + "'";
    }

    @Override
    public String setAtrValue() {
        return Constants.Predmet.NAZIV_PREDMETA + "='" + nazivPredmeta + "'";
    }

    @Override
    public String getClassName() {
        return Constants.Predmet.CLASS_NAME;
    }

    @Override
    public String getWhereCondition() {
        return Constants.Predmet.PREDMET_ID + "=" + predmetID;
    }

    @Override
    public String getNameByColumn(int column) {
        String[] names = new String[]{Constants.Predmet.PREDMET_ID, Constants.Predmet.NAZIV_PREDMETA};
        return names[column];
    }

    @Override
    public void checkConstraints() {
    }

    @Override
    public String getColumnNames() {
        return Constants.Predmet.NAZIV_PREDMETA;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.predmetID);
        hash = 89 * hash + Objects.hashCode(this.nazivPredmeta);
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
        final DCPredmet other = (DCPredmet) obj;
        if (!Objects.equals(this.predmetID, other.predmetID)) {
            return false;
        }
        return true;
    }

    @Override
    public void setKey(ResultSet rs) {
        try {
            if (rs.next()) {
                predmetID = rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DCPredmet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return nazivPredmeta;
    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Predmet.PREDMET_ID:
                return predmetID;
            case Constants.Predmet.NAZIV_PREDMETA:
                return nazivPredmeta;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Predmet.PREDMET_ID};
    }
    
    

}
