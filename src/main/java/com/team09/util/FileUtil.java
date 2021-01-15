package com.team09.util;


import org.apache.commons.fileupload.FileItem;

import javax.servlet.jsp.PageContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author team09
 */
public class FileUtil {

    private static String PATH = "";

    public static void setPath(String path){
        PATH = path;

        File file = new File(PATH);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    /**
     * 存入content内容，并返回文件名
     * @param content
     * @return
     */
    public static String writeContent(String content) throws IOException {
        String fileName = System.currentTimeMillis() + ".txt";
        File file = new File(PATH + "/WEB-INF/content/" + fileName);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.close();

        return fileName;
    }

    public static List<String> readContent(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(PATH + "/WEB-INF/content/"+ fileName));

        List<String> list = new ArrayList<>();
        String line = null;
        while((line = reader.readLine()) != null){
            list.add(new String(line.getBytes(), "UTF-8"));
            list.add(line);
        }

        return list;
    }


    public static String saveImg(FileItem fileItem) throws Exception {
        String fileName = System.currentTimeMillis() + ".png";

        File file = new File(PATH + "/image/" + fileName);
        fileItem.write(file);

        return fileName;
    }

    public static String getImg(String fileName){
        return "/image/" + fileName;
    }
}
