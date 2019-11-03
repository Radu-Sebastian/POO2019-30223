import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Polynom 
{	
	static final double epsilon = 0.00001;
	
	static void writepoly(int []a, int x, PrintWriter pw)
	{
		System.out.println(" ");
		if(a[0]!=1)
			{
			   pw.print(a[0] + "x^" + (x-1) + " ");
			   System.out.print(a[0] + "x^" + (x-1) + " ");
			}
		else
			{
			   pw.print("x^" + (x-1) + " ");
			   System.out.print("x^" + (x-1) + " ");
			}
		
		int i=1;
		while(i<x)
		{
			if(a[i]!=0)
			{
				    if(a[i] == -1 && i < x-2)
			   {
				    	pw.print("-x^" + (x-i-1) + " ");
				    	System.out.print("-x^" + (x-i-1) + " ");
			   }
				    if(a[i] < 0 && a[i] !=-1 && i < x-2)
			   {
				    	pw.print(a[i] + "x^" + (x-i-1) + " ");
				    	System.out.print(a[i] + "x^" + (x-i-1) + " ");
			   }
					if(a[i]!=1 && a[i]> 0 && i < x-2)
			   {
						pw.print("+ " + a[i] + "x^" + (x-i-1) + " ");
						System.out.print("+ " + a[i] + "x^" + (x-i-1) + " ");
			   }
					if(a[i]==1 && i < x-2)
			   {
						pw.print("+ " + "x^" + (x-i-1) + " ");
						System.out.print("+ " + "x^" + (x-i-1) + " ");
			   }
					if(a[i]==1 && i == x-2)
			   {
						pw.print("+ " + "x" + " ");
						System.out.print("+ " + "x" + " ");
			   }
					if(a[i]==-1 && i == x-2)
			   {
						pw.print("- " + "x" + " ");
						System.out.print("- " + "x" + " ");
			   }
					if(a[i]> 0 && a[i]!=1 && i == x-2)
			   {
						pw.print("+ " + a[i] + "x" + " ");
						System.out.print("+ " + a[i] + "x" + " ");
			   }
					if(a[i]< 0 && a[i]!=-1 && i == x-2)
			   {
						pw.print(a[i] + "x" + " ");
						System.out.print(a[i] + "x" + " ");
			   }
					if(a[i]==1 && i == x-1)
			   {
						pw.print("+ 1 "  + " ");
						System.out.print("+ 1 "  + " ");
			   }
					if(a[i]==-1 && i == x-1)
			   {
						pw.print("- 1 "  + " ");
						System.out.print("- 1 "  + " ");
			   }
					if(a[i]> 0 && a[i]!=1 && i == x-1)
			   {
						pw.print("+ " + a[i]  + " ");
						System.out.print("+ " + a[i]  + " ");
			   }
					if(a[i]< 0 && a[i]!=-1 && i == x-1)
			   {
						pw.print(a[i]  + " ");
						System.out.print(a[i]  + " ");
			   }
			}
			i++;
		}
	}
	
	static void addpoly(int []a, int []b, int x, int y, int k, PrintWriter pw)
	 {
		int [] c = new int[200];
		int mx = 0;
		int mn = 0;
		
		if(x>y)
		{
			mx = x;
			mn = y;
		}
		else
		{
			mx = y;
		    mn = x;
		}
		
		if (mx==x)
			for(int i=0; i<mx; i++)
				c[i] = a[i];
		else
			for(int i=0; i<mx; i++)
				c[i] = b[i];

		int j = 0;
		
		if(k==1)
		for(int i=mx-mn; i<mx; i++)
		{
			c[i] = a[i] + b[j];
			j++;
		}
		
		if(k==0)
		for(int i=mx-mn; i<mx; i++)
		{
			c[i] = a[i] - b[j];
			j++;
		}	
		
		writepoly(c,mx,pw);
	 }
	
	static int evaluate(int []a, int x, int n)
	{
		int rez = a[0];
		for (int i=1; i<x; i++) 
	        rez = rez * n + a[i]; 
		return rez;
	}
	
	static double evaluatef(double []a, int x, double n)
	{
		double rez = a[0];
		for (int i=1; i<x; i++) 
	        rez = rez * n + a[i]; 
		return rez;
	}
	
	static double DEI(double s , double d, double []a, int x)
	{
		if(d-s <= epsilon)
	        return s;
	       else
	       {
	    	   double m = (s+d)/2;
	    	   double k = evaluatef(a,x,m);
	         if(Double.compare(k,0)==0)
	            return m;
	         else
	         if(evaluatef(a,x,m)<0)
	            return DEI(m,d,a,x);
	         else
	            return DEI(s,m,a,x);
	       }
	}
	
	static void scalar(int []a, int x, int n, PrintWriter pw)
	{
		int [] d = new int[100];
		for (int i=0; i<x; i++) 
			d[i] = a[i] * n;
	     writepoly(d,x,pw); 
	}
	
	static void multiply(int []a, int []b, int x, int y, PrintWriter pw)
	{
		int [] e = new int[1000];
		int nre = x+y-1;
		
		for (int i=0; i<nre; i++) 
			e[i] = 0;
		
		for(int i=x-1; i>=0; i--)
		{
			for(int j=y-1; j>=0; j--)
				e[i+j] = e[i+j] + a[i]*b[j];
		}
	     writepoly(e,nre,pw); 
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		try {
			File out = new File("out.txt");
			if(!out.exists()) {
				out.createNewFile();	
			}
			
			PrintWriter pw = new PrintWriter(out);
			File file = new File("D:\\Eclipse\\Assignement2\\src\\polynom.txt");
			Scanner s = new Scanner(file);
			int ctr = 0;
			
			String s1 = s.nextLine();
			String s2 = s.nextLine();
			
			int x = s1.length();
			int [] a = new int[100];
			int y = s2.length();
			int [] b = new int[100];
			
			int nra = 0;
			int nrb = 0;
			
			a[0] = (s1.charAt(0)-'0');
			b[0] = (s2.charAt(0)-'0');
			nra++;
			nrb++;
			
			  for(int i=1; i<x; i++)
			 {
				if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9')
				{
					if(s1.charAt(i-1)=='-' && i!=1)
					{
						a[nra] = (-1)*(s1.charAt(i) -'0');
				        nra = nra + 1;
					}
					else
					{
					    a[nra] = (s1.charAt(i) -'0');
			            nra = nra + 1;
					}
			    }
			 }
			  
			 for(int i=1; i<y; i++)
			 {
				if(s2.charAt(i) >= '0' && s2.charAt(i) <= '9')
				{
					if(s2.charAt(i-1)=='-' && i!=1)
					{
						b[nrb] = (-1)*(s2.charAt(i) -'0');
				        nrb = nrb + 1;
					}
					else
					{
					    b[nrb] = (s2.charAt(i) -'0');
			            nrb = nrb + 1;
					}
			    }
			 }
			 
			 pw.print("P(x) = ");
			 writepoly(a,nra,pw);
			 pw.println(" ");
			 pw.print("Q(x) = ");
			 writepoly(b,nrb,pw);
			 pw.println(" ");
			 
			 String s3 = s.nextLine();
			 
			 double []la = new double[100];
			 for(int i=0;i<nra;i++)
				 la[i] = a[i];
			 
			 double []lb = new double[100];
			 for(int i=0;i<nrb;i++)
				 lb[i] = b[i];
			 
			 pw.println("O solutie a ecuatiei P(x) = 0 in intervalul (-1,2) este " + DEI(-1,2,la,nra));
			 pw.println("O solutie a ecuatiei Q(x) = 0 in intervalul (-1,2) este " + DEI(-1,2,lb,nrb));
			 
			 while(s.hasNextLine())
			{
				 if(s3.equals("ADD"))
				{
					 pw.print("P(x) + Q(x) = ");
					 addpoly(a,b,nra,nrb,1,pw);
					 pw.println(" ");
			    }
				 
				 if(s3.equals("SUBTRACT"))
					{
					     pw.print("P(x) - Q(x) = ");
						 addpoly(a,b,nra,nrb,0,pw);
						 pw.println(" ");
				    }
				 
				 if(s3.startsWith("EVAL"))
					{
					     int n = Integer.parseInt(s3.substring(5,6));
					     pw.print("P(" + n + ") = " + evaluate(a,nra,n));
					     pw.println(" ");
					     pw.print("Q(" + n + ") = " + evaluate(b,nrb,n));
					     pw.println(" ");
				    }
				 
				 if(s3.startsWith("MUL_SCAL"))
					{
					     int n = Integer.parseInt(s3.substring(9,10));
					     pw.print(n + "P(x) = ");
						 scalar(a,nra,n,pw);
						 pw.println(" ");
						 pw.print(n + "Q(x) = ");
						 scalar(b,nrb,n,pw);
						 pw.println(" ");
				    }
				 
				 if(s3.equals("MULTIPLY"))
					{
					     pw.print("P(x) * Q(x) = ");
						 multiply(a,b,nra,nrb,pw);
						 pw.println(" ");
				    }
				 
			     s3 = s.nextLine();
			     pw.close();
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}

