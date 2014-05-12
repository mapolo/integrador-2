package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.ClaveFabricacionDTO;



  
public class ClaveFabricacionDataModelo extends ListDataModel<ClaveFabricacionDTO> implements SelectableDataModel<ClaveFabricacionDTO> {    
  
    public ClaveFabricacionDataModelo() {  
    }  
  
    public ClaveFabricacionDataModelo(List<ClaveFabricacionDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public ClaveFabricacionDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<ClaveFabricacionDTO> uNegocio = (List<ClaveFabricacionDTO>) getWrappedData();  
          
        for(ClaveFabricacionDTO td : uNegocio) {          	
            if(td.getIdClfa().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(ClaveFabricacionDTO td) {  
        return td.getIdClfa();  
    }  

}