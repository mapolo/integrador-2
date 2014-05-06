package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.PersonaDTO;


  
public class PersonaDataModel extends ListDataModel<PersonaDTO> implements SelectableDataModel<PersonaDTO> {    
  
    public PersonaDataModel() {  
    }  
  
    public PersonaDataModel(List<PersonaDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public PersonaDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<PersonaDTO> uNegocio = (List<PersonaDTO>) getWrappedData();  
          
        for(PersonaDTO td : uNegocio) {          	
            if(td.getIdPers().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(PersonaDTO td) {  
        return td.getIdPers();  
    }  

}