package Controllers;

import java.util.List;
import java.util.Scanner;

import entities.Produto;
import repositories.ProdutoRepository;

public class ProdutoController {

	public void cadastrarProduto() {

		try {

			System.out.println("\nCADASTRO DE PRODUTO:\n");

			Produto produto = new Produto();
			Scanner scanner = new Scanner(System.in);

			System.out.print("NOME DO PRODUTO.......: ");
			produto.setNome(scanner.nextLine());

			System.out.print("DESCRICAO.............: ");
			produto.setDescricao(scanner.nextLine());

			System.out.print("PRECO.................: ");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));

			System.out.print("QUANTIDADE.............: ");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

			ProdutoRepository produtoRepository = new ProdutoRepository();
			produtoRepository.create(produto);

			System.out.println("\nPRODUTO CADASTRADO COM SUCESSO!");

			scanner.close();

		} catch (Exception e) {

			System.out.println("\nFALHA AO CADASTRAR PRODUTO: " + e.getMessage());
		}

	}

	public void atualizarProduto() {

		try {

			System.out.println("\nATUALIZAÇÃO DE PRODUTO: \n");

			Scanner scanner = new Scanner(System.in);

			System.out.println("ID DO PRODUTO..........:");
			Integer id = Integer.parseInt(scanner.nextLine());

			ProdutoRepository produtoRepository = new ProdutoRepository();
			Produto produto = produtoRepository.findById(id);

			if (produto != null) {

				System.out.println("NOME DO PRODUTO.......:");
				produto.setNome(scanner.nextLine());

				System.out.println("DESCRICAO DO PRODUTO..:");
				produto.setDescricao(scanner.nextLine());

				System.out.println("PRECO DO PRODUTO......:");
				produto.setPreco(Double.parseDouble(scanner.nextLine()));

				System.out.println("QUANTIDADE DO PRODUTO.:");
				produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

				produtoRepository.update(produto);

				System.out.println("\nPRODUTO ATUALIZADO COM SUCESSO!");
			} else {
				System.out.println("\nPRODUTO NÃO ENCONTRADO!");
			}

			scanner.close();

		} catch (Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR O PRODUTO: " + e.getMessage());
		}

	}

	public void excluirProduto() {

		try {

			System.out.println("\nEXCLUSÃO DE PRODUTO: \n");

			Scanner scanner = new Scanner(System.in);

			System.out.println("ID DO PRODUTO..........:");
			Integer id = Integer.parseInt(scanner.nextLine());

			ProdutoRepository produtoRepository = new ProdutoRepository();
			Produto produto = produtoRepository.findById(id);

			if (produto != null) {

				produtoRepository.delete(produto.getId());

				System.out.println("\nPRODUTO EXCLUIDO COM SUCESSO!");

			} else {
				System.out.println("\nPRODUTO NÃO ENCONTRADO!");

				scanner.close();

			}

		} catch (Exception e) {
			System.out.println("\nFALHA AO EXCLUIR O PRODUTO: " + e.getMessage());

		}

	}

	public void consultarProdutos() {

		try {

			System.out.println("\nCONSULTA DE PRODUTOS: \n");

			ProdutoRepository produtoRepository = new ProdutoRepository();
			List<Produto> lista = produtoRepository.findAll();

			for (Produto produto : lista) {

				System.out.println("ID................: " + produto.getId());
				System.out.println("NOME..............: " + produto.getNome());
				System.out.println("DESCRICAO.........: " + produto.getDescricao());
				System.out.println("PRECO.............: " + produto.getPreco());
				System.out.println("QUANTIDADE........: " + produto.getQuantidade());
				System.out.println("......");
			}

		} catch (Exception e) {
			System.out.println("\nFALHA AO CONSULTAR PRODUTOS!" + e.getMessage());
		}

	}

}
