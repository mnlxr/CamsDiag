/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.awt.Desktop;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import main.CamReqs.MainInfo;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.WebServerPath;
import static main.common.CheckConnection.Get_StatusServer_Boolean;
import static main.common.CheckConnection.urlpath;
import static main.common.Folders.MainLinkWEB;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.Folders.portApache;
import static main.common.Folders.portNginx;
import static main.common.MainVars.CamsDiag_JobName;
import static main.common.MainVars.main_path_installation;
import static main.common.MainVars.userDataBackUp;
import main.info.UserInfo;
import static main.pros.SystemProps.ReadProp_port;

/**
 *
 * @author MManolas
 */
public class Windows {
    
    /**
     *
     * @param process
     * @return
     * @throws IOException
     */
    public static String CheckProcessTaskManager(String process) throws IOException {
        String h1 = "";
        String line;
        String pidInfo = "";

        Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

        try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            while ((line = input.readLine()) != null) {
                pidInfo += line;
            }
        }
        if (pidInfo.contains(process)) {
            h1 = process + " is Running";

        } else {
            h1 = process + "is Not Running";
        }
        return h1;

    }
    
    /**
     *
     * @param process
     * @return
     * @throws IOException
     */
    public static boolean CheckProcessBTaskManager(String process) throws IOException {
        boolean h1 = true;
        String line;
        String pidInfo = "";

        Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

        try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            while ((line = input.readLine()) != null) {
                pidInfo += line;
            }
        }
        if (pidInfo.contains(process)) {
            h1 = true;

        } else {
            h1 = false;
        }
        return h1;

    } 
        
    /**
     *
     * @throws IOException
     */
    public static void EraseLast_Job() throws IOException {
            String lastjob=Read_CAM_Job_General(CamsDiag_JobName);
            File file = new File(lastjob);
            deleteDirS(file);
            String lasthtml = lastjob+".html";
            File file1 = new File(lasthtml);
            deleteDirS(file1);
//        RandomAccessFile f = new RandomAccessFile(logpath, "rw");
//        long length = f.length() - 1;
//        byte b;
//        do {
//            length -= 1;
//            f.seek(length);
//            b = f.readByte();
//        } while (b != 10 && length > 0);
//        f.setLength(length + 1);
//        f.close();
    }      
        
    /**
     *
     * @param dir
     */
    public static void deleteDirS(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (final File file : files) {
                deleteDirS(file);
            }
        }
        dir.delete();
    }    
        
  private static String Read_CAM_Job_General(String filePath) 
    {
        String content = "";
 
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return content;
    }    
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String Check_WEBServer_Status() throws IOException {
        String h1 = "";
        String j1 = "";
        h1 = WebServerPath();
        String webLibs = "";
        try {
            if (h1.endsWith("http://localhost:" + Folders.portNginx + "/" + mainFolder + "/")) {
                j1 = CheckNGINX();

            } else if (h1.endsWith("http://localhost:" + Folders.portApache + "/" + mainFolder + "/")) 
            {
                j1 = CheckApache();
            }
        } catch (IOException e) {
        }

        return j1;
    }
        
    /**
     *
     * @return
     * @throws IOException
     * @throws ExceptionInInitializerError
     * @throws URISyntaxException
     */
    public Icon WebServer_statusIcon() throws IOException, ExceptionInInitializerError, URISyntaxException {
        ImageIcon j1 = null;
        String h2 = "";



        try {
            if (WebServerPath().endsWith("http://localhost:" + Folders.portNginx + "/" + mainFolder + "/")) {
                j1 = (ImageIcon) NGIXstatusIcon();

            } else if (WebServerPath().endsWith("http://localhost:" + Folders.portApache + "/" + mainFolder + "/"))
            {
                j1 = (ImageIcon) ApachestatusIcon();
            }
        } catch (IOException e) {
        }
        return j1;
    }
    
    /**
     *
     * @return
     */
    public static String Check_WebLibs() {
        String h1 = "";    
        try {
                
                
                String h2 = portApache;
                String h3 = portNginx;
                
                if (ReadProp_port().endsWith("8158")) {
                    h1 = "nginx\\html\\MnIT_libs";
                } else if(ReadProp_port().endsWith("8198")){
                    h1 = "httpd\\Apache2\\htdocs\\MnIT_libs\\";
                }
                
  } catch (IOException ex) {
                Logger.getLogger(Windows.class.getName()).log(Level.SEVERE, null, ex);
            }
   return h1; }
            
    /**
     *
     * @return
     */
    public static String Check_PathWebServer() {
        String h1 = "";
        try {

            String h2 = portApache;
            String h3 = portNginx;

            if (ReadProp_port().endsWith("8158")) {
                h1 = main_path_installation+"\\"+"nginx\\html\\";
            } else if (ReadProp_port().endsWith("8198")) {
                h1 = main_path_installation+"\\"+"httpd\\Apache2\\htdocs\\";
            }

        } catch (IOException ex) {
            Logger.getLogger(Windows.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h1.trim();
    }      
    
    private static void CopyUserData_BackUp(File src, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
// buffer size 1K 
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    /**
     *
     * @throws IOException
     */
    public static void UserDataBackUp() throws IOException {
        String username = UserInfo.Get_UserName().toLowerCase();
        String folder_user = "";
        String dir = main_path_installation + "\\" + userDataBackUp + "\\" + username + "\\" + CamJobName();

        //Create the Folder
        File file = new File(dir);
        
        if (file.mkdirs()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
        
        File srcJS = new File(PathWebServer + "//" + mainFolder + "//"
                + CamJobName() + "\\" + CamJobName() + ".js");
        File destJS = new File(dir+"\\"+CamJobName()+"_"+DataBackUpDate()+".js");
//
//        File srcPy = new File(PathWebServer+"\\"+
//                mainFolder+"\\"+
//                CamJobName() + "\\"+PythonFolderMainName()+"\\" + PyNamesFiles() + ".py");
//        
//        File destPy = new File(dir+"\\"+CamJobName()+"_"+DataBackUpDate()+".py");
        
        CopyUserData_BackUp(srcJS, destJS);
        //CopyUserData_BackUp(srcPy, destPy);
        //SedCamJobUserData();
    }

    /**
     *
     * @param prop
     * @return
     */
    public static String getPropertyAsString(Properties prop) {    
  StringWriter writer = new StringWriter();
  prop.list(new PrintWriter(writer));
  return writer.getBuffer().toString();
}
    
    /**
     *
     * @param s
     * @return
     * @throws IOException
     */
    public Properties parsePropertiesString(String s) throws IOException {
    // grr at load() returning void rather than the Properties object
    // so this takes 3 lines instead of "return new Properties().load(...);"
    final Properties p = new Properties();
    p.load(new StringReader(s));
    return p;
}
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String CheckNGINX() throws IOException {
        //boolean b1 = Windows.CheckProcessBTaskManager("nginx.exe");
        String h1 = "nginx Web Server";
        String h2 = "";
        if (false == CheckNGINX_Boolean()) {
            h2 = h1 + " is Not Running";
        } else {
            h2 = h1 + " is Running";
        }
        return h2;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public Icon NGIXstatusIcon() throws IOException {
        ImageIcon h1 = null;
        if (CheckNGINX().endsWith(" is Running")) {
            h1 = createImageIcon("/main/images/nginx.png", "");
        } else {
            h1 = createImageIcon("/main/images/cancel.png", "");

        }
        return h1;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static boolean CheckNGINX_Boolean() throws IOException {
        boolean b1 = Windows.CheckProcessBTaskManager("nginx.exe");

        boolean h2;
        if (false == b1) {
            h2 = false;
        } else {
            h2 = true;
        }
        return h2;
    }   
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String CheckApache() throws IOException {
        //boolean b1 = Windows.CheckProcessBTaskManager("nginx.exe");
        String h1 = "Apache Web Server";
        String h2 = "";
        if (false == CheckApache_Boolean()) {
            h2 = h1 + " is Not Running";
        } else {
            h2 = h1 + " is Running";
        }
        return h2;
    }    
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static boolean CheckApache_Boolean() throws IOException {
        boolean b1 = Windows.CheckProcessBTaskManager("httpd.exe");

        boolean h2;
        if (false == b1) {
            h2 = false;
        } else {
            h2 = true;
        }
        return h2;
    }     
    
    /**
     *
     * @return
     * @throws IOException
     */
    public Icon ApachestatusIcon() throws IOException {
        ImageIcon h1 = null;
        if (CheckApache().endsWith(" is Running")) {
            h1 = createImageIcon("/main/images/apache.png", "");
        } else {
            h1 = createImageIcon("/main/images/cancel.png", "");

        }
        return h1;
    }    
    
    /**
     *
     */
    public static void StartWebServer_EXE() {
        /*Runtime.
   getRuntime().
   exec("cmd /c start \"\" build.bat");*/
        
        
        try {
            Runtime runTime = Runtime.getRuntime();
            String executablePath = "cmd /c start \"\" \"C:\\Users\\mmanolas\\Documents\\NetBeansProjects\\Cams_Diag\\cams_bin\\start_web_server.exe\"";
            Process process = runTime.exec(executablePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    
    /** Returns an ImageIcon, or null if the path was invalid.
     * @param path
     * @param description
     * @return  */
public  ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}

    /**
     *
     * @return
     */
    public static String MousePoints() {
       
        Integer[] i = null;
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y = p.y;
        String h3=String.valueOf(y);
        String h4=String.valueOf(x);
        String[] j1 = {h4,h3};
            //j1=[x,y];
        String str = String.join(",", j1);
return str;

    }
    
//    public static String WebServerPath() throws URISyntaxException {
//        String h1 = "";
//        h1 = "http://localhost:"+Folders.portNginx +"/"+mainFolder+"/";
//        return h1;
//    }

    /**
     *
     * @return
     * @throws URISyntaxException
     */
    
        public static String WebServerPathApache() throws URISyntaxException {
        String h1 = "";
        h1 = "http://localhost:"+Folders.portApache +"/"+mainFolder+"/";
        return h1;
    }
    
    /**
     *
     * @return
     * @throws URISyntaxException
     */
    public static String WebServerPathNginx() throws URISyntaxException {
        String h1 = "";
        h1 = "http://localhost:"+Folders.portNginx +"/"+mainFolder+"/";
        return h1;
    }

    /**
     *
     * @return
     */
    public static String LibPath_HTML_Windir() {
    String h1="";
    h1="../MnIT_libs";
    return h1;}
    
    /**
     *
     * @return
     */
    public static String LibPathServer_HTML_Windir() {
    String h1="";
    h1="../../MnIT_libs";
    return h1;}    
    
    /**
     *
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String WebServer_LastJob() throws URISyntaxException, IOException {
        String h1 = "";
        h1 = MainLinkWEB()+MainInfo.CamJobName();
        //h1 = WebServerPath()+MainInfo.CamJobName();
        return h1;
    }
    
    /**
     *
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String WebServer_LastJobW() throws URISyntaxException, IOException {
        String h1 = "";
        h1 = WebServerPath()+MainInfo.CamJobName();
        return h1;
    }
        
    
    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (IOException e) {
                /* TODO: error handling */ }
        } else {
            /* TODO: error handling */ }
    }
    
    /**
     *
     * @return
     */
    public static String ZipDate() {
    String h1="";
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmmss");
System.out.println(formatter.format(date));
h1 = formatter.format(date);
    return h1;}
    
    /**
     *
     * @return
     */
    public static String DataBackUpDate() {
    String h1="";
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
System.out.println(formatter.format(date));
h1 = formatter.format(date);
    return h1;}    
    
    /**
     *
     * @param directoryToBeDeleted
     * @return
     */
    public static boolean DeleteDirectory(File directoryToBeDeleted) {
    File[] allContents = directoryToBeDeleted.listFiles();
    if (allContents != null) {
        for (File file : allContents) {
            DeleteDirectory(file);
        }
    }
    return directoryToBeDeleted.delete();
}
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String CheckInternetConnection() throws IOException {
        
        String h1 = "Internet Connection : ";
        String h2 = "";
        if (Get_StatusServer_Boolean(urlpath) == true) {
            h2 = h1 + " is OK";
        } else {
            h2 = h1 + " is Not OK";
        }
        return h2;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static String CheckCamsDiagConnection() throws IOException {
        
        String h1 = MainVars.aniscamsdiag01+" Connection : ";
        String h2 = "";
        if (Get_StatusServer_Boolean(MainVars.aniscamsdiag01url) == true) {
            h2 = h1 + " is OK";
            System.out.println(h1 + " is OK");
        } else {
            h2 = h1 + " is Not OK";
            System.out.println(h1 + " is Not OK");
        }
        return h2;
    }            
            
    /**
     *
     * @return
     * @throws IOException
     */
    public Icon InternetConnectionStatusIcon() throws IOException {
        ImageIcon h1 = null;
        if (CheckInternetConnection().endsWith(" is OK")) {
            h1 = createImageIcon("/main/images/flag_green.png", "");
        } else {
            h1 = createImageIcon("/main/images/flag_red.png", "");

        }
        return h1;
    }
    
    
//    public static boolean WebPhraseToCheck() {
//        String h1="";
//        String h2 = "";
//        h1 = WebServerPath();
//            
//            boolean kk1 = h1.endsWith(Folders.portNginx + "/"+mainFolder+"/");
//            boolean kk2 = h1.endsWith(Folders.portApache + "/"+mainFolder+"/");
//            boolean result;
//            
//            if (kk1 == true) {
//            result=true;
//        } else {
//                result=false;
//        }
            
            
//            if (h1.contains(Folders.portNginx) == true) {
//            h2 = "http://localhost:"+Folders.portNginx +"/"+mainFolder+"/";
//        } else //if (h1.endsWith("http://localhost:"+Folders.portApache + "/"+mainFolder+"/"))
//        {
//            h2 = "http://localhost:"+Folders.portApache + "/"+mainFolder+"/";
//                
//        }
    
//    return result;}
}
