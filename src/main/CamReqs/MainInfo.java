/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.CamReqs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.MnIT_Main;
import main.common.FileToString;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.CamsDiag_NofCams;
import static main.common.MainVars.LocalhostName;

/**
 *
 * @author MManolas
 */
public class MainInfo {

    public static Integer NumberOfCams() {
        Integer h1;
        h1 = 12;
        
 Integer jj1 = Integer.parseInt(MnIT_Main.DisplayInfo_02.getText());
        
//        String h2 = String.valueOf(Main.cams_display.getText());
//        
//        Integer r1;
//        r1 = Integer.parseInt(h2);
//        
//        //String h3 = FileToString.F2String(CamsDiag_NofCams);
//        
//        //r1 = Basic_Get_NumberOFCamsINT();
        
        return jj1;
    }
    
//    public static Integer NumberOfCams_CBmotion() {
//        Integer h1;
//        h1 = 12;
//
//        Integer jj1 = Integer.parseInt(main.MnIT_Main_CBmotionDown.DisplayInfo_02.getText());
//
//        return jj1;
//    }   

    
    public static String NumberOfCams_String() {
    String h3 = "";
        try {
            h3 = FileToString.F2String(CamsDiag_NofCams);
        } catch (IOException ex) {
            Logger.getLogger(MainInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    return h3;
    }
    
    
    public static String CamJobName() throws IOException {
        String h1 = "";
        h1 = "mamnolas_test_12".toLowerCase();
        
        String kk1 = MnIT_Main.DisplayInfo_01.getText();
        
        
//        String h2 = ReadLastJob_From_LOG();
//        String h3 = h2.substring(24, h2.length());
        
        return kk1;
    }
    
//    public static String CamJobName_CBmotion() throws IOException {
//        String h1 = "";
//        h1 = "mamnolas_test_12".toLowerCase();
//        
//        String kk1 = main.MnIT_Main_CBmotionDown.DisplayInfo_01.getText();
//                
//        return kk1;
//    }    
    
    public static String AsmDescription_Label() {
//    String h1="";
//    int as1 = Main.asmdesc_label.getText().length();
//    h1 = Main.asmdesc_label.getText().substring(18,as1);
    
    String h2 = "Kati kanei ait to pragma";
    
    String ppp1 = MnIT_Main.DisplayInfo_03.getText();
    
    
    return ppp1;
    }
    
//    public static String AsmDescription_Label_CBmotion() {
////    String h1="";
////    int as1 = Main.asmdesc_label.getText().length();
////    h1 = Main.asmdesc_label.getText().substring(18,as1);
//    
//    String h2 = "Kati kanei ait to pragma";
//    
//    String ppp1 = main.MnIT_Main_CBmotionDown.DisplayInfo_03.getText();
//    
//    
//    return ppp1;
//    }    
    
    
        public static String WebServerPath() throws IOException  {
        String h1 = "";
        String h2 = LocalhostName;
         //h1 = "http://localhost:8158"
                  h1 = h2
                 //+ReadProp_port() 
                 +"/"+mainFolder+"/";   
         //h1 = "http://localhost:"+portNginx +"/"+mainFolder+"/";   
         //ReadPROP_webServer()
        return h1;
    }
    

}
