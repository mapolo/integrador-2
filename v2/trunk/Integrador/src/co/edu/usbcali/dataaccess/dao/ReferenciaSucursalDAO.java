package co.edu.usbcali.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.modelo.ReferenciaSucursal;

/**
 * A data access object (DAO) providing persistence and search support for
 * ReferenciaSucursal entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see lidis.ReferenciaSucursal
 */
@Scope("singleton")
@Repository("ReferenciaSucursalDAO")
public class ReferenciaSucursalDAO extends
		HibernateDaoImpl<ReferenciaSucursal, Long> implements
		IReferenciaSucursalDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ReferenciaSucursalDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IReferenciaSucursalDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IReferenciaSucursalDAO) ctx.getBean("ReferenciaSucursalDAO");
	}
}
