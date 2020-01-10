package be.vdab;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Werknemer;
import be.vdab.personeel.kader.Functietitel;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.Datum;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;

import java.io.IOException;
import java.math.BigDecimal;

public class BedrijfApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Datum xy = new Datum(2001,3,45);  // day
//        Datum yy = new Datum(2000, 14, 11); // month
//        Datum zz = new Datum(9999, 3, 28); // year
//        Datum aa = new Datum(2000, 2, 29); //ok date
//        Datum bb = new Datum(2001, 2, 29); //leap year
//        System.out.println(aa);

//        WerknemersDatum falseDatum = new WerknemersDatum(1976, 1, 11);
//        System.out.println(falseDatum);

        WerknemersDatum datum1 = new WerknemersDatum(1999, 1, 28);
        WerknemersDatum datum2 = new WerknemersDatum(2001, 2, 18);
        WerknemersDatum datum3 = new WerknemersDatum(1998, 3, 3);
        WerknemersDatum datum4 = new WerknemersDatum(1979, 4, 7);
        WerknemersDatum datum5 = new WerknemersDatum(2011, 5, 15);
        WerknemersDatum datum6 = new WerknemersDatum(2020, 6, 30);
        WerknemersDatum datum7 = new WerknemersDatum(2015, 7, 31);
        WerknemersDatum datum8 = new WerknemersDatum(2019, 8, 22);
        WerknemersDatum datum9 = new WerknemersDatum(1977, 9, 1);

//        System.out.println(datum1);
//        System.out.println(datum2);
//        System.out.println(datum3);
//        System.out.println(datum4);
//        System.out.println(datum5);
//        System.out.println(datum6);
//        System.out.println(datum7);
//        System.out.println(datum8);
//        System.out.println(datum9);

        Arbeider arbeider1 = new Arbeider(12345, Geslacht.M, "Luke", datum1, new BigDecimal("25456.56"));
        Arbeider arbeider2 = new Arbeider(67898, Geslacht.V, "Leila", datum2, new BigDecimal("22222.22"));
        Arbeider arbeider3 = new Arbeider(5678, Geslacht.V, "Padme", datum3, new BigDecimal("33334.56"));

        Bediende bediende1 = new Bediende(78987, Geslacht.V, "Ahsoka", datum4, new BigDecimal("456789.55"));
        Bediende bediende2 = new Bediende(23456, Geslacht.M, "Moff", datum5, new BigDecimal("678945.55"));
        Bediende bediende3 = new Bediende(78888, Geslacht.V, "Jyn", datum6, new BigDecimal("998768.55"));

        Kaderlid kaderlid1 = new Kaderlid(987993, Geslacht.M, "Anakin", datum7, new BigDecimal("1000000.05"), Functietitel.MANAGER);
        Kaderlid kaderlid2 = new Kaderlid(987994, Geslacht.V, "Asajj", datum8, new BigDecimal("1500000.05"), Functietitel.DIRECTEUR);
        Kaderlid kaderlid3 = new Kaderlid(987996, Geslacht.M, "Marka", datum9, new BigDecimal("2000000.05"), Functietitel.CEO);
//
//        System.out.println(arbeider1);
//        System.out.println(arbeider2);
//        System.out.println(arbeider3);
//
//        System.out.println(bediende1);
//        System.out.println(bediende2);
//        System.out.println(bediende3);
//
//        System.out.println(kaderlid1);
//        System.out.println(kaderlid2);
//        System.out.println(kaderlid3);
//
//

        Bedrijf deathStar = new Bedrijf();
        deathStar.voegWerknemerToe(arbeider1);
        deathStar.voegWerknemerToe(arbeider2);
        deathStar.voegWerknemerToe(arbeider3);
        deathStar.voegWerknemerToe(bediende1);
        deathStar.voegWerknemerToe(bediende2);
        deathStar.voegWerknemerToe(bediende3);
        deathStar.voegWerknemerToe(kaderlid1);
        deathStar.voegWerknemerToe(kaderlid2);
        deathStar.voegWerknemerToe(kaderlid3);


//        System.out.println(deathStar.getBedrijfslist());;

        Zusterbedrijf korriban = new Zusterbedrijf();

        System.out.println("*****Sorted list naturally ******");
        deathStar.gesorteerdeLijst();

        System.out.println("*****Sorted list on name ******");
        deathStar.gesorteeerdeLijstOpNaam();

        System.out.println("*****Sorted list list of Arbeiders ******");
        deathStar.listVanArbeiders();

        System.out.println("***** Percentage of Mannen *****");
        System.out.println(deathStar.percentageMannelijkeWerknemers() + " %");

        System.out.println("***** Nicely printed list as in Stars and Albums *****");
        deathStar.printLijst();


        System.out.println("*** save and load ***");
        deathStar.save();
        korriban.load();


    }

}
