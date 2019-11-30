INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin2','$2a$10$9j7qK4am6yzz0V4B4.wFwuL0xv/iaEpEN448JbqF/jpnYqHEtdLt.',1, 'Admin2', 'Admin2','admin2@unicon.com.pe');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$9j7qK4am6yzz0V4B4.wFwuL0xv/iaEpEN448JbqF/jpnYqHEtdLt.',1, 'Admin', 'Admin','admin@unicon.com.pe');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);
