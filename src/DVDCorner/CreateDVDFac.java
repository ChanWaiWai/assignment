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
public class CreateDVDFac implements CommandFactory{
    Vector dvd;

    @Override
    public void setDVD(Vector dvd) {
        this.dvd = dvd;
    }

    @Override
    public Command create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter DVD type (mo=movie/mv=MV):");
        String type = scanner.nextLine();
        if(type.equals("mo")){
            return new MvCommand(dvd);
        }else
            return new MovieCommand(dvd);
    }
}
