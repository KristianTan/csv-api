package esg.csv_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    public Item() {
    }

    public Item(Long id, String customerRef, String customerName, String addressLineOne, String addressLineTwo, String town, String county, String country, String postcode) {
        this.id = id;
        this.customerRef = customerRef;
        this.customerName = customerName;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.town = town;
        this.county = county;
        this.country = country;
        this.postcode = postcode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerRef;
    private String customerName;
    private String addressLineOne;
    private String addressLineTwo;
    private String town;
    private String county;
    private String country;
    private String postcode;

    public Long getId() {
        return id;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public String getTown() {
        return town;
    }

    public String getCounty() {
        return county;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
