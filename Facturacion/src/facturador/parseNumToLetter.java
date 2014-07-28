/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facturador;

/**
 *
 * @author Izzy-Izumi
 */
public class parseNumToLetter {
    String cantidadNum , cantidadNumDecimal; 
    public parseNumToLetter(String cantidad){
        this.cantidadNum = cantidad.substring(0,cantidad.length()-3);
        this.cantidadNumDecimal = cantidad.substring(cantidad.length()-2, cantidad.length());
    }
    public String run(){
        int longitudReal = this.cantidadNum.length();
        System.out.println(longitudReal);
        String numEnLetra="";
        switch(longitudReal){
            case 5: numEnLetra+=decenasMillar(cantidadNum.substring(0, 2));
                    numEnLetra+=obtenerCentenas(cantidadNum.substring(2, cantidadNum.length()));
                break;
            case 4: numEnLetra+=unidadDeMillar(cantidadNum.substring(0, 1));
                    numEnLetra+=obtenerCentenas(cantidadNum.substring(1,cantidadNum.length()));
                break;
            case 3: numEnLetra+=obtenerCentenas(cantidadNum);
                break;
        }
        numEnLetra+="PESOS "+this.cantidadNumDecimal+"/100 MN";
        return numEnLetra;
    }
    public String decenasMillar(String numReal){
        int parseNum = Integer.parseInt(numReal);
        String millarConvertido="";
        if(parseNum<20){
            millarConvertido=specialCases(parseNum);
        }
        if(parseNum>=20){
            millarConvertido=calcularDecenas(parseNum, 20, "VEINTE ", "VEINTI");
        }
        if(parseNum>=30){
            millarConvertido=calcularDecenas(parseNum, 30, "TREINTA ", "TREINTA Y ");
        }
        if(parseNum>=40){
            millarConvertido=calcularDecenas(parseNum, 40, "CUARENTA ", "CUARENTA Y ");
        }
        if(parseNum>=50){
            millarConvertido=calcularDecenas(parseNum, 50, "CINCUENTA ", "CINCUENTA Y ");
        }
        if(parseNum>=60){
            millarConvertido=calcularDecenas(parseNum, 60, "SESENTA ", "SESENTA Y ");
        }
        if(parseNum>=70){
            millarConvertido=calcularDecenas(parseNum, 70, "SETENTA ", "SETENTA Y ");
        }
        if(parseNum>=80){
            millarConvertido=calcularDecenas(parseNum, 80, "OCHENTA ", "OCHENTA Y ");
        }
        if(parseNum>=90){
            millarConvertido=calcularDecenas(parseNum, 90, "NOVENTA ", "NOVENTA Y ");
        }
        millarConvertido+="MIL ";
        return millarConvertido;
    }
    
    public String calcularDecenas(int num, int numComp, String menorUno, String mayorCero){
        String numConvertido="", numReal = String.valueOf(num);
        if(num>=numComp){
            if(num==numComp)
                numConvertido=menorUno;
            else{
                numConvertido=mayorCero;
                int partirNum = Integer.parseInt(numReal.substring(1));
                System.out.println("porque? " +partirNum);
                switch(partirNum){
                    case 1: numConvertido+="UN "; break;
                    case 2: numConvertido+="DOS "; break;
                    case 3: numConvertido+="TRES "; break;
                    case 4: numConvertido+="CUATRO "; break;
                    case 5: numConvertido+="CINCO "; break;
                    case 6: numConvertido+="SEIS "; break;
                    case 7: numConvertido+="SIETE "; break;
                    case 8: numConvertido+="OCHO "; break;
                    case 9: numConvertido+="NUEVE "; break;
                }
            }
        }
        return numConvertido;
    }
    
    public String unidadDeMillar(String num){
        String numConvertido="";
        switch(Integer.parseInt(num)){
                    case 1: numConvertido+=""; break;
                    case 2: numConvertido+="DOS "; break;
                    case 3: numConvertido+="TRES "; break;
                    case 4: numConvertido+="CUATRO "; break;
                    case 5: numConvertido+="CINCO "; break;
                    case 6: numConvertido+="SEIS "; break;
                    case 7: numConvertido+="SIETE "; break;
                    case 8: numConvertido+="OCHO "; break;
                    case 9: numConvertido+="NUEVE "; break;
                }
        numConvertido+="MIL ";
        return numConvertido;
    }
    
    public String specialCases(int num){
        String partirNum = String.valueOf(num).substring(1), numConVertido="";
        switch(Integer.parseInt(partirNum)){
            case 1: numConVertido="ONCE "; break;
            case 2: numConVertido="DOCE "; break;
            case 3: numConVertido="TRECE "; break;
            case 4: numConVertido="CATORCE "; break;
            case 5: numConVertido="QUINCE "; break;
            case 6: numConVertido="DIECISEIS "; break;
            case 7: numConVertido="DIECISIETE "; break;
            case 8: numConVertido="DIECIOCHO "; break;
            case 9: numConVertido="DIECINUEVE "; break;
        }
        return numConVertido;
    }
    
    public String obtenerCentenas(String num){
        String numConvertido = "";
        int parseNum = Integer.parseInt(num);
        if(parseNum>=100){
            numConvertido=calcularCentenas(parseNum, 100, "CIEN ", "CIENTO ");
        }if(parseNum>=200){
            numConvertido=calcularCentenas(parseNum, 100, "DOSCIENTOS ", "DOSCIENTOS ");
        }if(parseNum>=300){
            numConvertido=calcularCentenas(parseNum, 100, "TRESCIENTOS ", "TRESCIENTOS ");
        }if(parseNum>=400){
            numConvertido=calcularCentenas(parseNum, 100, "CUATROCIENTOS ", "CUATROCIENTOS ");
        }if(parseNum>=500){
            numConvertido=calcularCentenas(parseNum, 100, "QUINIENTOS ", "QUINIENTOS ");
        }if(parseNum>=600){
            numConvertido=calcularCentenas(parseNum, 100, "SEISCIENTOS ", "SEISCIENTOS ");
        }if(parseNum>=700){
            numConvertido=calcularCentenas(parseNum, 100, "SETECIENTOS ", "SETECIENTOS ");
        }if(parseNum>=800){
            numConvertido=calcularCentenas(parseNum, 100, "OCHOCIENTOS ", "OCHOCIENTOS ");
        }if(parseNum>=900){
            numConvertido=calcularCentenas(parseNum, 100, "NOVECIENTOS ", "NOVECIENTOS ");
        }
        return numConvertido;
    }
    
    public String calcularCentenas(int num, int numComp, String menorUno, String mayorCero){
        String numConvertido="", numReal = String.valueOf(num);
        System.out.println("Aqui estoy");
        if(num>=numComp){
            if(num==numComp)
                numConvertido=menorUno;
            else{
                numConvertido=mayorCero;
                int partirNum = Integer.parseInt(numReal.substring(1,2));
                String numPartido = numReal.substring(1);
                int numPart = Integer.parseInt(numReal.substring(1));
                System.out.println(partirNum);
                System.out.println(numPart);
                System.out.println(numPart);
                switch(partirNum){
                    case 2: numConvertido+=calcularDecenas(numPart, 20, "VEINTE ", "VEINTI"); break;
                    case 3: numConvertido+=calcularDecenas(numPart, 30, "TREINTA ", "TREINTA Y "); break;
                    case 4: numConvertido+=calcularDecenas(numPart, 40, "CUARENTA ", "CUARENTA Y "); break;
                    case 5: numConvertido+=calcularDecenas(numPart, 50, "CINCUENTA ", "CINCUENTA Y "); break;
                    case 6: numConvertido+=calcularDecenas(numPart, 60, "SESENTA ", "SESENTA Y "); break;
                    case 7: numConvertido+=calcularDecenas(numPart, 70, "SETENTA ", "SETENTA Y "); break;
                    case 8: numConvertido+=calcularDecenas(numPart, 80, "OCHENTA ", "OCHENTA Y "); break;
                    case 9: numConvertido+=calcularDecenas(numPart, 90, "NOVENTA ", "NOVENTA Y "); break;
                }
            }
        }
        return numConvertido;
    }
}
