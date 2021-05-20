package com.mmi.profiles.util;

import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Commons {

    public String savePicture(MultipartFile profilePicture, String username) {
        String fileExtension = profilePicture.getOriginalFilename().split("\\.")[1];
        String pictureDir = "C:\\Users\\Public\\"+username.substring(0,3)+"."+fileExtension;
        File file = new File(pictureDir);
        try(FileOutputStream outputStream = new FileOutputStream(file)){
            outputStream.write(profilePicture.getBytes());
            return pictureDir;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    public void deleteOldProfile(String oldPath) {
        try{
            Files.delete(Paths.get(oldPath));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
