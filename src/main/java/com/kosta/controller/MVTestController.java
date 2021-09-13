package com.kosta.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MVTestController {
	@GetMapping("/test")
	public String test() {
		return "movie/test";
	}
	@GetMapping("/mov")
	public String mov() {
		return "movie/movieList";
	}
	@GetMapping("/imageView/{movieCd}/{title}")
    public String getImage(@PathVariable String movieCd,@PathVariable String title, Model model) {
	   String clientId = "HYX4a9ygamLFJItnu0gY"; 
       String clientSecret = "vIJnIW_G5B";

       String text =null;
       try {
           text = URLEncoder.encode(title, "UTF-8");
       } catch (UnsupportedEncodingException e2) {
           throw new RuntimeException("검색어 인코딩 실패",e2);
       }


       String apiURL = "https://openapi.naver.com/v1/search/movie?query=" + text;    // json 결과
       //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


       Map<String, String> requestHeaders = new HashMap<>();
       requestHeaders.put("X-Naver-Client-Id", clientId);
       requestHeaders.put("X-Naver-Client-Secret", clientSecret);
       String responseBody = get(apiURL,requestHeaders);
       
 //      System.out.println(responseBody);
 
     
       //추가
       JSONArray getArray = new JSONArray();
       try {
       	JSONParser parser = new JSONParser();
			Object obj = parser.parse(responseBody);
			
			JSONObject jsonObj = (JSONObject) obj;
			getArray = (JSONArray) jsonObj.get("items");
			
//		   for (int i = 0; i < getArray.size(); i++) {
               JSONObject object = (JSONObject) getArray.get(0);

               String getTitle = (String) object.get("title");
               String image = (String) object.get("image");
               
               if(getTitle.contains(title)) {
            	   model.addAttribute("movieCd",movieCd);
            	   model.addAttribute("mvImg",image);
               }
 //           }
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	return "movie/imageView";
      
   }

	@ResponseBody
	@GetMapping("/imageList/{title}")
    public String imageList(@PathVariable String title) {
	   String clientId = "HYX4a9ygamLFJItnu0gY"; 
       String clientSecret = "vIJnIW_G5B";

       String text =null;
       try {
           text = URLEncoder.encode(title, "UTF-8");
       } catch (UnsupportedEncodingException e2) {
           throw new RuntimeException("검색어 인코딩 실패",e2);
       }


       String apiURL = "https://openapi.naver.com/v1/search/movie?query=" + text;    // json 결과
       //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


       Map<String, String> requestHeaders = new HashMap<>();
       requestHeaders.put("X-Naver-Client-Id", clientId);
       requestHeaders.put("X-Naver-Client-Secret", clientSecret);
       String responseBody = get(apiURL,requestHeaders);
       
 //      System.out.println(responseBody);
 
     
       //추가
       JSONArray getArray = new JSONArray();
       String image = "";
       try {
       	JSONParser parser = new JSONParser();
			Object obj = parser.parse(responseBody);
			
			JSONObject jsonObj = (JSONObject) obj;
			getArray = (JSONArray) jsonObj.get("items");
			
               JSONObject object = (JSONObject) getArray.get(0);

               String getTitle = (String) object.get("title");
               image = (String) object.get("image");
               

			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	return image;
      
   }

   private static String get(String apiUrl, Map<String, String> requestHeaders){
       HttpURLConnection con = connect(apiUrl);
       try {
       	
           con.setRequestMethod("GET");
           for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
               con.setRequestProperty(header.getKey(), header.getValue());
           }
           
           int responseCode = con.getResponseCode();
           if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
               return readBody(con.getInputStream());
           } else { // 에러 발생
               return readBody(con.getErrorStream());
           }
       } catch (IOException e) {
           throw new RuntimeException("API 요청과 응답 실패", e);
       } finally {
           con.disconnect();
       }
   }


   private static HttpURLConnection connect(String apiUrl){
       try {
           URL url = new URL(apiUrl);
           return (HttpURLConnection)url.openConnection();
       } catch (MalformedURLException e) {
           throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
       } catch (IOException e) {
           throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
       }
   }


   private static String readBody(InputStream body){
       InputStreamReader streamReader = new InputStreamReader(body);


       try (BufferedReader lineReader = new BufferedReader(streamReader)) {
           StringBuilder responseBody = new StringBuilder();


           String line;
           while ((line = lineReader.readLine()) != null) {
               responseBody.append(line);
           }


           return responseBody.toString();
       } catch (IOException e) {
           throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
       }
}
   }
