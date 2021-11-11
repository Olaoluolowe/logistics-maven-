package africa.semicolon.data.repositories;

import africa.semicolon.data.models.TrackingData;
import africa.semicolon.data.models.TrackingInformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TrackingInformationRepositoryImplTest {
    TrackingInformationRepository trackingInformationRepository;

    @BeforeEach
    void setUp() {
        trackingInformationRepository =new TrackingInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(7);
        TrackingData trackingData = new TrackingData("y");
        trackingData.setEvent("Ready for dispatch");
        trackingInformation.getTrackingData().add(trackingData);

        TrackingInformation savedInfo = trackingInformationRepository.save(trackingInformation);
        assertEquals(savedInfo, trackingInformation);
    }

    public TrackingInformation saveTestHelper(){
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setPackageId(7);
        TrackingData trackingData = new TrackingData("u");
        trackingData.setEvent("Ready for dispatch");
        trackingInformation.getTrackingData().add(trackingData);

        TrackingInformation savedInfo= trackingInformationRepository.save(trackingInformation);
        return savedInfo;
    }

    @Test
    void findAll() {
        TrackingInformation savedInfo = saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
    }

    @Test
    void deleteAll() {
        saveTestHelper();
        assertEquals(1, trackingInformationRepository.findAll().size());
        trackingInformationRepository.deleteAll();
        assertEquals(0, trackingInformationRepository.findAll().size());

    }

    @Test
    void findByPackageId() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        Optional<TrackingInformation> trackingInformationId = trackingInformationRepository.findByPackageId(savedTrackingInformation.getPackageId());
        assertTrue(trackingInformationId.isPresent());
//        assertEquals(savedTrackingInformation, trackingInformationId.get());
    }

    @Test
    void delete() {
        TrackingInformation savedTrackingInformation = saveTestHelper();
        Optional<TrackingInformation> trackingInformation = trackingInformationRepository.findByPackageId(7);
        trackingInformationRepository.delete(savedTrackingInformation);
        assertEquals(0, trackingInformationRepository.findAll().size());
    }

    @Test
    void deleteById() {
    }
}