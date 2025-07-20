package com.codebycs.qr_codebycs_generator_api.ports;

public interface StoragePort {
    String uploadFile(byte[] fileData, String fileName, String contentType);
}
