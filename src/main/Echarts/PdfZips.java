/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.Echarts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import static main.CamReqs.MainInfo.CamJobName;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.ZipuserPath;
import static main.common.Folders.mainFolder;
import static main.utils.Zip.zipFolder;

/**
 *
 * @author MManolas
 */
public class PdfZips {
 
    /**
     *
     */
    public static String filename = PathWebServer+"//"+mainFolder+"//";
            //CamReqs.MainInfo.CamJobName()+"_"+ZipDate()+".zip";
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String PythonPdfZipName() throws IOException {
        String h1 = "";

        h1 = PathWebServer + "//" + mainFolder + "//" + CamJobName() + "_" + "pdfs.zip";

        return h1;
    }
    
    /**
     *
     * @throws IOException
     * @throws Exception
     */
    public static void CreateZipPdf() throws IOException, Exception {
        String zipFile = PythonPdfZipName();
         
        String[] srcFiles = { "C:/srcfile1.txt", "C:/srcfile2.txt", "C:/srcfile3.txt"};
        zipFolder(PathWebServer+ZipuserPath, filename);
         
        try {
             
            // create byte buffer
            byte[] buffer = new byte[1024];
 
            FileOutputStream fos = new FileOutputStream(zipFile);
 
            ZipOutputStream zos = new ZipOutputStream(fos);
             
            for (int i=0; i < srcFiles.length; i++) {
                 
                File srcFile = new File(srcFiles[i]);
 
                FileInputStream fis = new FileInputStream(srcFile);
 
                // begin writing a new ZIP entry, positions the stream to the start of the entry data
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                 
                int length;
 
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
 
                zos.closeEntry();
 
                // close the InputStream
                fis.close();
                 
            }
 
            // close the ZipOutputStream
            zos.close();
             
        }
        catch (IOException ioe) {
            System.out.println("Error creating zip file: " + ioe);
        }    
    }
    
    
    
//        try {
//            String filename = userbackup+"\\"+mainFolder+"_"+ZipDate()+".zip";
//            
//            openZipDir.setEnabled(false);
//            zip_data.setText("Please Wait...\n");
//            zip_data.append("*********************************\n");
//            zipFolder(PathWebServer+ZipuserPath, filename);
//            //zip_data.setText("Please Wait...\n");
//            jLabel17.setText("ZIP is Ready");
//            zip_data.append("ZIP is Ready\n");
//            zip_data.append("File Name : "+filename.substring(11,filename.length())+"\n");
//            zip_data.append("Path : "+"C:\\Data\\CamsDiag\\UserBackUp\\"+ZipuserPath+"\n");
//            Path path = Paths.get(filename);
//            long bytes = Files.size(path);
//            String filesize = String.format("%d kilobytes", bytes/1024);
//            zip_data.append("Size : "+filesize+"\n");
//            zip_data.append("*********************************\n");
//            String[] pathnames;
//            File f = new File("UserBackUp\\");
//            FilenameFilter filter = new FilenameFilter() {
//        @Override
//        public boolean accept(File f, String name) {
//            return name.endsWith(".zip");
//        }
//    };
//            
//            pathnames = f.list(filter);
//            zip_data.append("Total BackUp ZIP Files : "+f.listFiles(filter).length+"\n");
//            zip_data.append("BackUp Files : \n");
//            for (String pathname : pathnames) 
//            {zip_data.append(pathname+"\n");}
//            openZipDir.setEnabled(true);
//        } catch (Exception ex) {
//            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
//        }    
    
    
}
