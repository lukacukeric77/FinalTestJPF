package be.vdab.personeel;

import be.vdab.util.Datum;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bediende extends Werknemer implements Serializable {
    private static final long serialVersionUID = 1L;
    private BigDecimal maandweede;

    public Bediende(int personeelsnummer, Geslacht geslacht, String naam, WerknemersDatum datumInDienst, BigDecimal maandweede) {
        super(personeelsnummer, geslacht, naam, datumInDienst);
        this.maandweede = maandweede;
    }

    public BigDecimal getMaandweede() {
        return maandweede;
    }

    public void setMaandweede(BigDecimal maandweede) {
        if (maandweede.compareTo(BigDecimal.valueOf(1129.47))>0.0){
            this.maandweede = maandweede;} else throw new WerknemerException("Minimum monthly salary must be bigger than 1129.47");
    }

    @Override
    public BigDecimal getVerloning() {
        return maandweede;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.getPERSONEELSNUMMER()).append('\t').append(super.getDatumInDienst()).append('\t')
                .append(super.getNaam()).append('\t').append(super.getGeslacht()).append('\t')
                .append(maandweede.setScale(2, RoundingMode.HALF_UP)).append('\t').append(getVerloning());
        return builder.toString();
    }
}
