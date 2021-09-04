package woo;
import java.io.Serializable;
import java.util.Comparator;

public class Fornecedor implements Serializable{
	public String _id;
	public String _nome;
	public String _morada;
	public String _estado;
	
	public Fornecedor(String id,String nome, String morada) {
		_id = id;
		_nome = nome;
		_morada = morada;
		_estado = "SIM";
	}
	
	public String getID() { return _id;}
	public void setEstado(String e) { _estado = e;}
	public String getEstado() {return _estado;}
	
	public static Comparator<Fornecedor> FornecedorIDComparator = new Comparator<Fornecedor>() {
		public int compare(Fornecedor fornecedor1, Fornecedor fornecedor2) {
			   String fornecedorId1 = fornecedor1.getID().toUpperCase();
			   String fornecedorId2 = fornecedor2.getID().toUpperCase();
			  
			   return fornecedorId1.compareTo(fornecedorId2);
		}};

	public String toString() {
			return _id + "|" + _nome + "|" + _morada + "|";
	}
}
