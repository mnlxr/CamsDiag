/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 * @author MManolas
 */
public class UserInfo {
    
    
    
    
    public static String Header_Comments() throws Exception {
        String h1 = "";
        h1 = "\n/*\n"
                //+ OneLine_Comment()
                + "//Date : " + Set_TimeCountry() + "\n"
                + "//Name : Manolis Manolas\n"
                + "//Email : manolis.manolas@bicworld.com\n"
                + "//App : CAMs Diagr.\n"
                + "//Echarts :: Powered By Apache\n"
                + "#"+OneLine_Comment()                
                + "//User Name : " + Get_UserName() + "\n"
                + "//Computer Name : " + Get_ComputerName() + "\n"               
                + "//IP : " + Get_PublicIP() + "\n"
                + "//Java Version : " + Get_JavaVersion() + "\n"
                + "//Vendor : " + Get_Vendor() + "\n"
                + "//OS Name : " + Get_OsName() + "\n"
                + "//OS Version :" + Get_OsVersion() + "\n"
                + "//OS Arch : " + Get_OsArch() + "\n"
                //+ OneLine_Comment()
                //+"*/"
                ;
        return h1;
    }   
    
        public static String Header_Comments_Py() throws Exception {
        String h1 = "";
        h1 = "\n#"
                +"#"+OneLine_Comment()
                + "#Date : " + Set_TimeCountry() + "\n"
                + "#Name : Manolis Manolas\n"
                + "#Email : manolis.manolas@bicworld.com\n"
                + "#App : CAMs Diagr.\n"
                + "#Echarts :: Powered By Apache\n"
                +"#"+OneLine_Comment()                
                + "#User Name : " + Get_UserName() + "\n"
                + "#Computer Name : " + Get_ComputerName() + "\n"               
                + "#IP : " + Get_PublicIP() + "\n"
                + "#Java Version : " + Get_JavaVersion() + "\n"
                + "#Vendor : " + Get_Vendor() + "\n"
                + "#OS Name : " + Get_OsName() + "\n"
                + "#OS Version :" + Get_OsVersion() + "\n"
                + "#OS Arch : " + Get_OsArch() + "\n"
                +"#"+OneLine_Comment();
        return h1;
    } 
    
    
        public static String Set_TimeCountry() throws Exception {
        
        String h2 = "";
        boolean fr_mon = Get_ComputerName().startsWith("MON") || Get_ComputerName().startsWith("VER") || Get_ComputerName().startsWith("CLI");
        boolean gr_ani = Get_ComputerName().startsWith("ANI");

        if (fr_mon == true) {
            h2 = Get_FormatDateDirSynch_CEST();
        } else if (gr_ani == true) {
            h2 = Get_FormatDateDirSynch_EEST();
        }
        return h2;
    }
    
        public static String Get_PublicIP() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }
        
        
        
        
    public static String Get_ComputerName() {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME")) {
            return env.get("COMPUTERNAME");
        } else if (env.containsKey("HOSTNAME")) {
            return env.get("HOSTNAME");
        } else {
            return "Unknown Computer";
        }
    }

    public static String Get_UserName() {
        String h1 = "";
        h1 = System.getProperty("user.name");
        return h1;
    }

    public static String Get_JavaVersion() {
        String h1 = "";
        h1 = System.getProperty("java.version");
        return h1;
    }

    public static String Get_OsVersion() {
        String h1 = "";
        h1 = System.getProperty("os.version");
        return h1;
    }

    public static String Get_OsName() {
        String h1 = "";
        h1 = System.getProperty("os.name");
        return h1;
    }

    public static String Get_OsArch() {
        String h1 = "";
        h1 = System.getProperty("os.arch");
        return h1;
    }

    public static String Get_Vendor() {
        String h1 = "";
        h1 = System.getProperty("java.vm.specification.vendor");
        return h1;
    }
    
      public static String Get_FormatDateDirSynch_EEST() {
        String strDate = "";
        DateFormat sdf;
        Date now = new Date();
        sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'EEST' yyyy");
        strDate = sdf.format(now);
        return strDate;
    }

    public static String Get_FormatDateDirSynch_CEST() {
        String strDate = "";
        DateFormat sdf;
        Date now = new Date();
        sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CEST' yyyy");
        strDate = sdf.format(now);
        return strDate;
    }

    public static String Get_CurrentTimezoneOffset() {

        TimeZone tz = TimeZone.getDefault();
        Calendar cal = GregorianCalendar.getInstance(tz);
        int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

        String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
        //offset = (offsetInMillis >= 0 ? "+" : "-") + offset;
        return offset;
    }
    
        public static String OneLine_Comment() {
        String h1 = "";
        h1 = "\n#//////////////////////////////////////////\n";
        return h1;
    }
        
}
