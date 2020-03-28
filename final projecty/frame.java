import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class frame extends JFrame {

   JPanel p =new JPanel();
   Tile tiles[]=new Tile[16];

   public static void main(String arg[]){
   	new frame();
   }
   public frame(){
   	super(" frame ");
   	setSize(700,700);
   	setResizable(false);
   	setDefaultCloseOperation(EXIT_ON_CLOSE);
   	p.setLayout(new GridLayout(4,4));

   	for(int i=0;i<16;i++){

   		tiles[i]=new Tile();
   		p.add(tiles[i]);
   	}
   	add(p);
   	setVisible(true);

   }


}