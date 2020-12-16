/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

/**
 *
 * @author C0FII
 */
public class TableInfo {

      private int id;
      private String table;
      private String dist1;
      private String dist2;
      private String imageC;
      private String tag;
      private String clock;

      public TableInfo(int id, String table, String dist1, String dist2, String imageC, String tag, String clock) {
            this.id = id;
            this.table = table;
            this.dist1 = dist1;
            this.dist2 = dist2;
            this.imageC = imageC;
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
