package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information. 1. How
		 * many robots 2. The color of the shapes 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the
		 * requested number of robots each draw the requested shape in the requested
		 * color. The robots should execute at the same time so Threads will need to be
		 * used. Arrange the robots so that the shapes do not overlap. For full credit,
		 * define the Thread functions using lambdas. -> the arrow stuff
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product
		 * should look like.
		 */

		String numRobotsString = JOptionPane.showInputDialog("How many robots do you want?");
		int numRobots = Integer.parseInt(numRobotsString);

		String shapeColor = JOptionPane.showInputDialog("What color? R G B?");

		String numberSidesString = JOptionPane.showInputDialog("How many sides do you want the shapes to be?");
		int numberSides = Integer.parseInt(numberSidesString);
		System.out.println(numberSides);
		Thread[] threads = new Thread[numRobots];

		int x = 100;
		int y = 100;

		for (int i = 0; i < threads.length; i++) {

			Robot rob = new Robot();
			rob.setX(x);
			rob.setY(y);
			x += 100;
			//y += 40;
			if (shapeColor.equalsIgnoreCase("r")) {
				rob.setPenColor(Color.red);

			}
			if (shapeColor.equalsIgnoreCase("b")) {
				rob.setPenColor(Color.blue);
			}
			if (shapeColor.equalsIgnoreCase("g")) {
				rob.setPenColor(Color.green);
			}

			rob.penDown();
			
			threads[i] = new Thread(() -> {
				moveRobot(rob, numberSides);
				
				
			});

		}
		
		for(int i = 0; i < threads.length; i++) {
			threads[i].start();
			
		}
	

	}public static void moveRobot(Robot r, int sides) {
		
		//System.out.println(sides);
		
		float doubleangle = (float) ((180.0)*((sides - 2.0)/(sides)));
		
		System.out.println("doubleangle = " + doubleangle);
		int angle = (int) doubleangle;
		
		System.out.println("angle = " + angle);
		
		
		r.setSpeed(100);
		for(int i = 0; i < sides; i++) {
			r.move(15);
			
			r.turn(180 - angle);
			
		}
		r.hide();
		
	}
}
