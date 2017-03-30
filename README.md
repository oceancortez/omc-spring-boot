# omc-spring-boot

Criando micro projetos e testando o spring boot


Start JAR
------------
	Criar a Base e tabela de Cliente conforme arquivo omc-pedidos-2.sql
	Dir => omc-spring-boot
	mvn clean
	mvn package
	cd omc-pedidos-ws
	cd target
	java -jar omc-pedidos-ws-0.0.1-SNAPSHOT.jar


	
Start WAR
------------
	Criar a Base e tabela de Cliente conforme arquivo omc-pedidos-2.sql
	Dir => omc-spring-boot
	mvn clean
	mvn package
	cd omc-pedidos-ws
	cd target
	java -jar omc-pedidos-ws-0.0.1-SNAPSHOT.jar


Start WAR com WIDIFLY
------------
	Baixar o widilfy e descompactar no c:
	Criar a Base e tabela de Cliente conforme arquivo omc-pedidos-2.sql
	Abrir o prompt command
	Ir até o dir > omc-spring-boot
	mvn clean package
	cd omc-pedidos-ws
	cd target
	copiar o omc-pedidos-ws-0.0.1-SNAPSHOT.war
	para C:\wildfly-11.0.0.Alpha1\standalone\deployments
	standalone.bat
	


