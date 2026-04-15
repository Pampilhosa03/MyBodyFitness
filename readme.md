MyBodyFitness

A app é suposto permitir que uma pessoa que faz musculação permitir registir os seus treinos , os seus pesos e os seus progressos 

Luis Pampihosa
Rodrigo Lopes
Tomas Silva

- Criar um plano de treino.
- Consultar o histórico de treinos
- Consultar recordes de carga levantada.

2. Cada um cria a sua branch

# Membro A
git checkout -b feature/uc05-medidas

# Membro B
git checkout -b feature/uc06-planos

# Membro C
git checkout -b feature/uc07-treino
3. O que cada um implementa
O padrão é sempre o mesmo: Service → Controller → Templates

Membro A — UC05 Medidas
Criar estes 3 ficheiros:

service/MedidaService.java — lógica de negócio
controller/MedidaController.java — rotas HTTP
templates/medidas/lista.html + templates/medidas/nova.html — páginas

Rotas a implementar:

Rota	O que faz
GET /medidas	lista o histórico de medidas do utilizador
GET /medidas/nova	mostra o formulário
POST /medidas/nova	guarda a medida e calcula o IMC
Membro B — UC06 Planos de Treino
service/PlanoDeTreinoService.java
controller/PlanoDeTreinoController.java
templates/planos/lista.html + templates/planos/criar.html

Rotas:

Rota	O que faz
GET /planos	lista os planos do utilizador
GET /planos/criar	formulário de criação
POST /planos/criar	guarda o plano com os exercícios
Membro C — UC07 Iniciar Treino
service/SessaoTreinoService.java
controller/SessaoTreinoController.java
templates/treino/iniciar.html + templates/treino/sessao.html + templates/treino/resumo.html

Rotas:

Rota	O que faz
GET /treino/iniciar	escolher plano e ginásio
POST /treino/iniciar	cria a sessão e adapta ao ginásio
GET /treino/sessao/{id}	ecrã do treino ativo (exercício a exercício)
POST /treino/sessao/{id}/serie	regista uma série
POST /treino/sessao/{id}/concluir	termina o treino
Padrão que cada um segue no Controller
Para obter o utilizador autenticado em qualquer controller:


@Autowired
private UtilizadorRepository utilizadorRepository;

// Em qualquer método do controller:
private Utilizador getUtilizadorAtual(Principal principal) {
    return utilizadorRepository.findByEmail(principal.getName()).orElseThrow();
}
E o método recebe Principal principal como parâmetro:


@GetMapping("/medidas")
public String listar(Model model, Principal principal) {
    Utilizador u = getUtilizadorAtual(principal);
    model.addAttribute("medidas", medidaService.listar(u));
    return "medidas/lista";
}
Quer que eu crie o esqueleto inicial (Service + Controller vazios) para algum UC específico?