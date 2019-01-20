package org.test.device.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.test.device.domain.Device;

import java.util.Optional;

/**
 * Created by Alireza on 1/10/2019.
 */
public class DeviceRepositoryImpl implements DeviceRepository {
    private DynamoDBMapper mapper;

    public DeviceRepositoryImpl(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public <S extends Device> S save(S s) {
        mapper.save(s);
        return s;
    }

    @Override
    public <S extends Device> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Device> findById(String s) {
        return null;
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Device> findAll() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        return mapper.scan(Device.class, scanExpression);
    }

    @Override
    public Iterable<Device> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Device device) {

    }

    @Override
    public void deleteAll(Iterable<? extends Device> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
