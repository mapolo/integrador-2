package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Bateriologo;
import co.edu.usbcali.modelo.dto.BateriologoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IBateriologoLogic {
	public List<Bateriologo> getBateriologo() throws Exception;

	/**
	 * Save an new Bateriologo entity
	 */
	public void saveBateriologo(Bateriologo entity) throws Exception;

	/**
	 * Delete an existing Bateriologo entity
	 * 
	 */
	public void deleteBateriologo(Bateriologo entity) throws Exception;

	/**
	 * Update an existing Bateriologo entity
	 * 
	 */
	public void updateBateriologo(Bateriologo entity) throws Exception;

	/**
	 * Load an existing Bateriologo entity
	 * 
	 */
	public Bateriologo getBateriologo(Long idBate) throws Exception;

	public List<Bateriologo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Bateriologo> findPageBateriologo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberBateriologo() throws Exception;

	public List<BateriologoDTO> getDataBateriologo() throws Exception;
}
