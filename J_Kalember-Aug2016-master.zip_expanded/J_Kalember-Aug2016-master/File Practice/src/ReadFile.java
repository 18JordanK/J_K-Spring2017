import java.io.*;
import java.util.*;

public class ReadFile {
	public static void fileReader() throws FileNotFoundException{
		File weather = new File("./resources/weather.txt");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(weather);
		double currNum = input.nextDouble();
		
		for(int i=0;i<weather.length();i++){
			double nextNum = input.nextDouble();
			double difference = nextNum - currNum;
			
			System.out.println(currNum + " to " + nextNum + ", change = " + difference);
			
			currNum = nextNum;
		}
	}
	public static void main(String[] args){
		fileReader();
	}
}
