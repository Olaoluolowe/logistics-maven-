package africa.semicolon.utils.dtos.Requests;

import lombok.Data;

@Data
public class AddTrackingInfoRequest {
    private Integer packageId;
    private String event;

    public AddTrackingInfoRequest(Integer packageId){
        this.packageId = packageId;
    }
    public AddTrackingInfoRequest(String event){
        this.event = event;
    }
}

