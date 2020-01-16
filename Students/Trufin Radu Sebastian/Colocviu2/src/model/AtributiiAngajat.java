package model;

public interface AtributiiAngajat 
{
	public void adaugaMedicament(Farmacie f, Medicament m, Integer stoc);
	public void stergeMedicament(Farmacie f, Medicament m);
	public void verificaStoc(Farmacie f, Medicament m);
	public void verificaMedicament(Farmacie f, Medicament m);
	public void modificaStoc(Farmacie f, Medicament m, int stocNou);
	public void proceseazaReteta(Pacient p);
}
