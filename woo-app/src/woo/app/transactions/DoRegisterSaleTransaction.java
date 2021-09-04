package woo.app.transactions;

import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes



import woo.exceptions.ChaveClienteNaoConhecidaException;
import woo.app.exceptions.UnknownClientKeyException;
import woo.exceptions.ProdutoIndisponivelException;
import woo.app.exceptions.UnavailableProductException;
import woo.app.exceptions.UnknownProductKeyException;
import woo.exceptions.idProdutoDesconhecidoException;
/**
 * Register sale.
 */
public class DoRegisterSaleTransaction extends Command<Storefront> {
	  private Input<String> _idCliente;
	  private Input<String> _idProduto;
	  private Input<Integer> _data_limite;
	  private Input<Integer> _qtd;

  //FIXME add input fields

  public DoRegisterSaleTransaction(Storefront receiver) {
    super(Label.REGISTER_SALE_TRANSACTION, receiver);
    _idCliente = _form.addStringInput(Message.requestClientKey());
    _data_limite = _form.addIntegerInput(Message.requestPaymentDeadline());
    _idProduto = _form.addStringInput(Message.requestProductKey());    
    _qtd = _form.addIntegerInput(Message.requestAmount());
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
    //FIXME implement command
	  	 _form.parse();

		 String idCliente = _idCliente.value();
		 String idProduto = _idProduto.value();
		 int datal = _data_limite.value();
		 int qtd = _qtd.value();
		 
		 try {
		 _receiver.RegisterVendaFront(idCliente,idProduto,datal,qtd);
		 
		 }

		 catch(ChaveClienteNaoConhecidaException e) { throw new UnknownClientKeyException(idCliente);}
		 catch(idProdutoDesconhecidoException e) {throw new UnknownProductKeyException(idProduto);}
		 catch(ProdutoIndisponivelException e) {throw new UnavailableProductException(idProduto,qtd,_receiver.getQtdFront(idProduto));}
			 
		 }
  	
  }


