package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.BateriologoDTO;



  
public class BateriologoDataModel extends ListDataModel<BateriologoDTO> implements SelectableDataModel<BateriologoDTO> {    
  
    public BateriologoDataModel() {  
    }  
  
    public BateriologoDataModel(List<BateriologoDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public BateriologoDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<BateriologoDTO> uNegocio = (List<BateriologoDTO>) getWrappedData();  
          
        for(BateriologoDTO td : uNegocio) {          	
            if(td.getIdBate().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(BateriologoDTO td) {  
        return td.getIdBate();  
    }  

}