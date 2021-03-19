/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Christopher
 */
public class notMyMethods {
      
      public void rez(JTable table, boolean v) {
            if (v == true) {
                  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                  for (int i = 0; i < table.getColumnCount(); i++) {
                        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
                        TableColumn col = colModel.getColumn(i);
                        int width = 0;
                        TableCellRenderer renderer = col.getHeaderRenderer();
                        for (int r = 0; r < table.getRowCount(); r++) {
                              renderer = table.getCellRenderer(r, i);
                              Component comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, i),
                                      false, false, r, i);
                              width = Math.max(width, comp.getPreferredSize().width);
                        }
                        col.setPreferredWidth(width + 10);
                  }
            }
      }

      public void onPaste(JTextField tf) {
            Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable t = c.getContents(this);
            if (t == null) {
                  return;
            }
            try {
                  tf.setText(tf.getText() + (String) t.getTransferData(DataFlavor.stringFlavor));
            } catch (Exception e) {
                  e.printStackTrace();
            }//try
      }
      public void onPaste(JComboBox cb) {
            Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable t = c.getContents(this);
            if (t == null) {
                  return;
            }
            try {
                  cb.setSelectedItem(cb.getSelectedItem().toString() + (String) t.getTransferData(DataFlavor.stringFlavor));
            } catch (Exception e) {
                  e.printStackTrace();
            }//try
      }
}
