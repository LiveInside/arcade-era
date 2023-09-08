create table t_publisher
(
    id      serial not null
        primary key,
    country varchar(255),
    hide    boolean,
    name    varchar(255)
);
create sequence t_publisher_seq
    increment by 50;

alter sequence t_publisher_seq owner to postgres;

create table t_game
(
    id              serial not null
        primary key,
    age_rating      varchar(255),
    genre           varchar(255),
    hide            boolean,
    name            varchar(255),
    platform        varchar(255),
    price           numeric(38, 2),
    user_evaluation numeric(38, 2),
    publisher_id    integer
        constraint publisher_id
            references t_publisher
);
create sequence t_game_seq
    increment by 50;

alter sequence t_game_seq owner to postgres;

create table t_user
(
    id      serial not null
        primary key,
    age     smallint,
    balance numeric(38, 2),
    name    varchar(255),
    region  varchar(255),
    game_id integer
        constraint game_id
            references t_game
);
create sequence t_user_seq
    increment by 50;

alter sequence t_user_seq owner to postgres;

INSERT INTO t_user (region, age, balance, name)
VALUES ('rus', 21, 100, 'Никита'),
       ('eng', 17, 30, 'Томас'),
       ('us', 30, 700.81, 'Генри');

INSERT INTO t_game (name, price, platform, genre, age_rating, user_evaluation, hide)
VALUES ('Apex Legends', 0, 'PC', 'Battle Royale', '18+', 8.9, false),
       ('Counter-Strike: Globale Offensive', 11, 'PC', 'Team Shooter', '18+', 8.3, false),
       ('DOTA 2', 0, 'PC', 'MOBA', '18+', 9, false),
       ('Supreme Commander: Forged Alliance', 3.99, 'PC', 'RTS', '18+', 8.1, true);

INSERT INTO t_publisher (name, country, hide)
VALUES ('THQ Nordic', 'Austria', true),
       ('Valve', 'United States', false),
       ('Electronic Arts', 'United States', false);