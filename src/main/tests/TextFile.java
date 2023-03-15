/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.tests;

import java.io.*;

public class TextFile
{
    public static void main(String[] args)
    {
        try
        {
            String verify, putData;
            File file = new File("CamsDiagJobs.log");
            file.createNewFile();
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("I am Shah Khalidssss\n");
            bw.flush();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while( (verify=br.readLine()) != null )
            { 
                if(verify != null)
                {
                    putData = verify.replaceAll("here", "there");
                    //bw.write(putData); 
                }
            }
            br.close();
            bw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Shah");
    }
}
