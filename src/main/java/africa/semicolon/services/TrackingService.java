package africa.semicolon.services;

import africa.semicolon.data.models.TrackingInformation;
import africa.semicolon.utils.dtos.Requests.AddTrackingInfoRequest;
import africa.semicolon.utils.dtos.Responses.AddTrackingInfoResponse;

public interface TrackingService {
    AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest);
    TrackingInformation trackPackage(Integer packageId);
}
