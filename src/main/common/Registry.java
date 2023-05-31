/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.tests.Main;


/**
 *
 * @author MManolas
 */
public class Registry {

    /**
     *
     */
    public static String regpath = "HKEY_LOCAL_MACHINE\\SOFTWARE\\WOW6432Node\\BIC_Violex\\PTC_config";
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String GetUserRegDisplayName() throws IOException {

        String value = null;
        try {
            value = Get_ValueFromRegistry("HKEY_LOCAL_MACHINE\\SOFTWARE\\WOW6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{43AB51D9-DC48-44B9-A942-53CDC4161E6E}_is1", "DisplayName");
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;

    } 
    
    /**
     *
     * @param keyPath
     * @param keyName
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static String Get_ValueFromRegistry(String keyPath, String keyName)
            throws IOException, InterruptedException {
        Process keyReader = Runtime.getRuntime().exec(
                "reg query \"" + keyPath + "\" /v \"" + keyName + "\"");

        BufferedReader outputReader;
        String readLine;
        StringBuilder outputBuffer = new StringBuilder();

        outputReader = new BufferedReader(new InputStreamReader(
                keyReader.getInputStream()));

        while ((readLine = outputReader.readLine()) != null) {
            outputBuffer.append(readLine);
        }

        String[] outputComponents = outputBuffer.toString().split("    ");

        keyReader.waitFor();

        return outputComponents[outputComponents.length - 1];
    }   
    
}
