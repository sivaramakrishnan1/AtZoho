class pattern {
	public static void main(String args[]) {
	int a = 6;
        for(int i=0 ; i<a ; i++)
        {
            for(int j=0 ; j<i;j++)
            {
                System.out.print(" ");
            }
            for(int j=i ; j<a;j++)
            {
				if(i % 2 == 0)
                System.out.print("#");
			else
                System.out.print("&");
				
            }
            System.out.println();
        }
	}
}