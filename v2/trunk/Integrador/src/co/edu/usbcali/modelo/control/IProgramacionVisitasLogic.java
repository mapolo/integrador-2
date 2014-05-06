package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ProgramacionVisitas;
import co.edu.usbcali.modelo.dto.ProgramacionVisitasDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IProgramacionVisitasLogic {
	public List<ProgramacionVisitas> getProgramacionVisitas() throws Exception;

	/**
	 * Save an new ProgramacionVisitas entity
	 */
	public void saveProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception;

	/**
	 * Delete an existing ProgramacionVisitas entity
	 * 
	 */
	public void deleteProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception;

	/**
	 * Update an existing ProgramacionVisitas entity
	 * 
	 */
	public void updateProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception;

	/**
	 * Load an existing ProgramacionVisitas entity
	 * 
	 */
	public ProgramacionVisitas getProgramacionVisitas(Long idPrvi)
			throws Exception;

	public List<ProgramacionVisitas> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ProgramacionVisitas> findPageProgramacionVisitas(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberProgramacionVisitas() throws Exception;

	public List<ProgramacionVisitasDTO> getDataProgramacionVisitas()
			throws Exception;
}
