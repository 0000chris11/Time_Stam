package Table;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christopher
 */
public class CustomTableModel extends DefaultTableModel {

      Class[] types;
      int Index;

      public CustomTableModel(int index) {
            //System.out.println("----------index size: " + index);
            Index = index;
            types = new Class[Index];

            types[0] = Integer.class;
            for (int a = 1; a < Index; a++) {//!!!!!!!!!!!!!!! ONE !!!!!!!!!!!!!!!!!!!!!
                  types[a] = String.class;
            }
      }

      @Override
      public Class getColumnClass(int columnIndex) {
            //System.out.println("+-+-+-+-+-+-columnIndex: " + columnIndex);
            /*if (Index == 6) {
                  for (int a = 0; a < 10; a++) {
                        if (columnIndex == a + 6) {
                              return types[5];
                        }
                  }
            }
            */
            return types[columnIndex];

      }
}
