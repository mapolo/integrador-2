package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ConceptoRecibo;
import co.edu.usbcali.modelo.dto.ConceptoReciboDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IConceptoReciboLogic {
	public List<ConceptoRecibo> getConceptoRecibo() throws Exception;

	/**
	 * Save an new ConceptoRecibo entity
	 */
	public void saveConceptoRecibo(ConceptoRecibo entity) throws Exception;

	/**
	 * Delete an existing ConceptoRecibo entity
	 * 
	 */
	public void deleteConceptoRecibo(ConceptoRecibo entity) throws Exception;

	/**
	 * Update an existing ConceptoRecibo entity
	 * 
	 */
	public void updateConceptoRecibo(ConceptoRecibo entity) throws Exception;

	/**
	 * Load an existing ConceptoRecibo entity
	 * 
	 */
	public ConceptoRecibo getConceptoRecibo(Long idCpto) throws Exception;

	public List<ConceptoRecibo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ConceptoRecibo> findPageConceptoRecibo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberConceptoRecibo() throws Exception;

	public List<ConceptoReciboDTO> getDataConceptoRecibo() throws Exception;
}
