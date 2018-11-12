package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Junit_Testing_Polynom {

	@Test
	public void StringTest() {
		Polynom_able p1 = new Polynom("5x^1");
		Monom m = new Monom(5,1);
		Polynom p2 = new Polynom();
		p2.add(m);
		if(!p1.equals(p2)) {
			fail("fail: Someting is wrong with the String consrtuctor");
		}
	}
	@Test
	public void CopyTest() {
		Polynom p1 = new Polynom("5x^3+8x^2+5x^1+7");
		Polynom p2 = new Polynom(p1);
		if(!p1.equals(p2)) {
			fail("fail: something is wrong with the copy constructor");
		}
	}
	@Test
	public void MultiplyTest(){
		Polynom p1 = new Polynom ("1*x^1+1");
		Polynom p2 = new Polynom ("1*x^1+1");
		Polynom p3 = new Polynom ("1*x^2+2*x^1+1");
		p1.multiply(p2);
		assertTrue(p1.equals(p3));
	}
	
}
