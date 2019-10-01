/*
 * Classe que defineix un torn. Un torn es defineix pel seu codi, nom, hora d'inici
 * i hora d'acabament del torn.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Torn {

    private String codi;
    private String nom;
    private String horaInici;
    private String horaAcabament;
    
    /* atribut constant DADES de tipus Scanner */
    static private Scanner DADES = new Scanner(System.in);

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    public Torn(String cd,String nm,String hi,String ha){
        codi = cd;
        nom = nm;
        horaInici = hi;
        horaAcabament = ha;
    }

    /*
     TODO Mètodes accessors    
     */
    public String getCodi(){
        
        return codi;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou torn. Les dades 
     a demanar són les que passem per paràmetre en el constructor.
     - Per assignar les hores d'inici i acabamanet del torn, heu d'utilitzar el mètode
     escaient d'aquesta classe.
     Retorn: El nou torn creat.
     */
    public static Torn addTorn() {
        System.out.println("Introdueix les dades per crear un nou torn");
        System.out.println("Introdueix les dades que es demanen i pulsa [ENTER]");
        
        System.out.println("\nCodi: ");
        String codTorn = DADES.nextLine();
        System.out.println("\nNom: ");
        String nomTorn = DADES.nextLine();
        System.out.println("Introdueix les dades per definir l'hora d 'inici del torn");
        String horaInici = horesTorn();
        System.out.println("Introdueix les dades per definir l'hora en que acaba el torn");
        String horaFinal = horesTorn();
        
        Torn nouTorn = new Torn(codTorn,nomTorn,horaInici,horaFinal);
        
        return nouTorn;

    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte (Penseu com heu de
     modificar les hores d'inici i d'acabament del torn).
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     Retorn: cap
     */
    public void updateTorn() {
        
        showTorn(); 
        
        System.out.println("\nIntrodueix les dades per modificar el torn:");
        System.out.println("\n Codi: ");
        codi = DADES.nextLine();
        System.out.println("\n Nom: ");
        nom = DADES.nextLine();
        System.out.println("Introdueix les dades per definir l'hora d 'inici del torn");
        horaInici = horesTorn();
        System.out.println("Introdueix les dades per definir l'hora en que acaba el torn");
        horaAcabament = horesTorn();
        
    }

    public void showTorn() {
        System.out.println("\nLes dades del torn amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHora d'inici: "+horaInici);
        System.out.println("\nHora d'acabament: "+horaAcabament);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear les hores d'inici o acabament
     d'un torn.
     - Tant l'hora d'inici com la d'acabament, han de tenir el format "hh:mm", on
     hh és l'hora en format 24 hores i mm els minuts. Perquè es respecti el format,
     primer demanarem l'hora a l'usuari i després els minuts. El mateix mètode és
     el que haurà de crear el format correcte amb les dades introduïdes per l'usuari.
     - Heu de controlar que les hores i minuts introduïts siguin correctes. Si no 
     és així, se li tornaran a demanar a l'usuari fins que introdueixi unes dades correctes.
     Retorn: Les hores d'inici o acabament del torn.
     */
    public static String horesTorn() {
        
        int hores = 0;
        int minuts = 0;
        
        System.out.println("L'Hora s'enregistra en format 24 hores Ex: \"hh:mm\" \n"
                + "on hh és l'hora i  mm els minuts");
        
        boolean horaInorrecte = true; 
            while (horaInorrecte){
             System.out.println("Introdueix les hores:");
            hores = DADES.nextInt();
             System.out.println("Introdueix els minuts");
            minuts = DADES.nextInt();

            if (((hores >= 0)&&(hores <=24))&&((minuts >= 0)&&(minuts <60))){
                horaInorrecte = false;
            }
        }
        String textHores = Integer.toString (hores);
        if (textHores.length()<2){textHores= "0" + textHores;}
        String textMinuts = Integer.toString(minuts);
        if (textMinuts.length()<2){textMinuts= "0" + textMinuts;}
        
        String horesTorn = textHores +":"+textMinuts;
        
        return horesTorn;

    }
}
