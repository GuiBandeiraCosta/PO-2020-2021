package woo;


public class Livro extends Produto {
	private String _titulo;
	private String _autor;
	private String _ISBN;
	public Livro(String tipo,String id,String titulo ,String autor, String ISBN, String idFornecedor,int preco, int valorCritico,int quantidade) {
		super(tipo,preco,valorCritico,quantidade,idFornecedor,id);
		_titulo = titulo;
		_autor = autor;
		_ISBN = ISBN;
		
	}
	@Override
	public String toString() { return super.toString() + _titulo + "|" + _autor + "|" + _ISBN;}
}
