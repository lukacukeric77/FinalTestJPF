package be.vdab.personeel;

import be.vdab.util.Datum;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Arbeider extends Werknemer implements Serializable {
    private static final long serialVersionUID = 1L;
    private BigDecimal uurloon;

    public Arbeider(int personeelsnummer, Geslacht geslacht, String naam, WerknemersDatum datumInDienst, BigDecimal uurloon) {
        super(personeelsnummer, geslacht, naam, datumInDienst);
        setUurloon(uurloon);
    }

    public BigDecimal getUurloon() {
        return uurloon;
    }

    public void setUurloon(BigDecimal uurloon) {
        if (uurloon.compareTo(BigDecimal.valueOf(9.76))>0.0){
        this.uurloon = uurloon;} else throw new WerknemerException("Minimum hour rate must be bigger than 9.76");
    }

    @Override
    public BigDecimal getVerloning() {
       return uurloon.multiply(BigDecimal.valueOf(7.6)).multiply(BigDecimal.valueOf(65)).divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.getPERSONEELSNUMMER()).append('\t').append(super.getDatumInDienst()).append('\t')
                .append(super.getNaam()).append('\t').append(super.getGeslacht()).append('\t').append(uurloon.setScale(2, RoundingMode.HALF_UP)).append('\t').append(getVerloning());
        return builder.toString();
    }
}
