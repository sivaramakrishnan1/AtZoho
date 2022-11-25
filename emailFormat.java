class emailFormat {
    
	public static void main(String args[]) 
	{
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		emailFormat format = new emailFormat();
		int count = format.numUniqueEmails(emails);
		System.out.println(count);
	}
	
	public int numUniqueEmails(String[] emails) 
    {
		for(int i = 0 ; i < emails.length ; i++)
		{
			emails[i] = formatEmail(emails[i]);
		}
		
		for(int i = 0 ; i < emails.length - 1 ; i++)
		{
			for(int j = i+1 ; j < emails.length ; j++)
			{
				if(emails[i].equals(emails[j])) emails[j] = "";
			}
		}
		
		int count = 0;
		
		for(int i = 0 ; i < emails.length ; i++) 
			if(emails[i] != null) count++;
		
		return count;
    }

    public String formatEmail(String mail)
    {
        String newEmail = "";
		boolean inDomainArea = false;

        for(int i = 0 ; i < mail.length() ; i++)
        {            
            if(mail.charAt(i) == '+')
                while(i < mail.length() && mail.charAt(i) != '@' ) i++;
			if(mail.charAt(i) != '@') inDomainArea = true;
			if(!inDomainArea && mail.charAt(i) == '.') continue;
			newEmail += mail.charAt(i);			
        }
		
		return newEmail;
    }
}