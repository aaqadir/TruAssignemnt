package com.example.spring.demo;

import com.example.spring.demo.model.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TrimString {
    private static final Logger log = LogManager.getLogger(TrimString.class);


    // Recursively removes adjacent
    // duplicates from str and
    // returns new string. las_removed
    // is a pointer to
    // last_removed character
    public static String removeDuplicates(String s, char ch)
    {

        // If length of string is 1 or 0
        if (s == null || s.length() <= 1)
        {
            return s;
        }

        int i = 0;
        while (i < s.length())
        {
            if (i < s.length()-1 && s.charAt(i) == s.charAt(i + 1))
            {
                int j = i;
                while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1))
                {
                    j++;
                }
                char lastChar = i > 0 ? s.charAt(i - 1) : ch;

                String remStr = removeDuplicates(s.substring(j + 1, s.length()), lastChar);

                s = s.substring(0, i);
                int k = s.length(), l = 0;

                // Recursively remove all the adjacent
                // characters formed by removing the
                // adjacent characters
                while (remStr.length() > 0 && s.length() > 0 && remStr.charAt(0) == s.charAt(s.length() - 1))
                {

                    // Have to check whether this is the
                    // repeated character that matches the
                    // last char of the parent String
                    while (remStr.length() > 0 && remStr.charAt(0) != ch && remStr.charAt(0) == s.charAt(s.length() - 1))
                    {
                        remStr = remStr.substring(1, remStr.length());
                    }
                    s = s.substring(0, s.length() - 1);
                }
                s = s + remStr;
                i = j;
            }
            else
            {
                i++;
            }
        }
        return s+"-"+i;
    }

    public Output processData(String str){
        String res = TrimString.removeDuplicates(str.replace(" ",""), ' ');
        String finalop = res.split("-")[0];
        String count = res.split("-")[1];

        log.info("finalop: " + finalop);
        log.info("count: " + count);

        Output output = new Output();

        output.setCount(Integer.parseInt(count));
        output.setName("AbdulQadir");
        output.setOutput(finalop);
        output.setPublishedOn(new Date());
        return output;
    }
}