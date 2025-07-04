
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        int opcaoEscolhida = 0;
        String moeda = "";


        while (opcaoEscolhida != 7) {

            System.out.println("*****************************");
            System.out.println("Bem vindo ao Conversor de Moedas!\n");
            System.out.println(
                    "1) Dolar =>> Peso Argentino\n" +
                            "2) Peso Argentino =>> Dolar\n" +
                            "3) Dolar =>> Real Brasileiro\n" +
                            "4) Real Brasileiro =>> Dolar\n" +
                            "5) Dolar =>> Peso Colombiano\n" +
                            "6) Peso Colombiano =>> Dolar\n" +
                            "7) Sair");
            System.out.println("Escolha uma opção valida");
            System.out.println("*****************************");
            opcaoEscolhida = leitura.nextInt();

            switch (opcaoEscolhida) {
                case 1:
                    moeda = "USD/ARS";
                    break;
                case 2:
                    moeda = "ARS/USD";
                    break;
                case 3:
                    moeda = "USD/BRL";
                    break;
                case 4:
                    moeda = "BRL/USD";
                    break;
                case 5:
                    moeda = "USD/COP";
                    break;
                case 6:
                    moeda = "COP/USD";
                    break;
                case 7:
                    System.out.println("Conversor finalizou, Obrigado!");
                    return;
                default:
                    System.out.println("Opção Invalida!");
                    return;
            }
            ConsultaCotacao consultaCotacao = new ConsultaCotacao();
            consultaCotacao.consultar(moeda);
            Moeda novaTaxa = consultaCotacao.consultar(moeda);
            double conversion_rate = novaTaxa.conversion_rate();
            String base_code = novaTaxa.base_code();
            String target_code = novaTaxa.target_code();

            System.out.println("Digite o valor que deseja converter:");
            double valorInicial = leitura.nextDouble();
            double valorFinal = valorInicial * conversion_rate;
            System.out.println("Valor de " + base_code +" " + valorInicial + " corresponde a "
            + target_code + " " + valorFinal);

            try {
                Moeda novaMoeda = consultaCotacao.consultar(moeda);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }
}
