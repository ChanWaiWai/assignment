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
public interface Memento {
    public int getDvdId();
    public String getTitle();
    public DVD getDVD();
    public void restore();
}
