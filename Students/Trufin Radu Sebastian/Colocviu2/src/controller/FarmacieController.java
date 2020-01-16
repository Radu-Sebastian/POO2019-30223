package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Angajat;
import model.Farmacie;
import view.FarmacieView;

public class FarmacieController 
{
	private FarmacieView f_view;
	private Angajat f_model;
	
	public FarmacieController(FarmacieView view, Angajat model) 
	{
		f_view = view;
		view.addSortListener(new SortListener());
	}
	
	class SortListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			f_view.changeText("I tried");
        }
    }
}