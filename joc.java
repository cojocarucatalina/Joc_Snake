package joc2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class joc extends JPanel implements ActionListener {

	static final int WIDTH = 500;
    static final int HEIGHT = 500;
    static final int patratica = 30;
    static final int BOARD_SIZE = (WIDTH * HEIGHT) / (patratica * patratica);

    final Font font = new Font("Comic Sans", Font.BOLD, 30);

    int[] snakePosX = new int[BOARD_SIZE];
    int[] snakePosY = new int[BOARD_SIZE];
    int snakeLength;
   
    Random rand = new Random();
    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    Color randomColor = new Color(r, g, b);
    
    Random rand2 = new Random();
    float r2 = rand.nextFloat();
    float g2 = rand.nextFloat();
    float b2 = rand.nextFloat();
    Color randomColor2 = new Color(r2, g2, b2);

    Food food;
    int foodEaten;

    private int cod;
    private String sir;
    char direction = 'R';
    boolean isMoving = false;
    final Timer timer = new Timer(100, this);
	
    public joc(int cod, String sir) {
    	this.cod=cod;
    	this.sir=sir;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (isMoving) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            if (direction != 'R') {
                                direction = 'L';
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (direction != 'L') {
                                direction = 'R';
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if (direction != 'D') {
                                direction = 'U';
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (direction != 'U') {
                                direction = 'D';
                            }
                            break; // daca se deplaseaza in sus nu isi
                            // poate schimba directia decat stanga, dreapta
                    }
                } else {
                    start();
                }
            }
        });

        start();
    }

    protected void start() {
        snakePosX = new int[520];
        snakePosY = new int[520];
        snakeLength = 3;
        foodEaten = 0;
        direction = 'R';
        isMoving = true;
        putFood();
        timer.start();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        if (isMoving) {
        	if(foodEaten < cod) {
            g.setColor(randomColor2);
           // g.fillArc(food.getPosX(), food.getPosY(), TICK_SIZE, TICK_SIZE);
           // g.fillArc(food.getPosX(), food.getPosY()-10, TICK_SIZE, TICK_SIZE,15,150);
           // g.fillArc(food.getPosX(), food.getPosY(), TICK_SIZE, TICK_SIZE, 20, 150);
            g.fillOval(food.getPosX(), food.getPosY(), patratica, patratica);

         //   String s = String.format("snake");
         //   g.setColor(Color.red);
         //   g.setFont(font);
         //   g.drawString(s, (WIDTH - getFontMetrics(g.getFont()).stringWidth(s)) / 2, HEIGHT / 2);
            
            g.setColor(randomColor);
            for (int i = 0; i < snakeLength; i++) 
                g.fillRect(snakePosX[i], snakePosY[i], patratica, patratica);
            }
     
        } else {
        	if(foodEaten<cod) {
            String scoreText = String.format("ai pierdut, %s :(",sir);
            String textutz = String.format("Scor: %d", foodEaten);
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString(scoreText, (WIDTH - getFontMetrics(g.getFont()).stringWidth(scoreText)) / 2, HEIGHT / 2);
            g.drawString(textutz, (WIDTH - getFontMetrics(g.getFont()).stringWidth(textutz)) / 2, HEIGHT / 2+45);
        	}
        else { String TEXTCASTIG = String.format("AI CASTIGAT, %s :)", sir);
        String textutz3 = String.format("Scor: %d", foodEaten);
        String textutz2 = String.format("apasa space pentru a mai juca");
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(TEXTCASTIG, (WIDTH - getFontMetrics(g.getFont()).stringWidth(TEXTCASTIG)) / 2, HEIGHT / 2);
        g.drawString(textutz3, (WIDTH - getFontMetrics(g.getFont()).stringWidth(textutz3)) / 2, HEIGHT / 2+45);
        g.drawString(textutz2, (WIDTH - getFontMetrics(g.getFont()).stringWidth(textutz2)) / 2, HEIGHT / 2+90);
    }}
    }

    protected void move() {
        for (int i = snakeLength; i > 0; i--) {
            snakePosX[i] = snakePosX[i-1];
            snakePosY[i] = snakePosY[i-1];
        }

       switch (direction) {
            case 'U' -> snakePosY[0] -= patratica; 
            case 'D' -> snakePosY[0] += patratica;
            case 'L' -> snakePosX[0] -= patratica;
            case 'R' -> snakePosX[0] += patratica;
        }
    }

    protected void putFood() {
        food = new Food();
    }

    protected void eatFood() {
        if ((snakePosX[0] == food.getPosX()) && (snakePosY[0] == food.getPosY())) {
            snakeLength++;
            foodEaten++;
            putFood();
        }
    }

    protected void collisionTest() {
        for (int i = snakeLength; i > 0; i--) {
            if ((snakePosX[0] == snakePosX[i]) && (snakePosY[0] == snakePosY[i])) {
                isMoving = false;
                break;
            }
        }

        if (snakePosX[0] < 0 || snakePosX[0] > WIDTH || snakePosY[0] < 0 || snakePosY[0] > HEIGHT ) {
           isMoving = false;
           timer.stop();
        }
        
      //  if (snakePosX[0] > WIDTH || snakePosY[0] > HEIGHT) {
       //     isMoving= false;
       //  }
        
       // if (snakePosX[0] < WIDTH  || snakePosY[0] > WIDTH ) {
       //    isMoving = false;
       // }

        if (!isMoving) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isMoving) {
            move();
            collisionTest();
            eatFood();
        }

        repaint();
    }
}