package com.suleevn.springboot.web.controller;

import com.suleevn.springboot.web.database.dbadd;
import com.suleevn.springboot.web.database.dbupdate;
import com.suleevn.springboot.web.database.dbupdate_v2;
import com.suleevn.springboot.web.model.Todo;
import com.suleevn.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TodoController {


	public static String nmadd;
	public static String nbadd;
	public static int idupd;
	public static String nmupd;
	public static String nbupd;

	@Autowired
	TodoService service;



	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "", new String()));
		return "todo";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {

		if(id==0)
			throw new RuntimeException("Something went wrong");
		
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);

		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo,
			BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUser(getLoggedInUserName(model));
		model.put("todo", todo);
		service.updateTodo(todo);
		idupd = todo.getId();
		nmupd = todo.getDesc();
		nbupd = todo.getCnumber();
		dbupdate.main(null);
		dbupdate_v2.main(null);

		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		nmadd = todo.getDesc();
		nbadd = todo.getCnumber();
		dbadd.main(null);
		service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getCnumber());
		return "redirect:/list-todos";

	}
}
