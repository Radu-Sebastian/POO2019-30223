package pr35;

public class Student implements Cloneable
{
	private String nume;
	private String prenume;
	private Masina car;
	
	public Object clone() throws CloneNotSupportedException
	{
		Student s = (Student) super.clone();
		s.setCar((Masina) car.clone());
		return s;
	}
	
	public Student(String nume, String prenume, Masina car)
	{
		this.nume = nume;
		this.prenume = prenume;
		this.car = car;
	}
	
	public String toString()
	{
		return ("Numele " + this.getNume() + " prenumele " + this.getPrenume() +
				" masina" + this.getCar().toString());
	}
	
	public void print()
	{
		System.out.println(this.toString());
	}
	
	public String getNume() 
	{
		return nume;
	}
	
	public void setNume(String nume) 
	{
		this.nume = nume;
	}

	public String getPrenume() 
	{
		return prenume;
	}

	public void setPrenume(String prenume) 
	{
		this.prenume = prenume;
	}

	public Masina getCar() 
	{
		return car;
	}

	public void setCar(Masina car) 
	{
		this.car = car;
	}

	
}
