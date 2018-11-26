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
public class AcceptDVDDonationCommand implements Command{
    private Vector dvd;
    private String id;
    private int numOfDonation;
    private CareTaker ct;
    
    public AcceptDVDDonationCommand(Vector dvd , String id, int numOfDonation, CareTaker ct) {
        this.dvd = dvd;
        this.id = id;
        this.numOfDonation = numOfDonation;
        this.ct = ct;
    }
    @Override
    public void execute() {
        for (int i = 0; i < dvd.size(); i++) {
            DVD currentDVD = ((DVD)dvd.get(i));
            String getcurrentDVDClass = String.valueOf(currentDVD.getClass().getName());
            int currentDVDId = currentDVD.getDvdID();
            String currentDVDTitle = currentDVD.getTitle();
            System.out.println("Donation accepted: " + currentDVDTitle);
            int DVDId = Integer.parseInt(id);
            if (DVDId == currentDVDId) {
                int currentDVDCopies = currentDVD.getNumAvailable();
                int totalDVDCopies = currentDVDCopies + numOfDonation;
                currentDVD.setNumAvailable(totalDVDCopies);
                
                if (getcurrentDVDClass == "DVDCorner.MV") {
                    ct.saveMv((MV)currentDVD);
                } else if (getcurrentDVDClass == "DVDCorner.Movie") {
                    ct.saveMovie((Movie)currentDVD);
                }
                ct.addShowUndoList("Accept " + DVDId + " " + currentDVDTitle + " " + numOfDonation);

                System.out.println("Number of available copies: " + totalDVDCopies + "\n");
                break;
            }
        }
    }
}
