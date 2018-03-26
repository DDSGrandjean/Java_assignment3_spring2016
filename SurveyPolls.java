//DYLAN GRANDJEAN
//Assignment Java-A3
//Program designed to display polls based on user input

import java.util.Scanner;

public class SurveyPolls
{
	public static void main (String[] args)
	{
		//variable declaration and instantiation
		int agree = 0,
			disagree = 0,
			noOpinion = 0,
			userInput;
		double percentTotal,
			   percentAgree,
			   percentDisagree,
			   percentNoOpinion;

		//instantiate the Scanner
		Scanner keyboard = new Scanner(System.in);

		//begin the program, display programmer's name and prompt user for first input
		System.out.println("DYLAN GRANDJEAN\n");
		System.out.print("Response: <1=agree, 2=disagree, 3=no opinion, -1=exit>: ");
		userInput = keyboard.nextInt();

		//declare the sentinel value for the loop
		while (userInput != -1)
		{
			//user entered 1 <agree> - add a count to agree and prompt for new input
			if (userInput == 1)
				agree++;
			//user entered 2 <disagree> - add a count to disagree and prompt for new input
			else if (userInput == 2)
				disagree++;
			//user entered 3 <no opinion> - add a count to noOpinion and prompt for new input
			else if (userInput == 3)
				noOpinion++;
			//user entered an invalid number, display error message and prompt for new input
			else
				System.out.printf("Invalid response: %d\n", userInput);

			System.out.print("Response: <1=agree, 2=disagree, 3=no opinion, -1=exit>: ");
			userInput = keyboard.nextInt();
		}

		//check for the number of valid user inputs before displaying the board
		if (agree > 0 || disagree > 0 || noOpinion > 0)
		{
			//calculate the output variables
			percentTotal = agree + disagree + noOpinion;
			percentAgree = (agree / percentTotal) * 100;
			percentDisagree = (disagree / percentTotal) * 100;
			percentNoOpinion = (noOpinion / percentTotal) * 100;

			//display response, frequency, percentage, and histogram using for loops to display asterisks
			System.out.println("\nRESPONSE\tFREQUENCY\tPERCENT\t\tHISTOGRAM");
			System.out.printf(" Agree%15d\t\t%-1.2f%%\t\t", agree, percentAgree);
			for (int i = 0; i < agree; i++)
				System.out.print("*");
				System.out.println();
			System.out.printf(" Disagree%12d\t\t%-1.2f%%\t\t", disagree, percentDisagree);
			for (int i = 0; i < disagree; i++)
				System.out.print("*");
				System.out.println();
			System.out.printf(" No Opinion%10d\t\t%-1.2f%%\t\t", noOpinion, percentNoOpinion);
			for (int i = 0; i < noOpinion; i++)
			System.out.print("*");
				System.out.println("\n");
		}
		//user entered an invalid number THEN -1 <exit> - avoid display error and blank percentage table
		else
			System.out.println("No surveys processed\n");
	}
}
