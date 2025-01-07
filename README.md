
## **Princípios SOLID - Exercícios de Refatoração**

Os princípios SOLID são um conjunto de diretrizes para o design de software que ajudam a criar sistemas mais flexíveis, escaláveis e fáceis de manter. Este repositório apresenta exercícios práticos para aplicar os princípios SOLID em diferentes cenários.

Os princípios abordados são:

1. **SRP (Single Responsibility Principle)** - Princípio da Responsabilidade Única  
2. **OCP (Open/Closed Principle)** - Princípio Aberto/Fechado  
3. **LSP (Liskov Substitution Principle)** - Princípio da Substituição de Liskov  

---

### **Exercício 1: Princípio da Responsabilidade Única (SRP)**

#### **Enunciado**
Você foi contratado por um banco para criar um sistema que gere relatórios financeiros. Atualmente, a classe `RelatorioFinanceiro` faz duas coisas: gera o relatório e envia-o por e-mail. Refatore o código para que ele siga o Princípio da Responsabilidade Única (SRP), separando as responsabilidades em diferentes classes.

#### **Código Inicial**
A classe `RelatorioFinanceiro` original realizava duas responsabilidades:
1. Gerar o relatório financeiro.  
2. Enviar o relatório por e-mail.  

#### **Refatoração**
A responsabilidade de gerar o relatório foi movida para a classe `GeradorRelatorio`.  
A responsabilidade de enviar o relatório por e-mail foi movida para a classe `EnviadorEmail`.  

Agora, cada classe tem uma única responsabilidade, conforme exigido pelo SRP.

#### **Código Refatorado**

```java
// Classe responsável por gerar o relatório financeiro
public class GeradorRelatorio {
    public void gerarRelatorio() {
        System.out.println("Relatório financeiro gerado.");
    }
}

// Classe responsável por enviar o relatório por e-mail
public class EnviadorEmail {
    public void enviarPorEmail(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        GeradorRelatorio gerador = new GeradorRelatorio();
        gerador.gerarRelatorio();

        EnviadorEmail enviador = new EnviadorEmail();
        enviador.enviarPorEmail("Relatório Financeiro 2025");
    }
}
```

#### **Benefícios da Refatoração**
- Cada classe tem uma única responsabilidade, facilitando a manutenção.  
- Redução de dependências entre as classes.  
- Maior flexibilidade para mudanças futuras.  

---

### **Exercício 2: Princípio Aberto/Fechado (OCP)**

#### **Enunciado**
Você está desenvolvendo uma calculadora para o banco que realiza operações básicas como soma e subtração. No entanto, o gerente pediu para adicionar uma nova operação: multiplicação. Refatore o código para que ele siga o Princípio Aberto/Fechado (OCP), permitindo adicionar novas operações sem modificar o código existente.

#### **Código Inicial**
A classe `Calculadora` original utilizava um `if-else` para determinar a operação, o que exigia modificações no código para adicionar novas operações.

#### **Refatoração**
Foi criada uma interface `Operacao` que define o contrato para as operações.  
Para cada operação, como soma, subtração e multiplicação, foi criada uma classe que implementa a interface `Operacao`.  
A classe `Calculadora` foi refatorada para aceitar qualquer implementação da interface `Operacao`, sem a necessidade de modificar seu código ao adicionar novas operações.

#### **Código Refatorado**

```java
// Interface que define o contrato para as operações
public interface Operacao {
    int calcular(int a, int b);
}

// Classe para a operação de soma
public class Soma implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a + b;
    }
}

// Classe para a operação de subtração
public class Subtracao implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a - b;
    }
}

// Classe para a operação de multiplicação
public class Multiplicacao implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a * b;
    }
}

// Classe Calculadora que utiliza a interface Operacao
public class Calculadora {
    public int calcular(int a, int b, Operacao operacao) {
        return operacao.calcular(a, b);
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        Operacao soma = new Soma();
        Operacao subtracao = new Subtracao();
        Operacao multiplicacao = new Multiplicacao();

        System.out.println("Soma: " + calculadora.calcular(5, 3, soma)); // 5 + 3 = 8
        System.out.println("Subtração: " + calculadora.calcular(5, 3, subtracao)); // 5 - 3 = 2
        System.out.println("Multiplicação: " + calculadora.calcular(5, 3, multiplicacao)); // 5 * 3 = 15
    }
}
```

#### **Benefícios da Refatoração**
- O código está aberto para extensão (adicionar novas operações) e fechado para modificação.  
- Maior flexibilidade para adicionar funcionalidades sem impactar o código existente.  

---

### **Exercício 3: Princípio da Substituição de Liskov (LSP)**

#### **Introdução**
O LSP estabelece que objetos de uma classe derivada devem ser substituíveis por objetos da classe base sem afetar o funcionamento correto do programa.

#### **Contexto**
O sistema foi inicialmente implementado com uma classe `Quadrado` que estendia a classe `Retangulo`. Essa abordagem causou inconsistências no comportamento de `Quadrado`, pois a definição de largura e altura em `Retangulo` não se aplicava de maneira lógica a `Quadrado`.

#### **Refatoração**
- Criação da interface `Forma`, que define o método `getArea()`.  
- Separação das classes `Retangulo` e `Quadrado`, que agora implementam a interface `Forma`.  

#### **Código Refatorado**

```java
// Interface que define o contrato para formas geométricas
public interface Forma {
    int getArea();
}

// Classe Retangulo que implementa a interface Forma
public class Retangulo implements Forma {
    private int largura;
    private int altura;

    public Retangulo(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public int getArea() {
        return largura * altura;
    }
}

// Classe Quadrado que implementa a interface Forma
public class Quadrado implements Forma {
    private int lado;

    public Quadrado(int lado) {
        this.lado = lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public int getArea() {
        return lado * lado;
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        Forma retangulo = new Retangulo(5, 10);
        System.out.println("Área do Retângulo: " + retangulo.getArea());

        Forma quadrado = new Quadrado(4);
        System.out.println("Área do Quadrado: " + quadrado.getArea());
    }
}
```

#### **Benefícios da Refatoração**
- Garantia de que o sistema segue o Princípio da Substituição de Liskov.  
- Código mais sustentável e fácil de entender.  
- Separação clara das responsabilidades entre as classes.  

