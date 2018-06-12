/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.jpa.example1.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import rs.ac.bg.fon.silab.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCSkolskaGodina implements GeneralDObject, Serializable {

    private String skolskaGodina;
    private boolean aktivna;

    public DCSkolskaGodina() {
    }

    public DCSkolskaGodina(String skolskaGodina, boolean aktivna) {
        this.skolskaGodina = skolskaGodina;
        this.aktivna = true;
    }

    @Override
    public String getAtrValue() {
        return "'" + skolskaGodina + "'," + aktivna;
    }

    @Override
    public String setAtrValue() {
        return Constants.SkolskaGodina.SKOLSKA_GODINA + "='" + skolskaGodina + "'," + Constants.SkolskaGodina.AKTIVNA + "=" + aktivna;
    }

    @Override
    public String getClassName() {
        return Constants.SkolskaGodina.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.SkolskaGodina.SKOLSKA_GODINA + "," + Constants.SkolskaGodina.AKTIVNA;
    }

    @Override
    public String getWhereCondition() {
        return Constants.SkolskaGodina.SKOLSKA_GODINA + "='" + skolskaGodina + "'";
    }

    @Override
    public String getNameByColumn(int column) {
        String[] columnNames = new String[]{Constants.SkolskaGodina.SKOLSKA_GODINA, Constants.SkolskaGodina.AKTIVNA};
        return columnNames[column];
    }

    @Override
    public void checkConstraints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setKey(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(String skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public boolean isAktivna() {
        return aktivna;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.SkolskaGodina.SKOLSKA_GODINA:
                return skolskaGodina;
            case Constants.SkolskaGodina.AKTIVNA:
                return aktivna;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.SkolskaGodina.SKOLSKA_GODINA};
    }
    
    

}
