package br.com.globalcode.aj3.teste;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import br.com.globalcode.aj3.beans.Cliente;

public class TesteQueue {

	public static void main(String args[]) {
		Cliente c1 = new Cliente("Cliente1", "1111", "cpf1");
		Cliente c2 = new Cliente("Cliente2", "2222", "cpf2");
		Cliente c3 = new Cliente("Cliente3", "3333", "cpf3");
		Cliente c4 = new Cliente("Cliente3", "3333", "cpf3");

		Queue clientes = new PriorityQueue();
		clientes.offer(c1);
		clientes.offer(c2);
		clientes.offer(c3);
		clientes.offer(c4);

		imprimirQueue(clientes);

		Cliente clienteRemovido = (Cliente) clientes.poll();
		System.out.println("Cliente Removido = " + clienteRemovido);

		Cliente clienteRecuperado = (Cliente) clientes.peek();
		System.out.println("Cliente recuperado = " + clienteRecuperado);

	}

	public static void imprimirQueue(Queue clientes) {
		Iterator ponteiroClientes = clientes.iterator();
		while (ponteiroClientes.hasNext()) {
			System.out.println(ponteiroClientes.next());
		}
		System.out.println();
	}

}