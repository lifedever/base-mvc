package com.wincn.base.utils.velocity.engine;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createDate 2013-4-1 下午3:13:42
 */
public class VelocityUtils {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(VelocityUtils.class);

	/**
	 * 将数据和模板文件合并，返回字符串 不同模板，不同数据，相应合并，使用 velocity 模板实现
	 * 
	 * @param templateFileName
	 *            完整到模板路径地址
	 * @param data
	 *            包含key,value到map对象
	 * @return
	 */
	public static String mergeTemplateIntoString(String templateFileName, Map<String, Object> data) {
		data.put("utils", new VelocityUtils());
		String outString = "";
		try {
			/*
			 * 生成完整到模板路径名
			 */
			VelocityEngine velocityEngine = getVelocityEngine();
			outString = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateFileName, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outString;
	}

	/**
	 * 取得VelocityEngine
	 * 
	 * @return
	 */
	public static VelocityEngine getVelocityEngine() {
		Map<String, Object> velocityPropertiesMap = new HashMap<String, Object>();
		velocityPropertiesMap.put("resource.loader", "file");
		velocityPropertiesMap.put("velocimacro.library", "");
		velocityPropertiesMap.put("input.encoding", "UTF-8");
		velocityPropertiesMap.put("output.encoding", "UTF-8");
		velocityPropertiesMap.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityPropertiesMap.put("class.resource.loader.cache", "false");

		String filePath = VelocityUtils.class.getResource("").getPath();
		String path = filePath.substring(0, filePath.indexOf("classes")) + "classes/";
		velocityPropertiesMap.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		velocityPropertiesMap.put("file.resource.loader.path", path);
		velocityPropertiesMap.put("file.resource.loader.cache", "false");
		velocityPropertiesMap.put("file.resource.loader.modificationCheckInterval", "2");
		velocityPropertiesMap.put("runtime.interpolate.string.literals", "true");
		VelocityEngineFactoryBean vefb = new VelocityEngineFactoryBean();
		vefb.setVelocityPropertiesMap(velocityPropertiesMap);
		VelocityEngine ve = null;
		try {
			ve = vefb.createVelocityEngine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ve;
	}
}