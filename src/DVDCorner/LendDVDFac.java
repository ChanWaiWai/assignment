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
 * @author user
 */
public class LendDVDFac implements CommandFactory{
    Vector dvd;
    private CareTaker ct;
    
    public LendDVDFac(CareTaker ct) {
        this.ct = ct;
    }

    @Override
    public void setDVD(Vector dvd) {
        this.dvd = dvd ;
    }

    @Override
    public Command create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        String id = scanner.nextLine();
        return new LendDVDCommand(dvd , id, ct);
    }
}
