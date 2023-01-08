package Classi;

import java.util.Random;

public class GeneratoreMatricola {

    //Generazione di una matricola nel formato NXXXXXXXX dove X sono delle cifre da 0 a 9
    private static String generaMatricola() {
        Random rnd = new Random();
        String matricola = "N";
        
        for (int i = 0; i < 8; i++) {
            matricola += rnd.nextInt(10);
        }
        
        return matricola;
    }
    
}
