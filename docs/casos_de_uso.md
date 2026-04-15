# Casos de Uso — MyBodyFitness

---

## Atores

| Ator | Descrição |
|------|-----------|
| **Administrador Geral** | Responsável pela manutenção técnica da plataforma e integração de ginásios parceiros. |
| **Administrador Local** | Gestor de um ginásio parceiro; gere o catálogo de exercícios e consulta estatísticas locais. |
| **Cliente** | Utilizador autenticado que utiliza a app para treinar, registar progresso e explorar planos. |

> **Nota:** Autenticação e gestão de ginásios preferidos são pré-condições dos casos de uso, não casos de uso independentes.

---

## 1. Administrador Geral

### UC01 — Gerir Atualizações do Sistema

**Ator:** Administrador Geral
**Pré-condições:** O administrador está autenticado com permissões de sistema.

**Fluxo Principal:**
1. O administrador acede ao painel de administração e navega para "Atualizações".
2. O sistema apresenta a versão atual e eventuais atualizações pendentes.
3. O administrador revê as notas de versão e confirma a aplicação da atualização.
4. O sistema coloca a plataforma em modo de manutenção e aplica a atualização.
5. O sistema reinicia os serviços necessários e regista a operação no log.
6. O sistema confirma o sucesso da atualização e apresenta a nova versão ativa.

**Fluxos Alternativos:**
- **4a.** Se a atualização falhar, o sistema reverte para a versão anterior e notifica o administrador com o erro.

**Pós-condições:** A plataforma corre a nova versão e o evento fica registado no histórico.

---

### UC02 — Gerir Integração de Ginásios

**Ator:** Administrador Geral
**Pré-condições:** O administrador está autenticado. Existe um pedido de parceria de um ginásio.

**Fluxo Principal:**
1. O administrador acede a "Ginásios Parceiros" e seleciona "Novo ginásio".
2. O sistema apresenta o formulário de integração: nome, morada, contacto e catálogo inicial de equipamentos.
3. O administrador preenche os dados e confirma.
4. O sistema valida os dados e cria o perfil do ginásio na plataforma.
5. O sistema gera credenciais para o Administrador Local do ginásio e envia por e-mail.
6. O ginásio fica ativo e visível para os clientes.

**Fluxos Alternativos:**
- **3a.** Se dados obrigatórios estiverem em falta, o sistema assinala os campos e não cria o perfil.
- **6a.** O administrador pode desativar um ginásio existente, tornando-o invisível para os clientes sem apagar os dados.

**Pós-condições:** O ginásio fica registado na plataforma e o seu administrador local tem acesso ao painel de gestão.

---

## 2. Administrador Local

### UC03 — Gerir Catálogo de Exercícios do Ginásio

**Ator:** Administrador Local
**Pré-condições:** O administrador local está autenticado no painel do seu ginásio.

**Fluxo Principal:**
1. O administrador navega para "Catálogo de Exercícios".
2. O sistema apresenta a lista de exercícios atualmente disponíveis no ginásio.
3. O administrador seleciona "Adicionar exercício", escolhe da biblioteca global e confirma.
4. O sistema associa o exercício ao catálogo do ginásio.
5. O exercício passa a ser sugerido aos clientes que treinem neste ginásio.

**Fluxos Alternativos:**
- **3a.** O administrador pode remover um exercício do catálogo (ex: equipamento avariado); o sistema retira-o das sugestões automáticas para esse ginásio.
- **3b.** O administrador pode editar os detalhes de um exercício existente (ex: número de máquinas disponíveis).

**Pós-condições:** O catálogo do ginásio fica atualizado e as adaptações automáticas de treino refletem a mudança.

---

### UC04 — Consultar Estatísticas de Utilização

**Ator:** Administrador Local
**Pré-condições:** O administrador local está autenticado. Existem sessões de treino registadas no ginásio.

**Fluxo Principal:**
1. O administrador navega para "Estatísticas".
2. O sistema apresenta um dashboard com: número de treinos realizados no ginásio, exercícios mais utilizados e horários de maior afluência.
3. O administrador pode filtrar por intervalo de datas.
4. O sistema atualiza os gráficos de acordo com o filtro aplicado.

**Fluxos Alternativos:**
- **2a.** Se ainda não houver dados suficientes, o sistema apresenta uma mensagem informativa.

**Pós-condições:** Nenhuma alteração ao estado do sistema.

---

## 3. Cliente

### UC05 — Gerir Perfil Biométrico

**Ator:** Cliente
**Pré-condições:** O utilizador está autenticado na aplicação.

**Fluxo Principal:**
1. O utilizador navega para a secção "Medidas".
2. O sistema apresenta o formulário de registo com os campos: peso (kg), altura (cm), peito (cm), cintura (cm).
3. O utilizador preenche os campos pretendidos e confirma.
4. O sistema valida os valores introduzidos (devem ser numéricos e positivos).
5. O sistema calcula automaticamente o IMC com base no peso e altura.
6. O sistema guarda o registo com a data e hora atual.
7. O sistema apresenta uma mensagem de sucesso e atualiza o histórico de medidas.

**Fluxos Alternativos:**
- **4a.** Se algum valor for inválido (negativo, não numérico), o sistema assinala o campo com erro e não guarda o registo.
- **3a.** O utilizador pode preencher apenas o peso, sem as restantes medidas.

**Pós-condições:** O novo registo de medidas fica associado ao utilizador com a data atual.

---

### UC06 — Criar Plano de Treino

**Ator:** Cliente
**Pré-condições:** O utilizador está autenticado. Existem exercícios disponíveis no sistema.

**Fluxo Principal:**
1. O utilizador navega para "Planos de Treino" e seleciona "Criar novo plano".
2. O sistema apresenta um formulário com campos: nome do plano, descrição e visibilidade (público/privado).
3. O utilizador preenche o nome e clica em "Adicionar exercício".
4. O sistema apresenta a lista de exercícios disponíveis, com filtro por grupo muscular.
5. O utilizador seleciona um exercício e define o número de séries planeadas.
6. O sistema adiciona o exercício ao plano. Os passos 3–5 repetem-se para cada exercício.
7. O utilizador clica em "Guardar plano".
8. O sistema valida que o plano tem pelo menos um exercício e guarda.
9. O sistema confirma a criação e redireciona para a página do plano.

**Fluxos Alternativos:**
- **7a.** Se o plano estiver vazio (sem exercícios), o sistema apresenta mensagem de erro e não guarda.
- **4a.** Se não existirem exercícios disponíveis, o sistema informa o utilizador.

**Pós-condições:** O plano de treino fica guardado e associado ao utilizador criador.

---

### UC07 — Iniciar Treino com Adaptação de Local

**Ator:** Cliente
**Pré-condições:** O utilizador está autenticado e tem pelo menos um plano de treino.

**Fluxo Principal:**
1. O utilizador navega para "Iniciar Treino".
2. O sistema apresenta a lista de planos de treino do utilizador e pede para escolher o ginásio (da lista de preferidos ou novo).
3. O utilizador seleciona o plano e o ginásio onde vai treinar.
4. O sistema verifica quais os exercícios do plano cujo equipamento está disponível no ginásio selecionado.
5. Para exercícios sem equipamento disponível, o sistema sugere automaticamente exercícios alternativos que trabalham o mesmo grupo muscular.
6. O sistema apresenta o plano adaptado ao ginásio, exercício a exercício.
7. Para cada exercício, o utilizador regista: número de séries, carga (kg) e repetições por série.
8. O sistema guarda cada série à medida que é confirmada.
9. O utilizador conclui o treino clicando em "Terminar treino".
10. O sistema guarda a sessão de treino com data, duração e ginásio.
11. O sistema apresenta um resumo do treino realizado.

**Fluxos Alternativos:**
- **3a.** Se o utilizador quiser adicionar um ginásio novo, introduz o nome e pode guardá-lo nas preferências.
- **7a.** O utilizador pode saltar um exercício sem registar séries.
- **9a.** Se o utilizador fechar a app durante o treino, o sistema guarda o progresso parcial e permite retomar.

**Pós-condições:** A sessão de treino fica registada no histórico do utilizador, com todas as séries, cargas e repetições.

---

### UC08 — Partilhar / Importar Planos de Treino

**Ator:** Cliente
**Pré-condições:** O utilizador está autenticado.

**Fluxo Principal — Partilhar:**
1. O utilizador acede à página do plano de treino que pretende partilhar.
2. O utilizador clica em "Tornar público".
3. O sistema altera a visibilidade do plano para "público".
4. O sistema confirma a alteração e apresenta um link de partilha.
5. O plano passa a aparecer na pesquisa pública de outros utilizadores.

**Fluxo Principal — Importar:**
1. O utilizador navega para "Explorar planos" ou pesquisa por nome/grupo muscular.
2. O sistema lista os planos públicos de outros utilizadores.
3. O utilizador seleciona um plano e visualiza os seus detalhes (exercícios, séries, descrição).
4. O utilizador clica em "Seguir este plano".
5. O sistema cria uma cópia do plano associada ao utilizador.
6. O plano passa a aparecer na lista de planos do utilizador.

**Fluxos Alternativos:**
- **2a (Partilhar).** O utilizador pode reverter clicando em "Tornar privado", tornando o plano invisível para outros.
- **4a (Importar).** Se o utilizador já segue o plano, o sistema informa que o plano já está na sua lista.

**Pós-condições:** O plano fica público/privado conforme a escolha, ou a cópia importada fica disponível na lista do utilizador.

---

### UC09 — Analisar Progresso Visual

**Ator:** Cliente
**Pré-condições:** O utilizador está autenticado e tem pelo menos dois registos de medidas.

**Fluxo Principal:**
1. O utilizador navega para "Progressão".
2. O sistema apresenta um gráfico de linha com a evolução do peso ao longo do tempo.
3. O utilizador pode alternar entre métricas: peso, IMC, peito, cintura, anca.
4. O sistema atualiza o gráfico de acordo com a métrica selecionada.
5. O utilizador pode ajustar o intervalo temporal (último mês, 3 meses, 6 meses, 1 ano, tudo).

**Fluxos Alternativos:**
- **2a.** Se só existir um registo, o sistema avisa que são necessários pelo menos dois registos para mostrar evolução.

**Pós-condições:** Nenhuma alteração ao estado do sistema.

---

### UC10 — Consultar Calendário de Atividade

**Ator:** Cliente
**Pré-condições:** O utilizador está autenticado e tem pelo menos uma sessão de treino registada.

**Fluxo Principal:**
1. O utilizador navega para "Histórico de Treinos".
2. O sistema apresenta um calendário com os dias em que foram realizados treinos assinalados, e em lista abaixo as sessões mais recentes.
3. O utilizador seleciona uma sessão no calendário ou na lista.
4. O sistema apresenta os detalhes: data, ginásio, duração, plano utilizado e todas as séries realizadas (exercício, carga, repetições).

**Fluxos Alternativos:**
- **2a.** O utilizador pode filtrar por intervalo de datas ou por plano de treino.

**Pós-condições:** Nenhuma alteração ao estado do sistema.

---

### UC11 — Consultar Recordes de Carga Levantada

**Ator:** Cliente
**Pré-condições:** O utilizador está autenticado e tem pelo menos uma sessão de treino registada.

**Fluxo Principal:**
1. O utilizador navega para "Recordes".
2. O sistema calcula e apresenta, para cada exercício já realizado, a maior carga registada (1RM) e a data em que foi atingida.
3. O utilizador pode selecionar um exercício específico para ver a progressão da carga ao longo do tempo num gráfico.
4. O sistema apresenta o gráfico de evolução da carga máxima para esse exercício.

**Fluxos Alternativos:**
- **2a.** Se o utilizador ainda não tiver séries registadas, o sistema apresenta uma mensagem informativa.

**Pós-condições:** Nenhuma alteração ao estado do sistema.
