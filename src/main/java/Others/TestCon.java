
package Others;

import MC.MakeCon;

/**
 *
 * @author Christopher
 */
public class TestCon {
      MakeCon MC = new MakeCon();
      
      public static void main(String[] args){
            //CASE 1
            String[] cols1 = {"id"};
            String[] newvs1 = {"34"};
            //CASE 2
            String[] cols2 = {"id", "Name"};
            String[] newvs2 = {"24", "Akane"};
            //CASE 3
            String[] cols3 = {"id", "Name", "Last_Name"};
            String[] newvs3 = {"13", "Akane", "Tendo"};
            
            String[] cols4 = {"EP", "Title", "Time", "Descr"};
            String[] newvs4 = {"50", "Yokai Miracles", "B", "EC"};
            String id = "2";
            
            //new TestCon().MC.UpdateTEST("Ranma", cols1, newvs1, id);
            new TestCon().MC.UpdateTEST("Ranma", cols3, newvs3, id);
            new TestCon().MC.UpdateTEST("Yokai", cols4, newvs4, id);
      }
}
