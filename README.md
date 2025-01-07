

# **Princípios SOLID - Exercícios de Refatoração**

Os princípios SOLID são um conjunto de diretrizes para o design de software que ajudam a criar sistemas mais flexíveis, escaláveis e fáceis de manter. Este repositório apresenta exercícios práticos para aplicar os princípios SOLID em diferentes cenários.

Os princípios abordados são:

1. **SRP (Single Responsibility Principle)** - Princípio da Responsabilidade Única  
2. **OCP (Open/Closed Principle)** - Princípio Aberto/Fechado  
3. **LSP (Liskov Substitution Principle)** - Princípio da Substituição de Liskov  
4. **ISP (Interface Segregation Principle)** - Princípio da Segregação de Interfaces  

---

## **Exercício 1: Princípio da Responsabilidade Única (SRP)**

### **Descrição**
Refatorar uma classe que realiza múltiplas responsabilidades em classes separadas, cada uma com uma única responsabilidade.

### **Código Refatorado**
```java
public class GeradorRelatorio {
    public void gerarRelatorio() {
        System.out.println("Relatório financeiro gerado.");
    }
}

public class EnviadorEmail {
    public void enviarPorEmail(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

public class Main {
    public static void main(String[] args) {
        GeradorRelatorio gerador = new GeradorRelatorio();
        gerador.gerarRelatorio();

        EnviadorEmail enviador = new EnviadorEmail();
        enviador.enviarPorEmail("Relatório Financeiro 2025");
    }
}
```

---

## **Exercício 2: Princípio Aberto/Fechado (OCP)**

### **Descrição**
Refatorar uma calculadora para permitir a adição de novas operações sem modificar o código existente.

### **Código Refatorado**
```java
public interface Operacao {
    int calcular(int a, int b);
}

public class Soma implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a + b;
    }
}

public class Subtracao implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a - b;
    }
}

public class Multiplicacao implements Operacao {
    @Override
    public int calcular(int a, int b) {
        return a * b;
    }
}

public class Calculadora {
    public int calcular(int a, int b, Operacao operacao) {
        return operacao.calcular(a, b);
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        Operacao soma = new Soma();
        Operacao subtracao = new Subtracao();
        Operacao multiplicacao = new Multiplicacao();

        System.out.println("Soma: " + calculadora.calcular(5, 3, soma));
        System.out.println("Subtração: " + calculadora.calcular(5, 3, subtracao));
        System.out.println("Multiplicação: " + calculadora.calcular(5, 3, multiplicacao));
    }
}
```

---

## **Exercício 3: Princípio da Substituição de Liskov (LSP)**

### **Descrição**
Refatorar classes para garantir que objetos de classes derivadas possam substituir objetos da classe base sem alterar o comportamento do programa.

### **Código Refatorado**
```java
public interface Forma {
    int getArea();
}

public class Retangulo implements Forma {
    private int largura;
    private int altura;

    public Retangulo(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public int getArea() {
        return largura * altura;
    }
}

public class Quadrado implements Forma {
    private int lado;

    public Quadrado(int lado) {
        this.lado = lado;
    }

    @Override
    public int getArea() {
        return lado * lado;
    }
}

public class Main {
    public static void main(String[] args) {
        Forma retangulo = new Retangulo(5, 10);
        System.out.println("Área do Retângulo: " + retangulo.getArea());

        Forma quadrado = new Quadrado(4);
        System.out.println("Área do Quadrado: " + quadrado.getArea());
    }
}
```

---

## **Exercício 4: Princípio da Segregação de Interfaces (ISP)**

### **Descrição**
Refatorar uma interface grande em interfaces menores e mais específicas para evitar que classes sejam forçadas a implementar métodos que não utilizam.

### **Código Refatorado**
```java
public interface Programador {
    void programar();
}

public interface AtendenteDeCliente {
    void atenderCliente();
}

public class Desenvolvedor implements Programador {
    public void programar() {
        System.out.println("Programando...");
    }
}

public class Atendente implements AtendenteDeCliente {
    public void atenderCliente() {
        System.out.println("Atendendo cliente...");
    }
}

public class Main {
    public static void main(String[] args) {
        Programador desenvolvedor = new Desenvolvedor();
        desenvolvedor.programar();

        AtendenteDeCliente atendente = new Atendente();
        atendente.atenderCliente();
    }
}
```

---

## **Como Executar os Exercícios**

1. Clone este repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```
2. Compile os arquivos `.java`:
   ```bash
   javac *.java
   ```
3. Execute a classe `Main` correspondente ao exercício:
   ```bash
   java Main
   ```

---

## **Conclusão**

Os exercícios apresentados demonstram como aplicar os princípios SOLID para melhorar a qualidade do código, tornando-o mais modular, coeso e fácil de manter. Cada princípio foi abordado com exemplos práticos e refatorações que ilustram os benefícios de seguir essas diretrizes no desenvolvimento de software.
```

Este `README.md` inclui todos os quatro exercícios com explicações detalhadas, código refatorado e instruções de execução.
