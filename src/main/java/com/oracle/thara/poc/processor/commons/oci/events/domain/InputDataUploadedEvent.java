package com.oracle.thara.poc.processor.commons.oci.events.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class InputDataUploadedEvent {

  @NonNull
  private final String bucketName;

  @NonNull
  private final String resourceName;

  @NonNull
  private final String dataOwner;

  @NonNull
  private final String dataType;

  @NonNull
  private final String dataSource;

  public InputDataUploadedEvent(@NonNull String bucketName, @NonNull String resourceName) {
    this.bucketName = bucketName;
    this.resourceName = resourceName;

    dataOwner = bucketName;
    String[] pathList = resourceName.split("/", -1);
    dataType = pathList[0];
    dataSource = pathList[1];
  }

}
