package com.junit5.app.webclient;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
/*import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;*/
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class WebServiceClientRestTemplate {

	public RestTemplate RestTemplateProvider() {
		RestTemplate restTemplate=new RestTemplate();
		/*
		 * MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
		 * MappingJackson2HttpMessageConverter();
		 * mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
		 * MediaType.APPLICATION_JSON,
		 * MediaType.APPLICATION_OCTET_STREAM,MediaType.TEXT_PLAIN));
		 * restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		 */
		return restTemplate;
	}
	
	public List<String> callEmailWebService() {
		List<String> result=new ArrayList<String>();
		final String targetIP = "https://shramsuvidha.gov.in";
		final String targetURI = "/sms-email-gateway/1.0/webservices/bulkemail/withattachment";
		final FileSystemResource value = new FileSystemResource(new File("C://Users//Admin//Desktop//Linux notes.pdf"));
		final String emailParameters = "{ \"accessKey\" :\"Uwin.SSP.19\", \"dataSourceAgencyName\":\"NIC\", \"contentType\":\"text/html\", \"to\":\"write2sirfsushil@gmail.com\", \"cc\":\"sushil_bhaskar@hotmail.com\", \"bcc\":\"write2sirfsushil@gmail.com\", \"subject\":\"email attachment service\" , \"emailBody\":\"Email With Attachment service\" }";

		
		try {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA); 
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("emailParameters", emailParameters);
        body.add("file", value);
        
        
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = RestTemplateProvider().postForEntity(URLDecoder.decode(targetIP.concat(targetURI),StandardCharsets.UTF_8.toString()), requestEntity, String.class);
        //ResponseEntity<String> response = RestTemplateProvider().exchange(URLDecoder.decode(targetIP.concat(targetURI),StandardCharsets.UTF_8.toString()),HttpMethod.POST, requestEntity, String.class); 
			result.add(String.valueOf(response.getStatusCode()));
			result.add(response.getBody());
			return result;
		} catch (Exception rpc) {
			rpc.printStackTrace();
			return null;
		}

	}
	
	
	@SuppressWarnings("unused")
	private static Resource getTestFile() throws IOException {
        Path testFile = Files.createTempFile("test-file", ".txt");
        System.out.println("Creating and Uploading Test File: " + testFile);
        Files.write(testFile, "Hello World !!, This is a test file.".getBytes());
        return new FileSystemResource(testFile.toFile());
    }
	

}



