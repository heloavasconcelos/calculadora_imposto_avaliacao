package model;

public class Servico implements CalculadoraDeImpostos {
	
	private int servicoCodigo;
	private String servicoNome;
	private double servicoPreco;
	
	public Servico(int servicoCodigo, String servicoNome, double servicoPreco) {
		this.servicoCodigo = servicoCodigo;
		this.servicoNome = servicoNome;
		this.servicoPreco = servicoPreco;
	}
	
	public Servico() {}
	
	@Override
	public String toString() {
		
		String s = 	"Cód.: " + this.servicoCodigo + 
					"\nNome: " + this.servicoNome + 
					"\nPreço: R$ " + this.servicoPreco +
					"\nImposto (5%): R$ " + calcularImpostos();
		
		return s;
	}
	
	@Override
	public double calcularImpostos() {
		return (this.servicoPreco * 0.05);
	}
	
	public int getServicoCodigo() {
		return servicoCodigo;
	}
	
	public void setServicoCodigo(int servicoCodigo) {
		this.servicoCodigo = servicoCodigo;
	}
	
	public String getServicoNome() {
		return servicoNome;
	}
	
	public void setServicoNome(String servicoNome) {
		this.servicoNome = servicoNome;
	}
	
	public double getServicoPreco() {
		return servicoPreco;
	}
	
	public void setServicoPreco(double servicoPreco) {
		this.servicoPreco = servicoPreco;
	}
	
}
