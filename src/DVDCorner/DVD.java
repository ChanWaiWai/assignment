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
public abstract class DVD {
    private int dvdID;
    private String title;
    private int length;
    private int numAvailable;
    
    public DVD(int dvdID, String title, int length, int numAvailable){
        this.dvdID = dvdID;
        this.title = title;
        this.length = length;
        this.numAvailable = numAvailable;
    }
    
    public int getDvdID(){
        return dvdID;
    }
    
    public String getTitle(){
        return title;
    }
    
    public int getLength(){
        return length;
    }
    
    public int getNumAvailable(){
        return numAvailable;
    }
    
    public void setNumAvailable(int numAvailable){
        numAvailable += this.numAvailable;
    }
    
    public String toString(){
        return "DVD information\nID: " + dvdID + "\nTitle: " + title + "\nLength: " + length + " mins\n" + "Number of available copies: " + numAvailable;
    }
}
