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
public class MovieCommand implements Command {
    Vector dvd;
    Movie movie;
    private int dvdID;
    private String title;
    private int length;
    private int numAvailable;
    private String director;
    
    public MovieCommand(Vector dvd) {
        this.dvd = dvd;
        movie = null;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id, title, length, number of available copies, director:");
        String [] answer = scanner.nextLine().split(",");
        dvdID  = Integer.parseInt(answer[0]);
        title = answer[1];
        length = Integer.parseInt(answer[2]);
        numAvailable = Integer.parseInt(answer[3]);
        director  = answer[4];
        movie = new Movie(dvdID, title, length, numAvailable, director);
        dvd.add(movie);
        System.out.println("DVD record created.");
    }

    @Override
    public void undo() {
        if(movie != null){
            dvd.remove(movie);
        }
    }
}
