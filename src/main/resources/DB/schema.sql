CREATE TABLE employee (
                           id BIGINT PRIMARY KEY,
                           corporation VARCHAR(50) NOT NULL,
                           name VARCHAR(50) NOT NULL,
                           type ENUM('PERMANENT','CONTRACT','PART_TIME','INTERN','TEMPORARY') NOT NULL,
                           created_at TIMESTAMP,
                           updated_at TIMESTAMP
);
CREATE TABLE employee_status (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 employee_id BIGINT,
                                 FOREIGN KEY (employee_id) REFERENCES employee(id),
                                 status_type ENUM('HIRED', 'EMPLOYED', 'ON_LEAVE', 'RESIGNED'),
                                 start_date DATE,
                                 end_date DATE,
                                 details LONGTEXT,
                                 created_at TIMESTAMP,
                                 updated_at TIMESTAMP
);

CREATE TABLE employee_info (
                                info_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               employee_id BIGINT,
                               FOREIGN KEY (employee_id) REFERENCES employee(id),
                               phone VARCHAR(30) UNIQUE,
                               address VARCHAR(50),
                               email VARCHAR(30) UNIQUE,
                               join_date DATE,
                               job_history VARCHAR(30),
                               memo LONGTEXT,
                               manager BIGINT,
                               FOREIGN KEY (manager) REFERENCES employee(id),
                               created_at TIMESTAMP,
                               created_by BIGINT NOT NULL,
                               FOREIGN KEY (created_by) REFERENCES employee(id),
                               updated_at TIMESTAMP
);
CREATE TABLE documents (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           employee_id BIGINT NOT NULL,
                           FOREIGN KEY (employee_id) REFERENCES employee_info(info_id),
                           save_name VARCHAR(1000) NOT NULL,
                           origin_name VARCHAR(255) NOT NULL,
                           path VARCHAR(100) NOT NULL,
                           created_at TIMESTAMP,
                           updated_at TIMESTAMP

);

CREATE TABLE department (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(50) NOT NULL UNIQUE,
                             status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
                             establish_date DATE NOT NULL,
                             created_at TIMESTAMP,
                             updated_at TIMESTAMP
);

create table role (
                      id int AUTO_INCREMENT PRIMARY KEY,
                      name varchar(255) not null,
                      `rank` INT not null,
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP
);

CREATE TABLE department_employee(
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY ,
                                      employee_id BIGINT,
                                      department_id BIGINT,
                                      role_id int,
                                      FOREIGN KEY (role_id) references role(id),
                                      FOREIGN KEY (employee_id) REFERENCES employee(id),
                                      FOREIGN KEY (department_id) REFERENCES department(id),
                                     created_at TIMESTAMP,
                                      updated_at TIMESTAMP
);

create table department_role(
    id            bigint AUTO_INCREMENT primary key ,
    department_id bigint not null,
    role_id       int not null,
    foreign key (department_id) references department (id),
    foreign key (role_id) references role (id),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE ip (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     employee_id BIGINT,
                     FOREIGN KEY (employee_id) REFERENCES employee(id),
                     ip_name VARCHAR(50) NOT NULL,
                     registered_ip VARCHAR(50) NOT NULL,
                     created_at TIMESTAMP,
                     updated_at TIMESTAMP
);

CREATE TABLE attendance (
                             employee_id BIGINT,
                             date DATE,
                             status ENUM('출근', '퇴근', '휴식') NOT NULL,
                             location ENUM('재택', '오피스'),
                             time_in TIMESTAMP,
                             time_out TIMESTAMP,
                             ip_id BIGINT,
                             FOREIGN KEY (ip_id) REFERENCES ip(id),
                             PRIMARY KEY (employee_id, date),
                             FOREIGN KEY (employee_id) REFERENCES employee(id),
                             created_at TIMESTAMP,
                             updated_at TIMESTAMP
);
CREATE TABLE notice (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(50) NOT NULL,
                         content VARCHAR(500) NOT NULL,
                         created_at TIMESTAMP,
                         updated_at TIMESTAMP,
                         created_by BIGINT NOT NULL,
                         FOREIGN KEY (created_by) REFERENCES employee(id)
);
