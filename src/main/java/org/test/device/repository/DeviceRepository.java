package org.test.device.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.test.device.domain.Device;

/**
 * Created by Alireza on 1/9/2019.
 */
@EnableScan
public interface DeviceRepository extends CrudRepository<Device, String> {
}
