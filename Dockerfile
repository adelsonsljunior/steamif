FROM postgres

WORKDIR /database

COPY ./database/database.sql /docker-entrypoint-initdb.d/

USER root