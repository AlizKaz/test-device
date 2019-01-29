package org.test.device.controller;


import org.test.device.domain.Device;

/**
 * Created by Alireza on 1/6/2019.
 */
public class DeviceInitializer {
    public static Device validDevice() {
   		Device device = new Device();
   		device.setId("id1");
   		device.setDeviceModel("/devicemodels/id1");
   		device.setName("Sensor");
   		device.setNote("Testing a sensor.");
   		device.setSerial("A020000102");
   		return device;
   	}

    public static Device invalidDevice() {
        Device device = new Device();
        device.setId(null);
        device.setDeviceModel("/devicemodels/id1");
        device.setName("Sensor");
        device.setNote("Testing a sensor.");
        device.setSerial("A020000102");
        return device;
    }



}
