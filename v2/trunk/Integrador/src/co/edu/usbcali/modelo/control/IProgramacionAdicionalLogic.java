package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ProgramacionAdicional;
import co.edu.usbcali.modelo.dto.ProgramacionAdicionalDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IProgramacionAdicionalLogic {
	public List<ProgramacionAdicional> getProgramacionAdicional()
			throws Exception;

	/**
	 * Save an new ProgramacionAdicional entity
	 */
	public void saveProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception;

	/**
	 * Delete an existing ProgramacionAdicional entity
	 * 
	 */
	public void deleteProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception;

	/**
	 * Update an existing ProgramacionAdicional entity
	 * 
	 */
	public void updateProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception;

	/**
	 * Load an existing ProgramacionAdicional entity
	 * 
	 */
	public ProgramacionAdicional getProgramacionAdicional(Long idPrad)
			throws Exception;

	public List<ProgramacionAdicional> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ProgramacionAdicional> findPageProgramacionAdicional(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberProgramacionAdicional() throws Exception;

	public List<ProgramacionAdicionalDTO> getDataProgramacionAdicional()
			throws Exception;
}
