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
	@SuppressWarnings("unchecked")
	public Graph() {
		double x0 =-2;
		double x1 =6;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		// Insert rest of the code here
		Polynom p = new Polynom("0.2*x^4 + -1.5*x^3 + 3*x^2 + -1*x^1+ -5");
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
	public void extrema(Polynom p1,double x0,double x1,double eps,DataTable data) {
		Polynom pd = new Polynom(p1.derivative().toString());
		for(double i=x0;i<=x1; i+=eps){
			if(pd.f(i)*pd.f(i+eps)<0) {
				data.add(i,p1.f(i));
			}
		}
	}
	public double area2(Polynom p,double x0, double x1, double eps) {
		
		return p.area(x0, x1, eps);
	}
	public static void main(String[] args) {
		Graph frame = new Graph();
		frame.setVisible(true);
	}
}