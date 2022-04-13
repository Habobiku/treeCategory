package com.company.DataBase;

import com.company.Category;

import java.sql.SQLException;
import java.util.stream.IntStream;

import static com.company.DataBase.treeDB.getData;

public class dbConvert
{
    public static Category convertTree() throws Exception
    {
        Category root=new Category("root",1);
        var result = getData("1");
        String[] array;

        while (result.next())
        {
            array=result.getString("path").split("\\.");

            String[] finalArray = array;
            int length=array.length;
            if(length!=1)
                IntStream.range(0, array.length).forEach(idx->
                {
                    if(idx==length-2)
                    {
                        try
                        {
                            root.addCategory(result.getString("name"),Integer.parseInt(finalArray[idx]));
                        } catch (SQLException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    String value= finalArray[idx];
                });
        }
        return root;

    }
}
