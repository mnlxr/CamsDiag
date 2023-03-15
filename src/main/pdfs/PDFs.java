/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pdfs;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.MnIT_Main;
import static main.common.Commands.PDFlite_Image;
import main.common.MainVars;
import main.info.UserInfo;

/**
 *
 * @author MManolas
 */
public class PDFs extends javax.swing.JFrame implements DropTargetListener{
//jpeg2pdf.exe -o doc1.pdf -t "The Title of PDF" -a Andrew -c MManolas -p auto -n landscape -z fit -r both *.jpeg
//pdfimage.exe -o "C:\Data\CamsDiag\gnu32\pdflite\bin\mmanolas2.pdf" /*-p num*/ "C:\Data\CamsDiag\gnu32\pdflite\bin\c1.png" "C:\Users\mmanolas\Downloads\ff1.jpeg"    
    
    /**
     * Creates new form PDFs
     */
    public PDFs() {
        initComponents();
        dt = new DropTarget(ta, this);
    }
DropTarget dt;




public String[] TextAreaFiles_StringArray() {
String[] h1 = null;
String h2 = ta.getText().toString();

String s[] = ta.getText().split("\\r?\\n");
//ta.getText().split("\\n");
    ArrayList<String>arrList = new ArrayList<>(Arrays.asList(s)) ;
    System.out.println(arrList);
    String[] stringArray = arrList.toArray(new String[0]);

return stringArray;}

public  String TextAreaFiles_String() {
String h1="";
String[] stringArray = TextAreaFiles_StringArray();


StringBuffer sb = new StringBuffer();
    for (int i = 0; i < stringArray.length; i++) {
        sb.append("\""+stringArray[i]+"\" ");
    }
    String str = sb.toString();
    System.out.println(str);
// for(int i = 0; i < TextAreaFiles_StringArray().length; i++) {
//         sb.append(TextAreaFiles_StringArray()[i]);
//      }
//      String str = sb.toString();
//      System.out.println(str);
return str;}


public void PDFliteCommand() {
//String h1="";
//String pathExport = main_path_installation+"\\PDFs";
//String cmdpdflite = "\""+pdfliteImage+"\""+" -o \""+pathExport+"\\"+UserInfo.Get_UserName()+"_CamsDiag"+"_"+ZipDate()+".pdf\" -p 1 "+TextAreaFiles_String();
//String cmd_cd = "cd "+pathExport+" && ";
String CMD_final=PDFlite_Image()+TextAreaFiles_String();


try {
      String line;
      Process p = Runtime.getRuntime().exec(CMD_final);
      System.out.println(CMD_final);
      BufferedReader bri = new BufferedReader
        (new InputStreamReader(p.getInputStream()));
      BufferedReader bre = new BufferedReader
        (new InputStreamReader(p.getErrorStream()));
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
      jLabel2.setText("Done");
      convertBt.setEnabled(false);
      ta.append("PDF is Ready!\n");
    }
    catch (Exception err) {
      err.printStackTrace();
    }

}

    @Override
  public void dragEnter(DropTargetDragEvent dtde) {
    System.out.println("Drag Enter");
  }

    @Override
  public void dragExit(DropTargetEvent dte) {
    System.out.println("Drag Exit");
  }

    @Override
  public void dragOver(DropTargetDragEvent dtde) {
    System.out.println("Drag Over");
  }

    @Override
  public void dropActionChanged(DropTargetDragEvent dtde) {
    System.out.println("Drop Action Changed");
  }
  
    @Override
    public void drop(DropTargetDropEvent dtde) {
    try {
      // Ok, get the dropped object and try to figure out what it is
      Transferable tr = dtde.getTransferable();
      DataFlavor[] flavors = tr.getTransferDataFlavors();
      for (int i = 0; i < flavors.length; i++) {
        System.out.println("Possible flavor: "
            + flavors[i].getMimeType());
        // Check for file lists specifically
        if (flavors[i].isFlavorJavaFileListType()) {
          // Great! Accept copy drops...
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          jLabel2.setText("Successful file list drop.");
          ta.setBackground(new java.awt.Color(204, 255, 204));
          
          // And add the list of file names to our text area
          java.util.List list = (java.util.List) tr
              .getTransferData(flavors[i]);
          for (int j = 0; j < list.size(); j++) {
            ta.append(list.get(j) + "\n");
          }

          // If we made it this far, everything worked.
          dtde.dropComplete(true);
          convertBt.setEnabled(true);
          TextAreaFiles_StringArray();
          TextAreaFiles_String();
          return;
        }
        // Ok, is it another Java object?
        else if (flavors[i].isFlavorSerializedObjectType()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          jLabel2.setText("Successful text drop");
          Object o = tr.getTransferData(flavors[i]);
          ta.append("Object: " + o);
          dtde.dropComplete(true);
          convertBt.setEnabled(true);
          return;
        }
        // How about an input stream?
        else if (flavors[i].isRepresentationClassInputStream()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          jLabel2.setText("Successful text drop.");
          ta.read(new InputStreamReader((InputStream) tr
              .getTransferData(flavors[i])),
              "from system clipboard");
          dtde.dropComplete(true);
          convertBt.setEnabled(true);
          return;
        }
      }
      // Hmm, the user must not have dropped a file list
      System.out.println("Drop failed: " + dtde);
      ta.setBackground(Color.red);
      dtde.rejectDrop();
      convertBt.setEnabled(false);
    } catch (Exception e) {
      e.printStackTrace();
      dtde.rejectDrop();
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

        exitBt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        convertBt = new javax.swing.JButton();
        openDirBt = new javax.swing.JButton();
        clearBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:: CamsDiag PDF Images Creator - "+UserInfo.Get_UserName()+" - "+UserInfo.Get_ComputerName()
            +" ::.");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/main/images/camsdiag01.png")).getImage());

        exitBt.setFont(getFont());
        exitBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/exit.png"))); // NOI18N
        exitBt.setText("Exit");
        exitBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtActionPerformed(evt);
            }
        });

        jLabel2.setFont(getFont());
        jLabel2.setText("-");

        ta.setEditable(false);
        ta.setColumns(20);
        ta.setFont(getFont());
        ta.setRows(5);
        ta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true)), "Drag n Drop Images Here", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, getFont()));
        jScrollPane4.setViewportView(ta);

        convertBt.setFont(getFont());
        convertBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/pdf.png"))); // NOI18N
        convertBt.setText("Convert");
        convertBt.setEnabled(false);
        convertBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertBtActionPerformed(evt);
            }
        });

        openDirBt.setFont(getFont());
        openDirBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/drives.png"))); // NOI18N
        openDirBt.setText("Open Dir");
        openDirBt.setEnabled(false);
        openDirBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDirBtActionPerformed(evt);
            }
        });

        clearBt.setFont(getFont());
        clearBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/cross.png"))); // NOI18N
        clearBt.setText("Clear");
        clearBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(clearBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 469, Short.MAX_VALUE)
                        .addComponent(openDirBt)
                        .addGap(18, 18, 18)
                        .addComponent(convertBt)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(convertBt)
                    .addComponent(openDirBt)
                    .addComponent(clearBt))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(exitBt)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBt)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(836, 481));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtActionPerformed

    private void openDirBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDirBtActionPerformed
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            openDirBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            dirToOpen = new File(MainVars.main_path_installation+"\\PDFs");
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(MnIT_Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openDirBtActionPerformed

    private void convertBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertBtActionPerformed
        PDFliteCommand();
        openDirBt.setEnabled(true);
    }//GEN-LAST:event_convertBtActionPerformed

    private void clearBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtActionPerformed
        ta.setText("");
        convertBt.setEnabled(false);
        openDirBt.setEnabled(false);
    }//GEN-LAST:event_clearBtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new PDFs();
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
            java.util.logging.Logger.getLogger(PDFs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDFs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDFs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDFs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDFs().setVisible(true);
            }
        });
    }

    
    class ImgFilter extends javax.swing.filechooser.FileFilter {

        public boolean accept(File f) {

            return f.isFile() 
                    && f.getName().toLowerCase().endsWith(".jpeg") 
                    || f.getName().toLowerCase().endsWith(".png") 
                    || f.getName().toLowerCase().endsWith(".jpg") 
                    || f.isDirectory();
        }

        public String getDescription() {

            return "Images";
        }
    }    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBt;
    private javax.swing.JButton convertBt;
    private javax.swing.JButton exitBt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton openDirBt;
    private javax.swing.JTextArea ta;
    // End of variables declaration//GEN-END:variables
}
