/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofii;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Christopher
 */
public class MTree {
      
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
}
