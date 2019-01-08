package org.test.device.controller;

import org.test.device.domain.Device;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * Created by Alireza on 1/6/2019.
 */
@Controller("/api")
public class DeviceController {


    @PostMapping(name = "/devices")
    public ResponseEntity devices(@RequestBody @Valid Device request, Errors errors) {
        try {
            if (!errors.hasErrors()) {
                return new ResponseEntity(HttpStatus.CREATED);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (Throwable e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
