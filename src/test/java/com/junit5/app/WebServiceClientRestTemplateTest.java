package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit5.app.webclient.WebServiceClientRestTemplate;

public class WebServiceClientRestTemplateTest {

	private WebServiceClientRestTemplate webServiceClient=null;
	
	@BeforeEach
	void init() {
		webServiceClient=new WebServiceClientRestTemplate();
	}
		
	@Test
	@DisplayName("Email with attachment test")
	void webServiceClientCallEmailWebService() {
		List<String> expected=new ArrayList<String>();
		expected.add("200 OK");
		expected.add("{\"message\":{\"statusCode\":\"1001\",\"statusMessage\":\"Email has been sent with attachment\",\"referenceNumber\":\"true\"}}");
		
		assertEquals(expected, webServiceClient.callEmailWebService(),"test failed case");
		webServiceClient.callEmailWebService();
	}
	@AfterEach
	void destroy() {
		webServiceClient=null;
	}
	
}
