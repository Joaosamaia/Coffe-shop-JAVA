package classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario{
	//add funcionario specific atributes
	@Id
	private String pessoaID;
	private String nome;
	private String telefone;
	private String email;
	private String CPF;
	private String cargo;

	@ManyToOne
	private Endereco endereco;
	
	
	
	//constructors
	public Funcionario() {
		super();
	}
	public Funcionario(String pessoaID) {
		super();
		this.pessoaID = pessoaID;
	}
	public Funcionario(String pessoaID, String nome, String telefone, String email, String cPF, String cargo,
			Endereco endereco) {
		super();
		this.pessoaID = pessoaID;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.CPF = cPF;
		this.cargo = cargo;
		this.endereco = endereco;
	}
	
	
	//getters and setters:

	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getPessoaID() {
		return pessoaID;
	}
	public void setPessoaID(String pessoaID) {
		this.pessoaID = pessoaID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
