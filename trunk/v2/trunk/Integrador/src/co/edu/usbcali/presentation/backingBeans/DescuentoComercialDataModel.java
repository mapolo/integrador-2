package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.DescuentoComercialDTO;


  
public class DescuentoComercialDataModel extends ListDataModel<DescuentoComercialDTO> implements SelectableDataModel<DescuentoComercialDTO> {    
  
    public DescuentoComercialDataModel() {  
    }  
  
    public DescuentoComercialDataModel(List<DescuentoComercialDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public DescuentoComercialDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<DescuentoComercialDTO> uNegocio = (List<DescuentoComercialDTO>) getWrappedData();  
          
        for(DescuentoComercialDTO td : uNegocio) {          	
            if(td.getIdDeco().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(DescuentoComercialDTO td) {  
        return td.getIdDeco();  
    }  

}