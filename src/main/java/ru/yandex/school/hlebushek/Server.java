package ru.yandex.school.hlebushek;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

import ru.yandex.school.hlebushek.db.DatabaseProvider;

public class Server extends ResourceConfig {

    public Server() {
        register(JacksonFeature.class);
        register(new DynamicFeature() {
            @Override
            public void configure(ResourceInfo resourceInfo, FeatureContext context) {
                context.register(DatabaseProvider.class);
            }
        });
    }
}