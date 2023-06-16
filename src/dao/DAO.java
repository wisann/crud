package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.MyException;
import model.Cadastro;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;

	public DAO() {
		conn = DB.getConnection();
	}

	public Cadastro inserir(Cadastro cadastro) {
		String sql = "insert into aluno(nome, email) values (?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getEmail());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new MyException(e.getMessage());
		}
		finally {
			DB.closeConnection(conn);
			DB.closePreparedStatement(ps);
		}
		return cadastro;
	}

	public List<Cadastro> listarTodos() {
		List<Cadastro> cadastros = new ArrayList<>();
		String sql = "select * from aluno";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cadastro cadastro = new Cadastro();
				cadastro.setId(rs.getInt("id"));
				cadastro.setNome(rs.getString("nome"));
				cadastro.setEmail(rs.getString("email"));
				cadastros.add(cadastro);
			}

		} catch (SQLException e) {
			throw new MyException(e.getMessage());
		} finally {
			DB.closeConnection(conn);
			DB.closePreparedStatement(ps);
		}
		return cadastros;
	}

	public Cadastro atualizar(Cadastro cadastro) {
		String sql = "update aluno set nome = ?, email =? where id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getEmail());
			ps.setInt(3, cadastro.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new MyException(e.getMessage());
		} finally {
			DB.closeConnection(conn);
			DB.closePreparedStatement(ps);
		}
		return cadastro;
	}

	public void excluir(int id) {
		String sql = "delete from aluno where id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new MyException(e.getMessage());
		}
		finally {
			DB.closeConnection(conn);
			DB.closePreparedStatement(ps);
		}
	}

}
