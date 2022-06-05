package ActionItems.practice;

import java.util.ArrayList;

public class z15 {
    public static void main (String [] args){

        String myname= "JL";

        int myage= 12;
        System.out.println("My name is " + myname + " and my age is " + myage + ".");

        String [] LES;
        LES = new String [] {"abc", "def"};
        System.out.println("My name is " + LES[0]+ " and my age is " + LES[1]+ ".");


        ArrayList<String> ALS = new ArrayList<>();
        ALS.add("ggg");
        ALS.add("xxx");
        System.out.println("My name is " + ALS.get(0)+ " and my age is " + ALS.get(1)+ ".");

        for(int i =0; i < LES.length; i++){
            System.out.println(" For loop linear array name is " + LES[i]);

        } // end of loop


        int j = 0;

        while(j<ALS.size()){

            System.out.println(" While loop Array LIST name is " + ALS.get(j));

            j++;
        }//end of while loop


    }//end of main method

}//end of class
