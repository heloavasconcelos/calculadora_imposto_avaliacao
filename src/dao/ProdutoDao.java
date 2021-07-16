package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDao {
	
	private Connection conexao;
	
	public ProdutoDao() {
		this.conexao = new ConnectionFactory().estabelecerConexao();
	}
	
	public Produto getInstance(int codigo) {
		String sql = "SELECT PRO_COD, PRO_NOME, PRO_PRECO, PRO_ALIQUOTA FROM PRODUTOS WHERE PRO_COD = ?";
		Produto produto = new Produto();
		
		try {
			
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.setInt(1, codigo);
			
			ResultSet result = st.executeQuery();
			while(result.next()) {
				produto.setProdutoCodigo(result.getInt("PRO_COD"));
				produto.setProdutoNome(result.getString("PRO_NOME"));
				produto.setProdutoPreco(result.getDouble("PRO_PRECO"));
				produto.setProdutoAliquota(result.getDouble("PRO_ALIQUOTA"));
			}
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Produto> getAll() {
		String sql = "SELECT PRO_COD, PRO_NOME, PRO_PRECO, PRO_ALIQUOTA FROM PRODUTOS ORDER BY PRO_COD";
		List<Produto> listaProduto = new ArrayList<Produto>(); 
		
		try {
			
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				Produto produto = new Produto();
				produto.setProdutoCodigo(result.getInt("PRO_COD"));
				produto.setProdutoNome(result.getString("PRO_NOME"));
				produto.setProdutoPreco(result.getDouble("PRO_PRECO"));
				produto.setProdutoAliquota(result.getDouble("PRO_ALIQUOTA"));
				listaProduto.add(produto);
			}
			return listaProduto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
