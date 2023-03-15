/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author MManolas
 */
public class AsciiARTs {
  
    public static String ASCII_ART_CamsCharts() throws IOException {
        String h1 = "";
        int width = 211;
        int height = 331;

        StringBuilder sb = null;
        //BufferedImage image = ImageIO.read(new File("images\\bic_icon.png"));
       BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Tahoma", Font.BOLD, 14));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Cams Diag", 10, 20);

        //save this image
        //ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));
        for (int y = 0; y < height; y++) {
            sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

            }

            if (sb.toString().trim().isEmpty()) {
                
                continue;
            }

            System.out.println(sb);

        }
        h1 = sb.toString();
        String h2 = h1;
        return h2;
    }
    
    public static String ASCII_Art01() {
        String h1 = "";
        h1 =      "********************\n"
                + "Cams Diag\n"
                + "\"********************\n"
                + "Please Fill the 3 Elements\n"
                + "1. Cam Job Name \n"
                + "2. Number of Cams\n"
                + "3. Description of the Machine/Cam Job Name\n"
                + "********************\n"
                + "The output is an HTML page and PDF\n";

        return h1;
    }
    
    
//        public static String CamHeader_AsciiArt() {
//        String h1 = "";
//        h1 = main.pyscripts.CamsAppCommon.OneLine_Comment()+
//                "#   +-+ +-+ +-+ +-+                \n" +
//"#   |C| |A| |M| |s|                \n" +
//"#   +-+ +-+ +-+ +-+                \n" +
//"#   +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+\n" +
//"#   |D| |i| |a| |g| |r| |a| |m| |s|\n" +
//"#   +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+\n" +
//                main.pyscripts.CamsAppCommon.OneLine_Comment();
//        return h1;
//    }
}
