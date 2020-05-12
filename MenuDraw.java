import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

// 
// Decompiled by Procyon v0.5.36
// 

public class MenuDraw extends JPanel implements MouseListener
{
    public void paintComponent(final Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);
        g.setColor(new Color(50, 150, 200));
        g.fillRect(70, 200, 400, 100);
        g.setColor(new Color(0, 0, 200));
        g.fillRect(80, 210, 380, 80);
        g.setColor(Color.white);
        g.setFont(new Font("", 1, 60));
        g.drawString("Start", 100, 270);
        g.setColor(new Color(50, 50, 50));
        g.fillRect(70, 40, 620, 110);
        g.setColor(Color.WHITE);
        g.fillRect(80, 50, 600, 90);
        g.setColor(Color.GRAY);
        g.setFont(new Font("", 1, 70));
        g.drawString("Enemy Inbound", 100, 120);
        g.setColor(new Color(93, 194, 30));
        g.fillRect(70, 350, 400, 100);
        g.setColor(new Color(16, 124, 16));
        g.fillRect(80, 360, 380, 80);
        g.setColor(Color.white);
        g.setFont(new Font("Segoe Pro", 1, 60));
        g.drawString("Help", 100, 420);
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getX() >= 70 && e.getX() <= 470 && e.getY() >= 220 && e.getY() <= 320) {
            EnemyInbound.frame.dispose();
            new Start();
        }
        if (e.getX() >= 70 && e.getX() <= 470 && e.getY() >= 370 && e.getY() <= 470) {
            new Help();
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
