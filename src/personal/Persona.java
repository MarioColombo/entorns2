/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal;

import java.util.Scanner;
import principal.*;

/**
 *
 * @author MiguelAngel
 */
public abstract class Persona implements Element {

    private String nif;
    private String nom;
    private String cognom;

    public Persona(String nif, String nom, String cognom) {
        this.nif = nif;
        this.nom = nom;
        this.cognom = cognom;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }


    public void modificaElement() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\nNif és: " + this.getNif());
        System.out.println("\nEntra el nou nif:");
        this.setNif(teclado.next());
        System.out.println("\nNom és: " + this.getNom());
        System.out.println("\nEntra el nou nom:");
        this.setNom(teclado.next());
        System.out.println("\nCognom és: " + this.getCognom());
        System.out.println("\nEntra el nou cognom:");
        this.setCognom(teclado.next());
    }

    public void mostraElement() {
        String laClasse = this.getClass().getSimpleName();
        System.out.println("\nLes dades de "+laClasse+" amb nif " + this.getNif() + " són:");
        System.out.println("\nNom:" + this.getNom());
        System.out.println("\nCognom:" + this.getCognom());
    }

}
