package controller;

import java.util.List;

import model.BaseDados;
import model.Funcionario;

public class FuncionarioBusiness {
BaseDados bd = BaseDados.getInstancia();
	
	public FuncionarioBusiness() {
		super();
	}
	
	public boolean Cadastra (String nome, Character sexo, String cpf,
			 String cep, String email, String celular, String funcao) {

		boolean cadastro = false;
		List<Funcionario> funcs = bd.getFuncionarios();
		int codigo = funcs.size();
		Funcionario func = new Funcionario(codigo, nome, sexo, cpf, cep, email, celular, funcao);
		
		if(func != null){
			funcs.add(func);
			cadastro = true;
		}
		return cadastro;
	}
	
	public boolean Remove (String cpf){
		boolean delete = false;
		List<Funcionario> funcs = bd.getFuncionarios();
		
		for (int i = 0; i < funcs.size(); i++) {
			if (funcs.get(i).getCpf().equals(cpf)){
				funcs.remove(i);
				delete = true;
			}
		}
		return delete;
	}
	
	public boolean Edita(String nome, Character sexo, String cpf, String cep, String email, 
			String celular, String funcao){
		boolean edite = false;
		List<Funcionario> funcs = bd.getFuncionarios();
		
		for (int i = 0; i < funcs.size(); i++) {
			if (funcs.get(i).getCpf().equals(cpf)){
				int codigo = funcs.size();
				Funcionario funcE = new Funcionario(codigo, nome, sexo, cpf, cep, email, celular, funcao);
				if(funcE != null){
					funcs.set(i, funcE);
					edite = true;
				}
			}
		}
		return edite;
	}
	
	public void Lista (){
		List<Funcionario> funcs = bd.getFuncionarios();
				
		for (int i = 0; i < funcs.size(); i++) {
			 int codigo = funcs.get(i).getCodigo();
			 String nome = funcs.get(i).getNome();
			 char sexo = funcs.get(i).getSexo();
			 String cpf =  funcs.get(i).getCpf();
			 String cep = funcs.get(i).getCep();
			 String email = funcs.get(i).getEmail();
			 String celular = funcs.get(i).getCelular();
			 String funcao = funcs.get(i).getFuncao();
			 System.out.println("########FUNCIONARIO " + i);
			 System.out.println(" " +codigo +" " +nome +" " + sexo+" " + cpf+" " + cep+ " " +email+" " +celular+" " +funcao);
		}
	}
	

}