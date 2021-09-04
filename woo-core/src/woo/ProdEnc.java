package woo;

public class ProdEnc {
	private String _id;
	private int _qtd;
	public ProdEnc(String id,int qtd) {
		_id = id ;
		_qtd = qtd;
	}
	
	public String getID() {return _id;}
	public void aumentaQtd(int qtd) { _qtd+=qtd;}
	public int getQtd() {return _qtd;}
	
	
	
	public String toString() { return "\n" + _id + "|" + _qtd;}
}
