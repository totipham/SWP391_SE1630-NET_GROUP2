package utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author totipham
 */
public class ValidateUtility {

    public String getField(HttpServletRequest request, String fieldName, boolean required,
            int minLength, int maxLength) throws Exception {
        String value = null;

        value = request.getParameter(fieldName).trim();

        //check if value is null or value is empty
        if (value == null || value.trim().isEmpty()) {
            if (required) {
                String error = "Field " + fieldName + " is required";
                throw new Exception(error);
            } else {
                value = null; // Make empty string null so that you don't need to hassle with equals("") afterwards.
            }
        }

        //check if length of value is out of min length and max length
        if (minLength != maxLength) {
            if (value.length() < minLength || value.length() > maxLength) {
                throw new Exception(fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1, fieldName.length()).toLowerCase())
                        + " must between " + minLength + " and " + maxLength);
            }
        }
        else{
            throw new Exception(fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1, fieldName.length()).toLowerCase())
                        + " must has length is " + minLength );
        }

        return value;
    }

    public String getFieldByType(HttpServletRequest request, String type, String field,
            boolean required, int minLength, int maxLength) throws Exception {
        String regexPattern;
        String value = getField(request, field, true, minLength, maxLength);
        switch (type) {
            case "phone":

                //^0: matches 0 at the begining
                //[139]{1}: matches one of [3,5,7,8,9] at the next
                //[0-9]{8}$: matches 8 elements as number digit at the last
                //Accept 10 digit phone number start with 0, next is one of 1, 3, 9
                regexPattern = "^0[35789]{1}[0-9]{8}$";
                break;
            case "email":

                //^[a-zA-Z0-9]: matches a-z, A-Z, 0-9 from beginning
                //+@: matches  @ at the next
                //[a-z]{2,6}: matches 2 to 6 characters from a - z
                //[a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$
                // matches 0 or more of the preceding token
                //Accept email format which start with string username, character @
                //and domain
                regexPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
                break;
            default:
                regexPattern = "";
        }

        //check if regex pattern is empty
        if (regexPattern.isEmpty()) {
            return value;
        }

        //Check if input string maches regex pattern type
        if (value.matches(regexPattern)) {
            return value;
        } else {
            throw new Exception(type.substring(0, 1).toUpperCase().concat(type.substring(1, type.length()).toLowerCase())
                    + " not matches " + type + " format!");
        }
    }

    public Part getFieldAjaxFile(HttpServletRequest request, String fieldName, boolean required) throws Exception {
        Part value = null;
        value = request.getPart(fieldName);
        if (value == null) {
            if (required) {
                String error = "Field " + fieldName + " is required";
                throw new Exception(error);
            } else {
                value = null; // Make empty string null so that you don't need to hassle with equals("") afterwards.
            }
        }
        return value;
    }

    public String getFieldAjax(HttpServletRequest request, String fieldName, boolean required) throws Exception {
        String value = null;
        value = request.getParameter(fieldName);
        if (value == null || value.trim().isEmpty()) {
            if (required) {
                String error = "Field " + fieldName + " is required";
                throw new Exception(error);
            } else {
                value = null; // Make empty string null so that you don't need to hassle with equals("") afterwards.
            }
        }
        return value;
    }

    public int fieldInt(String value, String message) throws Exception {
        int number = 0;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new Exception(message);
        }
        return number;
    }

    public double fieldDouble(String value, String message) throws Exception {
        double number = 0;
        try {
            number = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new Exception(message);
        }
        return number;
    }

    public String fieldString(String value, String regex, String message) throws Exception {
        if (!value.matches(regex)) {
            throw new Exception(message);
        }
        return value;
    }

    public boolean fieldBoolean(String value, String message) throws Exception {
        boolean bool = false;
        try {
            bool = Boolean.parseBoolean(value);
        } catch (Exception e) {
            throw new Exception(message);
        }
        return bool;
    }

    public Date fieldDate(String value, String message) throws Exception {
        Date date = null;
        try {
            date = Date.valueOf(value);
        } catch (Exception e) {
            throw new Exception(message);
        }
        return date;
    }

    public Timestamp fieldTimestamp(String value, String message) throws Exception {
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(new java.util.Date(Long.parseLong(value)).getTime());
        } catch (Exception e) {
            throw new Exception(message);
        }
        return timestamp;
    }
}
