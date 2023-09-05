CREATE TABLE Publisher
(
    Publisher_ID SERIAL PRIMARY KEY,
    Name         VARCHAR(100) NOT NULL,
    Country      VARCHAR(100),
    Hide         BOOLEAN
);

CREATE TABLE Game
(
    Game_ID         SERIAL PRIMARY KEY,
    Name            VARCHAR(100) NOT NULL,
    Price           MONEY,
    Platform        VARCHAR(100),
    Genre           VARCHAR(100),
    Age_rating      VARCHAR(10),
    User_evaluation DECIMAL(2, 1),
    Hide            BOOLEAN,
    Publisher_ID    INT REFERENCES Publisher (Publisher_ID)
);

CREATE TABLE "User"
(
    User_ID SERIAL PRIMARY KEY,
    Region  VARCHAR(100),
    Age     SMALLINT,
    Balance MONEY,
    Name    VARCHAR(100),
    Game_ID INT REFERENCES Game (Game_ID)
);


INSERT INTO "User" (Region, Age, Balance, Name)
VALUES ('rus', 21, 100, 'Никита'),
       ('eng', 17, 30, 'Томас'),
       ('us', 30, 700.81, 'Генри');

INSERT INTO Game (Name, Price, Platform, Genre, Age_rating, User_evaluation, Hide)
VALUES ('Apex Legends', 0, 'PC', 'Battle Royale', '18+', 8.9, false),
       ('Counter-Strike: Globale Offensive', 11, 'PC', 'Team Shooter', '18+', 8.3, false),
       ('DOTA 2', 0, 'PC', 'MOBA', '18+', 9, false),
       ('Supreme Commander: Forged Alliance', 3.99, 'PC', 'RTS', '18+', 8.1, true);

INSERT INTO Publisher (Name, Country, Hide)
VALUES ('THQ Nordic', 'Austria', true),
       ('Valve', 'United States', false),
       ('Electronic Arts', 'United States', false);