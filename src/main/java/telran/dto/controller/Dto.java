package telran.dto.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
public class Dto {
boolean success;
long timestamp;
String base;
@JsonFormat(pattern = "yyyy-MM-dd")
LocalDate date;
HashMap<String, Double> rates;
}



//"success": true,
//"timestamp": 1519296206,
//"base": "EUR",
//"date": "2021-12-06",
//"rates": {
//    "AUD": 1.566015,
//    "CAD": 1.560132,
//    "CHF": 1.154727,
//    "CNY": 7.827874,
//    "GBP": 0.882047,
//    "JPY": 132.360679,
//    "USD": 1.23396,