package org.view;

import org.view.Exameple2.Calculator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {

    Calculator calculator = new Calculator();
    calculator.add(5);
    System.out.println(calculator.getResult());
  }
}