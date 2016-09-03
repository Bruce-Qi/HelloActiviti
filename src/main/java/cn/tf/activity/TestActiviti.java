package cn.tf.activity;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

//模拟activity工作流框架的执行
public class TestActiviti {
	//取得流程引擎，且自动创建Activity涉及的数据库和表
	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
	
	
	@Test
	public void createProcessEngine(){
		//通过代码形式创建
		/*ProcessEngineConfiguration  engineConfiguration=ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration();
		
		//设置数据库连接属性
		engineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		engineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activitiDB?createDatabaseIfNotExist=true"
				+ "&useUnicode=true&characterEncoding=utf8");
		engineConfiguration.setJdbcUsername("zp");
		engineConfiguration.setJdbcPassword("a");
		
		//自动创建表
		engineConfiguration.setDatabaseSchemaUpdate("true");
		
		ProcessEngine processEngine=engineConfiguration.buildProcessEngine();
	*/
	
	//方法2  通过加载activiti.cfg.xml获得流程引擎和自动创建数据库和表
/*	ProcessEngineConfiguration  engineConfiguration=ProcessEngineConfiguration
			.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
	
	ProcessEngine processEngine=engineConfiguration.buildProcessEngine();
	
	*/
	
	
	//方法3   通过流程引擎来获取默认的流程引擎
	//	ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		
	}
	
	
/*	//部署流程定义
	@Test
	public void deploy(){
		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		//获取仓库服务，管理流程定义
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deploy = repositoryService.createDeployment()
		.addClasspathResource("diagrams/LeaveBill.bpmn")
		.addClasspathResource("diagrams/LeaveBill.png")
		.name("请求单流程")
		.category("办公类别")
		.deploy();
		
		System.out.println(deploy.getId());
		System.out.println(deploy.getName());
	}
	
	
	//执行流程
	@Test
	public void startProcess(){
		String processDefKit="leaveBill";
		
		//取服务
		RuntimeService runtimeService=processEngine.getRuntimeService();
		//取得流程实例
		ProcessInstance pi = runtimeService.startProcessInstanceByKey(processDefKit);
		
		System.out.println("流程实例id:"+pi.getId());
		System.out.println("流程定义id:"+pi.getProcessDefinitionId());
	}*/
	
	
	//查询任务
	@Test
	public void queryTask(){
		String assignee="李四";
		//取得任务服务
		TaskService taskService = processEngine.getTaskService();
		//取得任务查询对象
		TaskQuery createTaskQuery = taskService.createTaskQuery();
		//办理人的任务列表
		List<Task> list = createTaskQuery.taskAssignee(assignee).list();
		
		//遍历任务列表
		if(list!=null && list.size()>0){
			for(Task task:list){
				System.out.println("任务办理人:"+task.getAssignee());
				System.out.println("任务的id："+task.getId());
				System.out.println("任务的名称:"+task.getName());
			}
			
		}
		
	}
	
	
	
	/*//完成任务
	@Test
	public void compileTask(){
		
		String taskId="108";
		//任务id
		processEngine.getTaskService().complete(taskId);
		
	}*/
	
	
	
	
	
	

}
