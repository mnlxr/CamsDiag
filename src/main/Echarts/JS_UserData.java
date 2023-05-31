/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Echarts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import static main.CamReqs.MainInfo.AsmDescription_Label;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.NumberOfCams;
import static main.MnIT_Main.CheckMachineMotionCamArray;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;

/**
 *
 * @author MManolas
 */
public class JS_UserData {
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        JS_UserDataFile();
    }
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void JS_UserDataFile() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer+"//"+mainFolder+"//"+
                CamJobName() + "//" + CamJobName() + ".js");
        
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {

            w.write(
                    //UserInfo.Header_Comments() 
                    //"/*///////////////////////////////////////////*/\n"
                    "var AsmName = \"" + CamJobName() + "\";\n"
                    + "var AsmDescription = \"" + AsmDescription_Label() + "\";\n"
                    + "\n"
                    + CheckMachineMotionCamArray()
            //+ "\n"
                    //+ "/*///////////////////////////////////////////*/\n"
                    //+ "// Cam Job Name : " + CamJobName() + "\n"
                    //+ "// Number OF Cams : " + NumberOfCams() + "\n"
                    //+ "var CamsDiag_JobName = \"" + CamJobName() + "\";\n"
                    //+ "var CamsDiag_NofCams = " + NumberOfCams() + ";\n"
            );
            String h1 = "", h2 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NumberOfCams(); NumberOfCams++) {
                h2 = String.valueOf(NumberOfCams);
                w.write(
                        h1
                        = 
                                //"/*///////////////////////////////////////////*/\n"
                        "\nvar cam" + h2 + "label = \"CDMD" + h2 + "\";\n"
                        + "var cam" + h2 + "x = " + CamX_Values() + ";\n"
                        + "var cam" + h2 + "y = " + CamY_Values() + ";\n"
                        + "var cam" + h2 + "descl = \"CAM Description #" + h2 + "\";\n"
                        + "var cam" + h2 + "diameter = " + ShaftDiam() + ";\n"
                        //+ "var labelChart" + h2 + " = "+labelCharts()+"; \n"
                );
            }
            w.write("\n"
                    //"/*///////////////////////////////////////////*/\n"
                    //+ UserInfo.Header_Comments() 
            );
            w.close();
        }
    }

    /**
     *
     * @return
     */
    public static String labelCharts(){
    
        String h1 = "";
        
        h1 = "[\" \"]";
        
        return h1;
    }

    /**
     *
     * @return
     */
    public static String CamY_Values() {
        String h1 = "", h2 = "", h3="";
        h2 = "[45, 45, 60.5, 60.5, 45, 45]";
        h3 = "[45, 45, 42.5, 42.5, 45, 45]";
        String[] harray={h2, h3};
                Random r = new Random();
        int random_number = r.nextInt(harray.length);
        h1 = harray[random_number];
        
        return h1;
    }

    /**
     *
     * @return
     */
    public static String CamX_Values() {
        String h1 = "";
        String h2 = "[0, 90, 160, 240, 310, 360]";
        String h3 = "[0, 90, 140, 200, 350, 360]";
        String[] harray={h2, h3};
                Random r = new Random();
        int random_number = r.nextInt(harray.length);
        h1 = harray[random_number];        
        
        return h1;
    }
    
    /**
     *
     * @return
     */
    public static String ShaftDiam() {
        String[] harray = {"16", "30", "28.575", "40"};
        Random r = new Random();
        int random_number = r.nextInt(harray.length);
        String h1 = harray[random_number];
        return h1;
    }
    
    
    
    
    
}
