/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.util.Vector;

/**
 *
 * @author user
 */
public class CareTaker {
    private Vector undoList;
    private Vector redoList;
    private Vector showUndoList;
    private Vector showRedoList;
    private Vector dvd;
    
    public CareTaker(Vector dvd){
        undoList = new Vector();
        redoList = new Vector();
        showUndoList = new Vector();
        showRedoList = new Vector();
        this.dvd = dvd;
    }
    
    public void saveMovie(Movie movie){
        MovieMemento mm = new MovieMemento(movie);
        undoList.add(mm);
    }
    
    public void saveMv(MV mv){
        MvMemento mvm = new MvMemento(mv);
        undoList.add(mvm);
    }
    
    public void addShowUndoList(String tostring) {
        showUndoList.add(tostring);
    }
    
    public void addShowRedoList(String tostring) {
        showRedoList.add(tostring);
    }
    
    public void printUndoRedoList() {
        System.out.println("\nUndo List:");
        if (showUndoList.size() < 1) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < showUndoList.size(); i++) {
                System.out.println(showUndoList.get(i));
            }
        }
        System.out.println("\nRedo List:");
        if (showRedoList.size() < 1) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < showRedoList.size(); i++) {
                System.out.println(showRedoList.get(i));
            }
        }
    }
    
    public void undo() {
        if (undoList.size() > 0) {
            int lastIndex = undoList.size() - 1;
            Memento m = (Memento)undoList.get(lastIndex);
            int undoDVDid = m.getDvdId();
            redoList.add(m);
            showRedoList.add(showUndoList.get(showUndoList.size() - 1));
            showUndoList.remove(showUndoList.size() - 1);
            undoList.remove(lastIndex);
            if (lastIndex > 0) {
                Boolean needRestore = false;
                for (int i = undoList.size() - 1; i >= 0; i--) {
                    Memento currentMemento = ((Memento)undoList.get(i));
                    if (currentMemento.getDvdId() == undoDVDid) {
                        needRestore = true;
                        Memento undoAction = (Memento)undoList.get(i);
                        System.out.println(undoAction.getTitle());
                        undoAction.restore();
                        break;
                    }
                }
                if (!needRestore) {
                    dvd.remove(dvd.size() - 1);
                }
            } else if (lastIndex == 0) {
                dvd.remove(lastIndex);
            }
        }
    }
    
    public void redo() {
        if (redoList.size() > 0) {
            int lastIndex = redoList.size() - 1;
            Memento m = (Memento)redoList.get(lastIndex);
            int redoDVDid = m.getDvdId();
            boolean needCreate = true;
            for (int i = undoList.size() - 1; i >= 0; i--) {
                Memento currentMemento = ((Memento)undoList.get(i));
                if (currentMemento.getDvdId() == redoDVDid) {
                    needCreate = false;
                }
            }
            if (needCreate) {
                if (m instanceof MvMemento) {
                    MV mv = (MV)m.getDVD();
                    int id = mv.getDvdID();
                    String title = mv.getTitle();
                    int length = mv.getLength();
                    int numAvailable = mv.getNumAvailable();
                    String singer = mv.getSinger();
                    
                    MV redo = new MV(id, title, length, numAvailable, singer);
                    dvd.add(redo);
                } else if (m instanceof MovieMemento) {
                    Movie movie = (Movie)m.getDVD();
                    int id = movie.getDvdID();
                    String title = movie.getTitle();
                    int length = movie.getLength();
                    int numAvailable = movie.getNumAvailable();
                    String director = movie.getDirector();
                    
                    Movie redo = new Movie(id, title, length, numAvailable, director);
                    dvd.add(redo);
                }
            } else {
                m.restore();
            }
            undoList.add(m);
            showUndoList.add(showRedoList.get(showRedoList.size() - 1));
            showRedoList.remove(showRedoList.size() - 1);
            redoList.remove(lastIndex);
        }
    }
}
