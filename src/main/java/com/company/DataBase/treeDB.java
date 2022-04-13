package com.company.DataBase;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import static com.company.config.Config.*;

public class treeDB
{
    private static ConnectDB connectDB=new ConnectDB(url,user,password);

    public static ResultSet getData(String id) throws Exception
    {
        Connection connection = connectDB.connect();
        String sql = "select * from tree where ? @>path order by id asc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1,id,Types.OTHER );
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
}
