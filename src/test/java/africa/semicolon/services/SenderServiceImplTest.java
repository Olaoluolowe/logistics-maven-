package africa.semicolon.services;

import africa.semicolon.utils.dtos.Responses.RegisterSenderResponse;
import africa.semicolon.utils.dtos.Requests.RegisterSenderRequest;
import africa.semicolon.utils.exceptions.DuplicateUserException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderServiceImplTest {
    private SenderService senderService;


    @BeforeEach
    void setUp() {
        senderService = new SenderServiceImpl();
    }

    @AfterEach
    void tearDown(){
        senderService.deleteAllSenders();
    }
    @Test
    void registerSender(){
        RegisterSenderResponse response = registerSenderTestHelper();
        assertEquals(1, senderService.getSenders().size());
    }

    public RegisterSenderResponse registerSenderTestHelper(){
        RegisterSenderRequest registerSenderRequest = new RegisterSenderRequest();
        registerSenderRequest.setSenderName("Jery");
        registerSenderRequest.setSenderEmail("jerry@email.com");
        registerSenderRequest.setPhoneNumber("98745987");
        return senderService.registerSender(registerSenderRequest);
    }

    @Test
    public void duplicateEmail_ThrowsExceptionTest(){
        registerSenderTestHelper();
        assertThrows(DuplicateUserException.class, ()->registerSenderTestHelper());
    }
}

