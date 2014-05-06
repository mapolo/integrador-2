package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Recibo;
import co.edu.usbcali.modelo.dto.ReciboDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IReciboLogic {
	public List<Recibo> getRecibo() throws Exception;

	/**
	 * Save an new Recibo entity
	 */
	public void saveRecibo(Recibo entity) throws Exception;

	/**
	 * Delete an existing Recibo entity
	 * 
	 */
	public void deleteRecibo(Recibo entity) throws Exception;

	/**
	 * Update an existing Recibo entity
	 * 
	 */
	public void updateRecibo(Recibo entity) throws Exception;

	/**
	 * Load an existing Recibo entity
	 * 
	 */
	public Recibo getRecibo(Long idRcbo) throws Exception;

	public List<Recibo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Recibo> findPageRecibo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberRecibo() throws Exception;

	public List<ReciboDTO> getDataRecibo() throws Exception;
}
