package com.miles.dp.pages;

/**
 * 项目名称：TapestryStart
 * 开发模式：Maven+Tapestry5.3+Tapestry-hibernate+Mysql
 * 网址：http://www.flywind.org
 * 版本：1.1
 * 编写：飞风
 * 时间：2012-09-27
 */

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.internal.services.StringValueEncoder;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.services.TypeCoercer;
import org.apache.tapestry5.util.EnumSelectModel;
import org.apache.tapestry5.util.EnumValueEncoder;

public class SelectTest {

 @Property
 @Persist
 private String color0, color1, color3;
 
 @Property
 @Persist
 private MyColor color2;
 
 //使用StringValueEncoder定义select显示的值。
 @Property
 private final StringValueEncoder stringEncoder = new StringValueEncoder();
 
 @Property
 private final String[] colorModel = { "黄", "红", "绿" };
 
 //使用EnumValueEncoder定义select显示的值。
 public enum MyColor{
  black, red, yellow
 }
 
 @Inject
 private TypeCoercer typeCoercer;
 
 @Inject
    private Messages messages;
 
 @Property
   private final ValueEncoder<MyColor> enumEncoder = new EnumValueEncoder(typeCoercer, MyColor.class);

  @Property
    private final SelectModel colorModel2 = new EnumSelectModel(MyColor.class, messages);

}
