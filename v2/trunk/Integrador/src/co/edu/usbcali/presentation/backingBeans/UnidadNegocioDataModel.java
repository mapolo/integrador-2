package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.UnidadNegocioDTO;

  
public class UnidadNegocioDataModel extends ListDataModel<UnidadNegocioDTO> implements SelectableDataModel<UnidadNegocioDTO> {    
  
    public UnidadNegocioDataModel() {  
    }  
  
    public UnidadNegocioDataModel(List<UnidadNegocioDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public UnidadNegocioDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<UnidadNegocioDTO> uNegocio = (List<UnidadNegocioDTO>) getWrappedData();  
          
        for(UnidadNegocioDTO td : uNegocio) {          	
            if(td.getIdUnne().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(UnidadNegocioDTO td) {  
        return td.getIdUnne();  
    }  

}