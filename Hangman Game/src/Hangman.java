import java.util.Random;
import java.util.*;

public class Hangman {
	String[] words = {"OPEN", "DOOR", "ABLE", "TINT", "FOND", "RANT", "TEST", "PART", "FALL",
			"WORD", "STEM", "FLEM", "WALL", "RACE", "CARS", "FOUR", "YOUR", "EGGS", "PIES", "CAKE"};
	private String word;
	
	public Hangman(){
		Random rand = new Random();
		int index = rand.nextInt(20);
		
		this.word = words[index];
		
	}
	
	public String getWord(){
		return this.word;
	}
	
	public boolean containsLetter(char letter){
		boolean doesContain = false;
		for(int i=0; i<this.word.length();i++){
			if(this.word.charAt(i) == letter){
				doesContain = true;
			}
		}
		return doesContain;
	}
	
	public String fillLetters(String s, char letter){
		char[] chars = s.toCharArray();
		for(int i=0;i<s.length()-1;i++){
			if(this.word.charAt(i) == letter){
			    chars[i] = letter;
			}
		}
		return String.valueOf(chars);
	}
	 
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to play Hangman?");
		String userInput = scanner.nextLine();
		
		while(userInput.equalsIgnoreCase("YES")){
			Hangman game = new Hangman();
			Scanner input = new Scanner(System.in);
			char guess;
			String totalGuess = "";
			
			for(int i=0; i<game.getWord().length();i++){
				totalGuess += "_";
			}
			System.out.println(totalGuess);
			
			while(!totalGuess.equals(game.getWord())){
				System.out.println("Guess a letter.");
				guess = input.nextLine().charAt(0);
				
				if(game.containsLetter(guess)){
					totalGuess = game.fillLetters(totalGuess, guess);
				}
				System.out.println(totalGuess);
			}
			
			System.out.println("Do you want to play Hangman?");
			userInput = scanner.nextLine();
		}
		System.out.println("Session terminated");
	}
	
}
