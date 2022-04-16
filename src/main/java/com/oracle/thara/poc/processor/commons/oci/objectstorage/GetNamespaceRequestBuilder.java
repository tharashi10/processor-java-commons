package com.oracle.thara.poc.processor.commons.oci.objectstorage;

import com.oracle.bmc.objectstorage.requests.GetNamespaceRequest;

public class GetNamespaceRequestBuilder {
    public GetNamespaceRequest build(){
        return GetNamespaceRequest.builder().build();
    }
}
