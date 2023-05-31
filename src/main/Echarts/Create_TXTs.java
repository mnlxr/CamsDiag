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
import static main.CamReqs.MainInfo.AsmDescription_Label;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.NumberOfCams;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.CamsDiag_Desc;
import static main.common.MainVars.CamsDiag_JobName;
import static main.common.MainVars.CamsDiag_NofCams;

/**
 *
 * @author MManolas
 */
public class Create_TXTs {
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
CamsDiag_Create_CamJobNameTXT();
CamsDiag_Create_CamJobNameTXT_General();
CamsDiag_Create_NofCamsTXT();
CamsDiag_Create_NofCamsTXT_General();

    }
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void CamsDiag_Create_NofCamsTXT() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer+"\\"+mainFolder+"\\"+
                CamJobName() + "\\"+CamsDiag_NofCams);
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = String.valueOf(NumberOfCams())
                  // NumberOfCams_String()
                    
            );
            w.close();
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void CamsDiag_Create_NofCamsTXT_General() throws FileNotFoundException, IOException, Exception {
        File statText = new File(
                PathWebServer+"\\"+
                mainFolder+"\\"+
                CamsDiag_NofCams);
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = String.valueOf(NumberOfCams())
                    //NumberOfCams_String()
            );
            w.close();
        }
    }    
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void CamsDiag_Create_DescriptionTXT() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer+"\\"+mainFolder+"\\"+
                CamJobName() + "\\"+CamsDiag_Desc);
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = AsmDescription_Label()
                  // NumberOfCams_String()
                    
            );
            w.close();
        }
    }    
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void CamsDiag_Create_DescriptionTXT_General() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer+"\\"+mainFolder+"\\"+
                CamsDiag_Desc);
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = AsmDescription_Label()
                  // NumberOfCams_String()
                    
            );
            w.close();
        }
    }    
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void CamsDiag_Create_CamJobNameTXT() throws FileNotFoundException, IOException, Exception {
        File statText = new File(
                PathWebServer+"\\"+
                mainFolder+"\\"+
                CamJobName() + "\\"+CamsDiag_JobName);
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = CamJobName()
            );
            w.close();
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void CamsDiag_Create_CamJobNameTXT_General() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer+"\\"+
                mainFolder+"\\"+CamsDiag_JobName);
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = CamJobName()
            );
            w.close();
        }
    }

}
