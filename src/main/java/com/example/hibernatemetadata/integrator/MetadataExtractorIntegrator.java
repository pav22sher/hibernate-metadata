package com.example.hibernatemetadata.integrator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.springframework.stereotype.Component;

@Getter
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MetadataExtractorIntegrator implements Integrator {
    public static final MetadataExtractorIntegrator INSTANCE = new MetadataExtractorIntegrator();
    private Metadata metadata;

    @Override
    public void integrate(
            Metadata metadata,
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry
    ) {
        System.out.println("integrate");
        this.metadata = metadata;
    }

    @Override
    public void disintegrate(
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry
    ) {
        System.out.println("disintegrate");
    }
}