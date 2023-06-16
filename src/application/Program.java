package application;

import java.util.List;

import dao.DAO;
import model.Cadastro;

public class Program {

	public static void main(String[] args) {

		
        DAO dao = new DAO();
       
        List<Cadastro> cadastros = dao.listarTodos();

        // Imprimindo os cadastros retornados
        for (Cadastro cadastro : cadastros) {
            System.out.println(cadastro);
        }
        
        //inserir
        Cadastro cadastro = new Cadastro();
        cadastro.setNome("samuel");
        cadastro.setEmail("samuel@gmail.com");
        Cadastro resultado = dao.inserir(cadastro);
        
        //excluir
        dao.excluir(1);
        
        //atualizar 
        Cadastro cadastro1 = new Cadastro();
        cadastro1.setId(1); // ID do registro a ser atualizado
        cadastro1.setNome("Novo Nome");
        cadastro1.setEmail("novoemail@example.com");
        Cadastro resultado1 = dao.atualizar(cadastro);
		
		
		
	}

}
