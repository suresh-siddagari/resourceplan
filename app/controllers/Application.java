package controllers;

import play.*;
import play.db.jpa.JPA;
import play.mvc.*;

import java.util.*;
import javax.persistence.Query;
import models.*;
public class Application extends Controller {

    public static void index() {


        Query objQuery= JPA.em().createQuery("select empId, empName,empType from Employee ");
        List<Object> listTempEmployees=objQuery.getResultList();

        List<Employee> listEmployees=new ArrayList<Employee>();

        for(Object tempEmp : listTempEmployees ){

            Object[] objResult=(Object[])tempEmp;
            Employee objTempEmp=new Employee();
            objTempEmp.setEmpId((Integer)objResult[0]);
            objTempEmp.setEmpName((String)objResult[1]);
            objTempEmp.setEmpType((String)objResult[2]);
            listEmployees.add(objTempEmp);
        }
        Logger.info("number of employees"+listEmployees.size());
        render();
    }

}