/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

/**
 *
 * @author wchan
 */
public class Main {
    public static void main (String [] args){
        DVD mv = new MV(101, "Test", 50, 10, "Test");
        System.out.println(mv.toString());
    }
}
