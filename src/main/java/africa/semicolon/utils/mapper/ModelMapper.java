package africa.semicolon.utils.mapper;

import africa.semicolon.data.models.Package;
import africa.semicolon.data.models.Sender;
import africa.semicolon.utils.dtos.Responses.RegisterSenderResponse;
import africa.semicolon.utils.dtos.Requests.AddPackageRequest;
import africa.semicolon.utils.dtos.Requests.RegisterSenderRequest;
import africa.semicolon.utils.dtos.Responses.AddPackageResponse;

public class ModelMapper {
    public static Package map(AddPackageRequest addPackageRequest){
        Package aPackage = new Package();
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setDeliveryAddress(addPackageRequest.getReceiverAddress());
        aPackage.setSenderEmail(addPackageRequest.getSenderEmail());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhoneNumber());
        aPackage.setReceiverName(addPackageRequest.getReceiverName());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());
        return aPackage;
    }

    public static AddPackageResponse map(Package savedPackage){
        AddPackageResponse response = new AddPackageResponse();
        response.setPackageName(savedPackage.getName());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        response.setTrackingId(savedPackage.getTrackingId());
        return response;
    }

    public static Sender map(RegisterSenderRequest registerSenderRequest){
        Sender sender = new Sender();
        sender.setSenderName(registerSenderRequest.getSenderName());
        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
        sender.setEmailAddress(registerSenderRequest.getSenderEmail());
        return sender;
    }

    public static RegisterSenderResponse map(Sender sender){
        RegisterSenderResponse response = new RegisterSenderResponse();
        response.setSenderEmail(sender.getEmailAddress());
        return response;
    }
}
