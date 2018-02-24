package com.marcosbarbero.wd.pcf.multidatasources;

import com.marcosbarbero.wd.pcf.multidatasources.first.domain.First;
import com.marcosbarbero.wd.pcf.multidatasources.first.repository.FirstRepository;
import com.marcosbarbero.wd.pcf.multidatasources.second.domain.Second;
import com.marcosbarbero.wd.pcf.multidatasources.second.repository.SecondRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Marcos Barbero
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private FirstRepository firstRepository;

    @Autowired
    private SecondRepository secondRepository;

    @Override
    public void run(String... args) throws Exception {
        First firstSaved = this.firstRepository.save(new First("first database"));
        Second secondSaved = this.secondRepository.save(new Second("second database"));

        logger.info(firstSaved.toString());
        logger.info(secondSaved.toString());
    }
}
