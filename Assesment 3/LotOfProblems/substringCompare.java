class substringCompare
{
	public static void main(String args[])
	{
		String s1 = "God reversed is Dog", s2 = "Dog reversed is God";
		System.out.println(s1.substring(0, 3)+ " " + s2.substring(16, 19));
		System.out.println((s1.substring(0, 3)).equals(s2.substring(16, 19)));
	}
}