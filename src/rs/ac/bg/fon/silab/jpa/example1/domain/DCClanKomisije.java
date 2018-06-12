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
public class DCClanKomisije implements GeneralDObject, ChildDObject, Serializable {

    private DCKomisija komisija;
    private int clanKomisijeRB;
    private DCNastavnik nastavnik;
    private EUlogaClanaKomisije ulogaClanaKomisije;

    public DCClanKomisije() {
    }

    public DCClanKomisije(DCKomisija komisija, int clanKomisijeRB, DCNastavnik nastavnik, EUlogaClanaKomisije ulogaClanaKomisije) {
        this.komisija = komisija;
        this.clanKomisijeRB = clanKomisijeRB;
        this.nastavnik = nastavnik;
        this.ulogaClanaKomisije = ulogaClanaKomisije;
    }

    public DCClanKomisije(DCKomisija komisija, int clanKomisijeRB) {
        this.komisija = komisija;
        this.clanKomisijeRB = clanKomisijeRB;
    }

    public DCClanKomisije(int clanKomisijeRB, DCNastavnik nastavnik, EUlogaClanaKomisije ulogaClanaKomisije) {

        this.clanKomisijeRB = clanKomisijeRB;
        this.nastavnik = nastavnik;
        this.ulogaClanaKomisije = ulogaClanaKomisije;
    }

    public DCClanKomisije(DCKomisija komisija) {
        this.komisija = komisija;
    }

    @Override
    public String getAtrValue() {
        return komisija.getKomisijaID() + "," + clanKomisijeRB + "," + nastavnik.getNastavnikID() + ",'" + ulogaClanaKomisije + "'";
    }

    @Override
    public String setAtrValue() {
        return Constants.ClanKomisije.KOMISIJA_ID_FK + "=" + komisija.getKomisijaID() + "," + Constants.ClanKomisije.CLAN_KOMISIJE_RB + "=" + clanKomisijeRB + "," + Constants.ClanKomisije.NASTAVNIK_ID_FK + "=" + nastavnik.getNastavnikID() + "," + Constants.ClanKomisije.ULOGA_CLANA_KOMISIJE + "='" + ulogaClanaKomisije.name() + "'";
    }

    @Override
    public String getClassName() {
        return Constants.ClanKomisije.CLASS_NAME;
    }

    @Override
    public String getColumnNames() {
        return Constants.ClanKomisije.KOMISIJA_ID_FK + "," + Constants.ClanKomisije.CLAN_KOMISIJE_RB + "," + Constants.ClanKomisije.NASTAVNIK_ID_FK + "," + Constants.ClanKomisije.ULOGA_CLANA_KOMISIJE;
    }

    @Override
    public String getWhereCondition() {
        return Constants.ClanKomisije.KOMISIJA_ID_FK + "=" + komisija.getKomisijaID() + " AND " + Constants.ClanKomisije.CLAN_KOMISIJE_RB + "=" + clanKomisijeRB;
    }

    @Override
    public String getNameByColumn(int column) {
        String[] columnNames = new String[]{Constants.ClanKomisije.KOMISIJA_ID_FK, Constants.ClanKomisije.CLAN_KOMISIJE_RB, Constants.ClanKomisije.NASTAVNIK_ID_FK, Constants.ClanKomisije.ULOGA_CLANA_KOMISIJE};
        return columnNames[column];
    }

    @Override
    public void checkConstraints() throws Exception {
        if (nastavnik == null || ulogaClanaKomisije == null) {
            throw new Exception("Not all fields for the member " + clanKomisijeRB + " had been filled");
        }
    }

    public DCKomisija getKomisija() {
        return komisija;
    }

    public void setKomisija(DCKomisija komisija) {
        this.komisija = komisija;
    }

    public int getClanKomisijeRB() {
        return clanKomisijeRB;
    }

    public void setClanKomisijeRB(int clanKomisijeRB) {
        this.clanKomisijeRB = clanKomisijeRB;
    }

    public DCNastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(DCNastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public EUlogaClanaKomisije getUlogaClanaKomisije() {
        return ulogaClanaKomisije;
    }

    public void setUlogaClanaKomisije(EUlogaClanaKomisije ulogaClanaKomisije) {
        this.ulogaClanaKomisije = ulogaClanaKomisije;
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
        final DCClanKomisije other = (DCClanKomisije) obj;
        if (this.clanKomisijeRB != other.clanKomisijeRB) {
            return false;
        }
        if (!Objects.equals(this.komisija, other.komisija)) {
            return false;
        }
        return true;
    }

    @Override
    public void setKey(ResultSet rs) {

    }

    @Override
    public String getParentWhere() {
        return Constants.ClanKomisije.KOMISIJA_ID_FK + "=" + komisija.getKomisijaID();
    }

    @Override
    public String[] returnUniqueColumns() {
        return new String[]{Constants.ClanKomisije.CLAN_KOMISIJE_RB, Constants.ClanKomisije.NASTAVNIK_ID_FK};
    }

    @Override
    public Object getValue(String column) {
        switch (column) {
            case Constants.ClanKomisije.KOMISIJA_ID_FK:
                return komisija;
            case Constants.ClanKomisije.CLAN_KOMISIJE_RB:
                return clanKomisijeRB;
            case Constants.ClanKomisije.NASTAVNIK_ID_FK:
                return nastavnik;
            case Constants.ClanKomisije.ULOGA_CLANA_KOMISIJE:
                return ulogaClanaKomisije;
            default:
                return null;
        }
    }

    @Override
    public String [] getPrimaryKeyColumns() {
        return new String[]{Constants.ClanKomisije.KOMISIJA_ID_FK,Constants.ClanKomisije.CLAN_KOMISIJE_RB};
    }
    
    

}
