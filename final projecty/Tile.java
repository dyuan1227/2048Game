
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event. ActionEvent;
import java.awt.*;
import javax.swing.*;

public class Tile extends JButton{

private ImageIcon image;
private JLabel label;


    public Tile() {
    	image=new ImageIcon(this.getClass().getResource("mva.jpg"));
    	label=new JLabel(image);


    }




}


