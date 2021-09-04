package woo;

public class Caixa extends Produto{
	NivelServico _nivelServico;
	
	public Caixa(String tipo,String id,String nivelServico ,String idFornecedor,int preco, int valorCritico,int quantidade) {
		super(tipo,preco,valorCritico,quantidade,idFornecedor,id);
		_nivelServico = NivelServico.valueOf(nivelServico);
		
	}
	
	@Override
	public String toString() { return super.toString() + _nivelServico;}
}