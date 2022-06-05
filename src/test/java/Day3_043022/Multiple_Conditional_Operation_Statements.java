package Day3_043022;

public class Multiple_Conditional_Operation_Statements {

    public static void main(String[] args) {
        int a = 2;
        int b= 2;
        int c= 3;

        // if a+b is less than c then print the result
        // if a+b is greater than c then print the results
        // finally print a+b is equal to c

        if (a+b < c) {
            System.out.println("a & b is less than c");
        } else if (a+b <c){
            System.out.println("a+b is greater than c ");// also can use if instead of "else if"
        }else {
            System.out.println(" a+b is equal to c ");
        }// end of conditions


        // declare additional variables

        int d = 4;
        int e = 5;
        int f = 6;

        // or operator with if statement
        if (d < e || f < e) {

            System.out.println(" d is less than e and f is is less than e");
        }else {
            System.out.println("condition is not true");}



//        //
//        if (d<e && f < e) {
//
//            System.out.println(" d is less than e and f is is less than e");
//        }else {
//            System.out.println("condition is not true");
//        } // end of and operator





    }//end of method
}//end of java class
