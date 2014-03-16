package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.MovimientoVendedor;
import co.edu.usbcali.modelo.dto.MovimientoVendedorDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IMovimientoVendedorLogic {
	public List<MovimientoVendedor> getMovimientoVendedor() throws Exception;

	/**
	 * Save an new MovimientoVendedor entity
	 */
	public void saveMovimientoVendedor(MovimientoVendedor entity)
			throws Exception;

	/**
	 * Delete an existing MovimientoVendedor entity
	 * 
	 */
	public void deleteMovimientoVendedor(MovimientoVendedor entity)
			throws Exception;

	/**
	 * Update an existing MovimientoVendedor entity
	 * 
	 */
	public void updateMovimientoVendedor(MovimientoVendedor entity)
			throws Exception;

	/**
	 * Load an existing MovimientoVendedor entity
	 * 
	 */
	public MovimientoVendedor getMovimientoVendedor(Long idMven)
			throws Exception;

	public List<MovimientoVendedor> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<MovimientoVendedor> findPageMovimientoVendedor(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberMovimientoVendedor() throws Exception;

	public List<MovimientoVendedorDTO> getDataMovimientoVendedor()
			throws Exception;
}
