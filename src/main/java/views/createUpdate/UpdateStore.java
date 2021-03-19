/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.createUpdate;

import MC.DT;
import MC.MainInstances;
import SQLStores.TableDistC;
import SQLStores.TableKeysC;
import SQLStores.TableTypeC;
import com.cofii2.methods.MList;
import com.cofii2.methods.MString;
import com.cofii2.stores.BooleanString;
import com.cofii2.stores.DInt;
import com.cofii2.stores.StringInt;
import java.util.Arrays;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class UpdateStore {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      
      private String table;
      private String[] column_Names;
      private StringInt[] types;
      private boolean[] nulls;
      private boolean[] pks;
      private BooleanString[] fks;
      private BooleanString[] defaults;
      private boolean extra;
      
      private int columnLength;

      private String dist;
      private String dist2;
      private String imageC;
      private String imageCPath;
      private String tag;
      private String clock;

      //++++++++++++++++++++++++++++++++++++++++++++
      UpdateStore() {
            this.table = MString.getCustomClearTableFormat(TableDistC.getTable());
            this.columnLength = VF_R.getJT().getColumnCount();
            
            columns();
            types();
            nulls();
            pks();
            fks();
            defaults();
            extra();
            
            this.dist = TableDistC.getDist1();
            this.dist2 = TableDistC.getDist2();
            this.imageC = TableDistC.getImageC();
            this.imageCPath = TableDistC.getImageCPath();
            this.tag= TableDistC.getTag();
            this.clock= TableDistC.getClock();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++
            /*
            MList.printFor(this.column_Names, "COLUMNS NAMES");
            MList.printForClassFields(this.types, "TYPES");
            MList.printFor(this.nulls, "NULLS");
            MList.printFor(this.pks, "PKS");
            MList.printForClassFields(this.fks, "FKS");
            MList.printForClassFields(this.defaults, "DEFAULTS");
            System.out.println("EXTRA: " + this.extra);
            */
            
      }
      
      private void columns(){
            String[] column_Names = new String[columnLength];
            for(int a = 0; a < columnLength; a++){
                  column_Names[a] = DT.getList_C().get(a).toLowerCase().trim();
            }
            this.column_Names = column_Names;
      }
      private void types(){
            StringInt[] types = new StringInt[columnLength];
            for (int a = 0; a < columnLength; a++) {
                  String type = DT.getList_Types().get(a).toUpperCase();
                  int width = -1;
                  if (type.contains("(")) {
                        width = Integer.parseInt(type.substring(type.indexOf("(") + 1, type.length() - 1));
                        type = type.substring(0, type.indexOf("("));
                  }
                  types[a] = new StringInt(type, width);
            }
            this.types = types;
      }
      private void nulls(){
            boolean[] nulls = new boolean[columnLength];
            for (int a = 0; a < columnLength; a++) {
                  nulls[a] = DT.getList_Nulls().get(a);
            }
            this.nulls = nulls;
      }
      private void pks(){
            boolean[] pks = new boolean[columnLength];
            Arrays.fill(pks, Boolean.FALSE);
            for (int b = 0; b < TableKeysC.getPK().length; b++) {
                  int index = TableKeysC.getPK()[b].index;
                  if (index > 0) {
                        pks[index - 1] = true;
                  }
            }
            this.pks = pks;
      }
      private void fks(){
            BooleanString[] fks = new BooleanString[columnLength];
            Arrays.fill(fks, new BooleanString(false, null));
            for (int b = 0; b < TableKeysC.getFK().length; b++) {
                  int index = TableKeysC.getFK()[b].index;
                  String references = TableKeysC.getTableR()[b] + "." + TableKeysC.getColumnR()[b];
                  if(index > 0){
                        fks[index - 1] = new BooleanString(true, references);
                  }
            }
            this.fks = fks;
      }
      private void defaults(){
            BooleanString[] defaults = new BooleanString[columnLength];
            for (int b = 0; b < columnLength; b++) {
                  String defaultt = DT.getList_Defaults().get(b);
                  if(defaultt != null){
                        defaults[b] = new BooleanString(true, defaultt);
                  }else{
                        defaults[b] = new BooleanString(false, null);
                  }
            }
            this.defaults = defaults;
      }
      private void extra(){
            if(TableTypeC.getEX().index > 0){
                  this.extra = true;
            }else{
                  this.extra = false;
            }
      }
      //++++++++++++++++++++++++++++++++++++++++++++
      public String getTable(){
            return table;
      }
      public String[] getColumnNames(){
            return column_Names;
      }
      public StringInt[] getTypes(){
            return types;
      }
      public boolean[] getNulls(){
            return nulls;
      }
      public boolean[] getPKS(){
            return pks;
      }
      public BooleanString[] getFKS(){
            return fks;
      }
      public BooleanString[] getDefaults(){
            return defaults;
      }
      public boolean getExtra(){
            return extra;
      }
      
      public String getDist(){
            return dist;
      }
      public String getDist2(){
            return dist2;
      }
      public String getImageC(){
            return imageC;
      }
      public String getImageCPath(){
            return imageCPath;
      }
      public String getTag(){
            return tag;
      }
      public String getClock(){
            return clock;
      }
}
