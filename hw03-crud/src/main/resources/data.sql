INSERT INTO db_schema.users (user_name, first_name, last_name, email, phone)
VALUES ('Ivan Ivanov', 'Ivan', 'Ivanov', 'ivanov@gmail.com', '+79001234001'),
       ('Petr Petrov', 'Petr', 'Petrov', 'petrov@gmail.com', '+79001234002'),
       ('Vitaliy Sidorov', 'Vitaliy', 'Sidorov', 'sidorov@gmail.com', '+79001234003'),
       ('Vladimir', 'Vladimir', 'Vladimirov', 'vladimirov@gmail.com', '+79001234004'),
       ('Gennadiy Pavlov', 'Gennadiy', 'Pavlov', 'pavlov@gmail.com', '+79001234005')
ON CONFLICT (user_name) DO NOTHING;
