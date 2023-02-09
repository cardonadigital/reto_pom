package co.com.sofka.models;

public class ShippingInfo {
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zipCode;
    private String phoneNumber;

    public static ShippingInfo shippingInfo(){
        return new ShippingInfo();
    }

    public ShippingInfo createShippingInfo(){
        this.email = "example@gmail.com.co";
        this.firstName = "mateo";
        this.lastName = "ocanpo";
        this.address = "cr22-21";
        this.city = "Medellin";
        this.zipCode = "12345-6789";
        this.phoneNumber = "3228997454";
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
