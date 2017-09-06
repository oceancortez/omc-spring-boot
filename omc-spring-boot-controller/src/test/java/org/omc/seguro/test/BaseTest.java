package org.omc.seguro.test;

import org.junit.runner.RunWith;
import org.omc.config.SpringBootRestApiApp;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration(classes = SpringBootRestApiApp.class)
@ContextConfiguration(classes = {SpringBootRestApiApp.class})
@TestPropertySource(locations  = {"classpath:application-test.properties"})
public class BaseTest {

}
