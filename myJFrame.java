import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;

public class myJFrame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JTable jt = null;
	private Integer width = 857;
	private Integer height = 328;
	
	public myJFrame(ArrayList<String[]> rowdata) {
		this.setVisible(true);
		this.jt = new myJTable(rowdata);
		this.setSize(width,height);
		this.add(this.jt);
		this.setTitle("Schedule Viewer by git-egi");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
