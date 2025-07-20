package com.codebycs.qr_codebycs_generator_api.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.codebycs.qr_codebycs_generator_api.dto.qrcode.QrCodeGenerateResponse;
import com.codebycs.qr_codebycs_generator_api.ports.StoragePort;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCodeGeneratorService {

    private final StoragePort storage;

    public QrCodeGeneratorService(StoragePort storage) {
        this.storage = storage;
    }

    public QrCodeGenerateResponse generateAndUploadQrCode(String text) throws WriterException, IOException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 300, 300);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", baos);

        byte[] qrCodeData = baos.toByteArray();

        String url = storage.uploadFile(qrCodeData, UUID.randomUUID().toString(), "image.png");

        return new QrCodeGenerateResponse(url);
    }

}
