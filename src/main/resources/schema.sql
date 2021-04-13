

CREATE TABLE employee (
id NUMBER GENERATED ALWAYS AS IDENTITY ,
first_name varchar2(255) not null,
last_name varchar2(255) not null,
address varchar2(255) not null,
joiningdate DATE default sysdate
);

INSERT INTO employee ( first_name , last_name , address ) values (  'bat' , 'man' , 'iran' )

