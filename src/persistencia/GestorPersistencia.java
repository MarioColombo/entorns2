/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import principal.Granja;
import principal.GranjaExcepcio;



/**
 *
 * @author MiguelAngel
 */
public class GestorPersistencia {
    private GestorXML gestor;

    public GestorXML getGestor() {
        return gestor;
    }

    public void setGestor(GestorXML gestor) {
        this.gestor = gestor;
    }
        
    

    public void desarGranja(String tipusPersistencia, String nomFitxer, Granja granja) throws GranjaExcepcio {
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.desarGranja(nomFitxer, granja);
        }
    }

    public void carregarGranja(String tipusPersistencia, String nomFitxer) throws GranjaExcepcio {
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.carregarGranja(nomFitxer);
        }
    }
}
