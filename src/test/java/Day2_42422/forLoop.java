package Day2_42422;

import java.util.ArrayList;

public class forLoop {
    public static void main(String[] args) {
        //create an array list for cities and loop/iterate through the values using the loop
        ArrayList<String> cities = new ArrayList<> ();
        cities.add("A");
        cities.add("B");
        cities.add("C");
        cities.add("D");
        cities.add("E");
        cities.add("F");
        cities.add("G");
        for (int i=0; i< cities.size();i++){  // i++ IS MORE LIKE 1+1
           // System.out.println("i is now "+i);
            System.out.println("My city is "+ cities.get(i));
        }//end of loop


    }//end of method
}//end of java class
