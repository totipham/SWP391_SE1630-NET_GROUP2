

package model;

import java.util.ArrayList;

/**
 *
 * @author totipham
 */
public class PropertyImage {
    private int propertyId;
    private String fileName;

    public PropertyImage() {
    }

    public PropertyImage(int propertyId, String fileName) {
        this.propertyId = propertyId;
        this.fileName = fileName;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "PropertyImage{" + "propertyId=" + propertyId + ", fileName=" + fileName + '}';
    }
    
    

}
