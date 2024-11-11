import java.util.Scanner;
import java.io.*;

public class RecordProcessor {

	public static void main(String[] args) {
		
		// prints to the Console ---- "standard output"
		System.out.println("Processing Temperature Data");
		
		System.out.println("Enter a file name:"); // prompt
		
		// get user's input from "standard input" -- usually the keyboard
		Scanner kb = new Scanner(System.in);
		String filename = kb.nextLine();
		
		System.out.println("Reading from: " + filename + "..."); 
		
		try {
			// open the data file
			Scanner sc = new Scanner(new File(filename));

			// open an output file
			PrintWriter pw = new PrintWriter(new File("output.txt"));
			
			// read in lines and record in a bdr
			BasicDailyRecord bdr = new BasicDailyRecord();
			
			while ( sc.hasNextInt() ) {
				int hour = sc.nextInt();
				int temp = sc.nextInt();
				bdr.recordTemp(hour, temp);
			}
			
			pw.println("High: " + bdr.getHigh());
			pw.println("Low: " + bdr.getLow());
			pw.println("Average: " + bdr.getAverage());
			
			pw.close();		// make sure to save the output file
			sc.close();
		} catch (IOException e) {
			System.out.println("Something went wrong: " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All done.");
				
	}

}

/* 

  Ask the user for the name of a data file.
  Open the data file, read pairs of integers as long 
     as there are more in the file
  Add them to a basicdailyrecord
  print out a summary of high/low/average

*/