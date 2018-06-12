/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.jpa.example1.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Objects;
import rs.ac.bg.fon.silab.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCDiplomskiRad implements GeneralDObject, Serializable {

    private DCTemaDiplomskogRada temaDiplomskogRada;
    private DCStudent student;
    private DCKomisija komisija;
    private LocalDate datumPrijave;
    private LocalDate datumKadJeOdobren;
    private LocalDate datumOdbrane;
    private EStatus status;
    private int ocena;

    public DCDiplomskiRad(DCStudent student) {
        this.temaDiplomskogRada = null;
        this.student = student;
        this.komisija = null;
        this.datumPrijave = null;
        this.datumKadJeOdobren = null;
        this.datumOdbrane = null;
        this.status = null;
        this.ocena = 0;
    }

    public DCDiplomskiRad(DCTemaDiplomskogRada temaDiplomskogRada, DCStudent student, DCKomisija komisija, LocalDate datumPrijave, LocalDate datumKadJeOdobren, LocalDate datumOdbrane, EStatus status, int ocena) {
        this.temaDiplomskogRada = temaDiplomskogRada;
        this.student = student;
        this.komisija = komisija;
        this.datumPrijave = datumPrijave;
        this.datumKadJeOdobren = datumKadJeOdobren;
        this.datumOdbrane = datumOdbrane;
        this.status = status;
        this.ocena = ocena;
    }

    public DCDiplomskiRad() {
        this.temaDiplomskogRada = null;
        this.student = null;
        this.komisija = null;
        this.datumPrijave = null;
        this.datumKadJeOdobren = null;
        this.datumOdbrane = null;
        this.status = null;
        this.ocena = 0;
    }

    @Override
    public String getAtrValue() {

        return temaDiplomskogRada.getTemaID() + ", '" + student.getBrojIndeksa() + "', " + (komisija == null ? "null" : komisija.getKomisijaID()) + "," + (datumPrijave == null ? "null" : ("'" + Date.valueOf(datumPrijave) + "'")) + "," + (datumKadJeOdobren == null ? "null" : ("'" + Date.valueOf(datumKadJeOdobren) + "'")) + "," + (datumOdbrane == null ? "null" : ("'" + Date.valueOf(datumOdbrane)
                + "'")) + ", '" + status.name() + "', " + ocena;
    }

    @Override
    public String setAtrValue() {
        return Constants.DiplomskiRad.TEMA_ID_FK + "=" + temaDiplomskogRada.getTemaID() + "," + Constants.DiplomskiRad.BROJ_INDEKSA_FK + "='" + student.getBrojIndeksa() + "'," + Constants.DiplomskiRad.KOMISIJA_ID_FK + "=" + (komisija == null ? "null" : komisija.getKomisijaID()) + "," + Constants.DiplomskiRad.DATUM_PRIJAVE + "=" + (datumPrijave == null ? "null" : ("'" + Date.valueOf(datumPrijave) + "'")) + "," + Constants.DiplomskiRad.DATUM_KAD_JE_ODOBREN + "=" + (datumKadJeOdobren == null ? "null" : ("'" + Date.valueOf(datumKadJeOdobren) + "'"))
                + "," + Constants.DiplomskiRad.DATUM_ODBRANE + "=" + (datumOdbrane == null ? "null" : ("'" + Date.valueOf(datumOdbrane) + "'")) + "," + Constants.DiplomskiRad.STATUS + "='" + status.name() + "'," + Constants.DiplomskiRad.OCENA + "=" + ocena;
    }

    @Override
    public String getClassName() {
        return Constants.DiplomskiRad.CLASS_NAME;
    }

    @Override
    public String getWhereCondition() {
        return Constants.DiplomskiRad.BROJ_INDEKSA_FK + "='" + student.getBrojIndeksa() + "'";
    }

    @Override
    public String getNameByColumn(int column) {
        String[] columnNames = new String[]{Constants.DiplomskiRad.TEMA_ID_FK, Constants.DiplomskiRad.BROJ_INDEKSA_FK, Constants.DiplomskiRad.KOMISIJA_ID_FK, Constants.DiplomskiRad.DATUM_PRIJAVE, Constants.DiplomskiRad.DATUM_KAD_JE_ODOBREN, Constants.DiplomskiRad.DATUM_ODBRANE, Constants.DiplomskiRad.STATUS, Constants.DiplomskiRad.OCENA};
        return columnNames[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        checkPrijavljen();
        switch (status) {
            case PRIJAVLJEN:
                checkPrijavljen();
                break;
            case ODOBREN:
                checkPrijavljen();
                checkOdobren();
                break;
            case ODBRANJEN:
                checkPrijavljen();
                checkOdobren();
                checkOdbranjen();
                break;
        }
    }

    private void checkPrijavljen() throws Exception {
        if (student == null) {
            throw new Exception("Student has to be set!");
        }
        if (temaDiplomskogRada == null) {
            throw new Exception("Tema has to be set!");
        }
        if (datumPrijave == null) {
            throw new Exception("Datum prijave is not set");
        }
    }

    @Override
    public String getColumnNames() {
        return Constants.DiplomskiRad.TEMA_ID_FK + "," + Constants.DiplomskiRad.BROJ_INDEKSA_FK + "," + Constants.DiplomskiRad.KOMISIJA_ID_FK + "," + Constants.DiplomskiRad.DATUM_PRIJAVE + "," + Constants.DiplomskiRad.DATUM_KAD_JE_ODOBREN + "," + Constants.DiplomskiRad.DATUM_ODBRANE + "," + Constants.DiplomskiRad.STATUS + "," + Constants.DiplomskiRad.OCENA;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.temaDiplomskogRada);
        hash = 61 * hash + Objects.hashCode(this.student);
        hash = 61 * hash + Objects.hashCode(this.komisija);
        hash = 61 * hash + Objects.hashCode(this.datumPrijave);
        hash = 61 * hash + Objects.hashCode(this.datumKadJeOdobren);
        hash = 61 * hash + Objects.hashCode(this.datumOdbrane);
        hash = 61 * hash + Objects.hashCode(this.status);
        hash = 61 * hash + this.ocena;
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
        final DCDiplomskiRad other = (DCDiplomskiRad) obj;
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return true;
    }

    @Override
    public void setKey(ResultSet rs) {

    }

    public DCTemaDiplomskogRada getTemaDiplomskogRada() {
        return temaDiplomskogRada;
    }

    public void setTemaDiplomskogRada(DCTemaDiplomskogRada temaDiplomskogRada) {
        this.temaDiplomskogRada = temaDiplomskogRada;
    }

    public DCStudent getStudent() {
        return student;
    }

    public void setStudent(DCStudent student) {
        this.student = student;
    }

    public DCKomisija getKomisija() {
        return komisija;
    }

    public void setKomisija(DCKomisija komisija) {
        this.komisija = komisija;
    }

    public LocalDate getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(LocalDate datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public LocalDate getDatumKadJeOdobren() {
        return datumKadJeOdobren;
    }

    public void setDatumKadJeOdobren(LocalDate datumKadJeOdobren) {
        this.datumKadJeOdobren = datumKadJeOdobren;
    }

    public LocalDate getDatumOdbrane() {
        return datumOdbrane;
    }

    public void setDatumOdbrane(LocalDate datumOdbrane) {
        this.datumOdbrane = datumOdbrane;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.DiplomskiRad.TEMA_ID_FK:
                return temaDiplomskogRada;
            case Constants.DiplomskiRad.BROJ_INDEKSA_FK:
                return student;
            case Constants.DiplomskiRad.KOMISIJA_ID_FK:
                return komisija;
            case Constants.DiplomskiRad.DATUM_PRIJAVE:
                return datumPrijave;
            case Constants.DiplomskiRad.DATUM_KAD_JE_ODOBREN:
                return datumKadJeOdobren;
            case Constants.DiplomskiRad.DATUM_ODBRANE:
                return datumOdbrane;
            case Constants.DiplomskiRad.STATUS:
                return status;
            case Constants.DiplomskiRad.OCENA:
                return ocena;
            default:
                return null;

        }
    }

    private void checkOdobren() throws Exception {
        if (datumKadJeOdobren == null) {
            throw new Exception("Datum odbrane can't be null");
        }
        if (komisija == null) {
            throw new Exception("Komisija can't be null");
        }

    }

    private void checkOdbranjen() throws Exception {
        if (datumOdbrane == null) {
            throw new Exception("Datum odbrane can't be mull!");
        }
        if (ocena <= 5 || ocena > 10) {
            throw new Exception("Ocena is not in range 6-10!");
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.DiplomskiRad.BROJ_INDEKSA_FK};
    }

}
