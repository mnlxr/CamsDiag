/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pros;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static main.common.MainVars.propfile;
import main.common.Windows;

/**
 *
 * @author MManolas
 */
public class SystemProps {
    
    /**
     *
     */
    public static String camsdiagProps="camsdiag";

    /**
     *
     */
    public static String echartsProps="echarts";
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String ReadProp_port() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(propfile)) {
            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
        }
        return prop.getProperty(camsdiagProps+".webport");
    }
        
    /**
     *
     * @return
     * @throws IOException
     */
    public static String CamsDiag_MainPath() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(propfile)) {
            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
        }
        return prop.getProperty(camsdiagProps+".mainpath");
    }       
        
    /**
     *
     * @return
     * @throws IOException
     */
    public static String CamsDiag_HelpPath() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(propfile)) {
            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                System.out.println();
            }
            prop.load(input);
        }
        return prop.getProperty(camsdiagProps+".help");
    }     
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String CamsDiag_WebURL() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(propfile)) {
            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
        }
        return prop.getProperty(camsdiagProps+".weburl");
    }    
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String CamsDiag_WebServerName() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(propfile)) {
            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
        }
        return prop.getProperty(camsdiagProps+".webserver_name");
    }     
    

        
}
