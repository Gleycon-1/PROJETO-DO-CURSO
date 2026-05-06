import java.util.Scanner;
import java.util.ArrayList;

/**
 * PROJETO: SISTEMA_GESTAO_FOLHA_ORACLE
 * DESENVOLVEDORES: GLEYCON SILVA
 * DATA DE CRIAÇÃO: 06/05/2026
 */

class COLABORADOR {
    int MATRICULA;
    String NOME;
    double SALARIO_FIXO;
    double EXTRAS;
    double SALARIO_FINAL;
    String TIPO_VINCULO;

    public COLABORADOR(int matricula, String nome, double salarioFixo, double extras, String tipo) {
        this.MATRICULA = matricula;
        this.NOME = nome.toUpperCase(); // Força o nome do funcionário em MAIÚSCULO também
        this.SALARIO_FIXO = salarioFixo;
        this.EXTRAS = extras;
        this.SALARIO_FINAL = salarioFixo + extras;
        this.TIPO_VINCULO = tipo.toUpperCase();
    }

    public void EXIBIR_RELATORIO() {
        System.out.println("\n-------------------------------------------");
        System.out.println("NOME COMPLETO: " + NOME);
        System.out.println("MATRÍCULA: " + MATRICULA);
        System.out.println("VÍNCULO: " + TIPO_VINCULO);
        System.out.println("SALÁRIO BASE: R$ " + SALARIO_FIXO);
        System.out.println("VALORES ADICIONAIS: R$ " + EXTRAS);
        System.out.println("SALÁRIO LÍQUIDO FINAL: R$ " + SALARIO_FINAL);
        System.out.println("-------------------------------------------");
    }
}

public class MAIN_SYSTEM_PAYROLL {
    // CONSTANTE OBRIGATÓRIA DA ORACLE
    static final double SALARIO_BASE_PADRAO = 2000.00;

    public static void main(String[] args) {
        Scanner LEITOR = new Scanner(System.in);
        ArrayList<COLABORADOR> DATABASE = new ArrayList<>();
        int OPCAO = -1;

        System.out.println("###########################################");
        System.out.println("#   SISTEMA DE FOLHA DE PAGAMENTO V.1.0   #");
        System.out.println("###########################################");

        while (OPCAO != 0) {
            System.out.println("\n[ MENU DE OPERAÇÕES ]");
            System.out.println("1 - CADASTRAR PADRÃO");
            System.out.println("2 - CADASTRAR COMISSIONADO");
            System.out.println("3 - CADASTRAR PRODUÇÃO");
            System.out.println("4 - GERAR FOLHA COMPLETA");
            System.out.println("0 - ENCERRAR SISTEMA");
            System.out.print("\nSELECIONE O COMANDO: ");
            
            OPCAO = LEITOR.nextInt();
            LEITOR.nextLine(); 

            if (OPCAO >= 1 && OPCAO <= 3) {
                System.out.print("NOME DO COLABORADOR: ");
                String nome = LEITOR.nextLine();
                System.out.print("NÚMERO DE MATRÍCULA: ");
                int matricula = LEITOR.nextInt();

                if (OPCAO == 1) {
                    DATABASE.add(new COLABORADOR(matricula, nome, SALARIO_BASE_PADRAO, 0, "PADRÃO"));
                } 
                else if (OPCAO == 2) {
                    System.out.print("VOLUME TOTAL DE VENDAS: ");
                    double vendas = LEITOR.nextDouble();
                    System.out.print("TAXA DE COMISSÃO (%): ");
                    double taxa = LEITOR.nextDouble();
                    
                    if (vendas < 0 || taxa < 0) {
                        System.out.println("!!! ERRO: VALORES NEGATIVOS NÃO PERMITIDOS !!!");
                    } else {
                        double calculoComissao = (vendas * taxa / 100);
                        DATABASE.add(new COLABORADOR(matricula, nome, SALARIO_BASE_PADRAO, calculoComissao, "COMISSIONADO"));
                    }
                } 
                else if (OPCAO == 3) {
                    System.out.print("QUANTIDADE DE UNIDADES PRODUZIDAS: ");
                    int qtdPeças = LEITOR.nextInt();
                    System.out.print("VALOR UNITÁRIO POR PEÇA: ");
                    double valorUnidade = LEITOR.nextDouble();

                    if (qtdPeças < 0 || valorUnidade < 0) {
                        System.out.println("!!! ERRO: VALORES NEGATIVOS NÃO PERMITIDOS !!!");
                    } else {
                        double calculoProducao = qtdPeças * valorUnidade;
                        DATABASE.add(new COLABORADOR(matricula, nome, SALARIO_BASE_PADRAO, calculoProducao, "PRODUÇÃO"));
                    }
                }
            } 
            else if (OPCAO == 4) {
                System.out.println("\n >>> EMISSÃO DE FOLHA DE PAGAMENTO GERAL <<<");
                System.out.println("REGISTROS ENCONTRADOS: " + DATABASE.size());
                for (COLABORADOR func : DATABASE) {
                    func.EXIBIR_RELATORIO();
                }
            }
        }
        System.out.println("\nSISTEMA FINALIZADO COM SUCESSO.");
        LEITOR.close();
    }
}