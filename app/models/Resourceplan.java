package models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: ayond
 * Date: 05/10/12
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Resourceplan {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private int resempId;

    @javax.persistence.Column(name = "resempId")
    @Basic
    public int getResempId() {
        return resempId;
    }

    public void setResempId(int resempId) {
        this.resempId = resempId;
    }

    private int resprojectId;

    @javax.persistence.Column(name = "resprojectId")
    @Basic
    public int getResprojectId() {
        return resprojectId;
    }

    public void setResprojectId(int resprojectId) {
        this.resprojectId = resprojectId;
    }

    private String resprojectName;

    @javax.persistence.Column(name = "resprojectName")
    @Basic
    public String getResprojectName() {
        return resprojectName;
    }

    public void setResprojectName(String resprojectName) {
        this.resprojectName = resprojectName;
    }

    private int week;

    @javax.persistence.Column(name = "week")
    @Basic
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    private int occupied;

    @javax.persistence.Column(name = "occupied")
    @Basic
    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resourceplan that = (Resourceplan) o;

        if (id != that.id) return false;
        if (occupied != that.occupied) return false;
        if (resempId != that.resempId) return false;
        if (resprojectId != that.resprojectId) return false;
        if (week != that.week) return false;
        if (resprojectName != null ? !resprojectName.equals(that.resprojectName) : that.resprojectName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + resempId;
        result = 31 * result + resprojectId;
        result = 31 * result + (resprojectName != null ? resprojectName.hashCode() : 0);
        result = 31 * result + week;
        result = 31 * result + occupied;
        return result;
    }

    private Employee employeeByResempId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "resempId", referencedColumnName = "empId", nullable = false)
    public Employee getEmployeeByResempId() {
        return employeeByResempId;
    }

    public void setEmployeeByResempId(Employee employeeByResempId) {
        this.employeeByResempId = employeeByResempId;
    }
}
