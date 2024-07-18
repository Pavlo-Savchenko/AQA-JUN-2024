package org.prog.dto;

import lombok.Data;

@Data
public class LocationDto {
    private StreetDto street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private CoordinatesDto coordinates;
    private TimeZoneDto timezone;

}
