/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.constants;

/**
 *
 * @author MARINA
 */
public class Constants {

    public static final String URL = "url";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public class TemaDiplomskogRada {

        public static final String CLASS_NAME = "tema_diplomskog_rada";
        public static final String TEMA_ID = "tema_id";
        public static final String NAZIV_TEME = "naziv_teme";
        public static final String OPIS_TEME = "opis_teme";
        public static final String PREDMET_ID_FK = "predmet_id_fk";
    }

    public class Student {

        public static final String CLASS_NAME = "student";
        public static final String BROJ_INDEKSA = "broj_indeksa";
        public static final String JMBG = "jmbg";
        public static final String IME = "ime";
        public static final String PREZIME = "prezime";
        public static final String BUDZET = "budzet";
        public static final String GODINA_STUDIJA = "godina_studija";
        public static final String DATUM_RODJENJA = "datum_rodjenja";
        public static final String PRVI_PUT_UPISAO = "prvi_put_upisao";
    }

    public class Predmet {

        public static final String CLASS_NAME = "predmet";
        public static final String PREDMET_ID = "predmet_id";
        public static final String NAZIV_PREDMETA = "naziv_predmeta";
    }

    public class Nastavnik {

        public static final String CLASS_NAME = "nastavnik";
        public static final String NASTAVNIK_ID = "nastavnik_id";
        public static final String IME_NASTAVNIKA = "ime_nastavnika";
        public static final String PREZIME_NASTAVNIK = "prezime_nastavnika";
        public static final String BROJ_RADNE_KNJIZICE = "broj_radne_knjizice";
        public static final String JMBG = "jmbg";
        public static final String ZVANJE = "zvanje";
        public static final String TITULA = "titula";
    }

    public class DiplomskiRad {

        public static final String CLASS_NAME = "diplomski_rad";
        public static final String TEMA_ID_FK = "tema_id_fk";
        public static final String BROJ_INDEKSA_FK = "broj_indeksa_fk";
        public static final String KOMISIJA_ID_FK = "komisija_id_fk";
        public static final String DATUM_PRIJAVE = "datum_prijave";
        public static final String DATUM_KAD_JE_ODOBREN = "datum_kad_je_odobren";
        public static final String DATUM_ODBRANE = "datum_odbrane";
        public static final String STATUS = "status";
        public static final String OCENA = "ocena";
    }

    public class Komisija {

        public static final String CLASS_NAME = "komisija";
        public static final String KOMISIJA_ID = "komisija_id";
    }

    public class ClanKomisije {

        public static final String CLASS_NAME = "clan_komisije";
        public static final String KOMISIJA_ID_FK = "komisija_id_fk";
        public static final String CLAN_KOMISIJE_RB = "clan_komisije_rb";
        public static final String ULOGA_CLANA_KOMISIJE = "uloga_clana_komisije";
        public static final String NASTAVNIK_ID_FK = "nastavnik_id_fk";
    }

    public class SkolskaGodina {

        public static final String CLASS_NAME = "skolska_godina";
        public static final String SKOLSKA_GODINA = "skolska_godina";
        public static final String AKTIVNA = "aktivna";
    }

    public class SOCall {

        public static final String SO_SAVE = "save";
        public static final String SO_UPDATE = "update";
        public static final String SO_SAVE_LIST = "save_list";
        public static final String SO_GENERATE_BROJ_INDEKSA = "generate_broj_indeksa";
        public static final String SO_FIND_ALL = "find_all";
        public static final String SO_FIND_WHERE = "find_where";
        public static final String SO_FIND_BY_ID = "find_by_id";
    }
}
