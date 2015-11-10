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
public class Operari extends Persona {

    public Operari(String nif, String nom, String cognom) {
        super(nif, nom, cognom);
    }

    public static Operari nouOperari() {
        Scanner teclado = new Scanner(System.in);
        String nifOperari;
        String nomOperari;
        String cognomOperari;
        System.out.println("Nif de l'operari:");
        nifOperari = teclado.next();
        System.out.println("Nom de l'operari:");;
        nomOperari = teclado.next();
        System.out.println("Cognom de l'operari:");
        cognomOperari = teclado.next();
        return new Operari(nifOperari, nomOperari, cognomOperari);
    }


}
