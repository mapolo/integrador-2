package co.edu.usbcali.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.modelo.DescuentoFinanciero;

/**
 * A data access object (DAO) providing persistence and search support for
 * DescuentoFinanciero entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see lidis.DescuentoFinanciero
 */
@Scope("singleton")
@Repository("DescuentoFinancieroDAO")
public class DescuentoFinancieroDAO extends
		HibernateDaoImpl<DescuentoFinanciero, Long> implements
		IDescuentoFinancieroDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DescuentoFinancieroDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IDescuentoFinancieroDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IDescuentoFinancieroDAO) ctx.getBean("DescuentoFinancieroDAO");
	}
}
