/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import static main.Echarts.JS_UserData.CamX_Values;
import static main.Echarts.JS_UserData.CamY_Values;
import static main.Echarts.JS_UserData.ShaftDiam;
import main.common.FileToString;
import static main.common.Folders.MainLinkWEB;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.CamsDiag_JobName;
import static main.common.MainVars.CamsDiag_NofCams;
import static main.common.MainVars.dirLocation;
import static main.common.MainVars.sedwin;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class EditCams extends javax.swing.JFrame {


    public static String comments = "/********************************/\n";
    public static String tempFolderName = "TEMP_";
   

    /**
     * Creates new form EditCams
     */
    public EditCams() {
        try {
            initComponents();
            setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
            StartCams();
        } catch (IOException ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] DefaultJobEmpty() {
        String[] list = null;
        return list;
    }

    public static String GetNumberofCams() throws IOException {
        String camsnumber = "";
        camsnumber = FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                + CB01_Job.getSelectedItem().toString()
                + "//" + CamsDiag_NofCams);
        return camsnumber;
    }
    
    public static String GetCamJobName() throws IOException {
    
    String h1="";
    h1 = FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                + CB01_Job.getSelectedItem().toString()
                + "//"+CamsDiag_JobName);
    return h1;}

    public void StartCams() throws IOException {
        jLabel2.setEnabled(false);
        CB01_Job.setEnabled(true);
        CB02_Version.setEnabled(false);
        CB02_Version.setModel(new DefaultComboBoxModel());
        cancelBt02.setEnabled(false);
        jLabel3.setEnabled(false);
        jLabel3.setText("Number of Cams : ");
        tabber.setEnabled(false);
        saveBt.setEnabled(false);
        SaveButtonColorInactive();
        jLabel4.setEnabled(false);
        jLabel4.setText(MainLinkWEB());
        jLabel4.setToolTipText(jLabel4.getText());
        camslider.setEnabled(false);
        camslider.setValue(5);
        jLabel5.setEnabled(false);
        cancelBttab01.setEnabled(false);
        compareTexts.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        textarea.setText("");        
    }

    public void AfterSelection() throws IOException {
        jLabel2.setEnabled(true);
        CB02_Version.setEnabled(true);
        cancelBt02.setEnabled(true);
        jLabel3.setEnabled(true);
        jLabel3.setText("Number of Cams : " + GetNumberofCams());
        tabber.setEnabled(true);
        jLabel4.setEnabled(true);
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setText(MainLinkWEB() + CB01_Job.getSelectedItem().toString() + ".html");
        jLabel4.setToolTipText(jLabel4.getText());
        jLabel4.updateUI();
        textarea.setText(comments+"Numer of Cams : "+GetNumberofCams()+"\n"
        +"Cam Job Name : "+GetCamJobName()+"\n");

    }

    public void SaveButtonColorActive() {
        saveBt.setBackground(Color.green);
        saveBt.setOpaque(true);
        saveBt.setBorderPainted(false);
        saveBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBt.setEnabled(true);

    }

    public void SaveButtonColorInactive() {
        saveBt.setBackground(Color.red);
        saveBt.setOpaque(true);
        saveBt.setBorderPainted(false);
        saveBt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saveBt.setEnabled(false);
    }    
    
        public static String Create_TempCamJobFolder() throws IOException {
        //String dir = PathWebServer+mainFolder+"\\"+CamJobName();
        String h1 = dirLocation+CB01_Job.getSelectedItem().toString()+"\\"+tempFolderName+CB01_Job.getSelectedItem().toString();
        File file = new File(h1);

        // true if the directory was created, false otherwise
        if (file.mkdirs()) {
            System.out.println("Directory is created!"+h1);
        } else {
            System.out.println("Failed to create directory!"+h1);
        }
        return h1;
    }    
    
   public static void Create_JS_MainFile() throws FileNotFoundException, IOException, Exception, FileAlreadyExistsException {
       String fileJStemp =  dirLocation + "//" 
               + CB01_Job.getSelectedItem().toString()+"//"
                + tempFolderName+CB01_Job.getSelectedItem().toString()+"//"
                + CB01_Job.getSelectedItem().toString()+".js";
       
        
        try{
            // Create new file
            String h1 = "", h2 = "";
            String content =  "var AsmName = \"" + CB01_Job.getSelectedItem().toString() + "\";\n";
            String path=fileJStemp;
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(content);
            //bw.close();
            for (int i = 1; i <= camslider.getValue(); i++) {
                h2 = String.valueOf(camslider.getValue());
               bw.write(
                        h1
                        = 
                        
                        "\nvar cam" + i + "label = \"CDMD" + i + "\";\n"
                        + "var cam" + i + "x = " + CamX_Values() + ";\n"
                        + "var cam" + i + "y = " + CamY_Values() + ";\n"
                        + "var cam" + i + "descl = \"CAM Description #" + i + "\";\n"
                        + "var cam" + i + "diameter = " + ShaftDiam() + ";\n"
                );
            }
            bw.write(
                    "\n//Previous File : "
                    + CB02_Version.getSelectedItem().toString() + "\n"
                    + "/*\n"
                    + GetVersionFileText()
                    + "\n*/"
            );
            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }        
        
       
    }         
    
    public static String GetVersionFileJS() {
        String srcJSfile = dirLocation + CB01_Job.getSelectedItem().toString() + "\\" + CB02_Version.getSelectedItem().toString();
        return srcJSfile;
    }

    public static String GetVersionFileText() throws IOException {
        String h1 = "";
        h1 = FileToString.F2String(GetVersionFileJS());
        return h1;
    }
    
    public void CheckCamsFromUSer() throws IOException {
        int k = Integer.parseInt(GetNumberofCams());
        int t = camslider.getValue();
        if (t == k) {
            compareTexts.setText("=");
            compareTexts.setForeground(Color.blue);
            jButton2.setEnabled(false);
            saveBt.setEnabled(false);
            SaveButtonColorInactive();
        } else if (t > k) {
            compareTexts.setText(">");
            compareTexts.setForeground(Color.red);
            SaveButtonColorActive();
        } else if (t < k) {
            compareTexts.setText("<");
            compareTexts.setForeground(Color.red);
            SaveButtonColorActive();
        }
    }

    public static String[] ReadCamsJobsUserBackUp() throws IOException {

        String[] list = null;
        try {
            //File tmp = new File(PathWebServer + "\\" + mainFolder);
            File tmp = new File(dirLocation
            );
            System.out.println(tmp.toString());
            //FilenameFilter filenameFilter = (file, s) -> s.endsWith(".html");

            list = tmp.list();

            if (list != null) {
                Arrays.stream(list)
                        .forEach(System.out::println);
                //.forEach(System.out::println);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String[] ReadCamsJobsUserBackUp_AfterSelection() throws IOException {

        String h1 = "";
        h1 = CB01_Job.getSelectedItem().toString();
        String[] list = null;
        try {
            //File tmp = new File(PathWebServer + "\\" + mainFolder);
            File tmp = new File(dirLocation + h1
            );
            System.out.println(tmp.toString());
            FilenameFilter filenameFilter = (file, s) -> s.endsWith(".js");

            list = tmp.list(filenameFilter);

            if (list != null) {
                Arrays.stream(list)
                        .forEach(System.out::println);
                //.forEach(System.out::println);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String[] ReadCamsJobsNgix() throws IOException {

        String[] list = null;
        try {
            File tmp = new File(PathWebServer + "//" + mainFolder + "//");
            //File tmp = new File(dirLocation
            //);
            System.out.println(tmp.toString());
            //FilenameFilter filenameFilter = (file, s) -> s.endsWith(".html");

            list = tmp.list();

            if (list != null) {
                Arrays.stream(list)
                        .forEach(System.out::println);
                //.forEach(System.out::println);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static HashSet<String> CompareFolders() throws IOException {
        String[] listSrc = null;
        String[] listTrg = null;
        String[] listResult = null;
//
        listSrc = ReadCamsJobsUserBackUp();
        listTrg = ReadCamsJobsNgix();

        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < listSrc.length; i++) {
            for (int j = 0; j < listTrg.length; j++) {
                if (listSrc[i].equals(listTrg[j])) {
                    set.add(listSrc[i]);
                }
            }
        }
        return set;

    }

    public static String[] FinalFolders() throws IOException {
        String[] arr = null;
        arr = CompareFolders().toArray(new String[0]);
        return arr;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CB01_Job = new javax.swing.JComboBox<>();
        cancelBt01 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CB02_Version = new javax.swing.JComboBox<>();
        cancelBt02 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tabber = new javax.swing.JTabbedPane();
        cam_editor = new javax.swing.JPanel();
        camslider = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        cancelBttab01 = new javax.swing.JButton();
        compareTexts = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        saveBt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:: CamsDiag - CamEditor :: "+UserInfo.Get_UserName()+" - "+UserInfo.Get_ComputerName()
            +" ::.");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/main/images/cam01.png")).getImage());

        jLabel1.setFont(getFont());
        jLabel1.setText("Cam Job Name : ");

        CB01_Job.setFont(getFont());
        try{
            CB01_Job.setModel(new DefaultComboBoxModel(FinalFolders()));
        } catch(Exception e) {}
        CB01_Job.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB01_JobActionPerformed(evt);
            }
        });

        cancelBt01.setFont(getFont());
        cancelBt01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cancel.png"))); // NOI18N
        cancelBt01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBt01ActionPerformed(evt);
            }
        });

        jLabel2.setFont(getFont());
        jLabel2.setText("Version File : ");
        jLabel2.setEnabled(false);

        CB02_Version.setFont(getFont());
        try{
            CB02_Version.setModel(new DefaultComboBoxModel(DefaultJobEmpty()));
            CB02_Version.setEnabled(false);
        }catch (Exception e) {}
        CB02_Version.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB02_VersionActionPerformed(evt);
            }
        });

        cancelBt02.setFont(getFont());
        cancelBt02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cancel.png"))); // NOI18N
        cancelBt02.setEnabled(false);
        cancelBt02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBt02ActionPerformed(evt);
            }
        });

        jLabel3.setFont(getFont());
        jLabel3.setText("Number of Cams : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CB01_Job, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB02_Version, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelBt01)
                            .addComponent(cancelBt02, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(CB01_Job, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBt01))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(CB02_Version, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBt02))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cam_editor.setFont(getFont());

        camslider.setFont(getFont());
        camslider.setMajorTickSpacing(1);
        camslider.setMaximum(60);
        camslider.setMinimum(1);
        camslider.setMinorTickSpacing(1);
        camslider.setPaintLabels(true);
        camslider.setPaintTicks(true);
        camslider.setSnapToTicks(true);
        camslider.setValue(5);
        camslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                camsliderStateChanged(evt);
            }
        });

        jLabel5.setFont(getFont());
        jLabel5.setText("NEW Number of Cams : ");

        cancelBttab01.setFont(getFont());
        cancelBttab01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cancel.png"))); // NOI18N
        cancelBttab01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBttab01ActionPerformed(evt);
            }
        });

        compareTexts.setBackground(new java.awt.Color(0, 51, 255));
        compareTexts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        compareTexts.setText("<=>");

        textarea.setEditable(false);
        textarea.setColumns(20);
        textarea.setFont(getFont());
        textarea.setRows(5);
        jScrollPane1.setViewportView(textarea);
        textarea.setCaretPosition(textarea.getDocument().getLength());

        jButton2.setFont(getFont());
        jButton2.setText("Update CAMs");

        jButton3.setText("Clear Text");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cam_editorLayout = new javax.swing.GroupLayout(cam_editor);
        cam_editor.setLayout(cam_editorLayout);
        cam_editorLayout.setHorizontalGroup(
            cam_editorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cam_editorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cam_editorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(camslider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cam_editorLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBttab01))
                    .addGroup(cam_editorLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(compareTexts)))
                .addContainerGap())
        );
        cam_editorLayout.setVerticalGroup(
            cam_editorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cam_editorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(camslider, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cam_editorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(compareTexts)
                    .addComponent(jLabel5)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(cam_editorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton2)
                    .addComponent(cancelBttab01))
                .addContainerGap())
        );

        tabber.addTab("CAM Editor", cam_editor);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        tabber.addTab("tab2", jPanel5);

        saveBt.setFont(getFont());
        saveBt.setText("Generate & Update CAMs Files");
        saveBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabber)
                    .addComponent(saveBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabber)
                .addGap(18, 18, 18)
                .addComponent(saveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setFont(getFont());
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/exit.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(getFont());
        jLabel4.setForeground(java.awt.Color.blue);
        try{
            jLabel4.setText(MainLinkWEB());
            jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch(Exception e) {}

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(848, 655));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CB01_JobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB01_JobActionPerformed
        CB01_Job.setEnabled(false);
        try {
            AfterSelection();
            CB02_Version.setModel(new DefaultComboBoxModel(ReadCamsJobsUserBackUp_AfterSelection()));
        } catch (IOException ex) {
            Logger.getLogger(CamsDiagEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            camslider.setValue(Integer.parseInt(GetNumberofCams()));
        } catch (IOException ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CB01_JobActionPerformed

    private void cancelBt01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBt01ActionPerformed
        try {
            StartCams();
        } catch (IOException ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelBt01ActionPerformed

    private void CB02_VersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB02_VersionActionPerformed
        CB02_Version.setEnabled(false);
        saveBt.setEnabled(true);
        SaveButtonColorActive();
        camslider.setEnabled(true);
        jLabel5.setEnabled(true);
        compareTexts.setEnabled(true);
        cancelBttab01.setEnabled(true);
        textarea.append(comments+"Version File : "+CB02_Version.getSelectedItem().toString()+"\n"+comments);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        try {
            CheckCamsFromUSer();
        } catch (IOException ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            textarea.append(GetVersionFileText()+"\n");
        } catch (IOException ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CB02_VersionActionPerformed

    private void cancelBt02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBt02ActionPerformed
        CB02_Version.setEnabled(true);
        saveBt.setEnabled(false);
        SaveButtonColorInactive();
        camslider.setEnabled(false);
        cancelBttab01.setEnabled(false);
        jLabel5.setEnabled(false);
        compareTexts.setEnabled(false);
        textarea.append("");
        jButton2.setEnabled(false);
    }//GEN-LAST:event_cancelBt02ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void camsliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_camsliderStateChanged
        try {
            String camslider = String.valueOf(this.camslider.getValue());
            jLabel5.setText("NEW Number of Cams : " + camslider);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            CheckCamsFromUSer();
            textarea.append("Number of Cams : " + camslider+"\n"+comments);
            repaint();
        } catch (IOException ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_camsliderStateChanged

    private void cancelBttab01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBttab01ActionPerformed
        try {
            camslider.setValue(Integer.parseInt(GetNumberofCams()));
        } catch (IOException ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel5.setText("NEW Number of Cams : ");
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_cancelBttab01ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        textarea.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void saveBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtActionPerformed
        try {
            Create_TempCamJobFolder();
            //Create_JS_MainFile();
            CheckAndRemoveLines();
        } catch (IOException ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EditCams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtActionPerformed

    public void CheckAndRemoveLines() throws IOException, Exception {
        String jsFile = dirLocation + "\\"
                + CB01_Job.getSelectedItem().toString() + "\\"
                + tempFolderName + CB01_Job.getSelectedItem().toString() + "\\"
                + CB01_Job.getSelectedItem().toString() + ".js";

        int CurrentCams = camslider.getValue();
        int CamsFromJob = Integer.parseInt(GetNumberofCams());
        
        int delLines = 8*CurrentCams;

    File myObj = new File(jsFile); 
    if (myObj.delete()) { 
      System.out.println("Deleted the file: " + myObj.getName());
    } else {
      System.out.println("Failed to delete the file.");
    }        
        
        
        if (CurrentCams < CamsFromJob) {
            try {
                // Create new file
                String h1 = "", h2 = "";
                //String content =  "var AsmName = \"" + CB01_Job.getSelectedItem().toString() + "\";\n";
                String path = jsFile;
                File file = new File(path);

                // If file doesn't exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                // Write in file
                bw.write(
                        
                        GetVersionFileText() + "\n"
                );

                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }            
                        
                    try {
            String line;
            Process p = Runtime.getRuntime().exec(SED_RemoveLastLinesFromText());
            System.out.println("Sed Done : " + SED_RemoveLastLinesFromText());
            BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = bri.readLine()) != null) {
                System.out.println(line);
            }
            bri.close();
            while ((line = bre.readLine()) != null) {
                System.out.println(line);
            }
            bre.close();
            p.waitFor();
            System.out.println("Done.");
            //jLabel21.setText("Done");
            //convertBt.setEnabled(false);
            //ta.append("PDF is Ready!\n");
        } catch (Exception err) {
            err.printStackTrace();
        }
            
                            
//            RandomAccessFile f = new RandomAccessFile(jsFile, "rw");
//            long length = f.length() - 1;
//            byte b;
//            do {
//                length -= delLines;
//                f.seek(length);
//                b = f.readByte();
//            } while (b != 10);
//            f.setLength(length + 1);
//            f.close();                            
//               // DeleteLinesFromTXT(jsFile, GetNumberofLinesFromVersionFile(), k);
//               //ReadLastLinesFromFile(myObj);
            
        } 
        
        else if (CurrentCams > CamsFromJob) {
            try {
                // Create new file
                String h1 = "", h2 = "";
                //String content =  "var AsmName = \"" + CB01_Job.getSelectedItem().toString() + "\";\n";
                String path = jsFile;
                File file = new File(path);

                // If file doesn't exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                // Write in file
                bw.write(GetVersionFileText() + "\n");
                //bw.write(content);
                //bw.close();
                for (int i = CamsFromJob + 1; i <= camslider.getValue(); i++) {
                    h2 = String.valueOf(camslider.getValue());
                    bw.write(
                            h1
                            = "\nvar cam" + i + "label = \"CDMD" + i + "\";\n"
                            + "var cam" + i + "x = " + CamX_Values() + ";\n"
                            + "var cam" + i + "y = " + CamY_Values() + ";\n"
                            + "var cam" + i + "descl = \"CAM Description #" + i + "\";\n"
                            + "var cam" + i + "diameter = " + ShaftDiam() + ";\n"
                    );
                }
                // Close connection
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //DeleteLinesFromTXT(jsFile, 3, 6);
    }
    
        public static String SED_RemoveLastLinesFromText() throws IOException {
        String h1 = "";
        int NumCamsConst=4;
        int CurrentCams = camslider.getValue();
        int CamsFromJob = Integer.parseInt(GetNumberofCams());
        
        int startF=NumCamsConst+(CurrentCams*6);
        
        
        String jsFile = dirLocation + "\\"
                + CB01_Job.getSelectedItem().toString() + "\\"
                + tempFolderName + CB01_Job.getSelectedItem().toString() + "\\"
                + CB01_Job.getSelectedItem().toString() + ".js";        
        h1 = "cmd /c "
                + sedwin+" -i \""+startF+",$d\" "
                //+ sedwin+" -i \"s/^[ \\t]*//;s/[ \\t]*$//\" "
                //%sedpath% -i "s/^[ \t]*//;s/[ \t]*$//" "%tempf%"
                
                + "\""+jsFile+"\""
                + "&& del sed*";
        return h1;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCams().setVisible(true);
            }
        });
    }

    public void DeleteLinesFromTXT(String filename, int startline, int numlines) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            //String buffer to store contents of the file
            StringBuffer sb = new StringBuffer("");

            //Keep track of the line number
            int linenumber = 1;
            String line;

            while ((line = br.readLine()) != null) {
                //Store each valid line in the string buffer
                if (linenumber < startline || linenumber >= startline + numlines) {
                    sb.append(line + "\n");
                }
                linenumber++;
            }
            if (startline + numlines > linenumber) {
                System.out.println("End of file reached.");
            }
            br.close();

            FileWriter fw = new FileWriter(new File(filename));
            //Write entire string buffer into the file
            fw.write(sb.toString());
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went horribly wrong: " + e.getMessage());
        }
    }

    public void ReadLastLinesFromFile(File file) throws Exception {
        //int lines = GetNumberofLinesFromVersionFile();
        int lines = 10;
        int readLines = 0;
        StringBuilder builder = new StringBuilder();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            long fileLength = file.length() - 1;
            // Set the pointer at the last of the file
            randomAccessFile.seek(fileLength);

            for (long pointer = fileLength; pointer >= 0; pointer--) {
                randomAccessFile.seek(pointer);
                char c;
                // read from the last, one char at the time
                c = (char) randomAccessFile.read();
                // break when end of the line
                if (c == '\n') {
                    readLines++;
                    if (readLines == lines)
                        break;
                }
                builder.append(c);
                fileLength = fileLength - pointer;
            }
            // Since line is read from the last so it is in reverse order. Use reverse
            // method to make it correct order
            builder.reverse();
            System.out.println(builder.toString());
        }

    }    
    
    public static int countLines(File aFile) throws IOException {
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(aFile));
            while ((reader.readLine()) != null);
            return reader.getLineNumber();
        } catch (Exception ex) {
            return -1;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
    
    public static int GetNumberofLinesFromVersionFile() throws IOException {
        int k = 1;
        
        String jsFile = dirLocation + "\\"
                + CB01_Job.getSelectedItem().toString() + "\\"
                //+ tempFolderName + CB01_Job.getSelectedItem().toString() + "\\"
                + CB01_Job.getSelectedItem().toString() + ".js";
        
        File file = new File(jsFile);
        k =countLines(file);
        boolean fileExists = file.exists();
        return k;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> CB01_Job;
    public static javax.swing.JComboBox<String> CB02_Version;
    private javax.swing.JPanel cam_editor;
    public static javax.swing.JSlider camslider;
    private javax.swing.JButton cancelBt01;
    private javax.swing.JButton cancelBt02;
    private javax.swing.JButton cancelBttab01;
    private javax.swing.JLabel compareTexts;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveBt;
    private javax.swing.JTabbedPane tabber;
    private javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables
}
