package co.edu.usbcali.dataaccess.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.dataaccess.api.HibernateDaoImpl;
import co.edu.usbcali.modelo.CamposParametrizables;

/**
 * A data access object (DAO) providing persistence and search support for
 * CamposParametrizables entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see lidis.CamposParametrizables
 */
@Scope("singleton")
@Repository("CamposParametrizablesDAO")
public class CamposParametrizablesDAO extends
		HibernateDaoImpl<CamposParametrizables, Long> implements
		ICamposParametrizablesDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CamposParametrizablesDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static ICamposParametrizablesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ICamposParametrizablesDAO) ctx
				.getBean("CamposParametrizablesDAO");
	}
}
