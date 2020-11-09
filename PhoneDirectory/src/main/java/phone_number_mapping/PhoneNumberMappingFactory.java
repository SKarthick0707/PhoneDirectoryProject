package phone_number_mapping;

public class PhoneNumberMappingFactory {

    public static PhoneNumberMapping getPhoneNumberMapping() {
        PhoneNumberMapping phoneNumberMapping =  PhoneNumberMappingImpl.getPhoneNumberMapping();
        return phoneNumberMapping;
    }
}
