A Java-based application for assembling custom PCs by selecting components (CPU, Motherboard, RAM, etc.) with SQL database integration for managing component data.
To run the program, you need to create a database with the identifier "pc_builder" in PostgreSQL, and create tables in it using the init.sql script. Then enter the name and password of your PostgreSQL user in the file /src/main/resources.application.properties.
After that, run the program via PcBuilderApplication.java and open the page in the browser at the link: http://localhost:8080/index.html
