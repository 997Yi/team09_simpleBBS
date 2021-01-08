package com.team09.util;


import java.io.*;

/**
 * @author team09
 */
public class FileUtil {

    private static final String PATH = System.getProperty("user.dir") + "/src/main/webapp/WEB-INF/content/";

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
        File file = new File(PATH + fileName);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.close();

        return fileName;
    }

    public static String readContent(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName));

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while((line = reader.readLine()) != null){
            stringBuffer.append(line);
        }

        return stringBuffer.toString();
    }
}
