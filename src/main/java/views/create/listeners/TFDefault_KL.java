/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class TFDefault_KL implements KeyListener{

      private static final String bandWord = "NULL";
      
      @Override
      public void keyTyped(KeyEvent e) {
            
      }

      @Override
      public void keyPressed(KeyEvent e) {
            
      }

      @Override
      public void keyReleased(KeyEvent e) {
            JTextField tf = (JTextField) e.getSource();
            String text = tf.getText().toUpperCase().trim();
            if(text.equals(bandWord)){
                  tf.setForeground(Color.RED);
            }else{
                  tf.setForeground(Color.WHITE);
            }
      }
      
}
