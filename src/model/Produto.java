package model;

public class Produto implements CalculadoraDeImpostos {
	
	private int produtoCodigo;
	private String produtoNome;
	private double produtoPreco;
	private double produtoAliquota;
	
	public Produto(int produtoCodigo, String produtoNome, double produtoPreco, double produtoAliquota) {
		this.produtoCodigo = produtoCodigo;
		this.produtoNome = produtoNome;
		this.produtoPreco = produtoPreco;
		this.produtoAliquota = produtoAliquota;
	}
	
	public Produto() {}
	
	@Override
	public String toString() {
		
		String s = 	"Cód.: " + this.produtoCodigo + 
					"\nNome: " + this.produtoNome + 
					"\nPreço: R$ " + this.produtoPreco +
					"\nImposto (" + this.produtoAliquota + "%): R$" + calcularImpostos();
		
		return s;
	}

	@Override
	public double calcularImpostos() {
		return (this.produtoPreco * (this.produtoAliquota / 100));
	}

	public int getProdutoCodigo() {
		return produtoCodigo;
	}

	public void setProdutoCodigo(int produtoCodigo) {
		this.produtoCodigo = produtoCodigo;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public double getProdutoPreco() {
		return produtoPreco;
	}

	public void setProdutoPreco(double produtoPreco) {
		this.produtoPreco = produtoPreco;
	}

	public double getProdutoAliquota() {
		return produtoAliquota;
	}

	public void setProdutoAliquota(double produtoAliquota) {
		this.produtoAliquota = produtoAliquota;
	}
	
	

}
