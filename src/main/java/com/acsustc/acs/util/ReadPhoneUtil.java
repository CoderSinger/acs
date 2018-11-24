package com.acsustc.acs.util;

import java.awt.*;
import java.io.*;
import java.math.BigDecimal;

/**
 * @author wong
 * @date 2018/11/21
 */
public class ReadPhoneUtil {
    /**
     * 从txt文本中读取电话号码
     * @param filePath
     */
    public static void ReadPhoneFromTxt(String filePath){
        File txtFile = new File(filePath);// 读取文件
        InputStream in = null;
        InputStreamReader read = null;
        BufferedReader bufferReader = null;
        String tempLine = "";// 每一行的内容

        try {
            String encoding = "GBK";
            if (txtFile.isFile() && txtFile.exists()) {//判断文件是否存在
                in = new FileInputStream(txtFile);
                read = new InputStreamReader(in, encoding);// 构建文件缓存
                bufferReader = new BufferedReader(read);

                // 循环遍历txt文件
                while ((tempLine = bufferReader.readLine()) != null) {
                    String[] split = tempLine.split(",");// 以,作为分隔符
                    System.out.print(split[0]);
                    System.out.println(split[1]);
                }
            }else{
                //to do something
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (read != null) {
                    read.close();
                }
                if (bufferReader != null) {
                    bufferReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
   /* public static void main(String[] args){
        ReadPhoneUtil readPhoneUtil=new ReadPhoneUtil();
        readPhoneUtil.ReadPhoneFromTxt("C:\\Users\\HelloWorld\\Desktop\\phone.txt");
    }*/
}
