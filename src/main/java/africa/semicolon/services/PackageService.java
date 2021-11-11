package africa.semicolon.services;

import africa.semicolon.data.models.Package;
import africa.semicolon.utils.dtos.Requests.AddPackageRequest;
import africa.semicolon.utils.dtos.Responses.AddPackageResponse;

import java.util.List;

public interface PackageService {
    AddPackageResponse addPackage(AddPackageRequest addPackageRequest);
    Package findPackageById(Integer trackingId);

    void deleteAllPackages();

    List<Package> getAllPackages();

    Package findPackageWithMy(Integer packageId);
}
