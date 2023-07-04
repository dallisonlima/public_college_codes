package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Disciplina;

public class DisciplinaDAOImp implements DisciplinaDAO {
	private Connection conexao;

	public DisciplinaDAOImp(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Disciplina obj) {
		try {
			PreparedStatement st = conexao.prepareStatement(
					"INSERT INTO disciplina (nomedisciplina, cargahoraria) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNomedisciplina());
			st.setInt(2, obj.getCargahoraria());

			int linhas = st.executeUpdate();

			if (linhas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					obj.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Disciplina obj) {
		try {
			PreparedStatement st = conexao
					.prepareStatement("UPDATE disciplina SET nomedisciplina = ?, cargahoraria = ? WHERE id = ?");

			st.setString(1, obj.getNomedisciplina());
			st.setInt(2, obj.getCargahoraria());
			st.setInt(3, obj.getId());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement st = conexao.prepareStatement("DELETE FROM disciplina WHERE iddisciplina = ?");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Disciplina findById(Integer id) {
		Disciplina disciplina = null;

		try {
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM disciplina WHERE id = ?");

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				disciplina = new Disciplina();
				disciplina.setId(rs.getInt("iddisciplina"));
				disciplina.setNomedisciplina(rs.getString("nomedisciplina"));
				disciplina.setCargahoraria(rs.getInt("cargahoraria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return disciplina;
	}

	@Override
	public List<Disciplina> findAll() {
		List<Disciplina> disciplinas = new ArrayList<>();

		try {
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM disciplina");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getInt("iddisciplina"));
				disciplina.setNomedisciplina(rs.getString("nomedisciplina"));
				disciplina.setCargahoraria(rs.getInt("cargahoraria"));
				disciplinas.add(disciplina);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return disciplinas;
	}
}
