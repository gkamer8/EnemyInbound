import java.awt.event.MouseListener;
import java.awt.Component;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class Help
{
    HelpDraw hd;
    static JFrame frame;
    
    static {
        Help.frame = new JFrame("Help");
    }
    
    public Help() {
        this.hd = new HelpDraw();
        Help.frame.setSize(800, 600);
        Help.frame.setLocation(0, 0);
        Help.frame.setVisible(true);
        Help.frame.add(this.hd);
        Help.frame.addMouseListener(this.hd);
        Help.frame.validate();
    }
}
