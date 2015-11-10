/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author professor
 */
public class GranjaExcepcio extends Exception {


    private String codiCausa = "desconegut";
    private String missatge;

    public GranjaExcepcio(String codiCausa) {
        this.codiCausa = codiCausa;
        switch (codiCausa) {
            case "1":
                this.missatge = "L'opció ha de ser correcta";
                break;
            case "2":
                this.missatge = "Ja no hi caben més elements";
                break;
            case "3":
                this.missatge = "El nif està repetit";
                break;
                case "GestorXML.model":
                this.missatge = "No s'ha pogut crear el model XML per desar la Granja";
                break;
            case "GestorXML.desar":
                this.missatge = "No s'ha pogut desar la Granja a causa d'error d'entrada/sortida";
                break;
            case "GestorXML.carrega":
                this.missatge = "No s'ha pogut carregar la Granja a causa d'error d'entrada/sortida";
                break;
            default:
                this.missatge = "Error desconegut";
                break;
        }
    }
    public String getMessage(){
        String inf = "\n El codi de causa és: "+codiCausa+ "\n "+missatge;
        return inf;
    }


}
