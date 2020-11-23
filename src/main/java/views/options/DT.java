/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.options;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Christopher
 */
public class DT {
      
      static JFrame JFN = new JFrame("Options");
      static JSplitPane SPLN = new JSplitPane();
      static JPanel JPN = new JPanel(){
        @Override
        public void repaint(){
              super.repaint();
              System.out.println("REPAINT");
        }    
      };
      
      static JTree JTEN;
      JScrollPane SC_JTEN;
      
      static JPanel[] jps = new JPanel[2];
      
      static JLabel lb_Title = new JLabel("Select an Option");
      static JSeparator sp_Title = new JSeparator(SwingConstants.HORIZONTAL);
      static JLabel[] lb_Icon = new JLabel[
              UIManager.getInstalledLookAndFeels().length];
      
      static JRadioButton[] rbtns;
}
