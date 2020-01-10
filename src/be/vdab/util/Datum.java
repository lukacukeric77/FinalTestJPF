package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;
import java.lang.Comparable;

public class Datum implements IDatum, Comparable<Datum>, Serializable {

    private int dag;
    private int maand;
    private int jaar;

    public Datum(int jaar, int maand, int dag) {
        setJaar(jaar);
        setMaand(maand);
        setDag(dag);
    }

    private void setDag(int dag) {
        if ((maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12) && (dag >= 1 && dag <= 31)) {
            this.dag = dag;
        } else if ((maand == 4 || maand == 6 || maand == 9 || maand == 11) && (dag >= 1 && dag <= 30)) {
            this.dag = dag;
        } else if (dag <= 29 && maand == 2 && leapYearCheck(jaar) == 1) {
            this.dag = dag;
        } else if (leapYearCheck(jaar) == 0 && maand == 2 && dag <= 28) {
            this.dag = dag;
        } else
            throw new DatumException("DAY is not correct. It could also be that the combination of the leap year and/or month is making this mistake.");
    }

    private void setMaand(int maand) {
        if (maand >= 1 && maand <= 12) {
            this.maand = maand;
        } else throw new DatumException("MONTH is not correct.");
    }

    private void setJaar(int jaar) {
        if (jaar >= 1584 && jaar <= 4099) {
            this.jaar = jaar;
        } else throw new DatumException("YEAR is not correct.");
    }

    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;
    }

    public int getJaar() {
        return jaar;
    }


    private int leapYearCheck(int jaar) {
        return (jaar % 4 == 0 || jaar % 100 == 0 && jaar % 400 == 0) ? 1 : 0;
    }

    @Override
    public String toString() {
        return String.valueOf(dag) + '/' + maand + '/' + jaar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datum datum = (Datum) o;
        return dag == datum.dag &&
                maand == datum.maand &&
                jaar == datum.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag + maand + jaar);
    }

    @Override
    public int compareTo(Datum o) {

        int yearCheck = this.jaar - o.getJaar();
        int monthCheck = this.maand - o.getMaand();
        int dayCheck = this.dag - o.getDag();

        if (yearCheck != 0) {
            return yearCheck;
        } else if (monthCheck != 0) {
            return monthCheck;
        } else return dayCheck;

    }
}
