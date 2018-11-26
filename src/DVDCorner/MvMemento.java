/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

/**
 *
 * @author user
 */
class MvMemento implements Memento{
    private MV mv;
    private String title;
    private String singer;
    private int dvdID;
    private int numAvailable;
    private int length;
    
    public MvMemento(MV mv){
        this.mv = mv;
        this.dvdID = mv.getDvdID();
        this.singer = mv.getSinger();
        this.length = mv.getLength();
        this.numAvailable = mv.getNumAvailable();
        this.title = mv.getTitle();
    }
    
    @Override
    public int getDvdId() {
        return mv.getDvdID();
    }

    @Override
    public String getTitle() {
        return mv.getTitle();
    }

    @Override
    public DVD getDVD() {
        return (MV)mv;
    }

    @Override
    public void restore() {
        System.out.println(mv);
        mv.setSinger(singer);
        mv.setNumAvailable(numAvailable);
    }
}
