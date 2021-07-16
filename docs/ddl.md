```sqlite
CREATE TABLE IF NOT EXISTS `Game`
(
    `game_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `timestamp`  INTEGER                           NOT NULL,
    `time_limit` INTEGER                           NOT NULL,
    `tiles`      INTEGER                           NOT NULL,
    `difficulty` TEXT,
    `user_id`    INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Game_timestamp` ON `Game` (`timestamp`);

CREATE INDEX IF NOT EXISTS `index_Game_difficulty` ON `Game` (`difficulty`);

CREATE INDEX IF NOT EXISTS `index_Game_user_id` ON `Game` (`user_id`);

CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `timestamp` INTEGER                           NOT NULL,
    `user_name` TEXT                              NOT NULL,
    `skill`     TEXT                              NOT NULL
);

CREATE INDEX IF NOT EXISTS `index_User_skill` ON `User` (`skill`);

CREATE TABLE IF NOT EXISTS room_master_table
(
    id            INTEGER PRIMARY KEY,
    identity_hash TEXT
);

INSERT OR
REPLACE INTO room_master_table (id, identity_hash)
VALUES (42, 'd388c1c1dc9bedf5b4dc00473ccf6d51');
```

[`ddl.sql`](sql/ddl.sql)

