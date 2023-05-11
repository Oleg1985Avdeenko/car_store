INSERT INTO car (id, availability, model, price, color_id, engine_id, model_option_id, transmission_id, order_id)
VALUES (12, true, 'CoolRay', 65875.00, 1, 1, 1, 1, null),
       (13, true, 'CoolRay', 67875.00, 2, 3, 1, 2, null),
       (14, true, 'Atlas', 75950.00, 2, 3, 3, 3, null),
       (15, false, 'Atlas', 75950.00, 3, 1, 2, 2, null),
       (16, false, 'Emgrand', 54200.00, 4, 2, 4, 1, null),
       (17, true, 'Emgrand', 52600.00, 1, 1, 4, 2, null);


INSERT INTO color (id, color_name)
VALUES (1, 'white'),
       (2, 'black'),
       (3, 'red'),
       (4, 'brown');

INSERT INTO engine (id, volume, type)
VALUES (1, 1.5, 'tdi 1.5'),
       (2, 1.5, 'i 1.5'),
       (3, 2.0, 'tdi 2.0');

INSERT INTO model_option(id, cruise_control, fog_light, heated_seat, option_name, salon, steering_wheel_control)
VALUES (1, true, true, false, 'comfort', 'textile', false),
       (2, true, true, true, 'Lux', 'textile', true),
       (3, true, true, true, 'Delux', 'leather', true),
       (4, false, true, false, 'simple', 'textile', false);

INSERT INTO transmission(id, type)
VALUES (1, '5 MT'),
       (2, 'CVT'),
       (3, '7 DCT');



