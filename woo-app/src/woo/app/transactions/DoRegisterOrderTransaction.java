package woo.app.transactions;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

import woo.exceptions.idProdutoDesconhecidoException;

import woo.exceptions.ProdutoIndisponivelException;
import woo.app.exceptions.UnavailableProductException;
import woo.app.exceptions.UnknownProductKeyException;
import woo.app.exceptions.UnknownSupplierKeyException;
import woo.exceptions.idFornecedorDesconhecidoException;
import woo.app.exceptions.WrongSupplierException;
import woo.exceptions.FornecedorSemProdutoException;
import woo.app.exceptions.UnauthorizedSupplierException;
import woo.exceptions.FornecedorNaoAtivoException;

/**
 * Register order.
 */
public class DoRegisterOrderTransaction extends Command<Storefront> {
	  private Input<String> _idFornecedor;
	  private Input<String> _idProduto;
	  private Input<Integer> _qtd;
	  private String _Fornecedor;
	  private Input<Boolean> _more;
	  private int first = 0;

	  
  //FIXME add input fields

  public DoRegisterOrderTransaction(Storefront receiver) {
    super(Label.REGISTER_ORDER_TRANSACTION, receiver);
    
    
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
    //FIXME implement command
	  
	  first = 0;
	 _idFornecedor = _form.addStringInput(Message.requestSupplierKey());
	 
	 _form.parse();
	 _Fornecedor = _idFornecedor.value();
	 _form.clear();
	   
	 	
	  while (first == 0 || _more.value() == true ) {
		  	_idProduto = _form.addStringInput(Message.requestProductKey());
		    _qtd = _form.addIntegerInput(Message.requestAmount());
		    _more = _form.addBooleanInput(Message.requestMore());
		    _form.parse();
		    first = 1;
		  
		  String idProduto = _idProduto.value();
		  int qtd = _qtd.value();
		  idProduto = _idProduto.value();
		  qtd = _qtd.value();
		  
		  try {
		  _form.clear();
		  _receiver.RegisterEncomendaFront(_Fornecedor,idProduto,qtd);
		  
		  if(_more.value()==false) break;
		  }
		  
          catch(idProdutoDesconhecidoException e) {throw new UnknownProductKeyException(idProduto);}
		  catch(idFornecedorDesconhecidoException e) {throw new UnknownSupplierKeyException(_Fornecedor);}
		  catch(FornecedorSemProdutoException e) {throw new WrongSupplierException(_Fornecedor,idProduto);}
		  catch(FornecedorNaoAtivoException e) {throw new UnauthorizedSupplierException(_Fornecedor);}
		  
		  		 
	  }
	  _receiver.aumenta_n_tFront();
	  
  	}
  	
  	
  }


