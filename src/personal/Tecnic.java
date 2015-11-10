/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal;

import java.util.Scanner;

/**
 *
 * @author MiguelAngel
 */
public class Tecnic extends Persona {

    public Tecnic(String nif, String nom, String cognom) {
        super(nif, nom, cognom);
    }

    public static Tecnic nouTecnic() {
        Scanner teclado = new Scanner(System.in);
        String nifTecnic;
        String nomTecnic;
        String cognomTecnic;
        System.out.println("Nif del tècnic:");
        nifTecnic = teclado.next();
        System.out.println("Nom del tècnic:");;
        nomTecnic = teclado.next();
        System.out.println("Cognom del tècnic:");
        cognomTecnic = teclado.next();
        return new Tecnic(nifTecnic, nomTecnic, cognomTecnic);
    }

}
