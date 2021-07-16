package view;

import java.util.Scanner;

import dao.*;
import model.*;

public class Principal {

	public static void main(String[] args) {
		
		Produto produto = new Produto();
		ProdutoDao daoProduto = new ProdutoDao();
		Servico servico = new Servico();
		ServicoDao daoServico = new ServicoDao();
		
		String menu =	"\n1) Calcular imposto do produto: \n" + 
			      		"2) Calcular imposto do serviço: \n" +
			      		"9) Sair";
		
		int opcaoMenu = 0;
		while(opcaoMenu != 9) {
			System.out.println(menu);
			opcaoMenu = lerNumero("\nInforme a opção desejada: ");
			
			switch (opcaoMenu) {
			case 1:
				
				produto = daoProduto.getInstance(lerNumero("Qual produto?"));
				produto.calcularImpostos();
				System.out.println(produto);
				
				break;
			case 2:
				
				servico = daoServico.getInstance(lerNumero("Qual serviço?"));
				servico.calcularImpostos();
				System.out.println(servico);
				
				break;

			default:
				break;
			}
			
		}
		

	}
	
	public static int lerNumero(String entrada) {
		int opcao = 0;
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
		System.out.println(entrada);
		opcao = leitor.nextInt();
		return opcao;
	}
	
	public static String lerPalavra(String entrada) {
		String string = "";
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
		System.out.println(entrada);
		string = leitor.nextLine();
		return string;
	}

}
