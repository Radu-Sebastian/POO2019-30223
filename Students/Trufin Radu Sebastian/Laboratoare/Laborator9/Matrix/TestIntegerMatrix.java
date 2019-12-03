package Matrix;
public class TestIntegerMatrix 
{
	public static void main(String[] args) 
	{
		final long phi = 123456789L;
		
		Integer[][] m1 = new Integer[][] {{1,2,3}, {4,5,6}, {1,1,1}};
		Integer[][] m2 = new Integer[][] {{1,1,1}, {2,2,2}, {0,0,0}};
		
		Double [][] d1 = new Double[][] {{1.0,0.0,0.0}, {0.0,1.0,0.0}, {0.0,0.0,1.0}};
		Double [][] d2 = new Double[][] {{1.0,2.2,3.7}, {4.8,5.9,6.4}, {7.1,8.0,9.3}};
		
		Long [][] l1 = {{phi/2,phi/3,phi/4}, {phi/5,phi/6,phi/7}, {phi/8,phi/9,phi/10}};
		
		IntegerMatrix integerMatrix = new IntegerMatrix();
		System.out.println("\nm1 + m2 is : ");
		GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');
		System.out.println("\nm1 * m2 is : ");
		GenericMatrix.printResult(m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
		
		DoubleMatrix doubleMatrix = new DoubleMatrix();
		System.out.println("\nd1 + d2 is : ");
		GenericMatrix.printResult(d1, d2, doubleMatrix.addMatrix(d1, d2), '+');
		System.out.println("\nd1 * d2 is : ");
		GenericMatrix.printResult(d1, d2, doubleMatrix.multiplyMatrix(d1, d2), '*');
		
		LongMatrix longMatrix = new LongMatrix();
		System.out.println("\nl1 + l1 is : ");
		GenericMatrix.printResult(l1, l1, longMatrix.addMatrix(l1, l1), '+');
		
		System.out.println("\nTranspose of m1 is :");
		GenericMatrix.printSimple(integerMatrix.transpose(m1));
		
	}
}