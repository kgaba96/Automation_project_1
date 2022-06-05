package ActionItems.practice;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Z12 {
public static void main (String [] args){
    String a1 = "String on it's own";
    int a2 = 192;
    System.out.println ("Practice my string and the example is "+a1+ ". My Integer value code is next "+a2 );

    //Linear Array
    String [] b1= new String[] {"hat", "cap", "cover"};
    int [] b2 = new int [] {1,2,3};

    System.out.println(b1[0]+b2[0]+" "+b1[1]+b2[1]+ ""+b1[2]+b2[2]);

    //ArrayList

    ArrayList<String> c1 = new ArrayList<>();
    c1.add ("face");
    c1.add ("eyes");
    c1.add ("nose");

    ArrayList <Integer>c2= new ArrayList <>();
    c2.add(12);
    c2.add(11);
    c2.add(10);

    // for loop

    for (int i=0; i<c1.size(); i++ ){

       // System.out.println( "Body part is "+ c1.get(i) + " the number attach to is "+ c2.get(i));

        if(c1.get(i) == "face" ) {
            System.out.println("if condition found is "+c1.get(i));

        } else if (c1.get(i) == "nose"){
            System.out.println(" else if condition is working " + c1.get(i));
        }// end of condition

    } //end of for loop

    // while loop

    int i = 0;

    while (i < b1.length) {

        System.out.println(" while loop practice and the satatments are " + b1[i]+" and the number " +
                "attach is "+ b2[i]);
        i++;
    }// end of while loop




}// end of main method / entry point of all java code
}// end off class
