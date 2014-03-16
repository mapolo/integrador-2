package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.SolicitudCampo;
import co.edu.usbcali.modelo.dto.SolicitudCampoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ISolicitudCampoLogic {
	public List<SolicitudCampo> getSolicitudCampo() throws Exception;

	/**
	 * Save an new SolicitudCampo entity
	 */
	public void saveSolicitudCampo(SolicitudCampo entity) throws Exception;

	/**
	 * Delete an existing SolicitudCampo entity
	 * 
	 */
	public void deleteSolicitudCampo(SolicitudCampo entity) throws Exception;

	/**
	 * Update an existing SolicitudCampo entity
	 * 
	 */
	public void updateSolicitudCampo(SolicitudCampo entity) throws Exception;

	/**
	 * Load an existing SolicitudCampo entity
	 * 
	 */
	public SolicitudCampo getSolicitudCampo(Long idSoca) throws Exception;

	public List<SolicitudCampo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<SolicitudCampo> findPageSolicitudCampo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSolicitudCampo() throws Exception;

	public List<SolicitudCampoDTO> getDataSolicitudCampo() throws Exception;
}
