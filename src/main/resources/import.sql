insert into users (id, username, password, enabled) values (1,'andresg','$2a$10$ljKYtCtZo1IVEu6Ztu8Cze3XccepJJMtPLgTvONRfRui5yspdRPmm', 1);
insert into users (id, username, password, enabled) values (2,'admin','$2a$10$vYABN9UYD5I9Hs1oq149neYV9cFxr0ecvxCkU8en/SGO833rCKyni', 1);
insert into authorities (id, authority, user_id) values (1,'ROLE_USER', 1);
insert into authorities (id, authority, user_id) values (2,'ROLE_ADMIN', 2);
insert into authorities (id, authority, user_id) values (3,'ROLE_USER', 2);