drop table if exists project_members;
drop table if exists projects;
drop table if exists employees;

create table employees (
    id              integer auto_increment primary key,
    first_name      varchar(255),
    last_name       varchar(255),
    address         varchar(255),
    supervisor_id   integer references employees(id)
);

insert into employees values (1, 'John', 'Doe', '123 Main St.', null);
insert into employees (first_name, last_name, address, supervisor_id)
    values ('Jane', 'Doe', '234 Main St.', 1);
insert into employees (first_name, last_name, address, supervisor_id)
    values ('Tom', 'Smith', '345 State St.', 1);

create table projects (
    id          integer auto_increment primary key,
    name        varchar(255),
    leader_id   integer references employees(id)
);

insert into projects values (1, 'Firestone', 1);
insert into projects values (2, 'Blue', 2);
insert into projects values (3, 'Star', 2);

create table project_members (
    project_id  integer references projects(id),
    member_id   integer references employees(id)
);

insert into project_members values (1, 1);
insert into project_members values (2, 1);
insert into project_members values (2, 2);
insert into project_members values (3, 2);

