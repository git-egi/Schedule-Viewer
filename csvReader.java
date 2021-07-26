import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class csvReader {
	
	String csv_fn = null;
	
	public csvReader(String csv_fn) {
		this.csv_fn = csv_fn;
	}
	
	public BufferedReader getReader() throws FileNotFoundException {
		return init();
	}
	
	private BufferedReader init() throws FileNotFoundException {
		
		if(csv_fn == null){
			System.out.println("CSV Error !");
			System.exit(-1);
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(this.csv_fn));
		
		return reader;	
	}

}
