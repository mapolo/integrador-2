package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.RutaDistribucionDTO;


  
public class RutaDistribucionDataModel extends ListDataModel<RutaDistribucionDTO> implements SelectableDataModel<RutaDistribucionDTO> {    
  
    public RutaDistribucionDataModel() {  
    }  
  
    public RutaDistribucionDataModel(List<RutaDistribucionDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public RutaDistribucionDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<RutaDistribucionDTO> uNegocio = (List<RutaDistribucionDTO>) getWrappedData();  
          
        for(RutaDistribucionDTO td : uNegocio) {          	
            if(td.getIdRudi().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(RutaDistribucionDTO td) {  
        return td.getIdRudi();  
    }  

}