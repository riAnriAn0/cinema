# 🎬 Sistema de Gerenciamento de Cinema

Projeto desenvolvido como atividade final da disciplina de **Programação Orientada a Objetos (POO)** no **Instituto Federal de Educação, Ciência e Tecnologia do Maranhão (IFMA) – Campus Caxias**.

**Professor:** Dr. Wilker Luz  
**Disciplina:** Programação Orientada a Objetos  
**Curso:** [Bacharelado em Ciência da Computação]  
**Autores:** Rian Silva e Giancandido Nascimento

---

## 📌 Objetivo

O objetivo do projeto é desenvolver um sistema orientado a objetos em **Java** para gerenciar um cinema com múltiplas salas, controle de assentos e regras de desconto na compra de ingressos, aplicando os principais conceitos da POO, como:

- Encapsulamento  
- Herança  
- Polimorfismo  
- Composição  

---

## 🛠️ Funcionalidades Principais

- Cadastro de filmes e alocação em salas;
- Visualização da ocupação das salas (assentos disponíveis e ocupados);
- Compra de ingressos com seleção da sala, fileira e número do assento;
- Aplicação de descontos de acordo com a categoria do comprador.

---

## 🏷️ Categorias e Descontos

| Categoria   | Desconto |
|-------------|----------|
| Normal      | 0%       |
| Estudante   | 50%      |
| Idoso (60+) | 100%     |
| Professor   | 30%      |

---

## 🏛️ Estrutura do Cinema

- 5 salas de cinema
- Cada sala contém 200 lugares, dispostos em:
  - 20 fileiras (de A a T)
  - 10 cadeiras por fileira
- Cada sala exibe um único filme por vez
- Admin 
  - login: rian ou gean 
  - senha: 1234
---

## 📦 Estrutura de Classes

- **Pessoa**: nome, idade, categoria (normal, estudante, idoso, professor)  
- **Filme**: título, duração (minutos), gênero  
- **Assento**: fileira (letra), número (1 a 10), status (ocupado ou não)  
- **Sala**: número da sala, matriz de assentos, filme em exibição  
- **Ingresso**: pessoa, sala, assento, preço final com desconto  
- **Cinema**: lista de salas, gerenciamento da venda de ingressos  

---

## ✅ Processo de Compra

1. Informar nome, idade e categoria da pessoa
2. Escolher a sala, fileira e número do assento
3. O sistema calcula e exibe o valor final com o desconto aplicado
4. O assento é marcado como ocupado

---

## 🧠 Conceitos de POO Aplicados

- **Encapsulamento**: proteção dos dados com métodos getters/setters  
- **Herança** e **Polimorfismo**: caso seja implementada especialização de classes  
- **Composição**: uma sala contém assentos e exibe um filme; um ingresso contém uma pessoa, sala e assento  
- **Uso de arrays/coleções** para representar os assentos e salas

---

## 💡 Funcionalidades Extras (Implementação Opcional)

- Geração de relatórios de ocupação por sala  
- Interface gráfica (JOptionPane ou JavaFX)  
- Histórico de compras  
- Exportação de dados em arquivos `.txt`  

---

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/riAnriAn0/cinema.git
   ```
2. Compile e execute a aplicação com o Java instalado:
   ```bash
   javac Main.java
   java Main
   ```
3. Siga as instruções no console ou interface gráfica (se aplicável).

---

## 📝 Licença

Este projeto é apenas para fins educacionais e acadêmicos.
