package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.SaldoInicialInventarioDTO;


  
public class SaldoInicialInventarioDataModel extends ListDataModel<SaldoInicialInventarioDTO> implements SelectableDataModel<SaldoInicialInventarioDTO> {    
  
    public SaldoInicialInventarioDataModel() {  
    }  
  
    public SaldoInicialInventarioDataModel(List<SaldoInicialInventarioDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public SaldoInicialInventarioDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<SaldoInicialInventarioDTO> uNegocio = (List<SaldoInicialInventarioDTO>) getWrappedData();  
          
        for(SaldoInicialInventarioDTO td : uNegocio) {          	
            if(td.getIdSini().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(SaldoInicialInventarioDTO td) {  
        return td.getIdSini();  
    }  

}