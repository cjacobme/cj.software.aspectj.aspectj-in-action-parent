create sequence seq_inventory_item start 1 increment 1;
create sequence seq_line_item start 1 increment 1;
create sequence seq_order start 1 increment 1;
create sequence seq_product start 1 increment 1;

    create table inventory_item (
        id int8 not null,
        quantityOnHand int4 not null,
        version int4 not null,
        product_id int8,
        primary key (id)
    );

    create table line_item (
        id int8 not null,
        quantity int4 not null,
        unitPrice float8 not null,
        version int4 not null,
        order_id int8,
        product_id int8,
        primary key (id)
    );

    create table order (
        id int8 not null,
        placed boolean not null,
        version int4 not null,
        primary key (id)
    );

    create table product (
        id int8 not null,
        description varchar(255),
        name varchar(255),
        price float8 not null,
        version int4 not null,
        primary key (id)
    );

    alter table inventory_item 
        add constraint FKnlagkg4wldbng04fndb117wai 
        foreign key (product_id) 
        references product;

    alter table line_item 
        add constraint FKj5l4bgtlxey3xsxn3lqqmes7s 
        foreign key (order_id) 
        references order;

    alter table line_item 
        add constraint FK237t8tbj9haibqe7wafj4t54x 
        foreign key (product_id) 
        references product;
