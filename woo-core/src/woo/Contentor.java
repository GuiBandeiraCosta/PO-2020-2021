package woo;

public class Contentor extends Caixa{
	QualidadeServico _qualidadeServico;
	public Contentor(String tipo,String id,String nivelServico,String qualidadeServico,String idFornecedor,int preco, int valorCritico,int quantidade) {
		super(tipo,id,nivelServico ,idFornecedor,preco,valorCritico,quantidade);
		_qualidadeServico = QualidadeServico.valueOf(qualidadeServico);
	}
	
	@Override
	public String toString() { return super.toString() + "|" + _qualidadeServico;}
}
