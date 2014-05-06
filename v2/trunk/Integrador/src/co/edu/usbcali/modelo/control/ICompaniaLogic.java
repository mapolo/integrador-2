package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Compania;
import co.edu.usbcali.modelo.dto.CompaniaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ICompaniaLogic {
	public List<Compania> getCompania() throws Exception;

	/**
	 * Save an new Compania entity
	 */
	public void saveCompania(Compania entity) throws Exception;

	/**
	 * Delete an existing Compania entity
	 * 
	 */
	public void deleteCompania(Compania entity) throws Exception;

	/**
	 * Update an existing Compania entity
	 * 
	 */
	public void updateCompania(Compania entity) throws Exception;

	/**
	 * Load an existing Compania entity
	 * 
	 */
	public Compania getCompania(Long idCia) throws Exception;

	public List<Compania> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Compania> findPageCompania(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCompania() throws Exception;

	public List<CompaniaDTO> getDataCompania() throws Exception;
}
