class temp {
	public static void main(String args[]) {
		int val = 6;

        int mid = (val % 2 == 0) ? val / 2 : (val / 2) -1;
        for (int i = 0; i < val-1; i++) {
            for (int j = 0; j < val * 2; j++) {
                if(i+j >= (mid * 2)-1 && j-i <= (mid * 2)-1) 
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }

        for (int i = 1; i <= val; i++) {
            for (int j = 1; j <= val * 2; j++) {
                if(i <= j && i + j >= (val * 2)) 
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
	}
}