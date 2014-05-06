package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.AtencionVendedor;
import co.edu.usbcali.modelo.dto.AtencionVendedorDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IAtencionVendedorLogic {
	public List<AtencionVendedor> getAtencionVendedor() throws Exception;

	/**
	 * Save an new AtencionVendedor entity
	 */
	public void saveAtencionVendedor(AtencionVendedor entity) throws Exception;

	/**
	 * Delete an existing AtencionVendedor entity
	 * 
	 */
	public void deleteAtencionVendedor(AtencionVendedor entity)
			throws Exception;

	/**
	 * Update an existing AtencionVendedor entity
	 * 
	 */
	public void updateAtencionVendedor(AtencionVendedor entity)
			throws Exception;

	/**
	 * Load an existing AtencionVendedor entity
	 * 
	 */
	public AtencionVendedor getAtencionVendedor(Long idAtve) throws Exception;

	public List<AtencionVendedor> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<AtencionVendedor> findPageAtencionVendedor(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAtencionVendedor() throws Exception;

	public List<AtencionVendedorDTO> getDataAtencionVendedor() throws Exception;
}
