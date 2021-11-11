package africa.semicolon.data.repositories;

import africa.semicolon.data.models.Sender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderRepositoryImplTest {
    SenderRepository senderRepository;

    @BeforeEach
    public void setUp() {
        senderRepository= new SenderRepositoryImpl();
    }

    //pseudoMethod
    public Sender saveSender(){
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("Jerry@email.com");
        sender.setPhoneNumber("9993884");
        Sender savedSender = senderRepository.save(sender);
        return senderRepository.save(sender);
    }

    @Test
    public void test_save() {
        Sender sender = new Sender();
        sender.setSenderName("Jerry");
        sender.setEmailAddress("Jerry@email.com");
        sender.setPhoneNumber("9993884");
        Sender savedSender = senderRepository.save(sender);
        assertEquals(sender, savedSender);
        assertEquals(1, senderRepository.findAll().size());

    }

    @Test
    public void test_findSenderByEmail() {
        Sender savedSender = saveSender();
        assertEquals(savedSender, senderRepository.findSenderByEmail(savedSender.getEmailAddress()).get());
    }

    @Test
    public void test_deleteByEmail() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender.getEmailAddress());
        assertEquals(0, senderRepository.findAll().size());
    }

    @Test
    public void testDelete() {
        Sender savedSender = saveSender();
        senderRepository.delete(savedSender);
        assertEquals(0, senderRepository.findAll().size());
        assertTrue(senderRepository.findAll().isEmpty());
    }
}