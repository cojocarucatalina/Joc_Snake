package joc2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game extends JFrame 

{
public Game(int cod, String sir)
{
          this.add(new joc( cod,sir));
          this.setTitle("Snake");              
          this.pack();
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setResizable(true);
          this.setVisible(true);

}
}
