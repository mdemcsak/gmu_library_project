To create your database:

1. Run the 01-create-database.sh (Note this takes you into the sqlite command line interface).

2. Quit out of sqlite command line interface (Use .quit to exit).

3. Run the 02-create-tables.sh script.

4. Edit data.sql to load whatever data you want...

5. Run the 03-load-data.sh script.

6. Enter 'sqlite3 authors.db' at the command line (you are taken into the sqlite command line interface)

7. List the tables using .tables

8. Type 'select * from authors;' and press enter. You should see all your authors.

9. Quit out of sqlite command line interface (Use .quit to exit).
