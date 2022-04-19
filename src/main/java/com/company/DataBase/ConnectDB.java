package com.company.DataBase;

import com.company.config.Config;
import java.io.IOException;

import java.sql.*;

import static com.company.config.Yml.readConfig;

public class ConnectDB
{


    public static Connection connect() throws SQLException, IOException
    {
        Config config=readConfig();
        return DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
    }


}
