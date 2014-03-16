package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.PresupuestoCartera;
import co.edu.usbcali.modelo.dto.PresupuestoCarteraDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IPresupuestoCarteraLogic {
	public List<PresupuestoCartera> getPresupuestoCartera() throws Exception;

	/**
	 * Save an new PresupuestoCartera entity
	 */
	public void savePresupuestoCartera(PresupuestoCartera entity)
			throws Exception;

	/**
	 * Delete an existing PresupuestoCartera entity
	 * 
	 */
	public void deletePresupuestoCartera(PresupuestoCartera entity)
			throws Exception;

	/**
	 * Update an existing PresupuestoCartera entity
	 * 
	 */
	public void updatePresupuestoCartera(PresupuestoCartera entity)
			throws Exception;

	/**
	 * Load an existing PresupuestoCartera entity
	 * 
	 */
	public PresupuestoCartera getPresupuestoCartera(Long idPrca)
			throws Exception;

	public List<PresupuestoCartera> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<PresupuestoCartera> findPagePresupuestoCartera(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberPresupuestoCartera() throws Exception;

	public List<PresupuestoCarteraDTO> getDataPresupuestoCartera()
			throws Exception;
}
