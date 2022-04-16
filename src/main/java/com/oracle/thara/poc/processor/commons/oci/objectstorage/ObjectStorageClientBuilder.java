package com.oracle.thara.poc.processor.commons.oci.objectstorage;

import com.oracle.bmc.auth.BasicAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;

import lombok.NonNull;

public class ObjectStorageClientBuilder {
  @NonNull
  private BasicAuthenticationDetailsProvider authenticationDetailsProvider;

  @NonNull
  public ObjectStorageClient build() {
    return ObjectStorageClient.builder().build(authenticationDetailsProvider);
  }
}
