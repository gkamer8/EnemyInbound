import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

// 
// Decompiled by Procyon v0.5.36
// 

public class Draw extends JPanel implements ActionListener, KeyListener, MouseListener
{
    Player player;
    Timer time;
    static ArrayList<Integer> enemy;
    static ArrayList<Integer> enemybullet;
    static ArrayList<Integer> enemybullet2;
    static ArrayList<Integer> enemybullet3;
    static ArrayList<Integer> enemybullet4;
    static ArrayList<Integer> playerbullet;
    static ArrayList<Integer> playerbullet2;
    static ArrayList<Integer> playerbullet3;
    static ArrayList<Integer> playerbullet4;
    int kills;
    Random rand;
    int enemycounter;
    boolean pause;
    int score;
    boolean store;
    boolean alert;
    int equipped;
    int bulletspeed;
    String alerttext;
    
    static {
        Draw.enemy = new ArrayList<Integer>();
        Draw.enemybullet = new ArrayList<Integer>();
        Draw.enemybullet2 = new ArrayList<Integer>();
        Draw.enemybullet3 = new ArrayList<Integer>();
        Draw.enemybullet4 = new ArrayList<Integer>();
        Draw.playerbullet = new ArrayList<Integer>();
        Draw.playerbullet2 = new ArrayList<Integer>();
        Draw.playerbullet3 = new ArrayList<Integer>();
        Draw.playerbullet4 = new ArrayList<Integer>();
    }
    
    public Draw() {
        this.player = new Player();
        this.time = new Timer(10, this);
        this.kills = 0;
        this.rand = new Random();
        this.enemycounter = 0;
        this.pause = false;
        this.score = 0;
        this.store = false;
        this.alert = false;
        this.equipped = 0;
        this.bulletspeed = 5;
        this.alerttext = "";
        if (!this.time.isRunning()) {
            this.time.start();
        }
        Draw.enemy.add(50);
        Draw.enemy.add(50);
        Draw.enemy.add(20);
        Draw.enemy.add(20);
        Draw.enemy.add(0);
        Draw.enemy.add(200);
        Draw.enemy.add(0);
        Draw.enemy.add(0);
        Draw.enemy.add(0);
    }
    
    public void paintComponent(final Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.GRAY);
        g.fillRect(350, 7, 150, 20);
        g.setFont(new Font("", 1, 15));
        g.setColor(Color.WHITE);
        g.drawString("Click for a tip", 370, 24);
        g.setColor(Color.BLACK);
        g.drawString("'P' to pause", 520, 24);
        g.drawString("'E' to open the shop", 630, 24);
        g.setColor(Color.BLUE);
        g.fillRect(this.player.getX(), this.player.getY(), this.player.getWidth(), this.player.getHeight());
        g.setColor(Color.RED);
        g.fillRect(this.player.getX() - (this.player.getHealth() / 4 - this.player.getWidth() / 2), this.player.getY() - 10, this.player.getHealth() / 2, 5);
        g.setColor(Color.ORANGE);
        for (int i = 0; i < Draw.enemy.size(); i += 9) {
            if (Draw.enemy.get(i + 8) == 0) {
                g.setColor(Color.ORANGE);
                g.fillRect(Draw.enemy.get(i), Draw.enemy.get(i + 1), Draw.enemy.get(i + 2), Draw.enemy.get(i + 3));
                g.setColor(Color.RED);
                g.fillRect(Draw.enemy.get(i) - (Draw.enemy.get(i + 5) / 8 - Draw.enemy.get(i + 2) / 2), Draw.enemy.get(i + 1) - 10, Draw.enemy.get(i + 5) / 4, 5);
            }
        }
        g.setColor(Color.RED);
        for (int i = 0; i < Draw.enemybullet.size(); i += 5) {
            g.fillRect(Draw.enemybullet.get(i), Draw.enemybullet.get(i + 1), Draw.enemybullet.get(i + 2), Draw.enemybullet.get(i + 3));
        }
        for (int i = 0; i < Draw.enemybullet2.size(); i += 5) {
            g.fillRect(Draw.enemybullet2.get(i), Draw.enemybullet2.get(i + 1), Draw.enemybullet2.get(i + 2), Draw.enemybullet2.get(i + 3));
        }
        for (int i = 0; i < Draw.enemybullet3.size(); i += 5) {
            g.fillRect(Draw.enemybullet3.get(i), Draw.enemybullet3.get(i + 1), Draw.enemybullet3.get(i + 2), Draw.enemybullet3.get(i + 3));
        }
        for (int i = 0; i < Draw.enemybullet4.size(); i += 5) {
            g.fillRect(Draw.enemybullet4.get(i), Draw.enemybullet4.get(i + 1), Draw.enemybullet4.get(i + 2), Draw.enemybullet4.get(i + 3));
        }
        if (this.equipped == 0) {
            g.setColor(Color.GREEN);
        }
        else if (this.equipped == 1) {
            g.setColor(new Color(50, 150, 200));
        }
        else if (this.equipped == 2) {
            g.setColor(new Color(93, 194, 30));
        }
        for (int i = 0; i < Draw.playerbullet.size(); i += 5) {
            g.fillRect(Draw.playerbullet.get(i), Draw.playerbullet.get(i + 1), Draw.playerbullet.get(i + 2), Draw.playerbullet.get(i + 3));
        }
        for (int i = 0; i < Draw.playerbullet2.size(); i += 5) {
            g.fillRect(Draw.playerbullet2.get(i), Draw.playerbullet2.get(i + 1), Draw.playerbullet2.get(i + 2), Draw.playerbullet2.get(i + 3));
        }
        for (int i = 0; i < Draw.playerbullet3.size(); i += 5) {
            g.fillRect(Draw.playerbullet3.get(i), Draw.playerbullet3.get(i + 1), Draw.playerbullet3.get(i + 2), Draw.playerbullet3.get(i + 3));
        }
        for (int i = 0; i < Draw.playerbullet4.size(); i += 5) {
            g.fillRect(Draw.playerbullet4.get(i), Draw.playerbullet4.get(i + 1), Draw.playerbullet4.get(i + 2), Draw.playerbullet4.get(i + 3));
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("", 1, 20));
        g.drawString("Kills: " + this.kills, 20, 20);
        g.drawString(new StringBuilder().append(this.enemycounter).toString(), 120, 20);
        g.drawString("$" + this.score, 190, 20);
        if (this.store) {
            g.setColor(new Color(93, 194, 30));
            g.fillRect(100, 75, 600, 400);
            g.setColor(new Color(16, 124, 16));
            g.fillRect(120, 95, 560, 360);
            g.setColor(Color.WHITE);
            g.setFont(new Font("", 1, 50));
            g.drawString("Store", 330, 145);
            g.setFont(new Font("", 1, 15));
            g.drawString("The Crusher", 160, 195);
            g.drawString("Damage: 50", 160, 215);
            g.drawString("Speed: 3", 160, 235);
            g.drawString("Size: 150", 160, 255);
            g.drawString("$10,000", 160, 275);
            g.fillRect(160, 285, 100, 20);
            g.setColor(new Color(16, 124, 16));
            g.drawString("Equip", 185, 300);
            g.setColor(Color.WHITE);
            g.drawString("Carlos D.", 350, 195);
            g.drawString("Damage: 25", 350, 215);
            g.drawString("Speed: 7", 350, 235);
            g.drawString("Size: 375", 350, 255);
            g.drawString("$7,500", 350, 275);
            g.fillRect(350, 285, 100, 20);
            g.setColor(new Color(16, 124, 16));
            g.drawString("Equip", 374, 300);
            g.setColor(Color.WHITE);
            g.drawString("Se\u00f1or Pain", 540, 195);
            g.drawString("Damage: 40", 540, 215);
            g.drawString("Speed: 5", 540, 235);
            g.drawString("Size: 64", 540, 255);
            g.drawString("$5,000", 540, 275);
            g.fillRect(540, 285, 100, 20);
            g.setColor(new Color(16, 124, 16));
            g.drawString("Equip", 564, 300);
            g.setColor(Color.BLACK);
            g.fillRect(250, 335, 300, 80);
            g.setColor(Color.RED);
            g.fillRect(260, 345, 280, 60);
            g.setColor(Color.WHITE);
            g.setFont(new Font("", 1, 35));
            g.drawString("Insta-Health", 290, 380);
            g.setFont(new Font("", 1, 15));
            g.drawString("( $10,000 )", 355, 400);
        }
        if (this.alert && !this.store) {
            g.setColor(new Color(0, 0, 200));
            g.fillRect(150, 100, 500, 300);
            g.setColor(new Color(50, 150, 200));
            g.fillRect(170, 120, 460, 260);
            g.setColor(Color.WHITE);
            g.setFont(new Font("", 1, 25));
            g.drawString(new StringBuilder().append(this.alerttext).toString(), 190, 200);
            g.setFont(new Font("", 1, 20));
            g.drawString("'P' to resume", 210, 350);
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent arg0) {
        this.repaint();
        if (!this.pause) {
            this.enemybrain();
            this.playerbrain();
            this.enemyspawn();
            this.player.setX(this.player.getX() + this.player.getDx());
            this.player.setY(this.player.getY() + this.player.getDy());
        }
    }
    
    public void enemyspawn() {
        ++this.enemycounter;
        if (this.enemycounter == 1000) {
            if (this.kills < 5) {
                final int ex = this.rand.nextInt(4);
                if (ex == 0) {
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(150);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 1) {
                    Draw.enemy.add(750);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(150);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 2) {
                    Draw.enemy.add(750);
                    Draw.enemy.add(530);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(150);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 3) {
                    Draw.enemy.add(20);
                    Draw.enemy.add(530);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(150);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                this.enemycounter = 0;
            }
            else if (this.kills < 10) {
                final int ex = this.rand.nextInt(4);
                if (ex == 0) {
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(200);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 1) {
                    Draw.enemy.add(750);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(200);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 2) {
                    Draw.enemy.add(750);
                    Draw.enemy.add(530);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(200);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 3) {
                    Draw.enemy.add(20);
                    Draw.enemy.add(530);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(200);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                this.enemycounter = 0;
            }
            else {
                final int ex = this.rand.nextInt(4);
                if (ex == 0) {
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(120);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(120);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 1) {
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(120);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(120);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 2) {
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(120);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(120);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                else if (ex == 3) {
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(120);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(20);
                    Draw.enemy.add(0);
                    Draw.enemy.add(120);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                    Draw.enemy.add(0);
                }
                this.enemycounter = 0;
            }
        }
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == 27) {
            this.pause = true;
            this.alert("Paused");
            new Help();
        }
        if (e.getKeyCode() == 37) {
            this.player.setDx(-this.player.getSpeed());
        }
        if (e.getKeyCode() == 39) {
            this.player.setDx(this.player.getSpeed());
        }
        if (e.getKeyCode() == 38) {
            this.player.setDy(-this.player.getSpeed());
        }
        if (e.getKeyCode() == 40) {
            this.player.setDy(this.player.getSpeed());
        }
        if (this.equipped == 0) {
            if (e.getKeyCode() == 87) {
                Draw.playerbullet.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet.add(this.player.getY());
                Draw.playerbullet.add(8);
                Draw.playerbullet.add(8);
                Draw.playerbullet.add(40);
            }
            if (e.getKeyCode() == 83) {
                Draw.playerbullet2.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet2.add(this.player.getY());
                Draw.playerbullet2.add(8);
                Draw.playerbullet2.add(8);
                Draw.playerbullet2.add(40);
            }
            if (e.getKeyCode() == 68) {
                Draw.playerbullet3.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet3.add(this.player.getY());
                Draw.playerbullet3.add(8);
                Draw.playerbullet3.add(8);
                Draw.playerbullet3.add(40);
            }
            if (e.getKeyCode() == 65) {
                Draw.playerbullet4.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet4.add(this.player.getY());
                Draw.playerbullet4.add(8);
                Draw.playerbullet4.add(8);
                Draw.playerbullet4.add(40);
            }
        }
        else if (this.equipped == 1) {
            if (e.getKeyCode() == 87) {
                Draw.playerbullet.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet.add(this.player.getY());
                Draw.playerbullet.add(10);
                Draw.playerbullet.add(15);
                Draw.playerbullet.add(50);
            }
            if (e.getKeyCode() == 83) {
                Draw.playerbullet2.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet2.add(this.player.getY());
                Draw.playerbullet2.add(10);
                Draw.playerbullet2.add(15);
                Draw.playerbullet2.add(50);
            }
            if (e.getKeyCode() == 68) {
                Draw.playerbullet3.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet3.add(this.player.getY());
                Draw.playerbullet3.add(15);
                Draw.playerbullet3.add(10);
                Draw.playerbullet3.add(50);
            }
            if (e.getKeyCode() == 65) {
                Draw.playerbullet4.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet4.add(this.player.getY());
                Draw.playerbullet4.add(15);
                Draw.playerbullet4.add(10);
                Draw.playerbullet4.add(50);
            }
        }
        else if (this.equipped == 2) {
            if (e.getKeyCode() == 87) {
                Draw.playerbullet.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet.add(this.player.getY());
                Draw.playerbullet.add(15);
                Draw.playerbullet.add(25);
                Draw.playerbullet.add(25);
            }
            if (e.getKeyCode() == 83) {
                Draw.playerbullet2.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet2.add(this.player.getY());
                Draw.playerbullet2.add(15);
                Draw.playerbullet2.add(25);
                Draw.playerbullet2.add(25);
            }
            if (e.getKeyCode() == 68) {
                Draw.playerbullet3.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet3.add(this.player.getY());
                Draw.playerbullet3.add(25);
                Draw.playerbullet3.add(15);
                Draw.playerbullet3.add(25);
            }
            if (e.getKeyCode() == 65) {
                Draw.playerbullet4.add(this.player.getX() + this.player.getWidth() / 2 - 4);
                Draw.playerbullet4.add(this.player.getY());
                Draw.playerbullet4.add(25);
                Draw.playerbullet4.add(15);
                Draw.playerbullet4.add(25);
            }
        }
        if (e.getKeyCode() == 80) {
            if (this.pause) {
                this.pause = false;
                this.alert = false;
            }
            else if (!this.pause) {
                this.pause = true;
                this.alert("Paused, 'ESC' to open 'Help'");
            }
        }
        if (e.getKeyCode() == 69) {
            if (this.store) {
                this.store = false;
                this.pause = false;
            }
            else if (!this.store) {
                this.store = true;
                this.pause = true;
            }
        }
        if (e.getKeyCode() == 81) {
            this.alert("Hello");
        }
    }
    
    public void playerbrain() {
        if (this.equipped == 0) {
            this.bulletspeed = 5;
        }
        else if (this.equipped == 1) {
            this.bulletspeed = 3;
        }
        else if (this.equipped == 2) {
            this.bulletspeed = 7;
        }
        for (int i = 0; i < Draw.playerbullet.size(); i += 5) {
            Draw.playerbullet.set(i + 1, Draw.playerbullet.get(i + 1) - this.bulletspeed);
        }
        for (int i = 0; i < Draw.playerbullet2.size(); i += 5) {
            Draw.playerbullet2.set(i + 1, Draw.playerbullet2.get(i + 1) + this.bulletspeed);
        }
        for (int i = 0; i < Draw.playerbullet3.size(); i += 5) {
            Draw.playerbullet3.set(i, Draw.playerbullet3.get(i) + this.bulletspeed);
        }
        for (int i = 0; i < Draw.playerbullet4.size(); i += 5) {
            Draw.playerbullet4.set(i, Draw.playerbullet4.get(i) - this.bulletspeed);
        }
        for (int i = 0; i < Draw.enemy.size(); i += 9) {
            for (int a = 0; a < Draw.playerbullet.size(); a += 5) {
                if (Draw.enemy.get(i) <= Draw.playerbullet.get(a) + Draw.playerbullet.get(a + 2) && Draw.enemy.get(i) + Draw.enemy.get(i + 2) >= Draw.playerbullet.get(a) && Draw.enemy.get(i + 1) <= Draw.playerbullet.get(a + 1) + Draw.playerbullet.get(a + 3) && Draw.enemy.get(i + 1) + Draw.enemy.get(i + 3) >= Draw.playerbullet.get(a + 1) && Draw.enemy.get(i + 8) == 0) {
                    Draw.playerbullet.set(a + 2, 0);
                    Draw.playerbullet.set(a + 3, 0);
                    Draw.enemy.set(i + 5, Draw.enemy.get(i + 5) - Draw.playerbullet.get(a + 4));
                    Draw.playerbullet.set(a + 4, 0);
                    if (Draw.enemy.get(i + 5) <= 0) {
                        Draw.enemy.set(i + 8, 1);
                        ++this.kills;
                        this.score += 1000 - this.enemycounter;
                    }
                }
            }
        }
        for (int i = 0; i < Draw.enemy.size(); i += 9) {
            for (int a = 0; a < Draw.playerbullet2.size(); a += 5) {
                if (Draw.enemy.get(i) <= Draw.playerbullet2.get(a) + Draw.playerbullet2.get(a + 2) && Draw.enemy.get(i) + Draw.enemy.get(i + 2) >= Draw.playerbullet2.get(a) && Draw.enemy.get(i + 1) <= Draw.playerbullet2.get(a + 1) + Draw.playerbullet2.get(a + 3) && Draw.enemy.get(i + 1) + Draw.enemy.get(i + 3) >= Draw.playerbullet2.get(a + 1) && Draw.enemy.get(i + 8) == 0) {
                    Draw.playerbullet2.set(a + 2, 0);
                    Draw.playerbullet2.set(a + 3, 0);
                    Draw.enemy.set(i + 5, Draw.enemy.get(i + 5) - Draw.playerbullet2.get(a + 4));
                    Draw.playerbullet2.set(a + 4, 0);
                    if (Draw.enemy.get(i + 5) <= 0) {
                        Draw.enemy.set(i + 8, 1);
                        ++this.kills;
                        this.score += 1000 - this.enemycounter;
                    }
                }
            }
        }
        for (int i = 0; i < Draw.enemy.size(); i += 9) {
            for (int a = 0; a < Draw.playerbullet3.size(); a += 5) {
                if (Draw.enemy.get(i) <= Draw.playerbullet3.get(a) + Draw.playerbullet3.get(a + 2) && Draw.enemy.get(i) + Draw.enemy.get(i + 2) >= Draw.playerbullet3.get(a) && Draw.enemy.get(i + 1) <= Draw.playerbullet3.get(a + 1) + Draw.playerbullet3.get(a + 3) && Draw.enemy.get(i + 1) + Draw.enemy.get(i + 3) >= Draw.playerbullet3.get(a + 1) && Draw.enemy.get(i + 8) == 0) {
                    Draw.playerbullet3.set(a + 2, 0);
                    Draw.playerbullet3.set(a + 3, 0);
                    Draw.enemy.set(i + 5, Draw.enemy.get(i + 5) - Draw.playerbullet3.get(a + 4));
                    Draw.playerbullet3.set(a + 4, 0);
                    if (Draw.enemy.get(i + 5) <= 0) {
                        Draw.enemy.set(i + 8, 1);
                        ++this.kills;
                        this.score += 1000 - this.enemycounter;
                    }
                }
            }
        }
        for (int i = 0; i < Draw.enemy.size(); i += 9) {
            for (int a = 0; a < Draw.playerbullet4.size(); a += 5) {
                if (Draw.enemy.get(i) <= Draw.playerbullet4.get(a) + Draw.playerbullet4.get(a + 2) && Draw.enemy.get(i) + Draw.enemy.get(i + 2) >= Draw.playerbullet4.get(a) && Draw.enemy.get(i + 1) <= Draw.playerbullet4.get(a + 1) + Draw.playerbullet4.get(a + 3) && Draw.enemy.get(i + 1) + Draw.enemy.get(i + 3) >= Draw.playerbullet4.get(a + 1) && Draw.enemy.get(i + 8) == 0) {
                    Draw.playerbullet4.set(a + 2, 0);
                    Draw.playerbullet4.set(a + 3, 0);
                    Draw.enemy.set(i + 5, Draw.enemy.get(i + 5) - Draw.playerbullet4.get(a + 4));
                    Draw.playerbullet4.set(a + 4, 0);
                    if (Draw.enemy.get(i + 5) <= 0) {
                        Draw.enemy.set(i + 8, 1);
                        ++this.kills;
                        this.score += 1000 - this.enemycounter;
                    }
                }
            }
        }
    }
    
    public void enemybrain() {
        for (int i = 0; i < Draw.enemy.size(); i += 9) {
            Draw.enemy.set(i + 4, Draw.enemy.get(i + 4) + 1);
        }
        for (int i = 0; i < Draw.enemy.size(); i += 9) {
            if (Draw.enemy.get(i + 8) == 0) {
                if (Draw.enemy.get(i + 4) == 100) {
                    final int r = this.rand.nextInt(3);
                    Draw.enemy.set(i + 6, r);
                    Draw.enemy.set(i + 4, 0);
                }
                if (Draw.enemy.get(i) > 800 - this.player.getWidth()) {
                    Draw.enemy.set(i + 6, 1);
                }
                else if (Draw.enemy.get(i + 1) > 550 - this.player.getHeight()) {
                    Draw.enemy.set(i + 6, 3);
                }
                else if (Draw.enemy.get(i) < 0) {
                    Draw.enemy.set(i + 6, 0);
                }
                else if (Draw.enemy.get(i + 1) < 0) {
                    Draw.enemy.set(i + 6, 2);
                }
                if (Draw.enemy.get(i + 6) == 0) {
                    Draw.enemy.set(i, Draw.enemy.get(i) + 3);
                }
                else if (Draw.enemy.get(i + 6) == 1) {
                    Draw.enemy.set(i, Draw.enemy.get(i) - 3);
                }
                else if (Draw.enemy.get(i + 6) == 2) {
                    Draw.enemy.set(i + 1, Draw.enemy.get(i + 1) + 3);
                }
                else if (Draw.enemy.get(i + 6) == 3) {
                    Draw.enemy.set(i + 1, Draw.enemy.get(i + 1) - 3);
                }
            }
        }
        for (int i = 0; i < Draw.enemy.size(); i += 9) {
            if (Draw.enemy.get(i + 8) == 0) {
                Draw.enemy.set(i + 7, Draw.enemy.get(i + 7) + 1);
                if (Draw.enemy.get(i + 7) == 120) {
                    Draw.enemybullet.add(Draw.enemy.get(i) + Draw.enemy.get(i + 2));
                    Draw.enemybullet.add(Draw.enemy.get(i + 1));
                    Draw.enemybullet.add(8);
                    Draw.enemybullet.add(8);
                    Draw.enemybullet.add(20);
                    Draw.enemybullet2.add(Draw.enemy.get(i) - Draw.enemy.get(i + 2));
                    Draw.enemybullet2.add(Draw.enemy.get(i + 1));
                    Draw.enemybullet2.add(8);
                    Draw.enemybullet2.add(8);
                    Draw.enemybullet2.add(20);
                    Draw.enemybullet3.add(Draw.enemy.get(i));
                    Draw.enemybullet3.add(Draw.enemy.get(i + 1) + Draw.enemy.get(i + 3));
                    Draw.enemybullet3.add(8);
                    Draw.enemybullet3.add(8);
                    Draw.enemybullet3.add(20);
                    Draw.enemybullet4.add(Draw.enemy.get(i));
                    Draw.enemybullet4.add(Draw.enemy.get(i + 1));
                    Draw.enemybullet4.add(8);
                    Draw.enemybullet4.add(8);
                    Draw.enemybullet4.add(20);
                    Draw.enemy.set(i + 7, 0);
                }
            }
        }
        for (int i = 0; i < Draw.enemybullet.size(); i += 5) {
            Draw.enemybullet.set(i, Draw.enemybullet.get(i) + 4);
            if (Draw.enemybullet.get(i) + Draw.enemybullet.get(i + 2) >= this.player.getX() && Draw.enemybullet.get(i + 1) + Draw.enemybullet.get(i + 3) >= this.player.getY() && Draw.enemybullet.get(i) < this.player.getX() + this.player.getWidth() && Draw.enemybullet.get(i + 1) < this.player.getY() + this.player.getHeight()) {
                Draw.enemybullet.set(i + 2, 0);
                Draw.enemybullet.set(i + 3, 0);
                this.death(Draw.enemybullet.get(i + 4));
                Draw.enemybullet.set(i + 4, 0);
            }
        }
        for (int i = 0; i < Draw.enemybullet2.size(); i += 5) {
            Draw.enemybullet2.set(i, Draw.enemybullet2.get(i) - 4);
            if (Draw.enemybullet2.get(i) + Draw.enemybullet2.get(i + 2) >= this.player.getX() && Draw.enemybullet2.get(i + 1) + Draw.enemybullet2.get(i + 3) >= this.player.getY() && Draw.enemybullet2.get(i) < this.player.getX() + this.player.getWidth() && Draw.enemybullet2.get(i + 1) < this.player.getY() + this.player.getHeight()) {
                Draw.enemybullet2.set(i + 2, 0);
                Draw.enemybullet2.set(i + 3, 0);
                this.death(Draw.enemybullet2.get(i + 4));
                Draw.enemybullet2.set(i + 4, 0);
            }
        }
        for (int i = 0; i < Draw.enemybullet3.size(); i += 5) {
            Draw.enemybullet3.set(i + 1, Draw.enemybullet3.get(i + 1) + 4);
            if (Draw.enemybullet3.get(i) + Draw.enemybullet3.get(i + 2) >= this.player.getX() && Draw.enemybullet3.get(i + 1) + Draw.enemybullet3.get(i + 3) >= this.player.getY() && Draw.enemybullet3.get(i) < this.player.getX() + this.player.getWidth() && Draw.enemybullet3.get(i + 1) < this.player.getY() + this.player.getHeight()) {
                Draw.enemybullet3.set(i + 2, 0);
                Draw.enemybullet3.set(i + 3, 0);
                this.death(Draw.enemybullet3.get(i + 4));
                Draw.enemybullet3.set(i + 4, 0);
            }
        }
        for (int i = 0; i < Draw.enemybullet4.size(); i += 5) {
            Draw.enemybullet4.set(i + 1, Draw.enemybullet4.get(i + 1) - 4);
            if (Draw.enemybullet4.get(i) + Draw.enemybullet4.get(i + 2) >= this.player.getX() && Draw.enemybullet4.get(i + 1) + Draw.enemybullet4.get(i + 3) >= this.player.getY() && Draw.enemybullet4.get(i) < this.player.getX() + this.player.getWidth() && Draw.enemybullet4.get(i + 1) < this.player.getY() + this.player.getHeight()) {
                Draw.enemybullet4.set(i + 2, 0);
                Draw.enemybullet4.set(i + 3, 0);
                this.death(Draw.enemybullet4.get(i + 4));
                Draw.enemybullet4.set(i + 4, 0);
            }
        }
    }
    
    public void death(final int damage) {
        this.player.setHealth(this.player.getHealth() - damage);
        if (this.player.getHealth() <= 0) {
            this.player.setX(400);
            this.player.setY(500);
            for (int i = 0; i < Draw.enemy.size(); i += 9) {
                Draw.enemy.set(i + 8, 1);
            }
            for (int i = 0; i < Draw.enemybullet.size(); i += 5) {
                Draw.enemybullet.set(i + 2, 0);
                Draw.enemybullet.set(i + 3, 0);
            }
            for (int i = 0; i < Draw.enemybullet2.size(); i += 5) {
                Draw.enemybullet2.set(i + 2, 0);
                Draw.enemybullet2.set(i + 3, 0);
            }
            for (int i = 0; i < Draw.enemybullet3.size(); i += 5) {
                Draw.enemybullet3.set(i + 2, 0);
                Draw.enemybullet3.set(i + 3, 0);
            }
            for (int i = 0; i < Draw.enemybullet4.size(); i += 5) {
                Draw.enemybullet4.set(i + 2, 0);
                Draw.enemybullet4.set(i + 3, 0);
            }
            for (int i = 0; i < Draw.playerbullet.size(); i += 5) {
                Draw.playerbullet.set(i + 2, 0);
                Draw.playerbullet.set(i + 3, 0);
            }
            for (int i = 0; i < Draw.playerbullet2.size(); i += 5) {
                Draw.playerbullet2.set(i + 2, 0);
                Draw.playerbullet2.set(i + 3, 0);
            }
            for (int i = 0; i < Draw.playerbullet3.size(); i += 5) {
                Draw.playerbullet3.set(i + 2, 0);
                Draw.playerbullet3.set(i + 3, 0);
            }
            for (int i = 0; i < Draw.playerbullet4.size(); i += 5) {
                Draw.playerbullet4.set(i + 2, 0);
                Draw.playerbullet4.set(i + 3, 0);
            }
            this.player.setDx(0);
            this.player.setDy(0);
            this.player.setHealth(200);
            this.enemycounter = 500;
            this.kills = 0;
            this.score -= this.score / 7;
            this.alert("You died!");
        }
    }
    
    public void alert(final String x) {
        this.pause = true;
        this.alert = true;
        this.alerttext = x;
    }
    
    @Override
    public void keyReleased(final KeyEvent e) {
        if (e.getKeyCode() == 37 && this.player.getDx() == -this.player.getSpeed()) {
            this.player.setDx(0);
        }
        if (e.getKeyCode() == 39 && this.player.getDx() == this.player.getSpeed()) {
            this.player.setDx(0);
        }
        if (e.getKeyCode() == 38 && this.player.getDy() == -this.player.getSpeed()) {
            this.player.setDy(0);
        }
        if (e.getKeyCode() == 40 && this.player.getDy() == this.player.getSpeed()) {
            this.player.setDy(0);
        }
    }
    
    @Override
    public void keyTyped(final KeyEvent arg0) {
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getX() >= 160 && e.getX() <= 260 && e.getY() >= 305 && e.getY() <= 325 && this.score >= 10000) {
            this.equipped = 1;
            this.score -= 10000;
        }
        if (e.getX() >= 350 && e.getX() <= 450 && e.getY() >= 305 && e.getY() <= 325 && this.score >= 7500) {
            this.equipped = 2;
            this.score -= 7500;
        }
        if (e.getX() >= 540 && e.getX() <= 640 && e.getY() >= 305 && e.getY() <= 325 && this.score >= 5000) {
            this.equipped = 0;
            this.score -= 5000;
        }
        if (e.getX() >= 250 && e.getX() <= 550 && e.getY() >= 355 && e.getY() <= 435 && this.score >= 10000) {
            this.player.setHealth(200);
            this.score -= 10000;
        }
        if (e.getX() >= 350 && e.getX() <= 500 && e.getY() >= 30 && e.getY() <= 50) {
            final int rn = this.rand.nextInt(6);
            if (rn == 0) {
                this.alert("Spam bullets!");
            }
            else if (rn == 1) {
                this.alert("Be reckless!");
            }
            else if (rn == 2) {
                this.alert("Enemies 2x after the 5th kill.");
            }
            else if (rn == 3) {
                this.alert("Kill quicker to earn more money.");
            }
            else if (rn == 4) {
                this.alert("All bullets are created equal.");
            }
            else if (rn == 5) {
                this.alert("'Se\u00f1or Pain' is the default bullet.");
            }
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseExited(final MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent arg0) {
    }
}
