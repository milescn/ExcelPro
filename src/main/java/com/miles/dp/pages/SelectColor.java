package com.miles.dp.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;

public class SelectColor
{
  @Validate("required")
  @Property
  private String color;

}