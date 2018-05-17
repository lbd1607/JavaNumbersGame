import javax.swing.JOptionPane;
import java.util.Random;

/*******************************************************************
 * Laura Davis CIS 260 903
 * This is a practice program that asks a user to input his or her
 * name. It returns the string and stores it in a constant variable
 * to be used in messages throughout the program. The program then
 * asks the user to play a guessing game that involves guessing
 * an integer between 1 and 10. If the user guesses correctly, a
 * dialog box will present a message of congratulations. If the user
 * guesses incorrectly, a dialog box will present a sorry message,
 * along with the actual number. The user is then prompted to play
 * again. If the user replies "y", the game starts over, while 
 * remembering the user's name. If the user replies with anything
 * other than "y", a dialog replies with a goodbye message and the
 * user's name. This program utilizes if else statements, a while
 * loop, methods, the imported random function, and the JOptionPane.
 * Had a problem with the if else in main. Strings are objects,
 * so they must use parameter checks, NOT operators like "==". 
 ******************************************************************/

public class NumbersGame
{
	public static void main(String[] args)
	{
		
		//Declare and initialize variables
		String game;
		final String USER_NAME;
		
		/**
		* Calls nameMethod and stores
		* USER_NAME as a constant variable. 
		* Also contains the user-controlled if-else loop
		* that determines whether or not the game is continued.
		*/
		USER_NAME = nameMethod();

		game = JOptionPane.showInputDialog("Would you like to "
				+ "play a guessing game? \n y = yes / n = no");
				
		if(game.equals("y"))
			{
			methodOne(USER_NAME);
			
			}
		else
			{
			JOptionPane.showMessageDialog(null, 
					"Bye " + USER_NAME + "!");
			}
		
		//exits the JObjectPane
			System.exit(0);
		
	}//end of main
	
		/**
		 * Gets the USER_NAME from user input and stores it in a final String variable.
		 * The USER_NAME is returned to be used by other parts of the program.
		 * 
		 * @return user's name to be used in another part of the program
		 */
		//This method retrieves and returns the user's name.
		public static String nameMethod()
		{
			
		final String USER_NAME;
		
		//Asks the user for his or her name.
		USER_NAME = JOptionPane.showInputDialog("Hi! What is your "
				+ "name? ");
		
		return USER_NAME;

		} //end of nameMethod
		
		/**
		 * USER_NAME is passed into this method to be used during the game.
		 * This prevents the user from needing to re-enter their name each
		 * time the game starts over. This method uses while and nested if-else
		 * loops to execute the numbers game. 
		 * 
		 * @param USER_NAME object that holds user name
		 */
		//This method includes the guessing game while loop.
		public static void methodOne(final String USER_NAME)
		{
			//Declare local variables
			String input_string;
			String again = "y";
			int someNumber;
			int answerNumber;
			
			//Creates a random object
			Random randomNumber = new Random();
			
			while (again.equalsIgnoreCase("y"))
			{
				//Gets a randomNumber
				someNumber = randomNumber.nextInt(10) + 1;
		
				//Asks the user to pick a number between 1 and 10.
				input_string = JOptionPane.showInputDialog("Guess a "
					+ "number between 1 and 10: ");
	
				//Converts the answer number to an integer.
				answerNumber = Integer.parseInt(input_string);
	
				//Determines whether the user guessed the right number.
				if (answerNumber == someNumber)
				{
					JOptionPane.showMessageDialog(null, 
						"You are correct! " + USER_NAME);
				}
				else
					{
					JOptionPane.showMessageDialog(null, 
						"Sorry, " + USER_NAME + ". You are wrong. \n"
								+ "The number is: " + someNumber);
					}
		
				again = JOptionPane.showInputDialog("Would you like to guess "
					+ "again? \n y = yes / n = no");
		
						
			}//end of while
			
			JOptionPane.showMessageDialog(null, 
					"Bye " + USER_NAME + "!");
			
		}//end of methodOne
		
}//end of class
