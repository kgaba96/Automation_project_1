package ActionItems;

public class Automation_Al02_prt01 {

    public static void main(String[] args) {


        // in this example I used Integer syntax to assign a value to run my grade condition.
        // I will Run the test for 5 Students
        //added different values to test out each condition.



     // Student 1.
        System.out.println(" Student 1 scored 55.");
        int gradeStudent1 = 55; // the value added to Student 1.


        if (gradeStudent1 >= 90 && gradeStudent1<= 100 ){
            System.out.println(" Student 1 grade is A"); // we begin the condition with if and Parentheses with brackets
            // to write what happens if the condition meets the ask.

        } else if (gradeStudent1 >= 80 && gradeStudent1 <= 89 ) {
            System.out.println("Student 1 grade is B."); // when adding more conditions we use the else if.

        }  else if (gradeStudent1 >=70  && gradeStudent1 <= 79 ) {
            System.out.println("Student 1 grade is C.");
        } else if (gradeStudent1 >= 60 && gradeStudent1 <= 69 ) {
            System.out.println("Student 1 grade is D.");
        } else {
            System.out.println("Student 1 grade is F.");
        }// end of condition for student 1 - when writing else alone, we are speaking about the rest of the numbers that we didn't
        //...set a condition on, in this example from 0 to 60. We need to remember not to add Parentheses when use else.
        // Always end the condition with an else.

        System.out.println("");
        System.out.println(" Student 2 scored 85.");

        int gradeStudent2 = 85;
        if (gradeStudent2 >= 90 && gradeStudent2 <= 100 ){
            System.out.println(" Student 2 grade is A");

        } else if (gradeStudent2 >= 80 && gradeStudent2 <= 89 ) {
            System.out.println("Student 2 grade is B.");

        }  else if (gradeStudent2 >=70  && gradeStudent2 <= 79 ) {
            System.out.println("Student 2 grade is C.");
        } else if (gradeStudent2 >= 60 && gradeStudent2 <= 69 ) {
            System.out.println("Student 2 grade is D.");
        } else {
            System.out.println("Student 2 grade is F.");
        }// end of student 2 condition

        System.out.println("");
        System.out.println(" Student 3 scored 75.");

        int gradeStudent3 = 75;
        if (gradeStudent3 >= 90 && gradeStudent3 <= 100 ){
            System.out.println(" Student 3 grade is A");
        } else if (gradeStudent3 >= 80 && gradeStudent3 <= 89 ) {
            System.out.println("Student 3 grade is B.");
        }  else if (gradeStudent3 >=70  && gradeStudent3 <= 79 ) {
            System.out.println("Student 3 grade is C.");
        } else if (gradeStudent3 >= 60 && gradeStudent3 <= 69 ) {
            System.out.println("Student 3 grade is D.");
        } else {
            System.out.println("Student 3 grade is F.");
        }// end of student 3 condition

        System.out.println("");
        System.out.println(" Student 4 scored 65.");

        int gradeStudent4 = 65;
        if (gradeStudent4 >= 90 && gradeStudent4 <= 100 ){
            System.out.println(" Student 4 grade is A");
        } else if (gradeStudent4 >= 80 && gradeStudent4 <= 89 ) {
            System.out.println("Student 4 grade is B.");
        }  else if (gradeStudent4 >=70  && gradeStudent4 <= 79 ) {
            System.out.println("Student 4 grade is C.");
        } else if (gradeStudent4 >= 60 && gradeStudent4 <= 69 ) {
            System.out.println("Student 4 grade is D.");
        } else {
            System.out.println("Student 4 grade is F.");
        }// end of student 4 condition

        System.out.println("");
        System.out.println(" Student 5 scored 99.");

        int gradeStudent5 = 99;
        if (gradeStudent5 >= 90 && gradeStudent5 <= 100 ){
            System.out.println(" Student 5 grade is A");
        } else if (gradeStudent5 >= 80 && gradeStudent5 <= 89 ) {
            System.out.println("Student 5 grade is B.");
        }  else if (gradeStudent5 >=70  && gradeStudent5 <= 79 ) {
            System.out.println("Student 5 grade is C.");
        } else if (gradeStudent5 >= 60 && gradeStudent5 <= 69 ) {
            System.out.println("Student 5 grade is D.");
        } else {
            System.out.println("Student 5 grade is F.");
        }// end of student 5 condition




    }//end of method


}//end of class
