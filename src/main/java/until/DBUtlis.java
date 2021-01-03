package until;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.*;


public class DBUtlis {
    public static boolean save(String sql,Object...args)  {
        Connection connection = null;
        PreparedStatement  ps = null;
        Integer count = null;
        try{
            connection = DBUtlis.getConnection();
            ps =  connection.prepareStatement(sql);
            if(args!=null && args.length>0) {
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1, args[i]);
                }
            }
            count = ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            close(connection, ps, null);
        }
        return count!=null&&count>0?true:false;
    }


    public static Integer getcount(String sql,Object...args)  {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        Integer count = null;
        try{
            connection = DBUtlis.getConnection();
            ps =  connection.prepareStatement(sql);
            if(args!=null && args.length>0) {
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1, args[i]);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            while(rs.next()) {
                count=rs.getInt(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            close(connection, ps, rs);
        }
        return count;
    }
    public static void close(Connection connection, Statement ps, ResultSet rs) {
        if(rs!=null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try{
                ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Boolean update(String sql, Object...args){

        Connection conn=null;
        PreparedStatement ps=null;
        Integer count=0;

        try{
            conn= DBUtlis.getConnection();
            ps = conn.prepareStatement(sql);

            if(args!=null&&args.length>0) {
                for (int i = 0; i < args.length; i++) {

                    //判断当前日期类型，是不是java.util.Date,转换成java.sql.Date
                    if (args[i] instanceof  java.util.Date){
                        java.util.Date date=(java.util.Date)args[i];
                        //转换成java.sql.Date
                        args[i]=new java.sql.Date(date.getTime());
                    }
                    ps.setObject(i + 1, args[i]);

                }
            }
            count = ps.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, null);
        }
        return count>0?true:false;
    }

    public static <T> T getSingleObj(Class<T> clazz, String sql, Object...args){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        T bean=null;
        try{
            conn= DBUtlis.getConnection();
            ps = conn.prepareStatement(sql);

            if(args!=null&&args.length>0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);

                }
            }
            rs = ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colsnum = rsmd.getColumnCount();

            while (rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowmap存放了一条记录
                Map<String,Object> rowMap=new HashMap<String,Object>();
                for(int i=1;i<=colsnum;i++){
                    String columnName=rsmd.getColumnLabel(i);
                    Object columnValue=rs.getObject(columnName);
                    //判断查询出来的类的类型，如果是java.sql.Date转成java.util.Date
                    if (columnValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columnValue;
                        columnValue=new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName,columnValue);
                }
                //创建一个User对象，给这个USer对象属性赋值；
                bean=clazz.newInstance();
                for (Map.Entry<String,Object> entry:rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue=entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return bean;
    }

    public static <T> List<T> getList(Class<T> clazz, String sql, Object...args){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> userList=null;

        try{
            conn= DBUtlis.getConnection();
            ps = conn.prepareStatement(sql);

            if(args!=null&&args.length>0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);

                }
            }
            rs = ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colsnum = rsmd.getColumnCount();

            userList = new ArrayList<>();

            while (rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowmap存放了一条记录
                Map<String,Object> rowMap=new HashMap<String,Object>();
                for(int i=1;i<=colsnum;i++){
                    String columnName=rsmd.getColumnLabel(i);
                    Object columnValue=rs.getObject(columnName);
                    //判断查询出来的类的类型，如果是java.sql.Date转成java.util.Date
                    if (columnValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columnValue;
                        columnValue=new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName,columnValue);
                }
                //创建一个User对象，给这个USer对象属性赋值；
                T bean=clazz.newInstance();

                //根据列名，id==给User对象属性赋值的方法名，setId，“set"+Id=setId,调用setId方法给user对象赋值，map中的value

                //循环rowMap给user所有属性赋值 entry {key,value}[{"id":1},{username:"king"},{"birthday":"2020-0606"}]
                for (Map.Entry<String,Object> entry:rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue=entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                }
                userList.add(bean);

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }

        return userList;
    }

    public static Connection getConnection() throws Exception {
        InputStream in =  Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(in);
        DataSource dataSource =  DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

}
