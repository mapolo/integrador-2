package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.PresupuestoVentas;
import co.edu.usbcali.modelo.dto.PresupuestoVentasDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IPresupuestoVentasLogic {
	public List<PresupuestoVentas> getPresupuestoVentas() throws Exception;

	/**
	 * Save an new PresupuestoVentas entity
	 */
	public void savePresupuestoVentas(PresupuestoVentas entity)
			throws Exception;

	/**
	 * Delete an existing PresupuestoVentas entity
	 * 
	 */
	public void deletePresupuestoVentas(PresupuestoVentas entity)
			throws Exception;

	/**
	 * Update an existing PresupuestoVentas entity
	 * 
	 */
	public void updatePresupuestoVentas(PresupuestoVentas entity)
			throws Exception;

	/**
	 * Load an existing PresupuestoVentas entity
	 * 
	 */
	public PresupuestoVentas getPresupuestoVentas(Long idPven) throws Exception;

	public List<PresupuestoVentas> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<PresupuestoVentas> findPagePresupuestoVentas(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberPresupuestoVentas() throws Exception;

	public List<PresupuestoVentasDTO> getDataPresupuestoVentas()
			throws Exception;
}
