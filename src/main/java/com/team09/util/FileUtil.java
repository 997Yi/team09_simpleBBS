package com.team09.util;


import org.apache.commons.fileupload.FileItem;

import java.io.*;

/**
 * @author team09
 */
public class FileUtil {

    private static final String PATH = System.getProperty("user.dir") + "/src/main/webapp/";

    static{
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

    public static String readContent(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(PATH + "/WEB-INF/content/"+ fileName));

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while((line = reader.readLine()) != null){
            stringBuffer.append(line);
        }

        return stringBuffer.toString();
    }


    public static String saveImg(FileItem fileItem) throws Exception {
        String fileName = System.currentTimeMillis() + ".png";

        File file = new File(PATH + "image/" + fileName);
        fileItem.write(file);

        return fileName;
    }

    public static String getImg(String fileName){
        return PATH + "image/" + fileName;
    }
}
