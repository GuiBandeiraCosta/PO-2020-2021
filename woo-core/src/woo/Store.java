package woo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;


import woo.exceptions.BadEntryException;
import woo.exceptions.ChaveClienteNaoConhecidaException;
import woo.exceptions.ChaveDuplicadaClienteException;
import woo.exceptions.idFornecedorDesconhecidoException;
import woo.exceptions.idProdutoDesconhecidoException;
import woo.exceptions.ServicoDesconhecidoException;
import woo.exceptions.Q_ServicoDesconhecidoException;
import woo.exceptions.ChaveDuplicadaPException;
import woo.exceptions.ProdutoIndisponivelException;
import woo.exceptions.FornecedorSemProdutoException;
import woo.exceptions.TransacaoDesconhecidaException;
import woo.exceptions.ChaveDuplicadaFornecedorException;
import woo.exceptions.FornecedorNaoAtivoException;



import java.util.Collections;
import java.util.Collection;

//FIXME import classes (cannot import from pt.tecnico or woo.app)

/**
 * Class Store implements a store.
 */
public class Store implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202009192006L;
  private ArrayList<Cliente> _listaClientes = new ArrayList<Cliente>();
  private ArrayList<Fornecedor> _listaFornecedores = new ArrayList<Fornecedor>();
  private ArrayList<Produto> _listaProdutos = new ArrayList<Produto>();
  private ArrayList<Transacao> _listaTransacoes = new ArrayList<Transacao>();
  
  
  private int _data = 0;
  private int _n_transacoes = 0;
  private double _SaldoD = 0;
  private double _SaldoC = 0;
  

  
  // FIXME define attributes
  // FIXME define contructor(s)
  // FIXME define methods

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   */
  public int getData() {return _data;}
  public void setData(int data) {_data = data; } 
  
  
  public void aumenta_n_t() {_n_transacoes += 1; }
  
  public void ChangeName(String nome,String idcliente) throws  ChaveClienteNaoConhecidaException  {
	  Cliente c = searchClient(idcliente);
	  if( c == null) { throw new ChaveClienteNaoConhecidaException();}
	  c.setNome(nome);
	  
  }
  
  
  /**
   * Importa o ficheiro de texto com os inputs
   * @param txtfile
   * @throws IOException
   * @throws BadEntryException
   */
  public void importFile(String txtfile) throws IOException, BadEntryException /* FIXME maybe other exceptions */ {
	  BufferedReader reader = new BufferedReader(new FileReader(txtfile));
      String line;
      while ((line = reader.readLine()) != null) {
              String[] fields = line.split("\\|");
              registaCampos(fields);
                              
      }
      reader.close();
  }
 /**
  * Regista os inputs
  * @param fields
  */
  void registaCampos(String[] fields) {
	  if (fields[0].equals("CLIENT")) {
		 Cliente c = new Cliente(fields[1],fields[2],fields[3]);
	  	  _listaClientes.add(c);
	  }
	  else if(fields[0].equals("SUPPLIER")) {
		 Fornecedor f = new Fornecedor(fields[1],fields[2],fields[3]);
		  _listaFornecedores.add(f);
	  }
	  else if(fields[0].equals("BOOK")) {
		 Livro l = new Livro("BOOK",fields[1],fields[2],fields[3],fields[4],fields[5],Integer.parseInt(fields[6]),Integer.parseInt(fields[7]),Integer.parseInt(fields[8]));
		  _listaProdutos.add(l);
	  }
	  else if(fields[0].equals("BOX")) {
		 Caixa ca = new Caixa("BOX",fields[1],fields[2],fields[3],Integer.parseInt(fields[4]),Integer.parseInt(fields[5]),Integer.parseInt(fields[6]));
		  _listaProdutos.add(ca);
	  }
	  else if(fields[0].equals("CONTAINER")) {
		 Contentor co = new Contentor("CONTAINER",fields[1],fields[2],fields[3],fields[4],Integer.parseInt(fields[5]),Integer.parseInt(fields[6]),Integer.parseInt(fields[7]));
		  _listaProdutos.add(co);
	  }	
  }
  
  /**
   * Encontra o cliente dado um id
   * Caso nao encontre devolve null
   * @param id
   * @return
   */
  public Cliente searchClient(String id)  {
	  for (Cliente c : _listaClientes) {
	        if ((c.getID().toUpperCase()).equals(id.toUpperCase())) {
	            return c;
	        }
	    }
	    return null;
	}
  
  /**
   * Auxiliar do Show Client na App
   * @param id
   * @return
   * @throws ChaveClienteNaoConhecidaException
   */
  public Cliente getClient(String id) throws ChaveClienteNaoConhecidaException {
	  Cliente c = searchClient(id);
	  if(c == null) throw new ChaveClienteNaoConhecidaException();
	  return c;
	}
  
  
  /**
   * Devolve a lista do Clientes ja sorted
   * @return
   */
  public Collection<Cliente> getAllClientes() {
	  	Collections.sort(_listaClientes, Cliente.ClienteIDComparator);
	    return Collections.unmodifiableCollection(_listaClientes);
	  }
  
  
  public Fornecedor searchFornecedor(String id)  {
	  for (Fornecedor f : _listaFornecedores) {
	        if ((f.getID().toUpperCase()).equals(id.toUpperCase())) {
	            return f;
	        }
	    }
	    return null;
	}
  
  
  
  
  /**
   * Devolve lista de Fornecedores ja sorted
   * @return
   */
  public Collection<Fornecedor> getAllFornecedores() {
	  	Collections.sort(_listaFornecedores, Fornecedor.FornecedorIDComparator);
	    return Collections.unmodifiableCollection(_listaFornecedores);
	  }
  
  /**
   * Adiciona um Cliente a lista de Clientes manualmente
   * @param id
   * @param nome
   * @param morada
   * @throws ChaveDuplicadaClienteException
   */
  public void RegisterClient(String id, String nome, String morada) throws ChaveDuplicadaClienteException{
	  if( searchClient(id) != null) throw new ChaveDuplicadaClienteException();
	  Cliente c = new Cliente(id,nome,morada);
	  _listaClientes.add(c);
	  
  }
  
  
  public Produto searchProduto(String id){
	  for (Produto p : _listaProdutos) {
	        if ((p.getID().toUpperCase()).equals(id.toUpperCase())) {
	            return p;
	        }
	    }
	    return null;
	}
  
  
  
  public void RegisterFornecedor(String id, String nome, String morada) throws ChaveDuplicadaFornecedorException{
	  if( searchFornecedor(id) != null) throw new ChaveDuplicadaFornecedorException();
	  Fornecedor f = new Fornecedor(id,nome,morada);
	  _listaFornecedores.add(f);
	  
  }
  
  public int toggleT(String idFornecedor)  throws idFornecedorDesconhecidoException{
	  Fornecedor f = searchFornecedor(idFornecedor);
	  if( f == null) throw new idFornecedorDesconhecidoException();
	  String state = f.getEstado();
	  if (state.equals("SIM")) {f.setEstado("NAO"); return 1;}
	  else if (state.equals("NAO")) { f.setEstado("SIM"); return 0;}
	  return -1;
  }
  
  
  
  public void RegisterProduct(String id, String idFornecedor, String Service , int preco , int valorC,String titulo,String autor,String ISBN, String Q_Service,String flag) throws idFornecedorDesconhecidoException,ChaveDuplicadaPException,ServicoDesconhecidoException,Q_ServicoDesconhecidoException{
	  
	  Caixa c;
	  Contentor co;
	  Livro l;
	  Fornecedor f = searchFornecedor(idFornecedor);
	  if (searchProduto(id) != null) throw new ChaveDuplicadaPException();
	  if (f==null) throw new idFornecedorDesconhecidoException();
	  else if (flag == "BOOK") {
			 l = new Livro(flag,id,titulo,autor,ISBN,idFornecedor,preco,valorC,0);
		    _listaProdutos.add(l);}
	  else if (( Service.equals("NORMAL") || Service.equals("AIR") || Service.equals("EXPRESS") || Service.equals("PERSONAL")) == false) throw new ServicoDesconhecidoException();
	  else if( flag == "BOX") {
		 c = new Caixa(flag,id,Service,idFornecedor,preco,valorC,0);
	  	_listaProdutos.add(c);}
	  else if( flag == "CONTAINER") {
		  	if ( (Q_Service.equals("B4") || Q_Service.equals("C4") || Q_Service.equals("C5") || Q_Service.equals("DL")) == false ) throw new Q_ServicoDesconhecidoException();
		  	co = new Contentor(flag,id,Service,Q_Service,idFornecedor,preco,valorC,0);
		 	_listaProdutos.add(co);}
	  
  }
  
  
  public void ChangePreco(String id, int preco) throws idProdutoDesconhecidoException{
	  Produto p = searchProduto(id);
	  if (p == null) { throw new idProdutoDesconhecidoException();}
	  if(preco > 0)  {p.setPreco(preco);}
  }
  
  public String ProcuraPUnder(int preco) {
	  String res = "";
	  Collections.sort(_listaProdutos, Produto.ProdutoIDComparator);
	  for (Produto p : _listaProdutos) {
		  if (p.getPreco() < preco) { res += p.toString()+"\n";} 
	  }
	  return res;
  }
  
  
  /**
   * Devolve a lista de Produtos ja sorted
   * @return
   */
  public Collection<Produto> getAllProdutos(){
	  Collections.sort(_listaProdutos, Produto.ProdutoIDComparator);
	  return Collections.unmodifiableCollection(_listaProdutos);
  }
  
  public void RegisterVenda(String idCliente,String idProduto,int datal,int qtd) throws idProdutoDesconhecidoException,ChaveClienteNaoConhecidaException,ProdutoIndisponivelException {
	  int valorb,valorp;
	  Venda v;
	  Produto p;
	  Cliente c = searchClient(idCliente);
	  if(c ==null) throw new ChaveClienteNaoConhecidaException();
	  
	  if(searchProduto(idProduto) == null) throw new idProdutoDesconhecidoException();
	  p = searchProduto(idProduto);
	  if (p.getQtd()<qtd) throw new ProdutoIndisponivelException();
	  p.setQtd(p.getQtd()-qtd);
	  valorb = p.getPreco() * qtd;
	  valorp = valorb;
	  c.setComprasE(valorb);
	  v = new Venda(_n_transacoes,idCliente,idProduto,valorb,valorp,datal,qtd);
	  _listaTransacoes.add(v);
	  _n_transacoes+=1;
  }
  
  
  public void RegisterEncomenda(String idFornecedor, String idProduto,int qtd) throws FornecedorSemProdutoException,idProdutoDesconhecidoException,idFornecedorDesconhecidoException,FornecedorNaoAtivoException{
	  int valorb = 0;
	  Transacao t;
	  Produto p;	  
	  t = searchTransaction(_n_transacoes);
	  p = searchProduto(idProduto);
	  
	  if (searchFornecedor(idFornecedor) == null) { throw new idFornecedorDesconhecidoException();}
	  if ((searchFornecedor(idFornecedor).getEstado()).equals("NAO") ) {throw new FornecedorNaoAtivoException();}
	  if(p == null) { 
		  if(t != null) {
			removeQtdEnc(t.getProdEncs());
			_listaTransacoes.remove(_n_transacoes);
		  }
		  throw new idProdutoDesconhecidoException();
		  }
	  if((p.getFornecedor()).equals(idFornecedor)==false) {
		  if(t != null) {
			  removeQtdEnc(t.getProdEncs());
			  _listaTransacoes.remove(_n_transacoes);
		  }
		  throw new FornecedorSemProdutoException();
		  }
	  
	  valorb = p.getPreco() * qtd;
	  p.setQtd(p.getQtd()+qtd);
	  if ( t == null) {
		  t = new Encomenda(_n_transacoes,idProduto,idFornecedor,valorb,_data,qtd);
		  t.guardaP(idProduto,qtd);
		  _listaTransacoes.add(t);
	  }
	  else { 
		  t.guardaP(idProduto,qtd);
		  t.somaPreco(valorb);
		  
	  } 
	  
  }

  public void removeQtdEnc(ArrayList<ProdEnc> _Produtos) {
	  for (ProdEnc pe : _Produtos) {
		  Produto p = searchProduto(pe.getID());
		  p.setQtd(p.getQtd() - pe.getQtd());
	  }
  }
  
  
  
  public int getSaldos(int flag) {

	  if (flag == 1 ) {
		  _SaldoC = 0;
		  _SaldoD = 0;
		  for( Transacao t : _listaTransacoes) {
			Valor_pagar(t.getID());
			if (t.getTipo().equals("Encomenda")) {_SaldoC -= t.getValorb();}
			else if (t.getTipo().equals("Venda")) {_SaldoC += t.getValorp();}
		  }
		  return (int) Math.round(_SaldoC); 
	  }
	  else if (flag == 0) {
		  _SaldoD = 0;
		  _SaldoC = 0;
		  for( Transacao t : _listaTransacoes) {
				if (t.getTipo().equals("Encomenda")) {_SaldoD -= t.getValorb();}
				else if (t.getTipo().equals("Venda") && (t.getDatap()) != -1) {_SaldoD += t.getValorp();}
			  }
		  return (int) Math.round(_SaldoD); 
	  }
	  return -1;
  }
  
  
  
  
  
  
  
  public void Valor_pagar(int idTransacao){
	  int N= 0;
	  double multa = 0;
	  double desconto= 0;
	  double valorp;
	  Transacao t = searchTransaction(idTransacao);
	  
	  if (t.getTipo().equals("Venda") && t.getDatap() == -1 ) {
		  int dataLim = t.getDataLim();
		  int valorb = t.getValorb();
		  EstatutoCliente e;
		  Produto p = searchProduto(t.getIdProduto());
		  e = (searchClient(t.getIdCliente())).getEstatuto();
		  if ((p.getTipo()).equals("BOX")==true) {
			  N = 5;
		  }
		  else if ((p.getTipo()).equals("BOOK")==true) {   /* N 8 data 6 datal 2*/
			  N = 3;
		  }
		  else if ((p.getTipo()).equals("CONTAINER")==true) {
			  N = 8;
		  }
		  if ( dataLim - _data >= N) { multa = 0; desconto = 0.10;}
		  else if (0 <=  dataLim - _data &&  dataLim - _data < N) { 
			  multa = 0;
			  if (e.equals(EstatutoCliente.NORMAL) ) { desconto = 0;}
			  else if(e.equals(EstatutoCliente.SELECTION)) { 
				  if ( dataLim - _data >= 2) {desconto = 0.05;}
				  else{desconto = 0;};	  
				  }
			  else if(e.equals(EstatutoCliente.ELITE)) { desconto = 0.10;}	
		  }
		  else if (_data - dataLim<=N && 0 <_data - dataLim) {
			  if (e.equals(EstatutoCliente.NORMAL) ) { desconto = 0; multa = 0.05;}
			  else if(e.equals(EstatutoCliente.SELECTION)) { 
				  if (_data - dataLim <= 1) {multa = 0; }
				  else {multa = 0.02;}
				  desconto = 0;
				  }
			  else if(e.equals(EstatutoCliente.ELITE)) { desconto = 0.05; multa = 0;}	
		  }
		  else if ( _data - dataLim>N) {
			  desconto = 0;
			  if ((e).equals(EstatutoCliente.NORMAL) ) {  multa = 0.10;}
			  else if(e.equals(EstatutoCliente.SELECTION)) {multa = 0.05; }
				  
			  else if(e.equals(EstatutoCliente.ELITE)) {multa = 0;}
		  }
		  
		  valorp = valorb * (1-desconto);
		  
		  if (multa != 0) {
		  valorp = valorp * (1 +(_data - dataLim)*multa);
		  }
		    int valorpF = (int) Math.round(valorp);
		  	t.setValorp(valorpF);

		  }
		 
	  }
	  
 
  
  
  
public void Pay(int idTransacao) throws TransacaoDesconhecidaException {
	Transacao t = searchTransaction(idTransacao);
	if (t == null) { throw new TransacaoDesconhecidaException();}
	if ( (t.getTipo()).equals("Venda") == true && t.getDatap()==-1 ) {
		String idC = t.getIdCliente();
		int dataLim = t.getDataLim();
		Cliente c = searchClient(idC);
		Valor_pagar(idTransacao);
		int valorp = t.getValorp();
		t.setDatap(_data);
		c.setComprasF(valorp);
		if (dataLim - _data >= 0) {
			c.aumentaPontos(valorp*10);
			if(c.getPontos()> 25000) { c.setEstatuto(EstatutoCliente.ELITE);}
			else if(c.getPontos()> 2000) { c.setEstatuto(EstatutoCliente.SELECTION);}
			
		}
		else if(_data - dataLim > 15 && c.getEstatuto().equals(EstatutoCliente.ELITE) ) { 
			c.setEstatuto(EstatutoCliente.SELECTION); 
			c.setPontos(((c.getPontos())*25)/100);
		}
		else if(_data - dataLim > 2 && c.getEstatuto().equals(EstatutoCliente.SELECTION)){
			c.setEstatuto(EstatutoCliente.NORMAL); 
			c.setPontos(((c.getPontos())*10)/100);
		}
		}
		
	}


  public String ShowTransacaoCliente(String idCliente)  throws ChaveClienteNaoConhecidaException{
	  String res = "";
	  if (searchClient(idCliente) == null) throw new ChaveClienteNaoConhecidaException();
	  for ( Transacao t : _listaTransacoes) {
		  if (t.getTipo().equals("Venda") && (t.getIdCliente()).equals(idCliente)) {
			  Valor_pagar(t.getID());
			 res += t.toString() + "\n";
		  }
	  }
	  return res;
  }
  
  
  
  public String ShowFaturasCliente(String idCliente) throws ChaveClienteNaoConhecidaException{
	  String res = "";
	  if (searchClient(idCliente) == null) throw new ChaveClienteNaoConhecidaException();
	  for ( Transacao t : _listaTransacoes) {
		  if (t.getTipo().equals("Venda") && (t.getIdCliente()).equals(idCliente) && t.getDatap()!=-1) {
			  res += t.toString() + "\n";
		  }
	  }
	  return res;
  }
	 
  
  public String ShowTransacaoFornecedor(String idFornecedor) throws idFornecedorDesconhecidoException{
	  String res = "";
	  if(searchFornecedor(idFornecedor) == null) throw new idFornecedorDesconhecidoException();
	  for ( Transacao t : _listaTransacoes) {
		  if (t.getTipo().equals("Encomenda") && (t.getIdFornecedor()).equals(idFornecedor)) {
			 res += t.toString() + "\n";
		  }
	  }
	  return res;
  }
  
  public Transacao searchTransaction(int  id){
	  
	  for (Transacao t : _listaTransacoes) {
	        if (t.getID()==id) {
	            return t;
	        }
	    }
	    return null;
	}
  
  
  
  
   public Transacao getTransaction(int id) throws TransacaoDesconhecidaException {
	  Transacao t = searchTransaction(id);
	   if(t == null) throw new TransacaoDesconhecidaException();
	  return t;
	}  
	
  
 
}


