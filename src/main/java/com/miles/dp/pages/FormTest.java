package com.miles.dp.pages;

/**
 * 项目名称：TapestryStart
 * 开发模式：Maven+Tapestry5.3+Tapestry-hibernate+Mysql
 * 网址：http://www.flywind.org
 * 版本：1.1
 * 编写：飞风
* 时间：2012-09-27
 */

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

public class FormTest {

@Property
 @Persist
 private String myName;
 
 public void onSuccessFromMyForm(){
  
 }
}
