insert into user_details (id, birth_date, name) values (1001, current_date(), 'Jack');
insert into user_details (id, birth_date, name) values (1002, current_date(), 'Sam');
insert into user_details (id, birth_date, name) values (1003, current_date(), 'Mike');


insert into post (id, description, user_id) values (2001, 'I want to learn AWS', 1001);
insert into post (id, description, user_id) values (2002, 'I want to learn Azure', 1001);
insert into post (id, description, user_id) values (2003, 'I want to Get AWS Certified', 1002);

insert into todo (id, description, done, target_date, username) values (3001, 'Learn AWS', false, '2023-10-01', 'Mike');
insert into todo (id, description, done, target_date, username) values (3002, 'Learn Azure', false, '2024-10-01', 'Mike');
insert into todo (id, description, done, target_date, username) values (3003, 'Learn DevSecOps', false, '2025-10-01', 'Mike');
insert into todo (id, description, done, target_date, username) values (3004, 'Learn Kubernetes', false, '2025-10-01', 'Sam');