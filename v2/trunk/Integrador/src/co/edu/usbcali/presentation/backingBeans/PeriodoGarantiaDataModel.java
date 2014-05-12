package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.PeriodoGarantiaDTO;


  
public class PeriodoGarantiaDataModel extends ListDataModel<PeriodoGarantiaDTO> implements SelectableDataModel<PeriodoGarantiaDTO> {    
  
    public PeriodoGarantiaDataModel() {  
    }  
  
    public PeriodoGarantiaDataModel(List<PeriodoGarantiaDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public PeriodoGarantiaDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<PeriodoGarantiaDTO> uNegocio = (List<PeriodoGarantiaDTO>) getWrappedData();  
          
        for(PeriodoGarantiaDTO td : uNegocio) {          	
            if(td.getIdPega().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(PeriodoGarantiaDTO td) {  
        return td.getIdPega();  
    }  

}