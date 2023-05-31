/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

/**
 *
 * @author MManolas
 */
 import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author MManolas
 */
public class FileToString {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    StringBuffer buffer = new StringBuffer();
    BufferedReader reader = new BufferedReader(
        new FileReader("build.xml"));
    char[] ch = new char[1024];
    int n = 0;
    while ((n = reader.read(ch)) != -1) {
      buffer.append(ch, 0, n);
    }
    reader.close();
    String str = buffer.toString();
    System.out.println(str.toLowerCase());
  }
  
    /**
     *
     * @param filename2read
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String F2String(String filename2read) throws FileNotFoundException, IOException {
        //String line18 = Files.readAllLines(Paths.get("file.txt")).get(18);
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filename2read));
        char[] ch = new char[1024];
        int n = 0;
        while ((n = reader.read(ch)) != -1) {
            buffer.append(ch, 0, n);
            
        }
        reader.close();
        String str = buffer.toString();
       
        return str;
    }
  
    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static String ReadFileFromSpecificLine(String filename) throws IOException {
        String h1 = "";
        String line18 = Files.readAllLines(Paths.get(filename)).get(18);
        return line18;
    }
    
    /**
     *
     * @param pathname
     * @return
     * @throws IOException
     */
    public static String readFileTXT(String pathname) throws IOException {

        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int) file.length());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator()); 
                
                //fileContents.replace(0, fileContents.length()-1, "\n");
            }
            
            return fileContents.toString();
        }
    }
      
      
      
  
  
}
