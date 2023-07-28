CREATE TABLE Groups(
    id              integer NOT NULL,
    name            varchar(100) NOT NULL,
    description     varchar(100),
    created_at      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      timestamp
);

CREATE TABLE Configurations(
    id              integer NOT NULL,
    key             varchar(80),
    group_id        integer NOT NULL,
    name            varchar(80) NOT NULL,
    description     varchar(100),
    version         integer,
    data            json,
    created_at      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      timestamp
);

CREATE TABLE Services(
    id              integer NOT NULL,
    name            varchar(100) NOT NULL,
    description     varchar(100),
    created_at      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      timestamp
);

CREATE TABLE Configurations_overrides(
    id                integer NOT NULL,
    service_id        integer NOT NULL,
    group_id          integer NOT NULL,
    configuration_key varchar(80),
    description       varchar(100),
    version           integer,
    created_at        timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at        timestamp
);
