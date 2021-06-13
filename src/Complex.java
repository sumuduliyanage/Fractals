/*
Author: E/16/200
Name: Lakmali B.L.S

This is  a piece of code which includes several methods to work with complex numbers
*/


public class Complex{


	private double realpart;//realpart of the complex number
	private double complexpart;//imaginary part of the complex number

	//this method does the addition of the complex numbers
	public double[] complexAdd (double realno1, double complexno1, double realno2, double complexno2){
		this.realpart = realno1+realno2;//real parts are added together
		this.complexpart = complexno1+complexno2;//imaginary parts are added together

		double[] result = new double[2];//this is the result after adding two complex numbers
		result[0] = this.realpart;//first elemnt in the array is the real part of the result
		result[1] = this.complexpart;//second elemnt in the array is the imaginary part of the reasult

		return result;
	}

	//this method calculates the quare of a complex number
	public double[] complexSquare (double realn, double complexn){
		//the square of x+yi is (x^2-y^2)+(2*x*y)i
		this.realpart = (realn*realn)-(complexn*complexn);//this is the real part:- (x^2-y^2)
		this.complexpart = 2*realn*complexn;//this is the imaginary part :- 2*x*y

		double[] result = new double[2];//result contains the imaginary part and the real part of the solution
		result[0] = this.realpart;//first element is the real part
		result[1] = this.complexpart;//second element is the imaginary part

		return result;
	}


	//this method gives the square of the absolute value of a complex number
	public double complexAbsSquare(double realn, double complexn){
		//square of absolute value of a complex number x+yi is (x^2)+(y^2)
		double complexabssquare = (realn*realn)+(complexn*complexn);//so,it is calculated
		return complexabssquare;
	}
}