package co.edu.usbcali.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.modelo.DescuentoComercial;

/**
 * A data access object (DAO) providing persistence and search support for
 * DescuentoComercial entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see lidis.DescuentoComercial
 */
@Scope("singleton")
@Repository("DescuentoComercialDAO")
public class DescuentoComercialDAO extends
		HibernateDaoImpl<DescuentoComercial, Long> implements
		IDescuentoComercialDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DescuentoComercialDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IDescuentoComercialDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IDescuentoComercialDAO) ctx.getBean("DescuentoComercialDAO");
	}
}
