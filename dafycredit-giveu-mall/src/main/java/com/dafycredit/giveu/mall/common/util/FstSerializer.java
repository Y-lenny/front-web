package com.dafycredit.giveu.mall.common.util;

import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectInput;
import org.nustaq.serialization.FSTObjectOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
* <br>基于fst序列化工具类</br>
*
* @class  FstSerializer
* @author  lennylv
* @date    2017/4/11 23:40
* @version 1.0
* @since  1.0
*/

public class FstSerializer implements Serializer {

	private FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();

	public byte[] serialize(Object object) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		FSTObjectOutput out = conf.getObjectOutput(stream);
		try {
			out.writeObject(object);
			out.flush();
			stream.close();
		}catch (Exception e) {
				e.printStackTrace();
		}
		return stream.toByteArray();
	}

	@SuppressWarnings("unchecked")
	public <T> T deserialize(byte[] bytes) {
		T result = null;
		try {
			ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
			FSTObjectInput in = conf.getObjectInput(stream);
			result = (T) in.readObject();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
