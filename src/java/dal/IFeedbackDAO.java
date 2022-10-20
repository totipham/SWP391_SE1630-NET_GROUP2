/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Oct 14, 2022         1.0           NgocCMHE161386     First Implement
 */
package dal;

import java.util.List;
import model.Feedback;
/**
 * The class contains method to get, send, edit, delete feedback from DB
 *
 * The method will throw an object of <code>java.lang.Exception</code> class if
 * there is any error
 * <p>
 * Bugs: Haven't found yet
 *
 * @author NgocCMHE161386
 */
public interface IFeedbackDAO {
    
    /**
     *
     * @param propertyId
     * @return
     * @throws Exception
     */
    public List<Feedback> getFeedbackByPropertyId(int propertyId) throws Exception;
    
    /**
     *
     * @param feedbackId
     * @return
     * @throws Exception
     */
    public Feedback getFeedbackByFeedbackID(int feedbackId) throws Exception;
    
    /**
     *
     * @param propertyId
     * @param userId
     * @param header
     * @param comment
     * @param star
     * @throws Exception
     */
    public void sendFeedback(int propertyId, int userId, String header, String comment, int star) throws Exception;
    
    /**
     *
     * @param feedbackId
     * @throws Exception
     */
    public void deleteFeedback(int feedbackId) throws Exception;
    
    /**
     *
     * @param feedbackId
     * @throws Exception
     */
    public void editFeedback(int feedbackId) throws Exception;
    
}
