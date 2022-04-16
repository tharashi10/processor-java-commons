package com.oracle.thara.poc.processor.commons.oci.objectstorage;

import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.GetNamespaceRequest;
import com.oracle.bmc.objectstorage.responses.GetNamespaceResponse;

import lombok.NonNull;

public class GetNamespaceClient {
    private ObjectStorageClientBuilder clientBuilder;
    private GetNamespaceRequestBuilder requestBuilder;
    
    @NonNull
    public String getNamespace() {
    try (ObjectStorageClient client = clientBuilder.build()) {
      GetNamespaceRequest request = requestBuilder.build();
      GetNamespaceResponse response = client.getNamespace(request);
      return response.getValue();
    }
  }
}
