package com.example.spring.demo;

import com.example.spring.demo.model.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TrimString {
    private static final Logger log = LogManager.getLogger(TrimString.class);

    //static int count=0;
    // removes adjacent similar characters
    public static String removeAdjacentSimilarChar(String inputStr, char emptyChar, int count)
    {

        count++;
        // if string is empty or contain only single char
        if (inputStr == null || inputStr.length() <= 1)
        {
            return inputStr;
        }

        int i = 0;
        while (i < inputStr.length())
        {
            //check 2 char if they are same
            if (i < inputStr.length()-1 && inputStr.charAt(i) == inputStr.charAt(i + 1))
            {

                int j = i;
                //check if it is a pair of 2 or 3 or more
                while (j + 1 < inputStr.length() && inputStr.charAt(j) == inputStr.charAt(j + 1))
                {
                    j++;
                }
                //replace with empty char
                char prvsChar;
                if (i > 0){
                    prvsChar = inputStr.charAt(i - 1);
                } else {
                    prvsChar = emptyChar;
                }

                //remove initial chars which has been scanned and do recursive call
                String remStr = removeAdjacentSimilarChar(inputStr.substring(j + 1), prvsChar, count);
                inputStr = inputStr.substring(0, i);

                // check and remove if any pair is formed again after removing pairs of adjacent charcter
                while (remStr.length() > 0 && inputStr.length() > 0 && remStr.charAt(0) == inputStr.charAt(inputStr.length() - 1))
                {
                    // check  and compare with parent Strings last character
                    while (remStr.length() > 0 && remStr.charAt(0) != emptyChar && remStr.charAt(0) == inputStr.charAt(inputStr.length() - 1))
                    {
                        remStr = remStr.substring(1);
                    }
                    inputStr = inputStr.substring(0, inputStr.length() - 1);
                }
                inputStr = inputStr + remStr;
                i = j;
            }
            else
            {
                i++;
            }
        }

        return inputStr+"-"+count;
    }

    public Output processData(String str){
        String res = TrimString.removeAdjacentSimilarChar(str.replace(" ",""), ' ', 0);
        String finalop = res.split("-")[0];
        String count = res.split("-")[1];

        Output output = new Output();
        output.setCount(Integer.parseInt(count));
        output.setName("AbdulQadir");
        output.setOutput(finalop);
        output.setPublishedOn(new Date());
        return output;
    }
}