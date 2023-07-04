package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Curso;

public class CursoDAOImp implements CursoDAO {

	private Connection conexao;

	public CursoDAOImp(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Curso obj) {
		try {
			PreparedStatement st = conexao.prepareStatement("INSERT INTO curso (nomecurso)" + "VALUES (?);",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNomecurso());
			int linhas = st.executeUpdate();

			if (linhas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					obj.setIdcurso(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Curso obj) {
		try {
			PreparedStatement st = conexao.prepareStatement("UPDATE curso SET nomecurso = ? WHERE idcurso = ?;");

			st.setString(1, obj.getNomecurso());
			st.setInt(2, obj.getIdcurso());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement st = conexao.prepareStatement("DELETE FROM curso WHERE idcurso = ?;");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Curso findById(Integer id) {
		Curso curso = null;

		try {
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM curso WHERE idcurso = ?;");

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				curso = new Curso();
				curso.setIdcurso(rs.getInt("idcurso"));
				curso.setNomecurso(rs.getString("nomecurso"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return curso;
	}

	@Override
	public List<Curso> findAll() {
		List<Curso> cursos = new ArrayList<>();

		try {
			PreparedStatement st = conexao.prepareStatement("SELECT * FROM curso;");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setIdcurso(rs.getInt("idcurso"));
				curso.setNomecurso(rs.getString("nomecurso"));

				cursos.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cursos;
	}

}
