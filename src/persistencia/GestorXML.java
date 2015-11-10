/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import principal.Granja;
import principal.GranjaExcepcio;
import personal.*;
import animals.Animal;
import edificis.Nau;

public class GestorXML implements ProveedorPersistencia {

    private Document doc;
    private Granja granja;

    public Granja getGranja() {
        return granja;
    }

    public void setGranja(Granja granja) {
        this.granja = granja;
    }
    

    @Override
    public void desarGranja(String nomFitxer, Granja granja) throws GranjaExcepcio {
        construeixModel(granja);
        desaModel(nomFitxer);
    }

    @Override
    public void carregarGranja(String nomFitxer) throws GranjaExcepcio {
        carregaFitxer(nomFitxer);
        fitxerGranja();
    }

    private void construeixModel(Granja granja) throws GranjaExcepcio {
        
        //Es construeix el document model
        //Creació del document
        try {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc = builder.newDocument();
        } catch (Exception e){
            System.out.println("Error en la creació del document: " +e.getMessage());
        }
        
        try {
            //Element arrel
            Element arrel = doc.createElement("Granja");
            doc.appendChild(arrel);
            Granja granjaActual = getGranja();

            //Afegim els atributs
            arrel.setAttribute("codi", String.valueOf(granjaActual.getCodi()));
            arrel.setAttribute("nom", granjaActual.getNom());
            arrel.setAttribute("adreça", granjaActual.getAdreça());

            // Fem un recorregut per els elements de granja
            for (int i = 0;i < granjaActual.getComptaElements();i++){
                if (granjaActual.getElements()[i] instanceof Tecnic){
                    //Elemement tecnic fill d'arrel
                    Element tecnic = doc.createElement("Tecnic");
                    tecnic.setAttribute("nif", null);
                    tecnic.setAttribute("nom", null);
                    tecnic.setAttribute("cognom", null);
                    arrel.appendChild(tecnic);
                } else if (granjaActual.getElements()[i] instanceof Operari){
                    //Elemement operari fill d'arrel
                    Element operari = doc.createElement("Operari");
                    operari.setAttribute("nif", null);
                    operari.setAttribute("nom", null);
                    operari.setAttribute("cognom", null);
                    arrel.appendChild(operari);
                }  else if (granjaActual.getElements()[i] instanceof Animal){
                    //Elemement animal fill d'arrel
                    Element animal = doc.createElement("Animal");
                    animal.setAttribute("codi", null);
                    animal.setAttribute("nom", null);
                    animal.setAttribute("cognom", null);
                    arrel.appendChild(animal);  
                } else if (granjaActual.getElements()[i] instanceof Nau){
                    //Elemement nau fill d'arrel
                    Element nau = doc.createElement("Nau");
                    nau.setAttribute("coi", null);
                    nau.setAttribute("nom", null);
                    nau.setAttribute("cognom", null);
                    arrel.appendChild(nau);
                    //Instanciem la nau actual
                    Nau nauActual = (Nau)granjaActual.getElements()[i];
                    do {
                        if (nauActual.getElements().listIterator().next() instanceof Tecnic) {
                            Element tecnic = doc.createElement("Tecnic");
                            tecnic.setAttribute("nif", null);
                            tecnic.setAttribute("nom", null);
                            tecnic.setAttribute("cognom", null);
                            nau.appendChild(tecnic);

                        } else if (nauActual.getElements().listIterator().next() instanceof Operari){
                            //Elemement operari fill d'nau
                            Element operari = doc.createElement("Operari");
                            operari.setAttribute("nif", null);
                            operari.setAttribute("nom", null);
                            operari.setAttribute("cognom", null);
                            nau.appendChild(operari);
                        }  else if (nauActual.getElements().listIterator().next() instanceof Animal){
                            //Elemement animal fill d'nau
                            Element animal = doc.createElement("Animal");
                            animal.setAttribute("codi", null);
                            animal.setAttribute("especie", null);
                            animal.setAttribute("alt", null);
                            animal.setAttribute("pes", null);
                            nau.appendChild(animal);  
                        } 

                    } while (nauActual.getElements().listIterator().hasNext());
            }
            }
        } catch (Exception ex) {
                throw new GranjaExcepcio("GestorXML.model");
                }        
    }

    private void desaModel(String nomFitxer) throws GranjaExcepcio {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            File f = new File(nomFitxer + ".xml");
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (Exception ex) {
            throw new GranjaExcepcio("GestorXML.desar");
        }
    }

    private void carregaFitxer(String nomFitxer) throws GranjaExcepcio {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            File f = new File(nomFitxer + ".xml");
            doc = builder.parse(f);
        } catch (Exception ex) {
            throw new GranjaExcepcio("GestorXML.carrega");
        }
    }

    private void fitxerGranja() throws GranjaExcepcio {
        try {
            Element arrel = doc.getDocumentElement();
            int codi = Integer.parseInt(arrel.getAttribute("codi"));
            String nom = arrel.getAttribute("nom");
            String adreca = arrel.getAttribute("adreça");
            Granja granjaActual = new Granja (codi,nom,adreca);
            // Anem a recuperar els tecnics
            NodeList tecnics = arrel.getElementsByTagName("tecnic");
            for (int i = 0;i < tecnics.getLength();i++){
                Element elem = (Element)tecnics.item(i);
                String tecnicNif = elem.getAttribute("nif");
                String tecnicNom = elem.getAttribute("nom");
                String tecnicCognom = elem.getAttribute("cognom");
                Tecnic tecnicActual = new Tecnic(tecnicNif,tecnicNom,tecnicCognom);
                granjaActual.nouTecnic(tecnicActual);
                }
            // Anem a recuperar els operaris
            NodeList operaris = arrel.getElementsByTagName("operari");
            for (int i = 0;i < operaris.getLength();i++){
                Element elem = (Element)operaris.item(i);
                String operariNif = elem.getAttribute("nif");
                String operariNom = elem.getAttribute("nom");
                String operariCognom = elem.getAttribute("cognom");
                Operari operariActual = new Operari(operariNif,operariNom,operariCognom);
                granjaActual.nouOperari(operariActual);
                }
            // Anem a recuperar els animals
            NodeList animals = arrel.getElementsByTagName("animal");
            for (int i = 0;i < animals.getLength();i++){
                Element elem = (Element)animals.item(i);
                String animalCodi = elem.getAttribute("codi");
                String animalEspecie = elem.getAttribute("especie");
                float animalPes = Float.parseFloat(elem.getAttribute("pes"));
                float animalAlt = Float.parseFloat(elem.getAttribute("alt"));
                Animal animalActual = new Animal(animalCodi,animalEspecie,animalPes,animalAlt);
                granjaActual.nouAnimal(animalActual);
                }
            // Anem a recuperar les naus i els seus elements
            NodeList naus = arrel.getElementsByTagName("nau");
            for (int i = 0;i < naus.getLength();i++){
                Element elem = (Element)naus.item(i);
                String nauNif = elem.getAttribute("nif");
                String nauNom = elem.getAttribute("nom");
                Nau nauActual = new Nau(nauNif,nauNom);
                granjaActual.nouNau(nauActual);
                // De la nau actual afegim els elements pertinents
                NodeList nauTecnics = elem.getElementsByTagName("tecnic");
                for (int j = 0;j < nauTecnics.getLength();i++){
                elem = (Element)nauTecnics.item(i);
                String tecnicNif = elem.getAttribute("nif");
                String tecnicNom = elem.getAttribute("nom");
                String tecnicCognom = elem.getAttribute("cognom");
                Tecnic tecnicActual = new Tecnic(tecnicNif,tecnicNom,tecnicCognom);
                nauActual.afegeixElementNau(tecnicActual);
                }
                NodeList nauOperaris = elem.getElementsByTagName("operari");
                for (int j = 0;j < nauOperaris.getLength();i++){
                elem = (Element)nauOperaris.item(i);
                String operariNif = elem.getAttribute("nif");
                String operariNom = elem.getAttribute("nom");
                String operariCognom = elem.getAttribute("cognom");
                Operari operariActual = new Operari(operariNif,operariNom,operariCognom);
                nauActual.afegeixElementNau(operariActual);                
                }
                NodeList nauAnimals = elem.getElementsByTagName("animal");
                for (int j = 0;j < nauAnimals.getLength();i++){
                elem = (Element)nauAnimals.item(i);
                String animalCodi = elem.getAttribute("codi");
                String animalEspecie = elem.getAttribute("especie");
                float animalPes = Float.parseFloat(elem.getAttribute("pes"));
                float animalAlt = Float.parseFloat(elem.getAttribute("alt"));
                Animal animalActual = new Animal(animalCodi,animalEspecie,animalPes,animalAlt);
                nauActual.afegeixElementNau(animalActual);                
            }
            }
            } catch (Exception e){
                throw new GranjaExcepcio("GestorXML.carrega");
        }

    }

}
