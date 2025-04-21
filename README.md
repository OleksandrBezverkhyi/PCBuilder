A Java-based application for assembling custom PCs by selecting components (CPU, Motherboard, RAM, etc.) with SQL database integration for managing component data.
Для того, щоб запустити програму потрібно створити базу даних з ідентифікатором "pc_builder" у PostgreSQL, та створити в ній таблиці з допомогою скрипта init.sql. Після чого ввести ім'я та пароль вашого користувача PostgreSQL в файлі /src/main/resources.application.properties.
Після цього запустити програму через PcBuilderApplication.java і відкрити в браузері сторінку за  посиланням: http://localhost:8080/index.html
