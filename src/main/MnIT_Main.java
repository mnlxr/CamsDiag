/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.dnd.DropTarget;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.rmi.server.LogStream.log;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.text.Document;
import main.CamReqs.MainInfo;
import static main.CamReqs.MainInfo.CamJobName;
import static main.CamReqs.MainInfo.WebServerPath;
import static main.Echarts.Create_TXTs.CamsDiag_Create_CamJobNameTXT;
import static main.Echarts.Create_TXTs.CamsDiag_Create_CamJobNameTXT_General;
import static main.Echarts.Create_TXTs.CamsDiag_Create_DescriptionTXT;
import static main.Echarts.Create_TXTs.CamsDiag_Create_DescriptionTXT_General;
import static main.Echarts.Create_TXTs.CamsDiag_Create_NofCamsTXT;
import static main.Echarts.Create_TXTs.CamsDiag_Create_NofCamsTXT_General;
import static main.Echarts.HTML_functions.CamsDiag_index_HTML;
import static main.Echarts.HTML_productionView.CamsDiag_index_HTML_View;
import static main.Echarts.JS_CamAll.CamParametersChartALL;
import static main.Echarts.JS_CommonApp.CommonVars;
import static main.Echarts.JS_DatGui.DatGUI;
import static main.Echarts.JS_Functions.CamsDiag_JS_FunctionsEveryChart;
import static main.Echarts.JS_MachineMotionText.Check_CBox_MarkArea_Option;
import static main.Echarts.JS_MachineMotionText.Check_CBox_Vars_Option;
import static main.Echarts.JS_MachineMotionText.MachineCamAll;
import static main.Echarts.JS_Parameters.CamParametersChart;
import static main.Echarts.JS_Polar.Polar_Rth;
import static main.Echarts.JS_PopTable.JS_PopTable;
import static main.Echarts.JS_ReadProps.JS_PropertiesFile;
import static main.Echarts.JS_StackBarHorizontal.StBar_Ph;
import static main.Echarts.JS_UserData.JS_UserDataFile;
import static main.Echarts.JS_globmnit.GlobMnit;
import static main.Echarts.Js_ImagesCanvas.CamsDiag_ImagesCanvas;
import static main.common.AsciiARTs.ASCII_Art01;
import static main.common.CamsDiag_JOptions.ClearBackUpFolder;
import static main.common.CamsDiag_JOptions.DeleteCamsJobs;
import main.common.FileToString;
import main.common.Folders;
import static main.common.Folders.CheckIfCamsFolderExist;
import static main.common.Folders.CreateUserBackForlder;
import static main.common.Folders.CreateUserCamsFolder;
import static main.common.Folders.Create_CamJobFolder;
import static main.common.Folders.Create_Camsolder;
import static main.common.Folders.Create_Python_CamJobFolder;
import static main.common.Folders.PathWebServer;
import static main.common.Folders.ZipuserPath;
import static main.common.Folders.mainFolder;
import static main.common.Folders.userbackup;
import static main.common.MainVars.CamsDiag_JobName;
import static main.common.MainVars.CamsDiag_NofCams;
import static main.common.MainVars.logpath;
import static main.common.MainVars.logpathFull;
import static main.common.MainVars.timeStamp;
import static main.common.MainVars.userDataBackUp;
import static main.common.MnIT_checkForUpdates.CheckForUpdates;
import main.common.Windows;
import static main.common.Windows.CheckInternetConnection;
import static main.common.Windows.Check_WEBServer_Status;
import static main.common.Windows.EraseLast_Job;
import static main.common.Windows.UserDataBackUp;
import main.info.UserInfo;
import static main.common.Windows.WebServer_LastJob;
import static main.common.Windows.ZipDate;
import main.pdfs.PDFs;
import main.pdfs.PDFsTexts;
import static main.pros.SystemProps.CamsDiag_HelpPath;
import static main.pros.SystemProps.CamsDiag_WebURL;
import main.tests.Main;
import static main.utils.Zip.zipFolder;
import main.utils.AboutBC_Cams;
import main.utils.JS_DataEditor_Embedded;
import main.utils.JS_DataEditor_StandAlone;
import main.utils.StatusCam;
/**
 *
 * @author MManolas
 */
public class MnIT_Main extends javax.swing.JFrame {

    /**
     *
     */
    public String camslider = "";
    private final int maxNumberOfCharacters = 30;
    int currentLetter = 1;
    Graphics g;

    /**
     *
     */
    public static String defaultText="-";

    Document documentjs;
    Document documentpy;
    
    Container contner = getContentPane();
    
     DropTarget dt;
     
    
     
         // create a frameInit
    static JFrame f;
    static JProgressBar b;
    static JDialog d;

    /**
     *
     */
    public static JFrame frameInit;
     //JLabel image=new JLabel(new javax.swing.ImageIcon(getClass().getResource("/main/images/camsdiag01.png")));

    /**
     *
     */
    public static JLabel image=new JLabel(new ImageIcon("camsdiag01.png"));
    //javax.swing.ImageIcon(getClass().getResource("/main/images/camsdiag01.png"))

    /**
     *
     */
    public static JLabel text=new JLabel("Cams Diagrams - Charts");

    /**
     *
     */
    public static JProgressBar progressBar=new JProgressBar();

    /**
     *
     */
    public static  JLabel message=new JLabel();
     
    /**
     * Creates new form MnIT_Main
     */
    public MnIT_Main() {
        //this.documentjs = data_edit.getDocument();
        //this.documentpy = py_data_edit.getDocument();
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        machineMotionCB.setVisible(true);
        machineCBVisibility();
        try {
           // tabs.remove(4);
            tabs.remove(5);
            tabs.remove(6);
           // dt = new DropTarget(datadrop, (DropTargetListener) this);
        } catch (Exception e) {
        }
         CheckForUpdates();
    }

    /**
     *
     */
    public  void machineCBVisibility() {
        if (machineMotionCB.isVisible()) {
            
            CBox_Visibility();
        } else {
            
            CBox_Visibility();
        }
    }
    
    /**
     *
     */
    public void CBox_Visibility() {
        if (machineMotionCB.isSelected() == true) {
            CB_motion.setVisible(true);
            CB_motion.setEnabled(true);
        } else {
            CB_motion.setVisible(false);
            CB_motion.setEnabled(false);
        }
    }
    
    /**
     *
     * @return
     */
    public String CBox_getName() {
        String h1 = "";
        h1 = CB_motion.getSelectedItem().toString();
        return h1;
    }
    
    /**
     *
     * @return
     */
    public Integer CBox_getIndex(){
    Integer t = 0;
    t = CB_motion.getSelectedIndex();
    return t;
    }
    
    /**
     *
     */
    public static void SplashScreen()
    {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }

    /**
     *
     */
    public static void createGUI(){
        frameInit=new JFrame();
        frameInit.getContentPane().setLayout(null);
        frameInit.setUndecorated(true);
        frameInit.setSize(600,400);
        frameInit.setLocationRelativeTo(null);
        frameInit.getContentPane().setBackground(Color.white);
        frameInit.setVisible(true);

    }

    /**
     *
     */
    public static void addImage(){
        image.setSize(600,225);
        //image.setSize(225,225);
        //600,200
        frameInit.add(image);
    }

    /**
     *
     */
    public static void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,20));
        text.setBounds(170,220,600,40);
        text.setForeground(Color.BLUE);
        frameInit.add(text);
    }

    /**
     *
     */
    public static void addMessage()
    {
        message.setBounds(250,320,200,40);
        message.setForeground(Color.black);
        message.setFont(new Font("arial",Font.BOLD,11));
        frameInit.add(message);
    }

    /**
     *
     */
    public static void  addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        frameInit.add(progressBar);
    }

    /**
     *
     */
    public static void runningPBar(){
        int i=0;

        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("Loading  "+Integer.toString(i)+"%");
                i++;
                if(i==100)
                    frameInit.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }



        }
    } 
    
    /**
     *
     */
    public static void fillProgresBar() {
        int i = 0;
        try {
            while (i <= 100) {
                // fill the menu bar
                b.setValue(i + 10);

                // delay the thread
                Thread.sleep(1000);
                i += 20;
            }
        } catch (Exception e) {
        }
    }
    
    /**
     *
     */
    public static void InitProressBar() {
        {
 
        // create a frameInit
        f = new JFrame("CamsDiag");
 
        d = new JDialog();
        
        // create a panel
        JPanel p = new JPanel();
 
        // create a progressbar
        b = new JProgressBar();
 
        // set initial value
        b.setValue(0);
 
        b.setStringPainted(true);
 
        // add progressbar
        p.add(b);
 
        // add panel
        //f.add(p);
        d.add(p);
 
        // set the size of the frameInit
        //f.setSize(500, 500);
        //f.setVisible(true);
        d.setSize(150, 250);
        d.setVisible(true);
 
        fillProgresBar();
        //System.exit(0);
    }
    }
    
    /**
     *
     */
    public static void PBarDialog() {
    
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public String Get_NumberOFCams_FroSlider() throws IOException {

        try {
            camslider = String.valueOf(cam_numbers_slider.getValue());
        } catch (Exception e) {
        }
        return camslider;
    }

    /**
     *
     * @throws IOException
     */
    public void GetInfo_FromUserInput() throws IOException {
        //int x = Integer.parseInt(cam_numbers_slider.getValue());
        DisplayInfo_01.setText(GetInfo_01.getText().trim().toLowerCase()
                .replaceAll("[^a-zA-Z0-9]", "_")
        );
        DisplayInfo_02.setText(GetInfo_02.getText());
        DisplayInfo_03.setText(Get_NumberOFCams_FroSlider());

        cam_numbers_slider.repaint();
    }    
    
    /**
     *
     */
    public void OkButtonCheckText() {
        if (GetInfo_01.getText().isEmpty() == true && DisplayInfo_02.getText().isEmpty()
                /*&& GetInfo_02.getText().isEmpty() == true*/) {
            oKbutton.setEnabled(false);
            SaveButtonColorInactive();
        } else if(GetInfo_01.getText().contains(defaultText)){
            oKbutton.setEnabled(false);
            SaveButtonColorInactive();
        }
        else {oKbutton.setEnabled(true);
        SaveButtonColorActive();}
    }
    
    /**
     *
     */
    public void OkButton_Actions() {
        GetInfo_01.setEnabled(false);
        GetInfo_01.setBackground(new java.awt.Color(255, 255, 128));
        GetInfo_02.setEnabled(false);
        GetInfo_02.setBackground(new java.awt.Color(255, 255, 128));
        cam_numbers_slider.setEnabled(false);
        cams_get.setEnabled(false);
        DisplayInfo_01.setEnabled(false);
        DisplayInfo_02.setEnabled(false);
        DisplayInfo_03.setEnabled(false);
        machineMotionCB.setEnabled(false);
        CB_motion.setEnabled(false);
    }
    
    /**
     *
     * @throws IOException
     * @throws Exception
     */
    public void OkButton_Triggers() throws IOException, Exception {
        //StopNGINX_CMD();          
        Create_CamJobFolder();
        Create_Camsolder();
         CheckIfCamsFolderExist();
        Create_Python_CamJobFolder();
        CreateUserBackForlder();
        CamsDiag_Create_CamJobNameTXT();
        CamsDiag_Create_CamJobNameTXT_General();
        CamsDiag_Create_NofCamsTXT();
        CamsDiag_Create_NofCamsTXT_General();
        CamsDiag_Create_DescriptionTXT();
        CamsDiag_Create_DescriptionTXT_General();
        JS_PropertiesFile();
        JS_UserDataFile();
        //DB_Main();
        
        //CopyUserData_BackUp(File src, File dest);
        //NGINX.StartNGINX_CMD();
        CommonVars();
        JS_PopTable();
        CamParametersChart();
        CamParametersChartALL();
        DatGUI();
        GlobMnit();
        
        Polar_Rth();
        StBar_Ph();
        CamsDiag_ImagesCanvas();
        CamsDiag_JS_FunctionsEveryChart();
        CamsDiag_index_HTML();
        CamsDiag_index_HTML_View();
//        Py_UserDataFile();
//        PyHiddenVars();
//        CamParametersPy();
//        CamParametersPy_Arbortext();
        //UserDataBackUp();
        Create_MainLOG();
        Create_LOG_Full();

    }
    
    /**
     *
     * @throws URISyntaxException
     */
    public void OkButton_AfterGenerate() throws URISyntaxException {
        try {
            weblabel.setText("<html><a href=''>"+WebServer_LastJob()+"</a></html>");
        } catch (URISyntaxException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
//            data_text.setText(FileToString.F2String(PathWebServer+"//"+mainFolder+"//"+
//                    CamJobName() + "//" + CamJobName() + ".js"));
            




            data_edit.setEditable(true);
            data_edit.setText(FileToString.F2String(PathWebServer+"//"+mainFolder+"//"+
                    CamJobName() + "//" + CamJobName() + ".js"));
            data_edit.setBackground(new java.awt.Color(212, 251, 194));
            tabs.setSelectedIndex(1);
            
        CheckDataTextAreaEmpty();
        CheckDataTextAreaDefaultText();
            
        data_text.append("\n"+LogFullStr());
        
        
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @throws URISyntaxException
     * @throws IOException
     */
    public void CancelButton_Actions() throws URISyntaxException, IOException {
        GetInfo_01.setEnabled(true);
        GetInfo_01.setText(defaultText);
        GetInfo_01.setBackground(java.awt.SystemColor.activeCaption);
        GetInfo_02.setEnabled(true);
        GetInfo_02.setText(defaultText);
        GetInfo_02.setBackground(java.awt.SystemColor.activeCaption);
        
        cam_numbers_slider.setEnabled(true);
        cam_numbers_slider.setValue(5);
        
        cams_get.setEnabled(true);
        
        DisplayInfo_01.setEnabled(true);
        DisplayInfo_01.setText(defaultText);
        DisplayInfo_02.setEnabled(true);
        DisplayInfo_02.setText(defaultText);
        DisplayInfo_03.setEnabled(true);
        DisplayInfo_03.setText(defaultText);
        
        //data_text.setText(defaultText);
        weblabel.setText(WebServerPath());
        

        
        CheckDataTextAreaEmpty();
        CheckDataTextAreaDefaultText();
        
        data_edit.setText("");

        data_edit.setEnabled(false);

        
        machineMotionCB.setEnabled(true);
        machineMotionCB.setSelected(false);
        CBox_Visibility();
        
        
    }    
    
    /**
     *
     * @throws IOException
     */
    public void Create_MainLOG() throws IOException {
        File file = new File(PathWebServer+"\\"+mainFolder+"\\"+logpath);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(
                "[" + timeStamp + "] : " + GetInfo_01.getText().trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "_") + "\n"
        );
        br.close();
        fr.close();
    }    
    
    /**
     *
     */
    public void SaveButtonColorActive() {
        oKbutton.setBackground(Color.green);
        oKbutton.setOpaque(true);
        oKbutton.setBorderPainted(false);
        oKbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oKbutton.setEnabled(true);

    }

    /**
     *
     */
    public void SaveButtonColorInactive() {
        oKbutton.setBackground(Color.red);
        oKbutton.setOpaque(true);
        oKbutton.setBorderPainted(false);
        oKbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        oKbutton.setEnabled(false);
    }    
    
    /**
     *
     */
    public void SaveJSButtonColorActive() {
        saveJS_Button.setBackground(Color.green);
        saveJS_Button.setOpaque(true);
        saveJS_Button.setBorderPainted(false);
        saveJS_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveJS_Button.setEnabled(true);

    }

    /**
     *
     */
    public void SaveJSButtonColorInactive() {
        saveJS_Button.setBackground(Color.red);
        saveJS_Button.setOpaque(true);
        saveJS_Button.setBorderPainted(false);
        saveJS_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saveJS_Button.setEnabled(false);
    }    
    
    /**
     *
     */
    public void CheckOkButtonStatus() {
        if (oKbutton.isEnabled() == true) {
            SaveButtonColorActive();
        } else {
            SaveButtonColorInactive();
        }
    }
    
    /**
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public void Create_LOG_Full() throws IOException, URISyntaxException {
        String spaces = "                        ";
        File file = new File(PathWebServer+"\\"+mainFolder+"\\"+logpathFull);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(LogFullStr()
        );

        br.close();
        fr.close();
    }
    
    /**
     *
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public  String LogFullStr() throws IOException, URISyntaxException {
    String h1="";
    //"<html><a href=''>"+WebServer_LastJob()+"</a></html>"
    String spaces = "                        ";
    h1=spaces + "********************************************************************************\n"
                + "[" + timeStamp + "] : " + GetInfo_01.getText()+ "\n"
                + spaces + "Number of Cams : " + DisplayInfo_02.getText() + "\n"
                + spaces + "Description : " + DisplayInfo_03.getText() + "\n"
                + spaces + "User Name : " + UserInfo.Get_UserName() + "\n"
                + spaces + "Computer Name : " + UserInfo.Get_ComputerName() + "\n"
                + spaces + "Web Server Status: " +Check_WEBServer_Status() + "\n"
                + spaces + CheckInternetConnection() + "\n"
                + spaces + "Main HTML : " + MainInfo.CamJobName() + ".html\n"
                + spaces + "Web Path : " + WebServerPath() + MainInfo.CamJobName() + ".html\n"
                + spaces + "Python Path : " + WebServerPath() + MainInfo.CamJobName() + "/" + Folders.PythonFolderMainName() + "\n";
    return h1;}
    
    /**
     *
     * @return
     * @throws Exception
     */
    public  String LibsIncludedChkBoxString() throws Exception {
String h1="";
    if (libs_included.isSelected() == true) {
        h1 = "Libs Included";
        jLabel17.setText(h1);
    } else {
        h1 = "Libs NOT Included";
        jLabel17.setText(h1);
    }

return h1;
} 


    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        machineMotionCB = new javax.swing.JCheckBox();
        CB_motion = new javax.swing.JComboBox<>();
        initWindow = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        pbar = new javax.swing.JProgressBar();
        upper_panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        basic_panel = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        main = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GetInfo_01 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cam_numbers_slider = new javax.swing.JSlider();
        cams_get = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GetInfo_02 = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        oKbutton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        data_text = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        webjob = new javax.swing.JLabel();
        js_data = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        data_edit = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        saveJS_Button = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        backUp = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        zip_data = new javax.swing.JTextArea();
        openZipDir = new javax.swing.JButton();
        zipButton = new javax.swing.JButton();
        libs_included = new javax.swing.JCheckBox();
        load_prev = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        loadjob = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        editjobs = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        editjobcb = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        editsaveJS_Button = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        editjobtextarea = new javax.swing.JTextArea();
        info_panel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DisplayInfo_01 = new javax.swing.JLabel();
        DisplayInfo_02 = new javax.swing.JLabel();
        DisplayInfo_03 = new javax.swing.JLabel();
        exit_panel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        toolbar = new javax.swing.JToolBar();
        jLabel23 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        weblabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jLabel18 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel19 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        menubar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        tabsMenu = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        machineMotionCB.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        machineMotionCB.setText("Machine Motion/Dwell Area");
        machineMotionCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                machineMotionCBActionPerformed(evt);
            }
        });

        CB_motion.setFont(getFont());
        CB_motion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Dwell & 2 Motion", "2 Dwell & 1 Motion" }));
        CB_motion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_motionActionPerformed(evt);
            }
        });

        initWindow.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        initWindow.setModal(true);
        initWindow.setUndecorated(true);
        initWindow.setResizable(false);

        pbar.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pbar, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pbar, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout initWindowLayout = new javax.swing.GroupLayout(initWindow.getContentPane());
        initWindow.getContentPane().setLayout(initWindowLayout);
        initWindowLayout.setHorizontalGroup(
            initWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        initWindowLayout.setVerticalGroup(
            initWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, initWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:: CamsDiag - "+UserInfo.Get_UserName()+" - "+UserInfo.Get_ComputerName()
            +" ::.");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/main/images/camsdiag01.png")).getImage());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/info.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(getFont());
        jLabel1.setText(".:: CamsDiag - "+UserInfo.Get_UserName()+" ::.");

        javax.swing.GroupLayout upper_panelLayout = new javax.swing.GroupLayout(upper_panel);
        upper_panel.setLayout(upper_panelLayout);
        upper_panelLayout.setHorizontalGroup(
            upper_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, upper_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        upper_panelLayout.setVerticalGroup(
            upper_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upper_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(upper_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addGap(4, 4, 4))
        );

        main.setFont(getFont());

        jLabel2.setFont(getFont());
        jLabel2.setText("CAMs Job Name : ");

        GetInfo_01.setBackground(java.awt.SystemColor.activeCaption);
        GetInfo_01.setFont(getFont());
        GetInfo_01.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                GetInfo_01CaretUpdate(evt);
            }
        });
        GetInfo_01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GetInfo_01KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GetInfo_01KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(GetInfo_01);

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("* No Special Characters and Spaces are Allowed (/.#?! etc.)");

        jLabel5.setFont(getFont());
        jLabel5.setText("Number of Cams : ");

        cam_numbers_slider.setFont(getFont());
        cam_numbers_slider.setMajorTickSpacing(1);
        cam_numbers_slider.setMaximum(60);
        cam_numbers_slider.setMinimum(1);
        cam_numbers_slider.setMinorTickSpacing(1);
        cam_numbers_slider.setPaintLabels(true);
        cam_numbers_slider.setPaintTicks(true);
        cam_numbers_slider.setSnapToTicks(true);
        cam_numbers_slider.setValue(4);
        cam_numbers_slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cam_numbers_sliderStateChanged(evt);
            }
        });

        cams_get.setFont(getFont());
        try {
            cams_get.setText(Get_NumberOFCams_FroSlider());
            cams_get.setToolTipText(Get_NumberOFCams_FroSlider() );
        } catch (Exception e) {}

        jLabel6.setFont(getFont());
        jLabel6.setText("Description : ");

        GetInfo_02.setBackground(java.awt.SystemColor.activeCaption);
        GetInfo_02.setFont(getFont());
        GetInfo_02.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GetInfo_02KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GetInfo_02KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(GetInfo_02);

        jLabel7.setForeground(jLabel3.getForeground());
        jLabel7.setText("*");

        oKbutton.setFont(getFont());
        oKbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/accept.png"))); // NOI18N
        oKbutton.setText("Ok");
        oKbutton.setEnabled(false);
        oKbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oKbuttonActionPerformed(evt);
            }
        });

        data_text.setEditable(false);
        data_text.setColumns(20);
        data_text.setFont(getFont());
        data_text.setRows(5);
        try {
            data_text.setText(ASCII_Art01());
        } catch(Exception e) {}
        jScrollPane3.setViewportView(data_text);

        cancelButton.setFont(getFont());
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/12-em-cross.png"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        webjob.setFont(getFont());
        webjob.setForeground(java.awt.Color.blue);
        webjob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        try {
            webjob.setText("-");
            webjob.setToolTipText(webjob.getText());
            webjob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        } catch (Exception e) {}
        webjob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webjobMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                webjobMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                webjobMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                webjobMousePressed(evt);
            }
        });

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webjob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(cam_numbers_slider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cams_get))
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(oKbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cam_numbers_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cams_get))
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(webjob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oKbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabs.addTab("Main", new javax.swing.ImageIcon(getClass().getResource("/main/images/house.png")), main); // NOI18N

        data_edit.setEditable(false);
        data_edit.setBackground(new java.awt.Color(204, 255, 204));
        data_edit.setColumns(20);
        data_edit.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        data_edit.setRows(5);
        data_edit.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                data_editCaretUpdate(evt);
            }
        });
        data_edit.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                data_editPropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(data_edit);

        jLabel13.setFont(getFont());
        jLabel13.setForeground(webjob.getForeground());
        jLabel13.setText(webjob.getText());
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        saveJS_Button.setFont(getFont());
        saveJS_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/disk.png"))); // NOI18N
        saveJS_Button.setText("Save JS File");
        saveJS_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJS_ButtonActionPerformed(evt);
            }
        });

        jButton5.setFont(getFont());
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/world_link.png"))); // NOI18N
        jButton5.setText("Open");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel15.setFont(getFont());
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText(defaultText);

        javax.swing.GroupLayout js_dataLayout = new javax.swing.GroupLayout(js_data);
        js_data.setLayout(js_dataLayout);
        js_dataLayout.setHorizontalGroup(
            js_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(js_dataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(js_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(js_dataLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(saveJS_Button))
                    .addGroup(js_dataLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        js_dataLayout.setVerticalGroup(
            js_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(js_dataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(js_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton5)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(js_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(saveJS_Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabs.addTab("Data", new javax.swing.ImageIcon(getClass().getResource("/main/images/javascript.png")), js_data); // NOI18N

        backUp.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(getFont());
        jLabel16.setText("BackUp User Data : "+UserInfo.Get_UserName());

        jLabel17.setFont(getFont());
        jLabel17.setText("Create ZIP File");

        zip_data.setEditable(false);
        zip_data.setBackground(new java.awt.Color(211, 227, 255));
        zip_data.setColumns(20);
        zip_data.setFont(data_edit.getFont());
        zip_data.setRows(5);
        jScrollPane6.setViewportView(zip_data);

        openZipDir.setFont(getFont());
        openZipDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/attach.png"))); // NOI18N
        openZipDir.setText("Open ZIP Dir");
        openZipDir.setEnabled(false);
        openZipDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openZipDirActionPerformed(evt);
            }
        });

        zipButton.setFont(getFont());
        zipButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/package.gif"))); // NOI18N
        zipButton.setText("ZIP");
        zipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipButtonActionPerformed(evt);
            }
        });

        libs_included.setFont(getFont());
        libs_included.setText("Libs Included");
        libs_included.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libs_includedActionPerformed(evt);
            }
        });
        libs_included.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                libs_includedPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout backUpLayout = new javax.swing.GroupLayout(backUp);
        backUp.setLayout(backUpLayout);
        backUpLayout.setHorizontalGroup(
            backUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backUpLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(openZipDir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backUpLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(libs_included)
                        .addGap(18, 18, 18)
                        .addComponent(zipButton)))
                .addContainerGap())
        );
        backUpLayout.setVerticalGroup(
            backUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(backUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(zipButton)
                    .addComponent(libs_included))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(openZipDir)
                .addContainerGap())
        );

        tabs.addTab("Back Up", new javax.swing.ImageIcon(getClass().getResource("/main/images/mimeico_zip.gif")), backUp); // NOI18N

        load_prev.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(getFont());
        jLabel20.setText("Select Job Main Page : ");

        loadjob.setFont(getFont());
        try{
            loadjob.setModel(new DefaultComboBoxModel(ReadHTMLfilesMain()));
        } catch(Exception e) {}
        loadjob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadjobActionPerformed(evt);
            }
        });

        jButton10.setFont(getFont());
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/world_link.png"))); // NOI18N
        jButton10.setText("Open");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel24.setFont(getFont());
        jLabel24.setForeground(java.awt.Color.blue);
        jLabel24.setText("http://localhost");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jLabel25.setFont(getFont());
        jLabel25.setText("Number of Cams :  ");

        jLabel26.setFont(getFont());
        jLabel26.setText("Cams Job Name : ");

        jButton3.setFont(getFont());
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cross.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel27.setFont(getFont());
        jLabel27.setText("Total Jobs : ");

        javax.swing.GroupLayout load_prevLayout = new javax.swing.GroupLayout(load_prev);
        load_prev.setLayout(load_prevLayout);
        load_prevLayout.setHorizontalGroup(
            load_prevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(load_prevLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(load_prevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(load_prevLayout.createSequentialGroup()
                        .addGroup(load_prevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)
                            .addGroup(load_prevLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(loadjob, 0, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton10))
                    .addGroup(load_prevLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        load_prevLayout.setVerticalGroup(
            load_prevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(load_prevLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(load_prevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(loadjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10)
                    .addComponent(jLabel20)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("View Previous Job", new javax.swing.ImageIcon(getClass().getResource("/main/images/date.png")), load_prev); // NOI18N

        editjobs.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(getFont());
        jLabel21.setText(jLabel20.getText());

        editjobcb.setFont(getFont());
        editjobcb.setModel(loadjob.getModel());
        editjobcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editjobcbActionPerformed(evt);
            }
        });

        jButton4.setFont(getFont());
        jButton4.setIcon(jButton10.getIcon());
        jButton4.setText(jButton10.getText());
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(getFont());
        jButton6.setIcon(jButton3.getIcon());
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel28.setFont(getFont());
        jLabel28.setForeground(java.awt.Color.blue);
        jLabel28.setText("http://localhost");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        jLabel31.setFont(getFont());
        jLabel31.setText("Cams Job Name : ");

        jLabel30.setFont(getFont());
        jLabel30.setText("Number of Cams :  ");

        jLabel29.setFont(getFont());
        jLabel29.setText("Total Jobs : ");

        jLabel22.setFont(getFont());
        jLabel22.setText("-");

        editsaveJS_Button.setFont(getFont());
        editsaveJS_Button.setIcon(saveJS_Button.getIcon());
        editsaveJS_Button.setText(saveJS_Button.getText());
        editsaveJS_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editsaveJS_ButtonActionPerformed(evt);
            }
        });

        editjobtextarea.setBackground(data_edit.getBackground());
        editjobtextarea.setColumns(20);
        editjobtextarea.setFont(data_edit.getFont());
        editjobtextarea.setRows(5);
        editjobtextarea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                editjobtextareaCaretUpdate(evt);
            }
        });
        editjobtextarea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                editjobtextareaPropertyChange(evt);
            }
        });
        jScrollPane5.setViewportView(editjobtextarea);

        javax.swing.GroupLayout editjobsLayout = new javax.swing.GroupLayout(editjobs);
        editjobs.setLayout(editjobsLayout);
        editjobsLayout.setHorizontalGroup(
            editjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editjobsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(editjobsLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(editjobcb, 0, 533, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(editjobsLayout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editjobsLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(editsaveJS_Button))
                    .addGroup(editjobsLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        editjobsLayout.setVerticalGroup(
            editjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editjobsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(editjobcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(editjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(editjobsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel22)
                    .addComponent(editsaveJS_Button))
                .addContainerGap())
        );

        tabs.addTab("Edit Jobs", new javax.swing.ImageIcon(getClass().getResource("/main/images/wrench.png")), editjobs); // NOI18N

        javax.swing.GroupLayout basic_panelLayout = new javax.swing.GroupLayout(basic_panel);
        basic_panel.setLayout(basic_panelLayout);
        basic_panelLayout.setHorizontalGroup(
            basic_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basic_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        basic_panelLayout.setVerticalGroup(
            basic_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basic_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );

        jLabel9.setFont(getFont());
        jLabel9.setText("Cams Job Name : ");

        jLabel10.setFont(getFont());
        jLabel10.setText("Asm Description : ");

        jLabel11.setFont(getFont());
        jLabel11.setText("Number of Cams :  ");

        DisplayInfo_01.setFont(getFont());
        DisplayInfo_01.setText(defaultText);

        DisplayInfo_02.setFont(getFont());
        DisplayInfo_02.setText(defaultText);

        DisplayInfo_03.setFont(getFont());
        DisplayInfo_03.setText(defaultText);

        javax.swing.GroupLayout info_panelLayout = new javax.swing.GroupLayout(info_panel);
        info_panel.setLayout(info_panelLayout);
        info_panelLayout.setHorizontalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DisplayInfo_01, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(DisplayInfo_02, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(DisplayInfo_03, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap())
        );
        info_panelLayout.setVerticalGroup(
            info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(info_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(DisplayInfo_01))
                .addGap(18, 18, 18)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(DisplayInfo_02))
                .addGap(18, 18, 18)
                .addGroup(info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(DisplayInfo_03))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setFont(getFont());
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/exit.png"))); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(getFont());
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("-");

        javax.swing.GroupLayout exit_panelLayout = new javax.swing.GroupLayout(exit_panel);
        exit_panel.setLayout(exit_panelLayout);
        exit_panelLayout.setHorizontalGroup(
            exit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exit_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        exit_panelLayout.setVerticalGroup(
            exit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exit_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(exit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.CENTER))
                .addGap(11, 11, 11))
        );

        toolbar.setRollover(true);

        try {
            jLabel23.setFont(toolbar.getFont());
            jLabel23.setIcon(main.common.Windows.class.newInstance().InternetConnectionStatusIcon());
            jLabel23.setText(CheckInternetConnection());
        } catch (Exception e) {}
        toolbar.add(jLabel23);
        toolbar.add(jSeparator7);

        try{
            jLabel12.setFont(toolbar.getFont());
            jLabel12.setIcon(main.common.Windows.class.newInstance().WebServer_statusIcon());
            jLabel12.setText(Windows.Check_WEBServer_Status());
            jLabel12.setToolTipText(jLabel12.getText());
        } catch (Exception e) {}
        toolbar.add(jLabel12);
        toolbar.add(jSeparator2);

        weblabel.setFont(toolbar.getFont());
        weblabel.setForeground(java.awt.Color.blue);
        weblabel.setText(defaultText);
        weblabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        weblabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                weblabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                weblabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                weblabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                weblabelMousePressed(evt);
            }
        });
        weblabel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                weblabelPropertyChange(evt);
            }
        });
        toolbar.add(weblabel);
        toolbar.add(jSeparator3);

        jLabel14.setFont(toolbar.getFont());
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/user.png"))); // NOI18N
        jLabel14.setText("User Name : "+UserInfo.Get_UserName());
        toolbar.add(jLabel14);
        toolbar.add(jSeparator4);

        jLabel18.setFont(toolbar.getFont());
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/layout.png"))); // NOI18N
        jLabel18.setText("Computer Name : "+UserInfo.Get_ComputerName());
        toolbar.add(jLabel18);
        toolbar.add(jSeparator5);

        jLabel19.setFont(toolbar.getFont());
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/java.png"))); // NOI18N
        jLabel19.setText("Java : "+UserInfo.Get_JavaVersion());
        toolbar.add(jLabel19);
        toolbar.add(jSeparator6);

        fileMenu.setText("File");

        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/folder.png"))); // NOI18N
        jMenuItem21.setText("ZIP BackUp");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem21);

        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/folder.png"))); // NOI18N
        jMenuItem22.setText("Data BackUp");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem22);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/world_link.png"))); // NOI18N
        jMenuItem5.setText("WEB Download");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem5);
        fileMenu.add(jSeparator1);

        jMenuItem4.setIcon(jButton2.getIcon());
        jMenuItem4.setText(jButton2.getText());
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem4);

        menubar.add(fileMenu);

        toolsMenu.setText("Tools");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/javascript.png"))); // NOI18N
        jMenuItem6.setText("JS Data Editor Prev Emb");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        toolsMenu.add(jMenuItem6);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/application.png"))); // NOI18N
        jMenuItem1.setText("Status");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        toolsMenu.add(jMenuItem1);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/mimeico_zip.gif"))); // NOI18N
        jMenu6.setText("BackUp");

        jMenuItem11.setIcon(zipButton.getIcon());
        jMenuItem11.setText("Create BackUp ZIP");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuItem10.setIcon(openZipDir.getIcon());
        jMenuItem10.setText(openZipDir.getText());
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        toolsMenu.add(jMenu6);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/bullet_red.png"))); // NOI18N
        jMenu5.setText("Clear");

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/edit-clear.png"))); // NOI18N
        jMenuItem13.setText("Empty BackUpDirectory");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cross.png"))); // NOI18N
        jMenuItem14.setText("Delete Jobs");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        toolsMenu.add(jMenu5);

        menubar.add(toolsMenu);

        editMenu.setText("Ext Tools");
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/javascript.png"))); // NOI18N
        jMenuItem16.setText("JS Data Editor");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem16);
        editMenu.add(jSeparator8);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/pdf.png"))); // NOI18N
        jMenuItem18.setText("PDF Image Creator");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem18);

        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/pdf_1.png"))); // NOI18N
        jMenuItem20.setText("PDF Text Creator");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem20);

        menubar.add(editMenu);

        tabsMenu.setText("Tabs");

        jMenuItem7.setIcon(tabs.getIconAt(0));
        jMenuItem7.setText("Main");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        tabsMenu.add(jMenuItem7);

        jMenuItem8.setIcon(tabs.getIconAt(1));
        jMenuItem8.setText("JS Data");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        tabsMenu.add(jMenuItem8);

        jMenuItem12.setIcon(tabs.getIconAt(3));
        jMenuItem12.setText("Back Up");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        tabsMenu.add(jMenuItem12);

        jMenuItem19.setIcon(tabs.getIconAt(3));
        jMenuItem19.setText("View Prev Job");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        tabsMenu.add(jMenuItem19);

        jMenuItem9.setIcon(tabs.getIconAt(4));
        jMenuItem9.setText("Edit Jobs");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        tabsMenu.add(jMenuItem9);

        menubar.add(tabsMenu);

        aboutMenu.setText("About");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/help.png"))); // NOI18N
        jMenuItem2.setText("Help");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        aboutMenu.add(jMenuItem2);

        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/application.png"))); // NOI18N
        jMenuItem23.setText("Check for Updates");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        aboutMenu.add(jMenuItem23);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/details.gif"))); // NOI18N
        jMenuItem3.setText("About");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        aboutMenu.add(jMenuItem3);

        menubar.add(aboutMenu);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(upper_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(basic_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exit_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(info_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upper_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(basic_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(info_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exit_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(884, 821));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cam_numbers_sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cam_numbers_sliderStateChanged
        camslider = String.valueOf(cam_numbers_slider.getValue());
        cams_get.setText(camslider);
        DisplayInfo_02.setText(camslider);
        repaint();
    }//GEN-LAST:event_cam_numbers_sliderStateChanged

    private void GetInfo_02KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GetInfo_02KeyReleased
        try {
            DisplayInfo_03.setText(GetInfo_02.getText());
            if (DisplayInfo_03.getText().length() == maxNumberOfCharacters + 20) {
                evt.consume();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_GetInfo_02KeyReleased

    private void GetInfo_02KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GetInfo_02KeyTyped
        GetInfo_02KeyReleased(evt);
    }//GEN-LAST:event_GetInfo_02KeyTyped

    private void GetInfo_01KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GetInfo_01KeyTyped
        try {
            DisplayInfo_01.setText(GetInfo_01.getText().trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "_"));
            if (DisplayInfo_01.getText().length() == maxNumberOfCharacters) {
                evt.consume();
            }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_GetInfo_01KeyTyped

    private void GetInfo_01KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GetInfo_01KeyReleased
        GetInfo_01KeyTyped(evt);
    }//GEN-LAST:event_GetInfo_01KeyReleased

    private void oKbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oKbuttonActionPerformed
        try {
            
            OkButton_Actions();
            OkButton_Triggers();
            OkButton_AfterGenerate();
            oKbutton.setEnabled(false);
            data_edit.setEnabled(true);
          
        } catch (Exception ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_oKbuttonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        try {
            CancelButton_Actions();
            oKbutton.setEnabled(true);
            SaveButtonColorActive();
            //EraseLastLOGEntry();
            EraseLast_Job();
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void webjobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webjobMouseClicked
        try {
            Desktop.getDesktop().browse(new URI(WebServer_LastJob()+".html"));
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_webjobMouseClicked

    private void webjobMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webjobMouseExited
                 try {
            webjob.setText(WebServer_LastJob()+".html");
            weblabel.setText(WebServer_LastJob()+".html");
            jLabel13.setText(WebServer_LastJob()+".html");
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_webjobMouseExited

    private void webjobMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webjobMouseEntered
        webjobMouseExited(evt);
    }//GEN-LAST:event_webjobMouseEntered

    private void webjobMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webjobMousePressed
        webjobMouseEntered(evt);
    }//GEN-LAST:event_webjobMousePressed

    private void weblabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_weblabelMouseClicked
        try {
            Desktop.getDesktop().browse(new URI(WebServer_LastJob()+".html"));
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_weblabelMouseClicked

    private void weblabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_weblabelMouseEntered
        weblabelMouseExited(evt);
    }//GEN-LAST:event_weblabelMouseEntered

    private void weblabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_weblabelMouseExited
                 try {
            webjob.setText(WebServer_LastJob()+".html");
            weblabel.setText(WebServer_LastJob()+".html");
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_weblabelMouseExited

    private void weblabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_weblabelMousePressed
        weblabelMouseExited(evt);
    }//GEN-LAST:event_weblabelMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                       AboutBC_Cams bs = new AboutBC_Cams(this, true);
        bs.setVisible(true);
        requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        StatusCam bs = new StatusCam(this, true);
        bs.setVisible(true);
        requestFocus();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        jButton2ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //JobsPrev bs = new JobsPrev(this, true);
        JS_DataEditor_Embedded bs = new JS_DataEditor_Embedded();
        bs.setVisible(true);
        requestFocus();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        webjobMouseClicked(evt);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        webjobMouseEntered(evt);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        webjobMouseExited(evt);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        webjobMousePressed(evt);
    }//GEN-LAST:event_jLabel13MousePressed

    private void GetInfo_01CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_GetInfo_01CaretUpdate
      OkButtonCheckText();
    }//GEN-LAST:event_GetInfo_01CaretUpdate

    private void libs_includedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libs_includedActionPerformed
        try {
            LibsIncludedChkBoxString();
        } catch (Exception ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_libs_includedActionPerformed

    private void zipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipButtonActionPerformed
        try {
            String filename = userbackup+"\\"+mainFolder+"_"+ZipDate()+".zip";
            
            openZipDir.setEnabled(false);
            zip_data.setText("Please Wait...\n");
            zip_data.append("*********************************\n");
            zipFolder(PathWebServer+ZipuserPath, filename);
            //zip_data.setText("Please Wait...\n");
            jLabel17.setText("ZIP is Ready");
            zip_data.append("ZIP is Ready\n");
            zip_data.append("File Name : "+filename.substring(11,filename.length())+"\n");
            zip_data.append("Path : "+"C:\\Data\\CamsDiag\\UserBackUp\\"+ZipuserPath+"\n");
            Path path = Paths.get(filename);
            long bytes = Files.size(path);
            String filesize = String.format("%d kilobytes", bytes/1024);
            zip_data.append("Size : "+filesize+"\n");
            zip_data.append("*********************************\n");
            String[] pathnames;
            File f = new File("UserBackUp\\");
            FilenameFilter filter = new FilenameFilter() {
        @Override
        public boolean accept(File f, String name) {
            return name.endsWith(".zip");
        }
    };
            
            pathnames = f.list(filter);
            zip_data.append("Total BackUp ZIP Files : "+f.listFiles(filter).length+"\n");
            zip_data.append("BackUp Files : \n");
            for (String pathname : pathnames) 
            {zip_data.append(pathname+"\n");}
            openZipDir.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_zipButtonActionPerformed

    private void libs_includedPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_libs_includedPropertyChange
        try {
            LibsIncludedChkBoxString();
        } catch (Exception ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_libs_includedPropertyChange

    private void openZipDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openZipDirActionPerformed
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File(userbackup);
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openZipDirActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        tabs.setSelectedIndex(0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        tabs.setSelectedIndex(1);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        tabs.setSelectedIndex(2);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        tabs.setSelectedIndex(3);
        //szipButtonActionPerformed(evt);
        
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        tabs.setSelectedIndex(2);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        switch (ClearBackUpFolder()) {
            case 0:
                Windows.DeleteDirectory(new File(userbackup));
                CreateUserBackForlder();
            case 1:
                //creoversions.setEnabled(true);
                //jLabel1.setText("No Change");
                break;
            case 2:
                //creoversions.setEnabled(true);
                //jLabel1.setText("Canceled by the User");
                break;
            default:
                break;
        }


    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
                switch (DeleteCamsJobs()) {
            case 0:
                    {
                        Windows.DeleteDirectory(new File(PathWebServer+mainFolder));
                        CreateUserCamsFolder();
                    }


                //CreateUserBackForlder();
            case 1:
                //creoversions.setEnabled(true);
                //jLabel1.setText("No Change");
                break;
            case 2:
                //creoversions.setEnabled(true);
                //jLabel1.setText("Canceled by the User");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Desktop.getDesktop().browse(new URI(WebServer_LastJob()+".html"));
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void data_editPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_data_editPropertyChange
CheckDataTextAreaEmpty();
        
    }//GEN-LAST:event_data_editPropertyChange

    private void data_editCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_data_editCaretUpdate
       
        jLabel15.setText("The File has been modified. Press Save.");
    }//GEN-LAST:event_data_editCaretUpdate

    private void weblabelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_weblabelPropertyChange
                 try {
            webjob.setText(WebServer_LastJob()+".html");
            weblabel.setText(WebServer_LastJob()+".html");
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_weblabelPropertyChange

    private void saveJS_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJS_ButtonActionPerformed
        SaveJS_UserDataFile();
        jLabel15.setText("File Has been Saved.");
    }//GEN-LAST:event_saveJS_ButtonActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        JS_DataEditor_StandAlone bs = new JS_DataEditor_StandAlone();
        bs.setVisible(true);
        requestFocus();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
                              try {
            Desktop.getDesktop().browse(new URI(WebServerPath()+loadjob.getSelectedItem().toString()));
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_jLabel24MouseClicked

    private void loadjobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadjobActionPerformed
       loadjob.setEnabled(false);
       String camsnumber="";
       String camjobname="";
        try {
            camsnumber = FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                    + loadjob.getSelectedItem().toString().substring(0, loadjob.getSelectedItem().toString().length() - 5)
                    + "//"+CamsDiag_NofCams);
            camjobname=FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                    + loadjob.getSelectedItem().toString().substring(0, loadjob.getSelectedItem().toString().length() - 5)
                    + "//"+CamsDiag_JobName);
            
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel26.setText("Cams Job Name :  "+camjobname);
        jLabel25.setText("Number of Cams :  "+camsnumber);
        try {
            jLabel24.setText(WebServerPath() + loadjob.getSelectedItem().toString());
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButton10.setEnabled(true);
        jLabel27.setText("Total Jobs : "+loadjob.getItemCount());
    }//GEN-LAST:event_loadjobActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadjob.setEnabled(true);
        jLabel24.setText("http://localhost");
        jLabel25.setText("Number of Cams : ");
        jLabel26.setText("Cams Job Name : ");
        jLabel27.setText("Total Jobs : ");
        jButton10.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                              try {
            Desktop.getDesktop().browse(new URI(WebServerPath()+loadjob.getSelectedItem().toString()));
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed

    }//GEN-LAST:event_editMenuActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
               try {
            Desktop.getDesktop().browse(new URI(CamsDiag_HelpPath()));
            System.out.println(CamsDiag_HelpPath());
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
//        try {
//            Desktop.getDesktop().browse(new URI(CamsDiag_WebURL()));
//        } catch (IOException | URISyntaxException e1) {
//        }
		Desktop desktop = java.awt.Desktop.getDesktop();
		try {
			//specify the protocol along with the URL
			URI oURL = new URI(
					CamsDiag_WebURL());
			desktop.browse(oURL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
               PDFs bs = new PDFs();
        bs.setVisible(true);
        requestFocus();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
               PDFsTexts bs = new PDFsTexts();
        bs.setVisible(true);
        requestFocus();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
         tabs.setSelectedIndex(3);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File(userbackup);
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File(userDataBackUp+"\\"+UserInfo.Get_UserName());
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed

CheckForUpdates();
//        Runtime run = Runtime.getRuntime();
//        String cmdjar="java -jar";
//        String updatejar="C:\\Data\\CamsDiag\\MnIT_CamsDiag_Update.jar";
//        String runjar = cmdjar+" "+updatejar;
//        
//        ProcessBuilder builder = new ProcessBuilder(
//            //"cmd.exe", "/c", "cd \"C:\\Program Files\\Microsoft SQL Server\" && dir"
//                "cmd.exe", "/c", cmdjar+" "+updatejar
//        );
//        builder.redirectErrorStream(true);
//        Process p = null;
//        try {
//            p = builder.start();
//        } catch (IOException ex) {
//            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String line = null;
//        while (true) {
//            try {
//                line = r.readLine();
//            } catch (IOException ex) {
//                Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (line == null) { break; }
//            System.out.println(line);
//        }        
        
//        try {
//            ProcessBuilder pb = new ProcessBuilder(runjar);
//
//            Process p = pb.start();
//            InputStream is = p.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//            String resultOutput = br.toString();
//            System.out.println(resultOutput);
//        } catch (Exception E) {
//            E.printStackTrace();
//            System.out.println(E.getMessage());
//        }
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void machineMotionCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_machineMotionCBActionPerformed
       CBox_Visibility();
    }//GEN-LAST:event_machineMotionCBActionPerformed

    private void CB_motionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_motionActionPerformed
        CB_motion.setEnabled(false);
    }//GEN-LAST:event_CB_motionActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
                                     try {
            Desktop.getDesktop().browse(new URI(WebServerPath()+editjobcb.getSelectedItem().toString()));
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        editjobcb.setEnabled(true);
        jLabel28.setText("http://localhost");
        jLabel30.setText("Number of Cams : ");
        jLabel31.setText("Cams Job Name : ");
        jLabel29.setText("Total Jobs : ");
        jButton10.setEnabled(false);
        editjobtextarea.setEditable(false);
        editjobtextarea.setText("");
        editsaveJS_Button.setEnabled(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                              try {
            Desktop.getDesktop().browse(new URI(WebServerPath()+editjobcb.getSelectedItem().toString()));
        } catch (IOException | URISyntaxException e1) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void editsaveJS_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsaveJS_ButtonActionPerformed
       SaveJS_EditUserDataFile();
        jLabel22.setText("File Has been Saved.");
    }//GEN-LAST:event_editsaveJS_ButtonActionPerformed

    private void editjobtextareaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editjobtextareaCaretUpdate
       jLabel22.setText("The File has been modified. Press Save.");
    }//GEN-LAST:event_editjobtextareaCaretUpdate

    private void editjobtextareaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_editjobtextareaPropertyChange
        // CheckDataEditTextAreaEmpty();
    }//GEN-LAST:event_editjobtextareaPropertyChange

    private void editjobcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editjobcbActionPerformed
               editjobcb.setEnabled(false);
               
       String camsnumber="";
       String camjobname="";
        try {
            camsnumber = FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                    + editjobcb.getSelectedItem().toString().substring(0, editjobcb.getSelectedItem().toString().length() - 5)
                    + "//"+CamsDiag_NofCams);
            camjobname=FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                    + editjobcb.getSelectedItem().toString().substring(0, editjobcb.getSelectedItem().toString().length() - 5)
                    + "//"+CamsDiag_JobName);
            
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel31.setText("Cams Job Name :  "+camjobname);
        jLabel30.setText("Number of Cams :  "+camsnumber);
        try {
            jLabel28.setText(WebServerPath() + editjobcb.getSelectedItem().toString());
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButton6.setEnabled(true);
        jLabel29.setText("Total Jobs : "+editjobcb.getItemCount());
        
        
            editjobtextarea.setEditable(true);
        try {
            editjobtextarea.setText(FileToString.F2String(PathWebServer+"//"+mainFolder+"//"+
                    camjobname + "//" + camjobname + ".js"));
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            editjobtextarea.setBackground(new java.awt.Color(212, 251, 194));        
        editsaveJS_Button.setEnabled(true);
    }//GEN-LAST:event_editjobcbActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
      tabs.setSelectedIndex(4);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //machineMotionCB.setVisible(false);
       SplashScreen(); 

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
            java.util.logging.Logger.getLogger(MnIT_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MnIT_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> CB_motion;
    public static javax.swing.JLabel DisplayInfo_01;
    public static javax.swing.JLabel DisplayInfo_02;
    public static javax.swing.JLabel DisplayInfo_03;
    private javax.swing.JTextPane GetInfo_01;
    private javax.swing.JTextPane GetInfo_02;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JPanel backUp;
    private javax.swing.JPanel basic_panel;
    private javax.swing.JSlider cam_numbers_slider;
    private javax.swing.JLabel cams_get;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea data_edit;
    private javax.swing.JTextArea data_text;
    private javax.swing.JMenu editMenu;
    private javax.swing.JComboBox<String> editjobcb;
    private javax.swing.JPanel editjobs;
    private javax.swing.JTextArea editjobtextarea;
    private javax.swing.JButton editsaveJS_Button;
    private javax.swing.JPanel exit_panel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel info_panel;
    public static javax.swing.JDialog initWindow;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPanel js_data;
    public static javax.swing.JCheckBox libs_included;
    private javax.swing.JPanel load_prev;
    private javax.swing.JComboBox<String> loadjob;
    public static javax.swing.JCheckBox machineMotionCB;
    private javax.swing.JPanel main;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JButton oKbutton;
    private javax.swing.JButton openZipDir;
    private javax.swing.JProgressBar pbar;
    private javax.swing.JButton saveJS_Button;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JMenu tabsMenu;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JPanel upper_panel;
    private javax.swing.JLabel webjob;
    private javax.swing.JLabel weblabel;
    private javax.swing.JButton zipButton;
    private javax.swing.JTextArea zip_data;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void SaveJS_EditUserDataFile() {
        try { 
           //UserDataBackUp();
            
           String camjobname = "";
           String editcamjobname = editjobcb.getSelectedItem().toString().substring(0, editjobcb.getSelectedItem().toString().length() - 5);
           
            camjobname=FileToString.F2String(PathWebServer + "//" + mainFolder + "//"
                    + editcamjobname+ "//"+editcamjobname+".js");           
           
            File JS_UserData01 = new File(PathWebServer+"//"+mainFolder+"//"+
                editcamjobname + "//" + editcamjobname + ".js");
            TextArea_to_fileWriter(JS_UserData01, editjobtextarea);
            System.out.println("Save Ok : "+JS_UserData01);
           
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }     
    
    /**
     *
     * @param command
     */
    public void executeCommand(String command) {
    try {
        log(command);
        Process process = Runtime.getRuntime().exec(command);
        logOutput(process.getInputStream(), "");
        logOutput(process.getErrorStream(), "Error: ");
        process.waitFor();
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}

    /**
     *
     * @param inputStream
     * @param prefix
     */
    public void logOutput(InputStream inputStream, String prefix) {
    new Thread(() -> {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        while (scanner.hasNextLine()) {
            synchronized (this) {
                log(prefix + scanner.nextLine());
            }
        }
        scanner.close();
    }).start();
}

    /**
     *
     */
    public void CheckDataTextAreaEmpty() {
if (data_edit.getText().isEmpty()  ) 
        {
            jButton5.setEnabled(false);
            saveJS_Button.setEnabled(false);
           
            jLabel13.setEnabled(false);

          
            
        } else {
            jButton5.setEnabled(true);
            saveJS_Button.setEnabled(true);
            
            jLabel13.setEnabled(true);

           
            
        }
}

    /**
     *
     */
    public void CheckDataTextAreaDefaultText() {
if (GetInfo_01.getText().contains(defaultText) && GetInfo_02.getText().contains(defaultText) ) 
        {
            jButton5.setEnabled(false);
            saveJS_Button.setEnabled(false);
  
            jLabel13.setEnabled(false);

            
            
        } else {
            jButton5.setEnabled(true);
            saveJS_Button.setEnabled(true);

            jLabel13.setEnabled(true);

          
            
        }
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
    public void SaveJS_UserDataFile() {
        try { 
            UserDataBackUp();
            
            File JS_UserData = new File(PathWebServer+"//"+mainFolder+"//"+
                CamJobName() + "//" + CamJobName() + ".js");
            TextArea_to_fileWriter(JS_UserData, data_edit);
            System.out.println("Save Ok : "+JS_UserData);
           
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    /**
     *
     */
    public void SavePy_UserDataFile() {
        try {
            UserDataBackUp();
//        File Py_UserData = new File(
//                PathWebServer+"\\"+
//                mainFolder+"//"+
//                CamJobName() + "//"+PythonFolderMainName()+"//" + PyNamesFiles() + ".py");

            //System.out.println("Save Ok : "+Py_UserData);
            //UserDataBackUp();
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }    
    
    
//    public void TextAreamanipulation() throws BadLocationException {
//        int pylines = py_data_edit.getLineCount();
//        int jslines = data_edit.getLineCount();
//        for (int i = 0; i < pylines; i++) {
//            int startpy = py_data_edit.getLineStartOffset(i);
//            int endpy = py_data_edit.getLineEndOffset(i);
//           
//        }
//        for (int i = 0; i < jslines; i++) {
//            int startjs = data_edit.getLineStartOffset(i);
//            int endjs = data_edit.getLineEndOffset(i);
//        }
//        
//        for (String line : data_edit.getText().split("\\n")) {
//        
//        }
//        
//    }

    /**
     *
     * @return
     */

    
    public static String CheckMachineMotion() {
        String h1 = Check_CBox_Vars_Option();
        String j1 = "";
        if (machineMotionCB.isSelected()) {
            j1 = h1;
        } else {
            j1 = "";
        }
        return j1;
    }

    /**
     *
     * @param t
     * @return
     */
    public static String CheckMachineMotionCam(Integer t) {
        String h1 = Check_CBox_MarkArea_Option(t);
        String j1 = "";
        if (machineMotionCB.isSelected()) {
            j1 = h1;
        } else {
            j1 = "";
        }
        return j1;
    } 
    
    /**
     *
     * @return
     */
    public static String CheckMachineMotionCamAll() {
        String h1 = MachineCamAll();
        String j1 = "";
        if (machineMotionCB.isSelected()) {
            j1 = "/*"+h1+"*/\n";
        } else {
            j1 = "";
        }
        return j1;
    }    
    
    /**
     *
     * @return
     */
    public static String CheckMachineMotionCamArray() {
        String h1 = Check_CBox_Vars_Option();
        String j1 = "";
        if (machineMotionCB.isSelected()) {
            j1 = h1;
        } else {
            j1 = "";
        }
        return j1;
    }    
    
    /**
     *
     */
    public void CheckCBDwell() {
        if (machineMotionCB.isSelected()) {
            machineMotionCB.setEnabled(false);
        } else {
            machineMotionCB.setEnabled(true);
        }
    
    }
    
    /**
     *
     * @param theMessage
     * @return
     */
    public static int CamJobExist_YesNoCancel(String theMessage) {
    int result = JOptionPane.showConfirmDialog((Component) null, theMessage,"alert", JOptionPane.YES_NO_CANCEL_OPTION);
    return result;
  }    
    
    /**
     *
     * @return
     */
    public static String[] ReadHTMLfilesMain() {
        
        String[] list = null;
        try {
            File tmp = new File(PathWebServer + "\\" + mainFolder );
            FilenameFilter filenameFilter = (file, s) -> (s.endsWith(".html") && !s.startsWith("PROD"));

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

        private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     *
     */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;
        
         private int returnStatus = RET_CANCEL;
}
