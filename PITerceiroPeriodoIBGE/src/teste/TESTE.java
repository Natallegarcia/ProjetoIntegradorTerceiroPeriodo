/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import estruturaDados.Lista;
import estruturaDados.No;
import java.util.Scanner;
import modelo.Municipio;

/**
 *
 * @author natalle.santos
 */
public class TESTE {
    public static void main(String[] args) throws Exception {
      Lista listaMunicipios = new Lista();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Adicionar Município");
            System.out.println("2. Atualizar Município");
            System.out.println("3. Excluir Município");
            System.out.println("4. Listar Municípios");
            System.out.println("5. Calcular Informações de Todos os Municípios");
            System.out.println("6. Ver Município com o Melhor PIB per Capita");
            System.out.println("7. Ver Município com o Pior PIB per Capita");
            System.out.println("8. Ver Município com o Melhor IDH Educação");
            System.out.println("9. Ver Município com o Pior IDH Educação");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Adicionando um novo município:");
                    Municipio novoMunicipio = lerDadosMunicipio(scanner);
                    listaMunicipios.incluirFim(novoMunicipio);
                    System.out.println("Município adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o código IBGE do município a ser atualizado: ");
                    String codigoIBGEAtualizar = scanner.nextLine();
                    System.out.println("Informe os novos dados do município:");
                    Municipio dadosAtualizados = lerDadosMunicipio(scanner);
                    try {
                        listaMunicipios.atualizarMunicipio(codigoIBGEAtualizar, dadosAtualizados);
                        System.out.println("Município atualizado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite o código IBGE do município a ser excluído: ");
                    String codigoIBGEExcluir = scanner.nextLine();
                    try {
                        excluirMunicipio(listaMunicipios, codigoIBGEExcluir);
                        System.out.println("Município excluído com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Listando municípios:");
                    listarMunicipios(listaMunicipios);
                    break;

                case 5:
                    System.out.println("Calculando informações de todos os municípios...");
                    calcularInformacoes(listaMunicipios);
                    System.out.println("Informações calculadas com sucesso!");
                    break;

                case 6:
                    Municipio melhorPIB = listaMunicipios.getMunicipioComMelhorPIBpC();
                    if (melhorPIB != null) {
                        System.out.println("Município com o melhor PIB per capita: " + melhorPIB.formatarInfo());
                    } else {
                        System.out.println("Nenhum município encontrado.");
                    }
                    break;

                case 7:
                    Municipio piorPIB = listaMunicipios.getMunicipioComPiorPIBpC();
                    if (piorPIB != null) {
                        System.out.println("Município com o pior PIB per capita: " + piorPIB.formatarInfo());
                    } else {
                        System.out.println("Nenhum município encontrado.");
                    }
                    break;

                case 8:
                    Municipio melhorIDH = listaMunicipios.getMunicipioComMelhorIDHEducacao();
                    if (melhorIDH != null) {
                        System.out.println("Município com o melhor IDH Educação: " + melhorIDH.formatarInfo());
                    } else {
                        System.out.println("Nenhum município encontrado.");
                    }
                    break;

                case 9:
                    Municipio piorIDH = listaMunicipios.getMunicipioComPiorIDHEducacao();
                    if (piorIDH != null) {
                        System.out.println("Município com o pior IDH Educação: " + piorIDH.formatarInfo());
                    } else {
                        System.out.println("Nenhum município encontrado.");
                    }
                    break;

                case 10:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 10);

        scanner.close();
    }

    private static Municipio lerDadosMunicipio(Scanner scanner) {
        System.out.print("Código IBGE: ");
        String codigoIBGE = scanner.nextLine();
        System.out.print("Nome do Município: ");
        String nomeMunicipio = scanner.nextLine();
        System.out.print("Microrregião: ");
        String microrregiao = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Região Geográfica: ");
        String regiaoGeografica = scanner.nextLine();
        System.out.print("Área (em km²): ");
        double area = scanner.nextDouble();
        System.out.print("População: ");
        double populacao = scanner.nextDouble();
        System.out.print("Domicílios: ");
        double domicilios = scanner.nextDouble();
        System.out.print("PIB Total: ");
        double pibTotal = scanner.nextDouble();
        System.out.print("IDH: ");
        double idh = scanner.nextDouble();
        System.out.print("Renda Média: ");
        double rendaMedia = scanner.nextDouble();
        System.out.print("Renda Nominal: ");
        double rendaNominal = scanner.nextDouble();
        System.out.print("PEA Dia: ");
        double peaDia = scanner.nextDouble();
        System.out.print("IDH Educação: ");
        double idhEducacao = scanner.nextDouble();
        System.out.print("IDH Longevidade: ");
        double idhLongevidade = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer

        return new Municipio(codigoIBGE, nomeMunicipio, microrregiao, estado, regiaoGeografica, area, populacao,
                domicilios, pibTotal, idh, rendaMedia, rendaNominal, peaDia, idhEducacao, idhLongevidade);
    }

    private static void excluirMunicipio(Lista listaMunicipios, String codigoIBGE) throws Exception {
        No atual = listaMunicipios.acessarPrimeiroNo();
        No anterior = null;

        while (atual != null) {
            if (atual.getDado().getCodigoIBGE().equals(codigoIBGE)) {
                if (anterior == null) { // Excluindo o primeiro nó
                    listaMunicipios.retirarInicio();
                } else {
                    anterior.setProximo(atual.getProximo());
                    listaMunicipios.retirarNoFim(); // Ajusta o tamanho
                }
                return;
            }
            anterior = atual;
            atual = atual.getProximo();
        }

        throw new Exception("Município com código IBGE " + codigoIBGE + " não encontrado.");
    }

    private static void listarMunicipios(Lista listaMunicipios) throws Exception {
        No atual = listaMunicipios.acessarPrimeiroNo();
        if (atual == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        while (atual != null) {
            System.out.println(atual.getDado().formatarInfo());
            atual = atual.getProximo();
        }
    }

    private static void calcularInformacoes(Lista listaMunicipios) throws Exception {
        No atual = listaMunicipios.acessarPrimeiroNo();
        while (atual != null) {
            atual.getDado().calcularDensidadeDemografica();
            atual.getDado().calcularPibPerCapita();
            atual.getDado().calcularClassificacoesIDH();
            atual = atual.getProximo();
        }
    }
    
}
