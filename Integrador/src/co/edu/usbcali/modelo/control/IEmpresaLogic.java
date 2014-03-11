package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.dto.EmpresaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IEmpresaLogic {
	public List<Empresa> getEmpresa() throws Exception;

	/**
	 * Save an new Empresa entity
	 */
	public void saveEmpresa(Empresa entity) throws Exception;

	/**
	 * Delete an existing Empresa entity
	 * 
	 */
	public void deleteEmpresa(Empresa entity) throws Exception;

	/**
	 * Update an existing Empresa entity
	 * 
	 */
	public void updateEmpresa(Empresa entity) throws Exception;

	/**
	 * Load an existing Empresa entity
	 * 
	 */
	public Empresa getEmpresa(Long idEmpr) throws Exception;

	public List<Empresa> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Empresa> findPageEmpresa(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEmpresa() throws Exception;

	public List<EmpresaDTO> getDataEmpresa() throws Exception;
}
