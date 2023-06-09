/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import main.CamReqs.MainInfo;
import static main.CamReqs.MainInfo.AsmDescription_Label;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.NumberOfCams_String;
import static main.CamReqs.MainInfo.WebServerPath;
import static main.Echarts.Create_TXTs.CamsDiag_Create_DescriptionTXT;
import main.MnIT_Main;
import main.common.FileToString;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.PythonFolderMainName;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.CamsDiag_Desc;
import static main.common.MainVars.CamsDiag_NofCams;
import static main.common.MainVars.logpath;
import static main.common.MainVars.logpathFull;
import static main.common.MainVars.main_path_installation;
import static main.common.MainVars.userDataBackUp;
import static main.common.Windows.DataBackUpDate;
import main.info.UserInfo;
import static main.utils.CamsDiagEditor.GetAsmDescription;
import static main.utils.CamsDiagEditor.camjob01CB;

/**
 *
 * @author MManolas
 */
public class JS_DataEditor_StandAlone extends javax.swing.JFrame {



    
    //Vector model = new Vector();
    /**
     * Creates new form PrevJobs
     */
    public JS_DataEditor_StandAlone() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    /**
     *
     * @return
     */
    public static String NoCamsJCox() {
    String h1="";
    h1=NumberOfCams_String();
    
   
    
    return h1;}
    
    /**
     *
     * @throws IOException
     */
    public void UserDataBackUp01() throws IOException {
        String username = UserInfo.Get_UserName().toLowerCase();
        String folder_user = "";
        String pyFolder = PathWebServer + "//" + mainFolder + "//"
                + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)+"//";
                //+ "//" + PythonFolderMainName() + "//";

         String dirDest = main_path_installation + "\\" + userDataBackUp + "\\" + username + "\\" + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)+"\\"
                 +jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5);


        File srcPy = new File(pyFolder + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5) + ".js");
        
        File destPy = new File(dirDest+"_"+DataBackUpDate()+".js");
        
        //CopyUserData_BackUp(srcJS, destJS);
        CopyUserData_BackUpEditor(srcPy, destPy);
        //SedCamJobUserData();
    }    
    
    private static void CopyUserData_BackUpEditor(File src, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
// buffer size 1K 
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } finally {
            is.close();
            os.close();
        }
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jobselection = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        js_Editor = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:: CamsDiag - "+UserInfo.Get_UserName()+" - "+UserInfo.Get_ComputerName()+" - JS Data Editor ::.");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/main/images/camsdiag01.png")).getImage());

        jButton1.setFont(getFont());
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cross.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(getFont());
        jLabel1.setText("Cams Job Main Page : ");

        try {
            jobselection.setFont(getFont());
            jobselection.setModel(new DefaultComboBoxModel(
                // CheckFile()
                //RemoveDuplicates()
                ReadHTMLfiles()
            )

            //new DefaultComboBoxModel(SortArray_CamJobs())
            /*new DefaultComboBoxModel(CamsDiagJobsLOG_File())
            SortArray_CamJobs()*/);
        CheckFile();
    } catch(Exception e) {}
    jobselection.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jobselectionActionPerformed(evt);
        }
    });

    jLabel2.setFont(getFont());
    jLabel2.setText("Go To : ");

    jLabel3.setFont(getFont());
    try{
        jLabel3.setIcon(main.common.Windows.class.newInstance().WebServer_statusIcon());
        jLabel3.setText(main.common.Windows.Check_WEBServer_Status());
    } catch(Exception e) {}

    jButton2.setFont(getFont());
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/world_link.png"))); // NOI18N
    jButton2.setText("Open");
    jButton2.setEnabled(false);
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    js_Editor.setColumns(20);
    js_Editor.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
    js_Editor.setRows(5);
    js_Editor.addCaretListener(new javax.swing.event.CaretListener() {
        public void caretUpdate(javax.swing.event.CaretEvent evt) {
            js_EditorCaretUpdate(evt);
        }
    });
    jScrollPane1.setViewportView(js_Editor);
    try{
        js_Editor.setText(FileToString.F2String(logpathFull));
    } catch (Exception e) {}

    jLabel4.setFont(getFont());
    jLabel4.setForeground(java.awt.Color.blue);
    jLabel4.setText("http://localhost");
    jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel4MouseClicked(evt);
        }
    });

    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/javascript.png"))); // NOI18N
    jLabel5.setText("Editor ");

    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cancel.png"))); // NOI18N
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    jLabel7.setFont(getFont());
    jLabel7.setText("Number Of Cams:  ");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton2))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jobselection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton4))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jButton4)
                .addComponent(jobselection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jLabel2)
                .addComponent(jButton2)
                .addComponent(jLabel4))
            .addGap(18, 18, 18)
            .addComponent(jLabel3)
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jLabel5)
                .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
            .addContainerGap())
    );

    jButton3.setFont(getFont());
    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/disk.png"))); // NOI18N
    jButton3.setText("Save");
    jButton3.setEnabled(false);
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    jLabel6.setFont(getFont());
    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel6.setText(MnIT_Main.defaultText);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jButton3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton1)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jButton1)
                .addComponent(jButton3)
                .addComponent(jLabel6))
            .addContainerGap())
    );

    setSize(new java.awt.Dimension(628, 547));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       //String h1 = jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length()-4);
       
               try {
            Desktop.getDesktop().browse(new URI(WebServerPath()+jobselection.getSelectedItem().toString()));
        } catch (IOException | URISyntaxException e1) {
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jobselectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobselectionActionPerformed
        String jsFile = PathWebServer + "//" + mainFolder + "//"
                + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)
                + "//"
                + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)+".js";
       
            //String h1=NumberOfCams_String();
            String hh1="";
            
            if (jobselection.getItemCount() != 0) {
            js_Editor.setText("No Jobs Found.");
        } else {
        }
            
            
        try {
            hh1 = FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)
                + "//"+CamsDiag_NofCams);
        } catch (IOException ex) {
            Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jobselection.setEnabled(false);
            jLabel4.setText(WebServerPath() + jobselection.getSelectedItem().toString());
        } catch (IOException ex) {
            Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            js_Editor.setText(FileToString.F2String(jsFile));
            js_Editor.setBackground(new java.awt.Color(204, 255, 204));
            jLabel7.setText("Number Of Cams : "+hh1 );
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jobselectionActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
                      try {
            Desktop.getDesktop().browse(new URI(WebServerPath()+jobselection.getSelectedItem().toString()));
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String jsFile = PathWebServer + "//" + mainFolder + "//"
                    + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)
                    + "//"
                    + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)+".js";
            
            File JS_UserData = new File(jsFile);
            TextArea_to_fileWriter(JS_UserData, js_Editor);
            jLabel6.setText(jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)+".js"+" File Has been Saved.");
            UserDataBackUp01();
            CamsDiag_Create_DescriptionTXT_JSstandalone();
        } catch (IOException ex) {
            Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jobselection.setEnabled(true);
        js_Editor.setText("");
        jLabel4.setText("http://localhost");
        jLabel6.setText(MnIT_Main.defaultText);
        jLabel7.setText("Number Of Cams :  ");
        js_Editor.setBackground(Color.white);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void js_EditorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_js_EditorCaretUpdate
        jLabel6.setText("The File has been modified. Press Save.");
    }//GEN-LAST:event_js_EditorCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String CamsDiagLOG_ReadFile() throws FileNotFoundException, IOException {
        String data = "";
        try {
            File myObj = new File(PathWebServer+"\\"+mainFolder+"\\"+logpath);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    //System.out.println(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return data.trim();
    } 
    
    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String[] CamsDiagJobsLOG_File() throws FileNotFoundException, IOException {
        String line = "";
        String[] data = {""};
        BufferedReader abc = new BufferedReader(new FileReader(PathWebServer+"\\"+mainFolder+"\\"+logpath));
        List<String> lines = new ArrayList<String>();
        while ((line = abc.readLine()) != null) {
            String replace = line.replace(line.substring(0, 23), "");            
            String secpart = "("+line.substring(1, 19)+")";
            //lines.add(replace+" - "+secpart);
            lines.add(replace);
            
            //lines.add(replace1);

            //System.out.println(data);
        }
        abc.close();

        data = lines.toArray(new String[]{});
                
        return data;
    }  
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void CamsDiag_Create_DescriptionTXT_JSstandalone() throws FileNotFoundException, IOException, Exception {
        String jsFile = PathWebServer + "\\" + mainFolder + "\\"
                + jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)
                + "\\"
                + CamsDiag_Desc;

        File statText = new File(jsFile);
        String h2 = "";
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = GetAsmDescriptionJSstandalone()
            // NumberOfCams_String()

            );
            w.close();
        }
    }    
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String GetAsmDescriptionJSstandalone() throws IOException {
    String camdesc="";
    
    camdesc=FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                    //+ jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)
            //+"//"+jobselection.getSelectedItem().toString().substring(0, jobselection.getSelectedItem().toString().length() - 5)
                    + "//"+CamsDiag_Desc);
    return camdesc;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String[] CheckFile() throws IOException {
        
        
        String[] str_array = RemoveDuplicates();
        List<String> list = new ArrayList<String>(Arrays.asList(str_array));
        //list.remove("item2");
        //str_array = list.toArray(new String[0]);

        File f = new File(PathWebServer + "\\" + mainFolder + "\\" + MainInfo.CamJobName()
        //+".html"
        );
        
        for (int i = 0; i < RemoveDuplicates().length; i++) {
                    if (f.exists() == true || f.isDirectory() == true || f.isFile()) {
            str_array = list.toArray(new String[0]);
        } else {
            list.remove(i);
        }
        }
        
        System.out.println("dddd "+str_array);
        
    return str_array;}

    /**
     *
     * @return
     */
    public static String[] ReadHTMLfiles() {
        
        String[] list = null;
        try {
            File tmp = new File(PathWebServer + "\\" + mainFolder );
            FilenameFilter filenameFilter = (file, s) -> s.endsWith(".html") && !s.startsWith("PROD");

            list = tmp.list(filenameFilter);

            if (list != null) {
                Arrays.stream(list)
                        .forEach(System.out::println);
                //.forEach(System.out::println);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    return list;}
    
    /**
     *
     * @return
     */
    public static String[] OnlyHTML_WithoutExtension() {
        
        String[] list = ReadHTMLfiles();

        
    return list;}
    
    
//    model.addElement(new Item(new ImageIcon("copy16.gif"), "copy"));
//    model.addElement(new Item(new ImageIcon("add16.gif"), "add"));
//    model.addElement(new Item(new ImageIcon("about16.gif"), "about"));
//        String[] h1 = RemoveDuplicates();
//        for (int i = 0; i < h1.length; i++) {
//            File f = new File(PathWebServer+"\\"+mainFolder+"\\"+h1[i]
//                    //+".html"
//            );
//            if (f.exists()==true && f.isDirectory()==true && f.isFile()) {
//                //if (f.exists()==true && f.isDirectory()==true && f.isFile()) {
//                //jobselection.setModel(new DefaultComboBoxModel(RemoveDuplicates()));
//               System.out.println("tesdadsadsadsawwt");
//            } else {
//                System.out.println("teswwt");
//                jobselection.removeItemAt(i);
//                //jobselection.remove(i);
//                //jobselection.removeItem(i);
//                //jobselection.setModel(new DefaultComboBoxModel(RemoveDuplicates()));
//            }
//        }

    /**
     *
     * @return
     * @throws IOException
     */
    public static String[] RemoveDuplicates() throws IOException {
        String[] h1 = SortArray_CamJobs();
        LinkedHashSet<String> lhSetColors
                = new LinkedHashSet<String>(Arrays.asList(h1));

        String[] newArray = lhSetColors.toArray(new String[lhSetColors.size()]);
        String h2 = Arrays.toString(newArray);
        return newArray;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String[] SortArray_CamJobs() throws IOException {
        String[] h1 = CamsDiagJobsLOG_File();
        int camjobs_size = h1.length;
        for (int i = 0; i < camjobs_size - 1; i++) {
            for (int j = i + 1; j < h1.length; j++) {
                if (h1[i].compareTo(h1[j])>0) {
                    String temp = h1[i];
                    h1[i] = h1[j];
                    h1[j] = temp;
                }
            }
        }
        String h2 = Arrays.toString(h1);
        //System.out.println(Arrays.toString(h1));
        
        return h1;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String[] SortCams_method1() throws IOException {
        String[] h1 = CamsDiagJobsLOG_File();
        for (String string : h1) {
            System.out.println(string);
        }
        Arrays.sort(h1);
        System.out.println("Sorting string array alphabetically: ");
        for (String str : h1) {
            System.out.println(str);
        }
        return h1;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static String[] SortCamsRevesreOrder_method1() throws IOException {
        String[] h1 = CamsDiagJobsLOG_File();
        for (String string : h1) {
            System.out.println(string);
        }
        // arrays.sort
        Arrays.sort(h1, Collections.reverseOrder());
        System.out.println("Sorting string array in descending or reverse order: ");
        for (String string : h1) {
            System.out.println(string);
        }
        return h1;
    }   
    
    /**
     *
     * @param savePath
     * @param textArea
     */
    public void TextArea_to_fileWriter(File savePath, JTextArea textArea) {
        try {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(savePath))) {
                bf.write(textArea.getText().trim());
                bf.flush();
            }
        } catch (IOException e) {
        }

    }
    
    /**
     *
     */
    public void SaveJS_UserDataFileEditor() {
        try {
            File JS_UserData = new File(PathWebServer+"//"+mainFolder+"//"+
                CamJobName() + "//" + CamJobName() + ".js");
            TextArea_to_fileWriter(JS_UserData, js_Editor);
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JS_DataEditor_StandAlone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JS_DataEditor_StandAlone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JComboBox<String> jobselection;
    private javax.swing.JTextArea js_Editor;
    // End of variables declaration//GEN-END:variables
}
