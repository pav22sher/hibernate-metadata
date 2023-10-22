package com.example.hibernatemetadata.integrator;

import org.hibernate.integrator.spi.Integrator;
import org.hibernate.jpa.boot.spi.IntegratorProvider;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MetadataExtractorIntegratorProvider implements IntegratorProvider {

    @Override
    public List<Integrator> getIntegrators() {
        return Collections.singletonList(MetadataExtractorIntegrator.INSTANCE);
    }
}
