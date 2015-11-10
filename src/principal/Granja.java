/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import personal.Operari;
import animals.Animal;
import edificis.Nau;
import java.util.Scanner;
import operacions.Registre;
import personal.Tecnic;


/**
 *
 * @author MiguelAngel
 */
public class Granja {

    static private Integer comptaCodi = 1; //El proper codi a assignar
    private Integer codi;
    private String nom;
    private String adreça;
    private Element[] elements = new Element[10];
    private Integer comptaElements = 0;
    private Registre[] registres = new Registre[100];
    private Integer comptaRegistres = 0;

    public Granja(String nom, String adreça) {
        this.codi = Granja.getComptaCodi();
        setComptaCodi();
        this.nom = nom;
        this.adreça = adreça;
    }
    public Granja(Integer codi, String nom, String adreça) {
        this.codi=codi;
        this.nom = nom;
        this.adreça = adreça;        
    }

    public static Integer getComptaCodi() {
        return comptaCodi;
    }

    public static void setComptaCodi() {
        Granja.comptaCodi++;
    }

    public Integer getCodi() {
        return codi;
    }

    public void setCodi(Integer codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }

    public Integer getComptaElements() {
        return comptaElements;
    }

    public void setComptaElements(Integer comptaElements) {
        this.comptaElements = comptaElements;
    }

    public Registre[] getRegistres() {
        return registres;
    }

    public void setRegistres(Registre[] registres) {
        this.registres = registres;
    }

    public Integer getComptaRegistres() {
        return comptaRegistres;
    }

    public void setComptaRegistres(Integer comptaRegistres) {
        this.comptaRegistres = comptaRegistres;
    }

    
    
    public static Granja novaGranja() {
        Scanner teclado = new Scanner(System.in);
        String nomGranja;
        String adreçaGranja;
        System.out.println("Nom de l'granja:");
        nomGranja = teclado.next();
        System.out.println("Adreça de l'granja:");
        adreçaGranja = teclado.next();
        return new Granja(nomGranja, adreçaGranja);
    }

    public void modificaGranja() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nNom de l'granja és: " + this.getNom());
        System.out.println("\nEntra el nou nom:");
        this.setNom(teclado.next());
        System.out.println("\nAdreça de l'granja és: " + this.getAdreça());
        System.out.println("\nEntra la nova adreça:");
        this.setAdreça(teclado.next());
    }

    public void mostraGranja() {
        System.out.println("\nLes dades de l'Granja amb codi " + this.getCodi() + " són:");
        System.out.println("\nNom:" + this.getNom());
        System.out.println("\nAdreça:" + this.getAdreça());
    }

    /*
     Tecnics
     */
    public void nouTecnic(Tecnic tecnic) {
        if (tecnic==null){
            elements[comptaElements] = Tecnic.nouTecnic();
            try {
                seleccionaTecnic(((Tecnic)elements[comptaElements]).getNif());
            } catch (GranjaExcepcio e){
                System.out.println(e.getMessage());
            }
            comptaElements++;  
        } else {
            try {
                seleccionaTecnic(tecnic.getNif());
                elements[comptaElements]=tecnic;
                comptaElements++;
            } catch(GranjaExcepcio e){
                System.out.println(e.getMessage());
            }
        }

    }


    /*
     Operaris
     */
    public void nouOperari(Operari operari) {
        if (operari==null){
            elements[comptaElements] = Operari.nouOperari();
            comptaElements++;  
        } else {
            elements[comptaElements]=operari;
                comptaElements++;
        }
    }



    /*
     Animals
     */
    public void nouAnimal(Animal animal) {
        if (animal==null){
            elements[comptaElements] = Operari.nouOperari();
            comptaElements++;  
        } else {
            elements[comptaElements]=animal;
                comptaElements++;
        }
    }


    /*
     Naus
     */
    public void nouNau(Nau nau) {
        if (nau==null){
            elements[comptaElements] = Operari.nouOperari();
            comptaElements++;  
        } else {
            elements[comptaElements]=nau;
                comptaElements++;
        }
    }

    public Integer seleccionaElement(Integer tipusElement, String codi) {
        Scanner teclado = new Scanner(System.in);
        Integer laClasse = tipusElement;
        boolean parametre = false;
        String codiSel = null;         
        if (codi!=null){
            parametre=true;
            codiSel=codi;
        }
        switch (laClasse) {
            case 0:
                System.out.println("\nQuè vols seleccionar?:");
                System.out.println("1. Tècnic:");
                System.out.println("2. Operari:");
                System.out.println("3. Animal:");
                System.out.println("4. Nau:");
                laClasse = teclado.nextInt();
                break;
            case 1:
                if (!parametre){
                  System.out.println("Nif del Tècnic?:");
                  codiSel = teclado.next();
                }
                break;
            case 2:
                if (!parametre){
                  System.out.println("Nif de l'Operari?:");
                  codiSel = teclado.next();
                }
                break;
            case 3:
                if (!parametre){
                  System.out.println("Codi de l'Animal?:");
                  codiSel = teclado.next();
                }
                break;
            case 4:
                if (!parametre){
                  System.out.println("Codi de la Nau?:");
                  codiSel = teclado.next();
                }
                break;
        }
        Integer indexSel = -1;
        for (int i = 0; i < comptaElements; i++) {
            if (elements[i] instanceof Tecnic && laClasse == 1) {
                if (((Tecnic) elements[i]).getNif().equals(codiSel)) {
                    indexSel = i;
                    break;
                }
            }
            if (elements[i] instanceof Operari && laClasse == 2) {
                if (((Operari) elements[i]).getNif().equals(codiSel)) {
                    indexSel = i;
                    break;
                }
            }
            if (elements[i] instanceof Animal && laClasse == 3) {
                if (((Animal) elements[i]).getCodi().equals(codiSel)) {
                    indexSel = i;
                    break;
                }
            }
            if (elements[i] instanceof Nau && laClasse == 4) {
                if (((Nau) elements[i]).getCodi().equals(codiSel)) {
                    indexSel = i;
                    break;
                }
            }
        }
        return indexSel;
    }
    
    

    public void afegeixElementNau(Integer tipusElement) {
        Nau nauSel = null;
        Integer indexSelNau = this.seleccionaElement(4,"");
        if (indexSelNau >= 0) {
            nauSel = (Nau) this.getElements()[indexSelNau];
        } else {
            System.out.println("\nNo existeix aquesta nau");
        }
        Integer indexSel = this.seleccionaElement(tipusElement,"");
        if (indexSel >= 0) {
            nauSel.afegeixElementNau(this.getElements()[indexSel]);
        } else {
            System.out.println("\nNo existeix aquest element");
        }
    }

    public void afegeixRegistre() {
        registres[comptaRegistres] = Registre.nouRegistre();
        comptaRegistres++;
    }
    
    public Integer seleccionaTecnic(String preNif) throws GranjaExcepcio {
        int ret=0;
        for (int i = 0; i < comptaElements; i++) {
            if (elements[i] instanceof Tecnic) {
                if (((Tecnic) elements[i]).getNif().equals(preNif))
                throw new GranjaExcepcio("3");
            } else {
                ret = -1;
            }
        }
        return ret;
    }

}

