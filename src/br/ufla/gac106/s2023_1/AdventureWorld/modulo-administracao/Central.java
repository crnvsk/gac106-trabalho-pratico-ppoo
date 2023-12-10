    package br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao;

    import java.util.ArrayList;
    import java.io.*;
    import java.util.List;

    import com.itextpdf.text.Document;
    import com.itextpdf.text.DocumentException;
    import com.itextpdf.text.PageSize;
    import com.itextpdf.text.Paragraph;
    import com.itextpdf.text.pdf.PdfWriter;

    import br.ufla.gac106.s2023_1.AdventureWorld.relatorios.ContabilizadorIngressos;
    import br.ufla.gac106.s2023_1.AdventureWorld.relatorios.DadosIngressoParque;
    import br.ufla.gac106.s2023_1.AdventureWorld.relatorios.DadosIngressoVisita;
    

    public class Central {
        private ArrayList<Parque> parques; // Lista de parques cadastrados
        private ArrayList<Cidade> cidades; // Lista de cidades cadastradas
        private ArrayList<Visita> visitas; // Lista de visitas cadastradas


        public Central(){
            parques = new ArrayList<>(); // Inicializa a lista de parques vazia
            cidades = new ArrayList<>(); // Inicializa a lista de cidades vazia
            visitas = new ArrayList<>(); // Inicializa a lista de visitas vazia
        }

        // Métodos para cadastro, listagem, detalhamento, remoção e verificação de parques
        public void cadastrarParque(String umNome, ArrayList<String> atracoes){
            Parque parque = new Parque(umNome, atracoes);
            parques.add(parque);
            salvarDados("dados.bin");
        }

        public String listarParques() {
            String saida = "";
            for (Parque parque : parques) {
                saida += "Nome do parque: " + parque.getNomeParque() + "\n";
                saida += "------" + "\n";
            }
            return saida;
        }

        public String detalharParque(String nomeParque) {
            for (Parque parque : parques) {
                if (parque.getNomeParque().equalsIgnoreCase(nomeParque)) {
                    return parque.getDescricao();
                }
            }
        
            return "Parque não encontrado!\n";
        }


        public String removerParque(String nomeParque) {
            String saida = "";
            Parque parqueRemover = null;
            for (Parque parque : parques) {
                if (parque.getNomeParque().equalsIgnoreCase(nomeParque)) {
                    parqueRemover = parque;
                    break;
                }
            }
            if (parqueRemover != null) {
                parques.remove(parqueRemover);
                saida += "Parque removido: " + parqueRemover.getNomeParque() + "\n";
                salvarDados("dados.bin");
            } else {
                saida +="Parque não encontrado!\n";
            }
            return saida;
        }

        public boolean verificaParque(String umNome){
            for(Parque parque : parques){
                if(parque.getNomeParque().equalsIgnoreCase(umNome)){
                    return true;
                }
            }
            return false;
        }

        /* -------------------------------------------------------------------------------- */

        // Métodos para cadastro, listagem, detalhamento, remoção e verificação de cidades
        public void cadastrarCidade(String umNome, String umEstado){
            Cidade cidade = new Cidade(umNome, umEstado);
            cidades.add(cidade);
            salvarDados("dados.bin");
        }

        public String listarCidades() {
            String saida = "";
            for (Cidade cidade : cidades) {
                saida += "Nome da cidade: " + cidade.getNomeCidade() + "\n";
                saida += "------\n";
            }
            return saida;
        }

        public String detalharCidade(String nomeCidade) {
            for (Cidade cidade : cidades) {
                if (cidade.getNomeCidade().equalsIgnoreCase(nomeCidade)) {
                    return cidade.getDescricao();
                }
            }

            return "Cidade não encontrada!\n";
        }

        public String removerCidade(String nomeCidade) {
            String saida = "";
            Cidade localRemover = null;
            for (Cidade cidade : cidades) {
                if (cidade.getNomeCidade().equalsIgnoreCase(nomeCidade)) {
                    localRemover = cidade;
                    break;
                }
            }
            if (localRemover != null) {
                cidades.remove(localRemover);
                saida += "Local removido: " + localRemover.getNomeCidade() + "\n";
                salvarDados("dados.bin");
            } else {
                saida += "Local não encontrado!\n";
            }
            return saida;
        }

        public boolean verificaCidade(String umNome){
            for(Cidade cidade : cidades){
                if(cidade.getNomeCidade().equalsIgnoreCase(umNome)){
                    return true;
                }
            }
            return false;
        }

        /* -------------------------------------------------------------------------------- */

        // Métodos para cadastro, listagem, detalhamento, remoção e verificação de visitas
        public void cadastrarVisita(String umNome, Parque umParque, Cidade umaCidade, String tipoIngresso, String data, String horario) {
            if (tipoIngresso.equals("1")){
                AcessoAtracao acessoAtração = new AcessoAtracao(umNome, umParque, umaCidade, data, horario);
                visitas.add(acessoAtração);
            }else {
                PassaporteVip passaporteVip = new PassaporteVip(umNome, umParque, umaCidade, data, horario);
                visitas.add(passaporteVip);
            }
            salvarDados("dados.bin");
        }

        public String listarVisitas(String nomeParque) {
            String saida = "";
            for (Visita visita : visitas) {
                if (visita.getParque().getNomeParque().equalsIgnoreCase(nomeParque)){
                    saida += "Visita: " + visita.getNomeVisita() + "\n";
                    saida += "---------------\n";
                }
            }
            return saida;
        }

        public List<String> returnVisitas(){
            List<String> retorno = new ArrayList<>();
            for (Visita visita : visitas){
                retorno.add(visita.getNomeVisita());
            }
            
            return retorno;
        }

        public String detalharVisita(String nomeVisita) {
            for (Visita visita : visitas) {
                if (visita.getNomeVisita().equalsIgnoreCase(nomeVisita)){
                    return visita.getDescricao();
                }
            }
            return "Visita não encontrada\n";
        }

        public String detalharVisitaCompleta(String nomeVisita) {
            for (Visita visita : visitas) {
                if (visita.getNomeVisita().equalsIgnoreCase(nomeVisita)){
                    return visita.getDescricaoCompleta();
                }
            }
            return "Visita não encontrada\n";
        }

        public String detalharVisitaCompleta(String nomeVisita, int valor, String nomeComprador) {
            for (Visita visita : visitas) {
                if (visita.getNomeVisita().equalsIgnoreCase(nomeVisita)) {
                    visita.vendaIngresso(valor);
                    visita.setNomeComprador(nomeComprador);
                    salvarDados("dados.bin");
                    return visita.getDescricaoCompleta();
                }
            }
            return "Visita não encontrada\n";
        }

        
        
        public String removerVisita(String nomeVisita) {
            String saida = "";
            Visita visitaRemover = null;
            for (Visita visita : visitas) {
                if (visita.getNomeVisita().equalsIgnoreCase(nomeVisita)) {
                    visitaRemover = visita;
                    break;
                }
            }
            if (visitaRemover != null) {
                visitas.remove(visitaRemover);
                saida += "Visita removida.\n";
                salvarDados("dados.bin");
            } else {
                saida += "Visita não encontrada!\n";
            }
            return saida;
        }

        public boolean verificaVisita(String umNome) {
            for (Visita visita : visitas) {
                if (visita.getNomeVisita().equalsIgnoreCase(umNome)) {
                    return true;
                }
            }
            return false;
        }

        public double precoVisita(String umNome){
            for (Visita visita : visitas) {
                if (visita.getNomeVisita().equalsIgnoreCase(umNome)) {
                    return visita.getPrecoIngresso();
                }
            }
            return 0;
        }


        /* -------------------------------------------------------------------------------- */

        // Métodos auxiliares para obter parque e cidade por nome
        public Parque obterParquePorNome(String nomeParque) {
            for (Parque parque : parques) {
                if (parque.getNomeParque().equalsIgnoreCase(nomeParque)) {
                    return parque;
                }
            }
            return null;
        }

        public Cidade obterCidadePorNome(String nomeCidade) {
            for (Cidade cidade : cidades) {
                if (cidade.getNomeCidade().equalsIgnoreCase(nomeCidade)) {
                    return cidade;
                }
            }
            return null;
        }

        public String salvarDados(String arquivo) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo))) {
                outputStream.writeObject(parques);
                outputStream.writeObject(cidades);
                outputStream.writeObject(visitas);
                return "Dados salvos com sucesso!\n";
            } catch (IOException e) {
                return "Erro ao salvar os dados: " + e.getMessage();
            }
        }

        @SuppressWarnings("unchecked")
        public String carregarDados(String arquivo) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivo))) {
                parques = (ArrayList<Parque>) inputStream.readObject();
                cidades = (ArrayList<Cidade>) inputStream.readObject();
                visitas = (ArrayList<Visita>) inputStream.readObject();
                return "Dados carregados com sucesso!\n";
            } catch (IOException | ClassNotFoundException e) {
                return "Erro ao carregar os dados: " + e.getMessage();
            }
        }
        
        public String limparDados() {
            parques.clear();
            cidades.clear();
            visitas.clear();
            return "Dados foram limpos com sucesso!\n";
        }

        public boolean checaVenda(String nomeVisita, int valor) {
            Boolean peca = false;
            for (Visita visita : visitas) {
                if (visita.getNomeVisita().equalsIgnoreCase(nomeVisita)){
                    if(valor < visita.getQtdIngresso()){
                        peca = true;
                    }
                }
            }
            return peca;
        }

        public void gerarPDF(String selecao, int inteira, int meia, double total, String nome){
             String saida = "";

            for(Visita visita : visitas){
                if (visita.getNomeVisita().equalsIgnoreCase(selecao)) {
                    saida += "Comprador: " + nome + "\n";
                    saida += "Visita: " + visita.getNomeVisita() + "\n";
                    saida += "Parque: " + visita.getNomeParque() + "\n";
                    saida += "Atrações: " + visita.exibirAtracoesParque() + "\n";
                    saida += "Cidade: " + visita.getNomeCidade() + "\n";
                    saida += "Tipo de Ingresso: " + visita.getIngresso() + "\n";
                    saida += "Preço do Ingresso: " + visita.getPrecoIngresso()+ "\n";
                    saida += "Data: " + visita.getData() + "\n";
                    saida += "Horário: " + visita.getHorario() + "\n";
                    saida += "------------------------------\n";
                    saida += "Quantidade de ingresso(s) Inteiro(s): " + inteira + "\n";
                    saida += "Quantidade de ingresso(s) Meio(s): " + meia + "\n";
                    saida += "Valor total: R$" + total + "\n";
                    saida += "------------------------------\n";
                }
            }

             // Cria o objeto do documento PDF
            Document document = new Document();
            try {
                // Cria o escritor do documento
                PdfWriter.getInstance(document, new FileOutputStream("arquivo.pdf"));


                // Ajusta o tamanho da página
                document.setPageSize(PageSize.A4);


                // Abre o documento
                document.open();           


                // Adiciona um parágrafo ao documento
                document.add(new Paragraph(saida));


                // Adiciona uma nova página
                document.newPage();
                // Adiciona um parágrafo à nova página
                document.add(new Paragraph("Novo parágrafo na nova página"));           


                // Fecha o documento
                document.close();
                System.out.println("O arquivo PDF foi gerado com sucesso.");
            }
            catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public List<ContabilizadorIngressos> getDadosIngressosPorParque() {
            List<ContabilizadorIngressos> dados = new ArrayList<>();
            for (Parque parque : parques) {
                int quantidadeIngressos = 0;
                double valorTotal = 0.0;
                for (Visita visita : visitas) {
                    if (visita.getParque().equals(parque)) {
                        if(visita.getIngresso().equals("Passaporte VIP")){
                            quantidadeIngressos += visita.getQtdIngressosVendidos();
                            valorTotal += quantidadeIngressos * visita.getPrecoIngresso();
                            System.out.println(valorTotal);
                        }
                        if(visita.getIngresso().equals("Ingresso Basico")){
                            quantidadeIngressos += visita.getQtdIngressosVendidos();
                            valorTotal += quantidadeIngressos * visita.getPrecoIngresso();
                            System.out.println(valorTotal);
                        }
                    }
                }
                dados.add(new DadosIngressoParque(parque.getNomeParque(), quantidadeIngressos, valorTotal));
            }
            return dados;
        }

        // Método para obter os dados de ingressos vendidos e valor arrecadado por atividade (visita)
        public List<ContabilizadorIngressos> getDadosIngressosPorAtividade() {
            List<ContabilizadorIngressos> dados = new ArrayList<>();
            for (Visita visita : visitas) {
                String nomeAtividade = visita.getNomeVisita();
                int quantidadeIngressos = visita.getQtdIngressosVendidos();
                double valorTotal = quantidadeIngressos * visita.getPrecoIngresso();

                dados.add(new DadosIngressoVisita(nomeAtividade, quantidadeIngressos, valorTotal));
            }
            return dados;
        }

        // Método para obter os dados de ingressos comprados e valor arrecadado por comprador
        public List<ContabilizadorIngressos> getDadosIngressosPorComprador() {
            List<ContabilizadorIngressos> dados = new ArrayList<>();
            for (Visita visita : visitas) {
                int cont = 0;
                String nomeComprador = "";
                if (visita.getNomeComprador(cont) != null)
                    nomeComprador = visita.getNomeComprador(cont);
                int quantidadeIngressos = visita.getQtdIngressosVendidos();
                double valorTotal = quantidadeIngressos * visita.getPrecoIngresso();

                dados.add(new DadosIngressoVisita(nomeComprador, quantidadeIngressos, valorTotal));
                cont++;
            }
            return dados;
        }

        public void colocarNomeComprador(String comprador){
            Visita visita = new Visita();
            visita.setNomeComprador(comprador);
        }
    }

