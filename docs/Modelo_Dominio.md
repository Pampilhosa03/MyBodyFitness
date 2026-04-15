# Modelo de Domínio — MyBodyFitness

## Diagrama de Classes

```mermaid
classDiagram
    class Utilizador {
        +int id
        +String nome
        +String email
        +String password
    }

    class AdminLocal {
    }

    class AdminGeral {
    }

    class Medida {
        +int id
        +Date data
        +float peso_kg
        +float altura_cm
        +float imc
        +float peito_cm
        +float cintura_cm
        +float anca_cm
    }

    class PlanoDeTreino {
        +int id
        +String nome
        +String descricao
        +boolean publico
        +Date dataCriacao
    }

    class SessaoDeTreino {
        +int id
        +Date data
        +int duracao_min
        +String notas
    }

    class Serie {
        +int id
        +int ordemNaSessao
        +float carga_kg
        +int repeticoes
    }

    class Exercicio {
        +int id
        +String nome
        +String descricao
        +String grupoMuscular
    }

    class Equipamento {
        +int id
        +String nome
        +String tipo
    }

    class Ginasio {
        +int id
        +String nome
        +String morada
    }

    Utilizador <|-- AdminLocal
    Utilizador <|-- AdminGeral

    Utilizador "1" --> "*" Medida : regista
    Utilizador "1" --> "*" SessaoDeTreino : realiza
    Utilizador "*" --> "*" PlanoDeTreino : cria / segue
    Utilizador "*" --> "*" Ginasio : tem preferidos

    PlanoDeTreino "*" --> "*" Exercicio : inclui
    SessaoDeTreino "*" --> "1" PlanoDeTreino : baseia-se em
    SessaoDeTreino "1" --> "*" Serie : contém
    Serie "*" --> "1" Exercicio : executa

    Exercicio "*" --> "*" Equipamento : necessita
    Ginasio "1" --> "*" Equipamento : disponibiliza
    Ginasio "1" --> "1" AdminLocal : gerido por
```

## Descrição das Entidades

| Entidade | Descrição |
|---|---|
| **Utilizador** | Pessoa registada na aplicação. Pode criar planos, registar treinos e acompanhar a sua progressão. |
| **AdminLocal** | Utilizador com permissões de gestão de um ginásio específico (equipamentos disponíveis). |
| **AdminGeral** | Utilizador com permissões globais de manutenção da plataforma. |
| **Medida** | Registo periódico das medidas corporais e peso de um utilizador. |
| **PlanoDeTreino** | Conjunto ordenado de exercícios planeados. Pode ser público (partilhável) ou privado. |
| **SessaoDeTreino** | Realização efetiva de um treino numa data concreta, com base num plano. |
| **Serie** | Execução de um exercício com uma carga e número de repetições numa sessão. |
| **Exercicio** | Movimento específico com grupo muscular alvo e equipamento necessário. |
| **Equipamento** | Material ou máquina necessário para realizar um exercício. |
| **Ginasio** | Instalação desportiva com equipamentos disponíveis, gerida por um AdminLocal. |
