/* Grupo:
	Jean C. Bueno
	Sarah Moreira Messias
	Nicolas Juliani Ferreira
	Nicholas Lopes de Almeida
	Matheus Lopes dos Santos
*/

package models;

public class Orcamento {
    
    //Atributos
    private int id;
    private String data;
    private String fornecedor;
    private String produto;
    private double preco;
    
    //Construtores
    public Orcamento() {
	}

    public Orcamento(int id, String data, String fornecedor, String produto, double preco) {
	this.id = id;
	this.data = data;
	this.fornecedor = fornecedor;
	this.produto = produto;
	this.preco = preco;
    }
    
    // Getters && Setters
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

    public void setProduto (String produto) {
        this.produto = produto;
    }

    public double getPreco() {
	return preco;
    }

    public void setPreco(double preco) {
	this.preco = preco;
    }
          
    // Chave primária, marcado somente o "ID"
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
	Orcamento other = (Orcamento) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
	return id + "\t" + data + "\t" + fornecedor + "\t" + produto + "\t" + preco + "\n";
    }

}
