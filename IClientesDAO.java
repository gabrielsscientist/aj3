package br.com.globalcode.aj3.dao;

import java.util.List;

import br.com.globalcode.aj3.beans.Cliente;
import br.com.globalcode.aj3.exception.GlobalcodeException;

public interface IClientesDAO {

	public abstract void salvar(Cliente cliente) throws GlobalcodeException;

	public abstract void excluir(String cpf) throws GlobalcodeException;

	public abstract List getAllClientes() throws GlobalcodeException;

	public abstract Cliente getClienteByCPF(String cpf)	throws GlobalcodeException;
}