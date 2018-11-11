package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	@Override
	/**
	 * Compares between two Monoms.
	 */
	public int compare(Monom m1, Monom m2) {
		if(m1.get_power()==m2.get_power()) return 0;
		else {
			if (m1.get_power()>m2.get_power()) return 1;
			
			else return -1;
		}
	}
}
