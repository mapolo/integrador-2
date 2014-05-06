package co.edu.usbcali.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.modelo.OrdenesDeCompra;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrdenesDeCompra entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see lidis.OrdenesDeCompra
 */
@Scope("singleton")
@Repository("OrdenesDeCompraDAO")
public class OrdenesDeCompraDAO extends HibernateDaoImpl<OrdenesDeCompra, Long>
		implements IOrdenesDeCompraDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrdenesDeCompraDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IOrdenesDeCompraDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IOrdenesDeCompraDAO) ctx.getBean("OrdenesDeCompraDAO");
	}
}
