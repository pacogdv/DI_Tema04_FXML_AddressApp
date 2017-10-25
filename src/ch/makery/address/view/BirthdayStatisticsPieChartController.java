/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.makery.address.view;

import ch.makery.address.model.Person;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart;

/**
 *
 * @author franciscogonzalezdelvalle
 */
public class BirthdayStatisticsPieChartController {
    
    @FXML
    private PieChart pieChart;

    private ObservableList<String> monthNames = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> dataPieData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Get an array with the English month names.
//        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getShortMonths();
        // Convert it to a list and add it to our ObservableList of months.
        monthNames.addAll(Arrays.asList(months));

        // Assign the month names as categories for the horizontal axis.
//        xAxis.setCategories(monthNames);
    }

    /**
     * Sets the persons to show the statistics for.
     * 
     * @param persons
     */
    public void setPersonDataPieChart(List<Person> persons) {
        // Count the number of people having their birthday in a specific month.
        int[] monthCounter = new int[12];
        for (Person p : persons) {
            int month = p.getBirthday().getMonthValue() - 1;
            monthCounter[month]++;
        }
            
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
//            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
//          pieChartData.add(new PieChart.Data("GTX 690", 35));

            dataPieData.add(new PieChart.Data(monthNames.get(i), monthCounter[i]));
        }

//        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//            new PieChart.Data("GrapeFruit", 50),
//            new PieChart.Data("Orange", 25),
//            new PieChart.Data("Apple", 25)
//        );
//        pieChart.setData(pieChartData); 

        pieChart.setData(dataPieData); 
    }
    
}
