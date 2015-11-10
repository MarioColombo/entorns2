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
public interface ProveedorPersistencia {
    public void desarGranja(String nomFitxer, Granja granja) throws GranjaExcepcio;
    public void carregarGranja(String nomFitxer) throws GranjaExcepcio;
    
    
}
