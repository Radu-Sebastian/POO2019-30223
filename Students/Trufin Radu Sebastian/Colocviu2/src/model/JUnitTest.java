package model;
import static org.junit.Assert.*;
import org.junit.*; 

public class JUnitTest 
{
	private static Angajat a;
	private static int nrTesteExecutate = 0;
	private static int nrTesteCuSucces = 0;
	
	public JUnitTest() 
	{
		System.out.println("Constructor angajat");
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		a = new Angajat("Radu","100","15-1-2020",125.0);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		System.out.println("S-au executat " + nrTesteExecutate + " teste din care "+ nrTesteCuSucces + " au avut succes!");
	}

	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Incepe un nou test!");
		nrTesteExecutate++;
	}
	
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("S-a terminat testul curent!");
	} 
	
	@Test
	public void testGetID() 
	{
		String t = a.getID();
		assertEquals(t,"100"); 
		nrTesteCuSucces++;
	}
	
	@Test
	public void testGetDataAngajarii() 
	{
		String t = a.getDataAngajarii();
		assertEquals(t,"16-1-2020"); 
		nrTesteCuSucces++;
	}
	
	@Test
	public void testGetNume() 
	{
		String t = a.getNume();
		assertEquals(t,"Radu"); 
		nrTesteCuSucces++;
	}
	
	@Test
	public void testAlwaysFail() 
	{
		fail("Esuat!"); // intotdeauna esueaza
		nrTesteCuSucces++;
	}
} 