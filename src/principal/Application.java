package principal;

import java.util.Scanner;
import components.Torn;
import components.Dissenyador;
import components.Jardiner;

/**
 *
 * @author root
 */
public class Application {

    static private Estudi[] estudis = new Estudi[4];
    static private int posicioEstudis = 0;
    static private Estudi estudiActual = null;
    
    /* atribut constant DADES de tipus Scanner */
    static private Scanner DADES = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió d'estudis");
            System.out.println("\n2. Gestió de projectes");
            System.out.println("\n3. Gestió de dissenyadors o dissenyadores");
            System.out.println("\n4. Gestió de jardiners o jardineres");
            System.out.println("\n5. Gestió de torns");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuEstudis();
                    break;
                case 2:
                    if (estudiActual != null) {
                        menuProjectes();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 3:
                    if (estudiActual != null) {
                        menuDissenyadors();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 4:
                    if (estudiActual != null) {
                        menuJardiners();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                case 5:
                    if (estudiActual != null) {
                        menuTorns();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar l'estudi al menú Gestió d'estudis");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuEstudis() {
        int opcio = 0;

        do {
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar estudi");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llista d'estudis");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    estudis[posicioEstudis] = Estudi.addEstudi();
                    posicioEstudis++;
                    break;
                case 2:
                    indexSel = selectEstudi();
                    if (indexSel >= 0) {
                        estudiActual = estudis[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquest estudi");
                    }
                    break;
                case 3:
                    indexSel = selectEstudi();
                    if (indexSel >= 0) {
                        estudis[indexSel].updateEstudi();
                    } else {
                        System.out.println("\nNo existeix aquest estudi");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioEstudis; i++) {
                        estudis[i].showEstudi();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO Heu de desenvolupar el menuDissenyadors amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
       
     Opció 0. Sortir -->         Surt del menú i retorna al menú principal
     Opció 1. Alta -->           Crea un dissenyador en l'estudi actual. Penseu que Estudi sap crear dissenyadors o dissenyadores        
     Opció 2. Modificar ->     Permet modificar un dissenyador o dissenyadora que està donat d'alta a l'estudi actual
     (per comprovar l'existència del dissenyador o dissenyadora tenim un mètode en la classe Estudi que ens ajuda)
     Opció 3. Llista de dissenyadors i dissenyadores -> Imprimeix les dades dels dissenyadors i dissenyadores de l'estudi actual
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuDissenyadors() {
        int opcio = 0;
        
        do{
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta dissenyador");
            System.out.println("\n2. Modificar dissenyador");
            System.out.println("\n3. Llista de dissenyadors i dissenyadores");
            opcio = DADES.nextInt();
            
            switch (opcio){
                case 0:
                    break;
                case 1:
                    estudiActual.addDissenyador();
                    break;
                case 2:
                    indexSel = estudiActual.selectDissenyador(null);
                    if (indexSel >=0 ){
                        estudiActual.getDissenyador(indexSel).updateDissenyador();
                    }else{
                        System.out.println("\nNo existeix aquest dissenyador");
                    }
                    break;
                case 3:
                    for (int i =0; i < 10; i++){
                        if (estudiActual.getDissenyador(i)!= null){    

                            estudiActual.getDissenyador(i).showDissenyador();
                        }else {
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
            
        }while (opcio != 0);    
    }

    /*
     TODO Heu de desenvolupar el menuJardiners amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
     
     Opció 0. Sortir -->         Surt del menú i retorna al menú principal
     Opció 1. Alta -->           Crea un jardiner o jardinera en l'estudi actual. Penseu que Estudi sap crear jardiners
     o jardineres.        
     Opció 2. Modificar ->     Permet modificar un jardiner o jardinera que està donat d'alta a l'estudi actual
     (per comprovar l'existència del jardiner o jardinera tenim un mètode en la classe Estudi que ens ajuda)
     Opció 3. Assignar torn ->   Assigna un torn a un jardiner o jardinera, però penseu que Estudi sap com fer-ho.
     Opció 4. Llista de jardiners i jardineres-> Imprimeix les dades dels jardiners i jardineres de l'estudi actual.
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuJardiners() {
        int opcio = 0;
        
        do{
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta jardiner o jardinera");
            System.out.println("\n2. Modificar jardiner o jardinera");
            System.out.println("\n3. Assignar torn");
            System.out.println("\n4. Llista de jardiners i jardineres");
            opcio = DADES.nextInt();
            
            switch (opcio){
                case 0:
                    break;
                case 1:
                    estudiActual.addJardiner();
                    break;
                case 2:
                    indexSel = estudiActual.selectJardiner(null);
                    if (indexSel >=0 ){ 
                        estudiActual.getJardiner(indexSel).updateJardiner();
                    }else{
                        System.out.println("\nNo existeix aquest jardiner");
                    }
                    break;
                case 3:
                    Torn trn = null;
                    indexSel = estudiActual.selectTorn(null);
                    if (indexSel != -1){
                    trn = estudiActual.getTorn(indexSel);
                    }else{
                    System.out.println("\nAquest torn no existeix");
                    break; 
                    }
                    indexSel = estudiActual.selectJardiner(null);
                     if (indexSel != -1){ 
                        estudiActual.getJardiner(indexSel).setTorn(trn);
                    }else{
                        System.out.println("\nAquest Jardiner no existeixen");
                    }
                    break; 
                case 4:
                    for (int i =0; i < 40 ; i++){
                        if (estudiActual.getJardiner(i)!= null){
                            
                            estudiActual.getJardiner(i).showJardiner();
                        
                        }else{
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
            
        }while (opcio!=0);
    }

    /*
     TODO Heu de desenvolupar el menuTorns amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
     
     Opció 0. Sortir -->         Surt del menú i retorna al menú principal
     Opció 1. Alta -->           Crea un torn en l'estudi actual. Penseu que Estudi sap crear torns     
     Opció 2. Modificar ->     Permet modificar un torn que existeix a l'estudi actual
     (per comprovar l'existència del torn tenim un mètode en la classe Estudi que ens ajuda)
     Opció 3. Llista de torns-> Imprimeix les dades dels torns de l'estudi actual.
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuTorns() {
        int opcio = 0;
        
        do{
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta torn de treball");
            System.out.println("\n2. Modificar torn");
            System.out.println("\n3. Llista de torns de treball ");
            opcio = DADES.nextInt();
                        
            switch (opcio){
                case 0:
                    break;
                case 1:
                    estudiActual.addTorn();
                    break;
                case 2:
                    indexSel = estudiActual.selectTorn(null);
                    if (indexSel >=0 ){ 
                        estudiActual.getTorn(indexSel).updateTorn();
                    }else{
                        System.out.println("\nNo existeix aquest torn de feina");
                    }
                    break;
                case 3:
                    for (int i =0; i < 10 ; i++){
                        if (estudiActual.getTorn(i)!= null){    

                            estudiActual.getTorn(i).showTorn();
                        }else {
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
            
        }while(opcio != 0);    
        
    }

    /*
     TODO Heu de desenvolupar el menuProjectes amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut estudiActual no és null
     
     Opció 0. Sortir -->         Surt del menú i retorna al menú principal
     Opció 1. Alta -->           Crea un projecte en l'estudi actual. Penseu que Estudi sap crear projectes      
     Opció 2. Modificar ->     Permet modificar un projecte que existeix a l'estudi actual
     (per comprovar l'existència del projecte tenim un mètode en la classe Estudi que ens ajuda)
     Opció 3. Assignar dissenyador o dissenyadora ->   Assigna un dissenyador o dissenyadora a un projecte, però penseu que Estudi sap com fer-ho.
     Opció 4. Assignar jardiner o jardinera ->   Assigna un jardiner o jardinera a un projecte, però penseu que Estudi sap com fer-ho.
     Opció 5. Llista de projectes-> Imprimeix les dades dels projectes de l'estudi actual.
        
     A més, heu de fer una estructura iterativa per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch-case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable opcio de tipus enter
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, ja que això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     */
    public static void menuProjectes() {
        int opcio = 0;
        
        do{
            int indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta projecte nou");
            System.out.println("\n2. Modificar projecte");
            System.out.println("\n3. Assignar dissenyador o dissenyadora");
            System.out.println("\n4. Assiganar jardiner o jardinera");
            System.out.println("\n5. Llista de projectes");
            opcio = DADES.nextInt();
            
            switch (opcio){
                case 0:
                    break;
                case 1:
                    estudiActual.addProjecte();
                    break;
                case 2:
                    indexSel = estudiActual.selectProjecte(null);
                    if (indexSel >=0){
                    estudiActual.getProjecte(indexSel).updateProjecte();
                    }else{
                    System.out.println("\nNo existeix aquest projecte");
                    }
                    break;
                case 3:
                    Dissenyador dis = null;
                    indexSel = estudiActual.selectDissenyador(null);
                    if(indexSel >=0){
                    dis = estudiActual.getDissenyador(indexSel);
                    }else{
                    System.out.println("\nNo existeix aquest dissenyador");
                    break;
                    }
                    indexSel = estudiActual.selectProjecte(null);
                    if (indexSel >=0){
                    estudiActual.getProjecte(indexSel).setDissenyador(dis);
                    }else{
                    System.out.println("\nNo existeix aquest projecte");    
                    }
                    break;
                case 4:
                    Jardiner jar = null;
                    indexSel = estudiActual.selectJardiner(null);
                    if(indexSel >=0){
                    jar = estudiActual.getJardiner(indexSel);
                    }else{
                    System.out.println("\nNo existeix aquest dissenyador");
                    break;
                    }
                    indexSel = estudiActual.selectProjecte(null);
                    if (indexSel >=0){
                    estudiActual.getProjecte(indexSel).addJardiner(jar);
                    }else{
                    System.out.println("\nNo existeix aquest projecte");    
                    }
                    break;
                case 5:
                    for (int i =0; i < 10 ; i++){
                        if (estudiActual.getProjecte(i)!= null){

                            estudiActual.getProjecte(i).showProjecte();
                        }else {
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
            
        }while (opcio != 0 );
    }

    public static Integer selectEstudi() {

        System.out.println("\nCodi de l'estudi?:");
        int codi = DADES.nextInt();

        for (int i = 0; i < posicioEstudis; i++) {
            if (estudis[i].getCodi() == codi) {
                return i;
            }
        }
        return -1;
    }

}
