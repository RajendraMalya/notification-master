package notify.model;

import java.time.LocalDateTime;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private long id;
    private String subject;
    private String from;
    private String to;
    private String body;
    private String sentTime;

    public Message() {
        this.sentTime = LocalDateTime.now().toString();
    }

    
}
