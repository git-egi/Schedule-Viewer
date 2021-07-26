import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class myJTable extends JTable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<String[]> rowdata = null;

	/* Options */
	
	private Color dayRowColor = new Color(83,172,150);
	private Color timeRowColor = new Color(83,150,172);
	private Color timeRowColor2 = new Color(83,172,172);
	private Color rowColor1 = new Color(83,83,172);
	private Color rowColor2 = new Color(83,105,172);
	
	private int rows;
	
	private int columns;
	
	public myJTable(ArrayList<String[]> rowdata) {
		this.rowdata = rowdata;
		this.rows = rowdata.size();
		this.columns = 6;		
		init();
	}
	
	public void init() {
		DefaultTableModel model = new DefaultTableModel(this.rows, this.columns) {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		this.setModel(model);
		this.setVisible(true);
		this.setForeground(Color.black);
		this.setDefaultRenderer(Object.class, getRenderer());
		this.setGridColor(Color.black);
		this.setRowHeight(25);
		this.setFont(new Font("Helvetica",Font.BOLD,12));
		setData();
	}
	
	private void setData() {
		for(int r = 0; r < this.rowdata.size(); r++) {
			for(int c = 0; c<this.rowdata.get(r).length; c++) {
				this.setValueAt(this.rowdata.get(r)[c], r, c);
			}
		}
	}
	
	public cellRenderer getRenderer() {
		
		cellRenderer myrenderer = new cellRenderer();
		for(int c = 0; c<this.columns; c++) {
			myrenderer.setColorForCell(0, c, this.dayRowColor);
		}
		
		for(int r = 1; r<this.rows; r++) {
			if(r%2 == 0)
				myrenderer.setColorForCell(r, 0, timeRowColor);
			else
				myrenderer.setColorForCell(r, 0, timeRowColor2);
		}
		
		for(int c = 1; c<this.columns; c++) {
			for(int r = 1; r<this.rows; r++) {
				if(r%2 == 0) 
					myrenderer.setColorForCell(r, c, rowColor1);
				else 
					myrenderer.setColorForCell(r, c, rowColor2);
			}
		}
		
		return myrenderer;
	}
	
	public class cellRenderer extends javax.swing.table.DefaultTableCellRenderer {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
        private final Map<String, Color> colorMap = new HashMap<>();
		
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            setBackground(null);
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            this.setHorizontalAlignment(JLabel.CENTER);
            getColorForCell(row, column).ifPresent(this::setBackground);
            return this;
        }
		
        public void setColorForCell(int row, int col, Color color) {
            colorMap.put(row + ":" + col, color);
        }

        public Optional<Color> getColorForCell(int row, int col) {
            return Optional.ofNullable(colorMap.get(row + ":" + col));
        }
	}

}
