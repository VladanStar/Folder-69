
package radsadatotekom1;

import java.io.File;
import java.util.Scanner;


public class RadSaDatotekom1 {

   
    public static void main(String[] args) {
        String imeDir;  // ime direktorijuma koje korisnik zadaje
        Scanner tastatura; //... i program ucitava preko tasture 
        File dir; // objekat tipa File za taj direktorijum
        String[] datoteke; 
        tastatura = new Scanner(System.in);
        System.out.println("Unesite ime direktorijuma: ");
        imeDir = tastatura.nextLine().trim();
        
        dir = new File(imeDir);
        if(!dir.exists()){
            System.out.println("Takav direktorijum ne postoji");
        }
        else if(!dir.isDirectory()){
            System.out.println("To nije direktorijum");
        }
        else{
        datoteke = dir.list();
            System.out.print("Datoteke u direktorijumu\"");
            System.out.println(dir + "\" su:");
            for(int i =0; i<datoteke.length; i++){
                System.out.println("Datoteke " + datoteke[i]);
            }
        }
    }
    
}
