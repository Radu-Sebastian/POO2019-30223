import java.math.BigDecimal;
import java.util.Random;

public class MatrixOperations 
{
	static double [][]add(double [][]a, double [][]b , int n, int m)
	{
		double [][]c = new double[100][100];
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				c[i][j] = a[i][j] + b[i][j];
		return c;
	}
	
	static double [][]subtract(double [][]a, double [][]b , int n, int m)
	{
		double [][]c = new double[100][100];
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				c[i][j] = a[i][j] - b[i][j];
		return c;
	}
	
	static double [][]multiply(double [][]a, double [][]b , int n)
	{
		 int i,j,k; 
		 double [][]c = new double[100][100];
		    for(i=1; i<=n; i++) 
		    { 
		        for (j=1; j<=n; j++) 
		            for (k=1; k<=n; k++) 
		            	c[i][j] = a[i][k] * b[k][j];
		    }
		return c;
	}
	
	static double [][]multiplyScalar(double [][]a, int n, int m, int k)
	{
		double [][]p = new double[100][100];
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				p[i][j] = k * a[i][j];
		return p;
	}
	
	static void areEqual(double [][]a, double [][]b, int n, int m)
	{
		int ok = 1;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				if(a[i][j] != b[i][j])
					ok = 0;
		if(ok == 1)
			System.out.println("Matrices are equal.");
		else
			System.out.println("Matrices are not equal.");
	}
	
	static void isZeroMatrix(double [][]a, int n, int m)
	{
		int ok = 1;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				if(a[i][j] != 0)
					ok = 0;
		if(ok == 1)
			System.out.println("Matrix contains only 0s.");
		else
			System.out.println("Matrix does not contain only 0s.");
	}
	
	static void isIdentityMatrix(double [][]a, int n, int m)
	{
		int ok = 1;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				{
				  if(i!=j && a[i][j] != 0)
					ok = 0;
		          if(i==j && a[i][j] != 1)
			        ok = 0;
				}
		if(ok == 1)
			System.out.println("Matrix is an identity matrix.");
		else
			System.out.println("Matrix is not an identity matrix.");
	}
	
	static float fillDegree(double [][]a, int n, int m)
	{
		float k = 0;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				if(a[i][j] != 0)
		k = k + 1;
		return k/n/n;
	}
	
	static void printMatrix(double [][]a, int n, int m)
	{
		for(int i=1;i<=n;i++)
		{
			 for(int j=1;j<=m;j++)
				 System.out.print(a[i][j] + " ");
			 System.out.println(" ");
		}
	}
	
    static double determinant(double [][]a, int n)
{
   // calculam recursiv un determinant prin dezvoltarea sa pe o line
   // daca dimensiunea lui e mai mare decat unu (alegem prima linie)
   // daca dimensiunea e unu valoarea sa e acel element unic
    int k,i,j, coef;
    double [][]aux = new double [n][n];
    double delta = 0;
    coef = 1;
    
    if (n==1)
      delta = a[1][1];
    else
    {
    	for (k=1; k<=n; k++)
    {
    		for (i=2; i<=n; i++)
    			for (j=1; j<=n; j++)
    {
    				if (j<k)
    					aux[i-1][j] = a[i][j];
    				if (j>k)
    					aux[i-1][j-1] = a[i][j];
    }
            delta = delta + coef * a[1][k] * determinant(aux,n-1);
            coef = (-1) * coef;
    }
    }
    return delta;
}
    
    static double[] KramerSystem(double [][]a, double B[], int n)
{	
    // daca se poate se calculeaza in X solutia sistemului si
    // returneaza true
    // daca functia returneaza false
    double [][]aux = new double[n+1][n+1];
    double []X = new double[n+1];
    int k, i, j;
    double delta;
    delta = determinant(a,n);
    
    if (delta != 0)
    {
       for (k=1; k<=n; k++)
      { 
    	   for (i=1; i<=n; i++)
    		   for (j=1; j<=n; j++)
                 if (k==j)
                   aux[i][j] = B[i];
                 else
                   aux[i][j] = a[i][j];
    	   X[k]= determinant(aux,n)/delta;
      }
       return X;
    }
    else return X;
}

	public static void main(String[] args) 
{
		double [][]a = new double[100][100];
		double [][]b = new double[100][100];
   
    int n = 3;
    int m = 3;
   
    Random x = new Random();
   
	 for(int i=1;i<=n;i++)
		 for(int j=1;j<=m;j++)
			 {
			     a[i][j] = x.nextInt(10)+1;
			     b[i][j] = i*j;
			 }
	 
	System.out.println("Matrix a is :");
	printMatrix(a,n,m);
	System.out.println(" ");
	System.out.println("Matrix b is :");
	printMatrix(b,n,m);
	System.out.println(" ");
	
	double [][]c = add(a,b,n,m);
	printMatrix(c,n,m);
	System.out.println(" ");
	
	double [][]d = subtract(a,b,n,m);
	printMatrix(d,n,m);
	System.out.println(" ");
	
	double [][]e = multiplyScalar(b,n,m,3);
	printMatrix(e,n,m);
	System.out.println(" ");
	
	areEqual(a,b,n,m);
	System.out.println(" ");
	
	isZeroMatrix(a,n,m);
	System.out.println(" ");
	
	isIdentityMatrix(a,n,m);
	System.out.println(" ");
	
	System.out.println("Matrix is " + fillDegree(a,n,m) * 100 + "% filled.");
	System.out.println(" ");
	
	// https://matrixcalc.org/en/
	double [][]f = multiply(a,b,n);
	printMatrix(f,n,m);
	System.out.println(" ");
	
	double []B = new double[5];
	
	// Termenii liberi 
	B[1]=1;
	B[2]=2;
	B[3]=3;
	
	// https://www.wolframalpha.com/calculators/system-equation-calculator
	System.out.println("The solutions of AX = B are:");
	double []X = KramerSystem(a,B,n);
	 for(int i=1;i<=n;i++)
	System.out.println("X_(" + i + ") = " + X[i]);
	
	// https://matrixcalc.org/en/
	System.out.println(" ");
	System.out.println("detA = " + determinant(a,n));
}	   
}

// BigDecimal method (not working)
/* 
import java.util.Random;

public class MatrixOperations 
{
	static BigDecimal [][]add(BigDecimal [][]a, BigDecimal [][]b , int n, int m)
	{
		BigDecimal [][]c = new BigDecimal[100][100];
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				c[i][j].add(a[i][j].add(b[i][j]));
		return c;
	}
	
	static BigDecimal [][]subtract(BigDecimal [][]a, BigDecimal [][]b , int n, int m)
	{
		BigDecimal [][]c = new BigDecimal[100][100];
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				c[i][j].add(a[i][j].subtract(b[i][j]));
		return c;
	}
	
	static BigDecimal [][]multiply(BigDecimal [][]a, BigDecimal [][]b , int n)
	{
		 int i,j,k; 
		 BigDecimal [][]c = new BigDecimal[100][100];
		    for(i=1; i<=n; i++) 
		    { 
		        for (j=1; j<=n; j++) 
		        { 
		            c[i][j] = new BigDecimal("0");
		            for (k=1; k<=n; k++) 
		            	c[i][j].add(a[i][k].multiply(b[k][j]));
		        } 
		    }
		return c;
	}
	
	static BigDecimal [][]multiplyScalar(BigDecimal [][]a, int n, int m, int k)
	{
		BigDecimal [][]p = new BigDecimal[100][100];
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				p[i][j] = k * a[i][j];
		return p;
	}
	
	static void areEqual(BigDecimal [][]a, BigDecimal [][]b, int n, int m)
	{
		int ok = 1;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				if(a[i][j].compareTo(b[i][j]) == 0)
					ok = 0;
		if(ok == 1)
			System.out.println("Matrices are equal.");
		else
			System.out.println("Matrices are not equal.");
	}
	
	static void isZeroMatrix(BigDecimal [][]a, int n, int m)
	{
		BigDecimal c = new BigDecimal("0");
		int ok = 1;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				if(a[i][j].compareTo(c) ==0)
					ok = 0;
		if(ok == 1)
			System.out.println("Matrix contains only 0s.");
		else
			System.out.println("Matrix does not contain only 0s.");
	}
	
	static void isIdentityMatrix(BigDecimal [][]a, int n, int m)
	{
		BigDecimal c = new BigDecimal("0");
		BigDecimal d = new BigDecimal("1");
		int ok = 1;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				{
				  if(i!=j && a[i][j].compareTo(c) == 0)
					ok = 0;
		          if(i==j && a[i][j].compareTo(d) == 0)
			        ok = 0;
				}
		if(ok == 1)
			System.out.println("Matrix is an identity matrix.");
		else
			System.out.println("Matrix is not an identity matrix.");
	}
	
	static float fillDegree(BigDecimal [][]a, int n, int m)
	{
		BigDecimal c = new BigDecimal("0");
		float k = 0;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=m; j++)
				if(a[i][j].compareTo(c) == 0)
		k = k + 1;
		return k/n/n;
	}
	
	static void printMatrix(BigDecimal [][]a, int n, int m)
	{
		for(int i=1;i<=n;i++)
		{
			 for(int j=1;j<=m;j++)
				 System.out.print(a[i][j] + " ");
			 System.out.println(" ");
		}
	}
	
    static BigDecimal determinant(BigDecimal [][]a, int n)
{
   // calculam recursiv un determinant prin dezvoltarea sa pe o line
   // daca dimensiunea lui e mai mare decat unu (alegem prima linie)
   // daca dimensiunea e unu valoarea sa e acel element unic
    int k,i,j, coef;
    BigDecimal [][]aux = new BigDecimal [n][n];
    BigDecimal delta = new BigDecimal("0");
    BigDecimal coef = new BigDecimal("1");
    BigDecimal coef2 = new BigDecimal("-1");
    
    if (n==1)
      delta = a[1][1];
    else
    {
    	for (k=1; k<=n; k++)
    {
    		for (i=2; i<=n; i++)
    			for (j=1; j<=n; j++)
    {
    				if (j<k)
    					aux[i-1][j] = a[i][j];
    				if (j>k)
    					aux[i-1][j-1] = a[i][j];
    }
    		BigDecimal c = a[1][k];
    		c.multiply(coef);
    		delta.add(c.multiply(determinant(aux,n-1)));
            //delta = delta + coef * a[1][k] * determinant(aux,n-1);
            coef.multiply(coef2);
    }
    }
    return delta;
}
    
    static BigDecimal[] KramerSystem(BigDecimal [][]a, BigDecimal B[], int n)
{	
    // daca se poate se calculeaza in X solutia sistemului si
    // returneaza true
    // daca functia returneaza false
    BigDecimal [][]aux = new BigDecimal[n+1][n+1];
    BigDecimal []X = new BigDecimal[n+1];
    int k, i, j;
    BigDecimal delta;
    BigDecimal c = new BigDecimal("0");
    delta = determinant(a,n);
    
    if (delta.compareTo(c) == 0)
    {
       for (k=1; k<=n; k++)
      { 
    	   for (i=1; i<=n; i++)
    		   for (j=1; j<=n; j++)
                 if (k==j)
                   aux[i][j] = B[i];
                 else
                   aux[i][j] = a[i][j];
    	   BigDecimal e =  determinant(aux,n);
    	   e.divide(delta);
    	   X[k]=e;
      }
       return X;
    }
    else return X;
}

	public static void main(String[] args) 
{
    BigDecimal [][]a = new BigDecimal[100][100];
    BigDecimal [][]b = new BigDecimal[100][100];
   
    int n = 3;
    int m = 3;
   
    Random x = new Random();
    BigDecimal k = new BigDecimal("1");
    BigDecimal l = new BigDecimal("2");
   
	 for(int i=1;i<=n;i++)
		 for(int j=1;j<=m;j++)
			 {
			     a[i][j] = k;
			     b[i][j] = l;
			 }
	 
	System.out.println("Matrix a is :");
	printMatrix(a,n,m);
	System.out.println(" ");
	System.out.println("Matrix b is :");
	printMatrix(b,n,m);
	System.out.println(" ");
	
	BigDecimal [][]c = add(a,b,n,m);
	printMatrix(c,n,m);
	System.out.println(" ");
	
	BigDecimal [][]d = subtract(a,b,n,m);
	printMatrix(d,n,m);
	System.out.println(" ");
	
	BigDecimal [][]e = multiplyScalar(b,n,m,3);
	printMatrix(e,n,m);
	System.out.println(" ");
	
	areEqual(a,b,n,m);
	System.out.println(" ");
	
	isZeroMatrix(a,n,m);
	System.out.println(" ");
	
	isIdentityMatrix(a,n,m);
	System.out.println(" ");
	
	System.out.println("Matrix is " + fillDegree(a,n,m) * 100 + "% filled.");
	System.out.println(" ");
	
	// https://matrixcalc.org/en/
	BigDecimal [][]f = multiply(a,b,n);
	printMatrix(f,n,m);
	System.out.println(" ");
	
	BigDecimal []B = new BigDecimal[5];
	
	// Termenii liberi 
	B[1]=k;
	B[2]=k;
	B[3]=l;
	
	// https://www.wolframalpha.com/calculators/system-equation-calculator
	System.out.println("The solutions of AX = B are:");
	BigDecimal []X = KramerSystem(a,B,n);
	 for(int i=1;i<=n;i++)
	System.out.println("X_(" + i + ") = " + X[i]);
	
	// https://matrixcalc.org/en/
	System.out.println(" ");
	System.out.println("detA = " + determinant(a,n));
}	   
}
*/