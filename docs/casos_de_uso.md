# Casos de Uso — MyBodyFitness

**Ator principal:** Cliente (Utilizador autenticado)
**Responsável:** Tomás Silva

---

## CU01 — Registar Peso e Medidas Corporais

**Ator:** Cliente  
**Pré-condições:** O utilizador está autenticado na aplicação.

**Fluxo Principal:**
1. O utilizador navega para a secção "Medidas".
2. O sistema apresenta o formulário de registo com os campos: peso (kg), altura (cm), peito (cm), cintura (cm) e anca (cm).
3. O utilizador preenche os campos pretendidos e confirma.
4. O sistema valida os valores introduzidos (devem ser numéricos e positivos).
5. O sistema calcula automaticamente o IMC com base no peso e altura.
6. O sistema guarda o registo com a data e hora atual.
7. O sistema apresenta uma mensagem de sucesso e atualiza o histórico de medidas.

**Fluxos Alternativos:**
- **4a.** Se algum valor for inválido (negativo, não numérico), o sistema assinala o campo com erro e não guarda o registo. O utilizador corrige e tenta novamente.
- **3a.** O utilizador pode preencher apenas o peso, sem as restantes medidas.

**Pós-condições:** O novo registo de medidas fica associado ao utilizador com a data atual.

---

## CU02 — Criar um Plano de Treino

**Ator:** Cliente  
**Pré-condições:** O utilizador está autenticado. Existem exercícios disponíveis no sistema.

**Fluxo Principal:**
1. O utilizador navega para "Planos de Treino" e seleciona "Criar novo plano".
2. O sistema apresenta um formulário com campos: nome do plano, descrição e visibilidade (público/privado).
3. O utilizador preenche o nome e clica em "Adicionar exercício".
4. O sistema apresenta a lista de exercícios disponíveis, com filtro por grupo muscular.
5. O utilizador seleciona um exercício e define o número de séries planeadas.
6. O sistema adiciona o exercício ao plano. Os passos 3-5 repetem-se para cada exercício.
7. O utilizador clica em "Guardar plano".
8. O sistema valida que o plano tem pelo menos um exercício e guarda.
9. O sistema confirma a criação e redireciona para a página do plano.

**Fluxos Alternativos:**
- **7a.** Se o plano estiver vazio (sem exercícios), o sistema apresenta mensagem de erro e não guarda.
- **4a.** Se não existirem exercícios disponíveis, o sistema informa o utilizador.

**Pós-condições:** O plano de treino fica guardado e associado ao utilizador criador.

---

## CU03 — Partilhar o Próprio Plano de Treino

**Ator:** Cliente  
**Pré-condições:** O utilizador está autenticado e tem pelo menos um plano de treino criado.

**Fluxo Principal:**
1. O utilizador acede à página do plano de treino que pretende partilhar.
2. O utilizador clica em "Tornar público".
3. O sistema altera a visibilidade do plano para "público".
4. O sistema confirma a alteração e apresenta um link de partilha.
5. O plano passa a aparecer na pesquisa pública de planos de outros utilizadores.

**Fluxos Alternativos:**
- **2a.** O utilizador pode reverter a decisão clicando em "Tornar privado", tornando o plano invisível para outros utilizadores.

**Pós-condições:** O plano fica visível para todos os utilizadores da aplicação.

---

## CU04 — Seguir um Plano de Treino de Outro Utilizador

**Ator:** Cliente  
**Pré-condições:** O utilizador está autenticado. Existem planos públicos disponíveis.

**Fluxo Principal:**
1. O utilizador navega para "Explorar planos" ou pesquisa por nome/grupo muscular.
2. O sistema lista os planos públicos de outros utilizadores.
3. O utilizador seleciona um plano e visualiza os seus detalhes (exercícios, séries, descrição).
4. O utilizador clica em "Seguir este plano".
5. O sistema cria uma cópia do plano associada ao utilizador.
6. O sistema confirma e o plano passa a aparecer na lista de planos do utilizador.

**Fluxos Alternativos:**
- **4a.** Se o utilizador já segue o plano, o sistema informa que o plano já está na sua lista.

**Pós-condições:** O plano copiado fica disponível na lista de planos do utilizador para usar em treinos.

---

## CU05 — Registar um Treino

**Ator:** Cliente  
**Pré-condições:** O utilizador está autenticado e tem pelo menos um plano de treino.

**Fluxo Principal:**
1. O utilizador navega para "Iniciar treino".
2. O sistema apresenta a lista de planos de treino do utilizador e pede para escolher o ginásio (da lista de preferidos ou novo).
3. O utilizador seleciona o plano e o ginásio onde vai treinar.
4. O sistema verifica quais os exercícios do plano cujo equipamento está disponível no ginásio selecionado.
5. Para exercícios sem equipamento disponível, o sistema sugere exercícios alternativos equivalentes.
6. O sistema apresenta o plano adaptado ao ginásio, exercício a exercício.
7. Para cada exercício, o utilizador regista: número de séries, carga (kg) e repetições por série.
8. O sistema guarda cada série à medida que é confirmada.
9. O utilizador conclui o treino clicando em "Terminar treino".
10. O sistema guarda a sessão de treino com data, duração e ginásio.
11. O sistema apresenta um resumo do treino realizado.

**Fluxos Alternativos:**
- **3a.** Se o utilizador quiser adicionar um ginásio novo, introduz o nome e pode optar por guardá-lo nas preferências.
- **7a.** O utilizador pode saltar um exercício sem registar séries.
- **9a.** Se o utilizador fechar a app durante o treino, o sistema guarda o progresso parcial e permite retomar.

**Pós-condições:** A sessão de treino fica registada no histórico do utilizador, com todas as séries, cargas e repetições.

---

## CU06 — Consultar o Histórico de Treinos

**Ator:** Cliente  
**Pré-condições:** O utilizador está autenticado e tem pelo menos uma sessão de treino registada.

**Fluxo Principal:**
1. O utilizador navega para "Histórico de Treinos".
2. O sistema apresenta a lista de sessões de treino ordenadas da mais recente para a mais antiga, num calendário e em lista.
3. O utilizador seleciona uma sessão.
4. O sistema apresenta os detalhes: data, ginásio, duração, plano utilizado e todas as séries realizadas (exercício, carga, repetições).

**Fluxos Alternativos:**
- **2a.** O utilizador pode filtrar por intervalo de datas ou por plano de treino.

**Pós-condições:** Nenhuma alteração ao estado do sistema.

---

## CU07 — Consultar Histórico de Progressão de Peso e Medidas

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

## CU08 — Consultar Recordes de Carga Levantada

**Ator:** Cliente  
**Pré-condições:** O utilizador está autenticado e tem pelo menos uma sessão de treino registada.

**Fluxo Principal:**
1. O utilizador navega para "Recordes".
2. O sistema calcula e apresenta, para cada exercício já realizado, a maior carga registada (1RM — repetição máxima) e a data em que foi atingida.
3. O utilizador pode selecionar um exercício específico para ver a progressão da carga ao longo do tempo num gráfico.
4. O sistema apresenta o gráfico de evolução da carga máxima para esse exercício.

**Fluxos Alternativos:**
- **2a.** Se o utilizador ainda não tiver séries registadas para nenhum exercício, o sistema apresenta uma mensagem informativa.

**Pós-condições:** Nenhuma alteração ao estado do sistema.
