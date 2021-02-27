insert into `bookstore`.`author` (id, first_name, last_name)
values (1, 'Patrick', 'Floyd');
insert into `bookstore`.`author` (id, first_name, last_name)
values (2, 'Joan', 'Rolling');
insert into `bookstore`.`author` (id, first_name, last_name)
values (3, 'Robert', 'Martin');

insert into `bookstore`.`book` (id, description, name, author_id)
values (1, 'Answer from StackOverflow', 'Element Collection', 1);
insert into `bookstore`.`book` (id, description, name, author_id)
values (2, 'Story about boy who survived', 'Harry Potter', 2);
insert into `bookstore`.`book` (id, description, name, author_id)
values (3, 'Story about clean code', 'Clean Code: A Handbook of Agile Software Craftsmanship', 3);

insert into `bookstore`.`book_tag` (id, name, book_id) values (1, 'Collections', 1);
insert into `bookstore`.`book_tag` (id, name, book_id) values (2, 'Java', 1);
insert into `bookstore`.`book_tag` (id, name, book_id) values (3, 'Kotlin', 1);
insert into `bookstore`.`book_tag` (id, name, book_id) values (4, 'Harry Potter', 2);
insert into `bookstore`.`book_tag` (id, name, book_id) values (5, 'Voldemort', 2);
insert into `bookstore`.`book_tag` (id, name, book_id) values (6, 'Death Gifts', 2);
insert into `bookstore`.`book_tag` (id, name, book_id) values (7, 'Code', 3);
insert into `bookstore`.`book_tag` (id, name, book_id) values (8, 'Programming', 3);

# password: qwe
insert into `bookstore`.`user` (id, email, first_name, last_name, password, username)
values (1, 'user1@gmail.com', 'User 1', 'User 1', '{bcrypt}$2a$10$bp3DwQ6tjNYUwbUYT/2u1uWSAFwjvBRBf5mmg5LgTsXVbyF6Zx5PG',
        'user1@gmail.com');
insert into `bookstore`.`user` (id, email, first_name, last_name, password, username)
values (2, 'user2@gmail.com', 'User 2', 'User 2', '{bcrypt}$2a$10$bp3DwQ6tjNYUwbUYT/2u1uWSAFwjvBRBf5mmg5LgTsXVbyF6Zx5PG',
        'user2@gmail.com');
insert into `bookstore`.`user` (id, email, first_name, last_name, password, username)
values (3, 'user3@gmail.com', 'User 3', 'User 3', '{bcrypt}$2a$10$bp3DwQ6tjNYUwbUYT/2u1uWSAFwjvBRBf5mmg5LgTsXVbyF6Zx5PG',
        'user3@gmail.com');
