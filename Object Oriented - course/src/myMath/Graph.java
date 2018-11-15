package myMath;
import java.awt.Color;

import javax.swing.JFrame;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class Graph extends JFrame {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	public Graph() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		Polynom p = new Polynom("0.2*x^4 + -1.5*x^3 + 3*x^2 + -1*x^1+ -5");//will work with every Polynom
		DataTable data = new DataTable(Double.class,Double.class);
		DataTable dataExt = new DataTable(Double.class,Double.class);//data table for the extremas only
		
		PolynomGraph(p, -2, 6, data);//need to insert range
		
		extrema(p, -2, 6, 0.01, dataExt);//need to insert range.
		
		XYPlot plot = new XYPlot(data);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		Color color = new Color(1f, 0.3f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		plot.getLineRenderers(data).get(0).setColor(color);
		plot.add(dataExt);
		Color colorExt = new Color(0f, 0f, 0f);//different colors for the extrema
		plot.getPointRenderers(dataExt).get(0).setColor(colorExt);

	}
	public void PolynomGraph(Polynom p, double x0, double x1,DataTable data) {
		for (double x = x0; x <= x1; x+=0.25) {//adding points to the graph
			double y = p.f(x);
			data.add(x,y);
		}
	}
	public void extrema(Polynom p1,double x0,double x1,double eps,DataTable data) {
		Polynom pd = new Polynom(p1.derivative().toString());
		for(double i=x0;i<=x1; i+=eps){
			if(pd.f(i)*pd.f(i+eps)<0) {//if the sign of f(i) and f(i+eps) in the derivative is different, there's an extrema there.
				data.add(i,p1.f(i));
			}
		}
	}
	public static void main(String[] args) {
		Graph frame = new Graph();
		frame.setVisible(true);
	}
}