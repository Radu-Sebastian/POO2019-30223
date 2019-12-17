package convertor_valutar;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class ConvertorView extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField inputSuma = new JTextField(10);
	private JTextField outputRez = new JTextField(10);
	private JButton arrow = new JButton(">>");
	private JLabel suma = new JLabel("Sum");
	private JLabel rezultat = new JLabel("Result");
	private JLabel inCurrency = new JLabel("Input");
	private JLabel outCurrency = new JLabel("Output");
	private String[] currencyArray = {"RON","EUR","USD"};
	@SuppressWarnings({"rawtypes", "unchecked"})
	private JComboBox fromBox = new JComboBox(currencyArray);
	@SuppressWarnings({"rawtypes", "unchecked"})
	private JComboBox toBox = new JComboBox(currencyArray);
	
	private ConvertorModel m_model;
	
	ConvertorView(ConvertorModel model) 
	{
		m_model = model;
		m_model.setValue(ConvertorModel.INITIAL_VALUE);
		outputRez.setText(m_model.getValue());
		outputRez.setEditable(false);
		
		JPanel mainPanel = new JPanel();
		
		setTitle("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(400,300));
		getContentPane().setLayout(new GridLayout());
		getContentPane().add(mainPanel);  
		setLocationRelativeTo(null);
		mainPanel.setLayout(new GridLayout(3,1));
		mainPanel.setBorder(new EmptyBorder(10,10,10,10));
		mainPanel.setBackground(new Color(230,230,250));
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(fromBox);
        topPanel.add(arrow);
        topPanel.add(toBox);
        mainPanel.add(topPanel);
         
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.add(suma);
        suma.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        inputPanel.add(inputSuma);
        inputSuma.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        inputSuma.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(inCurrency);
        inCurrency.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        mainPanel.add(inputPanel);
        
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.X_AXIS));
        outputPanel.add(rezultat);
        rezultat.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        outputPanel.add(outputRez);
        outputRez.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        outputRez.setHorizontalAlignment(SwingConstants.CENTER);
        outputPanel.add(outCurrency);
        outCurrency.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        mainPanel.add(outputPanel);  
        
        arrow.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        arrow.setBackground(new Color(230,230,250));
        fromBox.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        toBox.setFont(new Font("Calibri", Font.CENTER_BASELINE, 20));
        fromBox.setBackground(new Color(230,230,250));
        toBox.setBackground(new Color(230,230,250));
        outputRez.setBackground(new Color(255,255,255));
        
        ((JLabel) fromBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel) toBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        pack();
    }

	void reset() 
	{
		outputRez.setText(ConvertorModel.INITIAL_VALUE);
	}
	
	String getUserInput() 
	{ 
	    return inputSuma.getText();
	}
	
	String getFromCurrency()
	{
		return String.valueOf(fromBox.getSelectedItem());
	}
	
	String getToCurrency()
	{
		return String.valueOf(toBox.getSelectedItem());
	}
	
	void setOutput(String newOutput)
	{
		outCurrency.setText(newOutput);
	}
	
	void setInput(String newInput)
	{
		inCurrency.setText(newInput);
	}

    void convertCurrency(String newTotal) 
    {
    	outputRez.setText(newTotal);
    }
    
    void addConvertListener(ActionListener a) 
    {
    	arrow.addActionListener(a);
    }

    void showError(String errMessage) 
    {
    	JOptionPane.showMessageDialog(this, errMessage);
    }
} 