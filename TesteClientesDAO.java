package br.com.globalcode.aj3.teste;

import java.io.IOException;
import java.util.List;

import br.com.globalcode.aj3.beans.Cliente;
import br.com.globalcode.aj3.dao.ClientesDAOImpl;
import br.com.globalcode.aj3.dao.IClientesDAO;
import br.com.globalcode.aj3.exception.GlobalcodeException;
import br.com.globalcode.aj3.util.Teclado;

public class TesteClientesDAO {

    public static IClientesDAO dao = new ClientesDAOImpl();

    public static void montaMenu() {
        System.out.println("-------------------------");
        System.out.println("INSERIR NOVO CLIENTE : 1");
        System.out.println("REMOVER CLIENTE      : 2");
        System.out.println("LISTAR CLIENTES      : 3");
        System.out.println("BUSCAR CLIENTE       : 4");
        System.out.println("FINALIZAR            : 0");
        System.out.println("-------------------------");
        System.out.print("ESCOLHA A OPERACAO: ");
    }

    public static int leOperacao() throws IOException, NumberFormatException {
        String op = Teclado.le();
        int operacao = Integer.parseInt(op);
        return operacao;
    }

    public static Cliente leCliente() {
        Cliente cliente = null;
        try {
            System.out.print("Nome do cliente: ");
            String nome = Teclado.le();
            System.out.print("Telefone do cliente: ");
            String telefone = Teclado.le();
            System.out.print("CPF do cliente : ");
            String cpf = Teclado.le();
            int id = 0;
            cliente = new Cliente(nome, telefone, cpf, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public static String leCPFCliente() {
        String cpf = "";
        try {
            while (cpf.equals("")) {
                System.out.print("CPF do cliente : ");
                String strId = Teclado.le();
                if (strId != null && strId.length() > 0) {
                    cpf = strId;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpf;
    }

    public static void listarClientes(List clientes) {
        if (clientes != null) {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(((Cliente) clientes.get(i)));
            }
        }
    }

    public static void executarTarefa(int operacao) throws GlobalcodeException {
    	String clienteID = null;
    	Cliente cliente = null;
    	
        switch (operacao) {
        case 1:
            System.out.println("Inserindo cliente");
            cliente = leCliente();
            dao.salvar(cliente);
            break;
        case 2:
            clienteID = leCPFCliente();
            dao.excluir(clienteID);
            break;
        case 3:
            System.out.println("Listando clientes");
            List clientes = dao.getAllClientes();
            listarClientes(clientes);
            break;
        case 4:
        	System.out.println("Buscando cliente por cpf");
        	clienteID = leCPFCliente();
        	cliente = dao.getClienteByCPF(clienteID);
        	if (cliente != null)
        		System.out.println(cliente);
        	else
        		System.out.println("CPF nao encontrado!");
        }
    }

    public static void main(String[] args) throws GlobalcodeException {
        int TERMINAR = 0;
        int operacao = 1;
        do {
            try {
                montaMenu();
                operacao = leOperacao();
                if (operacao == TERMINAR) {
                    break;
                } else {
                    executarTarefa(operacao);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Operacao invalida");
            }
        } while (operacao != TERMINAR);
    }
}
