package org.test.device.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.test.device.domain.Device;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.test.device.repository.DeviceRepository;

import javax.validation.Valid;

/**
 * Created by Alireza on 1/6/2019.
 */
@Controller("/api")
public class DeviceController {
    Logger logger = LoggerFactory.getLogger(DeviceController.class);

    private DeviceRepository deviceRepo;

    @Autowired
    public DeviceController(DeviceRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @PostMapping(name = "/devices")
    public ResponseEntity devices(@RequestBody @Valid Device device, Errors errors) {
        try {
            if (!errors.hasErrors()) {
                deviceRepo.save(device);
                return new ResponseEntity(HttpStatus.CREATED);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
