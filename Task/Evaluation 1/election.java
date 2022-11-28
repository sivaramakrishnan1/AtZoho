import java.util.Scanner;

class election {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.print("\nPercentage of people voted: ");
		double percent_voters = s.nextDouble();
		System.out.print("\nPercentage of people voted for candidate X: ");
		double percent_candidateX = s.nextDouble();
		System.out.print("\nPopulation: ");
		double population = s.nextDouble();
		
		double voted_count = (percent_voters / 100) * population; 
		double voteOfX = (percent_candidateX / 100 ) * voted_count;
		double voteOfY = voted_count - voteOfX;
		
		System.out.println("\n\nNumber of votes X got : " + (int)voteOfX + "\n\nNumber of votes Y got: " + (int)voteOfY);
		s.close();
		
	}
}