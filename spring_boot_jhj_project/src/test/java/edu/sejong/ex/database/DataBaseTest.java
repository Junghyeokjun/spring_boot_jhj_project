package edu.sejong.ex.database;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DataBaseTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	void testDataSource() {
		assertNotNull(dataSource);
		log.info("DS="+dataSource);
	}

	@Test
	void testConnection() {
		try(Connection connection=dataSource.getConnection()) {
			assertThat(connection).isInstanceOf(Connection.class);
			assertEquals(100,getLong(connection,"select 100 from dual"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public long getLong(Connection connection, String sql) {
		long result=0;
		try (Statement stmt=connection.createStatement()){
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				result=rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
