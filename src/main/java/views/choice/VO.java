/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.choice;

import com.cofii2.myMethods.MComp;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import views.first.VF_R;

/**
 *
 * @author Christopher
 */
public class VO {
      
      private static JFrame JF = new JFrame("VO");
      public static JFrame getJF(){
            return JF;
      }
      
      JLabel lbq = new JLabel();
      JButton op1 = new JButton("No");
      JButton op2 = new JButton("Yes");
      
      private void windowClosing(){
            JF.addWindowListener(new WindowAdapter(){
                  @Override
                  public void windowClosing(WindowEvent e){
                        VF_R.getJF().setAlwaysOnTop(true);
                  }
            });
      }
      
      public VO(String QT, String table){
            //lbq.setText(QT);
            lbq.setText("Delete this table?");//EX
            //++++++++++++++++++++++++++++
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.setLayout(null);
            JF.getContentPane().setBackground(Color.DARK_GRAY.darker());
            JF.setVisible(true);
            JF.setSize(284, 140);
            JF.setLocationRelativeTo(null);
            JF.setAlwaysOnTop(true);
            //windowClosing();
            
            JF.add(lbq);
            Font f = new Font("Dialog", Font.PLAIN, 20);
            lbq.setForeground(Color.WHITE);
            lbq.setFont(f);
            lbq.setSize(lbq.getFontMetrics(f).stringWidth(lbq.getText()), 27);
            System.out.println("####lbq bounds: " + lbq.getBounds());
            System.out.println("####JF width: " + JF.getWidth());
            System.out.println("####JF-CP witdht: " + JF.getContentPane().getWidth());
            MComp.setLabelToXCenter(lbq, 18, JF);
            
            JF.add(op1);
            JF.add(op2);
            
            int by = 52;
            int bw = 100;
            int bh = 27;
            
            op1.setBounds(20, by, bw, bh);
            op2.setBounds(op1.getX() + op1.getWidth() + 20, by, bw, bh);
            
            VO_AL voal = new VO_AL(QT, table);
            op1.addActionListener(voal);
            op2.addActionListener(voal);
            //int w = op1.getX() + op1.getWidth() + op2.getWidth() + 64;
            //System.out.println("JF W: " + w);
      }
      
}

