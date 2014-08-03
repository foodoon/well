package com.foodoon.well.gen;

/**
 * Created by foodoon on 2014/7/29.
 */
public class DaoGen {

    private static String jdbcPath = "e:\\repo\\mysql\\mysql-connector-java\\5.1.9\\mysql-connector-java-5.1.9.jar";

    private static String jdbUrl = "jdbc:mysql://127.0.0.1:3306/well?useUnicode=true&characterEncoding=utf8";

    public static void main(String[] args){
        com.foodoon.gooda.gen.DemoGen demoGen = new com.foodoon.gooda.gen.DemoGen();
        demoGen.setJdbcPassword("");
        demoGen.setJdbcUsername("root");
        demoGen.setJdbcPath(jdbcPath);
        demoGen.setJdbUrl(jdbUrl);

        String appName = "well";
        String parentPackageName = "com.foodoon";
        String tableName = "well_team";
        demoGen.genDAO(tableName,appName,parentPackageName);


    }
}
