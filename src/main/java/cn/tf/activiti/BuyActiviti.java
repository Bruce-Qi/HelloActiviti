package cn.tf.activiti;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FileUtils;
import org.junit.Test;



public class BuyActiviti {
	
	private ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
	
/*	@Test
	public void deployProcessDefi(){
		Deployment deploy = processEngine.getRepositoryService()
				.createDeployment()
				.name("采购流程")
				.addClasspathResource("diagrams/BuyBill.bpmn")
				.addClasspathResource("diagrams/BuyBill.png")
				.deploy();
				
				System.out.println("部署名称:"+deploy.getName());
				System.out.println("部署id:"+deploy.getId());
		
	}*/
	
	//部署流程定义
/*	@Test
	public void deployProcessDefiByZip(){
		InputStream in=getClass().getClassLoader().getResourceAsStream("BuyBill.zip");
		
		
		Deployment deploy = processEngine.getRepositoryService()
				.createDeployment()
				.name("采购流程")
				.addZipInputStream(new ZipInputStream(in))
				.deploy();
				
				System.out.println("部署名称:"+deploy.getName());
				System.out.println("部署id:"+deploy.getId());
		
	}*/
	
	//查看流程定义
	/*
	@Test
	public void queryProcessDefination(){
		String processDefiKey="buyBill";//流程定义key
		List<ProcessDefinition> list =  processEngine.getRepositoryService().createDeploymentQuery()
//		.processDefinitionId(proDefiId) //流程定义id

		.processDefinitionKey(processDefiKey)//流程定义key 由bpmn 的 process 的  id属性决定
//		.processDefinitionName(name)//流程定义名称  由bpmn 的 process 的  name属性决定
//		.processDefinitionVersion(version)//流程定义的版本
		.latestVersion()//最新版本
		
		//排序
		.orderByProcessDefinitionVersion().desc()//按版本的降序排序
		
		//结果
//		.count()//统计结果
//		.listPage(arg0, arg1)//分页查询
		.list();
		
		
		//遍历结果
		if(list!=null&&list.size()>0){
			for(ProcessDefinition temp:list){
				System.out.print("流程定义的id: "+temp.getId());
				System.out.print("流程定义的key: "+temp.getKey());
				System.out.print("流程定义的版本: "+temp.getVersion());
				System.out.print("流程定义部署的id: "+temp.getDeploymentId());
				System.out.println("流程定义的名称: "+temp.getName());
			}
		}
		
	}*/
	
	//查看png图片
/*	@Test
	public void viewImage() throws IOException{
		String deployId="401";
		String imageName=null;
		List<String> deploymentResourceNames = processEngine.getRepositoryService().getDeploymentResourceNames(deployId);
		
		if(deploymentResourceNames!=null && deploymentResourceNames.size()>0){
			for (String temp : deploymentResourceNames) {
				if(temp.indexOf(".png")>0){
					imageName=temp;
				}
			}
		}
	
	
	*//**
	 * 读取资源
	 * deploymentId:部署的id
	 * resourceName：资源的文件名
	 *//*
	InputStream resourceAsStream = processEngine.getRepositoryService()
			.getResourceAsStream(deployId, imageName);
	
	//把文件输入流写入到文件中
	File file=new File("d:/"+imageName);
	FileUtils.copyInputStreamToFile(resourceAsStream, file);
	
	}*/
	
	
	//删除流程
	@Test
	public void delete(){
		String deloyId="301";
		processEngine.getRepositoryService().deleteDeployment(deloyId);
		
	}
	

}
