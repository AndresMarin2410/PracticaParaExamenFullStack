CREATE TABLE productos
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    nombre            VARCHAR(50)  NOT NULL,
    descripcion       VARCHAR(150) NOT NULL,
    precio DOUBLE NOT NULL,
    stock             INT          NOT NULL,
    fecha_vencimiento date         NOT NULL,
    CONSTRAINT pk_productos PRIMARY KEY (id)
);