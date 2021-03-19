/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.loginMain;

import MC.DT;
import MC.MainInstances;
import com.cofii2.stores.CC;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.Timer;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author COFII
 */
public class VL_Glass extends JComponent {

      private boolean ONE_LINE = false;
      private boolean TWO_LINES = false;

      private boolean DIST = true;

      private int dist = 0;
      private int dist2 = 0;
      private int dist_2 = 0;
      private int dist2_2 = 0;

      //++++++++++++++++++++++++++++++++++++++++
      private double alpha = 1.0;
      private Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  System.out.println("\t\tTimer Action");
                  alpha = alpha - 0.06;
                  if (alpha <= 0.0) {
                        stop();                     
                  } else {
                        repaint();
                  }
            }

      });

      @Override
      protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            if (alpha >= 0.0) {
                  VC_R_Comps vc = MainInstances.getVC_R_Comps();
                  VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
                  if (vc != null && dt != null) {
                        int x1 = dt.getsc_JPC().getWidth() + 13 //SPLITPANE WIDTH
                                + vc.getBTNS_Dist()[0].getX() + vc.getBTNS_Dist()[0].getWidth() + 1;
                        int x2 = x1 + 14;
                        if (ONE_LINE) {

                              int y1 = dt.getPU().getHeight() + vc.getBTNS_Dist()[dist - 1].getY();
                              int y2 = y1;

                              if (dist == dist2) {
                                    y1 += 20;
                                    y2 += 20;
                              } else if (dist > dist2) {
                                    y1 += 6;
                                    y2 += 6;
                              }

                              g2.setComposite(AlphaComposite.getInstance(
                                      AlphaComposite.SRC_OVER, (float) alpha));
                              g2.setColor(Color.WHITE);
                              System.out.println("\t" + x1 + ", " + y1 + ", " + x2 + ", " + y2);
                              g2.drawLine(x1, y1, x2, y2);
                        } else if (TWO_LINES) {

                              int y1 = dt.getPU().getHeight() + vc.getBTNS_Dist()[dist - 1].getY();
                              int y12 = dt.getPU().getHeight() + vc.getBTNS_Dist()[dist_2 - 1].getY();
                              int y2 = y1;
                              int y22 = y12;

                              if (dist == dist2) {
                                    y1 += 20;
                                    y2 += 20;
                              } else if (dist > dist2) {
                                    y1 += 6;
                                    y2 += 6;
                              }
                              g2.setComposite(AlphaComposite.getInstance(
                                      AlphaComposite.SRC_OVER, (float) alpha));
                              g2.setColor(Color.WHITE);
                              System.out.println("\t" + x1 + ", " + y1 + ", " + x2 + ", " + y2);
                              g2.drawLine(x1, y1, x2, y2);
                              
                              if (dist_2 == dist2_2) {
                                    y12 += 22;
                                    y22 += 22;
                              } else if (dist_2 > dist2_2) {
                                    y12 += 6;
                                    y22 += 6;
                              }
                              g2.setComposite(AlphaComposite.getInstance(
                                      AlphaComposite.SRC_OVER, (float) alpha));
                              g2.setColor(Color.WHITE);
                              System.out.println("\t" + x1 + ", " + y1 + ", " + x2 + ", " + y2);
                              g2.drawLine(x1, y12, x2, y22);
                        }
                  }
            } else {
                  g2.dispose();
            }
      }

      public void startOne(int dist, int dist2) {
            System.out.println(CC.CYAN + "\tSTART ONE" + CC.RESET);
            timer.stop();
            ONE_LINE = true;
            this.dist = dist;
            this.dist2 = dist2;
            timer.start();
      }

      public void startTwo(int dist, int dist2, int dist_2, int dist2_2) {
            TWO_LINES = true;
            timer.stop();
            this.dist = dist;
            this.dist2 = dist2;
            this.dist_2 = dist_2;
            this.dist2_2 = dist2_2;
            timer.start();
      }

      private void stop() {
            ONE_LINE = false;
            TWO_LINES = false;
            timer.stop();
            alpha = 1.0;
            System.out.println(CC.CYAN + "\tSTART ONE (STOPPED)" + CC.RESET);
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++

      /*
            1-1
            2-1
            2-2
            3-2
            3-3
            4-3
            4-4
            5-4
       */
}
