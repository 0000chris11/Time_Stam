package smallComponenets;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;


/**
 *
 * @author Christopher
 */
public class smallLB extends JLabel{
      
      public smallLB(){
            defaultConfig();
      }
      public smallLB(String text){
            super(text);
            defaultConfig();
      }
      public smallLB(String text, int constants){
            super(text, constants);
            defaultConfig();
      }
      
      private void defaultConfig(){
            Font f = new Font("Dialog", Font.BOLD, 16);
            
            setForeground(Color.WHITE);
            setFont(f);
      }
}
