package com.jekirdek.microservicespost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PostRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Post("title1", "description1", 1L)));
            log.info("Preloading " + repository.save(new Post("title2", "description2", 2L)));
            log.info("Preloading " + repository.save(new Post("title3", "description3", 2L)));
        };
    }
}
