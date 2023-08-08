package principal;

import java.util.Scanner;

import Controllers.ProdutoController;

public class Main {

	public static void main(String[] args) {

		try {

			Scanner scanner = new Scanner(System.in);

			System.out.println("\nCONTROLE DE PRODUTOS\n");
			System.out.println("(1) CADASTRAR PRODUTO");
			System.out.println("(2) ATUALIZAR PRODUTO");
			System.out.println("(3) EXCLUIR PRODUTO");
			System.out.println("(4) CONSULTAR PRODUTOS");

			System.out.print("\nESCOLHA A OPCAO DESEJADA: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			ProdutoController produtoController = new ProdutoController();

			switch (opcao) {
			case 1:
				produtoController.cadastrarProduto();
				break;

			case 2:
				produtoController.atualizarProduto();
				break;

			case 3:
				produtoController.excluirProduto();
				break;

			case 4:
				produtoController.consultarProdutos();
				break;

			default:
				System.out.println("\nOPCAO INVALIDA! ");
				break;
			}
			
			System.out.println("\nDESEJA CONTINUAR (S/N): ");
			String continuar = scanner.nextLine();
			
			if(continuar.equalsIgnoreCase("S")) {
				main(args);
			}
			else {
				System.out.println("\nFIM DO PROGRAMA!");
				
			}

			scanner.close();
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro: " + e.getMessage());

		}

	}

}
