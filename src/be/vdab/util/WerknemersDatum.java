package be.vdab.util;

import java.io.Serializable;

public class WerknemersDatum extends Datum implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Datum OPRICHTINGSDATUM = new Datum(1977,2,12);

    public WerknemersDatum(int jaar, int maand, int dag) {
        super(jaar, maand, dag);
    checkDate(jaar, maand, dag);
    }



    private Datum checkDate(int jaar, int maand, int dag){
        Datum entryDatum = new Datum(jaar, maand, dag);

        if (entryDatum.compareTo(OPRICHTINGSDATUM)>=0){
            return entryDatum;
        } else throw new WerknemerException("The entry datum is before the firm existed.");

    }


}
