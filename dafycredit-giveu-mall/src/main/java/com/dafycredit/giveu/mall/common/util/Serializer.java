package com.dafycredit.giveu.mall.common.util;

/**
* <br>序列化接口</br>
*
* @class  Serializer
* @author  lennylv
* @date    2017/4/11 23:41
* @version 1.0
* @since  1.0
*/

public abstract interface Serializer
{
  public abstract byte[] serialize(Object paramObject);

  public abstract <T> T deserialize(byte[] paramArrayOfByte);
}