package com.antares.controller;

import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Named(value = "emailJSFManagedBean")
@RequestScoped
public class EMailApp {

    private String to;
    private String from;
    private String subject;
    private String descr;
    private String username;
    private String password;
    private String smtp;
    private int port;
    
    public EMailApp() {
        
    this.to = null;
    this.from = "capinzon423@misena.edu.co";
    this.subject = null;
    this.descr = null;
    this.username = "capinzon423@misena.edu.co";
    this.password = "Auxi4702*";
    this.smtp = "smtp.gmail.com";
    this.port = 587;//25 Puerto 587 para que habilite el correo gmail
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public void validateEmail(FacesContext context, UIComponent toValidate, Object value){
        String message = "";
        String email = (String) value;
        if((email == null) || (email.equals(""))){
            ((UIInput) toValidate).setValid(false);
            message = "Email Requerido";
            context.addMessage(toValidate.getClientId(context), new FacesMessage(message));
        }else if((!email.contains("@")) || (!email.contains("."))){
            ((UIInput) toValidate).setValid(false);
            message = "Email Invalido";
            context.addMessage(toValidate.getClientId(context), new FacesMessage(message));
        }
    }
    
    public void submitEmail(){
        Properties props = null;
        Session session = null;
        MimeMessage message = null;
        Address fromAddress = null;
        Address toAddress = null;
        
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtp);
        props.put("mail.smtp.port", port);
        
        session = Session.getInstance(props,
                new javax.mail.Authenticator(){
                    @Override
                    protected  PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(username, password);
                    }
                });
        message = new MimeMessage(session);
        try {
            message.setContent(getDescr(), "text/plain");
            message.setSubject(getSubject());
            fromAddress = new InternetAddress(getFrom());
            message.setFrom(fromAddress);
            
            //UN USUARIO
            //toAddress = new InternetAddress(getTo());
            //message.setRecipient(Message.RecipientType.TO, toAddress);
            //message.saveChanges();
            //-----------------------------------------------------------
            
            //2 O MAS USUARIOS
            String[] recipientList = to.split(",");
            InternetAddress [] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for(String recipient : recipientList){
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddress);
            message.saveChanges();
            //------------------------------------------------------------
            
            Transport transport = session.getTransport("smtp");
            transport.connect(this.smtp, this.port, this.username, this.password);
            if (!transport.isConnected()) {
                //msj
                addMessage("System Message", "Conexion Realizada");
            }
            transport.sendMessage(message, message.getAllRecipients());
            
            
        } catch (MessagingException me) {
            //msj
            addMessage("System Message", "Error de envio.");
        }
        //msj
        addMessage("System Message", "Correo enviado");
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
}
