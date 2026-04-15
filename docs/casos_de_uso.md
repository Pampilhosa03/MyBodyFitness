# Casos de Uso — MyBodyFitness
*(Metodologia ICONIX)*

---

## Atores

| Ator | Descrição |
|------|-----------|
| **Administrador Geral** | Responsável pela manutenção técnica da plataforma e integração de ginásios parceiros. |
| **Administrador Local** | Gestor de um ginásio parceiro; gere o catálogo de exercícios e consulta estatísticas locais. |
| **Cliente** | Utilizador autenticado que utiliza a app para treinar, registar progresso e explorar planos. |

---

## 1. Administrador Geral

---

### UC01 — Gerir Atualizações do Sistema

**Ator Primário:** Administrador Geral

**Descrição Breve:** O administrador revê e aplica atualizações de software à plataforma.

**Pré-condições:** O administrador está autenticado com permissões de sistema.

**Pós-condições:** A plataforma corre a nova versão e o evento fica registado no histórico.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Atualizações" no painel de administração. | |
| 2 | | Apresenta a versão atual e as atualizações pendentes. |
| 3 | Revê as notas de versão e confirma a aplicação da atualização. | |
| 4 | | Coloca a plataforma em modo de manutenção e aplica a atualização. |
| 5 | | Reinicia os serviços necessários e regista a operação no log. |
| 6 | | Apresenta confirmação de sucesso com a nova versão ativa. |

**Cursos Alternativos:**
- **A1 (passo 4):** Se a atualização falhar, o sistema reverte para a versão anterior e notifica o administrador com a descrição do erro.

---

### UC02 — Gerir Integração de Ginásios

**Ator Primário:** Administrador Geral

**Descrição Breve:** O administrador integra um novo ginásio parceiro na plataforma ou desativa um existente.

**Pré-condições:** O administrador está autenticado. Existe um pedido de parceria de um ginásio.

**Pós-condições:** O ginásio fica registado na plataforma e o seu Administrador Local tem acesso ao painel de gestão.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Acede a "Ginásios Parceiros" e seleciona "Novo ginásio". | |
| 2 | | Apresenta o formulário de integração: nome, morada, contacto e catálogo inicial de equipamentos. |
| 3 | Preenche os dados e confirma. | |
| 4 | | Valida os dados e cria o perfil do Ginásio na plataforma. |
| 5 | | Gera credenciais para o Administrador Local e envia por e-mail. |
| 6 | | Ativa o ginásio e torna-o visível para os clientes. |

**Cursos Alternativos:**
- **A1 (passo 3):** Se dados obrigatórios estiverem em falta, o sistema assinala os campos inválidos e não cria o perfil.
- **A2 (passo 1):** O administrador seleciona um ginásio existente e escolhe "Desativar"; o sistema torna-o invisível para os clientes sem apagar os dados.

---

## 2. Administrador Local

---

### UC03 — Gerir Catálogo de Exercícios do Ginásio

**Ator Primário:** Administrador Local

**Descrição Breve:** O administrador local adiciona, edita ou remove exercícios do catálogo do seu ginásio.

**Pré-condições:** O Administrador Local está autenticado no painel do seu ginásio.

**Pós-condições:** O catálogo do Ginásio fica atualizado e as sugestões automáticas de treino refletem a mudança.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Catálogo de Exercícios". | |
| 2 | | Apresenta a lista de Exercícios atualmente disponíveis no ginásio. |
| 3 | Seleciona "Adicionar exercício" e escolhe um Exercício da biblioteca global. | |
| 4 | Confirma a adição. | |
| 5 | | Associa o Exercício ao catálogo do Ginásio. |
| 6 | | O exercício passa a ser sugerido aos clientes que treinem neste ginásio. |

**Cursos Alternativos:**
- **A1 (passo 3):** O administrador seleciona "Remover exercício" (ex.: equipamento avariado); o sistema retira-o das sugestões automáticas para esse ginásio.
- **A2 (passo 3):** O administrador seleciona "Editar exercício" e altera os detalhes (ex.: número de máquinas disponíveis); o sistema guarda as alterações.

---

### UC04 — Consultar Estatísticas de Utilização

**Ator Primário:** Administrador Local

**Descrição Breve:** O administrador local consulta o dashboard de estatísticas de utilização do seu ginásio.

**Pré-condições:** O Administrador Local está autenticado. Existem SessõesDeTreino registadas no ginásio.

**Pós-condições:** Nenhuma alteração ao estado do sistema.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Estatísticas". | |
| 2 | | Apresenta um dashboard com: número de treinos realizados, exercícios mais utilizados e horários de maior afluência. |
| 3 | Define um intervalo de datas e aplica o filtro. | |
| 4 | | Atualiza os gráficos de acordo com o filtro aplicado. |

**Cursos Alternativos:**
- **A1 (passo 2):** Se não existirem dados suficientes, o sistema apresenta uma mensagem informativa.

---

## 3. Cliente

---

### UC05 — Gerir Perfil Biométrico

**Ator Primário:** Cliente

**Descrição Breve:** O cliente regista as suas medidas corporais e peso, e consulta o respetivo histórico.

**Pré-condições:** O Cliente está autenticado na aplicação.

**Pós-condições:** O novo registo de Medida fica associado ao utilizador com a data atual.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para a secção "Medidas". | |
| 2 | | Apresenta o formulário com os campos: peso (kg), altura (cm), peito (cm), cintura (cm). |
| 3 | Preenche os campos pretendidos e confirma. | |
| 4 | | Valida os valores introduzidos (devem ser numéricos e positivos). |
| 5 | | Calcula automaticamente o IMC com base no peso e na altura. |
| 6 | | Guarda a Medida com a data e hora atual. |
| 7 | | Apresenta mensagem de sucesso e atualiza o histórico de medidas. |

**Cursos Alternativos:**
- **A1 (passo 4):** Se algum valor for inválido (negativo ou não numérico), o sistema assinala o campo com erro e não guarda o registo.
- **A2 (passo 3):** O cliente pode preencher apenas o peso, sem as restantes medidas.

---

### UC06 — Criar Plano de Treino

**Ator Primário:** Cliente

**Descrição Breve:** O cliente cria um novo PlanoDeTreino, selecionando exercícios e definindo séries.

**Pré-condições:** O Cliente está autenticado. Existem Exercícios disponíveis no sistema.

**Pós-condições:** O PlanoDeTreino fica guardado e associado ao utilizador criador.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Planos de Treino" e seleciona "Criar novo plano". | |
| 2 | | Apresenta o formulário: nome do plano, descrição e visibilidade (público/privado). |
| 3 | Preenche o nome e clica em "Adicionar exercício". | |
| 4 | | Apresenta a lista de Exercícios disponíveis com filtro por grupo muscular. |
| 5 | Seleciona um Exercício e define o número de séries planeadas. | |
| 6 | | Adiciona o Exercício ao PlanoDeTreino. |
| 7 | Repete os passos 3–6 para cada exercício desejado e clica em "Guardar plano". | |
| 8 | | Valida que o plano tem pelo menos um Exercício e guarda o PlanoDeTreino. |
| 9 | | Confirma a criação e redireciona para a página do plano. |

**Cursos Alternativos:**
- **A1 (passo 8):** Se o plano não tiver exercícios, o sistema apresenta mensagem de erro e não guarda.
- **A2 (passo 4):** Se não existirem exercícios disponíveis, o sistema informa o utilizador.

---

### UC07 — Iniciar Treino com Adaptação de Local

**Ator Primário:** Cliente

**Descrição Breve:** O cliente inicia uma SessaoDeTreino com base num PlanoDeTreino, com adaptação automática ao ginásio escolhido.

**Pré-condições:** O Cliente está autenticado e tem pelo menos um PlanoDeTreino criado.

**Pós-condições:** A SessaoDeTreino fica registada no histórico do utilizador com todas as Séries, cargas e repetições.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Iniciar Treino". | |
| 2 | | Apresenta a lista de PlanosDeTreino do utilizador e solicita a escolha do Ginásio. |
| 3 | Seleciona o PlanoDeTreino e o Ginásio onde vai treinar. | |
| 4 | | Verifica quais os Exercícios do plano cujo Equipamento está disponível no Ginásio selecionado. |
| 5 | | Para exercícios sem Equipamento disponível, sugere Exercícios alternativos do mesmo grupo muscular. |
| 6 | | Apresenta o plano adaptado ao Ginásio, exercício a exercício. |
| 7 | Para cada Exercício, regista número de séries, carga (kg) e repetições. | |
| 8 | | Guarda cada Série à medida que é confirmada. |
| 9 | Clica em "Terminar treino". | |
| 10 | | Guarda a SessaoDeTreino com data, duração e Ginásio. |
| 11 | | Apresenta o resumo do treino realizado. |

**Cursos Alternativos:**
- **A1 (passo 3):** O cliente escolhe "Adicionar ginásio"; o sistema permite introduzir um novo Ginásio e guardá-lo nas preferências.
- **A2 (passo 7):** O cliente salta um exercício sem registar séries; o sistema avança para o próximo.
- **A3 (passo 9):** Se o cliente fechar a app durante o treino, o sistema guarda o progresso parcial e permite retomar a sessão.

---

### UC08 — Partilhar / Importar Planos de Treino

**Ator Primário:** Cliente

**Descrição Breve:** O cliente torna um PlanoDeTreino público para partilha, ou importa um plano público de outro utilizador.

**Pré-condições:** O Cliente está autenticado.

**Pós-condições (Partilhar):** O PlanoDeTreino fica público e visível na pesquisa de outros utilizadores.

**Pós-condições (Importar):** Uma cópia do PlanoDeTreino fica disponível na lista do utilizador importador.

**Fluxo Principal — Partilhar:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Acede à página do PlanoDeTreino e clica em "Tornar público". | |
| 2 | | Altera a visibilidade do PlanoDeTreino para "público". |
| 3 | | Apresenta confirmação e um link de partilha. |
| 4 | | O plano passa a aparecer na pesquisa pública. |

**Fluxo Principal — Importar:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Explorar planos" e pesquisa por nome ou grupo muscular. | |
| 2 | | Lista os PlanosDeTreino públicos de outros utilizadores. |
| 3 | Seleciona um plano e visualiza os seus detalhes. | |
| 4 | Clica em "Seguir este plano". | |
| 5 | | Cria uma cópia do PlanoDeTreino associada ao utilizador. |
| 6 | | O plano passa a aparecer na lista de PlanosDeTreino do utilizador. |

**Cursos Alternativos:**
- **A1 — Partilhar (passo 1):** O cliente clica em "Tornar privado"; o sistema reverte a visibilidade e o plano deixa de aparecer na pesquisa pública.
- **A2 — Importar (passo 4):** Se o cliente já segue o plano, o sistema informa que o plano já está na sua lista.

---

### UC09 — Analisar Progresso Visual

**Ator Primário:** Cliente

**Descrição Breve:** O cliente visualiza gráficos de evolução das suas métricas corporais ao longo do tempo.

**Pré-condições:** O Cliente está autenticado e tem pelo menos dois registos de Medida.

**Pós-condições:** Nenhuma alteração ao estado do sistema.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Progressão". | |
| 2 | | Apresenta um gráfico de linha com a evolução do peso ao longo do tempo. |
| 3 | Seleciona uma métrica alternativa (IMC, peito, cintura, anca). | |
| 4 | | Atualiza o gráfico com a métrica selecionada. |
| 5 | Ajusta o intervalo temporal (último mês, 3 meses, 6 meses, 1 ano, tudo). | |
| 6 | | Atualiza o gráfico com o intervalo selecionado. |

**Cursos Alternativos:**
- **A1 (passo 2):** Se existir apenas um registo de Medida, o sistema avisa que são necessários pelo menos dois registos para mostrar evolução.

---

### UC10 — Consultar Calendário de Atividade

**Ator Primário:** Cliente

**Descrição Breve:** O cliente consulta o histórico de SessõesDeTreino num calendário e visualiza os detalhes de cada sessão.

**Pré-condições:** O Cliente está autenticado e tem pelo menos uma SessaoDeTreino registada.

**Pós-condições:** Nenhuma alteração ao estado do sistema.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Histórico de Treinos". | |
| 2 | | Apresenta um calendário com os dias de treino assinalados e a lista das sessões mais recentes. |
| 3 | Seleciona uma sessão no calendário ou na lista. | |
| 4 | | Apresenta os detalhes: data, Ginásio, duração, PlanoDeTreino utilizado e todas as Séries realizadas. |

**Cursos Alternativos:**
- **A1 (passo 2):** O cliente aplica um filtro por intervalo de datas ou por PlanoDeTreino; o sistema atualiza o calendário e a lista.

---

### UC11 — Consultar Recordes de Carga Levantada

**Ator Primário:** Cliente

**Descrição Breve:** O cliente consulta os seus recordes de carga por exercício e visualiza a progressão ao longo do tempo.

**Pré-condições:** O Cliente está autenticado e tem pelo menos uma SessaoDeTreino com Séries registadas.

**Pós-condições:** Nenhuma alteração ao estado do sistema.

**Fluxo Principal:**

| # | Ator | Sistema |
|---|------|---------|
| 1 | Navega para "Recordes". | |
| 2 | | Calcula e apresenta, para cada Exercício já realizado, a maior carga registada (1RM) e a data em que foi atingida. |
| 3 | Seleciona um Exercício específico. | |
| 4 | | Apresenta o gráfico de evolução da carga máxima ao longo do tempo para esse Exercício. |

**Cursos Alternativos:**
- **A1 (passo 2):** Se o utilizador ainda não tiver Séries registadas, o sistema apresenta uma mensagem informativa.
