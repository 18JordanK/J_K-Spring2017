import java.util.*;

public class Hangman {
	String[] words = {"OPEN", "DOOR", "ABLE", "TINT", "FOND", "RANT", "TEST", "PART", "FALL",
			"WORD", "STEM", "FLEM", "WALL", "RACE", "CARS", "FOUR", "YOUR", "EGGS", "PIES", "CAKE"};
	private String word;
	String userWord = "____";
	private int numIncorrect = 6;
	private ArrayList<Character> usedWords = new ArrayList<Character>();
			
	public Hangman(){
		Random rand = new Random();
		int index = 0;
		
		this.word = words[index];
		System.out.println("You have " + numIncorrect + " incorrect guesses left.");
		
	}
	
	public int getNumIncorrect(){
		return this.numIncorrect;
	}
	
	public String getWord(){
		return this.word;
	}
	
	public String getUserWord(){
		return this.userWord;
	}
	
	public ArrayList<Character> getUsedWords(){
		return this.usedWords;
	}
	
	public void guessLetter(char letter){
		if(letter > 'Z'){
			letter -= ' ';
		}
		
		boolean contains = false;
		for(int i=0; i<this.word.length(); i++){
			if(this.word.charAt(i) == letter){
				contains = true;
			}
		}
		
		if(contains){
			userWord = fillLetters(userWord, letter);
		}else{
			System.out.println("The word does not contain \"" + letter + "\"");
			this.numIncorrect--;
			if(this.numIncorrect>0){
				System.out.println("You have " + numIncorrect + " incorrect guesses left.");
			}
		}
		System.out.println(userWord);
		if(this.numIncorrect == 0){
			System.out.println("You lost.");
		}
		this.usedWords.add(letter);
	}
	
	public String fillLetters(String s, char letter){
		
		
		char[] chars = s.toCharArray();
		for(int i=0;i<s.length();i++){
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
		
		while(!userInput.contains("no")){
			Hangman game = new Hangman();
			System.out.println(game.getUserWord());
			Scanner input = new Scanner(System.in);
			char guess;
			
			while(game.getNumIncorrect() > 0 && !game.getUserWord().equals(game.getWord())){
				System.out.println("Guess a letter.");
				guess = input.nextLine().charAt(0);
				if((guess >= 'A' && guess<= 'Z') && (guess>= 'a' && guess <= 'z')){
					game.guessLetter(guess);
				}else{
					System.out.println("Invalid guess");
					guess.input.nextLine
				}
				if(game.getUserWord().equals(game.getWord())){
					System.out.println("You won!");
				}
			}
			
			System.out.println("Do you want to play Hangman?");
			userInput = scanner.nextLine();
		}
		System.out.print("Session terminated.");
	}
}
