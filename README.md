# README #

Pasos para la instalación de la aplicación de stampidia

### Para que es esta aplicación? ###

* Aplicación desarrollada para la clase de FABRICAS DE SOFTWARE	
* Versión 1.0.0

### Instalación y dependencias ###

* Versiones:
	* Java 1.7 (Java SE 1.7-0_67)
	* PostgreSQL 9.3.5 **sitio de descarga** http://www.enterprisedb.com/products-services-training/pgdownload#windows
	* Spring Tool Suite STS (Eclipse) 3.6.2 **sitio de descarga** http://spring.io/tools
	* Tomcat 7.0.57 **sitio de descarga** http://tomcat.apache.org/download-70.cgi

###Creación de la base de datos###

**NOTA:** Este usuario de base de datos debe tener todos los permisos asignados para poder crear las tablas y sus demás dependencias. y se asume que el comando psql esta configurado en las variables de entorno. 

1. Desde la consola de comandos, ubicarse dentro de la carpeta **docs** de este proyecto y ejecute el siguiente comando. (es posible que le pida la clave más de 1 vez)

**psql -U postgres -W -f stampidiadb-install.sql**
**psql -U postgres -W -f stampidia-uninstall.sql**
**psql -U stampidia -W -f inserts.sql**

2. La aplicación utilizará la siguiente base de datos: jdbc:postgresql://localhost:5432/stampidiadb

###Eliminación de la base de datos###

1. Al igual que la creación ejecute el siguiente comando.

**psql -U postgres -W -f stampidiadb-uninstall.sql**

### Inicio servidor Tomcat 7.0.57 (LINUX)###
1. parese sobre la instalación de tomcat (ej. /Aplicaciones/apache-tomcat-7.0.57/bin)
2. ejecute el comando sudo sh ./startup.sh
3. valide en su navegador de preferencia que esté ejecutando http://localhost:8080
### Deployment de la aplicación ###

**NOTA:** Inicie el servidor tomcat 7.0.57 y asegurese que está corriendo en el puerto 8080

1. Ubicarse en la carpeta donde instaló el servidor Tomcat 7
2. Abrir la carpeta webapps al interior de la carpeta anterior
3. Copiar en esta carpeta el archivo **stampidia.war** que se encuentra en la carpeta docs del proyecto 
4. Abrir el navegador de su preferencia en la url **http://localhost:8080/stampidiadb**

### Notas ###

*Por cuestión de tiempo esta versión no contiene pruebas unitarias

### Autores ###

* Diego Agudelo <die-agud@uniandes.edu.co>
* Lorena Salamanca <>
* Harold Murcia <hl.murcia222@uniandes.edu.co>
* Sebastián Gamba <fs.gamba10@uniandes.edu.co>
* Mauricio Cajamarca <>
