package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Cliente;
import co.edu.usbcali.modelo.dto.ClienteDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IClienteLogic {
	public List<Cliente> getCliente() throws Exception;

	/**
	 * Save an new Cliente entity
	 */
	public void saveCliente(Cliente entity) throws Exception;

	/**
	 * Delete an existing Cliente entity
	 * 
	 */
	public void deleteCliente(Cliente entity) throws Exception;

	/**
	 * Update an existing Cliente entity
	 * 
	 */
	public void updateCliente(Cliente entity) throws Exception;

	/**
	 * Load an existing Cliente entity
	 * 
	 */
	public Cliente getCliente(Long idClie) throws Exception;

	public List<Cliente> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Cliente> findPageCliente(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCliente() throws Exception;

	public List<ClienteDTO> getDataCliente() throws Exception;
}
