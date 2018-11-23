/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.util.Vector;

/**
 *
 * @author wai
 */
public interface CommandFactory {
    public void setDVD(Vector dvd);
    public Command create();
}
