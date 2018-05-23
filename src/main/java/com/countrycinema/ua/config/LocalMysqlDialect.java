package com.countrycinema.ua.config;

import org.hibernate.dialect.MySQLDialect;

public class LocalMysqlDialect extends MySQLDialect {
    @Override
    public String getTableTypeString() {
        return " DEFAULT CHARSET=utf8";
    }
}
