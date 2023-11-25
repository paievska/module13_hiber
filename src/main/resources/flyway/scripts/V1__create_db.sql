CREATE TABLE client (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(201) NOT NULL,
                        CHECK (LENGTH(name) >= 3)
);

CREATE TABLE planet (
                        id VARCHAR(10) PRIMARY KEY,
                        name VARCHAR(501) NOT NULL
);

CREATE TABLE ticket (
                        id SERIAL PRIMARY KEY,
                        created_at TIMESTAMP,
                        client_id INT,
                        from_planet_id VARCHAR(10),
                        to_planet_id VARCHAR(10),
                        FOREIGN KEY (client_id) REFERENCES Client(id),
                        FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
                        FOREIGN KEY (to_planet_id) REFERENCES Planet(id)
);