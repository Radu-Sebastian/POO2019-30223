import java.util.Scanner;

public class NameInverter 
{
	static int locate_char(String s, char c)
	{
		int ok = 0;
		for(int i=0; i<s.length();i++)
			if(s.charAt(i) == c)
		ok = 1;
		if(ok == 1)
			return 1;
		else return 0;
	}
	
	static String Inv(String a)
	{
		String s1 = a;
		String s2;
		String s3 = "";
		int k = 1;
		char ch = ' ';
		
		if(a == null)
			return "";
		
		if(a.startsWith("Mr."))
			{
			   s3 = "Mr.";
			   k = 0;
			}
		
		if(a.startsWith("Mrs."))
			{
			   s3 = "Mrs.";
			   k = 0;
			}
		
		if(a.startsWith("Mrs. Phd."))
			{
			   s3 = "Mrs. Phd.";
			   k = 2;
			}
		
		if(a.startsWith("Mr. Phd."))
			{
			   s3 = "Mr. Phd.";
			   k = 2;
			}
		
		if(locate_char(a,' ')==0)
			return s1;
		else
		{
			if(k==1)
			s1 = a.substring(0,(int)a.lastIndexOf(ch)); 
			if(k==0)
			s1 = a.substring(4,(int)a.lastIndexOf(ch));
			if(k==2)
			s1 = a.substring(9,(int)a.lastIndexOf(ch));
			s2 = a.substring((int)a.lastIndexOf(ch)+1,a.length());
			if(k == 0 || k == 2)
		return s2 + ", " + s1 + " " + s3;
			else
		return s2 + ", " + s1;
		}
	}
	
	public static void main(String[] args) 
	{
	  String x = new String(Inv("Mr. Phd. Radu-Sebastian Trufin"));
	  System.out.println(x);
	  
	  x = new String(Inv("Radu-Sebastian"));
	  System.out.println(x);
	  
	  x = new String(Inv("Radu-Sebastian Trufin"));
	  System.out.println(x);
	  
	  x = new String(Inv("Mr. Radu-Sebastian Trufin"));
	  System.out.println(x);
	  
	  x = new String(Inv(""));
	  System.out.println(x);
	}
}
