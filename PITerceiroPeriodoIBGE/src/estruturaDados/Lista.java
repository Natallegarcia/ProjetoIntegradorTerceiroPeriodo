/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturaDados;
import java.util.Comparator;
import modelo.Municipio;

/**
 *
 * @author natalle.santos
 */
public class Lista implements ILista{
    private int tamanho = 0;
    private No inicio = null;
    private No fim = null;

    public Lista() {
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void incluirInicio(Municipio elemento) throws Exception {  // Substituí Piloto por Docente
        No aux = new No(elemento, inicio);
        inicio = aux;
        if (estaVazia()) {
            fim = aux;
        }
        tamanho++;
    }

    @Override
    public void retirarInicio() throws Exception {
        if (estaVazia()) {
            throw new Exception("Não pode retirar, lista está vazia...");
        }
        inicio = inicio.getProximo();
        tamanho--;
        if (estaVazia()) {
            fim = null;
        }
    }

    @Override
    public Municipio acessarInicio() throws Exception {  // Substituí Piloto por Docente
        if (estaVazia()) {
            throw new Exception("Não pode acessar, lista está vazia...");
        }
        return inicio.getDado();
    }

    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    @Override
    public String obterLista() throws Exception {
        if (estaVazia()) {
            return "Lista = { }";
        }
        String saida = "Lista = { ";
        No aux = inicio;
        do {
            saida += aux.getDado() + " ";
            aux = aux.getProximo();
        } while (aux != null);
        return saida += "}";
    }

    @Override
    public void incluirFim(Municipio elemento) throws Exception {  // Substituí Piloto por Docente

        No aux = new No(elemento);

        if (estaVazia()) {
            inicio = fim = aux;
            tamanho++;
            return;
        }

        fim.setProximo(aux);
        fim = aux;
        tamanho++;
    }

    @Override
    public void retirarNoFim() throws Exception {

        if (estaVazia()) {
            throw new Exception("Não pode retirar, lista está vazia...");
        }

        if (tamanho == 1) {
            inicio = fim = null;
            tamanho = 0;
            return;
        }

        No ref = inicio;

        for (int contador = 1; contador < tamanho - 1; contador++) {
            ref = ref.getProximo();
        }

        ref.setProximo(null);
        fim = ref;
        tamanho--;
    }

    @Override
    public Municipio acessarNoFim() throws Exception {  // Substituí Piloto por Docente

        if (estaVazia()) {
            throw new Exception("Não pode acessar, lista está vazia...");
        }
        return fim.getDado();
    }

    @Override
    public No acessarPrimeiroNo() throws Exception {
                if (estaVazia()) {
            throw new Exception("Não pode acessar, lista está vazia...");
        }
        return inicio;
    }
    
    public void calcularInformacoes() throws Exception {
        No atual = inicio;
        while (atual != null) {
        Municipio municipio = atual.getDado();
        municipio.calcularDensidadeDemografica();
        municipio.calcularPibPerCapita();
        municipio.calcularClassificacoesIDH();
        atual = atual.getProximo();
    }
}
    
    // método adaptado para percorrer a lista procurando o código do município pelo código IBGE e atualiza os dados do município. 
   public void atualizarMunicipio(String codigoIBGE, Municipio novosDados) throws Exception {
    No atual = inicio;
    while (atual != null) {
        Municipio municipio = atual.getDado();
        if (municipio.getCodigoIBGE().equals(codigoIBGE)) {
            // Atualiza os dados do município
            municipio.setMunicipio(novosDados.getMunicipio());
            municipio.setMicrorregiao(novosDados.getMicrorregiao());
            municipio.setEstado(novosDados.getEstado());
            municipio.setRegiaoGeografica(novosDados.getRegiaoGeografica());
            municipio.setArea(novosDados.getArea());
            municipio.setPopulacao(novosDados.getPopulacao());
            municipio.setDomicilios(novosDados.getDomicilios());
            municipio.setPibTotal(novosDados.getPibTotal());
            municipio.setIdh(novosDados.getIdh());
            municipio.setRendaMedia(novosDados.getRendaMedia());
            municipio.setRendaNominal(novosDados.getRendaNominal());
            municipio.setPeaDia(novosDados.getPeaDia());
            municipio.setIdhEducacao(novosDados.getIdhEducacao());
            municipio.setIdhLongevidade(novosDados.getIdhLongevidade());

            // Recalcula as informações
            municipio.calcularDensidadeDemografica();
            municipio.calcularPibPerCapita();
            municipio.calcularClassificacoesIDH();
            municipio.atualizarUltimaAtualizacao();

            System.out.println("Município atualizado: " + municipio.formatarInfo()); ///////////!!!!!! Mudar para JOPTIONPANE
            return; // Encerra após encontrar e atualizar
        }
        atual = atual.getProximo();
    }
    throw new Exception("Município com código IBGE " + codigoIBGE + " não encontrado.");
}
    
         public Municipio getMunicipioComMelhorPIBpC() {
         if (estaVazia()) return null;

        No atual = inicio;
        Municipio melhor = atual.getDado();
        atual = atual.getProximo();

        while (atual != null) {
            Municipio municipio = atual.getDado();
            if (municipio.getPibPerCapita() == melhor.getPibPerCapita() && municipio.getPibPerCapita() > melhor.getPibPerCapita()) {
                melhor = municipio;
            }
            atual = atual.getProximo();
        }
        return melhor;
    }  
         
        public Municipio getMunicipioComPiorPIBpC() throws Exception {
        if (estaVazia()) return null;

        No atual = inicio;
        Municipio pior = atual.getDado();
        atual = atual.getProximo();

        while (atual != null) {
            Municipio municipio = atual.getDado();
            if (municipio.getPibPerCapita() < pior.getPibPerCapita()) {
                pior = municipio;
            }
            atual = atual.getProximo();
        }
        return pior;
}

       public Municipio getMunicipioComMelhorIDHEducacao() throws Exception {
        if (estaVazia()) return null;

        No atual = inicio;
        Municipio melhor = atual.getDado();
        atual = atual.getProximo();

        while (atual != null) {
            Municipio municipio = atual.getDado();
            if (municipio.getIdhEducacao() > melhor.getIdhEducacao()) {
                melhor = municipio;
            }
            atual = atual.getProximo();
        }
        return melhor;
}

        public Municipio getMunicipioComPiorIDHEducacao() throws Exception {
        if (estaVazia()) return null;

        No atual = inicio;
        Municipio pior = atual.getDado();
        atual = atual.getProximo();

        while (atual != null) {
            Municipio municipio = atual.getDado();
            if (municipio.getIdhEducacao() < pior.getIdhEducacao()) {
                pior = municipio;
            }
            atual = atual.getProximo();
        }
        return pior;
}



}
