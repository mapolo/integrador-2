package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.TipoContacto;
import co.edu.usbcali.modelo.dto.TipoContactoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoContactoLogic {
	public List<TipoContacto> getTipoContacto() throws Exception;

	/**
	 * Save an new TipoContacto entity
	 */
	public void saveTipoContacto(TipoContacto entity) throws Exception;

	/**
	 * Delete an existing TipoContacto entity
	 * 
	 */
	public void deleteTipoContacto(TipoContacto entity) throws Exception;

	/**
	 * Update an existing TipoContacto entity
	 * 
	 */
	public void updateTipoContacto(TipoContacto entity) throws Exception;

	/**
	 * Load an existing TipoContacto entity
	 * 
	 */
	public TipoContacto getTipoContacto(Long idTico) throws Exception;

	public List<TipoContacto> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoContacto> findPageTipoContacto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoContacto() throws Exception;

	public List<TipoContactoDTO> getDataTipoContacto() throws Exception;
}
