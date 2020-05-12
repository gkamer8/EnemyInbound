import java.awt.event.MouseListener;
import java.awt.Component;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class EnemyInbound
{
    static MenuDraw md;
    static JFrame frame;
    
    static {
        EnemyInbound.md = new MenuDraw();
        EnemyInbound.frame = new JFrame("EnemyInbound");
    }
    
    public EnemyInbound() {
        EnemyInbound.frame.setSize(800, 600);
        EnemyInbound.frame.setVisible(true);
        EnemyInbound.frame.setDefaultCloseOperation(3);
        EnemyInbound.frame.setLocationRelativeTo(null);
        EnemyInbound.frame.add(EnemyInbound.md);
        EnemyInbound.frame.addMouseListener(EnemyInbound.md);
        EnemyInbound.frame.validate();
    }
}
