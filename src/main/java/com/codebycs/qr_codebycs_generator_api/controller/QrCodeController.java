package com.codebycs.qr_codebycs_generator_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codebycs.qr_codebycs_generator_api.dto.qrcode.QrCodeGenerateRequest;
import com.codebycs.qr_codebycs_generator_api.dto.qrcode.QrCodeGenerateResponse;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request){
        return null;
    }

}
