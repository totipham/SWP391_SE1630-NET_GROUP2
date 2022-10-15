package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author totipham
 */
public class Property {

    private int id;
    private String name;
    private int total;
    private double area;
    private double price;
    private PropertyType type;
    private PropertyStatus status;
    private ArrayList<PropertyImage> images;
    private String address;
    private String description;
    private User host;
    private Date createdDate;
    private List<PropertyUtility> utilities;

    public Property(String name, User host, String address, String description, double price, double area, int total, Date createdDate) {
        this.name = name;
        this.host = host;
        this.address = address;
        this.description = description;
        this.area = area;
        this.price = price;
        this.createdDate = createdDate;
        this.total = total;
    }

    public Property(int id, String name, int total, double area, double price, PropertyType type, PropertyStatus status, ArrayList<PropertyImage> images, String address, String description, User host, Date createdDate, List<PropertyUtility> utilities) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.area = area;
        this.price = price;
        this.type = type;
        this.status = status;
        this.images = images;
        this.address = address;
        this.description = description;
        this.host = host;
        this.createdDate = createdDate;
        this.utilities = utilities;
    }

    public Property() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public PropertyStatus getStatus() {
        return status;
    }

    public void setStatus(PropertyStatus status) {
        this.status = status;
    }

    public ArrayList<PropertyImage> getImages() {
        return images;
    }

    public void setImages(ArrayList<PropertyImage> images) {
        this.images = images;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<PropertyUtility> getUtilities() {
        return utilities;
    }

    public void setUtilities(List<PropertyUtility> utilities) {
        this.utilities = utilities;
    }

    @Override
    public String toString() {
        return "Property{" + "id=" + id + ", name=" + name + ", total=" + total + ", area=" + area + ", price=" + price + ", type=" + type + ", status=" + status + ", images=" + images + ", address=" + address + ", description=" + description + ", host=" + host + ", createdDate=" + createdDate + ", utilities=" + utilities + '}';
    }

}
