import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author git-egi
 * This class is used to process the csv file Data and also print them in console using a format
 */
public class csvProcess {
	
	String csv_fn = null;
	csvReader reader = null;
	BufferedReader bReader = null;
	
	ArrayList<String> rows = new ArrayList<String>();
	ArrayList<String[]> rowData = new ArrayList<String[]>();
	
	public csvProcess(String csv_fn) throws IOException {
		this.csv_fn = csv_fn;
		this.reader = new csvReader(csv_fn);
		this.bReader = this.reader.getReader();
		process();
		//consolePrint();
	}
	
	private void process() throws IOException {
		String row;
		while((row = bReader.readLine()) != null) {
			rows.add(row);
		}
		
		if(this.rows.size() == 0) {
			System.out.println("ERROR : CSV is empty!");
			System.exit(-1);
		}
		
		/* If you use a different separator you should change it here as well */
		/* Change '#' with whatever separator you are using */
		for(int c = 0; c<this.rows.size(); c++) {
			this.rowData.add(this.rows.get(c).split("#"));
		}
	}
	
	@SuppressWarnings("unused")
	private void consolePrint() {
		/* I use '_' to separate rows */
		/* And '|' to separate columns */
		/* You can change that here */
		
		for(int c = 0; c<this.rows.size(); c++) {
			String[] tmp = this.rowData.get(c);
			for(int y=0; y<tmp.length; y++) {
				System.out.printf(" %-15s |",tmp[y]);	
			}
			System.out.println("\n______________________________________________________"
							    +"______________________________________________________");
		}
	}
	
	public ArrayList<String[]> getData() {
		return this.rowData;
	}

}
