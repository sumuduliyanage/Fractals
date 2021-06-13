/*
Author: E/16/200
Name: Lakmali B.L.S

This piece of code handles the errors happening when user gives the inputs
User is informed about the error and user is guided to do it in the correct way
That is the intention of this piece of code
*/

public class Error{

	//This method is called when user doesn't give any command line input argument
	//User has to say the name of the the fractal he wants draw
	public void noInput(){
		System.out.println("Error Encountered");//informing the user , there is an error
		System.out.print("You should give the name of the fractal you want to draw\n" );//the error he has done
		System.out.println("Note:You should have either of following format");//he is informed about the format he can use

		//If he want to draw a mandelbrot set, he can refer to following
		System.out.println("java Fractal Mandelbrot");//just draw according to default value
		System.out.println("java Fractal Mandelbrot x_start x_end y_start y_end");//range of interest can be also given 
    	System.out.println("java Fractal Mandelbrot x_start x_end y_start y_end iterations");//range of the value and the no of iterations can be also given

    	//If you want to draw Julia set
    	System.out.println("java Fractal Julia");//just draw according to default value
    	System.out.println("java Fractal Julia cx cy");//if you want to give new c value
    	System.out.println("java Fractal Julia cx cy iterations");//if you want to give new c value and number of iterations
    	System.exit(0);//exit from the program
	}

	//This error is when your input doesn't match with the acceptable format
	public void wrongNumberOfInputs(int x){
		System.out.println("Error Encountered");//informing the user , there is an error
		System.out.print("The Input format is wrong\n" );//the error he has done
		System.out.println("Note:You should have either of following format");//he is informed about the format he can use

		//if the user is trying to draw a mandelbrot set and he is using a wrong foramt , he is informed as below
		if (x==0){
			System.out.println("java Fractal Mandelbrot");//just draw according to default value
			System.out.println("java Fractal Mandelbrot x_start x_end y_start y_end");//range of interest can be also given 
	    	System.out.println("java Fractal Mandelbrot x_start x_end y_start y_end iterations");//range of the value and the no of iterations can be also given
		}
		//if the user is trying to draw a julia set and he is using a wrong foramt , he is informed as below
		else if(x==1){
			System.out.println("java Fractal Julia");//just draw according to default value
			System.out.println("java Fractal Julia cx cy");//if you want to give new c value
    		System.out.println("java Fractal Julia cx cy iterations");//if you want to give new c value and number of iterations
		}
		System.exit(0);//exit from the program

	}

	//When user gives a wrong fractal name , he is informed about it ,in this method
	public void wrongName(){
		System.out.println("Error Encountered");//informing the user , there is an error
		System.out.print("Name of the fractal you gave is wrong\n" );//the error he has done
		System.out.println("Note:You should have either of following format");//he is informed about the format he can use

		//If he want to draw a mandelbrot set, he can refer to following
		System.out.println("java Fractal Mandelbrot");//just draw according to default value
		System.out.println("java Fractal Mandelbrot x_start x_end y_start y_end");//range of interest can be also given 
    	System.out.println("java Fractal Mandelbrot x_start x_end y_start y_end iterations");//range of the value and the no of iterations can be also given

    	//If you want to draw Julia set
    	System.out.println("java Fractal Julia");//just draw according to default value
    	System.out.println("java Fractal Julia cx cy");//if you want to give new c value
    	System.out.println("java Fractal Julia cx cy iterations");//if you want to give new c value and number of iterations
    	System.exit(0);//exit from the program

	}
}