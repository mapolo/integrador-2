package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Tabla;
import co.edu.usbcali.modelo.dto.TablaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITablaLogic {
	public List<Tabla> getTabla() throws Exception;

	/**
	 * Save an new Tabla entity
	 */
	public void saveTabla(Tabla entity) throws Exception;

	/**
	 * Delete an existing Tabla entity
	 * 
	 */
	public void deleteTabla(Tabla entity) throws Exception;

	/**
	 * Update an existing Tabla entity
	 * 
	 */
	public void updateTabla(Tabla entity) throws Exception;

	/**
	 * Load an existing Tabla entity
	 * 
	 */
	public Tabla getTabla(Long idTabl) throws Exception;

	public List<Tabla> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Tabla> findPageTabla(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTabla() throws Exception;

	public List<TablaDTO> getDataTabla() throws Exception;
}
