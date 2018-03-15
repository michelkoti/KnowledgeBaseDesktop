/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knowledgebase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Michel
 */
public class ContentInfo {

    private final StringProperty idCt;
    private final StringProperty shortDesc;
    private final StringProperty detDesc;
    private final StringProperty typeCt;
    
    //Default Constructors
    public ContentInfo(String idCt, String shortDesc, String detDesc, String typeCt) {

        this.idCt = new SimpleStringProperty(idCt);
        this.shortDesc = new SimpleStringProperty(shortDesc);
        this.detDesc = new SimpleStringProperty(detDesc);
        this.typeCt = new SimpleStringProperty(typeCt);

        
    }

    //Getters
    public String getIdCt() {
        return idCt.get();
    }

    public String getShortDesc() {
        return shortDesc.get();
    }

    public String getDetDesc() {
        return detDesc.get();
    }
    public String getTypeCt() {
        return typeCt.get();
    }

    //Setters
    public void setIdCt(String value) {
        idCt.set(value);
    }
    
    public void setShortDesc(String value) {
        shortDesc.set(value);
    }

    public void setDetDesc(String value) {
        detDesc.set(value);
    }
    
    public void setTypeCt(String value) {
        typeCt.set(value);
    }

    //Property values
    public StringProperty idCtProperty() {
        return idCt;
    }
    
    public StringProperty shortDescProperty() {
        return shortDesc;
    }

    public StringProperty detDescProperty() {
        return detDesc;
    }
    
    public StringProperty typeCtProperty() {
        return typeCt;
    }

}
