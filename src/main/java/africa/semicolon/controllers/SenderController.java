package africa.semicolon.controllers;

import africa.semicolon.data.models.Sender;
import africa.semicolon.utils.dtos.Responses.RegisterSenderResponse;
import africa.semicolon.utils.dtos.Requests.RegisterSenderRequest;
import africa.semicolon.services.SenderService;
import africa.semicolon.services.SenderServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SenderController {
    private final SenderService senderService = new SenderServiceImpl();
    @PostMapping("api/v1/sender")
    public RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest){
        return senderService.registerSender(registerSenderRequest);
    }

    @GetMapping("api/v1/sender/{email}")
    public Optional<Sender> getSender(@PathVariable String email){
        return senderService.findSenderByEmail(email);
    }
}
