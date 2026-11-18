<img width="3280" height="1848" alt="FuelCalculator" src="https://github.com/user-attachments/assets/998d6c22-4b42-4d08-a7cd-b8196f1ef434" />

## 📱 Sobre o Projeto

A Calculadora de Combustível é um aplicativo nativo para Android desenvolvido em Kotlin. O objetivo do app é oferecer uma ferramenta intuitiva para motoristas estimarem o custo total de deslocamentos e viagens com base na distância percorrida, no consumo médio do veículo e no preço atual do combustível.

Além do cálculo prático, o projeto foi construído com foco em boas práticas de desenvolvimento Android, garantindo uma experiência de usuário (UX) fluida, validação segura de dados e controle rigoroso da pilha de navegação.

---

## 🌍 Funcionalidades e Diferenciais Técnicos

* Fluxo Intuitivo em Etapas: Navegação guiada dividida em telas claras (*Início → Distância → Consumo → Preço → Resultado*).
* Validação de Inputs: Tratamento de campos obrigatórios e conversão segura de valores numéricos (toDoubleOrNull()) para evitar falhas por entradas vazias ou inválidas.
* Formatação Regional: Exibição dos valores finais adaptada ao padrão monetário brasileiro (R$) e unidades de medida claras (km, km/l).
* Gerenciamento Avançado da Back Stack: Uso estratégico de Intent flags no botão "Calcular novamente", limpando o histórico de telas antigas e evitando loops de navegação.
* Controle do Botão Voltar: Interceptação personalizada do gesto/botão físico de voltar (onBackPressedDispatcher) na tela de resultado com finishAffinity(), encerrando a aplicação de forma limpa sem retornar a etapas já concluídas.

---

## 🛠️ Tecnologias Utilizadas

* Linguagem: Kotlin
* IDE: Android Studio
- Activities
- **Interface (UI) com XML:**
  - TextView
  - EditText
  - Button
  - Toolbar (navegação superior)
- Validação de campos
- **Navegação entre telas com Intent e Flags** (prevenção de loops)
- **Passagem de dados entre telas com Bundle**
- Controle do botão voltar (onBackPressedDispatcher)
- Formatação monetária (R$)
- Organização básica de layouts e telas

---

## 👩‍💻 Autora

Desenvolvido por Isabela Miléo

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/IsabelaMileo)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/isabelamileo/)
