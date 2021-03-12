--drop table album;
--drop table user_sm;
create table user_sm(
	user_id serial primary key,
	username text NOT NULL,
	pass_word text NOT NULL,
	first_name text NOT NULL,
	last_name text NOT NULL
);

--drop table user_status;
create table user_status(
	user_status_id serial primary key,
	user_id int references user_sm (user_id),
	user_status_value text
);


--drop table user_comments;
create table user_comments (
	user_comments_id serial primary key,
	user_comments_value text
);

--drop table status_comments;		
create table status_comments(
	user_status_id int references user_status (user_status_id),
	user_comments_id int references user_comments (user_comments_id) ,
	number_comments int,
	primary key (user_status_id, user_comments_id)
);


select * from user_sm us;

ALTER TABLE user_sm
ADD CONSTRAINT constraint_unique UNIQUE (username);


select * from cart;

create or replace function getTotal(c_id int)
	returns decimal as $$
declare
	t decimal;
begin
	select sum(ci.quantity * i.item_cost) into t
	from cart_item ci 
		inner join item i 
		on ci.product_id = i.product_id
	where ci.cart_id = c_id;
	return t;
end;
$$ language plpgsql;

create or replace procedure updateTotal(c_id int)
	as $$
declare
	t decimal;
begin
	select into t getTotal(c_id);
	update cart set total = t where cart_id = c_id;
end;
$$ language plpgsql;



--drop table item;
create table item (
	product_id serial primary key,
	item_cost float,
	item_name text,
	remining_items int,
	discount float
);
--drop table user_acc;
create table user_acc(
	user_id serial primary key,
	username text,
	pass_word text
);
--drop table cart;
create table cart(
	cart_id serial primary key,
	user_id int references user_acc (user_id),
	total float
);
--drop table cart_item;		
create table cart_item(
	cart_id int references cart (cart_id),
	product_id int references item (product_id) ,
	quantity int,
	primary key (cart_id, product_id)
);


INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(9.99, 'KK Egg Whites', 150, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(19.99, 'KK Dark Chocolate', 500, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(5.00, 'KK Rice&Bean', 99, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(1.99, 'KK Eggs', 1000, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(4.00, 'KK Muffins', 25, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(1999.99, 'KK Laptop', 15, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(799.00, 'KK 65 Inch TV', 5, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(25000.99, 'KK Car', 3, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(1199.00, 'ISung Phone', 99, 0);
INSERT INTO item (item_cost, item_name, remining_items, discount) VALUES(12345.99, 'KK Rocket', 2, 0);

INSERT INTO user_acc (username, pass_word) VALUES('admin', '123admin');
INSERT INTO user_acc (username, pass_word) VALUES('Nick', 'N123');
INSERT INTO user_acc (username, pass_word) VALUES('kkp', 'k2p');

--INSERT INTO user_sm (username, pass_word, first_name, last_name) 
--	values
--	('admin', '123admin', 'Keyur', 'Patel'),
--	('kkp', '123456', 'Keyur', 'Patel'),
--	('test', 'test123', 'test', 'user'),
--	('nick', '123', 'Nick', 'Jurczak');

--INSERT INTO cart (user_id, total) VALUES(2, 0);
--INSERT INTO cart (user_id, total) VALUES(3, 0);

INSERT INTO cart (user_id, total) VALUES((select user_id from user_acc where username = 'Nick'), 0);
INSERT INTO cart (user_id, total) VALUES((select user_id from user_acc where username = 'kkp'), 0);

--INSERT INTO cart_item (cart_id, product_id, quantity) VALUES(1, 1, 10);
--INSERT INTO cart_item (cart_id, product_id, quantity) VALUES(1, 2, 2);
--INSERT INTO cart_item (cart_id, product_id, quantity) VALUES(1, 3, 5);

insert into cart_item (cart_id, product_id, quantity)
	values(
		(select cart_id from cart where user_id =
			(select user_id from user_acc where username = 'Nick')
		),
	(select product_id from item where item_name = 'KK Rocket'), '1');

insert into cart_item (cart_id, product_id, quantity)
	values(
		(select cart_id from cart where user_id =
			(select user_id from user_acc where username = 'Nick')
		),
	(select product_id from item where item_name = 'ISung Phone'), '3');

insert into cart_item (cart_id, product_id, quantity)
	values(
		(select cart_id from cart where user_id =
			(select user_id from user_acc where username = 'Nick')
		),
	(select product_id from item where item_name = 'KK Car'), '2');

--INSERT INTO cart_item (cart_id, product_id, quantity) VALUES(2, 4, 4);
--INSERT INTO cart_item (cart_id, product_id, quantity) VALUES(2, 6, 3);
--INSERT INTO cart_item (cart_id, product_id, quantity) VALUES(2, 8, 1);
--INSERT INTO cart_item (cart_id, product_id, quantity) VALUES(2, 10, 1);

insert into cart_item (cart_id, product_id, quantity)
	values(
		(select cart_id from cart where user_id =
			(select user_id from user_acc where username = 'kkp')
		),
	(select product_id from item where item_name = 'KK Eggs'), '10');

insert into cart_item (cart_id, product_id, quantity)
	values(
		(select cart_id from cart where user_id =
			(select user_id from user_acc where username = 'kkp')
		),
	(select product_id from item where item_name = 'KK Dark Chocolate'), '30');

insert into cart_item (cart_id, product_id, quantity)
	values(
		(select cart_id from cart where user_id =
			(select user_id from user_acc where username = 'kkp')
		),
	(select product_id from item where item_name = 'KK Muffins'), '12');
	
insert into cart_item (cart_id, product_id, quantity)
	values(
		(select cart_id from cart where user_id =
			(select user_id from user_acc where username = 'kkp')
		),
	(select product_id from item where item_name = 'KK Rice&Bean'), '5');
	

select *     from user_acc;

-- select username, cart id and total, and each item name with quantity

