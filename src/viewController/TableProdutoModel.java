package viewController;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.ProdutoDao;
import model.Produto;

public class TableProdutoModel extends AbstractTableModel {

	private List<Produto> listaProduto = new ArrayList<Produto>();
	private String [] colunas = {"Código", "Descrição", "Preço", "%"};
	private ProdutoDao dao = new ProdutoDao();
	
	public TableProdutoModel() {
		listaProduto = dao.getAll();
	}
	
	@Override
	public int getRowCount() {
		return listaProduto.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch (columnIndex) {
		case 0:
			
			return listaProduto.get(rowIndex).getProdutoCodigo();
		case 1:
			
			return listaProduto.get(rowIndex).getProdutoNome();
		case 2:
			
			return listaProduto.get(rowIndex).getProdutoPreco();
		case 3:
			
			return listaProduto.get(rowIndex).getProdutoAliquota();
		default:
		}
		return null;
	}
	
	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}
	
	public Produto getProduto(int p) {
		return listaProduto.get(p);
	}
	
	public void refresh() {
		listaProduto = dao.getAll();
		fireTableDataChanged();
	}

}
