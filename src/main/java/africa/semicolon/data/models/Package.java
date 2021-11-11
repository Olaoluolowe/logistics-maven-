package africa.semicolon.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Package {
    private Integer trackingId;
    private String name;
    private String senderEmail;
    private String receiverName;
    private String deliveryAddress;
    private double netWeight;
    private String receiverPhone;

    public void setSenderPhone(String senderPhone) {
    }
}
