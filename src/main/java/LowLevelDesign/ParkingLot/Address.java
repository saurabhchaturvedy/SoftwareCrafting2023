package main.java.LowLevelDesign.ParkingLot;

public class Address {

    String block;
    String street;
    String city;
    String state;
    String country;


    private Address(Builder builder) {

        this.block = builder.block;
        this.city = builder.city;
        this.street = builder.street;
        this.state = builder.state;
        this.country = builder.country;
    }

    public String getBlock() {
        return block;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder {

        String block;
        String street;
        String city;
        String state;
        String country;

        Builder(String city) {
            this.city = city;
        }

        Builder block(String block) {
            this.block = block;
            return this;
        }

        Builder street(String street) {
            this.street = street;
            return this;
        }


        Builder state(String state) {
            this.state = state;
            return this;
        }

        Builder country(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }


}
