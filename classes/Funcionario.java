package classes;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa{
	//add funcionario specific atributes
	
	//implement methods for funcionario
	void imprimir(String a) {
	}
	
		//add functions for funcionario management
		/*such as:
	AddEmployee:
        Description: Adds a new employee to the system.
        Parameters: Employee details such as name, contact information, role, etc.
        Usage: When a new staff member is hired.

    UpdateEmployeeDetails:
        Description: Modifies the details of an existing employee.
        Parameters: Employee ID and updated information.
        Usage: When an employee's personal or professional details change.

    ViewEmployeeDetails:
        Description: Retrieves and displays employee information.
        Parameters: Employee ID or other identifiers.
        Usage: Allows management to view details for scheduling, performance evaluations, or administrative purposes.

    AssignRole:
        Description: Assigns a specific role or position to an employee.
        Parameters: Employee ID, role or position.
        Usage: When an employee takes on a new responsibility or role.

    ViewSchedule:
        Description: Retrieves and displays the work schedule for an employee.
        Parameters: Employee ID, date range.
        Usage: Allows employees to view their upcoming work schedule.

    RemoveEmployee:
        Description: Removes an employee and their associated data from the system.
        Parameters: Employee ID.
        Usage: When an employee leaves the company, either voluntarily or involuntarily.

    TrackAttendance:
        Description: Records and tracks employee attendance.
        Parameters: Employee ID, date, time in/out.
        Usage: Monitors punctuality and attendance for payroll and performance evaluation purposes.
	 */
}
