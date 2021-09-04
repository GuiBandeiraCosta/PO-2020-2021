package woo;
import java.io.Serializable;
import java.util.ArrayList;


public abstract class Transacao implements Serializable {
			
	private int _id;
	private int _data_pagamento;
	private String _idProduto;
	private int _qtd;
	private int _valor_base;
	private String _tipo;
	
	
	
	public int getID() {return _id;}
	public int getDatap() {return _data_pagamento;}
	public String getIdProduto() {return _idProduto;}
	public int getQtd() {return _qtd;}
	public int getValorb() {return _valor_base;}
	
	public abstract String getIdFornecedor();
	public abstract String getIdCliente();
	public abstract int getDataLim();
	public abstract int getValorp();
	public abstract ArrayList<ProdEnc> getProdEncs();
	
	
	
	public String getTipo() {return _tipo;}
	
	public void setDatap(int data) {_data_pagamento = data;}
	
	public void somaPreco(int valor) { 
		_valor_base += valor;
		}
	
	public void guardaP(String p,int qtd) {} 
	
	public void reset() {}
	public void setPreco(int preco) {}
	
	public void setValorp(int valor) {}
	
	public Transacao(int id,int datap, String idProduto, int qtd , int valorb,String tipo){
		_id = id;
		_data_pagamento = datap;
		_idProduto = idProduto;
		_qtd = qtd;
		_valor_base = valorb ;
		_tipo = tipo;
	}
	
	
}
