package africa.semicolon.services;

import africa.semicolon.utils.dtos.Requests.AddPackageRequest;
import africa.semicolon.utils.dtos.Responses.AddPackageResponse;
import africa.semicolon.utils.exceptions.DuplicatePackageIdException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServiceImplTest {
    PackageService packageService;


    @BeforeEach
    void setUp() {
        packageService = new PackageServiceImpl();
    }

    @AfterEach
    void tearDown() {
        packageService.deleteAllPackages();
    }

    @Test
    void addPackage() {
        AddPackageResponse addPackageResponse = addPackageTest();
        assertEquals(1, packageService.getAllPackages().size());
    }

    //pseudoMethod
    public AddPackageResponse addPackageTest(){
        AddPackageRequest addPackageRequest = new AddPackageRequest();
        addPackageRequest.setPackageWeight(43.5);
        addPackageRequest.setPackageDescription("Whatever");
        addPackageRequest.setReceiverAddress("Wherever");
        addPackageRequest.setReceiverPhoneNumber("8504883");
        addPackageRequest.setReceiverName("Waje");
        return packageService.addPackage(addPackageRequest);
    }
//    @Test
//    void findPackageById() {
//        addPackageTest();
//        assertThrows(DuplicatePackageIdException.class, ()-> addPackageTest());
//    }
}