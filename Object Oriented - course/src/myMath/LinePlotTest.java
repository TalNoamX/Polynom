package myMath;
import javax.swing.JFrame;

import de.erichseifert.gral.data.DataTable;


public class LinePlotTest extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinePlotTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        // Insert rest of the code here
    }

    public static void main(String[] args) {
        LinePlotTest frame = new LinePlotTest();
        frame.setVisible(true);
        DataTable data = new DataTable(Double.class, Double.class);
        for (double x = -5.0; x <= 5.0; x+=0.25) {
            double y = 5.0*Math.sin(x);
            data.add(x, y);
        }
    }
    
}