package com.koreait.ex13.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class SecurityUtils {
	
	// 크로스 사이트 스크립트 (XXS)
	// 스크립트 코드 입력 무력화
	
	public String xxs(String str) {
		
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("\"", "&quot;");   //escape"  escape : 역슬래쉬 (인식시키기 위해서..)
		
		return str;
		
	}
	
	// ★자바★ security 암호화/복호화 
	// SHA-256 : 입력 -> 256비트 *64바이트*  암호화 처리  (복구화[복호]는 불가능) 
	// 1바이트 :  2글자로 표현 되므로 DB필드는 64로 설정
	
	public static String sha256(String str) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());    // 문자열을 Byte 배열로 바꿔야할 때 str.getBytes() 메소드를 사용하면 된다..
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		// md.digest() : 입력된 문자열이 암호화된 32바이트 배열
		for(byte b : md.digest()) { // 1 바이트씩 2글자 16진수로 변환		
			// String의 형태 잡기  %02X : 두자리 16진수로 표현하겠다..
			sb.append(String.format("%02X", b));  
		}
		return sb.toString();
	}
	
	
	// ★스프링★ 암호화/복호화   
	// commons-codec 디펜던시
	
	// 암호  : 1111   ----> dsfkjh@%^$#%@#
	public static String encodeBase64(String str) {
		return new String(Base64.encodeBase64(str.getBytes()));  // String인데 byte를 요구하면 getByte쓰기...
	}
	
	// 복호 : dsfkjh@%^$#%@# ----> 1111
	public static String decodeBase64(String str) {
		return new String(Base64.decodeBase64(str.getBytes()));  
	}
	
	// 인증코드 생성
	public static String autoCode(int length) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < length; i++) {
			if(Math.random() < 0.5) {
				sb.append( (char)((int)(Math.random() * 26) + 'A') );  //  'A' : 65
			} else {
				sb.append( (char)((int)(Math.random() * 26) + '0') );  // '0': 48
			}
		}
		return sb.toString();
	}
	
	
}
