package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contatos;

public class ContatosDao extends Contatos {

	// Create
	public void inserir(Contatos contato) {

		try {
			Connection con = new ConnectionFactory().getConnection();

			String sql = "INSERT INTO contatos (id, nome, email, telefone) VALUES(?, ?, ?, ?)";

			PreparedStatement smt = con.prepareStatement(sql);

			smt.setInt(1, contato.getId());
			smt.setString(2, contato.getNome());
			smt.setString(3, contato.geteMail());
			smt.setString(4, contato.getTelefone());

			smt.execute();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Read
	public List<Contatos> listar() {

		List<Contatos> contatos = new ArrayList<Contatos>();

		try {
			Connection con = new ConnectionFactory().getConnection();

			PreparedStatement smt = con.prepareStatement("select * from contatos");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Contatos c = new Contatos();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.seteMail(rs.getString("eMail"));
				c.setTelefone(rs.getString("Telefone"));

				contatos.add(c);
			}

			rs.close();
			smt.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return contatos;
	}

	// Delete
	public void delete(Contatos contato) {

		try {
			Connection con = new ConnectionFactory().getConnection();

			String sql = "DELETE FROM contatos WHERE id=(?)";

			PreparedStatement smt = con.prepareStatement(sql);

			smt.setInt(1, contato.getId());

			smt.execute();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}