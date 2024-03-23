package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exception.EntityFileNotFound;
import exception.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
        	// Data file path
            String pathFile = "src/input.txt";

            // Creating a BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));

            Lawn lawn = parseLawn(reader.readLine());

            List<Mower> mowers = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                Mower mower = parseMower(line);
                mower.executeInstructions(reader.readLine(), lawn);
                mowers.add(mower);
            }

            mowers.stream().forEach(mower -> {
                System.out.println(mower.getPosition());
            });

            reader.close();
        } catch (FileNotFoundException e) {
            new FileNotFoundException("Fichier n'existe pas");
        }

    }

    private static Lawn parseLawn(String line) {
        String[] tokens = line.split(" ");
        int maxX = Integer.parseInt(tokens[0]);
        int maxY = Integer.parseInt(tokens[1]);
        return new Lawn(maxX, maxY);
    }

    private static Mower parseMower(String line) {
        String[] tokens = line.split(" ");
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        char orientation = tokens[2].charAt(0);
        return new Mower(x, y, orientation);
    }

}
