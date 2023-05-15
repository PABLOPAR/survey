INSERT INTO persons (id,email,first_name,last_name,type) VALUES(100,'brian@gmail.com','Brian Samuel','Epstein','user');
INSERT INTO persons (id,email,first_name,last_name,id_User,type) VALUES(1000,'Lenon@gmail.com','John','Lennon',1,'peopleAnalyzed');
INSERT INTO persons (id,email,first_name,last_name,id_User,type) VALUES(1001,'Paul@gmail.com','Paul','McCartney',1,'peopleAnalyzed');
INSERT INTO persons (id,email,first_name,last_name,id_User,type) VALUES(1002,'George@gmail.com','George','Harrison',1,'peopleAnalyzed');
INSERT INTO persons (id,email,first_name,last_name,id_User,type) VALUES(1003,'Ringo@gmail.com','Ringo','Starr',1,'peopleAnalyzed');
INSERT INTO persons (id,email,first_name,last_name,id_User,type) VALUES(1004,'Joaquín@gmail.com','Joaquín','Sabina',1,'peopleAnalyzed');


INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000000,'Le dejarías tu casa para sus vacaciones?',8, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000001,'Le prestarías dinero que necesitas que te devuelva en un plazo determinado?',7, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000002,'Le confiarías un secreto muy intimo?',10, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000003,'Le pedirias dinero si tuviera para prestarte?',6, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000004,'Hablás con el/ella seguido?',7, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000005,'Disfruta tus alegrías y te ayuda con tus dificultades?',7, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000006,'Te trata bien?',10, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000007,'Te corrige cuando te equivocas?',8, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000008,'Te ayuda con las cosas de tu vida?',7, 0);
INSERT INTO questions (id,question,question_importance, question_selected) VALUES (1000009,'Habla bien con otras personas de ti?',7, 0);

INSERT INTO category_options(id, category_name) VALUES (10000,'Por SI o por NO');
INSERT INTO category_options(id, category_name) VALUES (10001,'Por Frecuencia');

INSERT INTO options_questions_category(id, category_option_id, option_name,ranking_option) VALUES (10000,10000, 'SI', 2);
INSERT INTO options_questions_category(id, category_option_id, option_name,ranking_option) VALUES (10001,10000, 'NO', 1);
INSERT INTO options_questions_category(id, category_option_id, option_name,ranking_option) VALUES (10002,10001, 'SIEMPRE', 3);
INSERT INTO options_questions_category(id, category_option_id, option_name,ranking_option) VALUES (10003,10001, 'A VECES', 2);
INSERT INTO options_questions_category(id, category_option_id, option_name,ranking_option) VALUES (10004,10001, 'NUNCA', 1);




INSERT INTO Countries (name, code) VALUES ( 'United Kingdom' , 'UK');
INSERT INTO Countries (name, code) VALUES ( 'Ukraine' , 'UA');
INSERT INTO Countries (name, code) VALUES ( 'Spain' , 'ES');

