package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Garantia;
import co.edu.usbcali.modelo.dto.GarantiaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IGarantiaLogic {
	public List<Garantia> getGarantia() throws Exception;

	/**
	 * Save an new Garantia entity
	 */
	public void saveGarantia(Garantia entity) throws Exception;

	/**
	 * Delete an existing Garantia entity
	 * 
	 */
	public void deleteGarantia(Garantia entity) throws Exception;

	/**
	 * Update an existing Garantia entity
	 * 
	 */
	public void updateGarantia(Garantia entity) throws Exception;

	/**
	 * Load an existing Garantia entity
	 * 
	 */
	public Garantia getGarantia(Long idGar) throws Exception;

	public List<Garantia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Garantia> findPageGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGarantia() throws Exception;

	public List<GarantiaDTO> getDataGarantia() throws Exception;
}
