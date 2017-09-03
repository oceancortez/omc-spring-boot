# omc-spring-boot
Criando micro projetos e testando o spring boot

Start
-------------------------
Usando Wildfly com Mysql

1º Criar as seguintes pastas
- modules/system/layers/base/com/mysql/driver/main

2º Colocar o jar do mysql no pasta main
- mysql-connector-java-5.1.35-bin.jar

3º Criar o arquivo module.xml na pasta main com a config abaixo
<module xmlns="urn:jboss:module:1.3" name="com.mysql.driver">
 <resources>
  <resource-root path="mysql-connector-java-5.1.35-bin.jar" />
 </resources>
 <dependencies>
  <module name="javax.api"/>
  <module name="javax.transaction.api"/>
 </dependencies>
</module> 

4º Subir o servidor rodar standalone.bat

5º Adicionar um usuario rodar add-user.bat   como ManagementRealm

6º acessar "http://localhost:9990/console/App.html#home"     para configuar o data source 

7º configurar igual o ExampleDS








