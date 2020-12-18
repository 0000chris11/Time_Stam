/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import views.create.VC_R2;
import views.create.VC_R_DataCom;
import views.mainTable.VMT;

/**
 *
 * @author C0FII
 */
public class MainInstances {

      private static VC_R2 vcr2;
      private static VC_R_DataCom vcrd;
      private static VMT vmt;
      //++++++++++++++++++++++++++++++++++++++++++
      public static VC_R2 getVC_R2() {
            return vcr2;
      }

      public static VC_R_DataCom getVC_R_DataCom() {
            return vcrd;
      }

      public static VMT getVMT() {
            return vmt;
      }
      //++++++++++++++++++++++++++++++++++++++++++
      public static void setVC_R2(VC_R2 vcr2) {
            MainInstances.vcr2 = vcr2;
      }

      public static void setVC_R_DataCom(VC_R_DataCom vcrd) {
            MainInstances.vcrd = vcrd;
      }

      public static void setVMT(VMT vmt) {
            MainInstances.vmt = vmt;
      }
}
