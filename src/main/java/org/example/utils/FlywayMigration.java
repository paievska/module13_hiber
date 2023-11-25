package org.example.utils;

import org.flywaydb.core.Flyway;

import static org.example.utils.Config.*;

public class FlywayMigration {
    public static void flywayMigration() {
        System.out.println("Flyway migration execute");

        Flyway
                .configure()
                .dataSource(JDBC_URL, USERNAME, PASSWORD)
                .locations("classpath:flyway/scripts")
                .load().migrate();
    }
}
