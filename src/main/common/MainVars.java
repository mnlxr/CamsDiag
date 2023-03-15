/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.info.UserInfo;
import static main.pros.SystemProps.CamsDiag_MainPath;

/**
 *
 * @author MManolas
 */
public class MainVars {

    
    public static String main_path_installation = "C:\\Data\\CamsDiag";//"C:\\Data\\CamsDiag"; CamsDiag_MainPath()

    public static String logpath = "CamsDiagJobs.log";
    public static String logpathFull = "CamsDiag.log";

    public File log = new File(logpath);

    public static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public static String timeStamp = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(Calendar.getInstance().getTime());

    public static String CamsDiag_JobName = "CamsDiag_JobName.txt";
    public static String CamdDiag_Job_Name_WithoutExtension = CamsDiag_JobName.substring(0, CamsDiag_JobName.length()-4);
    public static String CamsDiag_NofCams = "CamsDiag_NofCams.txt";
    public static String CamsDiag_Desc = "CamsDiag_Desc.txt";

    public static String Cam_All_js = "Cam_All.js";
    public static String CamsDiag_Common_js = "CamsDiag_Common.js";
    public static String CamsDiag_Parameters_js = "CamsDiag_Parameters.js";
    public static String CamsDiag_PropertiesFile = "CamsDiag_Properties.js";
    public static String Cam_DatGui_js = "Cam_DatGui.js";
    public static String Cam_Polar_js = "Cam_Polars.js";
    public static String Cam_StackBar_js = "Cam_StBarHor.js";
    public static String jsgeneral_js = "globmnit.js";
    public static String CamsDiag_ImgsCnvs_js = "CamsDiag_ImgsCnvs.js";

    
    public static String propfile="camsdiag.properties";
    public static String echartspropfile="echarts.properties";
     
    public static String dbname="CamsDiag"; 
    public static String dbnameFull="CamsDiag.db";
    public static String dbjsfile = "dbcams_"+UserInfo.Get_UserName().toLowerCase()+".js";
     
    public static String gnu32="gnu32\\";
    
    public static String sedwin = main_path_installation+"\\"+gnu32+"sed\\bin\\sed.exe";     
    public static String pdflitePath = main_path_installation+"\\"+gnu32+"pdflite\\bin\\";
    public static String pdfliteImage = pdflitePath+"pdfimage.exe";
    public static String pdflitepdfimpose = pdflitePath+"pdfimpose.exe";
    public static String pdflitetext2pdf = pdflitePath+"text2pdf.exe";          
    
    public static String userDataBackUp="DataBackUp";
    public static String localohostname= UserInfo.Get_ComputerName()+":8158";
    
    
    public static String LocalhostName = "http://"+UserInfo.Get_ComputerName()+":8158";
    
    public static String prod_server = "http://server01";
    public static String servername = "aniscamsdiag01";
    public static String aniscamsdiag01 = "https://"+servername;
    public static String aniscamsdiag01url = "https://"+servername+".eu.bicworld.com:8123/";
    //public static String aniscamsdiag01UNC = "\\\\"+servername+".eu.bicworld.com\\C$";
    //public static String aniscamsdiag01ApachePath = aniscamsdiag01UNC + "\\Apache24\\htdocs";
    public static String aniscamsdiag01_Upload = "\\\\aniscamsdiag01\\charts$";
    public static String anicamsdiag01IP = "172.17.32.68";
    
    public static String username = UserInfo.Get_UserName().toLowerCase();
    public static String dirLocation = main_path_installation + "\\" + userDataBackUp + "\\" + username + "\\";    
    
    public static String MainPathInstallation(){
       String h1="";
        try {
            
            h1 = CamsDiag_MainPath();
            
        } catch (IOException ex) {
            Logger.getLogger(MainVars.class.getName()).log(Level.SEVERE, null, ex);
        }
return h1;}
    
    public static String Path2ReadJOB_from_CamsDiagJobName() {
        String h1 = "";
        
        try {
            h1 = FileToString.F2String(CamsDiag_JobName);
        } catch (IOException ex) {
            Logger.getLogger(MainVars.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return h1;
    }
    
    
    public static String ReadJOB_from_CamsDiagJobName() {
        String h1 = "";
        
        try {
            h1 = FileToString.F2String(Path2ReadJOB_from_CamsDiagJobName()+"\\"+Path2ReadJOB_from_CamsDiagJobName()+".js");
        } catch (IOException ex) {
            Logger.getLogger(MainVars.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return h1;
    }    
    
    
}
