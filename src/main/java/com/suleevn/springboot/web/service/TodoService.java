package com.suleevn.springboot.web.service;

import com.suleevn.springboot.web.database.dbdelete;
import com.suleevn.springboot.web.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.suleevn.springboot.web.database.database.*;


@Service
public class TodoService<i> {
    public static List<Todo> todos = new ArrayList<Todo>();
    public static int todoCount = indf;
    public static int iddel;

    public static void main(String[] args) {
            if(countdb != 0){
            for (int i = 0; i < countdb; i++) {

                todos.add(new Todo(iddbl.get(i), "nurasyl", namedbl.get(i), numberdbl.get(i)));
            }
        }}

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equalsIgnoreCase(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    
    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(Todo todo){
            todos.remove(todo);
            todos.add(todo);


    }

    public void addTodo(String name, String desc, String cnumber) {
        todos.add(new Todo(todoCount++, name, desc, cnumber));
    }



    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
                iddel = id;
                dbdelete.main(null);
            }
        }
    }
}