

package model;

/**
 *
 * @author totipham
 */
public class PropertyType {
    private int id;
    private String type;

    public PropertyType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropertyType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "PropertyType{" + "id=" + id + ", type=" + type + '}';
    }

}
