drop table if exists inventory;

create table inventory (
    product_id  integer primary key,
    upc         char(7),
    quantity    integer,
    price       integer
);

insert into inventory values (1, '1020301', 20, 100);
insert into inventory values (2, '1342193', null, 200);
insert into inventory values (3, null, 100, null);

