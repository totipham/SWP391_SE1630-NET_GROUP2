/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 19, 2022         1.0           NgocCMHE161386     First Implement
 */


package model;

/**				
 * The class contains attributes and getter, setter, toString method of a Feedback				
 * 				
 * The method will throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author NgocCMHE161386				
 */
public class Feedback {
    private int id;
    private Property propertyId;
    private User userId;
    private String header;
    private String comment;
    private int star;

    public Feedback() {
    }

    /**
     *
     * @param id
     * @param propertyId
     * @param userId
     * @param header
     * @param comment
     * @param star
     */
    public Feedback(int id, Property propertyId, User userId, String header, String comment, int star) {
        this.id = id;
        this.propertyId = propertyId;
        this.userId = userId;
        this.header = header;
        this.comment = comment;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", propertyId=" + propertyId + ", userId=" + userId 
                + ", header=" + header + ", comment=" + comment + ", star=" + star + '}';
    }
           
}
