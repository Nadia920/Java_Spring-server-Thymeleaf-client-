/*CREATE DATABASE "help--it-incidents-db"
create table app_role
(
    id   bigint not null
        constraint app_role_pkey
            primary key,
    role varchar(12)
);


create table country
(
    id   bigint not null
        constraint country_pkey
            primary key,
    country_name varchar(40)
);

create table city
(
    id         bigint not null
        constraint city_pkey
            primary key,
    city_name       varchar(30),
    city_country_id bigint
        constraint city_country
            references country
    ON DELETE  CASCADE
    ON update  CASCADE
);
create table company
(
    id     bigint       not null
        constraint company_pkey
            primary key,
    company_name       varchar(30)  not null,
    company_address    varchar(30)  not null,
    company_activity   varchar(100) not null,
    company_city_id bigint
        constraint company_city
            references city
        ON DELETE  CASCADE
        ON update  CASCADE
);

create table users
(
    id           bigint      not null
        constraint users_pkey
            primary key,
    last_name_user    varchar(15) not null,
    first_name_user   varchar(15) not null,
    patronymic_user   varchar(15) not null,
    email        varchar(40),
    phone_number varchar(15) not null,
    login        varchar(15) not null,
    password     varchar(15) not null,
    users_role_id      bigint      not null
        constraint users_role
            references app_role
            ON DELETE  CASCADE
            ON update  CASCADE,
    users_company_id      bigint      not null
        constraint users_company
            references company
            ON DELETE  CASCADE
            ON update  CASCADE
);
create table app_rating
(
    id           bigint      not null
        constraint app_rating_pkey
            primary key,
    value        varchar(40),
    final_value    varchar(15) not null,
    rating_users_id      bigint      not null
        constraint rating_users
            references users
        ON DELETE  CASCADE
        ON update  CASCADE
);
create table tests
(
    id           bigint      not null
        constraint tests_pkey
            primary key,
    topic        varchar(40)
);
create table questions
(
    id           bigint      not null
        constraint questions_pkey
            primary key,
    question      varchar(40),
    answer        varchar(40),
    questions_test_id      bigint      not null
        constraint question_test
            references tests
    ON DELETE  CASCADE
    ON update  CASCADE

);
create table results
(
    id           bigint      not null
        constraint results_pkey
            primary key,
    test_result        varchar(40),
    results_test_id      bigint      not null
        constraint results_test
            references tests
    ON DELETE  CASCADE
    ON update  CASCADE,
    results_user_id      bigint      not null
        constraint results_users
            references users
    ON DELETE  CASCADE
    ON update  CASCADE
);
create table detachments
(
    id           bigint      not null
        constraint detachments_pkey
            primary key,
    detachment_name        varchar(40),
    specialization        varchar(40)

);
create table problems
(
    id           bigint      not null
        constraint problems_pkey
            primary key,
    problem_name               varchar(40),
    description_problem        varchar(100),
    solution_problem        varchar(100),
    problems_user_id bigint      not null
        constraint problems_users
            references users
        ON DELETE  CASCADE
        ON update  CASCADE,
    problems_detachment_id bigint      not null
        constraint problems_detachment
            references detachments
        ON DELETE  CASCADE
        ON update  CASCADE
);
create table category
(
    id           bigint      not null
        constraint category_pkey
            primary key,
    category_name        varchar(40),
    description_category varchar(100)

);
create table incidents
(
    id           bigint      not null
        constraint incidents_pkey
            primary key,
    incident_name            varchar(40),
    incident_solution        varchar(100),
    incident_reaction        varchar(100),
    incident_comments        varchar(100),
    prevention_measures      varchar(200),
    status                   varchar(30),
    incidents_category_id bigint      not null
        constraint incidents_category
            references category,
    incidents_user_id bigint      not null
        constraint incidents_users
            references users
        ON DELETE  CASCADE
        ON update  CASCADE,
    incidents_detachment_id bigint      not null
        constraint incidents_detachments
            references detachments
        ON DELETE  CASCADE
        ON update  CASCADE
);
create table employees
(
    id           bigint      not null
        constraint employees_pkey
            primary key,
    last_name_employee          varchar(40),
    first_name_employee         varchar(40),
    patronymic_employee         varchar(40),
    qualification     varchar(40),
    experience        varchar(40),
    detachment_team        varchar(40),
    employees_company_id bigint      not null
        constraint employees_company
            references company
        ON DELETE  CASCADE
        ON update  CASCADE,
    employees_detachment_id bigint      not null
        constraint employees_detachments
            references detachments
        ON DELETE  CASCADE
        ON update  CASCADE
);
create table fixed_detachments
(
    id           bigint      not null
        constraint fixed_detachments_pkey
            primary key,
    fixed_det_detachment_id bigint      not null
        constraint fixedDetachments_detachments
            references detachments
        ON DELETE  CASCADE
        ON update  CASCADE,
    fixed_detachments_company_id bigint      not null
        constraint fixed_detachments_company
            references company
    ON DELETE  CASCADE
    ON update  CASCADE
);
create sequence hibernate_sequence
  start 1
  increment 1;*/