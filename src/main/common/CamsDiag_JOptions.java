/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import javax.swing.JOptionPane;

/**
 *
 * @author MManolas
 */
public class CamsDiag_JOptions {
   
    public static int ClearBackUpFolder() {
        int input = JOptionPane.showConfirmDialog(null,
                "Do you want to proceed?", "Empty BackUp Folder..", JOptionPane.YES_NO_CANCEL_OPTION);

        // 0=yes, 1=no, 2=cancel
        //System.out.println(input);    
        return input;
    }
    
    
    public static int DeleteCamsJobs() {
        int input = JOptionPane.showConfirmDialog(null,
                "Do you want to proceed?", "Delete Cams Jobs..", JOptionPane.YES_NO_CANCEL_OPTION);

        // 0=yes, 1=no, 2=cancel
        //System.out.println(input);    
        return input;
    }    
    
    
}
