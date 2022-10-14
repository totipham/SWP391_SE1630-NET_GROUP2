/*
 * Copyright(C) 2022, FPT University.
 * Hostalpy
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * Sept 29, 2022   1.0                 DucPTMHE160517   First Implement
 */
package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

/**				
 * The class contains method find update, delete, upload images			
 * 				
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data				
 * <p>Bugs: Haven't found yet				
 *				
 * @author DucPTMHE160517				
 */

public class FileUtility {

    /**
     *
     * @param part
     * @param folder
     * @return
     * @throws IOException
     */
    public String upLoad(Part part, String folder) throws IOException {
        String file = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        Path path = Paths.get(folder);

        //check if path is not existed
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File outputFilePath = new File(Paths.get(path.toString(), file).toString());
            
            //Check if this filename has existed
            if (outputFilePath.exists()) {
                Random random = new Random();
                file = random.nextInt(1000000000) + "-" + file.replaceAll("\\s+", "-");
                outputFilePath = new File(Paths.get(path.toString(), file).toString()); //set new name
            }
            inputStream = part.getInputStream();
            outputStream = new FileOutputStream(outputFilePath);
            int read = 0;
            final byte[] bytes = new byte[1024];
            
            //keep read bytes from input stream until it equals to -1
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (Exception e) {
            file = "";
            throw e;
        } finally {
            
            //check if output stream is not null
            if (outputStream != null) {
                outputStream.close();
            }
            
            //check if input stream is not null
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return file;
    }

    /**
     *
     * @param fileName
     * @param folder
     * @throws IOException
     */
    public void delete(String fileName, String folder) throws IOException {
        Path path = Paths.get(folder);
        try {
            File file = new File(Paths.get(path.toString(), fileName).toString());
            file.delete();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param UPLOAD_DIR
     * @param request
     * @return
     */
    public List<String> uploadFiles(String UPLOAD_DIR, HttpServletRequest request) {
        List<String> fileNames = new ArrayList<String>();
        try {
            List<Part> parts = (List<Part>) request.getParts();
            if (parts.size() <= 0) {
                return new ArrayList<String>();
            }
            for (Part part : parts) {
                System.out.println(part.getName());
                if (part.getName().equalsIgnoreCase("images")) {
                    String fileName = getFileName(part);
                    if (fileName == null || fileName.equals("") || fileName.isEmpty()) {
                        return new ArrayList<String>();
                    }
                    String applicationPath = request.getServletContext().getRealPath("");
                    String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
                    InputStream inputStream = null;
                    OutputStream outputStream = null;
                    try {
                        File outputFilePath = new File(basePath + fileName);
                        if (outputFilePath.exists()) {
                            Random random = new Random();
                            fileName = random.nextInt(1000000000) + "-" + fileName.replaceAll("\\s+", "-");
                            outputFilePath = new File(basePath + fileName);
                        }
                        fileNames.add(fileName);
                        inputStream = part.getInputStream();
                        outputStream = new FileOutputStream(outputFilePath);
                        int read = 0;
                        final byte[] bytes = new byte[1024];
                        while ((read = inputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, read);
                        }
                    } catch (Exception ex) {
                        fileName = null;
                    } finally {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                }
            }
        } catch (Exception e) {
            fileNames = null;
        }
        return fileNames;
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
