/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.choice;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Christopher
 */
public class View_Test extends javax.swing.JFrame {

      DefaultTableModel jm2;
      JTable table1;
      JTable table2;
      int count = 0;

      public View_Test() {
            initComponents();
            //EXAMPLE++++++++++++++++++++++++++++++++++++++++++
            
            //++++++++++++++++++++++++++++++++++++++++++++++++++
            String s = "X2: 2-3_4-5";
            System.out.println("S substring 1: " + s.substring(s.indexOf(":") + 2, 7));
            System.out.println("S substring 2: " + s.substring(s.indexOf(":") + 6));
            //++++++++++++++++++++++++++++++++++++++++++++++++++
            //String[] col = {"Column1", "Column2"};
            table1 = new JTable();
            JScrollPane sc_t1 = new JScrollPane(table1);
            //setAutoCreateRowSorter(true);
            sc_t1.setLocation(10, 10);
            sc_t1.setSize(250, 250);
            table1.setForeground(Color.BLACK);
            table1.setGridColor(Color.BLACK);
            table1.setShowGrid(true);
            table1.setAutoCreateRowSorter(true);
            jPanel1.add(sc_t1);

            table2 = new JTable();
            JScrollPane sc_t2 = new JScrollPane(table2);

            sc_t2.setLocation(270, 10);
            sc_t2.setSize(250, 250);
            table2.setForeground(Color.BLACK);
            table2.setGridColor(Color.BLACK);
            table2.setShowGrid(true);
            table2.setAutoCreateRowSorter(true);
            jPanel1.add(sc_t2);
            //++++++++++++++++++++++++++++++++++++++++++++++++++
            DefaultTableModel jm1 = new DefaultTableModel();
            //tdo.addColumn(col);
            jm1.addColumn("Column1");
            jm1.addColumn("Column2");

            Object[] row1 = {"1", "Arin"};
            Object[] row2 = {"2", "Dan"};
            Object[] row3 = {"3", "Ross"};
            Object[] row4 = {"4", "Barry"};
            Object[] row5 = {"5", "Jon"};

            jm1.addRow(row1);
            jm1.addRow(row2);
            jm1.addRow(row3);
            jm1.addRow(row4);
            jm1.addRow(row5);

            table1.setModel(jm1);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            JButton btn1 = new JButton("COL");
            int x = sc_t2.getX() + sc_t2.getWidth();
            btn1.setLocation(x, 10);
            btn1.setSize(40, 30);
            btn1.setVisible(true);
            jPanel1.add(btn1);

            JButton btn2 = new JButton("ROW");
            int y2 = btn1.getY() + btn1.getHeight() + 6;
            btn2.setLocation(x, y2);
            btn2.setSize(40, 30);
            btn2.setVisible(true);
            jPanel1.add(btn2);

            btn1.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        jm2.addColumn("COL");

                        System.out.println("ColumnClass 0: " + jm2.getColumnClass(0));
                        System.out.println("ColumnClass 1: " + jm2.getColumnClass(1));
                        System.out.println("ColumnClass 2: " + jm2.getColumnClass(2));
                        System.out.println("ColumnClass 3: " + jm2.getColumnClass(3));
                  }
            });

            btn2.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        count++;
                        Object[] data = {count, "L", "TWELVETH", "DOCEAVO"};
                        jm2.addRow(data);

                        System.out.println("ColumnClass 0: " + jm2.getColumnClass(0));
                        System.out.println("ColumnClass 1: " + jm2.getColumnClass(1));
                        System.out.println("ColumnClass 2: " + jm2.getColumnClass(2));
                        System.out.println("ColumnClass 3: " + jm2.getColumnClass(3));
                  }
            });

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            Object[][] rowsF2 = {{1, "A", "FIRST", "PRIMERO"}, {2, "B", "SECOND", "SEGUNDO"},
            {3, "C", "THIRD", "TERCERO"}, {4, "D", "FORTH", "CUARTO"}, {5, "E", "FIFTH", "QUINTO"},
            {6, "F", "SIXTH", "SEXTO"}, {7, "G", "SEVENTH", "SEPTIMO"}, {8, "H", "EIGHT", "OCTAVO"},
            {9, "I", "NINETH", "NOVENO"}, {10, "J", "TENTH", "DECIMO"},
            {11, "K", "ELEVENTH", "ONCEAVO"}};

            //DefaultTableModel jm2 = new DefaultTableModel(rowsF2, 
            //new String[] {"SELECT", "WHERE", "FIELD", "TYPE"});
            //DefaultTableModel jm2;
            table2.setModel(jm2 = new DefaultTableModel() {

                  Class[] types = {Integer.class, String.class, String.class,
                        String.class};
                  boolean[] canEdit = {true, true, true, true};

                  @Override
                  public Class getColumnClass(int columnIndex) {
                        return this.types[columnIndex];
                  }

                  public boolean isCellEditable(int columnIndex) {
                        return this.canEdit[columnIndex];
                  }
            });

            System.out.println("ColumnClass 0: " + jm2.getColumnClass(0));
            System.out.println("ColumnClass 1: " + jm2.getColumnClass(1));
            System.out.println("ColumnClass 2: " + jm2.getColumnClass(2));
            System.out.println("ColumnClass 3: " + jm2.getColumnClass(3));

            /*
            table2.setModel(jm2 = new DefaultTableModel(rowsF2, 
                    new String[] {"SELECT", "WHERE", "FIELD", "TYPE"}) {

                  Class[] types = {Integer.class, String.class, String.class,
                        String.class};
                  boolean[] canEdit = {true, true, true, true};

                  @Override
                  public Class getColumnClass(int columnIndex) {
                        return this.types[columnIndex];
                  }

                  public boolean isCellEditable(int columnIndex) {
                        return this.canEdit[columnIndex];
                  }
            });
             */
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++
      }

      /**
       * This method is called from within the constructor to initialize the
       * form. WARNING: Do NOT modify this code. The content of this method is
       * always regenerated by the Form Editor.
       */
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jMenuItem2 = new javax.swing.JMenuItem();
            jPanel1 = new javax.swing.JPanel();
            jMenuBar1 = new javax.swing.JMenuBar();
            jMenu1 = new javax.swing.JMenu();
            jMenuItem1 = new javax.swing.JMenuItem();
            jMenuItem3 = new javax.swing.JMenuItem();
            jMenuItem4 = new javax.swing.JMenuItem();
            jMenu2 = new javax.swing.JMenu();

            jMenuItem2.setText("jMenuItem2");

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(0, 0, 0));

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                  jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGap(0, 660, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                  jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGap(0, 287, Short.MAX_VALUE)
            );

            jMenu1.setText("File");

            jMenuItem1.setText("jMenuItem1");
            jMenu1.add(jMenuItem1);

            jMenuItem3.setText("jMenuItem2");
            jMenu1.add(jMenuItem3);

            jMenuItem4.setText("jMenuItem3");
            jMenu1.add(jMenuItem4);

            jMenuBar1.add(jMenu1);

            jMenu2.setText("Edit");
            jMenuBar1.add(jMenu2);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );

            pack();
      }// </editor-fold>//GEN-END:initComponents

      /**
       * @param args the command line arguments
       */
      public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
                              break;
                        }
                  }
            } catch (ClassNotFoundException ex) {
                  java.util.logging.Logger.getLogger(View_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(View_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(View_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(View_Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new View_Test().setVisible(true);
                  }
            });
      }

      public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {

            JComponent component = new JTextField();

            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
                  ((JTextField) component).setText((String) value);
                  ((JTextField) component).setFont(new java.awt.Font("Arial Unicode MS", 0, 12));
                  return component;
            }

            @Override
            public Object getCellEditorValue() {
                  return new String("dd");//To change body of generated methods, choose Tools | Templates.
            }

      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JMenu jMenu1;
      private javax.swing.JMenu jMenu2;
      private javax.swing.JMenuBar jMenuBar1;
      private javax.swing.JMenuItem jMenuItem1;
      private javax.swing.JMenuItem jMenuItem2;
      private javax.swing.JMenuItem jMenuItem3;
      private javax.swing.JMenuItem jMenuItem4;
      private javax.swing.JPanel jPanel1;
      // End of variables declaration//GEN-END:variables
}
