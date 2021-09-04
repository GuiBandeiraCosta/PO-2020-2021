package woo.app.clients;
import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes
import woo.app.exceptions.UnknownClientKeyException;
import woo.exceptions.ChaveClienteNaoConhecidaException;
/**
 * Show all clients.
 */
public class ChangeClientName extends Command<Storefront> {
	private Input<String> _input;
	private Input<String> _nome;
  //FIXME add input fields

  public ChangeClientName(Storefront storefront) {
    super(Label.CHANGE, storefront);
    _input = _form.addStringInput(Message.requestClientKey());
    _nome = _form.addStringInput(Message.requestClientName());
  }

  @Override
  public void execute() throws DialogException {
	  _form.parse();
	  String _id = _input.value();
	  String nome = _nome.value();
	  try {
		  _receiver.ChangeNameFront(nome,_id);
	  } 
	  	catch(ChaveClienteNaoConhecidaException e) {
			 throw new UnknownClientKeyException(_id);
		 }
	  
	  
	  	
  }
}