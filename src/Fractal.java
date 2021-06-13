/*
Author: E/16/200
Name: Lakmali B.L.S
This is the class which consists the main method
The paramters to draw the fractals are in this class 
All the input argumnets are taken in here and all the errors are handled as well
This class is a subclass of JPanel
*/

//All the needed classes are imported
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Fractal extends JPanel{

    private static double xStart = -1;//start of the real part of the region of interest
    private static double xEnd = 1;;//end of the real part of the region of interest
    private static double yStart = -1;;//start of the imaginary part of the region of interest
    private static double yEnd = 1;;//end of the imaginary part of the region of interest
    private static int iterations = 1000;//default no of iterations
    private static int fract = 0;//fract is 0 for mandelbrot and fract is 1 for julia
    private static double cx = -0.4;//default of real part of c 
    private static double cy = 0.6;//default of imaginary part of c

    //this constructor is called when mandelbrot set is drawn
    Fractal (double xStart, double xEnd, double yStart, double yEnd, int iterations){
        setPreferredSize(new Dimension(800,800));//size is set
        fract = 0;//for mandelbrot
    }

    //this constructor is called when julia set is drawn
    Fractal (double cx, double cy, int iterations){
        setPreferredSize(new Dimension(800,800));//size is set
        fract = 1;//for julia
    }

    //this method is called when we call setContentPane method in main method
     public  void paintComponent(Graphics g) 
    { 
        // call paintComponent from parent class 
        super.paintComponent(g); 

        //for mandelbrot
        if (fract == 0){
             Mandelbrot mandelbrot = new Mandelbrot();//an object is called
            
            BufferedImage I = mandelbrot.createMandelbrot(xStart,xEnd,yStart,yEnd,iterations);//method in Julia class is called

            g.drawImage(I, 0, 0, null);//picture is drawn
        }
       
       //for 
        if (fract == 1){
            Julia julia = new Julia();
            BufferedImage I = julia.createJulia(cx, cy, iterations);//method in the mandelbrot is called

            g.drawImage(I, 0, 0, null);//picture is drawn
        }
    }




    public static void main(String[] args){

        //Error object is made
        Error error = new Error();

        //when user give no argument
        if (args.length == 0){
            error.noInput();//noinput method is implemented in Error class
        }

        //for mandelbrot
        if (args[0].equals("Mandelbrot")){

            JFrame frame = new JFrame("Mandelbrot Set"); //name is set
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //can be closed
            frame.setBounds(10, 10, 800, 800);//size 
            frame.setResizable(false);//can't resize the frame            

            if (args.length == 1){//just draw the mandelbrot set for default values
                frame.setContentPane(new Fractal(xStart,xEnd,yStart,yEnd,iterations));//particular constructor is called
            }
            else if (args.length == 5){//draw mandelbrot set for this given range of interest
                xStart = Double.parseDouble(args[1]);
                xEnd = Double.parseDouble(args[2]);
                yStart = Double.parseDouble(args[3]);
                yEnd = Double.parseDouble(args[4]);
                frame.setContentPane(new Fractal(xStart,xEnd,yStart,yEnd,iterations));//particular constructor is called
            }
            else if (args.length == 6){//draw mandelbrot set for this given range of interest and no of iterations
                xStart = Double.parseDouble(args[1]);
                xEnd = Double.parseDouble(args[2]);
                yStart = Double.parseDouble(args[3]);
                yEnd = Double.parseDouble(args[4]);
                iterations = Integer.parseInt(args[5]);
                frame.setContentPane(new Fractal(xStart,xEnd,yStart,yEnd,iterations));//particular constructor is called

            }
            else{
                error.wrongNumberOfInputs(0);//when some one gives wrong format as command line arguments
            }

            frame.pack(); 
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);//frame can be visible

        }
        //for Julia set
        else if (args[0].equals("Julia")){
            JFrame frame = new JFrame("Julia Set"); //name is set
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //can be closed
            frame.setBounds(10, 10, 800, 800);//size is set
            frame.setResizable(false);//can't be resized

            if (args.length == 1){//just draw the Julia set for default values
                frame.setContentPane(new Fractal(cx,cy,iterations));//particular constructor is called

            }
            else if (args.length == 3){//when user gives the c value
                cx = Double.parseDouble(args[1]);
                cy = Double.parseDouble(args[2]);
                frame.setContentPane(new Fractal(cx,cy,iterations));//particular constructor is called
            }
            else if (args.length == 4){//when user gives c value and iterations
                cx = Double.parseDouble(args[1]);
                cy = Double.parseDouble(args[2]);
                iterations = Integer.parseInt(args[3]);
                frame.setContentPane(new Fractal(cx,cy,iterations));//particular constructor is called
            }
            else{
                error.wrongNumberOfInputs(1);//when the input format is incorrect
            }
            frame.pack(); 
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);//can be seen

        }
        else{
            error.wrongName();//when user gives a wrong name to fractal
        }
    }

}