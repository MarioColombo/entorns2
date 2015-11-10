/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacions;

import animals.Animal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MiguelAngel
 */
public class Registre {

    private Integer codi;
    private Date dataRegistre;
    private String tipusMesura;
    private String animal;
    private Float valor;

    public Registre(Integer codi, Date dataRegistre, String tipusMesura, String animal, Float valor) {
        this.codi = codi;
        this.dataRegistre = dataRegistre;
        this.tipusMesura = tipusMesura;
        this.animal = animal;
        this.valor = valor;
    }

    public Integer getCodi() {
        return codi;
    }

    public void setCodi(Integer codi) {
        this.codi = codi;
    }

    public Date getDataRegistre() {
        return dataRegistre;
    }

    public void setDataRegistre(Date dataRegistre) {
        this.dataRegistre = dataRegistre;
    }

    public String getTipusMesura() {
        return tipusMesura;
    }

    public void setTipusMesura(String tipusMesura) {
        this.tipusMesura = tipusMesura;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public static Registre nouRegistre() {
        Scanner teclado = new Scanner(System.in);
        Integer codi;
        Date dataRegistre = null;
        String tipusMesura;
        String animal;
        Float valor;
        System.out.println("Codi del registre:");
        codi = teclado.nextInt();
        System.out.println("Tipus de mesura:");
        tipusMesura = teclado.next();
        System.out.println("Animal:");
        animal = teclado.next();
        System.out.println("Valor del registre:");
        valor = teclado.nextFloat();
        System.out.println("Data del registre (dd/mm/aaaa):");
        String dateFormat = "dd/MM/yyyy";
        try {
            dataRegistre = new SimpleDateFormat(dateFormat).parse(teclado.next());
        } catch (Exception e) {
        }

        return new Registre(codi, dataRegistre, tipusMesura, animal, valor);
    }

}
