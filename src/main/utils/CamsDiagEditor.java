/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import static main.Echarts.JS_UserData.CamX_Values;
import static main.Echarts.JS_UserData.CamY_Values;
import static main.Echarts.JS_UserData.ShaftDiam;
import main.common.FileToString;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.mainFolder;
import static main.common.MainVars.CamsDiag_Desc;
import static main.common.MainVars.CamsDiag_NofCams;
import static main.common.MainVars.dirLocation;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class CamsDiagEditor extends javax.swing.JFrame {



    /**
     * Creates new form CamsDiagEditor
     */
    public CamsDiagEditor() {
        initComponents();
        StartUpFunctions();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

    }

    /**
     *
     */
    public void StartUpFunctions() {
        camjob02CB.setVisible(false);
        cancelBt02.setVisible(false);
        jLabel2.setVisible(false);
        camjob02CB.setEnabled(false);
        try {
            camjob02CB.setModel(new DefaultComboBoxModel(DefaultJobEmpty()));
        } catch (Exception e) {
        }
        cancelBt02.setEnabled(false);
        jLabel2.setEnabled(false);
        jSeparator1.setVisible(false);
        jCheckBox1.setVisible(false);
        jobNumberofCams.setVisible(false);
        camSlider.setVisible(false);
        jLabel4.setVisible(false);
        jLabel3.setVisible(false);
        editorArea.setVisible(false);
        jScrollPane1.setVisible(false);

        saveBtCams.setVisible(false);
        jButton2.setVisible(false);
    }

    /**
     *
     */
    public void StartUpFunctionsAfter() {
        camjob02CB.setVisible(true);
        cancelBt02.setVisible(true);
        jLabel2.setVisible(true);
        camjob02CB.setEnabled(true);

        cancelBt02.setEnabled(true);
        jLabel2.setEnabled(true);
        jSeparator1.setVisible(true);
        jCheckBox1.setVisible(true);
        jobNumberofCams.setVisible(true);

        jLabel3.setVisible(true);
        editorArea.setVisible(true);
        jScrollPane1.setVisible(true);

        jButton2.setVisible(true);
        jButton2.setEnabled(false);
    }

    /**
     *
     * @return
     */
    public static String[] DefaultJobEmpty() {
        String[] list = null;
        return list;
    }

    /**
     *
     * @throws IOException
     */
    public void EditCamsNumber() throws IOException {
        if (jCheckBox1.isSelected()) {
            camSlider.setVisible(true);
            camSlider.setValue(NofCams());
            jLabel4.setVisible(true);
            editorArea.setEnabled(true);
            saveBtCams.setVisible(true);
            saveBtCams.setEnabled(true);
            jButton2.setEnabled(false);
            jButton2.setVisible(true);
        } else {
            camSlider.setVisible(false);
            jLabel4.setVisible(false);
            editorArea.setEnabled(false);
            saveBtCams.setVisible(false);
            jButton2.setEnabled(true);
            jButton2.setVisible(true);

        }
    }

    /**
     *
     * @return
     * @throws IOException
     */
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

    /**
     *
     * @return
     * @throws IOException
     */
    public static String[] FinalFolders() throws IOException {
        String[] arr = null;
        arr = CompareFolders().toArray(new String[0]);
        return arr;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static Integer NofCams() throws IOException {
        int k = 0;
        String camsnumber = "";

        camsnumber = FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                + camjob01CB.getSelectedItem().toString()
                + "//" + CamsDiag_NofCams);

        k = Integer.parseInt(camsnumber);

        return k;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static String GetAsmDescription() throws IOException {
    String camdesc="";
    
    camdesc=FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                    + camjob01CB.getSelectedItem().toString()
                    + "//"+CamsDiag_Desc);
    return camdesc;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public static String NofCamsSlider() throws IOException {
        int k = 0;
        String camslider = String.valueOf(camSlider.getValue());

        return camslider;
    }
    
    /**
     *
     * @return
     */
    public static Integer NofCamsSliderINT() {
    int k=0;
    k=camSlider.getValue();
    return k;}

    /**
     *
     * @return
     * @throws IOException
     */
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

    /**
     *
     * @return
     * @throws IOException
     */
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

    /**
     *
     * @return
     * @throws IOException
     */
    public static String[] ReadCamsJobsUserBackUp_AfterSelection() throws IOException {

        String h1 = "";
        h1 = camjob01CB.getSelectedItem().toString();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        camjob01CB = new javax.swing.JComboBox<>();
        cancelBt01 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        camjob02CB = new javax.swing.JComboBox<>();
        cancelBt02 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jobNumberofCams = new javax.swing.JLabel();
        camSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        saveBtCams = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:: CamsDiag - CamEditor :: "+UserInfo.Get_UserName()+" - "+UserInfo.Get_ComputerName()
            +" ::.");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/main/images/camsdiag01.png")).getImage());

        camjob01CB.setFont(getFont());
        try{
            camjob01CB.setModel(new DefaultComboBoxModel(
                //ReadCamsJobsUserBackUp()
                //CompareFolders()
                FinalFolders()
            )
        );
    } catch(Exception e) {}
    camjob01CB.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            camjob01CBActionPerformed(evt);
        }
    });

    cancelBt01.setFont(getFont());
    cancelBt01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cancel.png"))); // NOI18N
    cancelBt01.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelBt01ActionPerformed(evt);
        }
    });

    jLabel1.setFont(getFont());
    jLabel1.setText("Select CAMs Job Name : ");

    camjob02CB.setFont(getFont());
    camjob02CB.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            camjob02CBActionPerformed(evt);
        }
    });

    cancelBt02.setFont(getFont());
    cancelBt02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cancel.png"))); // NOI18N
    cancelBt02.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelBt02ActionPerformed(evt);
        }
    });

    jLabel2.setFont(getFont());
    jLabel2.setText("Select Version : ");

    jCheckBox1.setFont(getFont());
    jCheckBox1.setText("Edit Number of Cams");
    try{
        EditCamsNumber();
    } catch(Exception e) {}
    jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBox1ActionPerformed(evt);
        }
    });

    jobNumberofCams.setFont(getFont());
    jobNumberofCams.setText("Number of Cams : ");

    camSlider.setFont(getFont());
    camSlider.setMajorTickSpacing(1);
    camSlider.setMaximum(60);
    camSlider.setMinimum(1);
    camSlider.setMinorTickSpacing(1);
    camSlider.setPaintLabels(true);
    camSlider.setPaintTicks(true);
    camSlider.setSnapToTicks(true);
    camSlider.setValue(5);
    camSlider.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            camSliderStateChanged(evt);
        }
    });

    jLabel4.setFont(getFont());
    jLabel4.setText("NEW Number of Cams : ");

    saveBtCams.setFont(getFont());
    saveBtCams.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/tick.png"))); // NOI18N
    saveBtCams.setText("Save");
    saveBtCams.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            saveBtCamsActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(saveBtCams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(camSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(camjob01CB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(camjob02CB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cancelBt01)
                        .addComponent(cancelBt02)))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jobNumberofCams, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jLabel1)
                .addComponent(camjob01CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cancelBt01))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(cancelBt02)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(camjob02CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
            .addGap(17, 17, 17)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jobNumberofCams)
                .addComponent(jCheckBox1))
            .addGap(18, 18, 18)
            .addComponent(camSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel4)
            .addGap(18, 18, 18)
            .addComponent(saveBtCams, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
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

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1)
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1)
            .addContainerGap())
    );

    editorArea.setColumns(20);
    editorArea.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
    editorArea.setRows(5);
    jScrollPane1.setViewportView(editorArea);

    jLabel3.setFont(getFont());
    jLabel3.setForeground(java.awt.Color.blue);
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("http://localhost");

    jButton2.setFont(getFont());
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/javascript.png"))); // NOI18N
    jButton2.setText("JS Editor(Latest Save)");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jButton3.setFont(getFont());
    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cancel.png"))); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jButton3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton2)
                .addComponent(jButton3))
            .addGap(18, 18, 18)
            .addComponent(jLabel3)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    setSize(new java.awt.Dimension(855, 694));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBt02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBt02ActionPerformed
        StartUpFunctions();
        camjob01CB.setEnabled(true);
    }//GEN-LAST:event_cancelBt02ActionPerformed

    private void camjob01CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camjob01CBActionPerformed
        String camsnumber = "";
        camjob01CB.setEnabled(false);
        StartUpFunctionsAfter();
        try {
            camjob02CB.setModel(new DefaultComboBoxModel(ReadCamsJobsUserBackUp_AfterSelection()));
        } catch (IOException ex) {
            Logger.getLogger(CamsDiagEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            camsnumber = FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                    + camjob01CB.getSelectedItem().toString()
                    + "//" + CamsDiag_NofCams);
        } catch (IOException ex) {
            Logger.getLogger(CamsDiagEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        jobNumberofCams.setText("Number of Cams : " + camsnumber);
    }//GEN-LAST:event_camjob01CBActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        try {
            EditCamsNumber();
        } catch (IOException ex) {
            Logger.getLogger(CamsDiagEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void camjob02CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camjob02CBActionPerformed
        camjob02CB.setEnabled(false);

        String targetJSfile = PathWebServer + "\\" + mainFolder + "\\"
                + camjob01CB.getSelectedItem().toString() + "\\"
                + camjob01CB.getSelectedItem().toString() + ".js";
        String srcJSfile = dirLocation + camjob01CB.getSelectedItem().toString() + "\\" + camjob02CB.getSelectedItem().toString();

        System.out.println(srcJSfile);
        try {
            editorArea.setText(FileToString.F2String(srcJSfile));
        } catch (IOException ex) {
            Logger.getLogger(CamsDiagEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            EditCamsNumber();
        } catch (IOException ex) {
            Logger.getLogger(CamsDiagEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

        jButton2.setEnabled(true);
    }//GEN-LAST:event_camjob02CBActionPerformed

    private void camSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_camSliderStateChanged
        String camslider = String.valueOf(camSlider.getValue());
        jLabel4.setText("NEW Number of Cams : " + camslider);
        repaint();
    }//GEN-LAST:event_camSliderStateChanged

    private void cancelBt01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBt01ActionPerformed
        StartUpFunctions();
        camjob01CB.setEnabled(true);
    }//GEN-LAST:event_cancelBt01ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JS_DataEditor_StandAlone bs = new JS_DataEditor_StandAlone();
        bs.setVisible(true);
        requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveBtCamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtCamsActionPerformed
        try {
            CamsDiag_Create_NofCamsTXT_Editor();
            JS_UserDataFile_Editor();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_saveBtCamsActionPerformed

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void CamsDiag_Create_NofCamsTXT_Editor() throws FileNotFoundException, IOException, Exception {
        File statText = new File(
                PathWebServer + "\\"
                + mainFolder + "\\"
                + CamsDiag_NofCams);
        String h2 = "";

        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {
            w.write(
                    h2 = String.valueOf(NofCamsSlider())
            //NumberOfCams_String()
            );
            w.close();
        }

        File statText1 = new File(PathWebServer + "\\" + mainFolder + "\\"
                + camjob01CB.getSelectedItem().toString() + "\\" + CamsDiag_NofCams);
        String h21 = "";
        FileOutputStream is1 = new FileOutputStream(statText1);
        OutputStreamWriter osw1 = new OutputStreamWriter(is1, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw1)) {
            w.write(
                    h21 = String.valueOf(NofCamsSlider())
            // NumberOfCams_String()

            );
            w.close();
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public static void JS_UserDataFile_Editor() throws FileNotFoundException, IOException, Exception {
        File statText = new File(PathWebServer+"//"+mainFolder+"//"+
                camjob01CB.getSelectedItem().toString() + "//" + camjob01CB.getSelectedItem().toString() + ".js");
        
        FileOutputStream is = new FileOutputStream(statText);
        OutputStreamWriter osw = new OutputStreamWriter(is, StandardCharsets.UTF_8);
        try (Writer w = new BufferedWriter(osw)) {

            w.write(
                    //UserInfo.Header_Comments() 
                    //"/*///////////////////////////////////////////*/\n"
                    "var AsmName = \"" + camjob01CB.getSelectedItem().toString() + "\";\n"
                    + "var AsmDescription = \"" + GetAsmDescription() + "\";\n"
                    + "\n"
                    //+ CheckMachineMotionCamArray()
            //+ "\n"
                    //+ "/*///////////////////////////////////////////*/\n"
                    //+ "// Cam Job Name : " + CamJobName() + "\n"
                    //+ "// Number OF Cams : " + NumberOfCams() + "\n"
                    //+ "var CamsDiag_JobName = \"" + CamJobName() + "\";\n"
                    //+ "var CamsDiag_NofCams = " + NumberOfCams() + ";\n"
            );
            String h1 = "", h2 = "";
            for (int NumberOfCams = 1; NumberOfCams <= NofCamsSliderINT(); NumberOfCams++) {
                h2 = String.valueOf(NofCamsSliderINT());
                w.write(
                        h1
                        = 
                                //"/*///////////////////////////////////////////*/\n"
                        "\nvar cam" + NumberOfCams + "label = \"CDMD" + NumberOfCams + "\";\n"
                        + "var cam" + NumberOfCams + "x = " + CamX_Values() + ";\n"
                        + "var cam" + NumberOfCams + "y = " + CamY_Values() + ";\n"
                        + "var cam" + NumberOfCams + "descl = \"CAM Description #" + NumberOfCams + "\";\n"
                        + "var cam" + NumberOfCams + "diameter = " + ShaftDiam() + ";\n"
                );
            }
            w.write("\n"
                    //"/*///////////////////////////////////////////*/\n"
                    //+ UserInfo.Header_Comments() 
            );
            w.close();
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
            java.util.logging.Logger.getLogger(CamsDiagEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CamsDiagEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CamsDiagEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CamsDiagEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CamsDiagEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JSlider camSlider;
    public static javax.swing.JComboBox<String> camjob01CB;
    private javax.swing.JComboBox<String> camjob02CB;
    private javax.swing.JButton cancelBt01;
    private javax.swing.JButton cancelBt02;
    private javax.swing.JTextArea editorArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jobNumberofCams;
    private javax.swing.JButton saveBtCams;
    // End of variables declaration//GEN-END:variables
}
