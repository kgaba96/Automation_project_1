package ActionItems;

import java.util.ArrayList;

public class Automation_Al02_prt02 {
    public static void main(String[] args) {

        // create an array with cities and print only when city is Brooklyn or Manhattan.

        ArrayList< String> city = new ArrayList<>();
        city.add("Brooklyn");
        city.add("Queens");
        city.add("Bronx");
        city.add("Manhattan");

        for (int i = 0; i < city.size(); i++) // for loop - we used city.size because we used an arraylist.
        if(city.get(i) == "Brooklyn" || city.get(i) == "Manhattan"){
             System.out.println("My City is " + city.get(i) + ".");
        }// end of condition

        }// end of method

    }// end of java class

