package pr34;
import java.util.Arrays; 
public class MainPersoana 
{
	public static void main(String args[])
	{
		int nrPers = 4;
		Persoana[] v = new Persoana[nrPers];
		
		v[0] = new Persoana("Radu","Denis",20,true);
		v[1] = new Persoana("Mirel","Radoi",22,true);
		v[2] = new Persoana("Ioan","Gavrea",100,true);
		v[3] = new Persoana("Rudolf","Hoho",13,true);
		
		Arrays.sort(v,0,4);
		for(int i=0; i<4; i++)
			System.out.println(v[i].getNume() + " ");
	}

}
