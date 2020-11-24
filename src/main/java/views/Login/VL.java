/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login;

import com.cofii.myClasses.MLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import views.Login.listeners.TFLST_FL;

/**
 *
 * @author C0FII
 */
public class VL extends VL_DataCom {

      private void setNames(){
            cbUser.setName("tfUser");
            tfPass.setName("tfPass");
            cbDB.setName("tfDB");
      }
      
      public VL() {
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.setAlwaysOnTop(true);
            //JF.setUndecorated(true);
            //JF.setShape(new RoundRectangle2D.Double(10, 10, 100, 100, 50, 50));
            JF.getContentPane().setLayout(new BorderLayout());
            /*
            JPanel JPN = new JPanel();
            JF.getContentPane().add(JPN, BorderLayout.NORTH);
            JPN.setBackground(Color.BLACK);
            JPN.setMinimumSize(new Dimension(10, 60));
            JPN.setPreferredSize(new Dimension(10, 60));
            JPN.setMaximumSize(new Dimension(Short.MAX_VALUE, 60));
            
            JPanel JPL = new JPanel();
            JF.getContentPane().add(JPL, BorderLayout.WEST);
            JPL.setBackground(Color.BLACK);
            JPL.setMinimumSize(new Dimension(100, 10));
            JPL.setPreferredSize(new Dimension(100, 10));
            JPL.setMaximumSize(new Dimension(100, Short.MAX_VALUE));

            JPanel JPR = new JPanel();
            JF.getContentPane().add(JPR, BorderLayout.EAST);
            JPR.setBackground(Color.BLACK);
            JPR.setMinimumSize(new Dimension(100, 10));
            JPR.setPreferredSize(new Dimension(100, 10));
            JPR.setMaximumSize(new Dimension(100, Short.MAX_VALUE));
             */
            JComponent[] components = new JComponent[6];
            components[0] = lbUser;
            components[1] = cbUser;
            components[2] = lbPass;
            components[3] = tfPass;
            components[4] = lbDB;
            components[5] = cbDB;

            //+++++++++++++++++++++++++++
            JF.getContentPane().add(JPC, BorderLayout.CENTER);
            JPC.setBackground(Color.BLACK);
            JPC.setBorder(new LineBorder(Color.WHITE, 2));
            JPC.setMinimumSize(new Dimension(401, 200));
            JPC.setPreferredSize(new Dimension(401, 200));
            JPC.setMaximumSize(new Dimension(401, Short.MAX_VALUE));

            GroupLayout gl = new GroupLayout(JPC);
            JPC.setLayout(gl);
            MLayout.singlelineSequence(gl, components, 28);
            //+++++++++++++++++++++++++++++++++++++++++
            cbUser.setEditable(true);
            cbDB.setEditable(true);
            //+++++++++++++++++++++++++++++++++++++++++
            setNames();
      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        new VL();
                        JF.setLocationRelativeTo(null);

                        JF.setSize(400, 500);
                        JF.setVisible(true);
                  }

            });
      }
}
