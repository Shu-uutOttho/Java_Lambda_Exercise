package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter with the full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Employee> list = new ArrayList<>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			System.out.print("Enter the Salary valor: ");
			Double salary = sc.nextDouble();
			System.out.println();

			List<String> emails = list.stream().filter(e -> e.getSalary() > salary)
					.map(e -> e.getEmail()).sorted()
					.collect(Collectors.toList());

			List<String> nameM = list.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getName())
					.sorted((s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
					.collect(Collectors.toList());
					
			System.out.println("Email of the people whose the salary is more than " + String.format("%.2f", salary) + ":");
			emails.forEach(System.out::println);
			
			System.out.println();
			
			System.out.println("People who name starts with 'M': ");
			nameM.forEach(System.out::println);
			
			System.out.println();
			
			Double sumSalaryNameM = list.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (x, y) -> x + y);

			System.out.println("Salary of the people who name starts with 'M' :" + String.format("%.2f", sumSalaryNameM));
			
			
		} catch (FileNotFoundException e) {
			System.out.println(("File not found!" + e.getMessage()));
		} catch (IOException e) {
			System.out.println(("Error" + e.getMessage()));
			e.getStackTrace();
		}
		sc.close();

	}

}
