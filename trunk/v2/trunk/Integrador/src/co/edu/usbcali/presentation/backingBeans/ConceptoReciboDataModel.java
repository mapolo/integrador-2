package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.ConceptoReciboDTO;

  
public class ConceptoReciboDataModel extends ListDataModel<ConceptoReciboDTO> implements SelectableDataModel<ConceptoReciboDTO> {    
  
    public ConceptoReciboDataModel() {  
    }  
  
    public ConceptoReciboDataModel(List<ConceptoReciboDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public ConceptoReciboDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<ConceptoReciboDTO> uNegocio = (List<ConceptoReciboDTO>) getWrappedData();  
          
        for(ConceptoReciboDTO td : uNegocio) {          	
            if(td.getIdCpto().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(ConceptoReciboDTO td) {  
        return td.getIdCpto();  
    }  

}