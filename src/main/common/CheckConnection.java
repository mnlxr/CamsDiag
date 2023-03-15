/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author MManolas
 */
public class CheckConnection {

    public static String urlpath = "https://www.google.gr/";
            
            

  

    
    
    
        public static boolean CheckStatusSever() throws IOException {
        boolean b1 = Get_StatusServer_Boolean(urlpath);
        
        if (Get_StatusServer_Boolean(urlpath) == true) {
            System.out.println("OK");
            System.out.println("You are Connected!");

            //UserVersiontoFile();
        } else {
            System.out.println("KO");
            System.out.println("You are NOT Connected!");
            System.out.println("Please Connect and Try Again!");
            System.out.println("Exit System");
            //System.exit(0);
        }
 return b1;}
    
    
    public static boolean Get_StatusServer_Boolean(String url) throws IOException {

        String result = "";
        int code = 200;

        boolean connected = false;
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000);
            connection.connect();

            code = connection.getResponseCode();
            if (code == 200) {
                connected = true;
                return connected;

            } else {
                connected = false;
                return connected;
            }
        } catch (IOException e) {
            return connected;

        }

    }

    public static Integer Get_StatusServerInt(String url) throws IOException {

        String result = "";
        int code = 200;
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000);
            connection.connect();

            code = connection.getResponseCode();
            if (code == 200) {

                return code;

            } else {
                return code;
            }
        } catch (IOException e) {
            return code;

        }

    }

}
