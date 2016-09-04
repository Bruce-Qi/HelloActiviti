package cn.tf.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class ProcessInstanceAndTask {
	
	private ProcessEngine  processEngine=ProcessEngines.getDefaultProcessEngine();
	
	//执行流程
/*	@Test
	public void startProcess(){
		String processDefiKey="buyBill";//bpmn 的 process id属性
		ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey(processDefiKey);
		
		System.out.println("流程执行对象的id："+pi.getId());//Execution 对象
		System.out.println("流程实例的id："+pi.getProcessInstanceId());//ProcessInstanceAndTask 对象
		System.out.println("流程定义的id："+pi.getProcessDefinitionId());//默认执行的是最新版本的流程定义	}
	
	}*/
	
	//查询正在运行的任务
/*	@Test
	public void complieTask(){
		String taskId="504";
		processEngine.getTaskService().complete(taskId);
		
		
	}*/
	
	
	//获取当前实例状态
	/*@Test
	public void getProcessInstanceState(){
		String processInstanceId="603";
		 ProcessInstance pi = processEngine.getRuntimeService()
		 .createProcessInstanceQuery()
		 .processInstanceId(processInstanceId)
		 .singleResult();//返回的数据要么是单行，要么是空 ，其他情况报错
		 //判断流程实例的状态
		 if(pi!=null){
			 System.out.println("该流程实例"+processInstanceId+"正在运行...  "+"当前活动的任务:"+pi.getActivityId());
		 }else{
			 System.out.println("当前的流程实例"+processInstanceId+" 已经结束！");
		 }
		 
	}*/
	
	//查看历史执行流程实例信息
		@Test
		public void queryHistoryProcInst(){
			List<HistoricProcessInstance> list = processEngine.getHistoryService()
			.createHistoricProcessInstanceQuery()
			.list();
			if(list!=null&&list.size()>0){
				for(HistoricProcessInstance temp:list){
					System.out.println("历史流程实例id:"+temp.getId());
					System.out.println("历史流程定义的id:"+temp.getProcessDefinitionId());
					System.out.println("历史流程实例开始时间--结束时间:"+temp.getStartTime()+"-->"+temp.getEndTime());
				}
			}
		}
		//查看历史执行流程任务信息
		@Test
		public void queryHistoryTask(){
			String processInstanceId="701";
			List<HistoricTaskInstance> list = processEngine.getHistoryService()
					.createHistoricTaskInstanceQuery()
					.processInstanceId(processInstanceId)
					.list();
			if(list!=null&&list.size()>0){
				for(HistoricTaskInstance temp:list){
					System.out.print("历史流程实例任务id:"+temp.getId());
					System.out.print("历史流程定义的id:"+temp.getProcessDefinitionId());
					System.out.print("历史流程实例任务名称:"+temp.getName());
					System.out.println("历史流程实例任务处理人:"+temp.getAssignee());
				}
			}
		}
		
		
		
		
		
	
	
}
