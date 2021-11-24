package naver.captcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.json.JSONObject;


	//5.아이디/시크릿/키/그림문자 전송
	//6. 네이버는 성공/실패 여부 반환(JSON) 형식
public class Ex03_ApiCaptchaNKeyResult {

	public static void main(String[] args) {

		String clientId = "ed6tJy6Zob4RjScbwaLh";
		String clientSecret= "6WwYogktUC";
		
		String code = "1";// 키 발급 "0", 이미지 비교 "1"
		String key = "wuyuJGkD9QwZdwPx";
		String value = "9423C";   // 그림문자
		
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code="+code + "&key=" +key+ "&value=" +value;
		
		// 요청 헤더(request header) : 아이디,시크릿 
		Map<String, String> requestHeaders = new HashMap<String, String>();   // new HashMap(); 이것도 가능
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		
		
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);    //MalformedURLException
			con = (HttpURLConnection)url.openConnection();   //IOException
			con.setRequestMethod("GET");
			
			for(Map.Entry<String, String> entry : requestHeaders.entrySet()) {
				con.setRequestProperty(entry.getKey(), entry.getValue());
			}	
//			con.setRequestProperty("X-Naver-Client-Id", clientId);     위의 문장과 같다
//			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {//200
//				InputStream is = con.getInputStream();    //  바이트기반 보조 스트림
//				InputStreamReader isr = new InputStreamReader(is);  // 문자 보조 스트림
//				InputStreamReader isr = new InputStreamReader(con.getInputStream());  
				
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // 위에 세 문장을 한줄로.
				
				StringBuilder sb = new StringBuilder();
				
				while(true) {
					String line = br.readLine();
					if(line == null) {
						break;
					}
					sb.append(line); // 비로소 결과가 저장된다.
				}
				System.out.println("네이버로부터 반환 받은 데이터 : " + sb);
				//-------------------------------------------------------------
				JSONObject obj = new JSONObject(sb.toString());				
				boolean result = (boolean)obj.get("result");
				System.out.println(result);
				//-------------------------------------------------------------
				
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream())); 
				StringBuilder sb = new StringBuilder();

				while(true) {
					String line = br.readLine();
					if(line == null) {
						break;
					}
					sb.append(line); // 비로서 결과가 저장된다.
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
