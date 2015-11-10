package principal;

import animals.Animal;
import edificis.Nau;
import personal.Operari;
import java.util.Scanner;
import persistencia.GestorPersistencia;
import personal.Tecnic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MiguelAngel
 */
public class Aplicacio {
    
    static private String FITXER = "granjapersist";
    static private Granja[] granges = new Granja[1];
    static private Integer comptaGranges = 0;
    static private Granja granjaActual = null;
    static private Integer tipusElement = 0;
    static private GestorPersistencia gp = new GestorPersistencia();

    

    /**
     * @param args the command line arguments
     * @throws principal.GranjaExcepcio
     */
    public static void main(String[] args) {
        try{
            menuPrincipal();  
        } catch (GranjaExcepcio e){
            System.out.println(e.getMessage());  
        }
    }

    private static void menuPrincipal() throws GranjaExcepcio{
        Integer opcio = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de granges");
            System.out.println("\n2. Gestió dels tècnics");
            System.out.println("\n3. Gestió dels operaris");
            System.out.println("\n4. Gestió d'animals");
            System.out.println("\n5. Gestió de naus");
            if (teclado.hasNextInt()){
            opcio = teclado.nextInt();
            } else {
                throw new GranjaExcepcio("1");
            }
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuGranja();
                    break;
                case 2:
                    if (granjaActual != null) {
                        tipusElement = 1;
                        menuElement();
                    } else {
                        System.out.println("\nPrimer s'ha de fixar l'granja al menú Granja");
                    }
                    break;
                case 3:
                    if (granjaActual != null) {
                        tipusElement = 2;
                        menuElement();
                    } else {
                        System.out.println("\nPrimer s'ha de fixar l'granja al menú Granja");
                    }
                    break;
                case 4:
                    if (granjaActual != null) {
                        tipusElement = 3;
                        menuElement();
                    } else {
                        System.out.println("\nPrimer s'ha de fixar l'granja al menú Granja");
                    }
                    break;
                case 5:
                    if (granjaActual != null) {
                        tipusElement = 4;
                        menuNaus();
                    } else {
                        System.out.println("\nPrimer s'ha de fixar l'granja al menú Granja");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuGranja() throws GranjaExcepcio {
        Integer opcio = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            Integer indexSel = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Fixa Granja");
            System.out.println("\n3. Modificació");
            System.out.println("\n4. Llista de granges");
            System.out.println("\n5. Carrega granja");
            System.out.println("\n6. Desa granja");            
            if (teclado.hasNextInt()){
                opcio = teclado.nextInt();
            } else {
                throw new GranjaExcepcio("1");
            }
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    if (comptaGranges < granges.length){
                        granges[comptaGranges] = Granja.novaGranja();
                        comptaGranges++;  
                    } else {
                        throw new GranjaExcepcio("2");
                    }
                    break;
                case 2:
                    indexSel = seleccionaGranja();
                    if (indexSel >= 0) {
                        granjaActual = granges[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta granja");
                    }
                    break;
                case 3:
                    indexSel = seleccionaGranja();
                    if (indexSel >= 0) {
                        granges[indexSel].modificaGranja();
                    } else {
                        System.out.println("\nNo existeix aquesta granja");
                    }
                    break;
                case 4:
                    for (int i = 0; i < comptaGranges; i++) {
                        granges[i].mostraGranja();
                    }
                    break;
                case 5: //Carregar granja
                    comptaGranges = 0;
                    granges = new Granja[1];
                    gp.carregarGranja("XML", FITXER);
                    granges[comptaGranges] = gp.getGestor().getGranja();
                    comptaGranges++;
                    break;
                case 6: //Desar granja
                    indexSel = seleccionaGranja();
                    if (indexSel >= 0) {
                        gp.desarGranja("XML", FITXER, granges[indexSel]);
                    } else {
                        System.out.println("\nNo existeix aquesta granja");
                    }
                    break;                    
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuElement()throws GranjaExcepcio  {
        Integer opcio = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificació");
            System.out.println("\n3. Llista");
            if (teclado.hasNextInt()){
                opcio = teclado.nextInt();
            } else {
                throw new GranjaExcepcio("1");
            }            
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    switch (tipusElement) {
                        case 1:
                            granjaActual.nouTecnic(null);
                            break;
                        case 2:
                            granjaActual.nouOperari(null);
                            break;
                        case 3:
                            granjaActual.nouAnimal(null);
                            break;
                    }
                    break;
                case 2:
                    Integer indexSel = granjaActual.seleccionaElement(tipusElement, "");
                    if (indexSel >= 0) {
                        granjaActual.getElements()[indexSel].modificaElement();
                    } else {
                        System.out.println("\nNo existeix aquest tecnic");
                    }
                    break;
                case 3:
                    for (int i = 0; i < granjaActual.getComptaElements(); i++) {
                        if (granjaActual.getElements()[i] instanceof Tecnic && tipusElement == 1) {
                            granjaActual.getElements()[i].mostraElement();
                        }
                        if (granjaActual.getElements()[i] instanceof Operari && tipusElement == 2) {
                            granjaActual.getElements()[i].mostraElement();
                        }
                        if (granjaActual.getElements()[i] instanceof Animal && tipusElement == 3) {
                            granjaActual.getElements()[i].mostraElement();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuNaus() throws GranjaExcepcio {
        Integer opcio = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Afegeix tecnic");
            System.out.println("\n3. Afegeix operari");
            System.out.println("\n4. Afegeix animal");
            System.out.println("\n5. Llista de naus");
            if (teclado.hasNextInt()){
                opcio = teclado.nextInt();
            } else {
                throw new GranjaExcepcio("1");
            }   
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    granjaActual.nouNau(null);
                    break;
                case 2:
                    granjaActual.afegeixElementNau(1);
                    break;
                case 3:
                    granjaActual.afegeixElementNau(2);
                    break;
                case 4:
                    granjaActual.afegeixElementNau(3);
                    break;
                case 5:
                    for (int i = 0; i < granjaActual.getComptaElements(); i++) {
                        if (granjaActual.getElements()[i] instanceof Nau) {
                            granjaActual.getElements()[i].mostraElement();
                        }

                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static Integer seleccionaGranja() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nCodi de granja?:");
        Integer codiSel = teclado.nextInt();
        Integer indexSel = -1;
        for (int i = 0; i < comptaGranges; i++) {
            if (granges[i].getCodi() == codiSel) {
                indexSel = i;
                break;
            }
        }
        return indexSel;
    }

}
