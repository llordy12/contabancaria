package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
	var conta = buscarNaCollection(numero);
	
	if(conta != null)
		conta.visualizar();
	else
		System.out.println("\n Conta numero; " + numero + "nao foi encontrada! ");

	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
	

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\n Aconta numero: " + conta.getNumero() + "foi criada com sucesso");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\n A conta numero: " + conta.getNumero() + "foi atualizada com sucesso");
		}else {
			System.out.println("\n A conta numero: " + conta.getNumero() + "nao foi encontrada");
		}
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta)== true)
				System.out.println("\n a conta numero; " + numero + "foi deletada com sucesso!");
		}else {
			System.out.println("\n a conta numero: " + numero + "nao foi encontrada");
		}
		

	}

	@Override
	public void sacar(int numero, float valor) {
		
	}

	@Override
	public void depositar(int numero, float valor) {
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
	
	}
	public int gerarNumero() {
		return ++ numero;
	}
	public Conta buscarNaCollection(int numero) {
	    for (var conta : listaContas) {
	        if (conta.getNumero() == numero) {
	            return conta;
	        }
	    }
	    return null;
	}


}
