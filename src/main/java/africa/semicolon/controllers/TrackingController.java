package africa.semicolon.controllers;

import africa.semicolon.data.models.TrackingInformation;
import africa.semicolon.utils.dtos.Requests.AddTrackingInfoRequest;
import africa.semicolon.utils.dtos.Responses.AddTrackingInfoResponse;
import africa.semicolon.services.TrackingService;
import africa.semicolon.services.TrackingServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackingController {
    private final TrackingService trackingService = new TrackingServiceImpl();

    @PatchMapping("/api/trackinginfo")
    public AddTrackingInfoResponse addTrackingInfo(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest){
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);
    }

    @GetMapping("/api/trackinginfo/{id}")
    public TrackingInformation getTrackingInfo (@PathVariable("id") Integer trackingId){
        return trackingService.trackPackage(trackingId);
    }
}
