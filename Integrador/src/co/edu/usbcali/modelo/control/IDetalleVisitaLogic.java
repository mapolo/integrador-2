package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.DetalleVisita;
import co.edu.usbcali.modelo.dto.DetalleVisitaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IDetalleVisitaLogic {
	public List<DetalleVisita> getDetalleVisita() throws Exception;

	/**
	 * Save an new DetalleVisita entity
	 */
	public void saveDetalleVisita(DetalleVisita entity) throws Exception;

	/**
	 * Delete an existing DetalleVisita entity
	 * 
	 */
	public void deleteDetalleVisita(DetalleVisita entity) throws Exception;

	/**
	 * Update an existing DetalleVisita entity
	 * 
	 */
	public void updateDetalleVisita(DetalleVisita entity) throws Exception;

	/**
	 * Load an existing DetalleVisita entity
	 * 
	 */
	public DetalleVisita getDetalleVisita(Long idDevi) throws Exception;

	public List<DetalleVisita> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DetalleVisita> findPageDetalleVisita(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDetalleVisita() throws Exception;

	public List<DetalleVisitaDTO> getDataDetalleVisita() throws Exception;
}
