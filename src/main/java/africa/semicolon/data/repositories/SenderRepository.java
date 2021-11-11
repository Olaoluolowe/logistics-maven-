package africa.semicolon.data.repositories;

import africa.semicolon.data.models.Sender;

import java.util.List;
import java.util.Optional;

public interface SenderRepository {
    Sender save(Sender sender);
    Optional<Sender> findSenderByEmail(String email);
    void delete (Sender sender);
    void delete(String email);
    List<Sender> findAll();
    void deleteAll();
}
