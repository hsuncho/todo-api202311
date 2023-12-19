package com.example.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class application {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://www.easylaw.go.kr/OPENAPI/soap/ManyAskManyAnswerService"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=CvK%2FiB1LyyFNkphbe6RXp6Mdy6u9UYHoXfns7Zs6U5Tz4Au5x%2BLRGwqfJD3P7EFP1PlRGN4WWmGhG1rG%2B5XJPA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("RequestMsgID","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*요청메세지ID-조회 시 필요 없는 파라미터입니다.*/
        urlBuilder.append("&" + URLEncoder.encode("RequestTime","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*요청시간-조회 시 필요 없는 파라미터입니다.*/
        urlBuilder.append("&" + URLEncoder.encode("CallBackURI","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*콜백URI-조회 시 필요 없는 파라미터입니다.*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-type", "text/xml; charset=utf-8");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}