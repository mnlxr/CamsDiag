package main.utils;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author MManolas
 */
public class SplashScreenDemo {
    JFrame frame;
    JLabel image=new JLabel(new javax.swing.ImageIcon(getClass().getResource("/main/images/camsdiag01.png")));
    //JLabel image=new JLabel(new ImageIcon("camsdiag01.png"));
    //javax.swing.ImageIcon(getClass().getResource("/main/images/camsdiag01.png"))
    JLabel text=new JLabel("Cams Diag Loading");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    SplashScreenDemo()
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
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.orange);
        frame.setVisible(true);

    }

    /**
     *
     */
    public void addImage(){
        image.setSize(600,225);
        //image.setSize(225,225);
        //600,200
        frame.add(image);
    }

    /**
     *
     */
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,20));
        text.setBounds(170,220,600,40);
        text.setForeground(Color.BLUE);
        frame.add(text);
    }

    /**
     *
     */
    public void addMessage()
    {
        message.setBounds(250,320,200,40);
        message.setForeground(Color.black);
        message.setFont(new Font("arial",Font.BOLD,11));
        frame.add(message);
    }

    /**
     *
     */
    public void addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        frame.add(progressBar);
    }

    /**
     *
     */
    public void runningPBar(){
        int i=0;

        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("Loading  "+Integer.toString(i)+"%");
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }



        }
    }
}
