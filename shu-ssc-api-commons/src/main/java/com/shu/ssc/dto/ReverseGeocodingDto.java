package com.shu.ssc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReverseGeocodingDto {
    private int status;
    private Result result;

    @Data
    public class Result {
        private Location location;
        @JsonProperty("formatted_address")
        private String formattedAddress;
        private String business;
        private AddressComponent addressComponent;

        @Data
        public class Location {
            float lat;
            float lng;
        }

        @Data
        public class AddressComponent {
            String country;
            String province;
            String city;
            String district;
            String street;
        }
    }
}
