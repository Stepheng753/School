package Lectures;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture9 {

    public void FileWriter () throws IOException
    {
        PrintWriter pWriter = new PrintWriter("pWriter.txt");
        pWriter.println("THIS TOOK FOREVER TO GET");
        pWriter.close();
    }

    public void FileReader (String fileName) throws IOException
    {
        FileInputStream textReader = new FileInputStream(fileName);
        Scanner input = new Scanner (textReader);
        while (input.hasNextLine()) { System.out.println(input.nextLine()); }
        textReader.close();
    }

public static void main(String[] args) throws IOException
    {
        try {
        Lecture9 test = new Lecture9();
        test.FileWriter();
        String fileName = "Test.txt";
        test.FileReader(fileName);
        }
        catch (IOException e) {
        System.out.println("File Not Found!");
        }
    }
}

class Lecture9Vocab {
    // OutputStream - Class that supports WRITING INFORMATION to some sort of OUTPUT
    // System.out - predefined Output Stream
    // "out" variable in the System class is a reference to the PrintStream Object
    // PrintStream inherits from the OutputStream class
    // This allows for print and println

    // InputStream - Class that supports READING INFORMATION, such as a keyboard
    // System.in - predefined InputStream that is associated with a system's standard input
    // Scanner Class wraps the Input Stream then reads in a sequence of bytes and converts the correct number of bytes into a desired data type
    // You have to import it: import java.util.Scanner

    // When using an InputStream, we need a THROWS CLAUSE to the definition of the main because both Streams can throw an IOException
    // public static void main(String[] args) throws IOException



    // The FileInputStream class ( which is derived from InputStream ) allows a programmer to READ bytes from a file
    // import: import java.io.FileInputStream
    // Must import the IOException class when FileInputStream throws file I/O Exceptions
    // import java.io.IOException

    // FileInputStream constructor takes in a single String as its input parameter
    // FileInputStream fStream = new FileInputStream ("blahblah.txt")

    // FileInputStream only supports a basic byte system
    // So a Scanner Object is helpful
    // You can use the "next" Methods to access the contents in the file

    // When done accessing the file, use the "close" Method
    // fStream.close();

    // To Access all contents
    //        FileInputStream fStream = new FileInputStream ("blahblah.txt");
    //        Scanner scanner = new Scanner (fStream);
    //        while (scanner.hasNext()) {
    //            System.out.println(scanner.next());
    //        }

    // The FileOutputStream class ( which is derived from the OutputStream ) allows a programmer to WRITE bytes to a file
    // import java.io.FileOutputStream
    // FileOutputSteam only supports writing basic bytes as output
    // So the PrintWriter object is helpful
    // import java.io.PrintWriter
    // The PrintWriter class allows a programmer to OUTPUT VARIOUS DATA TYPES to the underlying character stream similar to System.out
    // FileOutputStream fOutStream = new FileOutputStream ("output.txt")
    // PrintWriter pWriter = new PrintWriter (fOutStream)

}
