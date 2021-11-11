package africa.semicolon.controllers;

import africa.semicolon.data.models.Package;
import africa.semicolon.utils.dtos.Requests.AddPackageRequest;
import africa.semicolon.utils.dtos.Responses.AddPackageResponse;
import africa.semicolon.utils.exceptions.SenderDoesNotExistException;
import africa.semicolon.services.PackageService;
import africa.semicolon.services.PackageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {
    private final PackageService packageService = new PackageServiceImpl();

    @PostMapping("/api/addpackage")
    public ResponseEntity<?> addPackage(@RequestBody AddPackageRequest addPackageRequest){
        try {
            AddPackageResponse response = packageService.addPackage(addPackageRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (SenderDoesNotExistException senderDoesNotExist){
            return new ResponseEntity<>(senderDoesNotExist.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/package/{id}")
    public Package findPackageById(@PathVariable("id") Integer trackingId){
        return packageService.findPackageById(trackingId);
    }
}
