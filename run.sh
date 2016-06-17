#!/bin/sh

mvn clean install
echo 'Executing SalsTax Console App.....'
java -jar target/SalexTaxes-0.0.1.jar

