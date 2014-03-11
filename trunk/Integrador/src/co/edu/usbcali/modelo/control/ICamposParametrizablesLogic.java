package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.CamposParametrizables;
import co.edu.usbcali.modelo.dto.CamposParametrizablesDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ICamposParametrizablesLogic {
	public List<CamposParametrizables> getCamposParametrizables()
			throws Exception;

	/**
	 * Save an new CamposParametrizables entity
	 */
	public void saveCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	/**
	 * Delete an existing CamposParametrizables entity
	 * 
	 */
	public void deleteCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	/**
	 * Update an existing CamposParametrizables entity
	 * 
	 */
	public void updateCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	/**
	 * Load an existing CamposParametrizables entity
	 * 
	 */
	public CamposParametrizables getCamposParametrizables(Long idCapa)
			throws Exception;

	public List<CamposParametrizables> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<CamposParametrizables> findPageCamposParametrizables(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCamposParametrizables() throws Exception;

	public List<CamposParametrizablesDTO> getDataCamposParametrizables()
			throws Exception;
}
