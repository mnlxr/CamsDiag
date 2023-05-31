/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

/**
 *
 * @author MManolas
 */
import java.io.File;

 import java.io.FileInputStream;

 import java.io.FileOutputStream;

 import java.util.zip.ZipEntry;

 import java.util.zip.ZipOutputStream;
import static main.MnIT_Main.libs_included;
import main.common.Folders;
import static main.common.Folders.ZipuserPath;
import static main.common.Folders.mainFolder;

/**
 *
 * @author MManolas
 */
public class Zip {

    /**
     *
     * @param a
     * @throws Exception
     */
    public static void main(String[] a) throws Exception {

    zipFolder("nginx\\html\\"+ZipuserPath, mainFolder+".zip");

  }

    /**
     *
     * @param srcFolder
     * @param destZipFile
     * @throws Exception
     */
    static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
    ZipOutputStream zip = null;
    FileOutputStream fileWriter = null;
    fileWriter = new FileOutputStream(destZipFile);
    zip = new ZipOutputStream(fileWriter);
    addFolderToZip("", srcFolder, zip);
      //addFolderToZip("", Folders.webLibs, zip);

    if (libs_included.isSelected() == true) {
        addFolderToZip("", Folders.webLibs, zip);
    } else {
        String h1 = "//addFolderToZip(\"\", Folders.webLibs, zip);";
    }
    
    
    zip.flush();
    zip.close();
  }
  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFile);
    if (folder.isDirectory()) {
      addFolderToZip(path, srcFile, zip);
    } else {
      byte[] buf = new byte[1024];
      int len;
      FileInputStream in = new FileInputStream(srcFile);
      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
      while ((len = in.read(buf)) > 0) {
        zip.write(buf, 0, len);
      }
    }
  }

  static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFolder);

    for (String fileName : folder.list()) {
      if (path.equals("")) {
        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
      } else {
        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" +   fileName, zip);
      }
    }
  }


//  public static String LibsIncludedChkBox() {
//String h1 = "";
//    if (libs_included.isSelected() == true) {
//        h1 = "addFolderToZip(\"\", Folders.webLibs, zip);\n";
//    } else {
//        h1="//addFolderToZip(\"\", Folders.webLibs, zip);\n";
//    }
//return h1;
//}

    /**
     *
     */
  
  
  public static void LibsAreIn() {
  
  }

   }
