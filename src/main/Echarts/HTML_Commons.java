/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.Echarts;

import java.io.IOException;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.WebServerPath;
import static main.common.MainVars.emaildev;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class HTML_Commons {

    public static String HTML_Head_MetaData() throws IOException {
        String h1 = "";
        h1 = "\n"
                + "<meta name=\"description\" content=\"CamsDiag - Cams Charts Software\" />\n"
                + "<meta name=\"copyright\" content=\""+CopyRightText()+"\">\n"
                + "<meta name=\"keywords\" content=\"cam,chart,echarts," + CamJobName() + "\" />\n"
                + "<meta name=\"author\" content=\"" + UserInfo.Get_UserName() + "\" />\n"
                + "<meta name=\"designer\" content=\"Manolis Manolas\" />\n"
                + "<meta name=\"reply-to\" content=\"manolis.manwlas@hotmail.com\">\n"
                + "<meta http-equiv=\"Pragma\" content=\"no-cache\">\n"
                + "<meta http-equiv=\"Cache-Control\" content=\"no-cache\">\n"
                + "\n"
                + "<meta property=\"og:url\" content=\"" + WebServerPath() + CamJobName() + ".html" + "\" />\n"
                + "<meta property=\"og:image\" content=\"/imgs/camsdiag01.png\" />\n"
                + "<meta property=\"og:title\" content=\".:: Cams Diagramms : " + UserInfo.Get_UserName() + "_" + CamJobName() + " ::.\" />\n"
                + "<meta property=\"og:site_name\" content=\" CamsDiag :: " + UserInfo.Get_UserName() + "-" + CamJobName() + "\" />\n"
                + "<meta name=\"og:email\" content=\"manolis.manwlas@hotmail.com\"/>\n"
                + "<meta name=\"og:phone_number\" content=\"+302106299365\"/>\n";
        return h1;
    }

    public static String HTML_footer() {
        String h1 = "";
        h1 = ""
                + "\n<footer  id=\"footer\">\n"
                + "<hr>\n"
                + "<p>© All rights reserved, including cases of proprietary applications. \n"
                + "        We retain sole power of disposal including all righty relating to copying and distribution.</p>\n"
                + "<p>Developer : <a href=\"mailto:manolis.manwlas@hotmail.com\">M.Manolas</a> - 2022 </p>\n"
                + "</footer>\n";
        return h1;
    }
    
    public static String CopyRightText() {
    String h1="";
    h1="All rights reserved by Bic Group S.A., including cases of proprietary applications. We retain sole power of disposal including all righty relating to copying and distribution.";
    return h1;
    }
    
    public static String HTML_footer2() {
        String h1 = "";
        h1 = "\n<footer  id=\"footer\">\n"
                + "<hr>\n"
                + "<p>© All rights reserved by Bic Group S.A., including cases of proprietary applications. \n"
                + "        We retain sole power of disposal including all righty relating to copying and distribution.</p>\n"
                + "<p>Developer : <a href=\"mailto:"+emaildev+"\">M.Manolas</a> - 2022 </p>\n"
                + "</footer>\n";
        return h1;
    }    

    
    
    
    
    
}
 