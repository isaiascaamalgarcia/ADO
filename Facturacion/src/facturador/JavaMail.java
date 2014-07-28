/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facturador;

/**
 *
 * @author Izzy-Izumi
 */
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class JavaMail
{
    static String nombre_factura="";
    static String correo_destino="";
    public JavaMail(String factura, String correo){
        this.nombre_factura=factura;
        this.correo_destino=correo;
    }
 public void run()
    {
        System.out.println(nombre_factura);
        System.out.println(correo_destino);
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "carwashcancun@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            // session.setDebug(true);

            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText("Estimado cliente, le informamos que su factura se realizó satisfactoriamente , con el folio "+ nombre_factura +
"\nasí mismo el archivo en PDF para su manejo virtual.\n" +
"\n" +
"Comprometiendonos a brindarle cada vez un mejor servicio le agradecemos su preferencia.\n" +
"\n" +
"\n" +
"\n" +
"ATTE:\n" +
" Green wash");

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(
                new DataHandler(new FileDataSource(nombre_factura+".pdf")));
            adjunto.setFileName("factura.pdf");

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("greenwashcancun@gmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(correo_destino));
            message.setSubject("Factura Green Wash");
            message.setContent(multiParte);

            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect("greenwashcancun@gmail.com", "gr33nw4sh");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
