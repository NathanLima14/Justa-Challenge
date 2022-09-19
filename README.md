# Justa-Challenge

O projeto se encontra na pasta "AutomationPractice".

Importe o projeto em sua IDE de preferência, os testes se encontram em "testCases".

É necessário alterar o path do ChromeDriver antes de executar os testes nos seguintes arquivos: Teste1.java, Teste2.java e Test3.java
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nathan\\Desktop\\ChromeDriver\\chromedriver.exe"); 
-> System.setProperty("webdriver.chrome.driver", {Path ChromeDriver});

Como não é permitido repetir o nome do endereço no site, talvez sejá necessário alterar o nome em: src -> main -> java -> pages -> AddressPage.java -> String titletext = {Nome}

Importante: Na conta da Justa no site Automation Practice já se encontram dois endereços cadastrados.
Os cenários de testes 1.2 e 2.1 foram criados somente com um endereço em mente, portanto com dois endereços cadastrados ocorrerá falha.
