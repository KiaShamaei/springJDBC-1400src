package com.example.springh2.repository;

import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springh2.model.Employee;



@Repository
public class EmployeeRepository {
	private final String GET_ALL = "SELECT * FROM employee";
	private final String INSERT = "INSERT INTO employee ( first_name , last_name , address ) values ( ? , ? , ? )";
	private final String Edit = "UPDATE employee set first_name = ? , last_name=? , address= ? WHERE id = ?";
	private final String Delete = "DELETE FROM employee WHERE id=?";
	@Autowired
	JdbcTemplate jdcJdbcTemplate;
	private RowMapper<Employee> rowMapper = (ResultSet rs , int rowNumber) -> {
		Employee emp = new Employee();
		emp.setId (rs.getInt(1));
		emp.setFirst_name(rs.getString(2));
		emp.setLast_name(rs.getString(3));
		emp.setAddress(rs.getString(4));
		return emp;
	};

	public List<Employee> findAll() {
		return jdcJdbcTemplate.query(GET_ALL, rowMapper);
	}
	public boolean addEmployee(Employee e) {
		
		
		if (jdcJdbcTemplate.update(INSERT,e.getFirst_name(),e.getLast_name(),e.getAddress())>0)return true;
		else return false;
	}
	public boolean editEmployee(Employee emp) {
		
		if (jdcJdbcTemplate.update(Edit, emp.getFirst_name(),emp.getLast_name(),emp.getAddress(),emp.getId())>0)return true;
		else
		return false;
	}
	public boolean deleteEmployee(int id) {
		if (jdcJdbcTemplate.update(Delete,id)>0)return true ;
		else return false;
	}

	
}
