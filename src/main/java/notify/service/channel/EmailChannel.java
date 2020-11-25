package notify.service.channel;

import com.google.common.collect.Lists;
import notify.model.ChannelType;
import notify.model.Message;
import notify.util.EmailValidator;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;

@Component
public class EmailChannel implements Channel {

    @Autowired
    EmailValidator emailValidator;

    @Autowired
    it.ozimov.springboot.mail.service.EmailService emailService;

    @Value("${spring.mail.username}") String fromEmail;

    public void notify(Message msg) {
        if(!emailValidator.isValid(msg.getFrom())) {
            throw new RuntimeException("Invalid email format in - from address");
        }
        if(!emailValidator.isValid(msg.getTo())) {
            throw new RuntimeException("Invalid email format in - to address");
        }
        try {
            Email email = DefaultEmail.builder()
                    .from(new InternetAddress(fromEmail, "NotificationService"))
                    .to(Lists.newArrayList(new InternetAddress(
                            msg.getTo(), "")))
                    .subject(msg.getSubject())
                    .body(msg.getBody())
                    .encoding("UTF-8").build();
            emailService.send(email);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send message using email channel, exception : "+e.getMessage(), e);
        }
    }

    public boolean supports(ChannelType channelType) {
        return ChannelType.email == channelType;
    }
}
