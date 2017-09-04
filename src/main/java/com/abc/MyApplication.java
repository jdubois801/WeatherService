package com.abc;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

@ComponentScan("com.abc")
@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyApplication.class, args);
    }


    @EnableCouchbaseRepositories
    @Configuration
    static class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

        @Value("${couchbase.cluster.bucket}")
        private String bucketName;

        @Value("${couchbase.cluster.password}")
        private String password;

        @Value("${couchbase.cluster.ip}")
        private String ip;

        @Override
        protected List<String> getBootstrapHosts() {
            return Arrays.asList(this.ip);
        }

        @Override
        protected String getBucketName() {
            return this.bucketName;
        }

        @Override
        protected String getBucketPassword() {
            return this.password;
        }
    }
}
