package africa.semicolon.services;

import africa.semicolon.data.models.TrackingData;
import africa.semicolon.data.models.TrackingInformation;
import africa.semicolon.data.repositories.TrackingInformationRepository;
import africa.semicolon.data.repositories.TrackingInformationRepositoryImpl;
import africa.semicolon.utils.dtos.Requests.AddTrackingInfoRequest;
import africa.semicolon.utils.dtos.Responses.AddTrackingInfoResponse;
import africa.semicolon.utils.exceptions.InvalidPackageIdException;

import java.util.Optional;

public class TrackingServiceImpl implements TrackingService {
    private static final TrackingInformationRepository trackingRepo = new TrackingInformationRepositoryImpl();
    private final PackageService packageService = new PackageServiceImpl();
    @Override
    public AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest) {
        //verify package id is correct
        var aPackage = packageService.findPackageWithMy(addTrackingInfoRequest.getPackageId());
        if ( aPackage==null ) throw new InvalidPackageIdException("Package id is missing");
        TrackingData trackingData = new TrackingData(addTrackingInfoRequest.getEvent());
        // find previous tracking info;

        Optional<TrackingInformation> optionalInfo = trackingRepo.findByPackageId(addTrackingInfoRequest.getPackageId());

        // if it exists, add new event and save;
        //else create new tracking info, add new event
        if ( optionalInfo.isPresent() ){
            optionalInfo.get().getTrackingData().add(trackingData);
            trackingRepo.save(optionalInfo.get());
        }
        else {
            TrackingInformation trackingInformation= new TrackingInformation();
            trackingInformation.setPackageId(addTrackingInfoRequest.getPackageId());
            trackingInformation.getTrackingData().add(trackingData);
            TrackingInformation response = trackingRepo.save(trackingInformation);
        }

//        trackingInfoResponse.setPackageId(trac);

        //convert saved tracking info to response dto
        AddTrackingInfoResponse trackingInfoResponse = new AddTrackingInfoResponse();
        trackingInfoResponse.setDateTime(trackingData.getDateTimeOfEvent());
        trackingInfoResponse.setEvent(trackingData.getEvent());
        //return response dto
        return trackingInfoResponse;
    }

    @Override
    public TrackingInformation trackPackage(Integer packageId) {
        return trackingRepo.findByPackageId(packageId).get();
    }
}
