package woo.app.products;

import pt.tecnico.po.ui.Command;       
import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.exceptions.idFornecedorDesconhecidoException;
import woo.app.exceptions.UnknownSupplierKeyException;
import woo.exceptions.ServicoDesconhecidoException;
import woo.app.exceptions.UnknownServiceTypeException;
import woo.exceptions.Q_ServicoDesconhecidoException;
import woo.app.exceptions.UnknownServiceLevelException;
import woo.exceptions.ChaveDuplicadaPException;
import woo.app.exceptions.DuplicateProductKeyException;
import woo.app.exceptions.DuplicateProductKeyException;
/**
 * Register box.
 */
public class DoRegisterProductBox extends Command<Storefront> {
	private Input<Integer> _preco;
	private Input<Integer> _valorCritico;
	private Input<String> _id;
	private Input<String> _idFornecedor;
	private Input<String> _ServiceType;
  //FIXME add input fields

  public DoRegisterProductBox(Storefront receiver) {
    super(Label.REGISTER_BOX, receiver);
    _id = _form.addStringInput(Message.requestProductKey());
    _preco = _form.addIntegerInput(Message.requestPrice());
    _valorCritico = _form.addIntegerInput(Message.requestStockCriticalValue());
    _idFornecedor = _form.addStringInput(Message.requestSupplierKey());
    _ServiceType = _form.addStringInput(Message.requestServiceType());
    //FIXME init input fields
  }

  @Override
  public final void execute() throws DialogException {
    //FIXME implement command
	  	_form.parse();
		String id = _id.value();
		String idFornecedor = _idFornecedor.value();
		String Service = _ServiceType.value();
		int preco = _preco.value();
		int valorC = _valorCritico.value();
		try {
		_receiver.RegisterProductFront(id,idFornecedor,Service,preco,valorC,"","","","","BOX");
		}
		catch(idFornecedorDesconhecidoException e) { throw new UnknownSupplierKeyException(idFornecedor);}
		catch(ServicoDesconhecidoException e){ throw new UnknownServiceTypeException(Service); }
		catch(Q_ServicoDesconhecidoException e) { throw new UnknownServiceLevelException("");}
		catch(ChaveDuplicadaPException e) { throw new DuplicateProductKeyException(id);}
		
		
  		
		
  }
}
