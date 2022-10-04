package dal;

import java.util.ArrayList;
import model.PropertyImage;

/**
 *
 * @author totipham
 */
public interface IPropertyImageDAO {

    ArrayList<PropertyImage> getImagesByPID(int pid);
}
