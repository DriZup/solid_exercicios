# Exercício de Refatoração - Princípios SOLID

Este repositório contém dois exercícios de refatoração de código, onde aplicamos os princípios **SOLID** para melhorar a arquitetura e a manutenção do código. Os princípios abordados são:

- **SRP (Single Responsibility Principle)** - Princípio da Responsabilidade Única
- **OCP (Open/Closed Principle)** - Princípio Aberto/Fechado

## Exercício 1: Princípio da Responsabilidade Única (SRP)

### Enunciado:

Você foi contratado por um banco para criar um sistema que gere relatórios financeiros. Atualmente, a classe `RelatorioFinanceiro` faz duas coisas: gera o relatório e envia por e-mail. Refatore o código para que ele siga o **Princípio da Responsabilidade Única (SRP)**, separando as responsabilidades em diferentes classes.

### Código Inicial:

A classe `RelatorioFinanceiro` original realizava duas responsabilidades:
- Gerar o relatório financeiro
- Enviar o relatório por e-mail

### Refatoração:

- A responsabilidade de gerar o relatório foi movida para a classe `GeradorRelatorio`.
- A responsabilidade de enviar o relatório por e-mail foi movida para a classe `EnviadorEmail`.

Agora, cada classe tem uma única responsabilidade, conforme exigido pelo **SRP**.

### Exemplo de uso:

```java
GeradorRelatorio gerador = new GeradorRelatorio();
gerador.gerarRelatorio();

EnviadorEmail enviador = new EnviadorEmail();
enviador.enviarPorEmail("Relatório Financeiro 2025");
```

# Exercício 2: Princípio Aberto/Fechado (OCP)

## Enunciado:
Você está desenvolvendo uma calculadora para o banco que realiza operações básicas como soma e subtração. No entanto, o gerente pediu para adicionar uma nova operação: multiplicação. Refatore o código para que ele siga o **Princípio Aberto/Fechado (OCP)**, permitindo adicionar novas operações sem modificar o código existente.

### Código Inicial:
A classe `Calculadora` original utilizava um `if-else` para determinar a operação, o que exigia modificações no código para adicionar novas operações.

### Refatoração:
- Foi criada uma interface `Operacao` que define o contrato para as operações.
- Para cada operação, como soma, subtração e multiplicação, foi criada uma classe que implementa a interface `Operacao`.
- A classe `Calculadora` foi refatorada para aceitar qualquer implementação da interface `Operacao`, sem a necessidade de modificar seu código ao adicionar novas operações.
- Agora, o código está **aberto para extensão** (adicione novas operações sem modificar o código existente) e **fechado para modificação**, conforme o **OCP**.

### Exemplo de uso:

```java
Calculadora calculadora = new Calculadora();

Operacao soma = new Soma();
Operacao subtracao = new Subtracao();
Operacao multiplicacao = new Multiplicacao();

System.out.println("Soma: " + calculadora.calcular(5, 3, soma));          // 5 + 3 = 8
System.out.println("Subtração: " + calculadora.calcular(5, 3, subtracao)); // 5 - 3 = 2
System.out.println("Multiplicação: " + calculadora.calcular(5, 3, multiplicacao)); // 5 * 3 = 15

