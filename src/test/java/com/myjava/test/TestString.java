package com.myjava.test;

import org.junit.Test;

public class TestString {
	@Test
	public void testSubstring(){
		String str = "/OA/login/loginAction_login.action" ;
		System.out.println(str.substring(str.indexOf("/", str.indexOf("/")+1)));
	}
}
