package africa.semicolon.services;

import africa.semicolon.data.models.Package;
import africa.semicolon.data.models.Sender;
import africa.semicolon.data.repositories.PackageRepository;
import africa.semicolon.data.repositories.PackageRepositoryImpl;
import africa.semicolon.utils.dtos.Requests.AddPackageRequest;
import africa.semicolon.utils.dtos.Responses.AddPackageResponse;
import africa.semicolon.utils.exceptions.SenderDoesNotExistException;

import java.util.List;
import java.util.Optional;

import static africa.semicolon.utils.mapper.ModelMapper.*;

public class PackageServiceImpl implements PackageService{
    private static final PackageRepository packageRepository = new PackageRepositoryImpl();
    private final SenderService senderService = new SenderServiceImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        Optional<Sender> senderOptional = senderService.
                findSenderByEmail(addPackageRequest.getSenderEmail());
//        if ( senderOptional.isEmpty() )throw new SenderDoesNotExistException("Sender does not exist");
        Package aPackage = map(addPackageRequest);
        Package savedPackage = packageRepository.save(aPackage);
        return map(savedPackage);
    }

    @Override
    public Package findPackageById(Integer trackingId) {
        return packageRepository.findPackageByTrackingNumber(trackingId);
    }

    @Override
    public void deleteAllPackages() {
        packageRepository.deleteAll();
    }

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public Package findPackageWithMy(Integer packageId) {
        return null;
    }

}
