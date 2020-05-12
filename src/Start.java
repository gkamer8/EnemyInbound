import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.Component;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class Start
{
    static JFrame frame;
    
    static {
        Start.frame = new JFrame("LD27");
    }
    
    public static void main(final String[] args) {
        new EnemyInbound();
    }
    
    public Start() {
        final Draw draw = new Draw();
        Start.frame.setSize(800, 600);
        Start.frame.setLocationRelativeTo(null);
        Start.frame.setVisible(true);
        Start.frame.setDefaultCloseOperation(3);
        Start.frame.add(draw);
        Start.frame.addMouseListener(draw);
        Start.frame.addKeyListener(draw);
        Start.frame.validate();
    }
}
