drop table if exists public.user;
create table public.user(
    id serial primary key,
    username varchar(255) unique not null
);
