package naver.captcha;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Ex02_ApiCaptchaImage {
	
	
//	3. 아이디/시크릿/ 발급받은 키 전송 및 이미지 요청
//	4. 네이버가 이미지 발급해 줌
	public static void main(String[] args) {
		
		String clientId = "ed6tJy6Zob4RjScbwaLh";
		String clientSecret= "6WwYogktUC";
		
		String key = "wuyuJGkD9QwZdwPx";
		String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key="+key;
		
		// 요청 헤더(request header) : 아이디,시크릿 
				Map<String, String> requestHeaders = new HashMap<String, String>();   // new HashMap(); 이것도 가능
				requestHeaders.put("X-Naver-Client-Id", clientId);
				requestHeaders.put("X-Naver-Client-Secret", clientSecret);
				
				
				URL url = null;
				HttpURLConnection con = null;  // 서버를 만들고?
				
				try {
					url = new URL(apiURL);    //MalformedURLException  
					con = (HttpURLConnection)url.openConnection();   //IOException  서버에 접속
					con.setRequestMethod("GET");   //post or get ..
					
					for(Map.Entry<String, String> entry : requestHeaders.entrySet()) {
						con.setRequestProperty(entry.getKey(), entry.getValue());
					}
//					con.setRequestProperty("X-Naver-Client-Id", clientId);     위의 문장과 같다
//					con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
					
					int responseCode = con.getResponseCode();
					if(responseCode == HttpURLConnection.HTTP_OK) {//200
//						
						BufferedInputStream bis =  new BufferedInputStream(con.getInputStream());  //이미지를 읽는..
						String filename = Long.valueOf((new Date()).getTime()).toString() + ".jpg";//..?
						File file = new File(filename);
						BufferedOutputStream bos =  new BufferedOutputStream(new FileOutputStream(file));
						byte[] b = new byte[1024];  // 만약 파일이1030byte라면 ... -> 1024 , 나머지; 6
						int readCount = 0;
						while(true) {
							readCount = bis.read(b);
							if (readCount == -1) {
								break;
							}
							bos.write(b, 0, readCount);  // 실제로 읽어 들인만큼만 output하겠다.
							                            // 1.b의 0번인덱스부터 readcound만큼 - 1024
														// 2. b의 0번 인덱스부터 readcount만큼 - 6
						}
						System.out.println(filename + "이미지 캡챠가 생성 되었습니다.");
						if (bos != null) {
							bos.close();
						}
						if(bis != null) {
							bis.close();
						}
						
					} else {
						BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream())); 
						StringBuilder sb = new StringBuilder();

						while(true) {
							String line = br.readLine();
							if(line == null) {
								break;
							}
							sb.append(line); // 비로소 결과가 저장된다.
						}
						System.out.println("네이버로부터 반환 받은 에러데이터 : " + sb);
					}
					
				} catch (MalformedURLException e) {
					throw new RuntimeException("API URL이 잘못되었습니다. : " + apiURL, e);  // 메인안에 있는 문장이라서 JVM으로 가서 처리를 해준다.
				} catch (IOException e) {
					throw new RuntimeException("연결이 실패했거나, API 응답을 읽는데 실패했습니다. : " + apiURL,e );
				} finally {
					con.disconnect();
				}
				
	}

}
