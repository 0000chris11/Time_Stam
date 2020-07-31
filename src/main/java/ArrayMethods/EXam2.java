
package ArrayMethods;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Christopher
 */
public class EXam2 implements TableModel{

      Class[] types;
      
      @Override
      public int getRowCount() {
            return 0;
      }

      @Override
      public int getColumnCount() {
            return 0;
      }

      @Override
      public String getColumnName(int arg0) {
            return null;
      }

      @Override
      public Class<?> getColumnClass(int evt) {
            return types[evt];
      }

      @Override
      public boolean isCellEditable(int arg0, int arg1) {
            return false;
      }

      @Override
      public Object getValueAt(int arg0, int arg1) {
            return null;
      }

      @Override
      public void setValueAt(Object arg0, int arg1, int arg2) {

      }

      @Override
      public void addTableModelListener(TableModelListener arg0) {

      }

      @Override
      public void removeTableModelListener(TableModelListener arg0) {

      }
      
}
