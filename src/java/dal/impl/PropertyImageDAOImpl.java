package dal.impl;

import java.util.ArrayList;
import model.PropertyImage;

/**
 *
 * @author totipham
 */
public interface PropertyImageDAOImpl {

    ArrayList<PropertyImage> getImagesByPID(int pid);
}
