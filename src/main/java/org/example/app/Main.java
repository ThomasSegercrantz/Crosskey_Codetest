package org.example.app;

import java.util.ArrayList;
import java.util.List;

//This is the main class where code is run, first by creating all four prospects and then printing
//their information
public class Main {
    public static void main(String[] args) {
        List<Prospect> prospects = new ArrayList<>();
        Prospect prospect1 = new Prospect(1);
        prospects.add(prospect1);
        Prospect prospect2 = new Prospect(2);
        prospects.add(prospect2);
        Prospect prospect3 = new Prospect(3);
        prospects.add(prospect3);
        Prospect prospect4 = new Prospect(4);
        prospects.add(prospect4);

        System.out.println("****************************************************************************************************");
        for(Prospect prospect : prospects) {
            prospect.prospectSetup();
            System.out.print("Prospect " + prospect.getNumber() + ": " + prospect.getName() + " wants to borrow " + prospect.getLoan() + "€ for a period of "
                    + prospect.getYears() + " years and pay ");
            //We format to print the mortgage with 2 decimal accuracy
            System.out.printf("%.2f", prospect.getMortgage());
            System.out.println("€ each month");
            System.out.println("****************************************************************************************************");
        }
    }
}
