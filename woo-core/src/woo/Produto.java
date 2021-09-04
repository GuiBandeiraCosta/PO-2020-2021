package woo;
import java.util.Comparator;
import java.io.Serializable;

public abstract class Produto implements Serializable {
	private int _preco;
	private int _valorCritico;
	private int _quantidade;
	private String _idFornecedor;
	private String _id;
	private String _tipo;
	
	public Produto(String tipo,int preco, int valorCritico, int quantidade, String idFornecedor,String id) {
		_preco = preco;
		_valorCritico = valorCritico;
		_quantidade = quantidade;
		_idFornecedor = idFornecedor;
		_id = id;
		_tipo = tipo;
	}
	
	public String getID() {return _id;}
	public int getQtd() {return _quantidade;}
	public void setQtd(int qtd) { _quantidade=qtd;}
	public String getTipo() { return _tipo;}
	public String getFornecedor() { return _idFornecedor;}
	public int getPreco() {return _preco;}
	public void setPreco(int preco) {_preco = preco;}
	
	public static Comparator<Produto> ProdutoIDComparator = new Comparator<Produto>() {
		public int compare(Produto p1, Produto p2) {
			   String pId1 = p1.getID().toUpperCase();
			   String pId2 = p2.getID().toUpperCase();
			   return pId1.compareTo(pId2);
		}};
	
		
	public String toString() { 
		return  _tipo + "|" + _id + "|" + _idFornecedor +"|" + _preco + "|" + _valorCritico + "|" + _quantidade + "|";
	}
}
