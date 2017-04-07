package com.hawk.springboot.common;

import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;


/**
 * 
 * @author
 *
 */
public class BeanUtil extends PropertyUtils {

	private BeanUtil() {}
	/**
	 * override BeanUtils method copyProperties, support not copy null or blank
	 * property
	 * 
	 * @param dest
	 * @param src
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static void copyProperties(Object dest, Object src) {
		// 为两个参数时，skipNull 默认为false
		copyProperties(dest, src, false);
	}

	/**
	 * override BeanUtils method copyProperties, support not copy null or blank
	 * property
	 * 
	 * @param dest
	 * @param src
	 * @param skipNull 拷贝时是否忽略src对象为null的属性
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static void copyProperties(Object dest, Object src, boolean skipNull) {
		// Validate existence of the specified beans
		if (dest == null) {
			throw new IllegalArgumentException("No destination bean specified");
		}

		if (src == null) {
			throw new IllegalArgumentException("No origin bean specified");
		}
		// 获取所有src中的属性，存入于数组中
		PropertyDescriptor[] origDescriptors = PropertyUtils.getPropertyDescriptors(src);

		for (int i = 0; i < origDescriptors.length; i++) {
			// 取出src中属性名
			String name = origDescriptors[i].getName();

			if ("class".equals(name)) {
				continue; // No point in trying to set an object's class
			}

			if (PropertyUtils.isReadable(src, name) && PropertyUtils.isWriteable(dest, name)) {
				Object value = null;
				try {
					// 取出属性的值
					value = PropertyUtils.getSimpleProperty(src, name);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (skipNull) {
					if (value == null) {
						continue;
					}
				} else if (value == null) {
					value = null;
				}

				try {
					// copyProperties(dest, name, value);
					setProperty(dest, name, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
