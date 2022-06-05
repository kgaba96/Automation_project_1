package Day4_050722;

public class split_Message {
    public static void main(String[] args) {
        String splitMessage = "My name is John ";
        // declare an array of string to store the string split
        String[]splitMessageArray= splitMessage.split( "");
        //regex is regular expression, in between split the message in where we want to split
        System.out.println("my first name is "+ splitMessageArray[3]);
        // used in google search


    }//end of method
}// end of java
