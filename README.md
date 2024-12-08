# Conversor de Moedas

Este é um programa em Java que utiliza uma API de conversão de moedas para converter valores de uma moeda para outra. O programa usa a biblioteca `Gson` para processar a resposta JSON da API.

## Pré-requisitos

Antes de executar o código, é necessário:

1. Ter o Java 11 ou superior instalado.
2. Adicionar a dependência do `Gson` no seu projeto.
   - Se estiver usando Maven, adicione o seguinte ao seu `pom.xml`:

   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.10.1</version>
   </dependency>
   ```

   - Se estiver usando Gradle, adicione a linha abaixo ao seu `build.gradle`:

   ```gradle
   implementation 'com.google.code.gson:gson:2.10.1'
   ```

3. Substituir os valores das variáveis `API_KEY` e `API_URL` pelas informações corretas da API de conversão de moedas que você está utilizando.

## Como Funciona

1. O programa solicita que o usuário escolha uma moeda de origem e uma moeda de destino.
2. Em seguida, o usuário insere o valor a ser convertido.
3. O programa faz uma requisição HTTP à API de conversão de moedas, passando a chave de API (`API_KEY`).
4. A resposta da API é processada, e o valor convertido é calculado e exibido ao usuário.

## Como Usar

1. Substitua `API_KEY` e `API_URL` com as informações da sua API.
2. Compile e execute o programa.
3. O programa exibirá a lista de moedas disponíveis.
4. Escolha as moedas de origem e destino digitando os códigos das moedas (por exemplo, USD, BRL).
5. Digite o valor que deseja converter.
6. O programa exibirá o valor convertido.

### Exemplo de execução:

```text
Moedas disponíveis:
BRL - Real Brasileiro
USD - Dólar Americano
ARS - Peso Argentino
BOB - Boliviano Boliviano
CLP - Peso Chileno
COP - Peso Colombiano
Escolha a moeda de origem (por exemplo, USD): BRL
Escolha a moeda de destino (por exemplo, USD): USD
Digite o valor para conversão: 100
100.00 BRL é igual a 20.00 USD
```

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
