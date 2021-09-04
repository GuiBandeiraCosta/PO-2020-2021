package woo.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import woo.exceptions.MissingFileAssociationException;
import pt.tecnico.po.ui.Command;                                                                                                              import pt.tecnico.po.ui.DialogException;                                                                                                      import pt.tecnico.po.ui.Input;                                                                                                                import woo.Storefront;                                                                                                                        //FIXME import other classes

/**
 * Save current state to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<Storefront> {
	private Input<String> _inputfile;
	private String _saved;
  //FIXME add input fields

  /** @param receiver */
  public DoSave(Storefront receiver) {
    super(Label.SAVE, receiver);
    //FIXME init input fields
  }
  
  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {  
	  
	  _saved = _receiver.getfilename();
	  
	  if (_saved == null) {
	    	_inputfile = _form.addStringInput(Message.newSaveAs());
	    }
	  
	  try {
			if ( _saved == null) {
				_form.parse();
				_receiver.saveAs(_inputfile.value());
			 
			}
			else { _receiver.save();}
			_form.clear(); 
		 }
	  	
	    catch (FileNotFoundException ufe) {
	    	 ufe.printStackTrace();
	      }
	    catch (IOException ufe) {
	    	ufe.printStackTrace();
	      }
	    catch (MissingFileAssociationException ufe) {
	    	ufe.printStackTrace();
	      }
  }
}
