package org.test.device.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.test.device.domain.Device;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Basic integration tests for service demo application.
 *
 * @author aliz.kazerani@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class DeviceControllerTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private Device validDevice;
	private Device invalidDevice;

	@Before
	public void init() {
		validDevice = DeviceInitializer.validDevice();
		invalidDevice = DeviceInitializer.invalidDevice();
	}


	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		HttpEntity<Device> httpEntity = new HttpEntity<>(validDevice, null);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.postForEntity(
				"http://localhost:" + this.port + "/api/devices", httpEntity, Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@Test
	public void shouldReturn404WhenSendingRequestToController() throws Exception {
		HttpEntity<Device> httpEntity = new HttpEntity<>(invalidDevice, null);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.postForEntity(
				"http://localhost:" + this.port + "/api/devices", httpEntity, Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

}