package africa.semicolon.services;

import africa.semicolon.data.models.Sender;
import africa.semicolon.data.repositories.SenderRepository;
import africa.semicolon.data.repositories.SenderRepositoryImpl;
import africa.semicolon.utils.dtos.Responses.RegisterSenderResponse;
import africa.semicolon.utils.dtos.Requests.RegisterSenderRequest;
import africa.semicolon.utils.exceptions.DuplicateUserException;
import africa.semicolon.utils.mapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class SenderServiceImpl implements SenderService{
    private static final SenderRepository senderRepository = new SenderRepositoryImpl();
    @Override
    public RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest) {
        Optional<Sender> savedSender = senderRepository.findSenderByEmail
                (registerSenderRequest.getSenderEmail());
        if ( savedSender.isPresent() ) throw new DuplicateUserException
                ("Email"+ registerSenderRequest.getSenderEmail()+ "already exists");
        //save
        Sender sender = ModelMapper.map(registerSenderRequest);
        //convert sender to dto
        //
        Sender returnedSavedSender = senderRepository.save(sender);

        return ModelMapper.map(returnedSavedSender);
    }

    @Override
    public List<Sender> getSenders() {
        return senderRepository.findAll();
    }

    @Override
    public void deleteAllSenders() {
        senderRepository.deleteAll();
    }

    @Override
    public Optional<Sender> findSenderByEmail(String email) {
        return senderRepository.findSenderByEmail(email);
    }
}
