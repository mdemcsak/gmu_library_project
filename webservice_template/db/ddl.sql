create table authors (
  id integer primary key autoincrement not null,
  name varchar(255) not null,
  dob varchar(255) not null,
  nationality varchar(255) not null,
  biography text not null,
  awards text,
  image_url varchar(255)
);
