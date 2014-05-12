package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.RelacionComercialDTO;


  
public class RelacionComercialDataModel extends ListDataModel<RelacionComercialDTO> implements SelectableDataModel<RelacionComercialDTO> {    
  
    public RelacionComercialDataModel() {  
    }  
  
    public RelacionComercialDataModel(List<RelacionComercialDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public RelacionComercialDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<RelacionComercialDTO> uNegocio = (List<RelacionComercialDTO>) getWrappedData();  
          
        for(RelacionComercialDTO td : uNegocio) {          	
            if(td.getIdReco().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(RelacionComercialDTO td) {  
        return td.getIdReco();  
    }  

}