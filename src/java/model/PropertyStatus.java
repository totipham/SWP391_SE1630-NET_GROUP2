

package model;

/**
 *
 * @author totipham
 */
public class PropertyStatus {
    private int id;
    private String status;

    public PropertyStatus() {
    }

    public PropertyStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PropertyStatus{" + "id=" + id + ", status=" + status + '}';
    }

}
