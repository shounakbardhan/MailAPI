package com.hsbc.group.tooling.gqep.controller;


import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.group.tooling.gqep.bean.MailInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value="Mail Controller", description="Controller's handle resquest For Sending mail")
@RestController
public class MailController 
{
	
	
	
	@ApiOperation(value = "For Sending mail with Report File attached to it.")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Mail Send"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
			})
	@CrossOrigin("*")
	@PostMapping("api/sendmail")
	public Responsemessage sendmail(@RequestBody MailInput mailinput)
	{
		Responsemessage mess;
		
		String to=mailinput.getTomail();
		System.out.println(to);
		to.trim();
		String from=mailinput.getFrommail();
		from.trim();
		System.out.println(from);
		String subject=mailinput.getSubject();
		String body=mailinput.getBody();
		String CC=mailinput.getCc();
		CC.trim();
		
		System.out.println(to+"   "+from+" "+CC);
		String arr[]=to.split(";");
		String cc[]=CC.split(";");
		for (String string : arr) 
		{
			System.out.println(string);
			
		}
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "app-smtp-exchange.hk.hsbc");
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(true);
		MimeMessage msg = new MimeMessage(session);
		

		try {
			
			
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(from));

			for(int i=0;i<arr.length;i++)
			{
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(arr[i]));
			
			}
			System.out.println("CC length"+cc.length);
			if(cc.length>=1)
				{
				for(int i=0;i<cc.length;i++) 
				{
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
				}
			}
			//BodyPart msg2=new MimeBodyPart();
			msg.setText(body);

			
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(msg2);
			
			// msg2 = new MimeBodyPart();
			//String filename = "D:\\Tomcat\\apache-tomcat-8.5.23\\webapps\\ROOT\\PerfHTMLReports\\"+reportname1+"\\"+reportname1+".zip";
	         //String filename = "C:\\Temp\\test.txt";
			
			//String filename = "C:\\Users\\45068668\\Desktop\\SCREENSHOT\\Tomcat\\apache-tomcat-8.5.23\\webapps\\ROOT\\PerfHTMLReports\\"+reportname1+"_REPORT\\"+reportname1+"_REPORT.zip";
//	         DataSource source = new FileDataSource(filename);
//	         msg2.setDataHandler(new DataHandler(source));
//	         msg2.setFileName(new File(filename).getName());
//	         multipart.addBodyPart(msg2);
//
//	         // Send the complete message parts
//	         msg.setContent(multipart);
			
			msg.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect();

			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			 mess=new Responsemessage("Mail Send");
			

		} catch (Exception ex) {
			System.out.println("Exception occured");
			ex.printStackTrace();
			String message =ex.getMessage();
			 mess=new Responsemessage(message);
		}
		
		return mess;
	}
	
	
}