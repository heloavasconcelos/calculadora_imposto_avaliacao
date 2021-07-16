package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Servico;

public class ServicoDao {
	
	private Connection conexao;
	
	public ServicoDao() {
		this.conexao = new ConnectionFactory().estabelecerConexao();
	}
	
	public Servico getInstance(int codigo) {
		String sql = "SELECT SER_COD, SER_NOME, SER_PRECO FROM SERVICOS WHERE SER_COD = ?";
		Servico servico = new Servico();
		try {
			
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setInt(1, codigo);
			
			ResultSet result = st.executeQuery();
			while(result.next()) {
				servico.setServicoCodigo(result.getInt("SER_COD"));
				servico.setServicoNome(result.getString("SER_NOME"));
				servico.setServicoPreco(result.getDouble("SER_PRECO"));
			}
			return servico;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Servico> getAll() {
		String sql = "SELECT SER_COD, SER_NOME, SER_PRECO FROM SERVICOS ORDER BY SER_COD";
		List<Servico> listaServico = new ArrayList<Servico>();
		
		try {
			
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				Servico servico = new Servico();
				servico.setServicoCodigo(result.getInt("SER_COD"));
				servico.setServicoNome(result.getString("SER_NOME"));
				servico.setServicoPreco(result.getDouble("SER_PRECO"));
				listaServico.add(servico);
			}
			return listaServico;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


}
