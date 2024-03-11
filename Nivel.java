package joc2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Nivel extends JFrame{
	JFrame frame=new JFrame();
	public static int cod = 0;
	public static String sir = "";
	private JLabel titlu;

	private JLabel level;
	private JLabel nume;

	private JTextField nivel = new JTextField(20); ;
	private JTextField nume1 = new JTextField(20); ;

	private JButton submit = new JButton("SUBMIT");
	 
	Random rand = new Random();
    float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();
	Color randomColor = new Color(r, g, b);

	Random rand2 = new Random();
	float r2 = rand2.nextFloat();
	float g2 = rand2.nextFloat();
	float b2 = rand2.nextFloat();
	Color randomColor2 = new Color(r2, g2, b2);

public Nivel() {	
		
		setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		//getContentPane().setLayout(null);
		frame.setLayout(null);
		frame.setResizable(true);
	    frame.setVisible(true);
	    frame.getContentPane().setBackground(randomColor2);
	    frame.setSize(800,400);
	    
    titlu = new JLabel();
    titlu.setText("INCEPERE JOC");
    titlu.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
    titlu.setForeground(randomColor);
    titlu.setBounds(350, 50, 2000, 20);
    frame.add(titlu);

    level = new JLabel();
    level.setText("ENTER LEVEL");
   // level.setFont();
    level.setBounds(20, 100, 100, 20);
    level.setForeground(randomColor);
    frame.add(level);
    
    nume=new JLabel();
    nume.setText("ENTER NAME");
    nume.setForeground(randomColor);
    nume.setBounds(220, 100, 100, 20);
    frame.add(nume);
    
    nivel = new JTextField();
    nivel.setBounds(20, 125, 100, 20);
    frame.add(nivel);
    
    nume1 = new JTextField();
    nume1.setBounds(220, 125, 100, 20);
    nume1.setForeground(Color.black);
    frame.add(nume1);

    submit=new JButton();
    submit.setText("SUBMIT");
    submit.setBackground(randomColor);
    submit.setBounds(100, 180, 200, 40);

    frame.add(submit);
    submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int cod=Integer.parseInt(nivel.getText());
            String sir=nume1.getText();
           // getContentPane().add(new joc());
            frame.dispose();
        	new Game( cod, sir);
	
        }
    });
   
	}
}
