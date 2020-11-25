package notify.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import notify.exception.BadRequest;
import notify.model.ChannelType;
import notify.model.Message;
import notify.service.NotificationService;
import notify.util.EmailValidator;

@RestController
@RequestMapping("/api/v1.0/notifier")
@Api(value="Notification APIs")
public class NotificationController {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService service;

    @Autowired
    EmailValidator emailValidator;

    @ApiOperation(value = "Notify the given message to given channelType.")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found")})
    @PostMapping("/notify/{channelType}")
    public long notify(@PathVariable ChannelType channelType, @RequestBody Message msg) {
        if(ChannelType.email == channelType) {
            if(!emailValidator.isValid(msg.getFrom())) {
                throw new BadRequest("From Address", msg.getFrom());
            }
            if(!emailValidator.isValid(msg.getTo())) {
                throw new BadRequest("To Address", msg.getFrom());
            }
        }

        return service.notify(channelType, msg);
    }

    @ApiOperation(value = "Notify the given message to all channels like Slack and email.")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found")})
    @PostMapping("/notifyAll")
    public long notifyAll(@RequestBody Message msg) {
        return service.notifyAll(msg);
    }
}
