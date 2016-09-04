package cn.tf.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

//连线
public class UserTask {
	
	private ProcessEngine processEngine = ProcessEngines
			.getDefaultProcessEngine();

	// 部署流程定义，资源来在bpmn格式
/*	@Test
	public void deployProcessDefi() {
		Deployment deploy = processEngine.getRepositoryService()
				.createDeployment().name("指定用户处理")
				.addClasspathResource("diagrams/AppayBill.bpmn")
				.addClasspathResource("diagrams/AppayBill.png")
				.deploy();

		System.out.println("部署名称:" + deploy.getName());
		System.out.println("部署id:" + deploy.getId()); 
	}*/

	// 执行流程，开始跑流程
	//@Test
	public void startProcess() {
		String processDefiKey = "appayBill";// bpmn 的 process id属性
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("userID", "王大锤");
		
		ProcessInstance pi = processEngine.getRuntimeService()
				.startProcessInstanceByKey(processDefiKey,param);

		System.out.println("流程执行对象的id：" + pi.getId());// Execution 对象
		System.out.println("流程实例的id：" + pi.getProcessInstanceId());// ProcessInstance
																	// 对象
		System.out.println("流程定义的id：" + pi.getProcessDefinitionId());// 默认执行的是最新版本的流程定义
	}

	// 查询正在运行任务
	@Test
	public void queryTask() {
		// 取得任务服务
		TaskService taskService = processEngine.getTaskService();
		// 创建一个任务查询对象
		TaskQuery taskQuery = taskService.createTaskQuery();
		// 办理人的任务列表
		List<Task> list = taskQuery.taskAssignee("王大锤").list();
		// 遍历任务列表
		if (list != null && list.size() > 0) {
			for (Task task : list) {
				System.out.println("任务的办理人：" + task.getAssignee());
				System.out.println("任务的id：" + task.getId());
				System.out.println("任务的名称：" + task.getName());
			}
		}
	}

}
