/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.WebServerPath;
import static main.common.MainVars.aniscamsdiag01_Upload;
import static main.common.Windows.Check_PathWebServer;
import static main.common.Windows.Check_WebLibs;

import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class Folders {
  
    public static String WindowsPathAbs="C:\\Users\\mmanolas\\Documents\\NetBeansProjects\\MnIT_CamsDiag\\";
    
    
//    public static String PathWebServerApache = "httpd\\Apache2\\htdocs";//\httpd\Apache2\htdocs | Apache24\\htdocs\\
//    public static String PathWebServerNginx = "nginx\\html\\";
    
    //public static String PathWebServer = Check_PathWebServer();

    public static String mainFolder = UserInfo.Get_UserName().toLowerCase() + "_CamsCharts";
    public static String ZipuserPath = UserInfo.Get_UserName().toLowerCase() + "_CamsCharts";
//    public static String webLibsApache = "httpd\\Apache2\\htdocs\\MnIT_libs";
//    public static String webLibsNginx = "nginx\\html\\MnIT_libs";
    
    
    
    public static String webLibsApache = "httpd\\Apache2\\htdocs\\MnIT_libs\\";
    public static String webLibsNginx = "nginx\\html\\MnIT_libs";
    
    public static String PathWebServerApache = "httpd\\Apache2\\htdocs\\";
    public static String PathWebServerNginx = "nginx\\html\\";
    
    public static String PathWebServer = Check_PathWebServer();
    public static String webLibs = Check_WebLibs();
    

    

    
    //%sedpath% -i "s/^[ \t]*//;s/[ \t]*$//" "%tempf%"
    
    //public static String webLibs = Check_WebLibs();
    
    public static String portApache = "8198";
    public static String portNginx = "8158";

  public static String userbackup="UserBackUp";
    
    
            public static void main(String args[]) throws Exception {
Create_CamJobFolder();
Create_Camsolder();
Create_Python_CamJobFolder();
CreateUserBackForlder();
CopyImagesForReport();
//Create_Python_CamParameters();

    }
    
    public static String MainLinkWEB() throws IOException {
        String mainlink = "";
        mainlink = WebServerPath();
        return mainlink;
    }
            
            
        public static String Create_CamJobFolder() throws IOException {
        String dir = PathWebServer+mainFolder+"\\"+CamJobName();

        File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        return dir;
    }
        
        public static String Create_Camsolder() throws IOException {
        String dir = PathWebServer+mainFolder+"\\"+CamJobName()+"\\cams";

        File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        return dir;
    }

        public static String Create_PRODCamsJobFolder() throws IOException {
        String dir = aniscamsdiag01_Upload+"\\"+CamJobName()+"\\cams";

        File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        return dir;
    }        
        
        
        public static String Create_Python_CamJobFolder() throws IOException {
        String dir = PathWebServer+mainFolder+"\\"+CamJobName()+"\\"+PythonFolderMainName();

        File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        return dir;
    } 
        
        public static String Create_Python_CamParameters() throws IOException {
        String dir = PathWebServer+mainFolder+"\\"+CamJobName()+"\\"+PythonFolderMainName()+"\\"+PythonFolderParametersName();

        File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        return dir;
    }    
        
        public static String Create_Python_CamParametersArbortext() throws IOException {
        String dir = PathWebServer+mainFolder+"\\"+CamJobName()+"\\"+PythonFolderMainName()+"\\"+PythonFolderParametersName_Arbortext();

        File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        return dir;
    }        
        
        public static String PythonFolderMainName() {
        String h1="";
        h1="python".toLowerCase();
        return h1;
        }
        
        public static String Pythonvars() {
        String h1="";
        h1="Vars";
        return h1;
        }         
        
        
        public static String PythonFolderParametersName() {
        String h1="";
        h1="Run_This_File";
        return h1;
        }   
        
    public static String PythonFolderParametersName_Arbortext() {
        String h1 = "";
        h1 = "Run_This_File_ArborText";
        return h1;
    }
        
        public static String WebEchartsFolderMainName() {
        String h1="";
        h1="web".toLowerCase();
        return h1;
        }    
    
        
        public static String CreateUserBackUp_Folder() throws IOException {
        String dir = userbackup;

        File file = new File(dir);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        return dir;
    }        
        
        
    public static void CreateUserBackForlder() {
        File theDir = new File(userbackup);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
    
    public static void CreateUserCamsFolder() {
            File theDir = new File(PathWebServer+mainFolder);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    //PathWebServer+mainFolder
    }
    
    public static void CheckIfCamsFolderExist() throws IOException {
        
        //int i = /("Are your sure ?");
        
        
        String hq = PathWebServer + mainFolder + "\\" + CamJobName();
        //int i2 = CamJobExist_YesNoCancel("Cam Job Name : "+hq);
        File tmpDir = new File(hq);
        boolean exists = tmpDir.exists();
        if (exists) {
            System.out.println(hq + " exists");
            //int i2 =  JOptionPane.showConfirmDialog(null, "Do you like bacon?"+hq);
            
//            Object[] options = {"Yes, please", "No way!"};
//            int n = JOptionPane.showOptionDialog(null,
//                    "The CamJob : " + CamJobName() + " Exist.\nWould you like to use Previous Job?",
//                    "CamsDiag : " + CamJobName(),
//                    JOptionPane.YES_NO_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,
//                    options,
//                    options[0]);
//            if (n == JOptionPane.YES_OPTION) {
//
//            } else if (n == JOptionPane.NO_OPTION) {
//
//            } else {
//
//            }           
            
            
        } else {
            System.out.println(hq + " NOT exists");
        }
        if (tmpDir.isDirectory()) {
            System.out.println(hq + " is a directory");
        }

//    // test to see if a file exists
//    File file = new File("/Users/al/.bash_history");
//    exists = file.exists();
//    if (file.exists() && file.isFile())
//    {
//      System.out.println("file exists, and it is a file");
//    }
    }
     
    
private static void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }
}    
    



public static void CopyImagesForReport() throws IOException {
File camsdiag_icon = new File(Check_PathWebServer() + "\\MnIT_libs\\imgs\\camsdiag01.png");
File biclogo_icon = new File(Check_PathWebServer() + "\\MnIT_libs\\imgs\\bic_icon.png");
//File statText = new File(Check_PathWebServer()+mainFolder+"\\_CamsCharts"+ CamJobName()+"\\");
//File statText = new File("C:\\4del");
//System.out.println(statText);
//System.out.println(biclogo_icon);

try {

Path bytes = Files.copy(

new File(Check_PathWebServer() + "\\MnIT_libs\\imgs\\camsdiag01.png").toPath(),

new File(PathWebServer+mainFolder+"\\"+CamJobName()+"\\camsdiag01.png").toPath(),REPLACE_EXISTING,COPY_ATTRIBUTES,NOFOLLOW_LINKS);

System.out.println("File successfully copied using Java 7 way");

} catch (IOException e) {
e.printStackTrace();
}

try {

Path bytes = Files.copy(

new File(Check_PathWebServer() + "\\MnIT_libs\\imgs\\bic_icon.png").toPath(),

new File(PathWebServer+mainFolder+"\\"+CamJobName()+"\\bic_icon.png").toPath(),REPLACE_EXISTING,COPY_ATTRIBUTES,NOFOLLOW_LINKS);

System.out.println("File successfully copied using Java 7 way");

} catch (IOException e) {
e.printStackTrace();
}
    //copyFile(Check_PathWebServer() + "\\MnIT_libs\\imgs\\camsdiag01.png","C:\\4del\\camsdiag01.png");
    //copyFileUsingStream(biclogo_icon, statText);
    //copyFileUsingStream(camsdiag_icon, statText);
    //copyFile(String from, String to);
} 
    
    
}
