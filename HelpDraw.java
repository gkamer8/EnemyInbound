import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

// 
// Decompiled by Procyon v0.5.36
// 

public class HelpDraw extends JPanel implements MouseListener
{
    public void paintComponent(final Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.GRAY);
        g.setFont(new Font("", 1, 60));
        g.drawString("Help", 325, 100);
        g.setFont(new Font("", 1, 20));
        g.drawString("Controls:", 50, 200);
        g.setColor(Color.BLACK);
        g.drawString("Arrow Keys to move", 50, 240);
        g.drawString("W,A,S,D to shoot", 50, 270);
        g.drawString("'E' to bring up the shop", 50, 300);
        g.drawString("'P' to pause", 50, 330);
        g.setColor(Color.GRAY);
        g.drawString("Goal:", 50, 380);
        g.setColor(Color.BLACK);
        g.drawString("Shoot at the other squares until they're dead. By doing so, you earn", 50, 420);
        g.drawString("money for bullet upgrades among other things. A new enemy spawns", 50, 450);
        g.drawString("every 10 seconds; shoot quick so you don't get overwhelmed!", 50, 480);
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
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
