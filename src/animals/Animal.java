/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import principal.Element;

/**
 *
 * @author MiguelAngel
 */
public class Animal implements Element{

    private String codi;
    private String especie;
    private Float pes;
    private Float alt;

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }


    public Float getPes() {
        return pes;
    }

    public void setPes(Float pes) {
        this.pes = pes;
    }

    public Float getAlt() {
        return alt;
    }

    public void setAlt(Float alt) {
        this.alt = alt;
    }
    

    public Animal(String codi, String especie, Float pes, Float alt) {
        this.codi = codi;
        this.especie = especie;
        this.pes = pes;
        this.alt = alt;
    }

    public static Animal nouAnimal() {
        Scanner teclado = new Scanner(System.in);
        String codi;
        String especie;
        Date datanaixement = null;
        Float pes;
        Float alt;
        System.out.println("Codi de l'animal:");
        codi = teclado.next();
        System.out.println("Espècie de l'animal:");
        especie = teclado.next();
        System.out.println("Pes de l'animal:");
        pes = teclado.nextFloat();
        System.out.println("Alçada de l'animal:");
        alt = teclado.nextFloat();
        return new Animal(codi, especie, pes, alt);
    }

    public void modificaElement() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nCodi de l'animal és: " + this.getCodi());
        System.out.println("\nEntra el nou codi:");
        this.setCodi(teclado.next());
        System.out.println("\nEspècie de l'animal és: " + this.getEspecie());
        System.out.println("\nEntra la nova espècie:");
        this.setEspecie(teclado.next());       
        System.out.println("\nPes de l'animal és: " + this.getPes());
        System.out.println("\nEntra el nou pes:");
        this.setPes(teclado.nextFloat());
        System.out.println("\nAlçada de l'animal és: " + this.getAlt());
        System.out.println("\nEntra la nova alçada:");
        this.setAlt(teclado.nextFloat());
    }

    public void mostraElement() {
        System.out.println("\nLes dades del animal amb codi " + this.getCodi() + " són:");
        System.out.println("\nEspècie: " + this.getEspecie());
        System.out.println("\nPes: " + this.getPes());
        System.out.println("\nAlçada: " + this.getAlt());
    }
    

}
