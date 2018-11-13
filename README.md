This project is built to create and use Polynoms and Monoms objects.
The project allows to build Monoms And Polynoms objects, either with a String or by
creating a new object.
The user of this project can add, subtract, multiply and derivate Monoms and
Polynoms. In addition, the user can find a root of a Polynom in a certain segment, and
compute area's using Riemann's Integral.
▪ In the class 'Monom':
• There are 2 constructors. A default constructor and a copy constructor. if the
power is negative, the Monom will be zero.
• The user can use the following methods:
1. add(Monom m1) - Adding 2 Monoms with the only if they have the same power.
2. derivative() - Returns a new Monom which is the derivative of this Monom.
3. f(double x) - Returns the value of f(x).
4. get_coefficient() - Returns the coefficient of the Monom.
5. get_power() - Returns the power of the Monom.
6. multiply - (Monom m1) Multiplies 2 Monoms.
7. toString() - Returns a string that represent the Monom.


▪ In the class 'Polynom':
• There are 3 constructors:
1. Default constructor - initialize to the zero Polynom.
2. String constructor - will build a Polynom from a String. will only accept
Polynom of the shape ax^b or a*x^b (even if a/b=0/1 or a=-1 it needs to be
written). if the Polynom starts correctly but continues wrongly, it will build
what is correct.
Example: input:"1*x^2 + (-5x^1)+-8*x^0 hello world"
what the Polynom will be: -8.0 + -5.0x + 1.0x^2
3. copy constructor - copies a Polynom to another.
• The user can use the following methods:

1. add(myMath.Monom m1) Add m1 to this Polynom.
2. add (myMath.Polynom_able p1) Add p1 to this Polynom.
3. area(double x0, double x1,double eps) - Compute Riemann's Integral over this Polynom,
starting from x0, till x1 using eps size steps, see:
https://en.wikipedia.org/wiki/Riemann_integral
The algorithm is like this:
while x0<= at x1:
  *  Make x0=x0+eps.
  * sum x0*|f(eps)|.
  * advance x0 by eps.
  * return sum.
4. copy() Create a deep copy of this Polynom.
5. derivative() Creates a new Polynom which is the derivative of this Polynom.
6. equals (myMath.Polynom_able p1) - Test if this Polynom is equals to p1.
7. f(double x) Sums the value of Monom's f(x) for each Monom in the Polynom.
8. isZero() - Test if this is the Zero Polynom.
9. iteretor() - A Java iterator to go over the Polynom
10. multiply (myMath.Polynom_able p1) - Multiply this Polynom by p1
11. root(double x0, double x1,double eps)- Returns the x-axis cutting point of the Polynom with
an eps deviation, in the received segment, using the bisection method.
This function was written with the help of:
https://en.wikipedia.org/wiki/Bisection_method
12. sort() Sorting the Polynom's using the Monom_comperator and the Java ArrayList Sort.
13. substract (myMath.Polynom_able p1) - Subtract p1 from this Polynom.
14. toString() - Concatenation of the Polynom.

▪ Monom_comperator class - A class that compares between Monoms - will return 0
if they are equal.
