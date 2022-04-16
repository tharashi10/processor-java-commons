package com.oracle.thara.poc.processor.commons.oci.objectstorage;

import com.oracle.bmc.objectstorage.requests.GetObjectRequest;

import lombok.NonNull;

public class GetObjectRequestBuilder {
  @NonNull
  private String namespaceName;

  @NonNull
  public GetObjectRequest build(@NonNull String bucketName, @NonNull String objectName) {
    return GetObjectRequest.builder().namespaceName(namespaceName).bucketName(bucketName)
        .objectName(objectName).build();
  }
}
