# sinquia-agi


Caso a versão do chrome seja diferente de "Versão 125.0.6422.78 (Versão oficial) 64 bits", deve ser baixado o chromedriver em "https://developer.chrome.com/docs/chromedriver/downloads?hl=pt-br" e seguir as instruções da página.

Para rodar os testes baixar o código na máquina e rodar a classe preteste com o junit

![image](https://github.com/saratakata/sinquia-agi/assets/45776194/b634a2db-8cf2-4242-a309-15c2b45ec2d1)


Esta é apenas a base inicial de uma automação.

Feito com  java 8, selenium e junit.


## Estrutura:

* /teste-qa/browser: Localização do chromedriver.
* /teste-qa/cenarios: Cenários mapeados.
* /teste-qa/evidencias: Pasta onde são salvos os relatórios de cada teste.
* /teste-qa/properties: Onde ficam salvos os arquivos de propriedades.

* /teste-qa/src/test/java/br/com/agi/teste_qa/test/preteste.java: Clase onde estão os testes, devendo ser derivadas em outras classe específicas futuramente.

