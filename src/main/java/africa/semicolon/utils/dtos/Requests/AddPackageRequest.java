package africa.semicolon.utils.dtos.Requests;

import lombok.Data;

@Data
public class AddPackageRequest {
    private String senderEmail;
    private String receiverName;
    private String receiverAddress;
    private double packageWeight;
    private String packageDescription;
    private String receiverPhoneNumber;
}