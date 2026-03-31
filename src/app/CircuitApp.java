package app;

import java.io.File;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CircuitApp {
    private static final char fSep = File.separatorChar;
    String chemin =System.getProperty("user.dir")  +fSep+" src"+fSep+"donnees"+fSep+"fichiers_json";
    File[] fichier = new File(chemin).listFiles();
    public CircuitApp() {
        System.out.println(messageDemarage());
        choixDeFichier();
    }

    public String messageDemarage() {
        return "Bienvenu, ce programme sert a calculer la résistance total d'un circuit a partir d'un fichier JSOn. \nVoici les fichiers disponibles que j'apercois: ";
    }

    public void choixDeFichier() {
        for (int i = 1; i <3; i++) {
            System.out.println("[" + i + "] " + fichier[i-1].getName());
        }
        System.out.println("[Q] Quitter le programme");
        System.out.println("Veillez faire un choix");
        choix();
    }
    public void choix(){
        Scanner scanner = new Scanner(System.in);
        String reponse =scanner.nextLine();
        if (reponse.equals("Q")){
            quitterProgramme();
        }
        else if (parseInt(reponse) <= fichier.length) {
          String chemindufichier=chemin+fSep+fichier[parseInt(reponse)-1];
            new CircuitBuilder(chemindufichier);
        }
    }
public void quitterProgramme(){
    System.out.println("Vous avez quittez le programme");
}
    static void main(String[] args) {
        new CircuitApp();
    }
}
