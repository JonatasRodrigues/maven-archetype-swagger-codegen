# Descrição

Archetype com template de microserviço utilizando springboot, swagger-codegen e mustache.

# Pré-requisitos

<li>Java 1.8.0_181</li>
<li>Maven 3.6.3</li>
<li>Swagger-codegen 2.3.1</li>


# Instruções

Todos os comandos deverão ser executado via terminal.

1 - Para criar o archetype, fazer o checkout via GitHub e na raiz do projeto executar o comando abaixo:

- mvn clean install

2 - Para gerar o projeto a partir do archetype, executar o comando abaixo em um novo workspace:

- mvn archetype:generate -DarchetypeGroupId=br.com.api -DarchetypeArtifactId=customArchetype -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=br.com -DartifactId=newArchetype

3 - Na raiz do novo projeto gerado, executar o maven para gerar os stubs

- mvn clean install
