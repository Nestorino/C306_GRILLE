#! / bin / bash 
## SCRIPT D'EXECUTION DE COUVERTURE DE CODE 
## SUPRESSION DES ANCIENS RAPPORTS ET INSTRUMENTATION 
rm -rf destination/* instrumented/* cobertura.ser C:/Users/Nestor/Documents/NetBeansProjects/C306_ACTIVITE2/test/activite/CalculTest.class C:/Users/Nestor/Documents/NetBeansProjects/C306_ACTIVITE2/src/activite/Calcul.class 
 
## COMPILATION DE MON CODE 
javac C:/Users/Nestor/Documents/NetBeansProjects/C306_ACTIVITE2/src/activite/Calcul.java 
javac -cp cobertura-2.1.1/lib/junit-4.11.jar:Activites/src:. C:/Users/Nestor/Documents/NetBeansProjects/C306_ACTIVITE2/test/activite/CalculTest.java 

## INSTRUMENTATION 
cobertura-2.1.1/cobertura-instrument.sh --destination instrumented/ C:/Users/Nestor/Documents/NetBeansProjects/C306_ACTIVITE2/src/activite/Calcul.class C:/Users/Nestor/Documents/NetBeansProjects/C306_ACTIVITE2/test/activite/CalculTest.class
 
## EXECUTION DU CODE INSTRUMENTE 
java -cp C:/Users/Nestor/Documents/NetBeansProjects/C306_ACTIVITE2/cobertura-2.1.1/cobertura-2.1.1.jar:cobertura2.1.1/lib/slf4j-api-1.7.5.jar:cobertura-2.1.1/lib/logbackcore-1.0.13.jar:cobertura-2.1.1/lib/logback-classic1.0.13.jar:cobertura-2.1.1/lib/junit-4.11.jar:./instrumented:. activite2.CalculTest 
 
## GENERATION DU RAPPORT 
cobertura-2.1.1/cobertura-report.sh --datafile cobertura.ser -format html --destination destination/ . 
 
## AFFICHAGE DU RAPPORT 
firefox destination/index.html
PAUSE