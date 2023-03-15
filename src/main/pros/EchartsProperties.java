/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pros;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static main.common.MainVars.echartspropfile;
import main.common.Windows;
import static main.pros.SystemProps.echartsProps;

/**
 *
 * @author MManolas
 */
public class EchartsProperties {

    public static String ReadProp_EchartsLabels() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(echartspropfile)) {

            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                //return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            //System.out.println(prop.getProperty("camsdiag.webserver"));
            //System.out.println(prop.getProperty("db.user"));
            //System.out.println(prop.getProperty("db.password"));
        }

        return prop.getProperty(echartsProps + ".labels");
    }

    public static String ReadProp_EchartsSymbolSize() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(echartspropfile)) {

            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                //return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        }

        return prop.getProperty(echartsProps + ".symbol_size");
    }

    public static String ReadProp_EchartsTheme() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(echartspropfile)) {

            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                //return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        }

        return prop.getProperty(echartsProps + ".theme");
    }

    public static String ReadProp_EchartsChartsOpacity1() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(echartspropfile)) {

            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                //return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        }

        return prop.getProperty(echartsProps + ".opacity1");
    }

    public static String ReadProp_EchartsTextColor() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(echartspropfile)) {
            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                //return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        }

        return prop.getProperty(echartsProps + ".text_color");
    }

    public static String ReadProp_EchartsBICColor() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(echartspropfile)) {

            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                //return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        }

        return prop.getProperty(echartsProps + ".bic_color");
    }

    public static String ReadProp_EchartsLineWidth() throws IOException {
        String h1 = "";
        Properties prop;
        try (InputStream input = Windows.class.getClassLoader().getResourceAsStream(echartspropfile)) {

            prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                //return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        }

        return prop.getProperty(echartsProps + ".line_width");
    }
}
