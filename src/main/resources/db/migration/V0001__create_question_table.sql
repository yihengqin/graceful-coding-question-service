CREATE TABLE question
(
    id            serial PRIMARY KEY,
    questioner_id text not null,
    title         text not null,
    detail        text
)