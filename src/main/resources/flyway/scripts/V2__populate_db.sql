INSERT INTO client (name) VALUES
('Igor Antonov'), ('Roman Kostitsen'),
('Geog Armani'), ('Dina Sovko'),
('Helly Berry'), ('Max Wanko'),
('Kate Kitty'), ('Ray Bank'),
('Julia Kygai'), ('Pavlo Kovtyn');

INSERT INTO planet (id, name) VALUES
                                  ('MARS', 'Мars'),
                                  ('VEN', 'Venus'),
                                  ('EAR', 'Earth'),
                                  ('JUP', 'Jupiter'),
                                  ('SAT', 'Saturn');
INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
                                                                             (NOW(), 1, 'MARS', 'VEN'),
                                                                             (NOW(), 2, 'EAR', 'JUP'),
                                                                             (NOW(), 3, 'SAT', 'MARS'),
                                                                             (NOW(), 4, 'VEN', 'EAR'),
                                                                             (NOW(), 5, 'MARS', 'SAT'),
                                                                             (NOW(), 6, 'JUP', 'VEN'),
                                                                             (NOW(), 7, 'EAR', 'SAT'),
                                                                             (NOW(), 8, 'MARS', 'JUP'),
                                                                             (NOW(), 9, 'VEN', 'JUP'),
                                                                             (NOW(), 10, 'SAT', 'EAR');