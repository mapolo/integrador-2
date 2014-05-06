package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.EmpresaDTO;


  
public class EmpresaDataModel extends ListDataModel<EmpresaDTO> implements SelectableDataModel<EmpresaDTO> {    
  
    public EmpresaDataModel() {  
    }  
  
    public EmpresaDataModel(List<EmpresaDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public EmpresaDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<EmpresaDTO> uNegocio = (List<EmpresaDTO>) getWrappedData();  
          
        for(EmpresaDTO td : uNegocio) {          	
            if(td.getIdEmpr().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(EmpresaDTO td) {  
        return td.getIdEmpr();  
    }  

}