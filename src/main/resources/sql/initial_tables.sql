CREATE TABLE blocks(
                       id serial NOT NULL,
                       hash varchar(256) NOT NULL,
                       previousHash varchar(256) NOT NULL,
                       dateTime timestamptz NOT NULL,
                       CONSTRAINT blockPK PRIMARY KEY (id)
)
    WITH (
        OIDS=FALSE
        ) ;

CREATE TABLE proposals(
                       id serial NOT NULL,
                       name varchar(256) NOT NULL,
                       description varchar(256) NOT NULL,
                       CONSTRAINT proposalPK PRIMARY KEY (id)
)
    WITH (
        OIDS=FALSE
        ) ;

CREATE TABLE users(
                          id serial NOT NULL,
                          name varchar(256) NOT NULL,
                          password varchar(256) NOT NULL,
                          CONSTRAINT userPK PRIMARY KEY (id)
)
    WITH (
        OIDS=FALSE
        ) ;

CREATE TABLE votes(
                      id serial NOT NULL,
                      userID int NOT NULL,
                      proposalID int NOT NULL,
                      transactionID int NOT NULL,
                      quantity int NULL,
                      CONSTRAINT votePK PRIMARY KEY (id)
)
    WITH (
        OIDS=FALSE
        ) ;

ALTER TABLE votes
    ADD CONSTRAINT user_fk
        FOREIGN KEY(userID)
            REFERENCES users(id)

ALTER TABLE votes
    ADD CONSTRAINT proposal_fk
        FOREIGN KEY (proposalID)
            REFERENCES proposals (id);

ALTER TABLE votes
    ADD CONSTRAINT transaction_fk
        FOREIGN KEY (transactionID)
            REFERENCES transactions (id);



CREATE TABLE transactions(
                      id serial NOT NULL,
                      dateTime timestamptz NOT NULL,
                      blockID int null
                      CONSTRAINT transactionPK PRIMARY KEY (id)
)
    WITH (
        OIDS=FALSE
        ) ;

ALTER TABLE transactions
    ADD CONSTRAINT block_fk
        FOREIGN KEY (blockID)
            REFERENCES blocks(id);