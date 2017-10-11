/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author franciscogonzalezdelvalle
 */
public class properties_example02 {
    public static void main(String[] args) {
       System.out.println("ejemplo CON properties & binding");
       IntegerProperty num1 = new SimpleIntegerProperty(1);
       IntegerProperty num2 = new SimpleIntegerProperty(2);
       NumberBinding sum = Bindings.add(num1,num2);
       System.out.println(sum.getValue());
       num1.setValue(2);
//       System.err.println(sum.getValue());
       System.out.println(sum.getValue());
       
       System.out.println("ejemplo SIN properties & binding");
       int numint1 =1;
       int numint2 =2;
       int sumaSinBinding = numint1 + numint2;
       System.out.println(sumaSinBinding);
       numint1 =2;
       System.out.println(sumaSinBinding);

    }
    
}
