package app;

import java.io.File;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CircuitApp {
    private static final char fSep = File.separatorChar;
    private int NOMBRE_D_ITERATION=0;
    String chemin =System.getProperty("user.dir")  +fSep+"src"+fSep+"donnees"+fSep+"fichiers_json";
    File[] fichier = new File(chemin).listFiles();

    public CircuitApp() {
        System.out.println(messageDemarage());
        choixDeFichier();
    }

    public String messageDemarage() {
        return "Bienvenu, ce programme sert a calculer la résistance total d'un circuit a partir d'un fichier JSON. \nVoici les fichiers disponibles et les actions que j'apercois: ";
    }

    public void choixDeFichier() {
        for (int i = 1; i <=3; i++) {
            System.out.println("[" + i + "] " + fichier[i-1].getName());
        }
        if (NOMBRE_D_ITERATION==0) {
            System.out.println("[Q] Quitter le programme");
        }
        choix();
    }
    public void choix(){
        System.out.println("Veillez faire un choix :");
        Scanner scanner = new Scanner(System.in);
        String reponse =scanner.nextLine();
        try {
            if (((reponse.equals("Q"))||(reponse.equals("q")))&&(NOMBRE_D_ITERATION==0)){
                quitterProgramme();
            }
            else if ((parseInt(reponse) <= fichier.length)&&(parseInt(reponse)>0)) {
                System.out.println("Choix fait : " + fichier[parseInt(reponse)-1].getName() + ".");
                NOMBRE_D_ITERATION+=1;
               String chemindufichier=fichier[parseInt(reponse)-1].getPath();
                double resultat = new CircuitBuilder(chemindufichier).calculerResistance();
               affichageReistance(resultat);
            } else {
            System.out.println("Vôtre réponse est invalide !");
            System.out.println("Veillez selectionnez un fichier ou quittez en tapant Q.");
            choixDeFichier();
            }
        }catch (NumberFormatException e){
            System.out.println("Vôtre réponse est invalide !");
            System.out.println("Veillez selectionnez un fichier ou quittez en tapant Q.");
            choixDeFichier();
        }

    }
public void quitterProgramme(){
    System.out.println("Vous avez quittez le programme avec succes.");
}
public void affichageReistance(double resistance) {
    double arrondi = Math.round(resistance * 100.0) / 100.0;
    System.out.println("Résistance équivalente calculée du circuit : "+ arrondi+ " Ω.");
    choixDeFichier2();
}
public void choixDeFichier2(){
    System.out.println("[Q] Quitter le programme");
        System.out.println("[R] Tester un autre fichier");
    System.out.println("Veillez faire un choix :");
    Scanner scanner = new Scanner(System.in);
    String reponse =scanner.nextLine();

    if (((reponse.equals("R"))||(reponse.equals("r")))&&(NOMBRE_D_ITERATION>0)){
choixDeFichier();
    } else  if ((reponse.equals("Q"))||(reponse.equals("q"))){
        quitterProgramme();
    } else {
        System.out.println("Vôtre réponse est invalide !");
        choixDeFichier2();
    }

}
    static void main(String[] args) {
        new CircuitApp();
    }
}
