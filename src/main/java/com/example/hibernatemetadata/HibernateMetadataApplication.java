package com.example.hibernatemetadata;

import com.example.hibernatemetadata.integrator.MetadataExtractorIntegrator;
import lombok.extern.log4j.Log4j2;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class HibernateMetadataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HibernateMetadataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        MetadataExtractorIntegrator integrator = MetadataExtractorIntegrator.INSTANCE;
        Metadata metadata = integrator.getMetadata();
        Database database = metadata.getDatabase();
        System.out.println();
        for (Namespace namespace : database.getNamespaces()) {
            for (Table table : namespace.getTables()) {
                System.out.println("table: " + table.getName() + " comment: " + table.getComment());
                for (Column column : table.getColumns()) {
                    System.out.println("column: " + column.getName() + " comment: " + column.getComment());
                }
                System.out.println();
            }
        }
    }
}
