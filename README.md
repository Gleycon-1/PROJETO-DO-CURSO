# MAIN_SYSTEM_PAYROLL - ORACLE DUAL

## 📄 DESCRIÇÃO
O **MAIN_SYSTEM_PAYROLL** é um motor de processamento de folha de pagamento desenvolvido em **Java**. O sistema foi projetado para gerenciar diferentes modalidades de contratos (Padrão, Comissionado e Produção), garantindo precisão nos cálculos e integridade dos dados através de validações rigorosas.

## 📊 FLUXOGRAMA DE LÓGICA
O sistema segue uma estrutura lógica de decisão e repetição para garantir que nenhum dado seja processado incorretamente.

![Fluxograma do Sistema](./fluxograma.png)
*O diagrama acima detalha o percurso desde a entrada de dados via Scanner até a persistência no ArrayList.*

## 🚀 FUNCIONALIDADES
- **CADASTRO MULTIMODAL:** Suporte a funcionários padrão, comissionados e de produção.
- **MOTOR DE CÁLCULO:** Processamento automático de bônus e comissões sobre o salário base de R$ 2.000,00.
- **PERSISTÊNCIA EM MEMÓRIA:** Uso de `ArrayList` para gestão dinâmica de registros.
- **VALIDAÇÃO DE DADOS:** Travas lógicas para impedir a entrada de valores negativos.

## 🛠️ TECNOLOGIAS E CONCEITOS
- **Linguagem:** Java (JDK 17+)
- **Entrada/Saída:** `java.util.Scanner`
- **Estruturas de Dados:** `ArrayList` para coleções de objetos.
- **Controle de Fluxo:** Estruturas `while` e `switch-case` para interface de terminal.

## ⚙️ COMO EXECUTAR
1. Certifique-se de ter o JDK instalado.
2. Compile o arquivo:
   ```bash
   javac MAIN_SYSTEM_PAYROLL.java
