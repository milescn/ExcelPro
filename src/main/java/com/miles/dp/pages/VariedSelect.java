package com.miles.dp.pages;

/**
* 项目名称：TapestryStart
* 开发模式：Maven+Tapestry5.x+Tapestry-hibernate+Mysql
* 网址：http://www.flywind.org
* 版本：1.0
* 编写：飞风
* 时间：2012-02-29
*/
 
import org.apache.tapestry5.annotations.Property;
 
public class VariedSelect {
@Property
private String color0;
 
@Property
private String color1;
 
@Property
private String color2;
 
@Property
private String color3;
 
String[] onPassivate() {
return new String[] { color0, color1, color2, color3 };
}
 
void onActivate(String color0, String color1, String color2, String color3) {
this.color0 = color0;
this.color1 = color1;
this.color2 = color2;
this.color3 = color3;
}
}
