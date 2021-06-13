/*
Author: E/16/200
Name: Lakmali B.L.S
This piece of code consists of the calculation to check whether a given complex number is in mandelbrot set
*/

import java.lang.*;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

//All the methods in Complex class can be used in Mandelbrot class
public class Mandelbrot extends Complex{

		
	
	//This createMandelbrot method checks whether a complex number regarding to a paricular point in the frame is in mandelbrot set or not
    public BufferedImage createMandelbrot (double xStart,double xEnd,double yStart, double yEnd, int max_iterations){

    	BufferedImage I;
    	double zx, zy, cX, cY, tmp;//z = zx+zyi  and c = cX+cYi  and tmp is a temporary variable
    	
    	
    	Mandelbrot complex = new Mandelbrot(); // an object is made to use the methods in the super class

    	I = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB); //size of the frame is 800x800 pixels
        
        for (int y = 0; y < 800; y++) {
            for (int x = 0; x < 800; x++) {
            	//(x,y) all the coordinates of the plane are considered
                zx = zy = 0;//initilly z0 = 0

                //the canvas should be mapped into the region of interest
                cX=(((double)x*(xEnd-xStart))/800)-Math.abs(xStart);//in default -1<x<1  x is the real part
        		cY=(((double)y*(yStart-yEnd))/800)+Math.abs(yEnd);//in default -1<y<1 y is the imaginary part

                int iterations=max_iterations;//iterations in set to maximum no of iterations given by the user or 1000 in default
                
                while (complex.complexAbsSquare(zx,zy) <= 4 && iterations > 0) {//loops no of iterations times and when absolute value of a particular complex number is less than or equal to 2

                	double[] sqOfComplex = complex.complexSquare(zx,zy);//square of the complex number is taken

                    tmp = sqOfComplex[0]+ cX;//tmp = (zx^2-xy^2)+cX
                    zy = sqOfComplex[1] + cY;//zy = (2*x*y)+cY
                    zx = tmp;
                    iterations--;
                }

		       //acccording to the value of iterations, the color is set
               I.setRGB(x, y, iterations | (iterations << 8));
            }
        }
        return I;

    }
}