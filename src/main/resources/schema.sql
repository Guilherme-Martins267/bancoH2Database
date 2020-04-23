drop table if exists personagens

create table personagens(
    id_personagens bigint auto_increment,
    ator varchar(100) not null,
    idade int not null,
    personagem varchar(100) not null,
    filme varchar(100) not null,
    primary key(id_personagens));