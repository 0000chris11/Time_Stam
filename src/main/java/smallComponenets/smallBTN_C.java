package smallComponenets;

import MC.DT;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author Christopher
 */
public class smallBTN_C extends JButton {

      String Title;
      Font F = new Font("Dialog", Font.BOLD, 15);
      //ArrayList<Shape> listS = new ArrayList<Shape>();
      int W;
      int H;
      GradientPaint[] GPS = new GradientPaint[3];
      Shape Outline;

      ImageIcon ii = new ImageIcon("C:\\C0F\\Image\\X Icons\\H small.png");

      @Override
      public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            //System.out.println("pC - " + getName());
            if (getModel().isEnabled()) {
                  if (getModel().isPressed()) {
                        //System.out.println("\tPRESSED");
                        g2.setPaint(GPS[1]);
                  } else {
                        //System.out.println("\tNORMAL");
                        g2.setPaint(GPS[0]);
                  }
            } else {
                  g2.setPaint(GPS[2]);
            }
            g2.fillRect(0, 0, getWidth(), getHeight());
            if (Title != null && Outline != null) {
                  //System.out.println("\tShape: " + Outline);
                  //System.out.println("\tG2: " + g2);
                  setCenter(g2, Outline, getWidth(), getHeight());
            } else {
                  if (getName() != null) {
                        if (getName().equals("BTN_H")) {
                              //g2.drawImage(img, W, W, this)
                              g2.drawImage(ii.getImage(), -1, 4, null);

                        }
                  }
            }
            super.paintComponents(g);
      }

      private void creatingOutline() {
            Graphics2D g2 = (Graphics2D) smallBTN_C.this.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            FontRenderContext frc = g2.getFontRenderContext();
            TextLayout tl = new TextLayout(Title, F, frc);
            //System.out.println("\tConstr Shape 1: " + Outline);
            Outline = tl.getOutline(null);
            //System.out.println("\tConstr Shape 2: " + Outline);
      }

      private void setCenter(Graphics2D g2, Shape shape, int w, int h) {
            FontMetrics FM = g2.getFontMetrics();
            //int x = (w - FM.stringWidth(s)) / 2;
            int x = (w - (int) shape.getBounds().getWidth()) / 2;
            int y = (FM.getAscent() + (h - (FM.getAscent() + FM.getDescent())) / 2);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //int y = (h - (int) shape.getBounds().getHeight()) / 2;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            g2.setColor(new Color(0, 0, 0, 255));
            g2.translate(x, y);
            g2.draw(shape);
            g2.translate(-x, -y);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            g2.setColor(new Color(204, 0, 0, 220));
            g2.setFont(F);
            g2.drawString(Title, x, y);
      }
      
      

      public smallBTN_C(String title) {
            //System.out.println("\nConstructor Title: " + title);
            if (title == null) {
                  setSize(18, 27);
            } else {
                  if (title.isEmpty()) {
                        title = null;
                  }
            }
            Title = title;
            //System.out.println("\nConstructor Title Variable: " + Title);
            //+++++++++++++++++++++++
            new Thread() {
                  public void run() {
                        do {
                              try {
                                    Thread.sleep(500);
                              } catch (InterruptedException ex) {
                                    System.err.println("ERROR");
                              }
                              if (smallBTN_C.this.getGraphics() != null) {
                                    //System.out.println("\nSmallBTN_C -> Creating");
                                    W = getWidth();
                                    H = getHeight();

                                    GPS[0]
                                            = new GradientPaint(0, 0, DT.GP_brightCeleste[0],
                                                    W, H, DT.GP_brightCeleste[1]);

                                    GPS[1]
                                            = new GradientPaint(0, 0, DT.GP_brightCeleste[0],
                                                    W, H, DT.GP_brightCeleste[1].darker());

                                    GPS[2]
                                            = new GradientPaint(0, 0, DT.GP_brightCeleste[0].darker(),
                                                    W, H, DT.GP_brightCeleste[1].darker());

                                    //System.out.println("\t" + smallBTN_C.this.getName());
                                    //System.out.println("Dimensions: " + W + ", " + H);
                                    if (Title != null) {
                                          creatingOutline();
                                    }
                                    smallBTN_C.this.repaint();
                              }
                        } while (!smallBTN_C.this.isDisplayable());
                  }
            }.start();
            //++++++++++++++++++++++++
      }
      
      
}
