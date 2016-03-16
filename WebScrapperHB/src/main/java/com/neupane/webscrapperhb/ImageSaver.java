/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.webscrapperhb;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author parlad
 */
public class ImageSaver {

    public static void saveTOImage(String imageUrl, String imageName) throws IOException {
        try {
            URL url = new URL(imageUrl.trim());
            URLConnection conn = url.openConnection();

            InputStream inStream = conn.getInputStream();

            byte[] b = new byte[1024];
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            int i = 0;
            while ((i = inStream.read(b)) != -1) {
                outStream.write(b, 0, i);

            }
            outStream.close();
            inStream.close();
            byte[] response = outStream.toByteArray();
            String path = "F:/Directory/images/";
            System.out.println(path + imageName);
            File file = new File(path);
            file.mkdirs();
            FileOutputStream fos = new FileOutputStream(path + imageName);
            fos.write(response);
            fos.close();
            System.out.println("Saveing Image");
        } catch (IOException e) {
            e.getMessage();
        }

    }

}
