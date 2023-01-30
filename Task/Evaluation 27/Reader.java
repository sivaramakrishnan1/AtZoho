class Reader
{
	public static void main(String args[])
	{
		try {
			// int in = System.in.read();
			out : while(true)
			{
				clean();
				switch(System.in.read())
				{
					case 'w' : System.out.println("UP"); break;
					case 'a' : System.out.println("LEFT"); break;
					case 's' : System.out.println("DOWN"); break;
					case 'd' : System.out.println("RIGHT"); break;
					case 'q' : break out;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public static void clean() throws Exception
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}