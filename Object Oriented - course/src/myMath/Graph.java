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
		double x0 =-2;
		double x1 =6;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		// Insert rest of the code here
		Polynom p = new Polynom("0.2*x^4 + -1.5*x^3 + 3*x^2 + -1*x^1+ -5");
		@SuppressWarnings("unchecked")
		DataTable data = new DataTable(Double.class,Double.class);
		for (double x = x0; x <= x1; x+=0.25) {
			double y = p.f(x);
			data.add(x,y);
		}
		DataTable dataExt = new DataTable(Double.class,Double.class);
		extrema(p,x0,x1,0.01,dataExt);

		XYPlot plot = new XYPlot(data);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		Color color = new Color(1f, 0.3f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		plot.getLineRenderers(data).get(0).setColor(color);

		plot.add(dataExt);
		Color colorExt = new Color(0f, 0f, 0f);
		plot.getPointRenderers(dataExt).get(0).setColor(colorExt);

	}
	public double extrema(Polynom p1,double x0,double x1,double eps,DataTable data) {
		Polynom pd = new Polynom(p1.derivative().toString());
		double x=0;
		double y=0; 
		while((x1-x0)>eps) {
				x = pd.root(x0, x1, eps);
				y = p1.f(x);
				data.add(x,y);
			if(Math.abs(x1-x)<Math.abs(x0-x)) x1=x-eps*10;
			else x0=x+eps*10;
		}
		return 0;
	}
	public static void main(String[] args) {
		Graph frame = new Graph();
		frame.setVisible(true);
	}
}