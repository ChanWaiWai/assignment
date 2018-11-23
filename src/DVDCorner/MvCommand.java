/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author wai
 */
public class MvCommand implements Command {
    MV mv;
    Vector dvd;
    private int dvdID;
    private String title;
    private int length;
    private int numAvailable;
    private String singer;
    
    public MvCommand(Vector dvd) {
        this.dvd = dvd;
        mv = null;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id, title, length, number of available copies, singer:");
        String [] answer = scanner.nextLine().split(",");
        dvdID  = Integer.parseInt(answer[0]);
        title = answer[1];
        length = Integer.parseInt(answer[2]);
        numAvailable = Integer.parseInt(answer[3]);
        singer  = answer[4];
        mv = new MV(dvdID, title, length, numAvailable, singer);
        dvd.add(mv);
        System.out.println("DVD record created.");
    }

    @Override
    public void undo() {
        if (mv != null){
            dvd.remove(mv);
        }
    }
}
