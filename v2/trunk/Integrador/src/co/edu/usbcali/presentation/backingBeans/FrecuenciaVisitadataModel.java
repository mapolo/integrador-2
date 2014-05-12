package co.edu.usbcali.presentation.backingBeans;

 
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.FrecuenciaVisitaDTO;


  
public class FrecuenciaVisitadataModel extends ListDataModel<FrecuenciaVisitaDTO> implements SelectableDataModel<FrecuenciaVisitaDTO> {    
  
    public FrecuenciaVisitadataModel() {  
    }  
  
    public FrecuenciaVisitadataModel(List<FrecuenciaVisitaDTO> data) {  
        super(data);  
    }  
      
    @Override  
    public FrecuenciaVisitaDTO getRowData(String rowKey) {  

		@SuppressWarnings("unchecked")
		List<FrecuenciaVisitaDTO> uNegocio = (List<FrecuenciaVisitaDTO>) getWrappedData();  
          
        for(FrecuenciaVisitaDTO td : uNegocio) {          	
            if(td.getIdFrvi().toString().equals(rowKey))  
                return td;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(FrecuenciaVisitaDTO td) {  
        return td.getIdFrvi();  
    }  

}