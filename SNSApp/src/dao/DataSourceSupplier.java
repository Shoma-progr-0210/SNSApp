package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.DBAccessException;
import util.ErrorCodeConstValue;

/**
 * DataSource提供クラス
 *
 * @author shoma
 *
 */
public class DataSourceSupplier {

    private static DataSource ds = null;

    public static DataSource getDataSource() throws DBAccessException{
        try {
            //  初回の呼び出しのみ、データソースをインスタンス化
            if (ds == null) {
                ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/MySQL");

            }
        } catch (NamingException e) {
            throw new DBAccessException(ErrorCodeConstValue.DB_ERR);
        }
        //データソースを返却
        return ds;
    }

}
