insert into Contacts values (1, 'Адрес: ул. Марии Рубцовой, д. 7', 'Email: beardburn@mail.ru', 'BeardBurn',
'Телефон: 8 (495) 754-67-15', 'Залог брутальной красоты!', 'Режим работы: пн-сб: 10:00-22:00');

insert into Barber values (1, null, 'Даниил', null, 'Абушев', null, null, 'Барбер', '4.5', null);
insert into Barber values (2, null, 'Владислав', null, 'Четвериков', null, null, 'Топ барбер', '4.82', null);
insert into Barber values (3, null, 'Юлия', null, 'Солнцева', null, null, 'Младший барбер', '4.59', null);
insert into Barber values (4, null, 'Артем', null, 'Теплов', null, null, 'Барбер', '4.76', null);
insert into Barber values (5, null, 'Никита', null, 'Белогуров', null, null, 'Топ барбер', '4.81', null);
insert into Barber values (6, null, 'Даниил', null, 'Лекомцев', null, null, 'Младший барбер', '4.34', null);
insert into Barber values (7, null, 'Егор', null, 'Летов', null, null, 'Шеф барбер', '5.0', null);
insert into Barber values (8, null, 'Виктор', null, 'Яковлев', null, null, 'Шеф барбер', '4.93', null);
insert into Barber values (9, null, 'Максим', null, 'Касьянов', null, null, 'Барбер', '4.68', null);
insert into Barber values (10, null, 'Дмитрий', null, 'Солдатенков', null, null, 'Топ барбер', '4.82', null);
insert into Barber values (11, null, 'Антон', null, 'Бондаренко', null, null, 'Шеф барбер', '4.91', null);
insert into Barber values (12, null, 'Александра', null, 'Фавствова', null, null, 'Барбер', '4.75', null);
insert into Barber values (13, null, 'Никита', null, 'Ефремов', null, null, 'Младший барбер', '4.23', null);
insert into Barber values (14, null, 'Илья', null, 'Железняков', null, null, 'Барбер', '4.7', null);
insert into Barber values (15, null, 'Леонид', null, 'Галочкин', null, null, 'Топ барбер', '4.82', null);
insert into Barber values (16, null, 'Сергей', null, 'Лебедев', null, null, 'Барбер', '4.6', null);

insert into Service values (1, '2000.0','Мужская стрижка','40');
insert into Service values (2, '1200.0','Стрижка машинкой/шейвером','20');
insert into Service values (3, '1500.0','Моделирование бороды','40');
insert into Service values (4, '1200.0','Коррекция бороды','30');
insert into Service values (5, '1000.0','Укладка волос','20');
insert into Service values (6, '1300.0','Камуфляж седины','50');
insert into Service values (7, '1200.0','Черная маска','90');
insert into Service values (8, '1000.0','Коррекция воском','90');
insert into Service values (9, '1900.0','Премиум бритье','60');
insert into Service values (10, '1700.0','Премиум уход за лицом','90');
insert into Service values (11, '1500.0','Традиционное бритье','40');
insert into Service values (12, '1900.0','Премиум моделирование','90');

insert into barber_services values (1, 1);
insert into barber_services values (1, 2);
insert into barber_services values (1, 4);
insert into barber_services values (1, 5);
insert into barber_services values (1, 11);

insert into barber_services values (2, 1);
insert into barber_services values (2, 2);
insert into barber_services values (2, 3);
insert into barber_services values (2, 4);
insert into barber_services values (2, 5);
insert into barber_services values (2, 7);
insert into barber_services values (2, 8);
insert into barber_services values (2, 11);

insert into barber_services values (3, 1);
insert into barber_services values (3, 2);

insert into barber_services values (4, 1);
insert into barber_services values (4, 2);
insert into barber_services values (4, 4);
insert into barber_services values (4, 5);
insert into barber_services values (4, 11);

insert into barber_services values (5, 1);
insert into barber_services values (5, 2);
insert into barber_services values (5, 3);
insert into barber_services values (5, 4);
insert into barber_services values (5, 5);
insert into barber_services values (5, 7);
insert into barber_services values (5, 8);
insert into barber_services values (5, 11);

insert into barber_services values (7, 1);
insert into barber_services values (7, 2);
insert into barber_services values (7, 3);
insert into barber_services values (7, 4);
insert into barber_services values (7, 5);
insert into barber_services values (7, 6);
insert into barber_services values (7, 7);
insert into barber_services values (7, 8);
insert into barber_services values (7, 9);
insert into barber_services values (7, 10);
insert into barber_services values (7, 11);
insert into barber_services values (7, 12);

insert into barber_services values (8, 1);
insert into barber_services values (8, 2);
insert into barber_services values (8, 3);
insert into barber_services values (8, 4);
insert into barber_services values (8, 5);
insert into barber_services values (8, 6);
insert into barber_services values (8, 7);
insert into barber_services values (8, 8);
insert into barber_services values (8, 9);
insert into barber_services values (8, 10);
insert into barber_services values (8, 11);
insert into barber_services values (8, 12);

insert into barber_services values (9, 1);
insert into barber_services values (9, 2);
insert into barber_services values (9, 4);
insert into barber_services values (9, 5);
insert into barber_services values (9, 11);

insert into barber_services values (11, 1);
insert into barber_services values (11, 2);
insert into barber_services values (11, 3);
insert into barber_services values (11, 4);
insert into barber_services values (11, 5);
insert into barber_services values (11, 6);
insert into barber_services values (11, 7);
insert into barber_services values (11, 8);
insert into barber_services values (11, 9);
insert into barber_services values (11, 10);
insert into barber_services values (11, 11);
insert into barber_services values (11, 12);

insert into barber_services values (13, 1);
insert into barber_services values (13, 2);

insert into barber_services values (15, 1);
insert into barber_services values (15, 2);
insert into barber_services values (15, 3);
insert into barber_services values (15, 4);
insert into barber_services values (15, 5);
insert into barber_services values (15, 7);
insert into barber_services values (15, 8);
insert into barber_services values (15, 11);

insert into Contract values (1, '2021-04-04 15:30:00', null, null, null, 1, null, 1);
insert into Contract values (2, '2021-04-04 19:00:00', null, null, null, 1, null, 11);
insert into Contract values (3, '2021-04-05 21:30:00', null, null, null, 1, null, 4);
insert into Contract values (4, '2021-04-05 12:30:00' , null, null, null, 1, null, 2);
insert into Contract values (5, '2021-04-05 20:30:00', null, null, null, 1, null, 5);

insert into Contract values (6, '2021-04-04 14:00:00', null, null, null, 3, null, 1);
insert into Contract values (7, '2021-04-06 19:30:00', null, null, null, 3, null, 2);

insert into Contract values (8, '2021-04-04 12:30:00', null, null, null, 7, null, 12);
insert into Contract values (9, '2021-04-04 17:00:00', null, null, null, 7, null, 7);
insert into Contract values (10, '2021-04-07 19:00:00', null, null, null, 7, null, 2);

insert into Contract values (11, '2021-04-05 15:00:00', null, null, null, 4, null, 4);
insert into Contract values (12, '2021-04-05 17:30:00', null, null, null, 4, null, 5);

insert into Contract values (13, '2021-04-10 12:00:00', null, null, null, 11, null, 12);
insert into Contract values (14, '2021-04-10 15:30:00', null, null, null, 11, null, 9);

insert into Contract values (15, '2021-04-10 13:30:00', null, null, null, 13, null, 2);

insert into Contract values (16, '2021-04-06 12:00:00', null, null, null, 2, null, 8);
insert into Contract values (17, '2021-04-06 14:30:00', null, null, null, 2, null, 5);
insert into Contract values (18, '2021-04-07 12:00:00', null, null, null, 2, null, 11);

insert into Contract values (19, '2021-04-05 17:00:00', null, null, null, 5, null, 5);
insert into Contract values (20, '2021-04-05 19:00:00', null, null, null, 5, null, 3);
insert into Contract values (21, '2021-04-05 21:00:00', null, null, null, 5, null, 3);

insert into Contract values (22, '2021-04-07 17:00:00', null, null, null, 9, null, 11);
insert into Contract values (23, '2021-04-08 17:00:00', null, null, null, 9, null, 1);
insert into Contract values (24, '2021-04-09 17:00:00', null, null, null, 9, null, 1);

insert into Contract values (25, '2021-04-05 16:00:00', null, null, null, 8, null, 6);
insert into Contract values (26, '2021-04-05 19:00:00', null, null, null, 8, null, 12);
insert into Contract values (27, '2021-04-07 16:00:00', null, null, null, 8, null, 6);
insert into Contract values (28, '2021-04-07 19:00:00', null, null, null, 8, null, 12);
insert into Contract values (29, '2021-04-08 16:00:00', null, null, null, 8, null, 10);
insert into Contract values (30, '2021-04-08 19:00:00', null, null, null, 8, null, 10);

insert into Contract values (31, '2021-04-10 14:00:00', null, null, null, 15, null, 8);
insert into Contract values (32, '2021-04-11 14:00:00', null, null, null, 15, null, 8);
insert into Contract values (33, '2021-04-12 14:00:00', null, null, null, 15, null, 8);
insert into Contract values (34, '2021-04-13 14:00:00', null, null, null, 15, null, 7);
insert into Contract values (35, '2021-04-13 14:00:00', null, null, null, 15, null, 7);

