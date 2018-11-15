

This project is built to create and use Polynoms and Monoms objects. The project allows to build Monoms And Polynoms objects, either with a String or by creating a new object. The user of this project can add, subtract, multiply and derivate Monoms and Polynoms. In addition, the user can find a root of a Polynom in a certain segment, and compute area's using Riemann's Integral. ▪ In the class 'Monom': • There are 2 constructors. A default constructor and a copy constructor. if the power is negative, the Monom will be zero. • The user can use the following methods:

    add(Monom m1) - Adding 2 Monoms with the only if they have the same power.
    derivative() - Returns a new Monom which is the derivative of this Monom.
    f(double x) - Returns the value of f(x).
    get_coefficient() - Returns the coefficient of the Monom.
    get_power() - Returns the power of the Monom.
    multiply - (Monom m1) Multiplies 2 Monoms.
    toString() - Returns a string that represent the Monom.

▪ In the class 'Polynom': • There are 3 constructors:

    Default constructor - initialize to the zero Polynom.

    String constructor - will build a Polynom from a String. will only accept Polynom of the shape ax^b or ax^b (even if a/b=0/1 or a=-1 it needs to be written). if the Polynom starts correctly but continues wrongly, it will build what is correct. Example: input:"1x^2 + (-5x^1)+-8*x^0 hello world" what the Polynom will be: -8.0 + -5.0x + 1.0x^2

    copy constructor - copies a Polynom to another. • The user can use the following methods:

    add(myMath.Monom m1) - Add m1 to this Polynom.

    add (myMath.Polynom_able p1) - Add p1 to this Polynom.

    area(double x0, double x1,double eps) - Compute Riemann's Integral over this Polynom, starting from x0, till x1 using eps size steps, see: https://en.wikipedia.org/wiki/Riemann_integral The algorithm is like this: while x0<= at x1:

    Make x0=x0+eps.
    sum x0*|f(eps)|.
    advance x0 by eps.
    return sum. Note: The function calculates the integral, whetear the function is below the x-axis or above

    copy() Create a deep copy of this Polynom.
    derivative() Creates a new Polynom which is the derivative of this Polynom.
    equals (myMath.Polynom_able p1) - Test if this Polynom is equals to p1.
    f(double x) Sums the value of Monom's f(x) for each Monom in the Polynom.
    isZero() - Test if this is the Zero Polynom.
    iteretor() - A Java iterator to go over the Polynom
    multiply (myMath.Polynom_able p1) - Multiply this Polynom by p1
    root(double x0, double x1,double eps) - Returns the x-axis cutting point of the Polynom with an eps deviation, in the received segment, using the bisection method. This function was written with the help of: https://en.wikipedia.org/wiki/Bisection_method
    sort() - Sorting the Polynom's using the Monom_comperator and the Java ArrayList Sort.
    substract (myMath.Polynom_able p1) - Subtract p1 from this Polynom.
    toString() - Concatenation of the Polynom.

▪ Monom_comperator class - A class that compares between Monoms - will return 0 if they are equal.

▪ Graph - present the Polynom and it's extream in a 2d graph.
