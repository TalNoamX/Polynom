
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Tal
 * @author Oranit
 *
 */
public class Monom implements function {

	private double _coefficient; 
	private int _power;
	/**
	 * A default constructor
	 * @param a the coefficient
	 * @param b the power
	 */
	public Monom(double a, int b){
		if(b>=0) {
			this.set_coefficient(a);
			this.set_power(b);
		}
		else{
			this.set_coefficient(0);
			this.set_power(0);
		}
	}
	/**
	 * copy constructor
	 * @param ot - The copied Monom
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}

	public double get_coefficient() {
		return _coefficient;
	}

	public int get_power() {
		return _power;
	}
	/**
	 * param y - The value of y in the Monom.
	 * @param x The requested value to post in the monom
	 * @return y 
	 */
	public double f(double x) {
		double y = this._coefficient*Math.pow(x, this._power);
		return y;
	} 
	/**
	 *  Changes the Monom to be it's derivative.
	 * @return the derivative
	 */
	public Monom derivative() {
		this.set_coefficient(this.get_coefficient()*this.get_power());
		this.set_power(this.get_power()-1);
		return this;
	}
	/**
	 * Adding 2 Monoms with the same power. 
	 * @param m1 The Monom that is added
	 * @return  Monom+m1
	 */
	public Monom add(Monom m1) {
		if (this.get_power()!=m1.get_power()) {
			return this;
		}

		else {
			this.set_coefficient(this.get_coefficient()+m1.get_coefficient());
			return this;
		}
	}
	/**
	 * Multiplies 2 Monoms.
	 * @param m1 The Monom that is multiplied in this.Monom
	 * @return  Monom*m1
	 */
	public Monom multiply(Monom m1) {
		this.set_coefficient(m1.get_coefficient()*this.get_coefficient());
		this.set_power(m1.get_power()+this.get_power());
		return this;
	}
	/**
	 * Returns a string that represent the Monom.
	 */
	@Override
	public String toString() {
		String Mstring="";
		if(this.get_power()==0) {
			if(this.get_coefficient()>0)
				Mstring+=this.get_coefficient();
			else if(this.get_coefficient()<0)
				Mstring+="("+this.get_coefficient()+")";
			else Mstring+="0";
		}

		else {
			if(this.get_coefficient()>0)
				Mstring+=this._coefficient+"x"+"^"+this._power;
			else if(this.get_coefficient()<0)
				Mstring+="("+this._coefficient+")"+"x"+"^"+this._power+" ";
			else Mstring+="0";
		}
		return Mstring;
	}
}
