package ActionItems.practice;

import java.util.ArrayList;

public class Z11 {

public static void main (String[] args) {

    //trying string value with print.
    String stringTry1= "new order";
    System.out.println ("Trying my first code from heart" + stringTry1);

    // trying to add integer value
    int intTry1 = 12;
    System.out.println ("my Integer value is working "+ intTry1);

    // using array linear
    String [] moreLinearString = new String[] {"linear 1", " linear 2", " linear 3"};
    int [] moreLinearInt = new int[] {1,2,3,};
    System.out.println ("All my linear string and integer in an linear array "+ moreLinearInt[1] + " "+ moreLinearString[1] +  " "+ moreLinearInt[0] +  " "+ moreLinearString[0] );

    // using ArrayList

    ArrayList<String> newArrayList = new ArrayList<> ();
    newArrayList.add ("list 1");
    newArrayList.add ("list 3");
    newArrayList.add ("list 2");

    ArrayList <Integer> newIl = new ArrayList <> ();
    newIl.add (12);
    newIl.add(15);
    newIl.add(13);

    System.out.println(newArrayList.get(0) + ""+ newArrayList.get(1) + ""+ newArrayList.get(2) + ""+newIl.get(0) );











}// end of main method

}// end of class