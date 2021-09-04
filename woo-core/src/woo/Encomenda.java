package woo;

import java.util.ArrayList;

public class Encomenda extends Transacao{
	private String _idFornecedor;
	private ArrayList<ProdEnc> _Produtos = new ArrayList<ProdEnc>();


	public Encomenda(int id , String idProduto , String idFornecedor ,int valorb,int datap,int qtd) { 
		
		super(id,datap,idProduto,qtd,valorb,"Encomenda");
		
		_idFornecedor = idFornecedor;
		
	}

	public void guardaP(String id,int qtd) { 
		ProdEnc pe,p2;
		pe = new ProdEnc(id,qtd);
		p2= searchProdEnc(id);
		if (p2 == null) {
		_Produtos.add(pe);
		}
		else {
			p2.aumentaQtd(qtd);
		}
	}
	
	public ArrayList<ProdEnc> getProdEncs(){
		return _Produtos;
	}
	
	
	public ProdEnc searchProdEnc(String  id){
		  
		  for (ProdEnc pe : _Produtos) {
		        if ((pe.getID().toUpperCase()).equals(id.toUpperCase())){
		            return pe;
		        }
		    }
		    return null;
		}
	
	
	public void reset() { _Produtos.clear();}

	public  String getIdFornecedor() {return _idFornecedor;}
	public  String getIdCliente() {return null;}
	public int getDataLim() {return 0;}
	public int getValorp() { return  0;}

	public String toString() {
		String res = super.getID() + "|"+ _idFornecedor + "|" + super.getValorb() + "|"  + super.getDatap();
		for (ProdEnc pe : _Produtos) {
			res += pe.toString();
		}
		return res;
	}
}