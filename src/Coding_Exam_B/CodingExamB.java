package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class CodingExamB {
	 /*
	 * This is a logging program for collecting TODO comments in a program. The program will scan
	 * Through all the files in the Coding_Exam_B/classes package, and collect all the comments that start
	 * with //TODO: and write them to their own file. See the TODO_Log_example.txt file for an idea of what 
	 * the final file output will look like.
	 */
	static String combined = "";
	static int count = 0;
	public static String getLoggingInfo(String fileName) {
		/*
		 * 1. Complete the getLoggingInfoMethod.
		 *    The method takes in a String for a file and returns a String. 
		 *    The method will open the file a read through it. It will then 
		 *    take all the comments that begin with //TODO: and combine them 
		 *    into one large String. The string will also state the file name and
		 *    the line number for where each TODO was found. 
		*/
		combined = "";
		count = 0;
			try {
				
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				combined += "\nFile: " +fileName + "\n";
				
				br.lines().forEach((String s)->{
				count++;
					
					if(s.contains("TODO")) {
					combined += count+ ": " + s+ "\n";
				}
				//this only gets the last todo of each thing so gotta figure out how to fix that
				//if I do +=s then for some reason it repeats a ton of stuff
				//gotta figure out exactly what lines() does
				
				
			});
			
			} catch (FileNotFoundException e) {
				

				e.printStackTrace();
			}
			
			
			
		combined = combined.replaceAll("\t", "");
			
			
			//System.out.println("combined:"  + combined);
			//not sure how to get line number
		return combined;
	}
	
	public static void main(String[] args) {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java");
		
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java");
		
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java");
		
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java");
		
		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should match TODO_Log_example.txt. 
		 */
		try {
			FileWriter fw = new FileWriter("TODO_Log.txt");
			fw.write(finalLogString);
			fw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
