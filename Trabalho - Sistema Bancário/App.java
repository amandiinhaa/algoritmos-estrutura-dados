package TrabalhoFinal;

public class App {
	public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println("   INICIANDO TESTE COMPLETO - SISTEMA BANCÁRIO AED   ");
        System.out.println("=====================================================\n");

        // 1. Instanciação do gerenciador central
        GerenciadorAtendimento gerenciador = new GerenciadorAtendimento();

        // 2. CRIAÇÃO E INSERÇÃO DE CLIENTES NAS FILAS (MÉTODO: adicionaRegistro)
        System.out.println("[TESTE 1] -> Inserindo Clientes nas Filas...");
        
        // Clientes Prioritários (IDs na faixa 200)
        RegistroAtendimento p1 = new RegistroAtendimento(201, 8.0, TipoPrioridade.PREFERENCIAL);
        RegistroAtendimento p2 = new RegistroAtendimento(202, 8.05, TipoPrioridade.PREFERENCIAL);
        RegistroAtendimento p3 = new RegistroAtendimento(203, 8.10, TipoPrioridade.PREFERENCIAL);
        
        // Clientes Normais (IDs na faixa 100)
        RegistroAtendimento n1 = new RegistroAtendimento(101, 8.0, TipoPrioridade.NORMAL);
        RegistroAtendimento n2 = new RegistroAtendimento(102, 8.02, TipoPrioridade.NORMAL);
        RegistroAtendimento n3 = new RegistroAtendimento(103, 8.12, TipoPrioridade.NORMAL);

        // Adicionando nas respectivas filas
        gerenciador.adicionaRegistro(p1);
        gerenciador.adicionaRegistro(p2);
        gerenciador.adicionaRegistro(p3);
        gerenciador.adicionaRegistro(n1);
        gerenciador.adicionaRegistro(n2);
        gerenciador.adicionaRegistro(n3);

        System.out.println(" > Filas alimentadas com sucesso!");
        System.out.println("   - Clientes na Fila Prioritária: 3");
        System.out.println("   - Clientes na Fila Normal: 3\n");


        // 3. DISTRIBUIÇÃO INICIAL NOS GUICHÊS (MÉTODO: trocaAtendimento)
        System.out.println("[TESTE 2] -> Abertura dos Guichês e Alocação Inicial...");
        gerenciador.trocaAtendimento();

        // Mostra quem pegou vaga onde na primeira rodada
        if (GerenciadorAtendimento.preferencial != null) {
            System.out.println("  > Guichê Preferencial atendendo Cliente ID: " 
                    + GerenciadorAtendimento.preferencial.getRa().getIdCliente());
        }
        if (GerenciadorAtendimento.geral1 != null) {
            System.out.println("  > Guichê Geral 1 atendendo Cliente ID: " 
                    + GerenciadorAtendimento.geral1.getRa().getIdCliente() 
                    + " (" + GerenciadorAtendimento.geral1.getRa().getTipo() + ")");
        }
        if (GerenciadorAtendimento.geral2 != null) {
            System.out.println("  > Guichê Geral 2 atendendo Cliente ID: " 
                    + GerenciadorAtendimento.geral2.getRa().getIdCliente() 
                    + " (" + GerenciadorAtendimento.geral2.getRa().getTipo() + ")");
        }
        System.out.println();


        // 4. SIMULAÇÃO DO FLUXO COMPLETO E ARMAZENAMENTO EM PILHA (MÉTODO: finalizarAtendimento)
        System.out.println("[TESTE 3] -> Simulando Finalização de Atendimentos (Ciclo da Pilha)...");

        // Passo A: Guichê Geral 1 finaliza seu primeiro cliente (que foi o prioritário 202)
        if (GerenciadorAtendimento.geral1 != null) {
            int id = GerenciadorAtendimento.geral1.getRa().getIdCliente();
            GerenciadorAtendimento.geral1.finalizarAtendimento(); 
            System.out.println(" > Cliente " + id + " finalizado no Geral 1 -> Empilhado no Histórico Geral 1.");
            // Nota: O Geral 1 deve agora OBRIGATORIAMENTE puxar o Normal 101.
        }

        // Passo B: Guichê Preferencial finaliza seu primeiro cliente (201)
        if (GerenciadorAtendimento.preferencial != null) {
            int id = GerenciadorAtendimento.preferencial.getRa().getIdCliente();
            GerenciadorAtendimento.preferencial.finalizarAtendimento();
            System.out.println(" > Cliente " + id + " finalizado no Preferencial -> Empilhado no Histórico Preferencial.");
        }

        // Passo C: Guichê Geral 2 finaliza seu primeiro cliente (que foi o prioritário 203)
        if (GerenciadorAtendimento.geral2 != null) {
            int id = GerenciadorAtendimento.geral2.getRa().getIdCliente();
            GerenciadorAtendimento.geral2.finalizarAtendimento();
            System.out.println(" > Cliente " + id + " finalizado no Geral 2 -> Empilhado no Histórico Geral 2.");
        }

        // Passo D: Vamos finalizar as novas pessoas que entraram nos guichês para esvaziar o fluxo
        System.out.println("\n[TESTE 4] -> Esvaziando os guichês remanescentes...");
        if (GerenciadorAtendimento.geral1 != null && GerenciadorAtendimento.geral1.getRa().getStatus() == StatusAtendimento.ATENDENDO) {
            System.out.println(" > Geral 1 estava atendendo o ID: " + GerenciadorAtendimento.geral1.getRa().getIdCliente());
            GerenciadorAtendimento.geral1.finalizarAtendimento();
        }
        if (GerenciadorAtendimento.geral2 != null && GerenciadorAtendimento.geral2.getRa().getStatus() == StatusAtendimento.ATENDENDO) {
            System.out.println(" > Geral 2 estava atendendo o ID: " + GerenciadorAtendimento.geral2.getRa().getIdCliente());
            GerenciadorAtendimento.geral2.finalizarAtendimento();
        }


        // 5. VALIDAÇÃO DAS ESTRUTURAS DAS PILHAS (MÉTODO: pop / estaVazia)
        System.out.println("\n[TESTE 5] -> Verificação Estrutural Física das Pilhas...");
        System.out.println("  - Tamanho Histórico Geral 1: " + GerenciadorAtendimento.historicoGeral1.getTamanho());
        System.out.println("  - Tamanho Histórico Geral 2: " + GerenciadorAtendimento.historicoGeral2.getTamanho());
        System.out.println("  - Tamanho Histórico Preferencial: " + GerenciadorAtendimento.historicoPreferencial.getTamanho());

        // Provando o LIFO (Last In, First Out) desempilhando o topo do Geral 1
        if (!GerenciadorAtendimento.historicoGeral1.estaVazia()) {
            RegistroAtendimento noTopo = GerenciadorAtendimento.historicoGeral1.pop();
            System.out.println(" > Sucesso! Desempilhado do topo do Geral 1 o Cliente ID: " + noTopo.getIdCliente());
            System.out.println("  - Novo tamanho após remoção física: " + GerenciadorAtendimento.historicoGeral1.getTamanho());
            
            // Devolve ele para a pilha para não estragar o relatório consolidado final
            GerenciadorAtendimento.historicoGeral1.push(noTopo);
        }


        // 6. IMPRESSÃO DO RELATÓRIO (MÉTODO: relatorioAtendimento)
        System.out.println("\n[TESTE 6] -> Gerando Relatório Consolidado Exigido...");
        String relatorioCompleto = gerenciador.relatorioAtendimento();
        System.out.println(relatorioCompleto);

        System.out.println("=====================================================");
        System.out.println("          SIMULAÇÃO FINALIZADA COM SUCESSO           ");
        System.out.println("=====================================================");
    }
}
