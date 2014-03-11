package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.SolicitudCambio;
import co.edu.usbcali.modelo.dto.SolicitudCambioDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ISolicitudCambioLogic {
	public List<SolicitudCambio> getSolicitudCambio() throws Exception;

	/**
	 * Save an new SolicitudCambio entity
	 */
	public void saveSolicitudCambio(SolicitudCambio entity) throws Exception;

	/**
	 * Delete an existing SolicitudCambio entity
	 * 
	 */
	public void deleteSolicitudCambio(SolicitudCambio entity) throws Exception;

	/**
	 * Update an existing SolicitudCambio entity
	 * 
	 */
	public void updateSolicitudCambio(SolicitudCambio entity) throws Exception;

	/**
	 * Load an existing SolicitudCambio entity
	 * 
	 */
	public SolicitudCambio getSolicitudCambio(Long idSocb) throws Exception;

	public List<SolicitudCambio> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<SolicitudCambio> findPageSolicitudCambio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSolicitudCambio() throws Exception;

	public List<SolicitudCambioDTO> getDataSolicitudCambio() throws Exception;
}
