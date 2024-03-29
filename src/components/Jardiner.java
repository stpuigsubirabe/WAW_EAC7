/*
 * Classe que defineix un jardiner o jardinera. Un jardiner o jardinera es defineix 
 * pel seu NIF, nom, torn de feina i estat, és a dir, actiu si està treballant o no actiu si està 
 * de baixa o vacances.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Jardiner {
    
    private String nif;
    private String nom;
    private Torn torn;
    private boolean actiu;
    
    /* atribut constant DADES de tipus Scanner */
    static private Scanner DADES = new Scanner(System.in);

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou jardiner o jardinera, el seu estat sempre és
     actiu, per tant li assignem verdader. I torn, ja que quan es crea un nou
     jardiner o jardinera aquest encara no té assignat cap torn, per tant li assignarem
     null.
     */
    public Jardiner(String nf, String nm){
        nif = nf;
        nom = nm;
        torn = null;
        actiu = true; 
    }
    /*
     TODO Mètodes accessors    
     */
    public String getNif(){
        
        return nif;
    }
    public Torn getTorn(){
    
        return torn;
    }
    
    public void setTorn (Torn trn){
        torn = trn;
    }
    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou jardiner o nova
     jardinera. Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou jardiner o nova jardinera creat/da.
     */
    public static Jardiner addJardiner() {
        
        System.out.println("Introdueix les dades per crear un nou jardiner");
        System.out.println("\n Introdueix les dades que es demanen i pulsa [ENTER]");
        System.out.println("\n Nif: ");
        String nifJardiner = DADES.nextLine();
        System.out.println("\n Nom: ");
        String nomjardiner = DADES.nextLine();
        
        Jardiner noujardiner = new Jardiner(nifJardiner,nomjardiner);
        
        return noujardiner;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte, menys de l'atribut torn.
     - En el cas de l'atribut actiu, li heu de demanar que si el jardiner o jardinera està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl jardiner o jardinera
     està en actiu", si el jardiner o jardinera està en actiu, i en cas contrari, el missatge 
     "\nEl jardiner o jardinera no està en actiu".
     Retorn: cap
     */
    public void updateJardiner() {
        if (torn == null){
            System.out.println("\n Abnas de modificar el jardiner li has de assignar un torn de treball"); 
        }else{    
            showJardiner();
            setJardiner();
        }
    }

    public void showJardiner() {
        System.out.println("\nLes dades del jardiner o jardinera amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nI el seu torn és: ");
        torn.showTorn();
        System.out.println("\nL'estat és: ");
        
        if(actiu){
            System.out.print("El jardiner o jardinera està en Actiu");
        }else{
            System.out.print("El jardiner o jardinera no està en Actiu\"");
        }
    }
    public void setJardiner(){
        
        System.out.println("\nIntrodueix les dades per modificar al Jardiner:");
        System.out.println("\nIntrodueix les dades que es demanen i pulsa [ENTER]");
        System.out.println("\nNIF del Jardiner o Jardinera ");
        nif = DADES.nextLine();
        System.out.println("\n Nom del Jardiner o Jardinera: ");
        nom = DADES.nextLine();
        System.out.println("\n Aquest jardiner o jardinera es troba actiu ? "
                + "\n Introduex 1 si és actiu" 
                + "\n Introdueix 0 si està de baixa o de vacances" );
        int jarActiu = DADES.nextInt();
        
        switch (jarActiu){
            case 1:
                actiu = true;
                break;
            case 0:
                actiu = false;
                break;
            default:
                System.out.println("\n Has d'introduïr un valor correcte: ");
                break;      
        }        
        
    }
}
