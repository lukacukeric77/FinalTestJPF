package be.vdab.personeel.kader;

import be.vdab.personeel.Bediende;
import be.vdab.util.Datum;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;

public class Kaderlid extends Bediende implements Serializable {
    private static final long serialVersionUID = 1L;
    private Functietitel functietitel;

    public Kaderlid(int personeelsnummer, Geslacht geslacht, String naam, WerknemersDatum datumInDienst, BigDecimal maandweede, Functietitel functietitel) {
        super(personeelsnummer, geslacht, naam, datumInDienst, maandweede);
        setFunctietitel(functietitel);
    }

    public Functietitel getFunctietitel() {
        return functietitel;
    }

    public void setFunctietitel(Functietitel functietitel) {
        if (functietitel != null){
        this.functietitel = functietitel;}
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(super.toString()).append('\t').append(getFunctietitel()).toString();
    }


}
