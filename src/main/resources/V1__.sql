create extension if not exists LTREE;
create table tree
(
    id serial primary key,
    name varchar(255),
    path LTREE
);
create index tree_path_id on tree using gist(path);

insert into tree (name, path)
values
('root','1'),
('Laptops','1.2'),
('Acer','1.2.3'),
('Nitro','1.2.3.4'),
('Apple','1.2.5'),('MacBook','1.2.5.6'),
('Game Console','1.7'),
('Playstation','1.7.8'),
('Pro','1.7.8.9'),
('Xbox','1.7.10'),
('One','1.7.10.11');