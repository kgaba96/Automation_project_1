package ActionItems;

import java.util.ArrayList;

public class ArrayLinearArrayListLoop {
    public static void main(String[] args) {


        // ArrayList and for Loop
        System.out.println(" ");
        System.out.println("ArrayList plus for Loop.");

        ArrayList<String> country =new ArrayList<>();
        country.add("Argentina");
        country.add("Brazil");
        country.add("Spain");
        country.add("England");


        ArrayList<Integer>countryCode= new ArrayList<Integer>();
        countryCode.add(54);
        countryCode.add(55);
        countryCode.add(34);
        countryCode.add(44);

        for(int i=0;i< country.size(); i++ ){

            System.out.println("My country is "+ country.get(i)+ " and my country code is "+ countryCode.get(i)+ ".");
        }// end of for loop

        System.out.println(" ");


        // Linear Array and while loops
        System.out.println(" Linear Array plus while loop.");

        String[] region = new String[]{"Brooklyn", "Queens", "Bronx", "Manhattan"};
        int[] regionCode = new int[]{718,646,347,917};

        int i = 0;
        while (i <region.length){

            System.out.println("My region is "+ region[i]+ " and my region code is "+ regionCode[i]+ ".");

            i++;

        }//end of while loop and Linear Array


    }//end of method
}//end of java class
