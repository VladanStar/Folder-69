
package radsadatotekama;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class RadSaDatotkama {

   
    public static void main(String[] args) throws FileNotFoundException, IOException {
       Scanner ulaz; // ulazni tekstalni tok za citanje
       PrintWriter izlaz; // izlazni tekstualni tok za pisanje
       double[]brojevi = new double[1000]; // niz ucitanih brojeva
       int k =0;// ukupan bcitanih brojeva
       
       // konstruisanje uzlaznog toka za datoteku podaci.txt
       try{
       ulaz = new Scanner(new FileReader("podaci.txt"));
       }
       catch(FileNotFoundException e){
           System.out.println("Ulazna datoteka podaci.txt");
           System.out.println("nije nadjena");
           return; // kraj rada programa zbog greske
       }
       // konstruisanje izlaznog toka za datoteku sort-podaci.txt
       try{
       izlaz = new PrintWriter(new FileWriter("sort-podaci.txt"));
       }
       catch(IOException e){
           System.out.println("Otvaranje izlazne datoteke");
           System.out.println("sort-podaci.txt");
           System.out.println("Nije uspelo");
           System.out.println("Greska " + e);
           ulaz.close(); // zatvoriti ulaznu datoteku
           return; // kraj rada zbog greske
       }
       try{
           // ucitavanje brojeva iz ulazne datoteke u niz
           while(ulaz.hasNext()){// sve dok ima sledeceg broja
           brojevi[k] = ulaz.nextDouble(); // ucitati ga...
           k=k+1;
           }
           // sortiranje ucitanih brojeva
           Arrays.sort(brojevi,0,k);
           // upisivanje sortiranih brojeva u izlaznu datoteku
           for(int i =0; i<k;i++){
           izlaz.println(brojevi[k]);
               System.out.println("Ulazna datoteka je sortirana");
           }
       }
       catch(RuntimeException e){
           System.out.println("Problem u radu sa nizom");
           System.out.println("Greska " + e.getMessage());
       }
       catch(Exception e){
           System.out.println("Problem pri citanju.pisanju podataka");
           System.out.println("Greska" + e.getMessage());
       }
       finally{
       // zatvaranje obe datoteke u svakom slucaju
       ulaz.close();
        izlaz.close();
       }
    }
    
}
