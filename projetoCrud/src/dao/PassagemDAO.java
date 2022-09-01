package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Passagem;


public class PassagemDAO {

	static Connection conn = null;
	static PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Passagem passagem) {
		String sql = "INSERT INTO Passagem (nome_passagem, preco_passagem) values(?,?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primem parametro da sql
			pstm.setString(1, passagem.getNome());
			
			pstm.setDouble(2, passagem.getPreco());

			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo para Ler
	public List<Passagem> getPassagem() {
		String sql = "select * from passagem;";

		List<Passagem> Passagem = new ArrayList<Passagem>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Passagem passagem = new Passagem();

				passagem.setId(rset.getInt("id_passagem"));

				passagem.setNome(rset.getString("nome_passagem"));
				
				passagem.setPreco(rset.getDouble("preco_passagem"));

				Passagem.add(passagem);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Passagem;
	}
	// Metodo pra atualizar

	public void update(Passagem passagem) {
		String sql = "UPDATE Passagem set nome_passagem = ?  where id_passagem = ? preco_passagem = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getNome());

			pstm.setInt(2, passagem.getId());
			
			pstm.setDouble(3, passagem.getPreco());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM Passagem WHERE id_passagem = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Passagem getPassagemById(int id) {
		String sql = "SELECT * FROM passagem WHERE id_passagem = ?;";

		Passagem passagem = new Passagem();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			passagem.setId(rset.getInt("id_passagem"));

			passagem.setNome(rset.getString("nome_passagem"));
			
			passagem.setPreco(rset.getDouble("preco_passagem"));
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return passagem;
	}
}

