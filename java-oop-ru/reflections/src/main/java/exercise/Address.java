package exercise;

class Address {
    // BEGIN
    @NotNull
    private String country;
    // END

    // BEGIN
    @NotNull
    private String city;
    // END

    // BEGIN
    @NotNull
    private String street;
    // END

    // BEGIN
    @NotNull
    private String houseNumber;
    // END

    private String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}
