insert into stock(id, code, description, price, quantity)
values
	(1000, 'RCOM', 'Reliance COMM', 1500.00, 100000),
	(1001, 'INFY', 'Infosys', 800.00, 100000),
	(1002, 'TATA', 'Tata Motors', 400.00, 100000),
	(1003, 'HDFC', 'HDFC Bank', 1800.00, 100000),
	(1004, 'KOTAK', 'Kotak Mahindra Bank', 1200.00, 100000),
	(1005, 'IRB', 'IRB Co', 150.00, 100000);
	
	
insert into trade(id, code, trade_time, trade_amount, quantity)
values
	(100001, 'RCOM', '2020-01-01 10:00:00', 1500.9800, 500),
	(100002, 'KOTAK', '2020-01-01 10:00:00', 1400.9800, 600),
	(100003, 'TATA', '2020-01-01 10:00:00', 1500.9800, 500),
	(100004, 'INFY', '2020-01-01 10:00:00', 1500.9800, 500);
	