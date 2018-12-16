insert into person(id,first_name,last_name,age) values(1001,"Azatik","Can",22);

insert into topic(id,title,person_id) values(2002,"Hibernate is cool!",1001);
insert into topic(id,title,person_id) values(2003,"Hibernate is great!",1001);
insert into topic(id,title,person_id) values(2004,"Hibernate is amazing!",1001);
insert into comment(id,comment,person_id,topic_id) values(3003,"Yes I agree with you",1001,2002);
insert into comment(id,comment,person_id,topic_id) values(3004,"Osman lives in Istanbul",1001,2002);
insert into comment(id,comment,person_id,topic_id) values(3005,"No I don't agree with you",1001,2003);
insert into comment(id,comment,person_id,topic_id) values(3006,"I want to start learning Hibernate",1001,2002);
