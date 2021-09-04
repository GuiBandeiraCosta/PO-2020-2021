package woo;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import woo.exceptions.BadEntryException;
import woo.exceptions.ChaveClienteNaoConhecidaException;
import woo.exceptions.ChaveDuplicadaClienteException;
import woo.exceptions.ChaveDuplicadaPException;
import woo.exceptions.ImportFileException;
import woo.exceptions.MissingFileAssociationException;
import woo.exceptions.UnavailableFileException;
import woo.exceptions.idFornecedorDesconhecidoException;
import woo.exceptions.ServicoDesconhecidoException;
import woo.exceptions.Q_ServicoDesconhecidoException;
import woo.exceptions.idProdutoDesconhecidoException;
import woo.exceptions.ProdutoIndisponivelException;
import woo.exceptions.FornecedorSemProdutoException;
import woo.exceptions.TransacaoDesconhecidaException;
import woo.exceptions.ChaveDuplicadaFornecedorException;
import woo.exceptions.FornecedorNaoAtivoException;

import java.util.Collection;


//FIXME import classes (cannot import from pt.tecnico or woo.app)

/**
 * Storefront: façade for the core classes.
 */
public class Storefront {

  /** Current filename. */
  private String _filename;
  /** The actual store. */
  private Store _store = new Store();


  
  //FIXME define other attributes
  //FIXME define constructor(s)
  //FIXME define other methods
  
  
  public String getfilename() {return _filename;}


  /**
   * @throws IOException
   * @throws FileNotFoundException
   * @throws MissingFileAssociationException
   */
  public void save() throws IOException, FileNotFoundException, MissingFileAssociationException {
    //FIXME implement serialization method
	    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_filename)));
	    out.writeObject(_store);
	    out.close();
	    
  }

  /**
   * @param filename
   * @throws MissingFileAssociationException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void saveAs(String filename) throws MissingFileAssociationException,FileNotFoundException,IOException {
	_filename = filename;
	save();
  }

  /**
   * @param filename
   * @throws UnavailableFileException
   */
  public void load(String filename) throws UnavailableFileException,FileNotFoundException,IOException,ClassNotFoundException {
    //FIXME implement serialization method
	  _filename = filename;
	  ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
	  _store = (Store) in.readObject();
	  in.close(); 
  }

  /**
   * @param textfile
   * @throws ImportFileException
   */
  public void importFile(String textfile) throws ImportFileException {  
	  try {
      _store.importFile(textfile);
    } catch (IOException | BadEntryException e) {
      throw new ImportFileException(textfile);
    }

  }
  
 public void setDataFront(int data) {_store.setData(data);}
 
 public void ChangeNameFront(String nome,String idcliente) throws  ChaveClienteNaoConhecidaException{
	 _store.ChangeName(nome,idcliente);
 }
 
 public int getDataFront() {return _store.getData();}
 public int getSaldosFront(int flag) {return _store.getSaldos(flag);}

 public void aumenta_n_tFront() {_store.aumenta_n_t(); }

 
 public Cliente getClientFront(String id) throws ChaveClienteNaoConhecidaException {return _store.getClient(id);}
 
 public Collection<Cliente> getAllClientesFront() {
	    return (_store.getAllClientes());
	  }
 
 public Collection<Fornecedor> getAllFornecedorFront() {
	    return (_store.getAllFornecedores());
	  }
 
 public void RegisterClientFront(String id, String nome, String morada) throws ChaveDuplicadaClienteException{
	 _store.RegisterClient(id,nome,morada);
 }
 
 public void RegisterFornecedorFront(String id, String nome, String morada) throws ChaveDuplicadaFornecedorException{
	 _store.RegisterFornecedor(id,nome,morada);
 }
 
 public void RegisterProductFront(String id, String idFornecedor, String Service , int preco , int valorC, String Q_Service ,String titulo, String autor , String ISBN ,String flag) throws idFornecedorDesconhecidoException, ServicoDesconhecidoException , ChaveDuplicadaPException, Q_ServicoDesconhecidoException {
	 _store.RegisterProduct(id,idFornecedor,Service,preco,valorC,titulo,autor,ISBN,Q_Service,flag);
 } 
 
 
 public int getQtdFront(String id){ return (_store.searchProduto(id)).getQtd();}
 
 public void ChangePrecoFront(String id, int preco) throws idProdutoDesconhecidoException{
	 _store.ChangePreco(id,preco);
 }
 
 
 public Collection<Produto> getAllProdutosFront(){
	 return (_store.getAllProdutos());
 }
 
 
 public void RegisterVendaFront(String idCliente, String idProduto,int datl,int qtd) throws idProdutoDesconhecidoException,ProdutoIndisponivelException,ChaveClienteNaoConhecidaException {
	 _store.RegisterVenda(idCliente,idProduto,datl,qtd);
 }
 
 
 public void RegisterEncomendaFront(String idFornecedor, String idProduto,int qtd) throws idFornecedorDesconhecidoException,idProdutoDesconhecidoException,FornecedorSemProdutoException,FornecedorNaoAtivoException{
	 _store.RegisterEncomenda(idFornecedor,idProduto,qtd);
 }
 
 public void PayFront(int idTransacao) throws TransacaoDesconhecidaException{ 
	 _store.Pay(idTransacao);
	 }
 
 public Transacao getTransactionFront(int id) throws TransacaoDesconhecidaException  {
	 return _store.getTransaction(id);
 }
 
 public String ShowTransacaoClienteFront(String idCliente) throws ChaveClienteNaoConhecidaException{
	 return _store.ShowTransacaoCliente(idCliente);
 }
 public String ShowFaturasClienteFront(String idCliente) throws ChaveClienteNaoConhecidaException{
	 return _store.ShowFaturasCliente(idCliente);
 }

 
 public String ShowTransacaoFornecedorFront(String idFornecedor) throws idFornecedorDesconhecidoException{
	 return _store.ShowTransacaoFornecedor(idFornecedor);
 }

 public int toggleTFront(String idFornecedor)  throws idFornecedorDesconhecidoException{
	 return _store.toggleT(idFornecedor);
 }
 
 public void Valor_pagarFront(int idTransacao)  {
	 _store.Valor_pagar(idTransacao);
 }
 
 public String ProcuraPUnderFront(int p) {return  _store.ProcuraPUnder(p);}
 
}
