import java.util.Scanner;

class grade {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Total number of students: ");
		int tot_students = s.nextInt();
		
		System.out.println("Percentage of students who got A grade: ");
		double percentage_graded_A = s.nextDouble();
		
		System.out.println("Number of boys who got A grade: ");
		int boys_graded_A = s.nextInt();
		
		double girls_graded_A = ((percentage_graded_A / 100 ) * tot_students );
		girls_graded_A -= boys_graded_A;
		girls_graded_A = (girls_graded_A < 0) ? girls_graded_A * -1 : girls_graded_A ;
		
		System.out.println("Girls who got A grade: ");
		System.out.println((int)girls_graded_A);
		s.close();
	}
}