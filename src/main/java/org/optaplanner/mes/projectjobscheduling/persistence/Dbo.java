/**
 * 
 */
package org.optaplanner.mes.projectjobscheduling.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tbista
 *
 */
public class Dbo {
	protected final transient Logger logger = LoggerFactory.getLogger(getClass());
	private Connection conn = null;
	private String url = null;
	private String user = null;
	private String password = null;

	public Dbo(final String url, final String user, final String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Dbo() {
	}

	public boolean isOracle() {
		return (url == null && user == null && password == null) ? true : false;
	}

	public Connection getConnection(String sender) {

		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e) {
			logger.error(e.toString());
		}

		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			if (isOracle()) {
				conn = DriverManager.getConnection("jdbc:default:connection:");
				logger.info("Creating connection for oracle by " + sender);
			} else {
				conn = DriverManager.getConnection(url, user, password);
				logger.info("Creating connection for eclipse by " + sender);

			}
			return conn;

		} catch (SQLException e) {
			logger.error(e.toString());
		}
		return null;
	}

	public void closeConnection(String sender) {
		try {
			if (conn != null && !conn.isClosed()) {
				if (isOracle()) {
					logger.info("Closing connection for oracle by " + sender);
				} else {
					logger.info("Closing connection for eclipse by " + sender);
				}
				conn.close();
			}
		} catch (SQLException e) {
			logger.error(e.toString());
		}
	}
}
