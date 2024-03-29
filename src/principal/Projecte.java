/*
 * Classe que defineix un projecte. Un projecte es defineix per un codi, NIF del
 * del client que ha encarregat el projecte, si està finalitzat o no, el pressupost 
 * i el dissenyador encarregat en desenvolupar-lo. A més, contindrà un vector de 
 * jardiners encarregats d'implementar el projecte.
 */
package principal;

import components.Dissenyador;
import components.Jardiner;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Projecte {

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nifClient;
    private boolean finalitzat;
    private double pressupost;
    private Dissenyador dissenyador;
    private Jardiner[] jardiners = new Jardiner[40];
    private int posicioJardiners = 0; //Priemra posició buida del vector jardiners
    
     /* atribut constant DADES de tipus Scanner */
    static private Scanner DADES = new Scanner(System.in);
    
     /*
     TODO
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys el vector, el
     codi i finalitzat.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - Quan es crea un projecte aquest mai està finalitzat, per tant, assignarem
     fals a l'atribut finalitzat.
     - Quan es crea un projecte no té cap dissenyador assignat.
     */
    
    public Projecte (String nfCli,double press){
    
        codi = properCodi; 
        nifClient = nfCli;
        finalitzat = false;
        pressupost = press;
        dissenyador = null;
        //Jardiner[] jardiners = new Jardiner[40];
        posicioJardiners = 0;
        
        //actualitzar propercodi amb el seguent codi a assignar.
        
        properCodi ++;
    
    }
    /*
     TODO Mètodes accessors    
     */
    public int getCodi(){

            return codi;
        }  
    public void setDissenyador(Dissenyador dis){
        
        dissenyador = dis;
    
    }
    
     /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou projecte. Les dades
     a demanar són les que passem per paràmetre en el constructor.
     Retorn: El nou projecte creat.
     */
    public static Projecte addProjecte() {
        
        System.out.println("Introdueix les dades per crear un nou projecte");
        System.out.println("\n Introdueix les dades que es demanen i pulsa [ENTER]");
        System.out.println("\n Nif del client: ");
        String nifClient = DADES.nextLine();
        System.out.println("\n Pressupost del projecte: ");
        System.out.println("\n Escriu la quantitat en el següent format : 1500.00 ");
        double pressupost = DADES.nextDouble();
        
        Projecte nouProjecte = new Projecte (nifClient,pressupost);
        
        return nouProjecte;
    }
    
    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     només es pot modificar el NIF del client, si està finalitzat o no i el pressupost.
     - En el cas de finalitzat o no, li heu de demanar a l'usuari que si el projecte està  
     finalitzat, introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte actual, 
     abans de modificar-los. En el cas de l'atribut finalitzat, li heu de mostrar
     el missatge: "\nEl projecte està finalitzat", si el projecte s'ha finalitzat,
     i en cas contrari, el missatge "\nEl projecte no està finalitzat".
     Retorn: cap
     */
    public void updateProjecte() {
        
        showProjecte();
        
        System.out.println("Introdueix les dades per modificar projecte");
        System.out.println("\n Introdueix les dades que es demanen i pulsa [ENTER]");
        System.out.println("\n Nif del client: ");
        nifClient = DADES.nextLine();
        System.out.println("\n Pressupost del projecte: ");
        System.out.println("\n Escriu la quantitat en el següent format : 1500.00 ");
        pressupost = DADES.nextDouble();
        System.out.println("\n Aquest projecte esta finalitzat? "
                + "\n Introduex 1 si esta finalitzat" 
                + "\n Introdueix 0 si no esta finalitzat" );
        int projFin = DADES.nextInt();
        
        switch (projFin){
            case 1:
                finalitzat = true;
                break;
            case 0:
                finalitzat = false;
                break;
            default:
                System.out.println("\n Has d'introduïr un valor correcte: ");
                break;      
        }
    }

    /*
     TODO
     Paràmetres: jardiner o jardinera a afegir
     Accions:
     - afegeix al vector jardiners del projecte actual el jardiner o jardinera
     passat/ada per paràmetre.
     - actualitza la posició del vector jardiners.
     Retorn: cap
     */
    public void addJardiner(Jardiner jar) {
        
        
        jardiners[posicioJardiners] = jar;
        
        posicioJardiners++;

    }

    public void showProjecte() {
        System.out.println("\nLes dades del projecte amb codi " + codi + " són:");
        System.out.println("\nNIF client: " + nifClient);
        System.out.println("\nPressupost: " + pressupost);
        System.out.println("\nEl seu dissenyador es: ");
        dissenyador.showDissenyador();
        
        if(finalitzat){
            System.out.println("\nEl projecte està finalitzat");
        }else{
            System.out.println("\nEl projecte no està finalitzat");
        }
        System.out.println("\nEls seus jardiners son: ");
        for (int i = 0; i < posicioJardiners; i++) { 
            jardiners[i].showJardiner();
        }
    }
    
}
