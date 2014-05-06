package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Grupo;
import co.edu.usbcali.modelo.dto.GrupoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IGrupoLogic {
	public List<Grupo> getGrupo() throws Exception;

	/**
	 * Save an new Grupo entity
	 */
	public void saveGrupo(Grupo entity) throws Exception;

	/**
	 * Delete an existing Grupo entity
	 * 
	 */
	public void deleteGrupo(Grupo entity) throws Exception;

	/**
	 * Update an existing Grupo entity
	 * 
	 */
	public void updateGrupo(Grupo entity) throws Exception;

	/**
	 * Load an existing Grupo entity
	 * 
	 */
	public Grupo getGrupo(Long idGrpo) throws Exception;

	public List<Grupo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Grupo> findPageGrupo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrupo() throws Exception;

	public List<GrupoDTO> getDataGrupo() throws Exception;
}
