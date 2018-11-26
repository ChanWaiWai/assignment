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
public class LendDVDCommand implements Command{
    Vector dvd;
    String dvdID;
    private CareTaker ct;
    
    public LendDVDCommand(Vector dvd , String dvdID, CareTaker ct) {
        this.dvd = dvd;
        this.dvdID = dvdID;
        this.ct = ct;
    }

    @Override
    public void execute() {
        for (int i = 0; i < dvd.size(); i++) {
            DVD currentDVD = ((DVD)dvd.get(i));
            String getcurrentDVDClass = String.valueOf(currentDVD.getClass().getName());
            int currentDVDId = currentDVD.getDvdID();
            String currentDVDTitle = currentDVD.getTitle();
            int DVDId = Integer.parseInt(dvdID);
            if (DVDId == currentDVDId) {
                System.out.println("Lent out: " + currentDVDTitle);
                int totalDVDCopies = currentDVD.getNumAvailable() - 1;
                if (totalDVDCopies >= 0 ) {
                    currentDVD.setNumAvailable(totalDVDCopies);

                    if (getcurrentDVDClass == "DVDCorner.MV") {
                        ct.saveMv((MV)currentDVD);
                    } else if (getcurrentDVDClass == "DVDCorner.Movie") {
                        ct.saveMovie((Movie)currentDVD);
                    }
                    ct.addShowUndoList("Lead " + DVDId + " " + currentDVDTitle);

                    System.out.println("Number of available copies: " + totalDVDCopies + "\n");
                } else {
                    System.out.println("Invalid request (" + currentDVDTitle + " has no available copy)\n");
                }
            }
        }
    }
}
