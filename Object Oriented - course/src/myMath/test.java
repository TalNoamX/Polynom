package myMath;
//
public class test {
//
	public static void main(String[] args) {
///*
// * 1.0 This class will show you how the function works in the Monom class, and the Polynom class.
// * 1.1 Part one: we show you the Monom Object and how it work's with this own class functions.
// * 1.2 Part two: we show you the Polynom Object and how it work's with this own class functions 
// * 		that use the Monom function as well.
// */
////****************************Monom test********************************************************
//		System.out.println("Monom test! ");
//		System.out.println("Building Monoms: ");
//		Monom m0 = new Monom(0,0); // the number 0.
//		System.out.print("m0="+m0+" "); // There is a function call toString and it work automatically.
//		
//		Monom m1 = new Monom(2,0); // the number 2.
//		System.out.print("m1="+m1+" ");
//		
//		Monom m2 = new Monom(3,1); // the monom 3x.
//		System.out.print("m2="+m2+" ");
//		
//		Monom m3 = new Monom(5,2); // the monom 5x^2.
//		System.out.print("m3="+m3+" ");
//		
//		Monom m4 = new Monom(4,3); // the monom 4x^3.
//		System.out.print("m4="+m4+" ");
//		
//		Monom m5 = new Monom(1,4); // the monom x^4.
//		System.out.print("m5="+m5+" ");
//		
//		Monom m6 = new Monom(m5); // m6 is a deep copy of m5
//		System.out.print("m6="+m6+" ");
//		
//		Monom m7 = new Monom(m3); // m7 is a deep copy of m3
//		System.out.println("m7="+m7+" ");
//		
//		System.out.println();
//		//function Add Multiply Derivative and f:
//		
//		System.out.println("functions Add, Multiply, Derivative, and f: ");
//		
//		System.out.println("Add: m3+m7 is: "+m7+" + "+m3+" = "+m3.add(m7)); // Add
//		System.out.println("Multiply: m2*m5 is: "+m2+" * "+m5+" = "+m2.multiply(m5)); // Multiply
//		System.out.println("Derivative: m5' is: ("+m5+")' = "+m5.derivative()); // Derivative
//		System.out.println("The value f when x=2, x=5, x=9 in the Polynom m6= "+m6+" is : f(2)= "+m6.f(2)+" f(5)= "+m6.f(5)+" f(9)= "+m6.f(9));
//		System.out.println();
////************************* Polynom test*****************************************
//		System.out.println("Polynom test! ");
//		System.out.println("Building Polynom: ");
//		Polynom p1=new Polynom(); //this Polynom is now the 0 Polynom. f(x)=0
//		System.out.println("Empty polynom is the 0 Polynom: "+"f(x)= "+p1);
//		
//		//now we need some Monoms to put in.
//		//p1 Monoms
//		Monom m10 = new Monom(2,0);
//		Monom m11 = new Monom(1,1);
//		Monom m12 = new Monom(3,2);
//		
//		//p2 Monoms
//		Monom m13 = new Monom(4,0);
//		Monom m14 = new Monom(2,1);
//		Monom m15 = new Monom(2,2);
//		
//		//p3 Monoms
//		Monom m16 = new Monom(5,1);
//		Monom m17 = new Monom(-2,2);
//		Monom m18 = new Monom(3,3);
//		Monom m19 = new Monom(-7,4);
//		
//		System.out.println("regular Init after using function add(Monom): ");
//		p1.add(m10);// Adding Monoms into the Polynom p1
//		p1.add(m11);
//		p1.add(m12);
//		System.out.println("Polynom p1: "+"f(x)= "+p1);
//		
//		Polynom p2 = new Polynom();
//		p2.add(m13);// Adding Monoms into the Polynom p2
//		p2.add(m14);
//		p2.add(m15);
//		System.out.println("Polynom p2: "+"f(x)= "+p2);
//		
//		Polynom p3 = new Polynom();
//		p3.add(m16);// Adding Monoms into the Polynom p3
//		p3.add(m17);
//		p3.add(m18);
//		p3.add(m19);
//		System.out.println("Polynom p3: "+"f(x)= "+p3);
//		System.out.println();
//		
//		System.out.println("Copy Init: ");
//		Polynom p4 = new Polynom(p1);
//		System.out.println("Polynom p4: "+"f(x)= "+p4);
//		System.out.println();
//		
//		System.out.println("String Init: ");
//		Polynom p5 = new Polynom(p1.toString()); //This polynom Init is receiving a Polynom in a String form and Transforming it into a Polynom
//		System.out.println("Polynom p5: "+"f(x)= "+p5);
//		Polynom p6 = new Polynom("3 + 1x^1 + 1x^2 + -4x^4"); //This polynom Init is receiving a String and Transforming it into a Polynom
//		System.out.println("Polynom p6: "+"f(x)= "+p6);
//		System.out.println();
//		
//		//function Add(Monom),Add(Polynom), subtract, Multiply, f, equals, isZero, root, copy, Derivative, area, Iterator:
//		System.out.println("function Add(Polynom), subtract, Multiply, f, equals, isZero, root, copy, Derivative, area:");
//		System.out.println();
//		
//		System.out.println("Add(Polynom): "); //Add two Polynoms mathematically.
//		p1.add(p2);
//		System.out.println("The use of function add(Polynom): p1 + p2 = "+p1); //Add(Polynom) function.
//		p2.add(p3);
//		System.out.println("Another exemple add(Polynom): p2 + p3 = "+p2);
//		System.out.println();
//		
//		System.out.println("subtract: ");//Add two Polynoms mathematically.
//		p1.empty(); //Empty is a function that erases all Monoms out of the Polynom.
//		p2.empty();
//		p1 = new Polynom("2.0 + 1.0x^1 + 3.0x^2");
//		p2 = new Polynom("4.0 + 2.0x^1 + 2.0x^2");
//		p1.substract(p2);
//		System.out.println("The use of function subtract: p1 - p2 = "+p1); //Add(Polynom) function.
//		p2.substract(p3);
//		System.out.println("Another exemple subtract: p2 - p3 = "+p2);
//		System.out.println();
//		
//		System.out.println("Multiply: ");
//		p1.empty(); //Empty is a function that erases all Monoms out of the Polynom.
//		p2.empty();
//		p1 = new Polynom("2.0 + 1.0x^1 + 3.0x^2");
//		p2 = new Polynom("4.0 + 2.0x^1 + 2.0x^2");
//		p1.multiply(p2);;
//		System.out.println("The use of function Multiply: p1 * p2 = "+p1); //Add(Polynom) function.
//		p2.multiply(p3);;
//		System.out.println("Another exemple Multiply: p2 * p3 = "+p2);
//		System.out.println();
//		
//		System.out.println("f: "); //This function check the value of y by placing a value on the parameter x.
//		p1.empty(); //Empty is a function that erases all Monoms out of the Polynom.
//		p2.empty();
//		p1 = new Polynom("2.0 + 1.0x^1 + 3.0x^2");
//		p2 = new Polynom("4.0 + 2.0x^1 + 2.0x^2");
//		System.out.println("The use of function f on the Polynom p1 when x is 2,5,14,17: f(2)= "+p1.f(2)+" f(5)= "+p1.f(5)+" f(14)= "+p1.f(14)+" f(17)= "+p1.f(17));
//		System.out.println("The use of function f on the Polynom p3 when x is 2,5,14,17: f(2)= "+p3.f(2)+" f(5)= "+p3.f(5)+" f(14)= "+p3.f(14)+" f(17)= "+p3.f(17));
//		System.out.println();
//		
//		System.out.println("equals: "); // This function check if two Polynoms are equals or not by returning true or false.
//		System.out.println("The use of function equals on p1 and p2: "+p1.equals(p2));
//		Polynom Ptemp = new Polynom(p1.toString());
//		System.out.println("Now let's check between p1 and Ptemp : This is Ptemp: "+Ptemp+" This is p1(a reminder): "+p1+ " and the function equals says: "+p1.equals(Ptemp));
//		System.out.println();
//		
//		System.out.println("isZero: "); //This function check if the Polynom given is the zero Polynom.
//		System.out.println("This is the Polynom p1: "+p1+" now let's send it to the function and get back: "+p1.isZero());
//		Ptemp.empty();
//		System.out.println("Now this is Ptemp: "+Ptemp+" now let's send it to the function and get back: "+Ptemp.isZero());
//		System.out.println();
//		
//		System.out.println("root: "); // This function returns one of the intersection points with the X coordinate.
//		Ptemp = new Polynom("6 + 5x^1 + 1x^2");
//		System.out.println("Ptemp is: "+Ptemp+" the root of Ptemp between the Points x=-4 and x=0 with eps=0.000001 is: "+Ptemp.root(-4, 0, 0.000001));
//		System.out.println();
//		
//		System.out.println("copy: ");
//		Ptemp.empty();
//		System.out.println("coping p1 into Ptemp. p1 is: "+p1+" Ptemp is: "+Ptemp);
//		Ptemp=(Polynom) p1.copy();
//		System.out.println("after the copy Ptemp is: "+Ptemp);
//		System.out.println();
//		
//		System.out.println("Derivative: "); // This function give the derivative of the Polynom
//		p1.empty(); p3.empty();
//		p1 = new Polynom("2.0 + 1.0x^1 + 3.0x^2");
//		p3 = new Polynom("5.0x^1 + (-2.0)x^2  + 3.0x^3 + (-7.0)x^4");
//		System.out.println("This is p1: f(x)= "+p1+" and after derivative: f(x)'= "+p1.derivative());
//		System.out.println("This is p3: f(x)= "+p3+" and after derivative: f(x)'= "+p3.derivative());
//		System.out.println();
//		
//		System.out.println("area: "); //This function is the riemann sum formula.
//		Ptemp.empty(); p1.empty();
//		Ptemp = new Polynom("1x^1");
//		p1 = new Polynom("2.0 + 1.0x^1 + 3.0x^2");
//		System.out.println("the riemann sum of p1 between the x=0 to x=10 with eps=00001 is: "+p1.area(0, 10, 0.00001));
//		System.out.println("the riemann sum of Ptemp between the x=0 to x=10 with eps=00001 is: "+Ptemp.area(0, 10, 0.00001));
//		
//		System.out.println();
//		System.out.println();
//		System.out.println("Thank you for reading this test! we worked very hard on this exercise and we deserve 100! XOXOXOX");
//
//
		Polynom p1 = new Polynom ("1*x^1+1");
		Polynom p2 = new Polynom ("1*x^1+1");
		Polynom p3 = new Polynom ("1*x^2+2*x^1+1");
		p1.multiply(p2);
		System.out.println(p1);
		System.out.println(p3);
	}

}
