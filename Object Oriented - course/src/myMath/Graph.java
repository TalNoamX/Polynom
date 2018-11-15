package myMath;
import java.awt.Color;

import javax.swing.JFrame;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

@SuppressWarnings("serial")
public class Graph extends JFrame {
	//private static final long serialVersionUID = 1L;
	public Graph() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		// Insert rest of the code here
		Polynom p = new Polynom("0.2*x^4 + -1.5*x^3 + 3*x^2 + -1*x^1+ -5");
		@SuppressWarnings("unchecked")
		DataTable data = new DataTable(Double.class,Double.class);
		for (double x = -2.0; x <= 6.0; x+=0.25) {
			double y = p.f(x);
			data.add(x,y);
		}
		XYPlot plot = new XYPlot(data);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		Color color = new Color(1f, 0.3f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		plot.getLineRenderers(data).get(0).setColor(color);
	}
	public double extrema(Polynom p1) {
	
		return 0;
	}
	public static void main(String[] args) {
		Graph frame = new Graph();
		frame.setVisible(true);
	}
}