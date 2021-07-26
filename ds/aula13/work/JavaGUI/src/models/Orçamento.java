package models;

public class Orçamento {
	private int id;
	private String data;
	private String fornecedor;
	private String produto;
	private int preco;
	
	public Orçamento(){}

	public Orçamento(int id, String data, String fornecedor, String produto, int preco) {
		this.id = id;
		this.data = data;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orçamento other = (Orçamento) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return  id + "\t" + data + "\t" + fornecedor
				+ "\t" + produto + "\t"+ "R$"+ getPreco() + "\n";
	}
	
	

}
