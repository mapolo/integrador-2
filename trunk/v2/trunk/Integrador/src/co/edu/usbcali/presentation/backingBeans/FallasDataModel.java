package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.FallasDTO;


  
public class FallasDataModel extends ListDataModel<FallasDTO> implements SelectableDataModel<FallasDTO> {    
  
    public FallasDataModel() {  
    }  
  
    public FallasDataModel(List<FallasDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public FallasDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<FallasDTO> uNegocio = (List<FallasDTO>) getWrappedData();  
          
        for(FallasDTO td : uNegocio) {          	
            if(td.getIdCfal().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(FallasDTO td) {  
        return td.getIdCfal();  
    }  

}