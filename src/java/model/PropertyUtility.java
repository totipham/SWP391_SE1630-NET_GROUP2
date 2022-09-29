

package model;

/**
 *
 * @author totipham
 */
public class PropertyUtility {
    private int id;
    private int pid;
    private String name;
    private double price;
    private String period;

    public PropertyUtility() {
    }

    public PropertyUtility(int id, int pid, String name, double price, String period) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.period = period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
    
    
}
