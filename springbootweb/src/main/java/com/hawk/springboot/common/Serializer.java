package com.hawk.springboot.common;
/** 
 * @Desc  序列化接口
 * @Author feelingxu@tcl.com: 
 * @Date 创建时间：2016年6月30日 上午10:59:09 
 * @Version V1.0.0
 */
public abstract interface Serializer
{
  public abstract byte[] serialize(Object paramObject);

  public abstract <T> T deserialize(byte[] paramArrayOfByte);
}