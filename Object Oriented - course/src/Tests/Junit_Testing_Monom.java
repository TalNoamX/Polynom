package Tests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myMath.Monom;

class Junit_Testing_Monom {
	
	@Test
	public void testMonom() {
		Monom m = new Monom(3.15,9);
		if(m.get_coefficient()==0 || m.get_power()<0) {
			fail("fail: Something is wrong with this Monom");
		}
		
	}
	@Test
	public void testMonomCopy() {
		Monom m = new Monom(9,9);
		Monom m1 = new Monom(m);
		if(m1.get_coefficient()==0 || m1.get_power()<0) {
			fail("fail: Something is wrong with this Monom");
		}
	}
	@Test
	public void testGetPower() {
		int pow = 5;
		Monom m = new Monom(5.8,pow);
		if(pow!=m.get_power()) {
			fail("fail: Something is wrong with get_power function");
		}
	}
	@Test
	public void testGetCo() {
		double Co = 5.34;
		Monom m = new Monom(Co,7);
		if(Co!=m.get_coefficient()) {
			fail("fail: Something is wrong with get_coefficient function");
		}
	}
	@Test
	public void testf() {
		int power = 2;
		double Co = 6.4;
		int x = 4;
		double result = Co*(Math.pow(x,power));
		Monom m = new Monom(Co,power);
		assertEquals(result,m.f(x));
	}
	@Test
	public void testDerivative() {
		int power = 3;
		double Co = 5.5;
		Monom m = new Monom(Co,power);
		m.derivative();
		assertEquals(power-1,m.get_power());
		assertEquals(Co*power,m.get_coefficient());
	}
	@Test
	public void testAdd() {
		double co1 = 4.5 , co2 = 3.2;
		Monom m1 = new Monom(co1,2);
		Monom m2 = new Monom(co2,2);
		m1.add(m2);
		assertEquals(co1+co2,m1.get_coefficient());
	}
	@Test
	public void testBadAdd() {
		double co1 = 4.5;
		double co2 = 3.2;
		int power = 3;
		Monom m1 = new Monom(co1,power);
		Monom m2 = new Monom(co2,power+1);
		m1.add(m2);
		assertNotEquals(co1+co2,m1.get_coefficient());
	}
	@Test
	public void testMultiply() {
		double co1 = 4.5;
		double co2 = 3.2;
		int power1 = 3;
		int power2 = 5;
		Monom m1 = new Monom(co1,power1);
		Monom m2 = new Monom(co2,power2);
		m1.multiply(m2);
		assertEquals(co1*co2,m1.get_coefficient());
		assertEquals(power1+power2,m1.get_power());
		
		
	}
}
