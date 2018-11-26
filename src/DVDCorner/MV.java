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
public class MV extends DVD{
    String singer;
    
    public MV(int dvdID, String title, int length, int numAvailable, String singer) {
        super(dvdID, title, length, numAvailable);
        this.singer = singer;
    }
    
    public String getSinger(){
        return singer;
    }
    
    public void setSinger(String singer){
        this.singer = singer;
    }
    
    public String toString(){
        return super.toString() + "\nSinger: " + singer;
    }
}
