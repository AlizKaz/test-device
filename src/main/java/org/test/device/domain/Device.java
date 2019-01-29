package org.test.device.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.validation.constraints.NotBlank;

/**
 * Created by Alireza on 1/6/2019.
 * Device class represents the domain model of a sensor.
 */
@DynamoDBTable(tableName = "Device")
public class Device {
    @DynamoDBHashKey
    @NotBlank
    private String id;
    @NotBlank
    private String deviceModel;
    @NotBlank
    private String name;
    @NotBlank
    private String note;
    @NotBlank
    private String serial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
