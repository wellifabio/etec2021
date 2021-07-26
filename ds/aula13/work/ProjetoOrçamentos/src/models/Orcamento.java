package models;

public class Orcamento {

	int id;
	String data, fornecedor, produto;
	double preco;
	public boolean ignore = false;

	public Orcamento(int i, String d, String f, String pd, double pc) {
		id = i;
		data = d;
		fornecedor = f;
		produto = pd;
		preco = pc;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		id = i;
	}

	public String getData() {
		return data;
	}

	public void setData(String s) {
		data = s;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String s) {
		fornecedor = s;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String s) {
		produto = s;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double d) {
		preco = d;
	}
}
