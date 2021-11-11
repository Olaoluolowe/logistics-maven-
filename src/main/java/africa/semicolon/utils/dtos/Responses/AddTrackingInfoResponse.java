package africa.semicolon.utils.dtos.Responses;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AddTrackingInfoResponse {
    private LocalDateTime dateTime= LocalDateTime.now();
    private String event ;
    private Integer packageId;
}
