package models;

import java.util.Objects;

public class Orcamento {
	private int id;
	private String data;
	private String fornecedor;
	private String produto;
	private double preco;
	
	public Orcamento() {}

	public Orcamento(int id, String data, String fornecedor, String produto, double preco) {
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return id + "\t" + data + "\t" + fornecedor + "\t" + produto
				+ "\t" + preco + "\n";
	}
}