package woo;

import java.util.ArrayList;

public class Venda extends Transacao{
	
	private String _idCliente;
	private int _valor_pagamento;
	private int _data_limite;
	
	
	public Venda(int id, String idCliente, String idProduto, int valorb, int valorp,int datal,int qtd){
		super(id,-1,idProduto,qtd,valorb,"Venda");
		_idCliente = idCliente;
		_valor_pagamento = valorp;
		_data_limite = datal;
	}
	
	@Override
	public String getIdCliente() {return _idCliente;}
	@Override
	public int getDataLim() {return _data_limite;}
	@Override
	public int getValorp() { return  _valor_pagamento;}
	
	
	
	public void setValorp(int valor) { _valor_pagamento = valor;}
	
	
	public String getIdFornecedor() {return null;}
	public ArrayList<ProdEnc> getProdEncs(){return null;}
	
	
	
	public String toString() {
		if ( super.getDatap() == -1) { return super.getID() + "|" + _idCliente + "|" + super.getIdProduto() + "|" + super.getQtd() + "|" + super.getValorb() + "|" + _valor_pagamento + "|" + _data_limite;}
		else { return super.getID() + "|" + _idCliente + "|" + super.getIdProduto() + "|" + super.getQtd() + "|" + super.getValorb() + "|" + _valor_pagamento + "|" + _data_limite + "|" + super.getDatap();}
	}
}
