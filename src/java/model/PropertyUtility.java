/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Sep 29, 2022         1.0           DucPTMHE160517     First Implement
 */
package model;

/**				
 * The class contains attribute of Property Utility			
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if 
 * there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author DucPTMHE160517				
 */
public class PropertyUtility {

    private int id;
    private int pid;
    private String name;
    private double price;
    private String period;

    public PropertyUtility() {
    }

    public PropertyUtility(int pid, String name, double price, String period) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.period = period;
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

    @Override
    public String toString() {
        return "PropertyUtility{" + "id=" + id + ", pid=" + pid + ", name=" + name + ", price=" + price + ", period=" + period + '}';
    }
    
    

}
