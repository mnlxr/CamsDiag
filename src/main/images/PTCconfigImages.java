/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.imgs;

import javax.swing.ImageIcon;

/**
 *
 * @author MManolas
 */
public class PTCconfigImages {

    /**
     *
     */
    public static ImageIcon FlagYellowIcon = new ImageIcon("main/imgs/flag_yellow.png");

    /**
     *
     */
    public static String ImagePathSrc="/main/imgs/";
    
    /**
     *
     * @param ImageNamePTC
     * @return
     */
    public static ImageIcon PTCconfigImgs(String ImageNamePTC) {
    ImageIcon image = new ImageIcon(ImagePathSrc+ImageNamePTC);
        return image;
    }
    
    /**
     *
     * @param ImageNamePTC
     * @return
     */
    public static String PTCconfigImgsStr(String ImageNamePTC) {
    String image =  ImagePathSrc+ImageNamePTC;
        return image;
    }    
    
}
