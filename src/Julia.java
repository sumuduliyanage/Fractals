/*
Author: E/16/200
Name: Lakmali B.L.S
This piece of code consists of the calculation to check whether a given complex number is in Julia set
*/

import java.lang.*;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


//All the methods in Complex class can be used in Julia class
public class Julia extends Complex{


	//This createJulia method checks whether a complex number regarding to a paricular point in the frame is in Julia set or not
	public BufferedImage createJulia (double cx, double cy, int max_iterations){

    	BufferedImage I;
    	double zx, zy,tmp;//z = zx+zyi and tmp is a temporary register
    	
    	
    	Julia complex = new Julia();//an object is made to use the methods in super class Complex

    	I = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);//size of the frame is 800x800 pixels
        
        for (int y = 0; y < 800; y++) {
            for (int x = 0; x < 800; x++) {
            	//(x,y) all the coordinates of the plane are considered
                zx = zy = 0;
                //The points in the canvas are mapped into a range
                zx=(((double)x*2)/800)-1;//In Julia set, zx is always between -1 and 1
        		zy=1-(((double)y*2)/800);//zy is also between -1 and 1

                int iterations=max_iterations;//iterations in set to maximum no of iterations given by the user or 1000 in default
                
                while (complex.complexAbsSquare(zx,zy) <= 4 && iterations > 0) {//loops no of iterations times and when absolute value of a particular complex number is less than or equal to 2

                	double[] sqOfComplex = complex.complexSquare(zx,zy);//z^2 is considered
                	//next z value is calculated below
                    tmp = sqOfComplex[0]+ cx;//next zx
                    zy = sqOfComplex[1] + cy;//next zy
                    zx = tmp;
                    iterations--;
                }

		       //according to the value of iteratios, the color is set
               I.setRGB(x, y, iterations | (iterations << 8));
            }
        }
        return I;

    }

}