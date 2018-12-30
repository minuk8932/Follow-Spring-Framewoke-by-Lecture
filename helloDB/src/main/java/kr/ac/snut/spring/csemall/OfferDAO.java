package kr.ac.snut.spring.csemall;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OfferDAO {
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "SELECT COUNT(*) from offers";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}
}
