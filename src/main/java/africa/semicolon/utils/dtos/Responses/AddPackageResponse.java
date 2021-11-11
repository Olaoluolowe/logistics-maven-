package africa.semicolon.utils.dtos.Responses;

import lombok.Data;

@Data
public class AddPackageResponse {
    private Integer trackingId;
    private String packageName;
    private String receiverName;
    private String receiverPhone;
    private double packageWeight;
}
