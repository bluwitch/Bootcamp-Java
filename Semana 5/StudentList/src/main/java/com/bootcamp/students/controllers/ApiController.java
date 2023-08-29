package com.bootcamp.students.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootcamp.students.models.Info;
import com.bootcamp.students.models.Student;
import com.bootcamp.students.services.ApiService;
import com.bootcamp.students.services.ContactService;

@Controller
public class ApiController {

	private final ContactService contactService;
	private final ApiService studentService;

	public ApiController(ApiService studentService, ContactService contactService) {
		this.contactService = contactService;
		this.studentService = studentService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/students/new")
	public String createStudent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("age") int age, RedirectAttributes redirectAttributes) {
		Student student = new Student(firstName, lastName, age);
		studentService.createStudent(student);

		redirectAttributes.addFlashAttribute("message", "Estudiante creado exitosamente");

		return "redirect:/students";
	}

	@GetMapping("/students/new")
	public String showStudentForm() {
		return "new";
	}

	@GetMapping("/students")
	public String allStudents(Model model) {
		List<Student> todosLosEstudiantes = studentService.allStudents();
		List<Info> todosLosContactos = contactService.TodosLosContactos();
		model.addAttribute("TodosLosEstudiantes", todosLosEstudiantes);
		model.addAttribute("TodosLosContactos", todosLosContactos);
		return "students";
	}

	@GetMapping("/contact/new")
	public String contactNew(Model model) {
		model.addAttribute("NuevoContacto", new Info());

		List<Student> students = studentService.allStudents();
		model.addAttribute("students", students);

		return "contact";
	}

	@PostMapping("/contact/new")
	public String createContact(@RequestParam("estudianteNombre") Long estudianteNombre,
			@RequestParam("adress") String a, @RequestParam("city") String c, @RequestParam("state") String s) {
		Info contacto = new Info();
		Student estudiante = studentService.findStudent(estudianteNombre);

		if (estudiante != null) {
			contacto.setStudent(estudiante);
			contacto.setadress(a);
			contacto.setCity(c);
			contacto.setState(s);
			contactService.CrearContacto(contacto);
		} else {
			return "/";
		}

		return "redirect:/students";
	}

}
