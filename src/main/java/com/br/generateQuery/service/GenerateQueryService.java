package com.br.generateQuery.service;

import com.br.generateQuery.domain.GenerateQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateQueryService {

    public String generateQuery(GenerateQuery object){

        String response = "Select * from ";

        //Monta qual tabela vai utilizar
        if(object.getTable() != null){
            response = response + object.getTable();
            response = response + "\n";
        }
        else{
            throw new IllegalArgumentException("table is not informed");
        }

        if((object.getValues() != null && !object.getValues().isEmpty() )
                || (object.getComparators() != null && !object.getComparators().isEmpty())
                || (object.getOperators() != null && !object.getOperators().isEmpty())){

            response = response + " where ";
            Integer contOperator = 0;
            Integer contComparator = 0;
            Boolean validatorDuplicateOperator = false;
            List<String> valueList = object.getValues();
            List<String> operatorList = object.getOperators();
            List<String> comparatorsList = object.getComparators();

            for (String value : valueList) {

                response = response + value;

                    while (contOperator < operatorList.size()){

                        if(operatorList.get(contOperator).equals("and") || operatorList.get(contOperator).equals("or")) {

                            if(validatorDuplicateOperator.equals(true)){
                                throw new IllegalArgumentException("And or Or duplicate!");
                            }

                            response = response + " ";
                            response = response + operatorList.get(contOperator);
                            response = response + (" ");
                            contOperator = contOperator + 1;
                            break;
                        }

                        if(operatorList.get(contOperator) == "(" || operatorList.get(contOperator) == ")"){

                            response = response + operatorList.get(contOperator);
                            contOperator = contOperator + 1;
                            break;
                        }

                        else{

                            response = response + (" ");
                            response = response + operatorList.get(contOperator);
                            response = response + (" ");
                            contOperator = contOperator + 1;

                            response = response + comparatorsList.get(contComparator);
                            response = response + (" ");
                            contComparator = contComparator + 1;
                        }
                    }
            }
        }
        else{
            return response;
        }
        return response;
    }
}
