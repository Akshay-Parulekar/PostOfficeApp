package com.example.postofficeapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class PincodeDetails
{
    @PrimaryKey
    @NonNull
    int id;
    @NonNull
    int pincode;
    @NonNull
    String circle;
    @NonNull
    String region;
    @NonNull
    String division;
    @NonNull
    String office;
    @NonNull
    String officeType;
    @NonNull
    String delivery;
    @NonNull
    String district;
    @NonNull
    String state;
    @NonNull
    double latitude;
    @NonNull
    double longitude;

    public PincodeDetails(int id, int pincode, String circle, String region, String division, String office, String officeType, String delivery, String district, String state, double latitude, double longitude) {
        this.id = id;
        this.pincode = pincode;
        this.circle = circle;
        this.region = region;
        this.division = division;
        this.office = office;
        this.officeType = officeType;
        this.delivery = delivery;
        this.district = district;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "PincodeDetails{" +
                ", pincode=" + pincode +
                ", circle='" + circle + '\'' +
                ", region='" + region + '\'' +
                ", division='" + division + '\'' +
                ", office='" + office + '\'' +
                ", officeType='" + officeType + '\'' +
                ", delivery='" + delivery + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
