package smallComponenets;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;


/**
 *
 * @author Christopher
 */
public class smallLB extends JLabel{
      
      public smallLB(String text){
            Font f = new Font("Dialog", Font.BOLD, 16);
            
            setForeground(Color.WHITE);
            setFont(f);
            setText(text);
      }
      
      public smallLB(){
            Font f = new Font("Dialog", Font.BOLD, 16);
            
            setForeground(Color.WHITE);
            setFont(f);
      }
}
