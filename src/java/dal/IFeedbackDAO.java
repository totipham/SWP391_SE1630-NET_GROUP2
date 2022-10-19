/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal;

import java.util.List;
import model.Feedback;

/**
 *
 * @author User
 */
public interface IFeedbackDAO {
    
    public List<Feedback> getFeedbackByPropertyId(int pid) throws Exception;
    
    public Feedback sendFeedback(int pid, int uid) throws Exception;
    
    public void deleteFeedback(int feedbackId) throws Exception;
    
    public void editFedback(Feedback feedback) throws Exception;
    
}
