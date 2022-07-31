/**
 * 
 */
package com.bridgelabz.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author MD_AFROZ
 *
 */
public class EmployeePayrollService {
	public enum IOStream {
		CONSOLE_IO, FILE_IO, DATABASE_IO, REST_IO;
	}

	static Scanner sc;
	List<Employee> employeeList;
	IOStream ioStream;

	public EmployeePayrollService(IOStream ioStream) {
		employeeList = new ArrayList<Employee>();
		this.ioStream = ioStream;
	}

	public static void main(String[] args) {
		EmployeePayrollService service = new EmployeePayrollService(IOStream.CONSOLE_IO);
		sc = new Scanner(System.in);
		if (service.ioStream.equals(IOStream.CONSOLE_IO)) {
			boolean exit = false;
			while (!exit) {
				System.out.println("**************** Employee Payroll Service ****************");
				System.out.println("1. Add Employee\n 2. Show Employees\n 3. Exit");
				System.out.println("<-----------------Choose your options----------------->");
				int option = sc.nextInt();
				System.out.println("<------------------------------------------------------->");
				switch (option) {
				case 1:
					System.out.println("<-----------------Add Employee----------------->");
					service.readEmployeePayrollData();
					break;
				case 2:
					System.out.println("<-----------------Show Employees----------------->");
					service.writeEmployeePayrollData();
					break;
				case 3:
					exit = true;
					System.out.println("***************Thank you***************");
					break;
				default:
					System.out.println("Invalid option.Please try again.!!!");
				}
			}
		}

	}

	public void readEmployeePayrollData() {
		sc = new Scanner(System.in);
		if (ioStream.equals(IOStream.CONSOLE_IO)) {
			Employee emp = new Employee();
			int id = (int) (Math.random() * 900 + 100);
			emp.setId(id);
			System.out.println("Enter the employee name : ");
			emp.setName(sc.nextLine());
			System.out.println("Enter the employee salary : ");
			emp.setSalary(sc.nextDouble());
			employeeList.add(emp);
			System.out.println("Employee added successfully.!!!");
		}
	}

	public void writeEmployeePayrollData() {
		if (employeeList.isEmpty()) {
			System.out.println("No records found.!!!");
		} else {
			for (Employee employee : employeeList) {
				System.out.println(employee);
			}
		}
	}

}
