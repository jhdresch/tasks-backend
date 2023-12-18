package br.ce.wcaquino.taskbackend.controller;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {

	@Mock
	private TaskRepo todoRepo;

	@InjectMocks
	private TaskController controller;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = ValidationException.class)
	public void naoDeveSalvarTarefaSemDrescricao() throws ValidationException {

		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		todo.setTask(null);

		controller.save(todo);

	}

	@Test(expected = ValidationException.class)
	public void naoDeveSalvarTarefaSemData() throws ValidationException {

		Task todo = new Task();
		todo.setDueDate(null);
		todo.setTask("teste");

		controller.save(todo);

	}

	@Test(expected = ValidationException.class)
	public void naoDeveSalvarTarefaComDataPassada() throws ValidationException {

		Task todo = new Task();
		todo.setDueDate(LocalDate.of(2010, 11, 11));
		todo.setTask("teste");

		controller.save(todo);

	}

	@Test
	public void deveSalvaDataComSucesso() throws ValidationException {

		Task todo = new Task();
		todo.setDueDate(LocalDate.of(2030, 11, 11));
		todo.setTask("teste");

		controller.save(todo);
		Mockito.verify(todoRepo).save(todo);
		
		
	}

}
