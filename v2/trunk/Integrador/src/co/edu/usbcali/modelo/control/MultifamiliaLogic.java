package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.MultifamiliaDTO;
import co.edu.usbcali.utilities.Utilities;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
@Scope("singleton")
@Service("MultifamiliaLogic")
public class MultifamiliaLogic implements IMultifamiliaLogic {
    /**
     * DAO injected by Spring that manages Multifamilia entities
     *
     */
    @Autowired
    private IMultifamiliaDAO multifamiliaDAO;

    /**
    * Logic injected by Spring that manages Cliente entities
    *
    */
    @Autowired
    IClienteLogic logicCliente1;

    /**
    * Logic injected by Spring that manages Cliente entities
    *
    */
    @Autowired
    IClienteLogic logicCliente2;

    /**
    * Logic injected by Spring that manages Sucursal entities
    *
    */
    @Autowired
    ISucursalLogic logicSucursal3;

    @Transactional(readOnly = true)
    public List<Multifamilia> getMultifamilia() throws Exception {
        List<Multifamilia> list = new ArrayList<Multifamilia>();

        try {
            list = multifamiliaDAO.findAll();
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Multifamilia");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveMultifamilia(Multifamilia entity) throws Exception {
        try {
            if (entity.getClienteByClienteHijo() == null) {
                throw new ZMessManager().new ForeignException(
                    "clienteByClienteHijo");
            }

            if (entity.getClienteByClientePadre() == null) {
                throw new ZMessManager().new ForeignException(
                    "clienteByClientePadre");
            }

//            if (entity.getSucursal() == null) {
//                throw new ZMessManager().new ForeignException("sucursal");
//            }

            if (entity.getEstadoRegistro() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "estadoRegistro");
            }

            if ((entity.getEstadoRegistro() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEstadoRegistro(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "estadoRegistro");
            }

            if (entity.getFechaCreacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaCreacion");
            }

            if (entity.getFechaModificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaModificacion");
            }

//            if (entity.getIdMufa() == null) {
//                throw new ZMessManager().new EmptyFieldException("idMufa");
//            }

//            if ((entity.getIdMufa() != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        entity.getIdMufa(), 10, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException("idMufa");
//            }

            if (entity.getOperCreador() == null) {
                throw new ZMessManager().new EmptyFieldException("operCreador");
            }

            if ((entity.getOperCreador() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOperCreador(), 10) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "operCreador");
            }

            if (entity.getOperModifica() == null) {
                throw new ZMessManager().new EmptyFieldException("operModifica");
            }

            if ((entity.getOperModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOperModifica(), 10) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "operModifica");
            }

//            if (entity.getCliente().getIdClie() == null) {
//                throw new ZMessManager().new EmptyFieldException(
//                    "idClie_Cliente");
//            }
//
//            if ((entity.getCliente().getIdClie() != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        entity.getCliente().getIdClie(), 10, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idClie_Cliente");
//            }
//
//            if (entity.getCliente().getIdClie() == null) {
//                throw new ZMessManager().new EmptyFieldException(
//                    "idClie_Cliente");
//            }
//
//            if ((entity.getCliente().getIdClie() != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        entity.getCliente().getIdClie(), 10, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idClie_Cliente");
//            }

//            if (entity.getSucursal().getIdSucu() == null) {
//                throw new ZMessManager().new EmptyFieldException(
//                    "idSucu_Sucursal");
//            }
//
//            if ((entity.getSucursal().getIdSucu() != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        entity.getSucursal().getIdSucu(), 10, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idSucu_Sucursal");
//            }

//            if (getMultifamilia(entity.getIdMufa()) != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }

            multifamiliaDAO.save(entity);
        } catch (Exception e) {
        	e.printStackTrace();
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteMultifamilia(Multifamilia entity)
        throws Exception {
        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Multifamilia");
        }

        if (entity.getIdMufa() == null) {
            throw new ZMessManager().new EmptyFieldException("idMufa");
        }

        try {
            multifamiliaDAO.delete(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateMultifamilia(Multifamilia entity)
        throws Exception {
        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Multifamilia");
            }

            if (entity.getClienteByClienteHijo() == null) {
                throw new ZMessManager().new ForeignException(
                    "clienteByClienteHijo");
            }

            if (entity.getClienteByClientePadre() == null) {
                throw new ZMessManager().new ForeignException(
                    "clienteByClientePadre");
            }

            if (entity.getSucursal() == null) {
                throw new ZMessManager().new ForeignException("sucursal");
            }

            if (entity.getEstadoRegistro() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "estadoRegistro");
            }

            if ((entity.getEstadoRegistro() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEstadoRegistro(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "estadoRegistro");
            }

            if (entity.getFechaCreacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaCreacion");
            }

            if (entity.getFechaModificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaModificacion");
            }

            if (entity.getIdMufa() == null) {
                throw new ZMessManager().new EmptyFieldException("idMufa");
            }

            if ((entity.getIdMufa() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getIdMufa(), 10, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("idMufa");
            }

            if (entity.getOperCreador() == null) {
                throw new ZMessManager().new EmptyFieldException("operCreador");
            }

            if ((entity.getOperCreador() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOperCreador(), 10) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "operCreador");
            }

            if (entity.getOperModifica() == null) {
                throw new ZMessManager().new EmptyFieldException("operModifica");
            }

            if ((entity.getOperModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOperModifica(), 10) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "operModifica");
            }

//            if (entity.getCliente().getIdClie() == null) {
//                throw new ZMessManager().new EmptyFieldException(
//                    "idClie_Cliente");
//            }

//            if ((entity.getCliente().getIdClie() != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        entity.getCliente().getIdClie(), 10, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idClie_Cliente");
//            }
//
//            if (entity.getCliente().getIdClie() == null) {
//                throw new ZMessManager().new EmptyFieldException(
//                    "idClie_Cliente");
//            }
//
//            if ((entity.getCliente().getIdClie() != null) &&
//                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
//                        entity.getCliente().getIdClie(), 10, 0) == false)) {
//                throw new ZMessManager().new NotValidFormatException(
//                    "idClie_Cliente");
//            }

            if (entity.getSucursal().getIdSucu() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idSucu_Sucursal");
            }

            if ((entity.getSucursal().getIdSucu() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getSucursal().getIdSucu(), 10, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idSucu_Sucursal");
            }

            multifamiliaDAO.update(entity);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<MultifamiliaDTO> getDataMultifamilia()
        throws Exception {
        try {
            List<Multifamilia> multifamilia = multifamiliaDAO.findAll();

            List<MultifamiliaDTO> multifamiliaDTO = new ArrayList<MultifamiliaDTO>();

            for (Multifamilia multifamiliaTmp : multifamilia) {
                MultifamiliaDTO multifamiliaDTO2 = new MultifamiliaDTO();

                multifamiliaDTO2.setIdMufa(multifamiliaTmp.getIdMufa());
                multifamiliaDTO2.setEstadoRegistro((multifamiliaTmp.getEstadoRegistro() != null)
                    ? multifamiliaTmp.getEstadoRegistro() : null);
                multifamiliaDTO2.setFechaCreacion(multifamiliaTmp.getFechaCreacion());
                multifamiliaDTO2.setFechaModificacion(multifamiliaTmp.getFechaModificacion());
                multifamiliaDTO2.setOperCreador((multifamiliaTmp.getOperCreador() != null)
                    ? multifamiliaTmp.getOperCreador() : null);
                multifamiliaDTO2.setOperModifica((multifamiliaTmp.getOperModifica() != null)
                    ? multifamiliaTmp.getOperModifica() : null);
//                multifamiliaDTO2.setIdClie_Cliente((multifamiliaTmp.getCliente()
//                                                                   .getIdClie() != null)
//                    ? multifamiliaTmp.getCliente().getIdClie() : null);

                if (multifamiliaTmp.getSucursal() != null) {
                    multifamiliaDTO2.setIdSucu_Sucursal(multifamiliaTmp.getSucursal()
                                                                       .getIdSucu());
                } else {
                    multifamiliaDTO2.setIdSucu_Sucursal(null);
                }

                multifamiliaDTO.add(multifamiliaDTO2);
            }

            return multifamiliaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Multifamilia getMultifamilia(Long idMufa) throws Exception {
        Multifamilia entity = null;

        try {
            entity = multifamiliaDAO.findById(idMufa);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Multifamilia");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Multifamilia> findPageMultifamilia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Multifamilia> entity = null;

        try {
            entity = multifamiliaDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Multifamilia Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberMultifamilia() throws Exception {
        Long entity = null;

        try {
            entity = multifamiliaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Multifamilia Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Multifamilia> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Multifamilia> list = new ArrayList<Multifamilia>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = multifamiliaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
