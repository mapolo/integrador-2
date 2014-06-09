package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;


import co.edu.usbcali.modelo.dto.VendedorDTO;
  
public class VendedorDataModel extends ListDataModel<VendedorDTO> implements SelectableDataModel<VendedorDTO> {    
  
    public VendedorDataModel() {  
    }  
  
    public VendedorDataModel(List<VendedorDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public VendedorDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<VendedorDTO> vendedor = (List<VendedorDTO>) getWrappedData();  
          
        for(VendedorDTO td : vendedor) {          	
            if(td.getIdVend().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(VendedorDTO td) {  
        return td.getIdVend();  
    }  

}