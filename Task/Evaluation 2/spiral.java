import java.util.Scanner;

class spiral 
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int val = s.nextInt();
		int lim = 0;
		

        for(int i = 0 ; i < val ; i++)
        {
            for(int j = 0 ; j < val ; j++)
            {				
				System.out.print((val - lim) + " "); 
				if(lim < i) lim++;				
            }
			lim = i;
			for(int j = val-1 ; j >= 1 ; j--)
            {
				if( j < i+1) lim--;
				System.out.print((val - lim) + " ");				
            }
            System.out.println();
			lim = 0;
        }
		
		for(int i = val-1 ; i > 0 ; i--)
        {
			lim = val;
            for(int j = 0 ; j < val ; j++)
            {				
				System.out.print(lim + " "); 
				if(lim > (val-i+1)) lim--;				
            }
			lim = i-1;
			for(int j = val-1 ; j >= 1 ; j--)
            {
				if( j < i) lim--;
				System.out.print((val - lim) + " ");				
            }
            System.out.println();
			lim = 0; 
        }
    }
}