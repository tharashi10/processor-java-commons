package com.oracle.thara.poc.processor.commons.oci.events.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class InputDataUploadedEvent {

  @NonNull
  private  String bucketName;

  @NonNull
  private  String resourceName;

  @NonNull
  private  String dataOwner;

  @NonNull
  private  String dataType;

  @NonNull
  private  String dataSource;

  public InputDataUploadedEvent(@NonNull String bucketName, @NonNull String resourceName) {
    this.bucketName = bucketName;
    this.resourceName = resourceName;

    dataOwner = bucketName;
    String[] pathList = resourceName.split("/", -1);
    dataType = pathList[0];
    dataSource = pathList[1];
  }

}
