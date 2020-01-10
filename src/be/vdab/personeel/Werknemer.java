package be.vdab.personeel;

import be.vdab.util.Datum;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public abstract class Werknemer implements Comparable<Werknemer>, Serializable {
    private static final long serialVersionUID = 1L;
    private final int PERSONEELSNUMMER;
    private Geslacht geslacht;
    private String naam;
    private WerknemersDatum datumInDienst;

    public Werknemer(int personeelsnummer, Geslacht geslacht, String naam, WerknemersDatum datumInDienst) {
        this.geslacht = geslacht;
        this.naam = naam;
        this.datumInDienst = datumInDienst;
        this.PERSONEELSNUMMER = setPersoneelsnummer(personeelsnummer) ;
    }

    public String getNaam() {
        return naam;
    }

    private int setPersoneelsnummer(int personeelsnummer) {
        if (personeelsnummer > 0) {
            return personeelsnummer;
        } else return -1;
    }

    public int getPERSONEELSNUMMER() {
        return PERSONEELSNUMMER;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public Datum getDatumInDienst() {
        return datumInDienst;
    }

    public static Comparator<Werknemer> sorteerOpNaam() {
        return Comparator.comparing(Werknemer::getNaam);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(PERSONEELSNUMMER).append('\t').append(datumInDienst).append('\t').append(naam).append('\t').append(geslacht);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Werknemer)) {
            return false;
        }
        Werknemer v = (Werknemer) o;
        return PERSONEELSNUMMER == v.PERSONEELSNUMMER;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PERSONEELSNUMMER);
    }

    @Override
    public int compareTo(Werknemer o) {
        return PERSONEELSNUMMER - o.PERSONEELSNUMMER;
    }

    public abstract BigDecimal getVerloning();
}
