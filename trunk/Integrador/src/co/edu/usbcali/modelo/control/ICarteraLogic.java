package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Cartera;
import co.edu.usbcali.modelo.dto.CarteraDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ICarteraLogic {
	public List<Cartera> getCartera() throws Exception;

	/**
	 * Save an new Cartera entity
	 */
	public void saveCartera(Cartera entity) throws Exception;

	/**
	 * Delete an existing Cartera entity
	 * 
	 */
	public void deleteCartera(Cartera entity) throws Exception;

	/**
	 * Update an existing Cartera entity
	 * 
	 */
	public void updateCartera(Cartera entity) throws Exception;

	/**
	 * Load an existing Cartera entity
	 * 
	 */
	public Cartera getCartera(Long idCart) throws Exception;

	public List<Cartera> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Cartera> findPageCartera(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCartera() throws Exception;

	public List<CarteraDTO> getDataCartera() throws Exception;
}
