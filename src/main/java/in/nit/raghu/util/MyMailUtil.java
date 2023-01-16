package in.nit.raghu.util;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MyMailUtil {

	private JavaMailSender mailSender;
	
	public boolean send(
			String to[],
			String cc[],
			String bcc[],
			String subject,
			String text,
			Resource files[]
			) 
	{
		boolean sent = false;
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, files!=null && files.length>0);
			helper.setTo(to);
			if(cc!=null)
				helper.setCc(cc);
			if(bcc!=null)
				helper.setBcc(bcc);
			helper.setText(text);
			helper.setSubject(subject);
			helper.setText(text);
			if(files!=null) {
				for(Resource rob:files) {
					helper.addAttachment(rob.getFilename(), rob);
				}
			}
			
			mailSender.send(message);
			sent = true;
			
		}catch (Exception e) {

			e.printStackTrace();
			sent = false;
		}
		
		return sent;
	}
	
	/**Over-Loaded*/
	public boolean send(
			String to,
			String subject,
			String text,
			Resource file
			) 
	{
		return send(new String[] {to},null,null, subject, text, 
				file!=null?new Resource[] {file}:null);
	}
	
	public boolean send(
			String to,
			String subject,
			String text
			) 
	{
		return send(to, subject, text,null);
	}
}
	
