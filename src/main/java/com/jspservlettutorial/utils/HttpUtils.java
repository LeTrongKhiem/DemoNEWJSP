package com.jspservlettutorial.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
    private String value;

    public HttpUtils(String value) {
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);// ham dc goi ben porm.xml truyen vao 2 gia tri l� value
            // va
            // kieu du lieu
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print(e.getMessage());
        }
        return null;

    }

    public static HttpUtils of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        return new HttpUtils(sb.toString());
    }

}
