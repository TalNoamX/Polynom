package myMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * 
 * @author Tal
 * @author Oranit
 */
public class Polynom implements Polynom_able{

	private ArrayList <Monom> Polynom;
	private final Monom_Comperator comp = new Monom_Comperator();
	/**
	 * A default constructor
	 */
	public Polynom() {
		Polynom = new ArrayList<>();
	}
	/**
	 * Copy consructor
	 * @param p The Polynom that we need to copy from. 
	 */
	public Polynom(Polynom p) {
		Polynom = new ArrayList<>(); 
		Iterator<Monom> it = p.iteretor();
		while(it.hasNext()) {
			Monom m = new Monom(it.next());
			Polynom.add(m);
		}
	}
	/**
	 * A constructor that builds a polynom from a String.
	 * @param s  The String from the user
	 * param ps - A strings Array to deal with every Monom separately.
	 * param co - as _coefficient
	 * param s1 - we'll be converted to co.
	 * param pow - a power
	 * param s2 - we'll be converted to pow.
	 */
	public Polynom(String s) {
		Polynom = new ArrayList<>();
		s=s.replaceAll("\\s","");
		s=s.replaceAll("\\)","");
		s=s.replaceAll("\\(","");
		String[] ps = s.split(Pattern.quote("+"));
		int i=0;
		while(i<ps.length) {
			double co=0;
			int pow=0;
			String s1;
			String s2;
			if(Character.isDigit(ps[i].charAt(0)) || ps[i].charAt(0)=='-' || ps[i].charAt(0)=='+') 	{
				if(ps[i].contains("x")) {
					if(ps[i].contains("*")) {
						int j=ps[i].indexOf('*');
						s1= ps[i].substring(0, j);
						s2=ps[i].substring(j+3, ps[i].length());
						co=Double.parseDouble(s1);
						pow=(int) Double.parseDouble(s2);
					}
					else {
						int j=ps[i].indexOf('x');
						s1 = ps[i].substring(0, j);
						if(j+2<ps[i].length()) {
							s2=ps[i].substring(j+2, ps[i].length());
							co=Double.parseDouble(s1);
							pow=(int) Double.parseDouble(s2);
						}
						else {
							co=Double.parseDouble(s1);
						}
					}
				}
				else {
					co=Double.parseDouble(ps[i]);
				}
				Monom m = new Monom(co,pow);
				Polynom.add(m);
				i++;
			}
			else {
				break;
			}
		}
		Polynom.sort(comp);
	}

	/**
	 * Will return the value of f(x)
	 * param sum - will sum the value of f(x) in each Monom 
	 * param it - The iterator that will go over the Polynom.
	 * @param x  The value of x
	 * @return sum - the value of f(x).
	 */
	@Override
	public double f(double x) {
		double sum=0;
		Iterator<Monom> it = Polynom.iterator();
		while(it.hasNext()) {
			sum+=it.next().f(x);
		}
		return sum;
	}


	/**
	 * Will go over the Polynom and add the Monom to it, using the Monom's add function
	 * param it - The iterator that will go over the Polynom.
	 * @param p1 The Polynom that is added.
	 */
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> it = p1.iteretor();
		while(it.hasNext()) {
			Monom m=it.next();
			this.add(m);
		}
	}

	/**
	 * Will add a Monom to the Polynom, and sort at the and using the sort function.
	 * param flag - will tell us if the Monom we're adding has no Monom with a similar power in the Polynom.
	 * param it - The iterator that will go over the Polynom.
	 * @param m1  The Monom that is added.
	 * 
	 */
	@Override
	public void add(Monom m1) {
		boolean flag = false;
		Iterator<Monom> it = Polynom.iterator();
		if(m1.get_coefficient()!=0) {
			while(it.hasNext()) {
				Monom m = it.next();
				if(comp.compare(m1,m)==0) {
					m.add(m1);
					flag=true;
				}
			}
			if(!flag) {
				Polynom.add(m1);
				this.sort();
			}
		}

	}

	/**
	 * Will subtract Polynom's by multiplying each Monom in -1 and calling the add(Polynom) function each time.
	 * param minus -  An aid monom with the value -1.
	 *  we're multiplying each Monom in p1 in this Polynom in order to change it's sign.
	 *  @param p1 The Polynom that is subtracted
	 */
	@Override
	public void substract(Polynom_able p1) {
		Monom minus = new Monom(-1,0);
		Iterator<Monom> it = p1.iteretor();
		while(it.hasNext()) {
			Monom m=it.next();
			m.multiply(minus);
			this.add(m);
		}
	}

	/**
	 * Multiplying 2 Polynoms.
	 * param - helper - an aid Polynom to copy it the result.
	 * param - itAble - p1's iterator.
	 * param itPoly - this.Polynom's iterator.
	 * param mA - MonomAble - points p1's Monoms.
	 * param mP - MonomPolynom - points this.Polynom's Monoms.
	 * param mH - MonomHelper - points helper's Monoms.
	 * @param p1 The Polynom that is multipied.
	 */
	@Override
	public void multiply(Polynom_able p1) {
		Polynom helper = new Polynom();
		Iterator<Monom> itAble = p1.iteretor();
		while(itAble.hasNext()) {
			Monom mA = itAble.next();
			Iterator<Monom> itPoly = Polynom.iterator();
			while(itPoly.hasNext()) {
				Monom mP = new Monom(itPoly.next());
				mP.multiply(mA);
				helper.add(mP);

			}
		}

		Polynom.clear();
		Iterator<Monom> itHelp = helper.iteretor();
		while(itHelp.hasNext()){
			Monom mH =new Monom(itHelp.next());
			Polynom.add(mH);
		}
	}

	/** 
	 * Compares between each 2 Monoms at the same place in the 2 Polynom's ArrayListand 
	 * @return false if they are not equal.
	 * param - itAble - p1's iterator.
	 * param itPoly - this.Polynom's iterator.
	 * @param p1 - The Polynom that this.Polynom is being compared to
	 */
	@Override
	public boolean equals(Polynom_able p1) {
		Iterator<Monom> itAble = p1.iteretor();
		Iterator<Monom> itPoly = Polynom.iterator();
		while(itPoly.hasNext() && itAble.hasNext()) {
			Monom mp = itPoly.next();
			Monom ma = itAble.next();
			if(mp.get_power() == ma.get_power()) {
				if(mp.get_coefficient() == ma.get_coefficient());
				else return false;
			}
			else return false;
		}
		if(itAble.hasNext() || itPoly.hasNext()) return false;

		return true;
	}

	/**
	 * Check's if the Polynom is empty - if it is, it means it is the zero Polynom.
	 *@return true if it is the zero Polynom.
	 * 
	 */
	@Override
	public boolean isZero() {
		if (Polynom.isEmpty()) return true;

		return false;
	}

	/**
	 * A function that finds The root of The Polynom in a certain segment
	 * @return the function's root in the recieved values, with an exception of eps, using the bisection method.
	 * param mid - the middle of each segment we're checking.
	 * @param x0 
	 * @param x1
	 * @param eps
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		double mid=0;
		while((x1-x0)>eps) {
			mid=(x0+x1)/2;
			if(this.f(x0)*this.f(mid)>0) x0=mid;
			else x1=mid;
		}
		return mid;
	}
	/**
	 * @return a Polynom that is a copy of another Polynom
	 */
	@Override
	public Polynom_able copy() {
		return new Polynom(this);
	}

	/**
	 * Returns the derivative of the polynom
	 * param helper - an aid Polynom to copy the result to afterwards.
	 * param it - the polynom's iterator
	 * param ithelper - helper's iterator
	 */
	@Override
	public Polynom_able derivative() {
		Polynom helper = new Polynom();
		Iterator<Monom> it = Polynom.iterator();
		while(it.hasNext()) {
			Monom m = new Monom(it.next());
			m.derivative();
			if(m.get_coefficient()!=0)
				helper.add(m);
		}
		return helper;
	}

	/**
	 * @return the value of the integral using rieman's method.
	 * @param x0
	 * @param x1
	 * @param eps
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		x0=x0+eps;
		double sum=0;
		while(x0<=x1) {
			sum+=Math.abs(f(x0))*eps;
			x0+=eps;
		}
		return sum;
	}

	/**
	 * @return the Polynom's iterator.
	 */
	@Override
	public Iterator<Monom> iteretor() {
		Iterator<Monom> it = Polynom.iterator();
		return it;
	}
	/**
	 * Sorting the Polynom's using the comperator.
	 */

	public void sort() {
		this.Polynom.sort(comp); 
	}
	/**
	 *  Concatenation of the Polynom.
	 *  param polystring - concats the Polynom's.
	 */
	@Override
	public String toString() {
		String polystring="";
		Iterator<Monom> it = this.iteretor();
		if(this.isZero())
			polystring+="0";
		else {
			while(it.hasNext()) {
				Monom m =it.next();
				if(m.get_coefficient()!=0) {
					polystring+=m.toString();
					if(it.hasNext())
						polystring+=" + ";
				}
			}
		}
		return polystring;
	}
	/**
	 * Clearing the Polynom.
	 */
	public void empty() {
		Polynom.clear();
	}
	

}
