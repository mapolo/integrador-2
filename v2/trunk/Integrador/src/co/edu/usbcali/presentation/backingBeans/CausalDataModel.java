package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.CausalDTO;


  
public class CausalDataModel extends ListDataModel<CausalDTO> implements SelectableDataModel<CausalDTO> {    
  
    public CausalDataModel() {  
    }  
  
    public CausalDataModel(List<CausalDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public CausalDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<CausalDTO> uNegocio = (List<CausalDTO>) getWrappedData();  
          
        for(CausalDTO td : uNegocio) {          	
            if(td.getIdCusa().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(CausalDTO td) {  
        return td.getIdCusa();  
    }  

}