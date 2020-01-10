package be.vdab.personeel;

import be.vdab.personeel.kader.Functietitel;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.Geslacht;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bedrijf implements Serializable {
    private static final long serialVersionUID = 1L;
    List<Werknemer> bedrijfslist = new ArrayList<>();

    public Bedrijf() {
    }

    public List<Werknemer> getBedrijfslist() {
        return bedrijfslist;
    }

    public void voegWerknemerToe(Werknemer werknemer) {
        if (!bedrijfslist.contains(werknemer) ) {
            bedrijfslist.add(werknemer);
        }
    }

    public void gesorteerdeLijst() {
        bedrijfslist.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    public void gesorteeerdeLijstOpNaam() {
        bedrijfslist.stream().sorted(Werknemer.sorteerOpNaam()).forEach(System.out::println);
    }

    public void listVanArbeiders() {
        bedrijfslist.stream().filter(werknemer -> werknemer instanceof Arbeider).forEach(System.out::println);
    }

    public double percentageMannelijkeWerknemers() {
        return (double) bedrijfslist.stream().filter(werknemer -> werknemer.getGeslacht().equals(Geslacht.M)).count()*100/bedrijfslist.size();
    }


    public void listVanManagers() {
        bedrijfslist.stream().filter(werknemer -> werknemer instanceof Kaderlid)
                .map(werknemer -> ((Kaderlid) werknemer).getFunctietitel().equals(Functietitel.MANAGER)).forEach(System.out::println);
    }

    public void printLijst() {
        bedrijfslist.stream().collect(Collectors.groupingBy(Werknemer::getNaam)).entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        });
    }


    public void save() {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("/data/personeel.dat")))) {
            stream.writeObject(bedrijfslist);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
