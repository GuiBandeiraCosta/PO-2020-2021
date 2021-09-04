package woo;
import java.util.Comparator;
import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
	private String _id;
	private String _nome;
	private String _morada;
	private int _comprasE;
	private int _comprasF;
	private EstatutoCliente _estatuto;
	private int _pontos;
	
	
	public Cliente(String id,String nome, String morada) {
		_id = id;
		_nome = nome;
		_morada = morada;
		_estatuto = EstatutoCliente.NORMAL;
		_pontos = 0;
		_comprasE = 0;
		_comprasF= 0;
	}
	
	public String getID() {return _id;}
	public void setNome(String nome) { _nome = nome;}
	public void aumentaPontos(int p) { _pontos += p;}
	public int getPontos() {return _pontos;}
	
	
	public void setComprasE(int valor) {_comprasE += valor;}
	public void setComprasF(int valor) {_comprasF += valor;}
	public void setPontos(int pontos) {_pontos = pontos;}
	public void setEstatuto(EstatutoCliente e) { _estatuto = e;}
	public EstatutoCliente getEstatuto() {return _estatuto;}
	
	public static Comparator<Cliente> ClienteIDComparator = new Comparator<Cliente>() {
		public int compare(Cliente cliente1, Cliente cliente2) {
			   String clienteId1 = cliente1.getID().toUpperCase();
			   String clienteId2 = cliente2.getID().toUpperCase();
			   return clienteId1.compareTo(clienteId2);
		}};
		
	
	
	
	public String toString() {
		return _id + "|" + _nome + "|" + _morada +"|" + _estatuto + "|" + _comprasE + "|" + _comprasF;
	}
}
