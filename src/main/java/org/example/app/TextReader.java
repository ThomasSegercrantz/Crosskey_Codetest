package org.example.app;
import java.io.*;

//This class reads information from the "prospects.txt" file, and based on the linenumber parses the information into
//individual variables
public class TextReader {
    int prospectsNumber;
    private String name;
    private double loan;
    private double interest;
    private int years;

    public TextReader(int i) {
        prospectsNumber = i;
    }

    public void read(){
        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("prospects.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Skip to correct line
            for (int i = 0; i< prospectsNumber; i++) {
                reader.readLine();
            }

            // Read data
            String data = reader.readLine();
            String[] components = data.split(",");

            name = components[0];
            for (int i = 1; i < components.length - 3; i++) {
                name += "," + components[i];
            }

            loan = Double.parseDouble(components[components.length - 3]);
            interest = Double.parseDouble(components[components.length - 2]);
            years = Integer.parseInt(components[components.length - 1]);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public double getLoan() {
        return loan;
    }

    public double getInterest() {
        return interest;
    }

    public int getYears() {
        return years;
    }
}
