create table customer( id integer not null primary key auto_increment, name varchar(100) );
create table product( id integer not null primary key auto_increment, description varchar(100) );
create table ordering( id integer not null primary key auto_increment, customer_id integer references customer(id), date_order timestamp, total numeric(20,2) );
create table ordering_commited( id integer not null primary key auto_increment,product_id integer references product(id) ,ordering_id integer references ordering(id), quantity integer );