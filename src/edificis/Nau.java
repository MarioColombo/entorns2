/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edificis;

import personal.Operari;
import animals.Animal;
import java.util.*;
import personal.Tecnic;
import principal.Element;

/**
 *
 * @author MiguelAngel
 */
public class Nau implements Element {

    private String codi;
    private String nom;
    private ArrayList <Element> elements = new ArrayList <Element>();

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    
    


    public Nau(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
    }

    public static Nau nouNau() {
        Scanner teclado = new Scanner(System.in);
        String codiNau;
        String nomNau;
        System.out.println("Codi de la nau:");
        codiNau = teclado.next();
        System.out.println("Nom de la nau:");;
        nomNau = teclado.next();
        return new Nau(codiNau, nomNau);
    }

    public void afegeixElementNau(Element element) {
        elements.add(element);
    }

    public void modificaElement() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nCodi de la nau és: " + this.getCodi());
        System.out.println("\nEntra el nou nif:");
        this.setCodi(teclado.next());
        System.out.println("\nNom de la nau és: " + this.getNom());
        System.out.println("\nEntra el nou nom:");
        this.setNom(teclado.next());
    }

    public void mostraElement() {
        System.out.println("\nLes dades de la nau amb codi " + this.getCodi() + " són:");
        System.out.println("\nNom:" + this.getNom());
        System.out.println("Aquesta nau està formada pels elements:");
        ListIterator<Element> ltr = elements.listIterator();
        while(ltr.hasNext()) {
            System.out.println(ltr.next());
        }
        }
    }

