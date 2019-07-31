package com.junit5.app.webclient;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

public class WebServiceClientJersey {

	public List<String> callEmailWebService() {
		List<String> result=new ArrayList<String>();
		final Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		final String targetIP = "https://shramsuvidha.gov.in";
		final String targetURI = "/sms-email-gateway/1.0/webservices/bulkemail/withattachment";
		final File file=new File("C://Users//Admin//Desktop//Linux notes.pdf");

		
		try {
			client.property(ClientProperties.CONNECT_TIMEOUT, 30000); // Setting Connection timed out equivalent to request timed out 30 seconds
			client.property(ClientProperties.READ_TIMEOUT, 30000);// Setting read timed out equivalent it server not
																	// responding in specified time 30 seconds
			final WebTarget target = client.target(URLDecoder.decode(targetIP.concat(targetURI), StandardCharsets.UTF_8.toString()));
			final FileDataBodyPart form  = new FileDataBodyPart("file", file);
			form.setContentDisposition(FormDataContentDisposition.name("file").fileName("linux-book-mater.pdf").build());
			final String emailParameters = "{ \"accessKey\" :\"Uwin.SSP.19\", \"dataSourceAgencyName\":\"NIC\", \"contentType\":\"text/html\", \"to\":\"write2sirfsushil@gmail.com\", \"cc\":\"sushil_bhaskar@hotmail.com\", \"bcc\":\"write2sirfsushil@gmail.com\", \"subject\":\"email attachment service\" , \"emailBody\":\"Email With Attachment service\" }";
			@SuppressWarnings("resource")
			final MultiPart multipartEntity = new FormDataMultiPart().field("emailParameters", emailParameters, MediaType.MULTIPART_FORM_DATA_TYPE).bodyPart(form);
			final Response response = target.request().post(Entity.entity(multipartEntity, multipartEntity.getMediaType()));
			result.add(String.valueOf(response.getStatus()));
			result.add(response.readEntity(String.class));
			multipartEntity.cleanup();
			multipartEntity.close();
			return result;
		} catch (Exception rpc) {
			rpc.printStackTrace();
			return null;
		}

	}
	

}
