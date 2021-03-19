/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLStores;

/**
 *
 * @author C0FII
 */
public class TableDist {

      private int id = -1;
      private String table = null;
      private String dist1 = null;
      private String dist2 = null;
      private String imageC = null;
      private String imageCPath = null;
      private String tag = null;
      private String clock = null;

      public TableDist(String table){
            this.table = table;
      }
      
      public TableDist(int id, String table, String dist1, String dist2, String imageC, String imageCPath, String tag, String clock) {
            this.id = id;
            this.table = table;
            this.dist1 = dist1;
            this.dist2 = dist2;
            this.imageC = imageC;
            this.imageCPath = imageCPath;
            this.tag = tag;
            this.clock = clock;
      }
      
      public int getId(){
            return id;
      }
      public void setId(int id){
            this.id = id;
      }
      
      public String getTable(){
            return table;
      }
      public void setTable(String table){
            this.table = table;
      }
      
      public String getDist1(){
            return dist1;
      }
      public void setDist1(String dist1){
            this.dist1 = dist1;
      }
      
      public String getDist2(){
            return dist2;
      }
      public void setDist2(String dits2){
            this.dist2 = dist2;
      }
      
      public String getImageC(){
            return imageC;
      }
      public void setImageC(String imageC){
            this.imageC = imageC;
      }
      
      public String getImageCPath(){
            return imageCPath;
      }
      public void setImageCPath(String imageCPath){
            this.imageCPath = imageCPath;
      }
      
      public String getTag(){
            return tag;
      }
      public void setTag(String tag){
            this.tag = tag;
      }
      
      public String getClock(){
            return clock;
      }
      public void setClock(String clock){
            this.clock = clock;
      }
}
