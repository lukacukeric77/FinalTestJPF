package be.vdab;

import be.vdab.personeel.Werknemer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Zusterbedrijf {

    public void load() throws IOException, ClassNotFoundException {

        try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(Paths.get("/data/personeel.dat")))) {

            System.out.println(stream.readObject());

        } catch(IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
