package Day2_42422;

public class whileLoop {
    public static void main(String[] args) {
        // literate through zipcode and its streetNumber using linear and while loop
        String[] zipcode = new String[]{"11218","11219","11232","10001"};
        int[] houseNumber = new int[]{111,222,333,444};

        // initialize your starting point before calling while loop

        int i = 0;
        // define the end point in while loop
        while(i <=houseNumber.length){

            System.out.println("My zipcode is "+ zipcode[i] + " and house number "+ houseNumber[i]);

            //i = i+1 ;
            i++;
        }// end of while

    }//end of method
}//end java class
