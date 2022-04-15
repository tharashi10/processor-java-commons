package com.oracle.thara.poc.processor.commons.oci.events.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectStorageEvent {
    private Data data;

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String resourceName;
        private AdditionalDetails additionalDetails;

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AdditionalDetails {
      private String bucketName;
    }
  }
}
