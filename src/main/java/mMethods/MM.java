package mMethods;

import static Copy.Lots.searchFilter;
import First.VF_R;
import Second.View_Update;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Collections;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import First.VF_R;
import MC.DT;
import MC.Status;
import Others.CC;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.util.EventObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class MM extends Status {

      String CName = this.getClass().getName();
      
      Connection con;
      //Data DT = new Data("MethodM");

      public MM(String from, int CC) {
            DT.getConstructorName(DT.cons, CName, from, CC);
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void threadHandle(Thread t) {
            System.out.println("\nState: " + t.getState().toString());
            if (t.isAlive()) {
                  System.out.println("\tThread is Alive");
            } else {
                  System.out.println("\tThread is Dead");
            }
            if (t.isInterrupted()) {
                  System.out.println("\tThread is Interrupted");
            } else {
                  System.out.println("\tThread is NOT Interrupted");
            }
      }
      //JTREE+++++++++++++++++++++++++++++++++++++++++++++++
      public static boolean isCellEditableForCheckBoxAndDefaults(EventObject anEvent, JTree JTE, 
              DefaultMutableTreeNode editedNode){
            boolean returnValue = false;

            if (anEvent instanceof MouseEvent) {
                  MouseEvent mouseEvent = (MouseEvent) anEvent;
                  TreePath path = JTE.getPathForLocation(mouseEvent.getX(),
                          mouseEvent.getY());
                  if (path != null) {
                        Object ob = path.getLastPathComponent();
                        if ((ob != null) && (ob instanceof DefaultMutableTreeNode)) {
                              editedNode = (DefaultMutableTreeNode) ob;
                              Object userObject = editedNode.getUserObject();
                              if (userObject instanceof JCheckBox) {
                                    //System.out.println("JToggleButton");
                                    //System.out.println("CheckBox");
                                    Rectangle r = JTE.getPathBounds(path);
                                    int x = mouseEvent.getX() - r.x;
                                    int y = mouseEvent.getY() - r.y;

                                    JCheckBox checkbox = (JCheckBox) userObject;
                                    
                                    String text = checkbox.getText();
                                    checkbox.setText("");

                                    returnValue
                                            = userObject instanceof JCheckBox
                                            && x > 0
                                            && x < checkbox.getPreferredSize().width;
                                    
                                    checkbox.setText(text);
                              } else {
                                    returnValue = false;

                              }
                        }
                  }
            }
            System.out.println("isCellEditableForCheckBoxAndDefaults: " + returnValue);
            return returnValue;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void main(String[] args) {
            //System.out.println("MethodM STAR");
      }
}
