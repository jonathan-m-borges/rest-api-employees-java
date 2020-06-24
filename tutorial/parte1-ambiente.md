

https://vaadin.com/learn/tutorials/vs-code-for-java-and-maven-projects

https://spring.io/guides/tutorials/rest/
https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/


Preparado o ambiente: https://www.youtube.com/watch?v=vim1bTa-Bkc
Preparado o ambiente: https://www.youtube.com/watch?v=23rN0oDdOKg
Spring com VSCode: https://www.youtube.com/watch?v=dkmlOi_MNb4


spring-boot:run


# Criando uma WebAPI com Java

## Parte 1 - Preparando o ambiente

Nesta etapa será feita a preparação do ambiente de desenvolvimento.

Serão instalados:
   - JDK14
   - Eclipse
   - Extenções do Eclipse

Existe algumas IDEs (Integrated Development Environment) para desenvolvimento em em Java, como por exemplo o Eclipse e o Netbeans.

> Neste tutorial vamos utilizar o Visual Studio Code para desenvolver em Java!!!


---
### Instalando o Visual Studio Code (VSCode)

Baixe a versão estável (Stable Build) do site [https://code.visualstudio.com/](https://code.visualstudio.com/) e execute a instalação.

> **Dica** - Marque as opções **"Open with Code"** durante a instalação.
> ![Dica instalação VSCode](./assets/vscode-01.png)


---
### Instalando o JDK14

Baixe a versão mais atual do Java SE 14, no site [https://www.oracle.com/java/technologies/javase-jdk14-downloads.html](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html).

Configure as variáveis de ambiente do seu sistema:

 - Configure a variável **JAVA_HOME** para o diretório raiz onde foi instalado o Java (normalmente é C:\Program Files\Java\jdk-14.0.1);
 - Configure a variável **PATH**, adicionando a entrada ```%JAVA_HOME%/bin```

> Se tudo deu certo, ao entrar na linha de comando e digitar ```java -version``` deve ser apresentada a versão **java 14.0.1** no console.


---
### Instalando o Maven - gerenciador de pacotes e configurações do Java

Siga os procedimentos de instalação informados no link: [https://maven.apache.org/](https://maven.apache.org/)




### Instalando o Tomcat

https://tomcat.apache.org/download-90.cgi


---
### Instalando os Plugins do Java no VSCode

Localize e instale a extensão **Java Extension Pack** no VSCode.

> ![Instalando Java Extension Pack](./assets/vs-java-pack.png)
   





---
### Referências
 
 - [Instalação Visual Studio 2019](https://docs.microsoft.com/pt-br/visualstudio/install/install-visual-studio?view=vs-2019)
 - [Visual Studio Code](https://code.visualstudio.com)
 - [SDK .NET Core](https://dotnet.microsoft.com/download)
 - [Criando classes e interfaces com C# Extensions](https://medium.com/@renato.groffe/net-core-visual-studio-code-criando-rapidamente-classes-e-interfaces-com-c-extensions-e73bad83e867)
