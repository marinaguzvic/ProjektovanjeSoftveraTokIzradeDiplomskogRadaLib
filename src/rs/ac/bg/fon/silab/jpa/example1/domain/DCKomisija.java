/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.jpa.example1.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import rs.ac.bg.fon.silab.constants.Constants;

/**
 *
 * @author MARINA
 */
public class DCKomisija implements GeneralDObject, CompundDObject, Serializable {

    private Long komisijaID;
    private List<DCClanKomisije> clanovi;

    public DCKomisija() {
        clanovi = new ArrayList<>();
    }

    public DCKomisija(Long komisijaID, List<DCClanKomisije> clanovi) {
        this.komisijaID = komisijaID;
        this.clanovi = clanovi;
    }

    public DCKomisija(Long komisijaID) {
        this.komisijaID = komisijaID;
        clanovi = new ArrayList<>();
    }

    @Override
    public String getAtrValue() {
        return "";
    }

    @Override
    public String setAtrValue() {
        return "";
    }

    @Override
    public String getClassName() {
        return Constants.Komisija.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return "";
    }

    @Override
    public String getWhereCondition() {
        return Constants.Komisija.KOMISIJA_ID + "=" + komisijaID;
    }

    @Override
    public String getNameByColumn(int column) {
        return Constants.Komisija.KOMISIJA_ID;
    }

    @Override
    public void checkConstraints() throws Exception {
        for (int i = 0; i < clanovi.size() - 1; i++) {
            for (int j = i + 1; j < clanovi.size(); j++) {
                if (clanovi.get(i).equals(clanovi.get(j))) {
                    throw new Exception("Member " + (i + 1) + " and member " + (j + 1) + "are the same");
                }
            }
        }
        if (clanovi.size() >= 5) {
            throw new Exception("There are 5 members, if you want to add a new one, you have to delete one first!");
        }
        boolean hasMentor = false;
        for (DCClanKomisije dCClanKomisije : clanovi) {
            if (dCClanKomisije.getUlogaClanaKomisije().equals(EUlogaClanaKomisije.MENTOR)) {
                hasMentor = true;
            }
            dCClanKomisije.checkConstraints();
        }
        if (!hasMentor) {
            throw new Exception("Mentor has to be defined!");
        }
    }

    public Long getKomisijaID() {
        return komisijaID;
    }

    public void setKomisijaID(Long komisijaID) {
        this.komisijaID = komisijaID;
    }

    public List<DCClanKomisije> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<DCClanKomisije> clanovi) {
        this.clanovi = clanovi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.komisijaID);
        hash = 43 * hash + Objects.hashCode(this.clanovi);
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
        final DCKomisija other = (DCKomisija) obj;
        if (!Objects.equals(this.komisijaID, other.komisijaID)) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> classNames() {
        List<String> classNames = new ArrayList<>();
        classNames.add(Constants.ClanKomisije.CLASS_NAME);
        return classNames;
    }

    @Override
    public List<GeneralDObject> getItemsFor(String className) {
        switch (className) {
            case Constants.ClanKomisije.CLASS_NAME:
                return new ArrayList<>(clanovi);
            default:
                return null;
        }

    }

    @Override
    public void setKey(ResultSet rs) throws Exception {
        try {
            if (rs.next()) {
                komisijaID = rs.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("The key was not returned");
        }
    }

    @Override
    public GeneralDObject createChild(String className) {
        switch (className) {
            case Constants.ClanKomisije.CLASS_NAME:
                return new DCClanKomisije(this);
            default:
                return null;
        }
    }

    @Override
    public String getWhere(String className) {
        switch (className) {
            case Constants.ClanKomisije.CLASS_NAME:
                return Constants.ClanKomisije.KOMISIJA_ID_FK + "=" + komisijaID;
            default:
                return null;
        }
    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.Komisija.KOMISIJA_ID:
                return komisijaID;
            default:
                return null;
        }
    }

    @Override
    public String[] getPrimaryKeyColumns() {
        return new String[]{Constants.Komisija.KOMISIJA_ID};
    }

    
}
