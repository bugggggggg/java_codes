package com.codespace.judger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class GenerateFileUtil {

    public static void main(String[] args) {
        generate("111\n222","cpp");
    }

    public static void generate(String code,String language){

        try{
            OutputStream outputStream=new FileOutputStream("submitFile/cplusplus/hello"+"."+language);

            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(code);
            bufferedWriter.flush();
            bufferedWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
