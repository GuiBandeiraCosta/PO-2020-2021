package woo.app.products;

import pt.tecnico.po.ui.Command;    
import woo.exceptions.idFornecedorDesconhecidoException;
import woo.app.exceptions.UnknownSupplierKeyException;
import woo.exceptions.ServicoDesconhecidoException;
import woo.app.exceptions.UnknownServiceTypeException;
import woo.exceptions.Q_ServicoDesconhecidoException;
import woo.app.exceptions.UnknownServiceLevelException;
import pt.tecnico.po.ui.DialogException;        
import woo.exceptions.ChaveDuplicadaPException;
import pt.tecnico.po.ui.Input;                       
import woo.app.exceptions.DuplicateProductKeyException;
import woo.Storefront;                                                                                                                        //FIXME import other classes

/**
 * Register book.
 */
public class DoRegisterProductBook extends Command<Storefront> {
	private Input<Integer> _preco;
	private Input<Integer> _valorCritico;
	private Input<String> _id;
	private Input<String> _idFornecedor;
	private Input<String> _ServiceType;
	private Input<String> _Q_Service;
	private Input<String> _titulo;
	private Input<String> _ISBN;
	private Input<String> _autor;
  //FIXME add input fields

  public DoRegisterProductBook(Storefront receiver) {
    super(Label.REGISTER_BOOK, receiver);
    _id = _form.addStringInput(Message.requestProductKey());
    _titulo = _form.addStringInput(Message.requestBookTitle());
    _autor = _form.addStringInput(Message.requestBookAuthor());
    _ISBN = _form.addStringInput(Message.requestISBN());
    
    
    _preco = _form.addIntegerInput(Message.requestPrice());
    _valorCritico = _form.addIntegerInput(Message.requestStockCriticalValue());
    _idFornecedor = _form.addStringInput(Message.requestSupplierKey());
    
    
    
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
    //FIXME implement command
	  _form.parse();
		String id = _id.value();
		String idFornecedor = _idFornecedor.value();
		
		String titulo = _titulo.value();
		String autor = _autor.value();
		String ISBN = _ISBN.value();
		int preco = _preco.value();
		int valorC = _valorCritico.value();
		 
		try {
		_receiver.RegisterProductFront(id,idFornecedor,"",preco,valorC,"",titulo,autor,ISBN,"BOOK");
		}
		catch(idFornecedorDesconhecidoException e) { throw new UnknownSupplierKeyException(idFornecedor);}
		catch(ServicoDesconhecidoException e){ throw new UnknownServiceTypeException(""); }
		catch(Q_ServicoDesconhecidoException e) { throw new UnknownServiceLevelException("");}
		catch(ChaveDuplicadaPException e) { throw new DuplicateProductKeyException(id);}
  }
}
