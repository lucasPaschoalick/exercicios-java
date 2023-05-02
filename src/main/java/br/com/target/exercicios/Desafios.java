package br.com.target.exercicios;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Desafios {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {		
		int n;
		do {
			System.out.print("Digite qual questão deseja executar (1, 2, 3, 4, 5) ou digite 0 para sair: ");
			n = scanner.nextInt();
			
			switch(n) {
			case 0:
				scanner.close();
				System.exit(n);
            case 1:
                questao1();
                break;
			case 2:
				questao2();
				break;
			case 3:
				questao3();
				break;
			case 4:
				questao4();
				break;
			case 5:
				questao5();
				break;
			default:
				System.out.print("Essa questão não existe!");
				break;
			}
		}
		while(n != 0);		
	}
	
		
	//  Questão 1
    public static void questao1(){
        System.out.println("O valor da variável SOMA ao final do processamento será de 91.!");
    }
	
	
	
	//	Questão 2
	public static void questao2() {
		
		System.out.print("Informe um número: ");
		
		//	Recupera o numero inserido pelo console
		int n = scanner.nextInt();		
		int first = 0, second = 1, result = 0;
		
		//	Realiza o calcula da sequência de Fibonacci
		while (result < n) {
			result = first + second;
			first = second;
            second = result;
        }

		//	Se o resultado da soma for igual ao valor digitado, então ele está na sequência
		//	Se o resultado da soma não for igual ao valor digitado, então ele não está na sequência
		if (result == n) {
            System.out.println("O número pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número não pertence à sequência de Fibonacci.");
        }
		
	}
	
	
	
	//	Questão 3
	public static void questao3() {
		
		try {
            // Lê o arquivo JSON da pasta assets e armazena em um array
            JSONParser parser = new JSONParser();
            JSONArray invoicings = (JSONArray) parser.parse(new FileReader("assets/dados.json"));            

            // maxInvoicing começa como menor valor possível de um double e o minInvoicing como maior valor possível
            double maxInvoicing = Double.MIN_VALUE;
            double minInvoicing = Double.MAX_VALUE;
            
            double invoicingSum = 0.0;
            int dayWithInvoicings = 0;
            
            for (Object obj : invoicings) {
                JSONObject dayInvoicing = (JSONObject) obj;
                
                // Converte o objeto para double
                double valueInvoicings = Double.parseDouble(dayInvoicing.get("valor").toString());
                
                // Procura o menor faturamento
                if (valueInvoicings < minInvoicing) {
                	minInvoicing = valueInvoicings;
                }
                
                // Procura o maior faturamento
                if (valueInvoicings > maxInvoicing) {
                	maxInvoicing = valueInvoicings;
                }
                
                // Realiza soma dos faturamentos evitando os dias sem faturamento
                if (valueInvoicings > 0.0) {
                    invoicingSum += valueInvoicings;
                    dayWithInvoicings++;
                }
            }

            // Calcula a média de faturamento diário, excluindo os dias sem faturamento            
            double mediaFaturamento = invoicingSum / dayWithInvoicings;

            // Calcula o número de dias que o faturamento diário foi superior à média mensal
            int invoicingDaysAboveMean = 0;
            
            for (Object obj : invoicings) {
                JSONObject faturamentoDia = (JSONObject) obj;
                
                // Converte o objeto para double
                double valorFaturamento = Double.parseDouble(faturamentoDia.get("valor").toString());
                
                //	Verifica se o faturamento diário foi superior à média mensal, caso seja ele soma em 1 os dias acima da media
                if (valorFaturamento > mediaFaturamento) {
                    invoicingDaysAboveMean++;
                }
            }
                     
            System.out.println("Menor faturamento diário: R$" + minInvoicing);
            System.out.println("Maior faturamento diário: R$" + maxInvoicing);
            System.out.println("Número de dias com faturamento acima da média: " + invoicingDaysAboveMean);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
	//	Questão 4
	public static void questao4() {
        double[] stateInvoicings = {67836.43, 36678.66, 29229.88, 27165.48, 19849.53};
        double total = 0;
        
        //	Realiza soma de todos os faturamentos
        for(double i : stateInvoicings) {
        	total += i;
        }
        
        // Calcula o percentual de representação de cada estado no faturamento total
        double[] statePercentage = new double[5];
        
        for (int i = 0; i < stateInvoicings.length; i++) {
        	statePercentage[i] = (stateInvoicings[i] / total) * 100;
        }

        // Exibe os percentuais de representação de cada estado
        System.out.println("Percentuais de representação no faturamento total:");
        System.out.printf("SP: %.2f%%\n", statePercentage[0]);
        System.out.printf("RJ: %.2f%%\n", statePercentage[1]);
        System.out.printf("MG: %.2f%%\n", statePercentage[2]);
        System.out.printf("ES: %.2f%%\n", statePercentage[3]);
        System.out.printf("Outros: %.2f%%\n", statePercentage[4]);
    
	}
	
	
	
	//	Questão 5
	public static void questao5() {

        System.out.println("Informe uma string: ");
        
        //	Recupera a string inserida pelo console
        String original = scanner.next();

        //	String para armazenar a string original invertida
        String reverse = "";

        //	Percorre a string original de trás para frente, adicionando cada caracter na string invertida.
        for (int i = original.length() - 1; i >= 0; i--) {
        	reverse += original.charAt(i);
        }

        System.out.println("A string invertida é: " + reverse);
    }
}
