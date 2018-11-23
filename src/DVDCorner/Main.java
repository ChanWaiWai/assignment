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
 * @author wchan
 */
public class Main {
    public static void main (String [] args){
        Vector dvd = new Vector();
        Vector history = new Vector();
        Scanner scanner = new Scanner(System.in);
        boolean count = true;
        
        String[] factory = {"createDVDFac", "ShowDVDFac", "AcceptDVDDonationFac", "LendDVDFac", "ReturnDVDFac", "ShowListFac"};
        
        CommandFactory[] commandFactory = new CommandFactory[factory.length];
        try{
            for(int i = 0 ; i<commandFactory.length ; i++){
                commandFactory[i] = (CommandFactory)  Class.forName(factory[i]).newInstance();
               
            }
        }catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        while(count){
            System.out.println("DVD Record System\n" +
                               "Please enter command: [c | s | a | l | g | u | r | d | x]\n" +
                               "c = create DVD,  s = show DVD,  a = accept donation of DVD,  l = lend out a DVD, \n" +
                               "g = get back a returned DVD, u = undo,  r = redo,  d = display undo/redo list,  x = exit system");
            String line = scanner.nextLine();
            if(line.equals("x")){
                count=false;
            }else if(line.equals("u")){
                if(history.size() > 0){
                    Command com = (Command) history.remove(history.size() - 1);
                    com.undo();
                }
            }else if(line.equals("c")){
                Command com = commandFactory[0].create();
                history.add(com);
                //Execute the create DVD command
                com.execute();
            }else if(line.equals("s")){
                Command com = commandFactory[1].create();
                //Execute the show DVD command
                com.execute();
            }else if(line.equals("a")){
                Command com = commandFactory[2].create();
                //Execute the accept DVD command
                com.execute();
            }else if(line.equals("l")){
                Command com = commandFactory[3].create();
                //Execute the lend DVD command
                com.execute();
            }else if(line.equals("g")){
                Command com = commandFactory[4].create();
                //Execute the get back returned DVD command
                com.execute(); 
            }else if(line.equals("d")){
                Command com = commandFactory[5].create();
                //Execute the display undo/redo List command
                com.execute();
            }
        }
    }
}
