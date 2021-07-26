import java.io.IOException;


/**
 * @author git-egi
 * This is a JAVA application I created in order to view my daily Schedule
 */
public class Main {
	
	/* Make sure you are using the same delimiters at the csv export */
	/* I use '#' as a separator */
	/* If you wish to change that you need to change the appropriate code in csvProcess class */
	
	public static void main(String[] args) throws IOException {
		
		/* I use the first argument as the schedule csv file name */
		String schedule_fn = args[0];
		
		/* I get an instance of the class that I'm going to use to process the csv file */
		@SuppressWarnings("unused")
		csvProcess proc = new csvProcess(schedule_fn);
		
		@SuppressWarnings("unused")
		myJFrame m = new myJFrame(proc.getData());

	}

}
