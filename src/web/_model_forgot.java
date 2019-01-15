package web;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class _model_forgot {

	
	public String _sender_email_iD = "yourmail@gmail.com";
	public String _sender_password = "yourpassword";
	public String _email_SMTPserver = "smtp.gmail.com";
	public String _email_server_port = "465";
	public String _receiver_email_iD;
	public String _email_subject ="Poll Application: Reset password ";
	public String _email_body;
	
	
	
	
	public String get_sender_email_iD() {
		return _sender_email_iD;
	}

	public void set_sender_email_iD(String senderEmailID) {
		this._sender_email_iD = senderEmailID;
	}

	public String get_sender_password() {
		return _sender_password;
	}

	public void set_sender_password(String senderPassword) {
		this._sender_password = senderPassword;
	}

	public String get_email_SMTPserver() {
		return _email_SMTPserver;
	}

	public void set_email_SMTPserver(String emailSMTPserver) {
		this._email_SMTPserver = emailSMTPserver;
	}

	public String get_email_server_port() {
		return _email_server_port;
	}

	public void set_email_server_port(String emailServerPort) {
		this._email_server_port = emailServerPort;
	}

	public String get_receiver_email_iD() {
		return _receiver_email_iD;
	}

	public void set_receiver_email_iD(String receiverEmailID) {
		this._receiver_email_iD = receiverEmailID;
	}

	public String get_email_subject() {
		return _email_subject;
	}

	public void set_email_subject(String emailSubject) {
		this._email_subject = emailSubject;
	}

	public String get_email_body() {
		return _email_body;
	}

	public void set_email_body(String emailBody) {
		this._email_body = emailBody;
	}






	

	
	
	
	
	
	
	
	//functions i ll need 
	
	//generer un mdp aléatoire 
	public String generate(int length) {
	    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; 
	    String pass = "";
	    for(int x=0;x<length;x++)   {
	       int i = (int)Math.floor(Math.random() * chars.length() -1); 
	       pass += chars.charAt(i);
	    }
	    System.out.println(pass);
	    return pass;
}
	
	
	//envoyer le mail
	 public void _send_email(String receiverEmailID,String Subject,
			  String Body){
			   
			  // Receiver Email Address
			  this._receiver_email_iD=receiverEmailID; 
			  // Subject
			  this._email_subject=Subject;
			  // Body
			  this._email_body=Body;
			  Properties props = new Properties();
			  props.put("mail.smtp.user",_sender_email_iD);
			  props.put("mail.smtp.host", _email_SMTPserver);
			  props.put("mail.smtp.port", _email_server_port);
			  props.put("mail.smtp.starttls.enable", "true");
			  props.put("mail.smtp.auth", "true");
			  props.put("mail.smtp.socketFactory.port", _email_server_port);
			  
			  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			  props.put("mail.smtp.socketFactory.fallback", "false");
			  SecurityManager security = System.getSecurityManager();
			  try{  
			  Authenticator auth = new SMTPAuthenticator();
			  Session session = Session.getInstance(props, auth);
			  MimeMessage msg = new MimeMessage(session);
			  msg.setText(_email_body);
			  msg.setSubject(_email_subject);
			  msg.setFrom(new InternetAddress(_sender_email_iD));
			  msg.addRecipient(Message.RecipientType.TO,
			  new InternetAddress(receiverEmailID));
			  Transport.send(msg);
			  System.out.println("Message send Successfully:)"); }
			  
			  catch (Exception mex){
			  mex.printStackTrace();}
			  
			  
			  }
			  public class SMTPAuthenticator extends javax.mail.Authenticator
			  {
			  public PasswordAuthentication getPasswordAuthentication()
			  {
			  return new PasswordAuthentication(_sender_email_iD, _sender_password);
			  }
			  }
	
	
	
}
