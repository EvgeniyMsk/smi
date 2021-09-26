drop table if exists person;
drop table if exists organization;
create table organization
(
    id   serial not null
        constraint organization_pk
            primary key,
    name varchar not null
);

drop index if exists organization_id_uindex;
create unique index organization_id_uindex
    on organization (id);

drop index if exists organization_name_uindex;
create unique index organization_name_uindex
    on organization (name);

create table person
(
    id               serial  not null
        constraint person_pk
            primary key,
    name             varchar not null,
    "organizationid" integer
        constraint person_organization_fk
            references organization
            on update cascade on delete cascade,
        passport         varchar
);