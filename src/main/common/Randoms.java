/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.common;

/**
 *
 * @author MManolas
 */
public class Randoms {
    
    /**
     *
     * @return
     */
    public static String RandomNumber() {
        String h1 = "";
        h1 = String.valueOf(getRandomInteger(19, 1));
        return h1;
    }
       
    /**
     *
     * @param max
     * @return
     */
    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }

    /* * returns random integer between minimum and maximum range */

    /**
     *
     * @param maximum
     * @param minimum
     * @return
     */

    public static int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }     
    
}
